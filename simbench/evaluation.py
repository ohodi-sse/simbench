import polars as pl
from great_tables import GT
from great_tables import GT, loc, style, exibble
import numpy as np


def min_1(d: float):
    return 0.0 if (d > 1.0) | (d < 0.0) else d


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


def logistic(data, labels):
    from sklearn.linear_model import LogisticRegression

    model = LogisticRegression(max_iter=1000)
    mfit = model.fit(data, labels)

    return mfit


def isotonic(data, labels):
    from sklearn.isotonic import IsotonicRegression

    model = IsotonicRegression(out_of_bounds="clip")
    mfit = model.fit(data, labels)
    return mfit


def isotonic_regression(bld, analysis):
    from sklearn.metrics import log_loss

    dist_df = (
        analysis.distance_node.pull(bld)
        .filter(pl.col("src") != pl.col("tgt"))
        .collect()
    )

    dist_df = dist_df.select(
        [
            (pl.col("src_label") == pl.col("tgt_label"))
            .alias("within_class")
            .cast(pl.Int8),
            pl.col("distance").map_elements(min_1, return_dtype=pl.Float64).fill_nan(0),
        ]
    ).sort(by="distance")

    y_true = dist_df["within_class"].to_numpy()
    distances = dist_df["distance"].to_numpy().reshape(-1, 1)

    bld.log.info(f"Fitting isotonic model to similarities from {analysis.tool.name}")
    model = isotonic(distances, y_true)
    y_pred = model.predict(distances)

    loss = log_loss(y_true, y_pred)

    return model, loss


def mean_time(bld, analysis):
    dist_df = (
        analysis.distance_node.pull(bld)
        .filter(pl.col("src") != pl.col("tgt"))
        .collect()
    )

    return np.exp((dist_df["time"] * 1e-6).log().mean())


def prettify_dataframe(df: pl.DataFrame) -> pl.DataFrame:
    df = df.rename({col: col.replace("_", " ") for col in df.columns})
    df = df.with_columns(pl.col("Similarity Measure").str.replace_all("NCD", "\\ncd^"))
    df = df.with_columns(
        pl.col("Similarity Measure")
        .str.replace_all("without_similarity_measure", "\\cos^{")
        .str.replace_all("summed_diff_similarity", "\\diff_{b}^{")
        .str.replace_all("normalized_diff_similarity", "\\diff^{")
        .str.replace_all("diff_similarity", "\\diff_{a}^{")
    )
    df = df.with_columns(pl.col("Tool").str.replace_all("_", " "))

    df = df.rename({col: col.replace("Time", "{Time (ms)}") for col in df.columns})
    df = df.rename(
        {
            col: col.replace("Iso Loss", "{Iso Loss (\$\\times10^{-3}$)}")
            for col in df.columns
        }
    )
    return df


def pivot_normalizer(df: pl.DataFrame):
    df = df.with_columns(
        pl.struct(["Similarity Measure", "Tool"])
        .map_elements(lambda x: rf"{x['Similarity Measure']}mathrm{x['Tool']}")
        .alias("Similarity Measure")
    )

    df = df.pivot(
        values="{Iso Loss (\$\\times10^{-3}$)}",
        index=["Similarity Measure"],
        columns="Normalizer",
        aggregate_function="first",  # or "sum", "mean" depending on your data
    )

    df = df.rename(
        {
            "unprocessed": "Original",
            "decompiled": "Recompiled",
            "google_java_formatted": "Formatted",
            "token_format": "Tokens",
        }
    )

    df = df.select(
        ["Similarity Measure", "Original", "Formatted", "Tokens", "Recompiled"]
    )

    return df


def dataframe_as_latex_table(df: pl.DataFrame):
    df = prettify_dataframe(df)

    multiple_normalizers = df.select(pl.col("Normalizer").n_unique()).item() > 1
    if not multiple_normalizers:
        print(
            f"The following dataframe contains: {df.select(pl.col('Normalizer').unique()).item()}\n"
        )
        df = df.select(
            [
                pl.col(col)
                for col in df.columns
                if not (
                    (col == "Normalizer") & df.select(pl.col(col).n_unique()).item()
                    == 1
                )
            ]
        )
        df = df.with_columns(
            pl.struct(["Similarity Measure", "Tool"])
            .map_elements(
                lambda x: rf"{x['Similarity Measure']}mathrm{x['Tool']}" + "}"
            )
            .alias("Similarity Measure")
        ).select(pl.exclude("Tool"))

    if multiple_normalizers:
        df = pivot_normalizer(df)

    df = df.with_columns(pl.col("Similarity Measure").map_elements(lambda x: rf"${x}$"))

    print(df)
    gt = GT(df)

    if not multiple_normalizers:
        # locations = loc.body(columns="Time", rows=pl.col("Time") == pl.col("Time").min())
        locations = loc.body(
            columns=pl.col("Raw Loss"),
            rows=pl.col("Raw Loss") == pl.col("Raw Loss").min(),
        )

        gt = gt.tab_style(style=style.text(weight="bold"), locations=locations)
        locations = loc.body(
            columns=pl.col("{Iso Loss (\$\\times10^{-3}$)}"),
            rows=pl.col("{Iso Loss (\$\\times10^{-3}$)}")
            == pl.col("{Iso Loss (\$\\times10^{-3}$)}").min(),
        )

        gt = gt.tab_style(style=style.text(weight="bold"), locations=locations)

    gt = gt.fmt_number(
        columns=pl.col(pl.Float32),
        decimals=2,
    )

    latex_gt = gt.as_latex()
    assert latex_gt is not None
    latex_gt = latex_gt.replace(r"\}", "}")
    latex_gt = latex_gt.replace(r"\_", "_")
    latex_gt = latex_gt.replace(r"\{", "{")
    latex_gt = latex_gt.replace(r"\^", "^")
    latex_gt = latex_gt.replace(r"\$", "$")
    latex_gt = latex_gt.replace(r"(\\$", "($")
    latex_gt = latex_gt.replace(r"\c", "c")
    latex_gt = latex_gt.replace(r"\time", "time")
    latex_gt = latex_gt.replace(r"\d", "d")
    latex_gt = latex_gt.replace(r"\ncd", "ncd")
    latex_gt = latex_gt.replace(r"CDM", "\cdm^")
    latex_gt = latex_gt.replace(r"mathrm", "\mathrm{")
    latex_gt = latex_gt.replace(r"BERT", "BERT}")
    latex_gt = latex_gt.replace(r"Vec", "Vec}")
    latex_gt = latex_gt.replace(r"normalized_cosine", "\cos^{")
    latex_gt = latex_gt.replace(r"distance", "distance")
    latex_gt = latex_gt.replace(r"\fontsize{12.0pt}{14.4pt}\selectfont", "")

    return latex_gt
