import simbench.data as data
from abc import abstractmethod
from dataclasses import dataclass
import numpy as np
from sklearn.metrics import (
    precision_recall_fscore_support,
    accuracy_score,
    confusion_matrix,
)
from loguru import logger
import polars as pl

from abc import ABC


class Classification:
    name: str
    labelled_as: str
    similar_files: list[tuple[str, int]]

    def __init__(self, name, label, similar_files):
        self.name = name
        self.labelled_as = label
        self.similar_files = similar_files


@dataclass
class Classifier(ABC):
    @abstractmethod
    def classify(
        self, distance_df: pl.LazyFrame, src: str
    ) -> Classification | None: ...

    @property
    @abstractmethod
    def name(self) -> str: ...

    @property
    @abstractmethod
    def param(self) -> float: ...

    def matches(self, match):
        import re

        return re.fullmatch(match, self.name) is not None

    def classifications(self, distances: pl.LazyFrame) -> pl.LazyFrame:
        src_df = distances.select("src", "src_label").unique(maintain_order=True)
        src_names = pl.Series(src_df.select("src").collect()).to_list()

        logger.debug(f"Classifying using {self.name}-{self.param}")

        pb = data.get_progressbar(len(src_names))
        classifications = []
        for src in src_names:
            pb.inc(1)
            c = self.classify(distances, src)
            if c is not None:
                classifications.append(c.labelled_as)

        pb.finish()

        class_data = {
            "src": src_names,
            "src_label": pl.Series(src_df.select("src_label").collect()).to_list(),
            "classifier": [self.name for _ in range(len(src_names))],
            "class_param": [self.param for _ in range(len(src_names))],
            "labelled_as": classifications,
        }

        df = data.ClassificationTable.lazyframe(class_data)

        return df.lazy()


@dataclass
class KNN(Classifier):
    k: int

    @property
    def name(self) -> str:
        return "knn"

    @property
    def param(self) -> int:
        return self.k

    def classify(self, distance_df: pl.LazyFrame, src: str) -> Classification:
        assert self.k > 0, "k must be positive"
        assert distance_df.collect_schema() == data.DistanceTable.schema(), (
            "Must use a distance dataframe for classification"
        )

        filter_expr = (pl.col("src") == src) & (pl.col("tgt") != src)
        src_sim = distance_df.filter(filter_expr).select(
            ["tgt_label", "tgt", "distance"]
        )
        k_best = src_sim.head(self.k)
        counts = (
            k_best.group_by("tgt_label")
            .agg(pl.len(), pl.col("distance").mean())
            .sort(by=["len", "distance"], descending=[True, False])
        )  # The sorting here takes care of the tie-breaking
        # This means src is labelled as the closest label based on mean distance when given a tie

        label = counts.select("tgt_label").collect()["tgt_label"][0]

        # logger.debug(counts.collect())
        # logger.debug(label)

        k_best_names = pl.Series(k_best.select("tgt").collect()).to_list()
        return Classification(src, label, k_best_names)

    def __post_init__(self):
        assert isinstance(self.k, int)


@dataclass
class Threshold(Classifier):
    threshold: float

    @property
    def name(self) -> str:
        return "thrsh"

    @property
    def param(self) -> float:
        return self.threshold

    def classify(self, distance_df: pl.LazyFrame, src: str) -> Classification | None:
        assert 0.0 <= self.threshold and self.threshold <= 1.0, (
            "Threshold must be between 0 and 1"
        )
        assert distance_df.collect_schema() == data.DistanceTable.schema, (
            "Must use a distance dataframe for classification"
        )

        filter_expr = (
            (pl.col("src") == src)
            & (pl.col("tgt") != src)
            & (pl.col("distance") < self.threshold)
        )
        in_radius = distance_df.filter(filter_expr).select(
            ["tgt_label", "tgt", "distance"]
        )

        best_names = pl.Series(in_radius.select("tgt").collect()).to_list()

        if not best_names:
            return None

        counts = in_radius.group_by("tgt_label").agg(pl.len())

        label = (
            counts.sort(by="len", descending=True)
            .select(pl.col("tgt_label"))
            .collect()["tgt_label"][0]
        )

        return Classification(src, label, best_names)

    def __post_init__(self):
        assert isinstance(self.threshold, float)


def compute_performance_data(
    class_df: pl.LazyFrame,
) -> tuple[float, float, float, float]:
    src_labels = pl.Series(class_df.select("src_label").collect()).to_list()
    labelled_as = pl.Series(class_df.select("labelled_as").collect()).to_list()

    averaging = "macro"

    accuracy = accuracy_score(src_labels, labelled_as)
    precision, recall, f_score, _ = precision_recall_fscore_support(
        src_labels, labelled_as, average=averaging, zero_division=0.0
    )

    return accuracy, precision, recall, f_score


def get_performance(class_df: pl.LazyFrame) -> pl.LazyFrame:
    # metric = pl.Series(class_df.select("metric").unique().collect()).item()
    # comp = pl.Series(class_df.select("comp").unique().collect()).item()
    # complvl = pl.Series(class_df.select("comp_lvl").unique().collect()).item()

    classifier = pl.Series(
        class_df.select("classifier", "class_param").unique().collect()
    ).to_list()

    class_ls = []
    param_ls = []
    fp_ls = []
    fn_ls = []
    acc_ls = []
    prec_ls = []
    rec_ls = []
    f1_ls = []

    for cl in classifier:
        logger.debug(
            f"Calculating performance of classifications using: {cl['classifier']}-{cl['class_param']}"
        )
        expr = (pl.col("classifier") == cl["classifier"]) & (
            pl.col("class_param") == cl["class_param"]
        )
        pr_class_df = class_df.filter(expr)

        src_labels = pl.Series(pr_class_df.select("src_label").collect()).to_list()
        labelled_as = pl.Series(pr_class_df.select("labelled_as").collect()).to_list()

        cm = confusion_matrix(src_labels, labelled_as)
        FP = sum(cm.sum(axis=0) - np.diag(cm))
        FN = sum(cm.sum(axis=1) - np.diag(cm))

        accuracy, precision, recall, f_score = compute_performance_data(pr_class_df)
        class_ls.append(cl["classifier"])
        param_ls.append(cl["class_param"])
        fp_ls.append(FP)
        fn_ls.append(FN)
        acc_ls.append(accuracy)
        prec_ls.append(precision)
        rec_ls.append(recall)
        f1_ls.append(f_score)

    overview = {
        "classifier": class_ls,
        "class_param": param_ls,
        "FP": fp_ls,
        "FN": fn_ls,
        "Acc": acc_ls,
        "Prec": prec_ls,
        "Rec": rec_ls,
        "F1": f1_ls,
    }

    perf_df = data.PerformanceTable.lazyframe(overview).sort(
        by=["classifier", "class_param"], descending=[False, True]
    )

    return perf_df
