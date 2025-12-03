import polars as pl
import itertools
from numpy import arange
import simbench.data as data
from indicatif import ProgressBar, ProgressStyle

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
    from simbench.classification import BestMatch, KNN, Threshold

    thrsh = [Threshold(t) for t in arange(0.0, 1.0, 0.1)]
    knn = [KNN(k) for k in range(0, 300, 30)]
    classifiers = [KNN(10)]

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

    def compressions(self, update=False) -> pl.LazyFrame:  # data.CompressionTable:
        import time

        file = self.compression_file

        if file.exists():
            df = data.CompressionTable.scan(file)
            logger.info(f"Loaded compressions from {file}")
        else:
            file.parent.mkdir(parents=True, exist_ok=True)
            df = data.CompressionTable.lazyframe()

        if update:
            changed = list(self.sources())
        else:
            changed = []
            for src in self.sources():
                if src.name in df.collect()["src"]:
                    continue
                changed.append(src)

        new = []
        for src in changed:
            src_bytes = src.get_bytes()

            # best = None
            # for _ in range(
            #     3
            # ):  # Running multiple times to warm up cache for timing results
            buffer = io.BytesIO()
            starttime = time.perf_counter_ns()
            self.tool.compressor(src_bytes, buffer)
            complen = buffer.getbuffer().nbytes
            comptime = time.perf_counter_ns() - starttime
            # best = comptime if best is None else min(best, comptime)

            new.append(
                {
                    "src": src.name,
                    "src_time": comptime,
                    "src_comp": complen,
                    "src_size": len(src_bytes),
                    "src_ratio": complen / len(src_bytes),
                    "src_label": src.label,
                }
            )

        if not update:
            df = pl.concat([df, data.CompressionTable.lazyframe(new)])
        else:
            df = data.CompressionTable.lazyframe(new)

        if changed:
            df.collect().write_parquet(file)
            logger.success(f"Wrote data to {file}")

        assert df.collect_schema() == data.CompressionTable.schema(), (
            f"{df.collect_schema()}\n does not adhere to the compression schema:\n{data.CompressionTable.schema()}"
        )

        return df

    def pairwise_compressions(self, update=False) -> pl.LazyFrame:
        file = self.pairwise_compression_file

        changed = False
        if file.exists():
            df = data.ComparisonCompressionTable.scan(file)
            logger.info(f"Loaded pairwise compressions from {file}")
        else:
            file.parent.mkdir(parents=True, exist_ok=True)
            df = data.ComparisonCompressionTable.lazyframe()
            changed = True

        srcs = list(self.sources())

        if not update:
            logger.debug("Checking if data is updated")
            original = pl.Series(df.collect()["src"].unique()).to_list()
            if sorted(original) != sorted([src.name for src in list(self.sources())]):
                changed = True

        if update or changed:
            logger.debug("Computing pairwise compressions")
            pb = ProgressBar(
                len(srcs),
                style=ProgressStyle(
                    template="{spinner:.green} [{elapsed_precise}] [{wide_bar:.cyan/blue}] {pos}/{len} ({per_sec}, {eta})",
                    progress_chars="#>-",
                ),
            )

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

        if update:
            df.collect().write_parquet(file)
            logger.success(f"Wrote data to {file}")

        assert df.collect_schema() == data.ComparisonCompressionTable.schema(), (
            f"\n{df.collect_schema()}\n does not adhere to the compression schema:\n{data.ComparisonCompressionTable.schema()}"
        )

        return df

    def distances(
        self, comp_df: pl.LazyFrame, compare_comp_df: pl.LazyFrame, update=False
    ) -> pl.LazyFrame:
        file = self.distance_file

        dist_df = None
        if file.exists():
            dist_df = data.DistanceTable.scan(file)
            logger.info(f"Loaded distances from {file}")
        else:
            file.parent.mkdir(parents=True, exist_ok=True)
            update = True

        if not update and dist_df is not None:
            return dist_df

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


def get_performance_scores(
    distance_df: pl.LazyFrame, iterations: int = 10
) -> pl.LazyFrame:
    assert distance_df.collect_schema() == data.DistanceTable.schema

    perf = data.PerformanceTable.lazyframe()

    pb = ProgressBar(
        iterations,
        style=ProgressStyle(
            template="{spinner:.green} [{elapsed_precise}] [{wide_bar:.cyan/blue}] {pos}/{len} ({per_sec}, {eta})",
            progress_chars="#>-",
        ),
    )

    for i in range(1, 300, int(300 / iterations)):
        classifier = get_classifier(f"knn_{i}")
        assert classifier, "Failed to instantiate knn from {i}"
        class_df = create_classification_dataframe_new(distance_df, classifier)
        perf_tmp = get_performance_scikit(class_df)

        perf = pl.concat([perf, perf_tmp])
        pb.inc(1)

    pb.finish()

    pb = ProgressBar(
        iterations,
        style=ProgressStyle(
            template="{spinner:.green} [{elapsed_precise}] [{wide_bar:.cyan/blue}] {pos}/{len} ({per_sec}, {eta})",
            progress_chars="#>-",
        ),
    )

    for i in arange(0.0, 1.0, 1.0 / iterations):
        try:
            classifier = get_classifier(f"thr_{round(i, 3)}")
            assert classifier, "Failed to instantiate threshold from {i}"
            class_df = create_classification_dataframe_new(distance_df, classifier)
            perf_tmp = get_performance_scikit(class_df)

            perf = pl.concat([perf, perf_tmp])

            pb.inc(1)
        except:
            logger.debug(f"Failed to classify for threshold {i}")
            pb.inc(1)

    pb.finish()
    logger.debug(perf.collect())
    return perf
