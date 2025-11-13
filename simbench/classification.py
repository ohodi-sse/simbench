import polars as pl
from .data import get_label
from collections import Counter
from loguru import logger
from abc import abstractmethod
from typing import Callable


class Classifier(Callable):
    name: str

    @abstractmethod
    def __call__():
        pass


class Classification:
    name: str
    labelled_as: str
    similar_files: [(str, int)]

    def __init__(self, name, label, similar_files):
        self.name = name
        self.labelled_as = label
        self.similar_files = similar_files


class BestMatchClassifier(Classifier):
    name: str

    def __init__(self):
        self.name = "Best match"


def classify_best_match(similarities: pl.LazyFrame, src: str) -> Classification:
    # Takes a file with all similarities and extracts the column corresponding to the file in question

    filter_expr = (pl.col("src") == src) & (pl.col("target") != src)
    file_column = similarities.filter(filter_expr).sort("similarity", descending=True)

    # best_match_score = file_column.select("similarity").item(0, 0)
    best_match_name = file_column.select("target").collect().item(0, 0)
    label = get_label(similarities, best_match_name)

    return Classification(src, label, [best_match_name])


def sort_pr_src(similarities: pl.LazyFrame) -> pl.LazyFrame:
    return similarities.sort("src", "similarity", descending=[False, True])


def classify_knn_match(similarities: pl.LazyFrame, src: str, k: int) -> Classification:
    assert k > 0, "k must be positive"
    sorted_sim = sort_pr_src(similarities)

    filter_expr = (pl.col("src") == src) & (pl.col("target") != src)
    src_sim = sorted_sim.filter(filter_expr).select(["target", "similarity"])

    k_best = src_sim.head(k)

    k_best_names = pl.Series(k_best.select("target").collect()).to_list()
    labels = [get_label(similarities, filename) for filename in k_best_names]

    label_counts = Counter(labels)
    label = max(label_counts)

    return Classification(src, label, k_best_names)


def create_classification_dataframe(similarities: pl.LazyFrame, k: int) -> pl.LazyFrame:
    data = {"src": [], "classifier": [], "labelled_as": []}

    src_df = similarities.select("src", "src_label").unique(maintain_order=True)
    src_names = pl.Series(src_df.select("src").collect()).to_list()

    name = "knn"

    classifications = [
        classify_knn_match(similarities, src, k).labelled_as for src in src_names
    ]

    data["src"] = src_names
    data["classifier"] = [name for _ in range(len(src_names))]
    data["labelled_as"] = classifications

    return src_df.join(pl.LazyFrame(data), on="src")


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
        }
    )


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
        [summed_cols.collect().select(c).item() for c in summed_cols.collect().columns]
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

    overview = {
        "FP": [false_pos],
        "FN": [false_neg],
        "Acc": [accuracy],
        "Prec": [precision],
        "Rec": [recall],
        "F1": [f_score],
    }

    return pl.LazyFrame(overview)

    # AUC
    #
