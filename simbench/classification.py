from .data import (
    get_label,
    CLASSIFICATIONS_SCHEMA,
    PERFORMANCE_SCHEMA,
    CONFUSION_SCHEMA,
)
from collections import Counter
from abc import abstractmethod
from dataclasses import dataclass
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
    def __call__(self, similarity_df: pl.LazyFrame, src: str) -> Classification:
        pass

    @abstractmethod
    def name(self) -> str:
        pass


@dataclass(frozen=True)
class BestMatch(Classifier):
    def __call__(self, similarity_df: pl.LazyFrame, src: str) -> Classification:
        filter_expr = (pl.col("src") == src) & (pl.col("target") != src)
        file_column = similarity_df.filter(filter_expr).sort(
            "similarity", descending=True
        )

        best_match_name = file_column.select("target").collect().item(0, 0)
        label = get_label(similarity_df, best_match_name)

        return Classification(src, label, [best_match_name])

    def name(self) -> str:
        return "BestMatch"


def sort_pr_src(similarities: pl.LazyFrame) -> pl.LazyFrame:
    return similarities.sort("src", "similarity", descending=[False, True])


@dataclass(frozen=True)
class KNN(Classifier):
    k: int

    def __call__(self, similarities: pl.LazyFrame, src: str) -> Classification:
        assert self.k > 0, "k must be positive"
        sorted_sim = sort_pr_src(similarities)

        filter_expr = (pl.col("src") == src) & (pl.col("target") != src)
        src_sim = sorted_sim.filter(filter_expr).select(["target", "similarity"])

        k_best = src_sim.head(self.k)

        k_best_names = pl.Series(k_best.select("target").collect()).to_list()
        labels = [get_label(similarities, filename) for filename in k_best_names]

        label_counts = Counter(labels)
        label = max(label_counts)

        return Classification(src, label, k_best_names)

    def name(self) -> str:
        return f"knn_{self.k}"

    def __post_init__(self):
        assert isinstance(self.k, int)


def get_classifier(classifier_name: str) -> Classifier | None:
    classf_opts = classifier_name.split("_")

    k = None
    if len(classf_opts) > 1:
        k = int(classf_opts[1])

    match classf_opts[0]:
        case "bm":
            return BestMatch()
        case "knn":
            assert k, (
                "Must provide the knn option as knn_? where ? is the number of nearest neighbours"
            )
            try:
                return KNN(k)
            except ValueError:
                logger.warning(
                    "KNN classifiers should be given a k value. Pass knn_? where ? is an int"
                )
        case e:
            logger.warning(f"Don't know how to handle classifier name: {e}")


def create_classification_dataframe(
    similarities: pl.LazyFrame, classifier: Classifier
) -> pl.LazyFrame:
    data = {col: [] for col in CLASSIFICATIONS_SCHEMA}

    src_df = similarities.select("src", "src_label").unique(maintain_order=True)
    src_names = pl.Series(src_df.select("src").collect()).to_list()

    classifications = [classifier(similarities, src).labelled_as for src in src_names]

    data["src"] = src_names
    data["src_label"] = pl.Series(src_df.select("src_label").collect()).to_list()
    data["classifier"] = [classifier.name() for _ in range(len(src_names))]
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

    overview = {
        "FP": [false_pos],
        "FN": [false_neg],
        "Acc": [accuracy],
        "Prec": [precision],
        "Rec": [recall],
        "F1": [f_score],
    }

    return pl.LazyFrame(overview, schema=PERFORMANCE_SCHEMA)
