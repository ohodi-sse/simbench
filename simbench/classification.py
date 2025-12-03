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


class Classifier(ABC):
    @classmethod
    @abstractmethod
    def classify(cls, distance_df: pl.LazyFrame, src: str) -> Classification | None: ...

    @property
    @abstractmethod
    def name(self) -> str: ...

    @property
    @abstractmethod
    def param(self) -> str: ...

    def matches(self, match):
        import re

        return re.fullmatch(match, self.name) is not None

    @classmethod
    def classifications(cls, distances: pl.LazyFrame) -> pl.LazyFrame:
        df = data.ClassificationTable.dataframe()

        src_df = distances.select("src", "src_label").unique(maintain_order=True)
        src_names = pl.Series(src_df.select("src").collect()).to_list()
        classifications = [
            c.labelled_as
            for c in [cls.classify(distances, src) for src in src_names]
            if c is not None
        ]

        df["src"] = src_names
        df["src_label"] = pl.Series(src_df.select("src_label").collect()).to_list()
        df["classifier"] = [cls.name for _ in range(len(src_names))]
        df["class_param"] = [cls.param for _ in range(len(src_names))]
        df["labelled_as"] = classifications

        return df.lazy()

    @classmethod
    def compute_performance_data(
        cls,
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

    @classmethod
    def performance(cls, class_df: pl.LazyFrame) -> pl.LazyFrame:
        metric = pl.Series(class_df.select("metric").unique().collect()).item()
        comp = pl.Series(class_df.select("comp").unique().collect()).item()
        complvl = pl.Series(class_df.select("comp_lvl").unique().collect()).item()

        classifier = pl.Series(class_df.select("classifier").unique().collect()).item()
        class_param = pl.Series(
            class_df.select("class_param").unique().collect()
        ).item()
        src_labels = pl.Series(class_df.select("src_label").collect()).to_list()
        labelled_as = pl.Series(class_df.select("labelled_as").collect()).to_list()

        cm = confusion_matrix(src_labels, labelled_as)
        FP = sum(cm.sum(axis=0) - np.diag(cm))
        FN = sum(cm.sum(axis=1) - np.diag(cm))

        accuracy, precision, recall, f_score = cls.compute_performance_data(class_df)

        overview = {
            "metric": [metric],
            "comp": [comp],
            "comp_lvl": [complvl],
            "classifier": [classifier],
            "class_param": [class_param],
            "FP": [FP],
            "FN": [FN],
            "Acc": [accuracy],
            "Prec": [precision],
            "Rec": [recall],
            "F1": [f_score],
        }

        return data.PerformanceTable.lazyframe(overview)


@dataclass(frozen=True)
class BestMatch(Classifier):
    @classmethod
    def classify(cls, distance_df: pl.LazyFrame, src: str) -> Classification | None:
        assert distance_df.collect_schema() == data.DistanceTable.schema, (
            "Must use a distance dataframe for classification"
        )

        filter_expr = (pl.col("src") == src) & (pl.col("tgt") != src)
        src_sim = distance_df.filter(filter_expr).select(["tgt_label", "tgt"])
        best = src_sim.head(1).collect()
        label = best["tgt_label"][0]
        best_match_name = best["tgt"][0]

        return Classification(src, label, [best_match_name])

    @property
    def name(self) -> str:
        return "bm"

    @property
    def param(self) -> str:
        return "none"


@dataclass(frozen=True)
class KNN(Classifier):
    k: int

    @classmethod
    def classify(cls, distance_df: pl.LazyFrame, src: str) -> Classification:
        assert cls.k > 0, "k must be positive"
        assert distance_df.collect_schema() == data.DistanceTable.schema, (
            "Must use a distance dataframe for classification"
        )

        filter_expr = (pl.col("src") == src) & (pl.col("tgt") != src)
        src_sim = distance_df.filter(filter_expr).select(
            ["tgt_label", "tgt", "distance"]
        )
        k_best = src_sim.head(cls.k)
        counts = (
            k_best.group_by("tgt_label")
            .agg(pl.len(), pl.col("distance").mean())
            .sort(by=["len", "distance"], descending=[True, False])
        )  # The sorting here takes care of the tie-breaking
        # This means src is labelled as the closest label based on mean distance when given a tie

        label = counts.select(pl.col("tgt_label")).collect()["tgt_label"][0]

        # logger.debug(counts.collect())
        # logger.debug(label)

        k_best_names = pl.Series(k_best.select("tgt").collect()).to_list()
        return Classification(src, label, k_best_names)

    @property
    def name(self) -> str:
        return "knn"

    @property
    def param(self) -> str:
        return str(self.k)

    def __post_init__(self):
        assert isinstance(self.k, int)


@dataclass(frozen=True)
class Threshold(Classifier):
    threshold: float

    @classmethod
    def classify(cls, distance_df: pl.LazyFrame, src: str) -> Classification | None:
        assert 0.0 <= cls.threshold and cls.threshold <= 1.0, (
            "Threshold must be between 0 and 1"
        )
        assert distance_df.collect_schema() == data.DistanceTable.schema, (
            "Must use a distance dataframe for classification"
        )

        filter_expr = (
            (pl.col("src") == src)
            & (pl.col("tgt") != src)
            & (pl.col("distance") < cls.threshold)
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

    @property
    def name(self) -> str:
        return "thrsh"

    @property
    def param(self) -> str:
        return str(self.threshold)

    def __post_init__(self):
        assert isinstance(self.threshold, float)
