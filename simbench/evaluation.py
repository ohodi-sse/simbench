import polars as pl
from great_tables import GT


def min_1(d: float):
    return 0.0 if d > 1.0 else d


def log_loss(bld, analysis):
    from sklearn.metrics import log_loss

    dist_df = analysis.distance_node.pull(bld)

    dist_df = dist_df.select(
        [
            pl.col("src"),
            pl.col("tgt"),
            (pl.col("src_label") == pl.col("tgt_label"))
            .alias("within_class")
            .cast(pl.Int8),
            pl.col("distance").map_elements(min_1, return_dtype=pl.Float64),
        ]
    ).collect()
    y_true = dist_df["within_class"]
    y_pred = dist_df["distance"]

    return log_loss(y_true, y_pred)


def dataframe_as_latex_table(df: pl.DataFrame):
    df = df.with_columns(pl.col(pl.Utf8).str.replace_all("_", " "))
    gt = GT(df).fmt_number(columns=["Loss"], decimals=3)
    return gt.as_latex()
