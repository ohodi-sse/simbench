from typing import Sequence
import polars as pl

from contextlib import contextmanager

from dataclasses import dataclass, field
from abc import ABC, abstractmethod
from simbench.compressors import Compressor
from simbench.metrics import CompressionMetric
import time
from loguru import logger

from simbench.build import Suite, Pullable, Constant
from simbench.classification import Classifier
from simbench.tables import (
    compressions,
    pairwise_compressions,
    distances,
    classifications,
    performance,
)
from simbench.plots import plot_classification, plot_confusion_matrix, plot_fscore

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


def comp_tool_analysis(tool: CompressionTool, classifier: Classifier, suite: Suite):
    default_path = suite.root / "results" / tool.name
    default_path.mkdir(parents=True, exist_ok=True)

    compression_file = default_path / "compressions.parquet"

    pairwise_compression_file = default_path / "pairwise_compressions.parquet"

    distance_file = default_path / "distances.parquet"

    classification_dir = default_path / "classifications"
    classification_dir.mkdir(parents=True, exist_ok=True)

    classification_file = (
        classification_dir / f"{classifier.name}-{classifier.param}.parquet"
    )

    comp_node = compressions(
        compression_file,
        compressor=Constant(tool.compressor),
        suite=Constant(suite),
    )

    pair_node = pairwise_compressions(
        pairwise_compression_file,
        compressor=Constant(tool.compressor),
        suite=Constant(suite),
    )

    dist_node = distances(
        distance_file,
        metric=Constant(tool.metric),
        comp_df=comp_node,
        compare_comp_df=pair_node,
    )
    classification_node = classifications(
        classification_file, classifier=Constant(classifier), distances=dist_node
    )

    cm_node = plot_confusion_matrix(classifications=classification_node)

    cm_node = plot_classification(classifications=classification_node)

    cm_node = plot_fscore(distances=dist_node)
    return cm_node


def analyse_classifications(tool: CompressionTool, suite: Suite, **deps: Pullable):
    default_path = suite.root / "results" / tool.name
    performance_file = default_path / "performances.parquet"

    return performance(performance_file, **deps)
