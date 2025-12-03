import simbench.data as data
from collections import Counter
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


class Classification:
    name: str
    labelled_as: str
    similar_files: list[tuple[str, int]]

    def __init__(self, name, label, similar_files):
        self.name = name
        self.labelled_as = label
        self.similar_files = similar_files


class Classifier:
    @abstractmethod
    def __call__(self, similarity_df: pl.LazyFrame, src: str) -> Classification | None:
        pass

    @abstractmethod
    def name(self) -> str:
        pass

    @abstractmethod
    def param(self) -> str:
        pass


@dataclass(frozen=True)
class BestMatch(Classifier):
    def __call__(self, distances: pl.LazyFrame, src: str) -> Classification:
        assert distances.collect_schema() == data.DistanceTable.schema, (
            "Must use a distance dataframe for classification"
        )

        filter_expr = (pl.col("src") == src) & (pl.col("tgt") != src)
        src_sim = distances.filter(filter_expr).select(["tgt_label", "tgt"])
        best = src_sim.head(1).collect()
        label = best["tgt_label"][0]
        best_match_name = best["tgt"][0]

        return Classification(src, label, [best_match_name])

    def name(self) -> str:
        return "bm"

    def param(self) -> str:
        return "none"


def sort_pr_src(distances: pl.LazyFrame) -> pl.LazyFrame:
    return distances.sort("src", "distance", descending=[False, False])


@dataclass(frozen=True)
class KNN(Classifier):
    k: int

    def __call__(self, distances: pl.LazyFrame, src: str) -> Classification:
        assert self.k > 0, "k must be positive"
        assert distances.collect_schema() == data.DistanceTable.schema, (
            "Must use a distance dataframe for classification"
        )

        filter_expr = (pl.col("src") == src) & (pl.col("tgt") != src)
        src_sim = distances.filter(filter_expr).select(["tgt_label", "tgt", "distance"])
        k_best = src_sim.head(self.k)
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

    def name(self) -> str:
        return "knn"

    def param(self) -> str:
        return str(self.k)

    def __post_init__(self):
        assert isinstance(self.k, int)


@dataclass(frozen=True)
class Threshold(Classifier):
    threshold: float

    def __call__(self, distances: pl.LazyFrame, src: str) -> Classification | None:
        assert 0.0 <= self.threshold and self.threshold <= 1.0, (
            "Threshold must be between 0 and 1"
        )
        assert distances.collect_schema() == data.DistanceTable.schema, (
            "Must use a distance dataframe for classification"
        )

        filter_expr = (
            (pl.col("src") == src)
            & (pl.col("tgt") != src)
            & (pl.col("distance") < self.threshold)
        )
        in_radius = distances.filter(filter_expr).select(
            ["tgt_label", "tgt", "distance"]
        )

        best_names = pl.Series(in_radius.select("tgt").collect()).to_list()

        if not best_names:
            # logger.debug(
            #     f"Did not find any files to compare with threshold: {self.threshold}."
            # )
            return None

        counts = in_radius.group_by("tgt_label").agg(pl.len())

        label = (
            counts.sort(by="len", descending=True)
            .select(pl.col("tgt_label"))
            .collect()["tgt_label"][0]
        )

        return Classification(src, label, best_names)

    def name(self) -> str:
        return "thrsh"

    def param(self) -> str:
        return str(self.threshold)

    def __post_init__(self):
        assert isinstance(self.threshold, float)


def get_classifier(classifier_name: str) -> Classifier | None:
    assert isinstance(classifier_name, str), "get_classifier takes a string as input"
    classf_opts = classifier_name.split("_")

    opt = None
    if len(classf_opts) > 1:
        opt = classf_opts[1]

    match classf_opts[0]:
        case "bm":
            return BestMatch()
        case "knn":
            assert opt, (
                "Must provide the knn option as knn_? where ? is the number of nearest neighbours"
            )
            try:
                return KNN(int(opt))
            except ValueError:
                logger.warning(
                    "KNN classifiers should be given a k value. Pass knn_? where ? is an int"
                )
        case "thr":
            assert opt, (
                "Must provide the knn option as knn_? where ? is the number of nearest neighbours"
            )
            try:
                return Threshold(float(opt))
            except ValueError:
                logger.warning(
                    "Threshold classifiers should be given a threshold value. Pass knn_? where ? is an int"
                )
        case e:
            logger.warning(f"Don't know how to handle classifier name: {e}")


