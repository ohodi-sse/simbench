import os
import sys
import random
import polars as pl
from loguru import logger
from termcolor import colored
from simbench.tables import ClassificationTable, schema


def find_classification_difference(class1_path, class2_path, seed: int | None = None):
    # This function takes two classification files, and returns a dataframe containing all
    # solutions that were intially misclassified in class1 but rectified in class2
    # The intended use of this function is to locate code examples for which the
    # preprocessing of class2 has improved the performance of the classification

    assert class1_path.parent.name == "classifications"
    assert class2_path.parent.name == "classifications"

    class_df1 = pl.read_parquet(class1_path)
    class_df2 = pl.read_parquet(class2_path)

    assert isinstance(class_df1, pl.DataFrame)
    assert isinstance(class_df2, pl.DataFrame)

    assert class_df1.schema == schema(ClassificationTable)
    prejoindf = class_df2.select(pl.col("src"), pl.col("labelled_as").alias("label2"))

    diff_df = (
        class_df1.select(
            pl.col("src"),
            pl.col("src_label"),
            pl.col("labelled_as").alias("label1"),
        )
        .join(prejoindf, on="src")
        .filter(pl.col("src_label") != pl.col("label1"))
        .filter(pl.col("src_label") == pl.col("label2"))
        .filter(pl.col("label1") != pl.col("label2"))
    )

    file, label = pick_random_source(diff_df, seed)
    root_path = class1_path.parent.parent.parent.parent.parent
    class_1_normalizer = class1_path.parent.parent.parent.name
    class_2_normalizer = class2_path.parent.parent.parent.name
    normalizer1_name = f"{class_1_normalizer + '_' if class_1_normalizer != 'unprocessed' else ''}problems"

    normalizer2_name = f"{class_2_normalizer + '_' if class_2_normalizer != 'unprocessed' else ''}problems"
    def_path_1 = os.path.abspath(root_path / normalizer1_name / label / file)
    print(def_path_1)
    def_path_2 = os.path.abspath(root_path / normalizer2_name / label / file)

    show_file_diff(def_path_1, def_path_2)


def pick_random_source(df: pl.DataFrame, seed: int | None = None):
    srcs = pl.Series(df.select(pl.col("src"))).to_list()
    labels = pl.Series(df.select(pl.col("src_label"))).to_list()

    if seed:
        random.seed(seed)
    else:
        seed = random.randrange(sys.maxsize)

    logger.info(f"Random seed was: {seed}")

    rand_index = random.randint(0, len(srcs) - 1)
    file = srcs[rand_index]
    label = labels[rand_index]

    return file, label


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
