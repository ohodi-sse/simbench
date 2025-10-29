from pathlib import Path
import os
import pandas as pd
import pyarrow as pa
import pyarrow.parquet as pq

from sklearn.model_selection import train_test_split
from loguru import logger
import numpy as np


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
        self.group = os.path.dirname(filepath)

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


def collect_datafiles(dir: Path) -> pd.DataFrame:
    # This functions expects the dir to point to a directory,
    # containing folders each containing samples with one specific label.
    data = {}

    for d in os.listdir(dir):
        d_path = os.getcwd() / dir / Path(d)
        if d_path.is_dir():
            # extracting the group number from the folder name
            label = int("".join([c for c in d_path.name if c.isdigit()]))
            logger.debug(label)
            data[label] = [
                str(File(Path(file.path), label))
                for file in os.scandir(d_path)
                if file.is_file() and file.name.endswith(".java")
            ]

    return pd.DataFrame(data)


def str_to_path(strpath: str) -> Path:
    return Path(strpath)


def write_parquet(filename: Path, data: pd.DataFrame) -> None:
    table = pa.Table.from_pandas(data)
    pq.write_table(table, filename)


def load_parquet(filename: Path) -> pd.DataFrame:
    if not filename.is_file():
        raise ValueError(f"Path {filename} is not a valid file.")
    df = pq.read_table(filename).to_pandas()
    return df


def print_md_data(data: pd.DataFrame) -> str:
    return data.to_markdown()


def split_classes(classdir: Path) -> (np.array, np.array):
    classes = [
        int("".join([ch for ch in c if ch.isdigit()]))
        for c in os.listdir(classdir)
        if (classdir / Path(c)).is_dir()
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
