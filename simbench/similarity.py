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
    AnalysisSimDF,
    SIMILARITIES_SCHEMA,
    COMP_CLASS_SCHEMA,
    COMP_FILE_SCHEMA,
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

    @abstractmethod
    def __call__(self, len_src: int, len_tgt: int, len_src_tgt: int) -> float: ...

    @abstractmethod
    def name(self) -> str: ...


@dataclass(frozen=True)
class NCD(SimilarityMetric):
    compressor: Compress

    def __call__(self, len_src: int, len_tgt: int, len_src_tgt: int) -> float:
        return (len_src_tgt - min(len_src, len_tgt)) / max(len_src, len_tgt)

    # def polars_expr(self, distances: pl.LazyFrame) -> pl.LazyFrame:
    #     assert distances.collect_schema() == DISTANCE_SCHEMA

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


def metric(metric_name: str, compressor: Compress) -> SimilarityMetric | None:
    match metric_name:
        case "NCD":
            return NCD(compressor)
        case e:
            raise ValueError(f"No metric type called {e}")


def get_metric(metric_name: str, compressor_name: str) -> SimilarityMetric | None:
    comp = parse_compressor(compressor_name)
    assert comp, f"Failed to instantiate compressor from {compressor_name}"
    return metric(metric_name, comp)


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
        data["time"].append(comptime)
        data["complen"].append(complen)

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
            data["time"].append(comptime)
            data["complen"].append(complen)

    df = pl.DataFrame(data, schema=COMP_CLASS_SCHEMA)
    pb.finish()
    return df.lazy()


def lookup_compressed_file_len(
    src: str, comp_file_df: pl.LazyFrame
) -> tuple[int, float]:
    df = comp_file_df.filter(pl.col("src") == src).select("complen", "time").collect()

    complen = df["complen"][0]
    timed = df["time"][0]

    assert isinstance(complen, int)
    assert isinstance(timed, float)

    return complen, timed


def lookup_compressed_concat_len(
    src: str, tgt: str, comp_class_df: pl.LazyFrame
) -> tuple[int, float]:
    df = (
        comp_class_df.filter((pl.col("src") == src) & (pl.col("tgt") == tgt))
        .select("complen", "time")
        .collect()
    )
    complen = df["complen"][0]
    timed = df["time"][0]

    assert isinstance(complen, int)
    assert isinstance(timed, float)

    return complen, timed


def create_distance_file_polars(
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

    src_df = comp_file_df.rename({"complen": "alen", "time": "atime"})
    tgt_df = comp_file_df.rename({"src": "tgt", "complen": "blen", "time": "btime"})
    comp_file_df = src_df.join(tgt_df, how="cross")

    joined_df = comp_file_df.join(comp_class_df, on=["src", "tgt"], how="inner")

    metric_expr = (
        (pl.col("complen") - pl.min_horizontal("alen", "blen"))
        / pl.max_horizontal("alen", "blen")
    ).cast(pl.Float32)
    time_expr = (pl.col("atime") + pl.col("btime") + pl.col("time")).cast(pl.Float32)

    size = joined_df.collect().height
    data = {col: [] for col in DISTANCE_SCHEMA if col != "distance" and col != "time"}
    data["metric"] = [metric.name()] * size
    data["comp"] = [metric.compressor.name()] * size
    data["comp_lvl"] = [metric.compressor.compression_lvl] * size

    for src in files:
        for tgt in files:
            data["src"].append(src.name)
            data["src_label"].append(src.label)

            data["tgt"].append(tgt.name)
            data["tgt_label"].append(tgt.label)

    calc_df = joined_df.select(
        pl.col("src", "tgt"),
        distance=metric_expr,
        time=time_expr,
    )

    data_df = pl.LazyFrame(data)

    dist_df = data_df.join(calc_df, on=["src", "tgt"]).sort(by="distance")
    dist_df = dist_df.with_columns(pl.col("comp_lvl").cast(pl.UInt8))

    assert dist_df.collect_schema() == DISTANCE_SCHEMA, (
        "Created distance dataframe does not conform to the schema"
    )

    return dist_df


def create_distance_file(
    metric: SimilarityMetric, comp_file_df, comp_class_df, files: list[File]
) -> pl.LazyFrame:
    data = {col: [] for col in DISTANCE_SCHEMA}
    assert comp_file_df.collect_schema() == COMP_FILE_SCHEMA, (
        "Can only look up compressed length in comp file dataframe"
    )

    assert comp_class_df.collect_schema() == COMP_CLASS_SCHEMA, (
        "Can only look up compressed length in comp class dataframe"
    )

    assert isinstance(files[0], File), (
        "Can only create similarity matrix from File list"
    )
    lookup = {
        src.name: lookup_compressed_file_len(src.name, comp_file_df) for src in files
    }

    pb = ProgressBar(
        int(math.pow(len(files), 2)),
        style=ProgressStyle(
            template="{spinner:.green} [{elapsed_precise}] [{wide_bar:.cyan/blue}] {pos}/{len} ({per_sec}, {eta})",
            progress_chars="#>-",
        ),
    )

    for src in files:
        src_len, t1 = lookup[src.name]
        for tgt in files:
            pb.inc(1)
            data["src"].append(src.name)
            data["src_label"].append(src.label)

            data["tgt"].append(tgt.name)
            data["tgt_label"].append(tgt.label)

            data["metric"].append(metric.name())
            data["comp"].append(metric.compressor.name())
            data["comp_lvl"].append(metric.compressor.compression_lvl)

            tgt_len, t2 = lookup[tgt.name]

            src_tgt_len, t3 = lookup_compressed_concat_len(
                src.name, tgt.name, comp_class_df
            )

            dist = metric(src_len, tgt_len, src_tgt_len)
            data["distance"].append(dist)
            data["time"].append(t1 + t2 + t3)

    df = pl.DataFrame(data, schema=DISTANCE_SCHEMA).sort(by="distance")
    pb.finish()
    return df.lazy()
