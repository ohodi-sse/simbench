from pathlib import Path

import numpy as np
import pandas as pd
from typing import TypedDict, Required, Generic, TypeVarTuple, Tuple, NewType
from sklearn.model_selection import train_test_split
from loguru import logger


class File:
    name: str
    path: Path
    group: int = -1
    _bytes: bytes = None

    def __init__(self, filepath: Path, group: int = -1):
        if not filepath.is_file():
            raise ValueError(f"Path {filepath} is not a file.")
        self.path = filepath
        self.name = filepath.name
        self.group = filepath.parent # Assuming the file is in a folder named after group

    def __str__(self) -> str:
        return f"g:{self.group}_f:{self.name}"

    def parse(str) -> (str, str):
        args = str.split("_")
        group = args[0][2:]
        name = args[1][2:]
        return group, name

    def get_bytes(self) -> bytes:
        if self._bytes is None:
            self._bytes = self.path.read_bytes()
        return self._bytes

class AnalysisInfoDF(TypedDict,total=False):
    src : Required[str]
    target : Required[str]
    src_label : Required[str]


class SimilariyAnalysisDF(TypedDict,total=False):
    tool_name : Required[str]
    similarity : Required[float]
    options : str # Maybe it should be a subtype



# SimInfo = NewType('SimInfo',AnalysisInfoDF)
# SimData = NewType('SimData',SimilariyAnalysisDF)
# Shape = TypeVarTuple('Shape')
#
#
# class AnalysisDataFrame(Generic[SimInfo,*Shape]): 
#
#     def __init__(self,info : SimInfo, data: Tuple(*Shape)):
#         self.src = info.src
#         self.target = info.target 
#         self.src_label = info.src_label
#         self._shape: Tuple[*Shape] = shape
#
#
# def analyze_data(datafiles: [Path], metric: SimilariyMetric) -> AnalysisDataFrame:
#     # Should compare all datafiles pairwise with the metric, and return in the analysis DF format
#     pass


def collect_datafiles(dir: Path) -> pd.DataFrame:
    # This functions expects the dir to point to a directory,
    # containing folders each containing samples with one specific label.
    data = {}

    for d in dir.iterdir():
        if d.is_dir():
            # extracting the group number from the folder name
            label = int("".join([c for c in d.name if c.isdigit()]))

            data[label] = [
                File(file, label)
                for file in d.iterdir()
                if file.is_file() and file.name.endswith(".java")
            ]

    return pd.DataFrame(data)


def write_parquet(filename: Path, data: pd.DataFrame) -> None:
    data.to_parquet(filename)


def load_parquet(filename: Path) -> pd.DataFrame:
    if not filename.is_file():
        raise ValueError(f"Path {filename} is not a valid file.")
    df = pd.read_parquet(filename)
    return df


def print_md_data(data: pd.DataFrame) -> str:
    return data.to_markdown()




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
