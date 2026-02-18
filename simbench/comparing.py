from simbench.build import Builder
from simbench.analysis import Analysis
import sys
import random
import polars as pl
from loguru import logger
from termcolor import colored


def find_analysis_difference(
    analysis_1: Analysis, analysis_2: Analysis, seed: int | None = None
):
    # This function takes two classification files, and returns a dataframe containing all
    # solutions that were intially misclassified in class1 but rectified in class2
    # The intended use of this function is to locate code examples for which the
    # preprocessing of class2 has improved the performance of the classification
    bld = Builder(logger)

    class_df_1 = analysis_1.classification_nodes["knn-1"].pull(bld)
    class_df_2 = analysis_2.classification_nodes["knn-1"].pull(bld)

    prejoindf = class_df_2.select(pl.col("src"), pl.col("labelled_as").alias("label2"))

    diff_df = (
        class_df_1.select(
            pl.col("src"),
            pl.col("src_label"),
            pl.col("labelled_as").alias("label1"),
        )
        .join(prejoindf, on="src")
        .filter(pl.col("src_label") != pl.col("label1"))
        .filter(pl.col("src_label") == pl.col("label2"))
        .filter(pl.col("label1") != pl.col("label2"))
    ).collect()

    src = pick_random_source(diff_df, seed)

    source_1 = analysis_1.source_nodes.pull(bld)[src]
    source_2 = analysis_2.source_nodes.pull(bld)[src]

    show_file_diff(source_1.path, source_2.path)


def pick_random_source(df: pl.DataFrame, seed: int | None = None) -> str:
    srcs = pl.Series(df.select(pl.col("src"))).to_list()

    if seed:
        random.seed(seed)
    else:
        seed = random.randrange(sys.maxsize)

    logger.info(f"Random seed was: {seed}")

    rand_index = random.randint(0, len(srcs) - 1)
    file = srcs[rand_index]

    return file


def pretty_diff(str1, str2):
    from difflib import Differ
    import re

    collected = ""
    diff = Differ().compare(str1, str2)
    pad_size = 60
    for line in diff:
        text = re.sub(r"[^\S\n]", " ", line[1:]).replace("\n", "").rstrip()

        if line.startswith(" "):
            text = colored(text, "green")
            padding = " " * (9 + pad_size - len(text))
            left = text + padding
            collected += left + "| " + text + "\n"

        elif line.startswith("-"):
            # line is only on the left
            padding = " " * (pad_size - len(text))
            left = colored(text, "yellow") + padding
            collected += left + "| \n"

        elif line.startswith("+"):
            # line is only on the right
            left = " " * pad_size
            collected += left + "| " + colored(text, "blue") + "\n"

    return collected


def show_file_diff(file1, file2):
    with open(file=file1, mode="r") as f1:
        with open(file=file2, mode="r") as f2:
            s1 = f1.readlines()
            s2 = f2.readlines()
            diffout = pretty_diff(s1, s2)
            print(diffout)


def wilcoxon_signed_rank_test(file1, file2, key):
    from scipy.stats import wilcoxon

    df1 = pl.read_parquet(file1)
    df2 = pl.read_parquet(file2)

    assert isinstance(df1, pl.DataFrame)
    assert isinstance(df2, pl.DataFrame)

    col1 = pl.Series(df1.select(pl.col(key))).to_list()
    col2 = pl.Series(df2.select(pl.col(key))).to_list()

    assert len(col1) == len(col2), (
        "Can only compare entries with equally many datapoints"
    )

    diffs = [c1 - c2 for (c1, c2) in zip(col1, col2)]

    result = wilcoxon(diffs)
    print(f"Statistic: {result.statistic}")
    print(f"P-value: {result.pvalue}")
