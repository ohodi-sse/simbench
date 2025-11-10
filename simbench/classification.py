import polars as pl


def classify_best_match(similarities: pl.DataFrame, src: str) -> (str, float):
    # Takes a file with all similarities and extracts the column corresponding to the file in question

    filter_expr = (pl.col("src") == src) & (pl.col("target") != src)
    file_column = similarities.filter(filter_expr).sort("similarity", descending=True)

    best_match_score = file_column.select("similarity").item(0, 0)
    best_match_name = file_column.select("target").item(0, 0)

    return (best_match_name, best_match_score)


def classify_knn_match(similarities: pl.DataFrame, src: str, k: int) -> [(str, float)]:
    # Takes a file with all similarities and extracts the column corresponding to the file in question

    filter_expr = (pl.col("src") == src) & (pl.col("target") != src)
    file_column = similarities.filter(filter_expr).sort("similarity", descending=True)

    best_match_score = [file_column.select("similarity").item(i, 0) for i in range(k)]
    best_match_name = [file_column.select("target").item(i, 0) for i in range(k)]

    return (best_match_name, best_match_score)