def create_classification_dataframe(
    distances: pl.LazyFrame, classifier: Classifier
) -> pl.LazyFrame:
    df = data.ClassificationTable.dataframe()

    src_df = distances.select("src", "src_label", "metric", "comp", "comp_lvl").unique(
        maintain_order=True
    )
    src_names = pl.Series(src_df.select("src").collect()).to_list()
    classifications = [
        c.labelled_as for c in [classifier(distances, src) for src in src_names] if c
    ]

    df["src"] = src_names
    df["src_label"] = pl.Series(src_df.select("src_label").collect()).to_list()
    df["metric"] = pl.Series(src_df.select("metric").collect()).to_list()
    df["comp"] = pl.Series(src_df.select("comp").collect()).to_list()
    df["comp_lvl"] = pl.Series(src_df.select("comp_lvl").collect()).to_list()
    df["classifier"] = [classifier.name() for _ in range(len(src_names))]
    df["class_param"] = [classifier.param() for _ in range(len(src_names))]
    df["labelled_as"] = classifications

    return df.lazy()


def create_classification_dataframe_new(
    distances: pl.LazyFrame, classifier: Classifier
) -> pl.LazyFrame:
    df = data.ClassificationTable.dataframe()

    src_df = distances.select("src", "src_label", "metric", "comp", "comp_lvl").unique(
        maintain_order=True
    )
    src_names = pl.Series(src_df.select("src").collect()).to_list()

    classified = [(src, classifier(distances, src)) for src in src_names]

    classifiable = [s for (s, c) in classified if c]

    if classifiable:
        classifications = [c.labelled_as for (_, c) in classified if c]
        src_df = src_df.collect().with_columns(
            pl.when(pl.col("src").is_in(classifiable))
            .then(True)
            .otherwise(False)
            .alias("classifiable")
        )

        classifiable_df = src_df.filter(pl.col("classifiable"))
        df["src"] = classifiable
        df["src_label"] = pl.Series(classifiable_df.select("src_label")).to_list()
        df["metric"] = pl.Series(classifiable_df.select("metric")).to_list()
        df["comp"] = pl.Series(classifiable_df.select("comp")).to_list()
        df["comp_lvl"] = pl.Series(classifiable_df.select("comp_lvl")).to_list()
        df["classifier"] = [classifier.name() for _ in range(len(classifiable))]
        df["class_param"] = [classifier.param() for _ in range(len(classifiable))]
        df["labelled_as"] = classifications

    return df.lazy()


def check_classification(class_df: pl.LazyFrame, src: str) -> bool:
    filter_expr = pl.col("src") == src
    classification = (
        class_df.filter(filter_expr).select("src_label", "labelled_as").collect()
    )

    return classification.item(row=0, column=0) == classification.item(row=0, column=1)


def get_performance_data(class_df: pl.LazyFrame) -> tuple[float, float, float, float]:
    src_labels = pl.Series(class_df.select("src_label").collect()).to_list()
    labelled_as = pl.Series(class_df.select("labelled_as").collect()).to_list()

    averaging = "macro"

    accuracy = accuracy_score(src_labels, labelled_as)
    precision, recall, f_score, _ = precision_recall_fscore_support(
        src_labels, labelled_as, average=averaging, zero_division=0.0
    )

    return accuracy, precision, recall, f_score


def get_performance_scikit(class_df: pl.LazyFrame) -> pl.LazyFrame:
    metric = pl.Series(class_df.select("metric").unique().collect()).item()
    comp = pl.Series(class_df.select("comp").unique().collect()).item()
    complvl = pl.Series(class_df.select("comp_lvl").unique().collect()).item()

    classifier = pl.Series(class_df.select("classifier").unique().collect()).item()
    class_param = pl.Series(class_df.select("class_param").unique().collect()).item()
    src_labels = pl.Series(class_df.select("src_label").collect()).to_list()
    labelled_as = pl.Series(class_df.select("labelled_as").collect()).to_list()

    cm = confusion_matrix(src_labels, labelled_as)
    FP = sum(cm.sum(axis=0) - np.diag(cm))
    FN = sum(cm.sum(axis=1) - np.diag(cm))

    accuracy, precision, recall, f_score = get_performance_data(class_df)

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
