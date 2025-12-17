from typing import Sequence, get_type_hints
import polars as pl
import itertools
from numpy import arange
import simbench.data as data

from contextlib import contextmanager

from dataclasses import dataclass, field
from abc import ABC, abstractmethod
from simbench.compressors import Compressor
from simbench.metrics import CompressionMetric
from pathlib import Path
import time
from loguru import logger

import simbench.classification as cl

Logger = type(logger)


@dataclass
class Tool(ABC):
    @property
    @abstractmethod
    def name(self) -> str: ...

    def matches(self, match):
        import re

        return re.fullmatch(match, self.name) is not None


@dataclass
class CompressionTool(Tool):
    metric: CompressionMetric
    compressor: Compressor

    @property
    def name(self):
        return f"{self.compressor.name}-{self.compressor.level}-{self.metric.name}"


def get_all_tools():
    from simbench.compressors import Zstd, Gzip, Zlib
    from simbench.metrics import NCD

    compressors = [Zstd(1), Gzip(1), Zlib(1)]
    metrics = [NCD()]

    tools = []
    for m in metrics:
        for c in compressors:
            tools.append(CompressionTool(m, c))

    return tools


def get_all_classifiers() -> Sequence[cl.Classifier]:
    from simbench.classification import KNN, Threshold

    # thrsh = [Threshold(t) for t in arange(0.0, 1.0, 0.1)]
    knn = [KNN(k) for k in range(0, 300, 30)]
    classifiers = [KNN(k) for k in range(10, 50, 20)]

    return classifiers


@dataclass
class Config:
    log: Logger
    tools: list[Tool] = field(default_factory=list)
    classifiers: Sequence[cl.Classifier] = field(default_factory=list)

    def __init__(self):
        self.log = logger
        self.tools = get_all_tools()
        self.classifiers = get_all_classifiers()

    @contextmanager
    def profile(self, *name):
        # self.log.debug(f"Started {'/'.join(str(a) for a in name)}")
        starttime = endtime = time.perf_counter_ns()
        yield lambda: endtime - starttime
        endtime = time.perf_counter_ns()
        # self.log.debug(f"Stopped {'/'.join(str(a) for a in name)} took {endtime}")


@dataclass
class Analysis:
    suite: Path
    tool: CompressionTool

    @property
    def path(self):
        return self.suite / "results" / self.tool.name

    @property
    def compression_file(self):
        return self.path / "compressions.parquet"

    @property
    def pairwise_compression_file(self):
        return self.path / "pairwise_compressions.parquet"

    @property
    def distance_file(self):
        return self.path / "distances.parquet"

    def problems(self):
        return (self.suite / "data").iterdir()

    def sources(self):
        return itertools.chain.from_iterable(
            (data.Source(s) for s in p.iterdir()) for p in self.problems()
        )

    def compressions(self, cfg: Config, update: bool = False):
        compression = CompressionTable(self)
        if self.compression_file.exists() and not update:
            comp_df = pl.scan_parquet(self.compression_file)
        else:
            comp_df = compression.compute(cfg)

        if update:
            comp_df.collect().write_parquet(self.compression_file)

        return comp_df

    def pairwise_compressions(self, cfg: Config, update: bool = False):
        pair_comp = PairwiseCompressionTable(self)
        if self.pairwise_compression_file.exists() and not update:
            pair_comp_df = pl.scan_parquet(self.pairwise_compression_file)
        else:
            pair_comp_df = pair_comp.compute(cfg)

        if update:
            pair_comp_df.collect().write_parquet(self.pairwise_compression_file)
        print(update)
        print(pair_comp_df.collect())
        return pair_comp_df

    def distances(
        self,
        comp_df: pl.LazyFrame,
        pair_comp_df: pl.LazyFrame,
        update: bool = False,
    ):
        if self.distance_file.exists() and not update:
            dist_df = pl.scan_parquet(self.distance_file)
        else:
            dist_df = DistanceTable(self)
            dist_df = dist_df.compute(comp_df, pair_comp_df)

        if update:
            dist_df.collect().write_parquet(self.distance_file)

        return dist_df


class Table(ABC):
    @classmethod
    @abstractmethod
    def schema(cls) -> pl.Schema: ...

    @classmethod
    def scan(cls, *args, **kwargs):
        return pl.scan_parquet(*args, schema=cls.schema(), **kwargs)

    @classmethod
    def dataframe(cls, *args, **kwargs):
        return pl.DataFrame(*args, schema=cls.schema(), **kwargs)

    @classmethod
    def lazyframe(cls, *args, **kwargs):
        return pl.LazyFrame(*args, schema=cls.schema(), **kwargs)


# class CompressionTable(Data):
#     src: pl.String
#     src_comp: pl.UInt64
#     src_size: pl.UInt64
#     src_ratio: pl.Float64
#     src_time: pl.UInt64
#     src_label: pl.String
#
#     @classmethod
#     def builder(cls, compute):
#         pass
#
# @CompressionTable.builder
# def compute_compression(suite : Suite, compressor: Compressor, config: Config) -> pl.LazyFrame:
#


