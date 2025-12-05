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
import io
from loguru import logger

from simbench.classification import Classifier

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
    from simbench.compressors import Zstd, Gzip, Zstandard, Zlib
    from simbench.metrics import NCD

    compressors = [Zstd(1), Gzip(1), Zstandard(1), Zlib(1)]
    metrics = [NCD()]

    tools = []
    for m in metrics:
        for c in compressors:
            tools.append(CompressionTool(m, c))

    return tools


def get_all_classifiers():
    from simbench.classification import KNN, Threshold

    thrsh = [Threshold(t) for t in arange(0.0, 1.0, 0.1)]
    knn = [KNN(k) for k in range(0, 300, 30)]
    classifiers = [KNN(k) for k in range(10, 50, 20)]

    return classifiers


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

    def pairwise_compressions(self, update=False) -> pl.LazyFrame:
        file = self.pairwise_compression_file

        changed = False
        if file.exists():
            df = data.ComparisonCompressionTable.scan(file)
            logger.info(f"Loaded pairwise compressions from {file}")
        else:
            df = data.ComparisonCompressionTable.lazyframe()
            file.parent.mkdir(parents=True, exist_ok=True)
            changed = True

        srcs = list(self.sources())

        if not update:
            logger.debug("Checking if data is updated")
            original = pl.Series(df.collect()["src"].unique()).to_list()
            if sorted(original) != sorted([src.name for src in list(self.sources())]):
                changed = True

        if update or changed:
            logger.debug("Computing pairwise compressions")
            pb = data.get_progressbar(len(srcs))
            new = []
            byte_lookup = {src.name: src.get_bytes() for src in srcs}  # For speed
            for src in srcs:
                pb.inc(1)
                for tgt in srcs:
                    concatbytes = byte_lookup[src.name] + byte_lookup[tgt.name]

                    buffer = io.BytesIO()
                    # best = None
                    # for _ in range(
                    #     3
                    # ):  # Running multiple times to warm up cache for timing results
                    buffer = io.BytesIO()
                    starttime = time.perf_counter_ns()
                    self.tool.compressor(concatbytes, buffer)
                    complen = buffer.getbuffer().nbytes
                    comptime = time.perf_counter_ns() - starttime
                    # best = comptime if best is None else min(best, comptime)
                    size = len(concatbytes)
                    ratio = complen / size
                    new.append(
                        {
                            "src": src.name,
                            "tgt": tgt.name,
                            "srctgt_comp": complen,
                            "srctgt_size": size,
                            "srctgt_ratio": ratio,
                            "srctgt_time": comptime,
                        }
                    )

            pb.finish()

            df = data.ComparisonCompressionTable.lazyframe(new)

            assert df.collect_schema() == data.ComparisonCompressionTable.schema(), (
                f"\n{df.collect_schema()}\n does not adhere to the compression schema:\n{data.ComparisonCompressionTable.schema()}"
            )

            if update:
                df.collect().write_parquet(file)
                logger.success(f"Wrote data to {file}")

        return df

    def distances(
        self, comp_df: pl.LazyFrame, compare_comp_df: pl.LazyFrame, update=False
    ) -> pl.LazyFrame:
        file = self.distance_file

        if file.exists():
            dist_df = data.DistanceTable.scan(file)
            logger.info(f"Loaded distances from {file}")
        else:
            file.parent.mkdir(parents=True, exist_ok=True)

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

        logger.info("Calculating metrics dataframe for metrics")
        dist_df = self.tool.metric(metric_df)

        if update:
            dist_df.collect().write_parquet(file)
            logger.success(f"Wrote data to {file}")

        return dist_df


@dataclass
class Config:
    log: Logger
    tools: list[Tool] = field(default_factory=list)
    classifiers: list[Classifier] = field(default_factory=list)

    def __init__(self):
        self.log = logger
        self.tools = get_all_tools()
        self.classifiers = get_all_classifiers()

    @contextmanager
    def profile(self, *name):
        self.log.info(f"Started {'/'.join(str(a) for a in name)}")
        starttime = time.perf_counter_ns()
        timer = object()
        yield timer
        timer.time = time.perf_counter_ns() - starttime
        self.log.info(f"Stopped {'/'.join(str(a) for a in name)} took {timer.time}")


@dataclass
class Compression(data.Table):
    class Table(data.Table):
        data: pl.LazyFrame

    class Row(data.Table):
        src: pl.String
        src_comp: pl.UInt64
        src_size: pl.UInt64
        src_ratio: pl.Float64
        src_time: pl.UInt64
        src_label: pl.String

    analysis: Analysis

    def compute_row(self, src: data.Source, cfg: Config):
        src_bytes = src.get_bytes()

        with cfg.profile("compress", self.analysis.name, src.name) as p:
            complen = self.analysis.tool.compressor.compress_length(src_bytes)

        return {
            "src": src.name,
            "src_time": p.time,
            "src_comp": complen,
            "src_size": len(src_bytes),
            "src_ratio": complen / len(src_bytes),
            "src_label": src.label,
        }

    def compute(self, cfg: Config):
        return self.lazyframe(
            [self.compute_row(src, cfg) for src in self.analysis.sources()]
        )


#### EXPERIMENTAL ######


def extract_bad_matches(dist_df: pl.LazyFrame) -> list[tuple[str, str]]:
    assert dist_df.collect_schema() == data.DistanceTable.schema, (
        "Can only extract bad matches from distance file"
    )

    classifier = get_classifier("bm")
    assert classifier

    class_df = create_classification_dataframe(dist_df, classifier)
    expr = pl.col("src_label") != pl.col("labelled_as")
    bad_srcs = pl.Series(class_df.filter(expr).select("src").collect()).to_list()

    bad_srcs_list = [
        dist_df.filter((pl.col("src") == bad_src) & (pl.col("src") != pl.col("tgt")))
        .sort(by="similarity", descending=True)
        .select("src")
        .collect()
        .item(0, "src")
        for bad_src in bad_srcs
    ]

    bad_targets_list = [
        dist_df.filter((pl.col("src") == bad_src) & (pl.col("src") != pl.col("tgt")))
        .sort(by="similarity", descending=True)
        .select("target")
        .collect()
        .item(0, "target")
        for bad_src in bad_srcs
    ]

    bad_matches = [(s, t) for (s, t) in zip(bad_srcs_list, bad_targets_list)]
    logger.debug(bad_matches)

    return bad_matches
