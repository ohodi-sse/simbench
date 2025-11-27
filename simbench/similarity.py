from abc import abstractmethod
from dataclasses import dataclass
import io
import math
from typing import Protocol
from pathlib import Path
import time
from .data import (
    DISTANCE_SCHEMA,
    File,
    COMP_CLASS_SCHEMA,
    COMP_FILE_SCHEMA,
    METRIC_SCHEMA,
)

from loguru import logger
import polars as pl
import zstd
import gzip
import zstandard
import zlib
from indicatif import ProgressBar, ProgressStyle


class Compress(Protocol):
    compression_lvl: int

    @abstractmethod
    def __call__(self, file: bytes, out: io.BytesIO) -> None:
        pass

    @abstractmethod
    def name(self) -> str:
        pass


class Zstd:
    compression_lvl: int

    def __init__(self, compression_lvl):
        self.compression_lvl = compression_lvl

    def __call__(self, file: bytes, out: io.BytesIO) -> None:
        assert self.compression_lvl in range(1, 20), (
            f"Compression level {self.compression_lvl} is out of range"
        )
        out.write(zstd.compress(file, self.compression_lvl))

    def name(self) -> str:
        return "zstd"

    def __post_init__(self):
        assert isinstance(self.compression_lvl, int)


class Zstandard:
    compression_lvl: int

    def __init__(self, compression_lvl):
        self.compression_lvl = compression_lvl

    def __call__(self, file: bytes, out: io.BytesIO) -> None:
        assert self.compression_lvl in range(1, 20), (
            f"Compression level {self.compression_lvl} is out of range"
        )
        out.write(zstandard.compress(file, self.compression_lvl))

    def name(self) -> str:
        return "zstandard"

    def __post_init__(self):
        assert isinstance(self.compression_lvl, int)


class Zlib:
    compression_lvl: int

    def __init__(self, compression_lvl):
        self.compression_lvl = compression_lvl

    def __call__(self, file: bytes, out: io.BytesIO) -> None:
        assert self.compression_lvl in range(1, 20), (
            f"Compression level {self.compression_lvl} is out of range"
        )
        out.write(zlib.compress(file, self.compression_lvl))

    def name(self) -> str:
        return "zlib"

    def __post_init__(self):
        assert isinstance(self.compression_lvl, int)


class Gzip:
    compression_lvl: int

    def __init__(self, compression_lvl):
        self.compression_lvl = compression_lvl

    def __call__(self, file: bytes, out: io.BytesIO) -> None:
        assert self.compression_lvl in range(1, 10), (
            f"Compression level {self.compression_lvl} is out of range"
        )
        out.write(gzip.compress(file, self.compression_lvl))

    def name(self) -> str:
        return "gzip"

    def __post_init__(self):
        assert isinstance(self.compression_lvl, int)


class SimilarityMetric(Protocol):
    compressor: Compress

    def __call__(self, metric_df: pl.LazyFrame) -> pl.LazyFrame:
        assert metric_df.collect_schema() == METRIC_SCHEMA, (
            "A metric dataframe must be provided to calculate metrics"
        )

        metric_df = metric_df.with_columns(
            [
                pl.lit(self.name()).alias("metric"),
                pl.lit(self.compressor.name()).alias("comp"),
                pl.lit(self.compressor.compression_lvl).alias("comp_lvl"),
            ]
        )
        metric_df = metric_df.select(
            pl.col(
                ["src", "tgt", "src_label", "tgt_label", "metric", "comp", "comp_lvl"]
            ),
            distance=self.metric_expr(),
            time=self.time_expr(),
        )

        dist_df = metric_df.sort(by="distance")
        dist_df = dist_df.with_columns(pl.col("comp_lvl").cast(pl.UInt8))
        logger.debug(dist_df.collect())

        assert dist_df.collect_schema() == DISTANCE_SCHEMA, (
            "Created distance dataframe does not conform to the schema"
        )
        return dist_df

    @abstractmethod
    def metric_expr(self) -> pl.Expr: ...

    def time_expr(self):
        return pl.col("src_time") + pl.col("tgt_time") + pl.col("srctgt_time")

    @abstractmethod
    def name(self) -> str: ...


@dataclass(frozen=True)
class NCD(SimilarityMetric):
    compressor: Compress

    def metric_expr(self) -> pl.Expr:
        return (
            (pl.col("srctgt_len") - pl.min_horizontal("src_len", "tgt_len"))
            / pl.max_horizontal("src_len", "tgt_len")
        ).cast(pl.Float32)

    def name(self):
        return "NCD"


