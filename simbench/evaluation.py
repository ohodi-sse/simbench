def log_loss(bld: Builder, analysis):
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

    res = log_loss(y_true, y_pred)
    print(res)
