from __future__ import annotations
import hashlib
from simbench.AI_tools import CodeBERT, GraphCodeBERT, Code2Vec

from typing import Sequence
from contextlib import contextmanager
from numpy import arange
import sys

from dataclasses import dataclass, field
from abc import ABC, abstractmethod


from simbench.compressors import Compressor, Diff, EditDistanceDiff
from simbench.metrics import (
    Metric,
    NormalizedDiffMetric,
    SummedDiffMetric,
    NormalizedCosine,
)
import time

import loguru
from loguru import logger

from simbench.build import (
    Normalizer,
    Suite,
    Constant,
)
from simbench.classification import Classifier
from simbench.normalizers import (
    IDNormalizer,
    GoogleFormatter,
    DecompileWOImports,
    DecompileNormalizer,
    OptimizedDecompiledNormalizer,
    HashedProblemLabel,
    PartitionedProblemClasses,
    DecompileFixedImports,
    TokenNormalizer,
    IdentifierNoSemantics,
    DecompiledFormatted,
)

from simbench.tables import (
    compressions,
    pairwise_compressions,
    comp_distances,
    diff_distances,
    pairwise_diff,
    classifications,
    performance,
    evaluation,
)
from simbench.plots import (
    classification_overview_figure,
    fscore_overview_figure,
    fscore_comparison_figure,
)


@dataclass
class Tool(ABC):
    metric: Metric

    @property
    @abstractmethod
    def tool_name(self) -> str: ...

    @property
    def similarity_name(self) -> str:
        return self.metric.name

    @property
    def name(self) -> str:
        return f"{self.tool_name}_{self.similarity_name}"

    def matches(self, match):
        import re

        return re.match(match, self.name) is not None


@dataclass
class CompressionTool(Tool):
    compressor: Compressor

    @property
    def tool_name(self):
        return f"{self.compressor.name}-{self.compressor.level}"


@dataclass
class DiffTool(Tool):
    diff: Diff

    @property
    def tool_name(self):
        return self.diff.name


@dataclass
class AITool(Tool):
    from simbench.build import NamedCallable

    AItool: NamedCallable

    @property
    def tool_name(self):
        return f"{self.AItool.name}"

    def __call__(self):
        return self.AItool


def get_all_tools():
    from simbench.compressors import Zstd, Gzip, Zlib, Difflib
    from simbench.metrics import NCD
    from simbench.metrics import DiffMetric

    comp_lvls = [1, 9]
    zlib = [Zlib(comp_lvl) for comp_lvl in comp_lvls]
    gzip = [Gzip(comp_lvl) for comp_lvl in comp_lvls]
    zstd = [Zstd(comp_lvl) for comp_lvl in comp_lvls]

    compressors = gzip + zstd + zlib
    comp_metrics = [NCD()]

    comp_tools = [CompressionTool(m, c) for c in compressors for m in comp_metrics]
    diff_tools = [
        DiffTool(NormalizedDiffMetric(), EditDistanceDiff()),
        DiffTool(DiffMetric(), EditDistanceDiff()),
        DiffTool(SummedDiffMetric(), EditDistanceDiff()),
    ]  # BSDiff is veeeery slooow
    # other_tools = [GenericTool(GenericMetric(), Difflib())]
    ai_tools = [
        AITool(NormalizedCosine(), CodeBERT()),
        AITool(NormalizedCosine(), GraphCodeBERT()),
        AITool(NormalizedCosine(), Code2Vec()),
    ]

    return diff_tools + comp_tools + ai_tools


def get_all_classifiers(steps: int = 20) -> Sequence[Classifier]:
    from simbench.classification import KNN, Threshold

    thrsh = [Threshold(round(t, 3)) for t in arange(0.05, 1.0, 1.0 / steps)]
    knn = [KNN(k) for k in range(1, 300, int(301 / steps))]

    thrsh = [Threshold(0.5)]
    knn = [KNN(1)]
    return thrsh + knn


def get_all_normalizers():
    return [
        IDNormalizer(),
        DecompileNormalizer(),
        OptimizedDecompiledNormalizer(),
        GoogleFormatter(),
        TokenNormalizer(),
        DecompileWOImports(),
        DecompileFixedImports(),
        HashedProblemLabel(),
        IdentifierNoSemantics(),
        DecompiledFormatted(),
        PartitionedProblemClasses(5),
        PartitionedProblemClasses(25),
    ]


@dataclass
class Config:
    log: loguru.Logger
    tools: Sequence[Tool] = field(default_factory=list)
    classifiers: Sequence[Classifier] = field(default_factory=list)
    normalizers: list[Tool] = field(default_factory=list)

    def __init__(self):
        self.log = logger
        self.log.remove(0)
        self.log.add(sys.stderr, level="DEBUG")

        self.tools = get_all_tools()
        self.classifiers = get_all_classifiers()
        self.normalizers = get_all_normalizers()

    @contextmanager
    def profile(self, *name):
        starttime = endtime = time.perf_counter_ns()
        yield lambda: endtime - starttime
        endtime = time.perf_counter_ns()


