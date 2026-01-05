from typing import Sequence
import polars as pl

from contextlib import contextmanager

from dataclasses import dataclass, field
from abc import ABC, abstractmethod
from simbench.compressors import Compressor
from simbench.metrics import CompressionMetric
import time
from loguru import logger

from simbench.build import Suite, Constant
from simbench.classification import Classifier
from simbench.tables import (
    compressions,
    pairwise_compressions,
    distances,
    classifications,
    performance,
)

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


def get_all_classifiers() -> Sequence[Classifier]:
    from simbench.classification import KNN, Threshold

    # thrsh = [Threshold(t) for t in arange(0.0, 1.0, 0.1)]
    knn = [KNN(k) for k in range(0, 300, 30)]
    classifiers = [KNN(k) for k in range(10, 50, 20)]

    return classifiers


@dataclass
class Config:
    log: Logger
    tools: list[Tool] = field(default_factory=list)
    classifiers: Sequence[Classifier] = field(default_factory=list)

    def __init__(self):
        self.log = logger
        self.tools = get_all_tools()
        self.classifiers = get_all_classifiers()

    @contextmanager
    def profile(self, *name):
        starttime = endtime = time.perf_counter_ns()
        yield lambda: endtime - starttime
        endtime = time.perf_counter_ns()


@dataclass
class Analysis:
    tool: CompressionTool
    suite: Suite
    classifiers: list[Classifier]

    @property
    def default_path(self):
        default_path = self.suite.root / "results" / self.tool.name
        default_path.mkdir(parents=True, exist_ok=True)
        return default_path

    @property
    def compression_file(self):
        return self.default_path / "compressions.parquet"

    @property
    def pairwise_compression_file(self):
        return self.default_path / "pairwise_compressions.parquet"

    @property
    def distance_file(self):
        return self.default_path / "distances.parquet"

    @property
    def performance_file(self):
        return self.default_path / "performances.parquet"

    @property
    def classification_dir(self):
        classification_dir = self.default_path / "classifications"
        classification_dir.mkdir(parents=True, exist_ok=True)

        return classification_dir

    @property
    def comp_node(self):
        return compressions(
            self.compression_file,
            compressor=Constant(self.tool.compressor),
            suite=Constant(self.suite),
        )

    @property
    def pair_node(self):
        return pairwise_compressions(
            self.pairwise_compression_file,
            compressor=Constant(self.tool.compressor),
            suite=Constant(self.suite),
        )

    @property
    def distance_node(self):
        return distances(
            self.distance_file,
            metric=Constant(self.tool.metric),
            comp_df=self.comp_node,
            compare_comp_df=self.pair_node,
        )

    @property
    def classification_nodes(self):
        nodes = {}
        for classifier in self.classifiers:
            classification_file = (
                self.classification_dir
                / f"{classifier.name}-{classifier.param}.parquet"
            )
            nodes[f"{classifier.name}-{classifier.param}"] = classifications(
                classification_file,
                classifier=Constant(classifier),
                distances=self.distance_node,
            )

        return nodes

    @property
    def performance_node(self):
        return performance(self.performance_file, **self.classification_nodes)
