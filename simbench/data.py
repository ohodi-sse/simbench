from pathlib import Path

import polars as pl
from loguru import logger

from dataclasses import dataclass


@dataclass(frozen=True)
class Source:
    path: Path

    @property
    def name(self):
        return self.path.name

    @property
    def label(self):
        return self.path.parent.name

    def __post_init__(self):
        if not self.path.is_file():
            raise ValueError(f"Path {self.filepath} is not a file.")

    def get_bytes(self) -> bytes:
        return self.path.read_bytes()


class File:
    name: str
    path: Path
    label: str = ""
    _bytes: bytes | None = None

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


FILEINFO_SCHEMA = {
    "src": pl.String(),
    "src_label": pl.String(),
    "src_file": pl.String(),
}


METRIC_SCHEMA = pl.Schema(
    {
        "src": pl.String(),
        "src_len": pl.UInt64(),
        "src_time": pl.Float64(),
        "src_label": pl.String(),
        "tgt": pl.String(),
        "tgt_len": pl.UInt64(),
        "tgt_time": pl.Float64(),
        "tgt_label": pl.String(),
        "srctgt_len": pl.UInt64(),
        "srctgt_time": pl.Float64(),
    }
)

COMP_CLASS_SCHEMA = pl.Schema(
    {
        "src": pl.String(),
        "tgt": pl.String(),
        "srctgt_len": pl.UInt64(),
        "srctgt_time": pl.Float64(),
    }
)

COMP_FILE_SCHEMA = pl.Schema(
    {
        "src": pl.String(),
        "src_len": pl.UInt64(),
        "src_time": pl.UInt64(),
        "src_label": pl.String(),
    }
)


class CompressionTable:
    schema = COMP_FILE_SCHEMA

    @classmethod
    def scan(cls, *args, **kwargs):
        return pl.scan_parquet(*args, schema=cls.schema, **kwargs)

    @classmethod
    def dataframe(cls, *args, **kwargs):
        return pl.DataFrame(*args, schema=cls.schema, **kwargs)


DISTANCE_SCHEMA = pl.Schema(
    {
        "src": pl.String(),
        "tgt": pl.String(),
        "src_label": pl.String(),
        "tgt_label": pl.String(),
        "metric": pl.String(),
        "comp": pl.String(),
        "comp_lvl": pl.UInt8(),
        "distance": pl.Float32(),
        "time": pl.Float64(),
    }
)


CLASSIFICATIONS_SCHEMA = pl.Schema(
    {
        "src": pl.String(),
        "src_label": pl.String(),
        "metric": pl.String(),
        "comp": pl.String(),
        "comp_lvl": pl.UInt8(),
        "classifier": pl.String(),
        "class_param": pl.String(),
        "labelled_as": pl.String(),
    }
)
CONFUSION_SCHEMA = pl.Schema(
    {
        "class": pl.String(),
        "true_pos": pl.UInt64(),
        "true_neg": pl.UInt64(),
        "false_pos": pl.UInt64(),
        "false_neg": pl.UInt64(),
    }
)

PERFORMANCE_SCHEMA = pl.Schema(
    {
        "metric": pl.String(),
        "comp": pl.String(),
        "comp_lvl": pl.UInt8(),
        "classifier": pl.String(),
        "class_param": pl.String(),
        "FP": pl.UInt64(),
        "FN": pl.UInt64(),
        "Acc": pl.Float32(),
        "Prec": pl.Float32(),
        "Rec": pl.Float32(),
        "F1": pl.Float32(),
    }
)


def collect_datafiles(dir: Path) -> pl.LazyFrame:
    # This functions expects the dir to point to a directory,
    # containing folders each containing samples with one specific label.
    data = {col: [] for col in FILEINFO_SCHEMA}

    logger.debug(f"Collecting data from {str(dir)}")
    dirs = dir.iterdir()
    assert dirs, f"Failed to find any subdirectories in {dir}"
    currdir = Path.cwd()

    for d in dirs:
        if d.is_dir() and d.name != "analyses":
            dir_srcs = [filepath for filepath in d.iterdir() if filepath.is_file()]

            data["src"].extend([file.name for file in dir_srcs])
            data["src_label"].extend([file.parent.stem for file in dir_srcs])
            data["src_file"].extend(
                [str(file.relative_to(currdir)) for file in dir_srcs]
            )

    assert data["src"], "Failed to collect any files in the specified directory"

    return pl.LazyFrame(data, schema=FILEINFO_SCHEMA)


def join_on_src_target():
    pass


def write_parquet(filename: Path, data: pl.LazyFrame) -> None:
    data.to_parquet(filename)


def load_parquet(filename: Path) -> pl.LazyFrame:
    if not (filename.is_file() & filename.name.endswith(".parquet")):
        raise ValueError(f"Path {filename} is not a valid file.")
    df = pl.scan_parquet(filename)
    return df


def filelist_from_data(df: pl.LazyFrame) -> list[File]:
    file_paths = [
        Path(fp) for fp in pl.Series(df.select("src_file").collect()).to_list()
    ]
    files = [File(fp.name, fp.parent.stem, fp) for fp in file_paths]

    return files


def get_similarity(data: pl.LazyFrame, src: str, target: str) -> float:
    filter_expr = (pl.col("src") == src) & (pl.col("tgt") == target)
    similarity = data.filter(filter_expr).select("distance").collect()

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


def merge_dataframes(df1: pl.LazyFrame, df2: pl.LazyFrame) -> pl.DataFrame:
    assert df1.collect_schema() == df2.collect_schema(), (
        "Can only merge dataframes with the same schema"
    )

    return df1.collect().extend(df2.collect())


def merge_many(dir: Path, suffix: str) -> pl.DataFrame:
    """Takes a directory and tries to load and merge all dataframes with a certain suffix"""
    assert suffix.endswith(".parquet"), "Suffix should end with .parquet"

    eligible_files = [
        f
        for f in dir.iterdir()
        if f.is_file() and f.name.endswith(suffix) and ("merged" not in f.name)
    ]

    assert eligible_files, (
        f"No files found with suffix {suffix} in directory {str(dir)}"
    )

    df = pl.read_parquet(eligible_files[0])
    df_schema = df.schema
    if len(eligible_files) < 2:
        return df

    for f in eligible_files[1:]:
        df_next = pl.read_parquet(f)
        assert df_schema == df_next.schema, (
            "Can only merge dataframes with the same schema"
        )
        df.extend(df_next)

    return df


def display_diff(src1: str, src2: str, file_overview: pl.LazyFrame):
    path1 = Path(
        file_overview.filter(pl.col("src") == src1).select("src_file").collect().item()
    )
    path2 = Path(
        file_overview.filter(pl.col("src") == src2).select("src_file").collect().item()
    )

    assert path1.exists() and path1.is_file(), f"{path1} is not a valid file"
    assert path1.exists() and path2.is_file(), f"{path2} is not a valid file"

    with open(path1, "r") as f1:
        with open(path2, "r") as f2:
            logger.info(f1)
            logger.info(f2)
