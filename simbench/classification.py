import polars as pl
from .data import get_label


class Classication:
    name: str
    labelled_as: str
    score: float

    def __init__(self, name, label, score):
        self.name = name
        self.labelled_as = label
        self.score = score


def classify_best_match(similarities: pl.DataFrame, src: str) -> Classication:
    # Takes a file with all similarities and extracts the column corresponding to the file in question

    filter_expr = (pl.col("src") == src) & (pl.col("target") != src)
    file_column = similarities.filter(filter_expr).sort("similarity", descending=True)

    best_match_score = file_column.select("similarity").item(0, 0)
    best_match_name = file_column.select("target").item(0, 0)
    label = get_label(similarities, best_match_name)

    return Classication(best_match_name, label, best_match_score)


def classify_knn_match(similarities: pl.DataFrame, src: str, k: int) -> [Classication]:
    # Takes a file with all similarities and extracts the column corresponding to the file in question

    filter_expr = (pl.col("src") == src) & (pl.col("target") != src)
    file_column = similarities.filter(filter_expr).sort("similarity", descending=True)

    scores = [file_column.select("similarity").item(i, 0) for i in range(k)]
    names = [file_column.select("target").item(i, 0) for i in range(k)]
    labels = [file_column.select("").item(i, 0) for i in range(k)]

    return (best_match_name, best_match_score)