# The analysis dataclass specifies the structure of the project, and how things are stored.
@dataclass
class Analysis(ABC):
    tool: Tool
    suite: Suite
    classifiers: list[Classifier]
    normalizer: Normalizer

    def __post_init__(self):
        assert isinstance(self.suite, Suite), (
            "Must provide a Suite object when creating an Analysis object."
        )
        assert isinstance(self.tool, Tool)

    @property
    def default_path(self):
        if self.suite.seed and self.suite.n_samples:
            result_path = f"results_w_seed_{self.suite.seed}"
        else:
            result_path = "results"

        default_path = (
            self.suite.root
            / result_path
            / f"{self.normalizer.name}"
            / self.tool.tool_name
        )
        default_path.mkdir(parents=True, exist_ok=True)
        return default_path

    @property
    def with_metric_path(self):
        metric_path = self.default_path / f"{self.tool.similarity_name}"
        metric_path.mkdir(parents=True, exist_ok=True)
        return metric_path

    @property
    def parameter_name(self):
        return f"{self.normalizer.name}_{self.tool.name}"

    @property
    def distance_file(self):
        return self.with_metric_path / "distances.parquet"

    @property
    def performance_file(self):
        return self.with_metric_path / "performances.parquet"

    @property
    def classification_dir(self):
        classification_dir = self.with_metric_path / "classifications"
        classification_dir.mkdir(parents=True, exist_ok=True)

        return classification_dir

    @property
    def performance_overview_file(self):
        return self.with_metric_path / "performance_overview.pdf"

    @property
    def classification_plot_file(self):
        return self.with_metric_path / "classification_plots.pdf"

    @property
    def source_nodes(self):
        return self.normalizer.get_normalized_sources(list(self.suite.sources()))

    @property
    @abstractmethod
    def distance_node(self): ...

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

    @property
    def performance_pdf_node(self):
        return fscore_overview_figure(
            self.performance_overview_file,
            distances=self.distance_node,
            performances=self.performance_node,
            normalizer=Constant(self.normalizer),
        )

    @property
    def classification_plot(self):
        return classification_overview_figure(self.classification_plot_file)


class CompressionAnalysis(Analysis):
    def __post_init__(self):
        assert isinstance(self.tool, CompressionTool)

    @property
    def compression_file(self):
        return self.default_path / "compressions.parquet"

    @property
    def pairwise_compression_file(self):
        return self.default_path / "pairwise_compressions.parquet"

    @property
    def comp_node(self):
        assert isinstance(self.tool, CompressionTool)
        return compressions(
            self.compression_file,
            compressor=Constant(self.tool.compressor),
            sources=self.source_nodes,
        )

    @property
    def pair_node(self):
        assert isinstance(self.tool, CompressionTool)
        return pairwise_compressions(
            self.pairwise_compression_file,
            compressor=Constant(self.tool.compressor),
            sources=self.source_nodes,
        )

    @property
    def distance_node(self):
        return comp_distances(
            self.distance_file,
            metric=Constant(self.tool.metric),
            comp_df=self.comp_node,
            compare_comp_df=self.pair_node,
        )


class DiffAnalysis(Analysis):
    def __post_init__(self):
        assert isinstance(self.tool, DiffTool)

    @property
    def diff_file(self):
        return self.default_path / "diffs.parquet"

    @property
    def diff_node(self):
        assert isinstance(self.tool, DiffTool)
        return pairwise_diff(
            self.diff_file,
            diff=Constant(self.tool.diff),
            sources=self.source_nodes,
        )

    @property
    def distance_node(self):
        return diff_distances(
            self.distance_file,
            metric=Constant(self.tool.metric),
            diff_df=self.diff_node,
        )


class AIToolAnalysis(Analysis):
    def __post_init__(self):
        assert isinstance(self.tool, AITool)

    @property
    def raw_distance_file(self):
        return self.default_path / "raw_distances.parquet"

    @property
    def raw_distance_node(self):
        from simbench.tables import ai_distances

        assert isinstance(self.tool, AITool)
        return ai_distances(
            self.raw_distance_file,
            tool=Constant(self.tool.AItool),
            sources=self.source_nodes,
        )

    @property
    def distance_node(self):
        from simbench.tables import ai_similarities

        assert isinstance(self.tool, AITool)
        return ai_similarities(
            self.distance_file,
            metric=Constant(self.tool.metric),
            raw_ai_dist_df=self.raw_distance_node,
        )


def init_analysis(
    tool: Tool, suite: Suite, classifiers: list[Classifier], normalizer: Normalizer
):
    if isinstance(tool, CompressionTool):
        return CompressionAnalysis(tool, suite, classifiers, normalizer)

    if isinstance(tool, DiffTool):
        return DiffAnalysis(tool, suite, classifiers, normalizer)

    if isinstance(tool, AITool):
        return AIToolAnalysis(tool, suite, classifiers, normalizer)

    assert False, f"Unrecognized tool type: {type(tool)}"


@dataclass
class AnalysisComparison:
    suite: Suite
    tools: list[CompressionTool]
    classifiers: list[Classifier]
    normalizers: list[Normalizer]

    @property
    def analyses(self):
        analyses = [
            init_analysis(tool, self.suite, self.classifiers, normalizer)
            for tool in self.tools
            for normalizer in self.normalizers
        ]
        return {a.parameter_name: Constant(a) for a in analyses}

    @property
    def performance_comparison_pdf(self):
        return fscore_comparison_figure(
            path=self.suite.root / "results" / "performance_comparison.pdf",
            **self.analyses,
        )

    @property
    def comparison_table_file(self):
        h = hashlib.new("sha256")
        h.update("".join(self.analyses.keys()).encode("utf-8"))
        hashstr = h.hexdigest()[:16]

        return self.suite.root / "results" / f"{hashstr}_table_comparison.parquet"

    @property
    def table_comparison(self):
        return evaluation(
            self.comparison_table_file,
            **self.analyses,
        )
