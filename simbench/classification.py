from .data import (
    get_label,
    CLASSIFICATIONS_SCHEMA,
    PERFORMANCE_SCHEMA,
    CONFUSION_SCHEMA,
    DISTANCE_SCHEMA,
)
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


@dataclass(frozen=True)
class BestMatch(Classifier):
    def __call__(self, distances: pl.LazyFrame, src: str) -> Classification:
        assert distances.collect_schema() == DISTANCE_SCHEMA, (
            "Must use a distance dataframe for classification"
        )

        filter_expr = (pl.col("src") == src) & (pl.col("tgt") != src)
        src_sim = distances.filter(filter_expr).select(["tgt_label", "tgt"])
        best = src_sim.head(1).collect()
        label = best["tgt_label"][0]
        best_match_name = best["tgt"][0]

        return Classification(src, label, [best_match_name])

    def name(self) -> str:
        return "BestMatch"


def sort_pr_src(distances: pl.LazyFrame) -> pl.LazyFrame:
    return distances.sort("src", "distance", descending=[False, False])


@dataclass(frozen=True)
class KNN(Classifier):
    k: int

    def __call__(self, distances: pl.LazyFrame, src: str) -> Classification:
        assert self.k > 0, "k must be positive"
        assert distances.collect_schema() == DISTANCE_SCHEMA, (
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
        return f"knn_{self.k}"

    def __post_init__(self):
        assert isinstance(self.k, int)


@dataclass(frozen=True)
class Threshold(Classifier):
    threshold: float

    def __call__(self, distances: pl.LazyFrame, src: str) -> Classification | None:
        assert 0.0 <= self.threshold and self.threshold <= 1.0, (
            "Threshold must be between 0 and 1"
        )
        assert distances.collect_schema() == DISTANCE_SCHEMA, (
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
        return f"thrsh_{self.threshold}"

    def __post_init__(self):
        assert isinstance(self.threshold, float)


@dataclass(frozen=True)
class KThreshold(Classifier):
    threshold: float

    def __call__(self, distances: pl.LazyFrame, src: str) -> Classification | None:
        assert 0.0 <= self.threshold and self.threshold <= 1.0, (
            "Threshold must be between 0 and 1"
        )
        assert distances.collect_schema() == DISTANCE_SCHEMA, (
            "Must provide a distance dataframe to KNN plotting"
        )
        sorted_sim = sort_pr_src(distances)

        filter_expr = (pl.col("src") == src) & (pl.col("tgt") != src)
        src_sim = sorted_sim.filter(filter_expr).select(["tgt", "distance"])
        in_radius = src_sim.filter(pl.col("distance") > self.threshold)

        best_names = pl.Series(in_radius.select("tgt").collect().head(10)).to_list()

        if not best_names:
            logger.warning(
                f"Did not find any files to compare with threshold: {self.threshold}."
            )
            return None

        labels = [get_label(distances, filename) for filename in best_names]

        label_counts = Counter(labels)
        label = max(label_counts)

        return Classification(src, label, best_names)

    def name(self) -> str:
        return f"thrsh_{self.threshold}"

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
    data = {col: [] for col in CLASSIFICATIONS_SCHEMA}

    src_df = distances.select("src", "src_label", "metric", "comp", "comp_lvl").unique(
        maintain_order=True
    )
    src_names = pl.Series(src_df.select("src").collect()).to_list()
    classifications = [classifier(distances, src).labelled_as for src in src_names]

    data["src"] = src_names
    data["src_label"] = pl.Series(src_df.select("src_label").collect()).to_list()
    data["metric"] = pl.Series(src_df.select("metric").collect()).to_list()
    data["comp"] = pl.Series(src_df.select("comp").collect()).to_list()
    data["comp_lvl"] = pl.Series(src_df.select("comp_lvl").collect()).to_list()
    data["classifier"] = [classifier.name() for _ in range(len(src_names))]
    data["labelled_as"] = classifications

    return pl.LazyFrame(data, schema=CLASSIFICATIONS_SCHEMA)


def create_classification_dataframe_new(
    distances: pl.LazyFrame, classifier: Classifier
) -> pl.LazyFrame:
    data = {col: [] for col in CLASSIFICATIONS_SCHEMA}

    src_df = distances.select("src", "src_label", "metric", "comp", "comp_lvl").unique(
        maintain_order=True
    )
    src_names = pl.Series(src_df.select("src").collect()).to_list()

    classified = [(src, classifier(distances, src)) for src in src_names]

    classifiable = [s for (s, c) in classified if c]

    if classifiable:
        classifications = [c.labelled_as for (_, c) in classified if c]
        # logger.debug(src_df.collect())
        src_df = src_df.collect().with_columns(
            pl.when(pl.col("src").is_in(classifiable))
            .then(True)
            .otherwise(False)
            .alias("classifiable")
        )

        # logger.debug(src_df)
        classifiable_df = src_df.filter(pl.col("classifiable"))
        # logger.debug(classifiable_df)
        data["src"] = classifiable
        data["src_label"] = pl.Series(classifiable_df.select("src_label")).to_list()
        data["metric"] = pl.Series(classifiable_df.select("metric")).to_list()
        data["comp"] = pl.Series(classifiable_df.select("comp")).to_list()
        data["comp_lvl"] = pl.Series(classifiable_df.select("comp_lvl")).to_list()
        data["classifier"] = [classifier.name() for _ in range(len(classifiable))]
        data["labelled_as"] = classifications

        # src_df.join(pl.LazyFrame(data), on="src")
    return pl.LazyFrame(data, schema=CLASSIFICATIONS_SCHEMA)


def check_classification(class_df: pl.LazyFrame, src: str) -> bool:
    filter_expr = pl.col("src") == src
    classification = (
        class_df.filter(filter_expr).select("src_label", "labelled_as").collect()
    )

    return classification.item(row=0, column=0) == classification.item(row=0, column=1)


def get_confusion_matrix(class_df: pl.LazyFrame) -> pl.LazyFrame:
    classes = pl.Series(class_df.select("src_label").unique().collect()).to_list()

    eq_class = class_df.filter(pl.col("src_label") == pl.col("labelled_as"))
    neq_class = class_df.filter(pl.col("src_label") != pl.col("labelled_as"))

    true_pos = [
        eq_class.filter((pl.col("labelled_as") == label)).collect().height
        for label in classes
    ]

    true_neg = [
        eq_class.filter((pl.col("labelled_as") != label)).collect().height
        for label in classes
    ]

    false_neg = [
        neq_class.filter((pl.col("labelled_as") != label)).collect().height
        for label in classes
    ]

    false_pos = [
        neq_class.filter((pl.col("labelled_as") == label)).collect().height
        for label in classes
    ]

    return pl.LazyFrame(
        {
            "class": classes,
            "true_pos": true_pos,
            "true_neg": true_neg,
            "false_pos": false_pos,
            "false_neg": false_neg,
        },
        schema=CONFUSION_SCHEMA,
    )


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
        "FP": [FP],
        "FN": [FN],
        "Acc": [accuracy],
        "Prec": [precision],
        "Rec": [recall],
        "F1": [f_score],
    }

    return pl.LazyFrame(overview, schema=PERFORMANCE_SCHEMA)


def get_performance_overview(class_df: pl.LazyFrame) -> pl.LazyFrame:
    confusion_mat = get_confusion_matrix(class_df)

    summed_cols = confusion_mat.select(
        "true_pos", "true_neg", "false_pos", "false_neg"
    ).sum()

    true_pos = summed_cols.select("true_pos").collect().item()
    true_neg = summed_cols.select("true_neg").collect().item()
    false_pos = summed_cols.select("false_pos").collect().item()
    false_neg = summed_cols.select("false_neg").collect().item()

    total_population = sum(
        [summed_cols.select(c).collect().item() for c in summed_cols.collect().columns]
    )

    # Accuracy
    accuracy = (true_pos + true_neg) / total_population

    # Precision
    precision = true_pos / (true_pos + false_pos)

    # Recall
    recall = true_pos / (true_pos + false_neg)

    # F-Score
    f_score = (
        (2 * precision * recall) / (precision + recall)
        if (precision + recall) > 0
        else 0
    )

    metric = pl.Series(class_df.select("metric").unique().collect()).item()
    comp = pl.Series(class_df.select("comp").unique().collect()).item()
    complvl = pl.Series(class_df.select("comp_lvl").unique().collect()).item()
    classifier = pl.Series(class_df.select("classifier").unique().collect()).item()

    overview = {
        "metric": [metric],
        "comp": [comp],
        "comp_lvl": [complvl],
        "classifier": [classifier],
        "FP": [false_pos],
        "FN": [false_neg],
        "Acc": [accuracy],
        "Prec": [precision],
        "Rec": [recall],
        "F1": [f_score],
    }

    return pl.LazyFrame(overview, schema=PERFORMANCE_SCHEMA)