@dataclass
class CompressionTable(Table):
    analysis: Analysis

    @classmethod
    def schema(cls) -> pl.Schema:
        return pl.Schema(
            {
                "src": pl.String,
                "src_comp": pl.UInt64,
                "src_size": pl.UInt64,
                "src_ratio": pl.Float64,
                "src_time": pl.UInt64,
                "src_label": pl.String,
            }
        )

    def compute_row(self, src: data.Source, cfg: Config):
        src_bytes = src.get_bytes()

        with cfg.profile(
            "compress", self.analysis.tool.compressor.name, src.name
        ) as timed:
            complen = self.analysis.tool.compressor.compress_length(src_bytes)

        return {
            "src": src.name,
            "src_comp": complen,
            "src_size": len(src_bytes),
            "src_ratio": complen / len(src_bytes),
            "src_time": timed(),
            "src_label": src.label,
        }

    def compute(self, cfg: Config):
        rows = [self.compute_row(src, cfg) for src in self.analysis.sources()]
        data_dict = {k: [] for k, _ in self.schema().items()}
        for row in rows:
            for k, v in row.items():
                data_dict[k].append(v)

        return self.lazyframe(data_dict)


@dataclass
class PairwiseCompressionTable(Table):
    analysis: Analysis

    @classmethod
    def schema(cls) -> pl.Schema:
        return pl.Schema(
            {
                "src": pl.String,
                "tgt": pl.String,
                "srctgt_size": pl.UInt64,
                "srctgt_comp": pl.UInt64,
                "srctgt_ratio": pl.Float64,
                "srctgt_time": pl.UInt64,
            }
        )

    def compute_row(
        self,
        src: data.Source,
        tgt: data.Source,
        byte_lookup: dict[str, bytes],
        cfg: Config,
    ):
        concat_bytes = byte_lookup[src.name] + byte_lookup[tgt.name]

        with cfg.profile(
            "paircompress", self.analysis.tool.compressor.name, src.name, tgt.name
        ) as timed:
            complen = self.analysis.tool.compressor.compress_length(concat_bytes)

        size = len(concat_bytes)
        ratio = complen / size
        return {
            "src": src.name,
            "tgt": tgt.name,
            "srctgt_comp": complen,
            "srctgt_size": size,
            "srctgt_ratio": ratio,
            "srctgt_time": timed(),
        }

    def compute(self, cfg: Config):
        byte_lookup = {
            src.name: src.get_bytes() for src in self.analysis.sources()
        }  # For speed

        srcs = list(self.analysis.sources())
        pb = data.get_progressbar(len(byte_lookup))
        data_list = []

        for src in srcs:
            pb.inc(1)
            for tgt in srcs:
                data_list.append(self.compute_row(src, tgt, byte_lookup, cfg))

        data_dict = {k: [] for k, _ in self.schema().items()}
        for row in data_list:
            for k, v in row.items():
                data_dict[k].append(v)

        pb.finish()

        return self.lazyframe(data_dict)


@dataclass
class DistanceTable(Table):
    analysis: Analysis

    @classmethod
    def schema(cls) -> pl.Schema:
        return pl.Schema(
            {
                "src": pl.String,
                "tgt": pl.String,
                "src_label": pl.String,
                "tgt_label": pl.String,
                "distance": pl.Float32,
                "time": pl.UInt64,
            }
        )

    def compute(
        self, comp_df: pl.LazyFrame, compare_comp_df: pl.LazyFrame
    ) -> pl.LazyFrame:
        tgt_df = comp_df.rename(
            {
                "src": "tgt",
                "src_comp": "tgt_comp",
                "src_size": "tgt_size",
                "src_time": "tgt_time",
                "src_ratio": "tgt_ratio",
                "src_label": "tgt_label",
            }
        )
        comp_file_df = comp_df.join(tgt_df, how="cross")
        metric_df = comp_file_df.join(compare_comp_df, on=["src", "tgt"], how="inner")
        dist_df = self.analysis.tool.metric(metric_df)

        return dist_df


class ClassificationTable(Table):
    analysis: Analysis

    @classmethod
    def schema(cls) -> pl.Schema:
        return pl.Schema(
            {
                "src": pl.String,
                "src_label": pl.String,
                "classifier": pl.String,
                "class_param": pl.Float32,
                "labelled_as": pl.String,
            }
        )


#### EXPERIMENTAL ######


def extract_bad_matches(
    dist_df: pl.LazyFrame, class_df: pl.LazyFrame
) -> list[tuple[str, str]]:
    assert dist_df.collect_schema() == data.DistanceTable.schema, (
        "Can only extract bad matches from distance file"
    )

    total_df = dist_df.join(class_df, on=["src", "tgt"])
    expr = (pl.col("src_label") != pl.col("labelled_as")) & (
        pl.col("src") != pl.col("tgt")
    )
    bad_srcs = pl.Series(class_df.filter(expr).select("src").collect()).to_list()

    total_df.filter(expr).sort(by="distance", descending=True).select(
        "src", "tgt"
    ).collect()

    logger.debug(bad_matches)

    return bad_matches
