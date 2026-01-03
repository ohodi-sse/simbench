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
        assert distance_df.collect_schema() == data.DistanceTable.schema(), (
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


def get_performance_row(class_df: pl.LazyFrame):
    src_labels = pl.Series(class_df.select("src_label").collect()).to_list()
    labelled_as = pl.Series(class_df.select("labelled_as").collect()).to_list()

    cm = confusion_matrix(src_labels, labelled_as)
    FP = sum(cm.sum(axis=0) - np.diag(cm))
    FN = sum(cm.sum(axis=1) - np.diag(cm))

    averaging = "macro"

    accuracy = accuracy_score(src_labels, labelled_as)
    precision, recall, f_score, _ = precision_recall_fscore_support(
        src_labels, labelled_as, average=averaging, zero_division=0.0
    )

    return FP, FN, accuracy, precision, recall, f_score


def get_performance(class_df: pl.LazyFrame) -> pl.LazyFrame:
    classifier = pl.Series(
        class_df.select("classifier", "class_param").unique().collect()
    ).to_list()

    data_dict = {k: [] for k in data.PerformanceTable.schema()}

    for cl in classifier:
        logger.debug(
            f"Calculating performance of classifications using: {cl['classifier']}-{cl['class_param']}"
        )
        expr = (pl.col("classifier") == cl["classifier"]) & (
            pl.col("class_param") == cl["class_param"]
        )
        pr_class_df = class_df.filter(expr)

        FP, FN, accuracy, precision, recall, f_score = get_performance_row(pr_class_df)

        data_dict["classifier"].append(cl["classifier"])
        data_dict["class_param"].append(cl["class_param"])
        data_dict["FP"].append(FP)
        data_dict["FN"].append(FN)
        data_dict["Acc"].append(accuracy)
        data_dict["Prec"].append(precision)
        data_dict["Rec"].append(recall)
        data_dict["F1"].append(f_score)

    perf_df = data.PerformanceTable.lazyframe(data_dict).sort(
        by=["classifier", "class_param"], descending=[False, True]
    )

    return perf_df
