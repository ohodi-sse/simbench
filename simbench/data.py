from pathlib import Path

import numpy as np
import polars as pl
from typing import TypedDict, Required  # , Generic, TypeVarTuple, Tuple, NewType
from sklearn.model_selection import train_test_split
from loguru import logger


class File:
    name: str
    path: Path
    label: str = ""
    _bytes: bytes = None

    def __init__(self, name, label, filepath: Path):
        if not filepath.is_file():
            raise ValueError(f"Path {filepath} is not a file.")
        assert name == filepath.name, "File name must match the final part of the path"
        assert label == filepath.parent.stem, (
            "Label must match the parent directory of the file"
        )

        self.name = name
        self.label = label
        self.path = filepath

    def __str__(self) -> str:
        return f"{self.name}"

    def get_bytes(self) -> bytes:
        if self._bytes is None:
            self._bytes = self.path.read_bytes()
        return self._bytes


class FileInfoDF(TypedDict, total=False):
    src: Required[str]
    src_label: Required[str]


class AnalysisSimDF(TypedDict, total=False):
    src: Required[str]
    target: Required[str]
    src_label: Required[str]
    tool_name: Required[str]
    similarity: Required[float]
    options: str  # Maybe it should be a subtype


def collect_datafiles(dir: Path) -> FileInfoDF:
    # This functions expects the dir to point to a directory,
    # containing folders each containing samples with one specific label.
    data = {"src": [], "src_label": [], "src_file": []}

    logger.debug(f"Collecting data from {str(dir)}")
    dirs = dir.iterdir()
    assert dirs, f"Failed to find any subdirectories in {dir}"

    for d in dirs:
        if d.is_dir():
            dir_srcs = [filepath for filepath in d.iterdir() if filepath.is_file()]

            data["src"].extend([file.name for file in dir_srcs])
            data["src_label"].extend([file.parent.stem for file in dir_srcs])
            data["src_file"].extend(dir_srcs)

    assert data["src"], "Failed to collect any files in the specified directory"
    return pl.LazyFrame(data)


def join_on_src_target():
    pass


def write_parquet(filename: Path, data: pl.LazyFrame) -> None:
    data.to_parquet(filename)


def load_parquet(filename: Path) -> pl.LazyFrame:
    if not filename.is_file():
        raise ValueError(f"Path {filename} is not a valid file.")
    df = pl.scan_parquet(filename)
    return df


def get_similarity(data: pl.LazyFrame, src: str, target: str) -> float:
    filter_expr = (pl.col("src") == src) & (pl.col("target") == target)
    similarity = data.filter(filter_expr).select("similarity").collect()

    return similarity.item()


def get_label(data_overview: pl.LazyFrame, src: str) -> str:
    filter_expr = pl.col("src") == src
    file_col = data_overview.filter(filter_expr).select("src_label").collect()
    assert not file_col.is_empty(), (
        f"Failed to find a label for {src} in {data_overview}"
    )

    label = file_col.item(0, 0)

    assert isinstance(label, str), "get_label must return a string"

    return label


######## DATA SPLITTING #############


def split_classes(classdir: Path) -> (np.array, np.array):
    classes = [
        int("".join([ch for ch in c if ch.isdigit()]))
        for c in classdir.iterdir()
        if c.is_dir()
    ]

    classes_train, classes_test = train_test_split(
        classes, train_size=0.8, random_state=1, shuffle=True, stratify=None
    )
    return classes_train, classes_test


def split_data(X, y):
    X_train, X_test, y_train, y_test = train_test_split(
        X, y, train_size=0.8, random_state=1, shuffle=True, stratify=None
    )

    print(f"Class distribution of train set: {y_train.value_counts()}")
    print(f"Class distribution of test set: {y_test.value_counts()}")

    return X_train, X_test, y_train, y_test


def split_collected_data(
    datafile: Path, classes: np.array
) -> (np.array, np.array, np.array, np.array):
    df = load_parquet(datafile)

    # pick out the chosen classes to stratify on this level as well.
    df = df[classes]

    X = df.to_numpy().transpose()
    y = df.columns

    X_train, X_test, y_train, y_test = split_data(X, y)

    return X_train, X_test, y_train, y_test
