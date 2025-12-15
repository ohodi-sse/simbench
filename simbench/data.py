from pathlib import Path

import polars as pl
from loguru import logger

from typing import get_type_hints

from dataclasses import dataclass
from abc import ABC, abstractmethod

from indicatif import ProgressBar, ProgressStyle


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
            raise ValueError(f"Path {self.path} is not a file.")

    def get_bytes(self) -> bytes:
        return self.path.read_bytes()


class Table(ABC):
    @classmethod
    def schema(cls):
        return get_type_hints(cls)

    @classmethod
    def scan(cls, *args, **kwargs):
        return pl.scan_parquet(*args, schema=cls.schema(), **kwargs)

    @classmethod
    def dataframe(cls, *args, **kwargs):
        return pl.DataFrame(*args, schema=cls.schema(), **kwargs)

    @classmethod
    def lazyframe(cls, *args, **kwargs):
        return pl.LazyFrame(*args, schema=cls.schema(), **kwargs)


class CompressionTable(Table):
    src: pl.String
    src_comp: pl.UInt64
    src_size: pl.UInt64
    src_ratio: pl.Float64
    src_time: pl.UInt64
    src_label: pl.String


class ComparisonCompressionTable(Table):
    src: pl.String
    tgt: pl.String
    srctgt_size: pl.UInt64
    srctgt_comp: pl.UInt64
    srctgt_ratio: pl.Float64
    srctgt_time: pl.UInt64


class MetricTable(Table):
    src: pl.String
    src_comp: pl.UInt64
    src_size: pl.UInt64
    src_ratio: pl.Float64
    src_time: pl.UInt64
    src_label: pl.String
    tgt: pl.String
    tgt_comp: pl.UInt64
    tgt_size: pl.UInt64
    tgt_ratio: pl.Float64
    tgt_time: pl.UInt64
    tgt_label: pl.String
    srctgt_comp: pl.UInt64
    srctgt_size: pl.UInt64
    srctgt_ratio: pl.Float64
    srctgt_time: pl.UInt64


class DistanceTable(Table):
    src: pl.String
    tgt: pl.String
    src_label: pl.String
    tgt_label: pl.String
    distance: pl.Float32
    time: pl.UInt64


class ClassificationTable(Table):
    src: pl.String
    src_label: pl.String
    classifier: pl.String
    class_param: pl.Float32
    labelled_as: pl.String


class PerformanceTable(Table):
    classifier: pl.String
    class_param: pl.Float32
    FP: pl.UInt64
    FN: pl.UInt64
    Acc: pl.Float32
    Prec: pl.Float32
    Rec: pl.Float32
    F1: pl.Float32


def get_progressbar(iterations: int):
    return ProgressBar(
        iterations,
        style=ProgressStyle(
            template="{spinner:.green} [{elapsed_precise}] [{wide_bar:.cyan/blue}] {pos}/{len} ({per_sec}, {eta})",
            progress_chars="#>-",
        ),
    )


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