def parse_compressor(compstr: str) -> Compress | None:
    parts = compstr.split("_")

    name = parts[0]
    clvl = 1

    if len(parts) > 1:
        assert parts[1] == "clvl", (
            f'Second part of compressor string {compstr} must be "clvl"'
        )
        clvl = int(parts[2])

    match name:
        case "zstd":
            comp = Zstd(compression_lvl=clvl)
            assert comp
            return comp
        case "gzip":
            return Gzip(compression_lvl=clvl)
        case "zstandard":
            return Zstandard(compression_lvl=clvl)
        case "zlib":
            return Zlib(compression_lvl=clvl)
        case e:
            raise ValueError(f"{e} is not a valid compressor name")


def create_metric(metric_name: str, compressor: Compress) -> SimilarityMetric | None:
    match metric_name:
        case "NCD":
            return NCD(compressor)
        case e:
            raise ValueError(f"No metric type called {e}")


def get_metric(metric_name: str, compressor_name: str) -> SimilarityMetric | None:
    comp = parse_compressor(compressor_name)
    assert comp, f"Failed to instantiate compressor from {compressor_name}"
    return create_metric(metric_name, comp)


def create_comp_file(tool: Compress, files: list[File]) -> pl.LazyFrame:
    data = {col: [] for col in COMP_FILE_SCHEMA}

    assert isinstance(files[0], File), (
        "Can only create compression overview from File list"
    )

    for src in files:
        src_bytes = src.get_bytes()

        buffer = io.BytesIO()

        starttime = time.monotonic()
        tool(src_bytes, buffer)
        complen = buffer.getbuffer().nbytes
        comptime = time.monotonic() - starttime

        data["src"].append(src.name)
        data["src_time"].append(comptime)
        data["src_len"].append(complen)
        data["src_label"].append(src.label)

    df = pl.DataFrame(data, schema=COMP_FILE_SCHEMA)
    return df.lazy()


def create_comp_class(tool: Compress, files: list[File]) -> pl.LazyFrame:
    data = {col: [] for col in COMP_CLASS_SCHEMA}

    assert isinstance(files[0], File), (
        "Can only create compression overview from File list"
    )

    pb = ProgressBar(
        len(files),
        style=ProgressStyle(
            template="{spinner:.green} [{elapsed_precise}] [{wide_bar:.cyan/blue}] {pos}/{len} ({per_sec}, {eta})",
            progress_chars="#>-",
        ),
    )
    for src in files:
        pb.inc(1)

        src_bytes = src.get_bytes()
        for tgt in files:
            tgt_bytes = tgt.get_bytes()
            concatbytes = src_bytes + tgt_bytes

            buffer = io.BytesIO()

            starttime = time.monotonic()
            tool(concatbytes, buffer)
            complen = buffer.getbuffer().nbytes
            comptime = time.monotonic() - starttime

            data["src"].append(src.name)
            data["tgt"].append(tgt.name)
            data["srctgt_time"].append(comptime)
            data["srctgt_len"].append(complen)

    df = pl.DataFrame(data, schema=COMP_CLASS_SCHEMA)
    pb.finish()
    return df.lazy()


def create_metric_df(comp_class_df, comp_file_df):
    tgt_df = comp_file_df.rename(
        {
            "src": "tgt",
            "src_len": "tgt_len",
            "src_time": "tgt_time",
            "src_label": "tgt_label",
        }
    )
    comp_file_df = comp_file_df.join(tgt_df, how="cross")

    metric_df = comp_file_df.join(comp_class_df, on=["src", "tgt"], how="inner")

    logger.debug(metric_df.collect())
    assert metric_df.collect_schema() == METRIC_SCHEMA, (
        "Failed to create metric dataframe"
    )

    return metric_df


def create_distance_file(
    metric: SimilarityMetric, comp_file_df, comp_class_df, files: list[File]
) -> pl.LazyFrame:
    assert comp_file_df.collect_schema() == COMP_FILE_SCHEMA, (
        "Can only look up compressed length in comp file dataframe"
    )

    assert comp_class_df.collect_schema() == COMP_CLASS_SCHEMA, (
        "Can only look up compressed length in comp class dataframe"
    )

    assert isinstance(files[0], File), (
        "Can only create similarity matrix from File list"
    )

    metric_df = create_metric_df(comp_class_df, comp_file_df)
    dist_df = metric(metric_df)

    return dist_df
