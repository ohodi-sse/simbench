from dataclasses import dataclass, field
import time
import functools
from pathlib import Path
import json
from typing import Callable, get_type_hints
from abc import ABC, abstractmethod
from contextlib import contextmanager
import itertools

from click import progressbar
import polars as pl
import simbench.data as data
from loguru import logger

from simbench.analysis import CompressionTool
from simbench.compressors import Compressor
from simbench.data import Source
from simbench.metrics import CompressionMetric
from simbench.classification import Classifier
from indicatif import ProgressBar, ProgressStyle


@dataclass
class Builder:
    log: logger

    @contextmanager
    def profile(self):
        starttime = endtime = time.perf_counter_ns()
        yield lambda: endtime - starttime
        endtime = time.perf_counter_ns()

    @contextmanager
    def progressbar(self, n):
        pb = ProgressBar(
            n,
            style=ProgressStyle(
                template="{spinner:.green} [{elapsed_precise}] [{wide_bar:.cyan/blue}] {pos}/{len} ({per_sec}, {eta})",
                progress_chars="#>-",
            ),
        )
        yield pb
        pb.finish()


class Pullable[A](ABC):
    @abstractmethod
    def pull(self, bld) -> A: ...


@dataclass
class Constant[A]:
    data: A

    def pull(self, bld) -> A:
        return self.data


class Store[A](ABC):
    @abstractmethod
    def load(self, bld) -> A | None: ...

    @abstractmethod
    def store(self, item: A, bld: Builder) -> int: ...


@dataclass
class JsonStore[A](Store[A], Pullable[A]):
    file: Path

    def load(self, bld):
        if self.file.exists():
            return self.pull(bld)

    def store(self, item, bld):
        self.file.write_text(json.dumps(item))

    def pull(self, bld):
        return json.loads(self.file.read_text())


@dataclass
class ByteStore[bytes](Store[bytes], Pullable[bytes]):
    file: Path

    def load(self, bld) -> bytes | None:
        if self.file.exists():
            return self.pull(self, bld)
        return

    def store(self, item: bytes, bld):
        self.file.write_bytes(item)

    def pull(self, bld) -> bytes:
        return self.file.read_bytes()


@dataclass
class SourceStore(Pullable[Source]):
    src: Source

    def pull(self, bld) -> Source:
        return self.src


@dataclass
class ParquetStore(Store[pl.LazyFrame], Pullable[pl.LazyFrame]):
    file: Path
    schema: pl.Schema

    def __post_init__(self):
        assert self.file.parent.exists(), (
            f"Cannot find {self.file.parent} at callsite {Path.cwd()}"
        )

    def load(self, bld) -> pl.LazyFrame | None:
        if self.file.exists():
            return self.pull(bld)
        return

    def store(self, item: pl.LazyFrame, bld):
        item.collect().write_parquet(self.file)
        assert self.file.exists(), f"Failed to create file {self.file}"

    def pull(self, bld) -> pl.LazyFrame:
        return pl.scan_parquet(self.file, schema=self.schema)


@dataclass
class Node[A](Pullable[A]):
    action: Callable
    store: Store[A]
    dependencies: dict[str, Pullable]

    def pull(self, bld) -> A:
        if (a := self.store.load(bld)) is not None:
            return a

        outputs = {k: dep.pull(bld) for k, dep in self.dependencies.items()}

        a = self.action(bld=bld, **outputs)
        self.store.store(a, bld=bld)

        return a

    @classmethod
    def from_action(cls, fun):
        def inner(store, **kwargs):
            return Node(fun, store, dependencies=kwargs)

        return inner


@dataclass
class Suite:
    root: Path

    def problems(self):
        return (self.root / "data").iterdir()

    def sources(self):
        return itertools.chain.from_iterable(
            (data.Source(s) for s in p.iterdir()) for p in self.problems()
        )


@dataclass
class TableBuilder:
    schema: pl.Schema
    columns: dict[str, list[object]] = field(init=False)

    def __post_init__(self):
        self.columns = {k: [] for k in self.schema.keys()}

    def add(self, **kwargs):
        assert kwargs.keys() == self.schema.keys(), (
            f"{kwargs.keys()} is not \n{self.schema.keys()}"
        )
        for k, v in kwargs.items():
            self.columns[k].append(v)

    def from_lazyframe(self, lf: pl.LazyFrame):
        assert lf.collect_schema() == self.schema
        self.columns = lf.collect().to_dict(as_series=False)

    def getvalue(self):
        return pl.LazyFrame(self.columns, schema=self.schema)


def tablenode(schema):
    def outer(fn):
        def wrapper(path, **dependencies):
            return Node(
                functools.partial(fn, schema), ParquetStore(path, schema), dependencies
            )

        return wrapper

    return outer


def schema(tabledef):
    columns = get_type_hints(tabledef)
    schema = pl.Schema(columns)
    return schema


class CompressionTable:
    src: pl.String
    src_comp: pl.UInt64
    src_size: pl.UInt64
    src_ratio: pl.Float64
    src_time: pl.UInt64
    src_label: pl.String


@tablenode(schema(CompressionTable))
def compression(schema: pl.Schema, bld: Builder, compressor: Compressor, suite: Suite):
    bld.log.info(f"{list(suite.sources())}")
    out = TableBuilder(schema)

    bld.log.info(f"Computing compression table for {compressor.name}")
    for src in suite.sources():
        src_bytes = src.get_bytes()

        with bld.profile() as timed:
            complen: int = compressor.compress_length(src_bytes)

        out.add(
            src=src.name,
            src_comp=complen,
            src_size=len(src_bytes),
            src_ratio=complen / len(src_bytes),
            src_time=timed(),
            src_label=src.label,
        )

    return out.getvalue()


class PairwiseCompressionTable:
    src: pl.String
    tgt: pl.String
    srctgt_size: pl.UInt64
    srctgt_comp: pl.UInt64
    srctgt_ratio: pl.Float64
    srctgt_time: pl.UInt64


@tablenode(schema(PairwiseCompressionTable))
def pairwise_compressions(
    schema: pl.Schema, bld: Builder, compressor: Compressor, suite: Suite
):
    out = TableBuilder(schema)

    bld.log.info(f"Computing pairwise compressions table for {compressor.name}")

    byte_lookup = {src.name: src.get_bytes() for src in suite.sources()}  # For speed

    n = len(byte_lookup) ** 2
    with bld.progressbar(n) as pb:
        for src, tgt in itertools.product(suite.sources(), repeat=2):
            pb.inc(1)
            concat_bytes = byte_lookup[src.name] + byte_lookup[tgt.name]

            with bld.profile() as timed:
                complen = compressor.compress_length(concat_bytes)

            size = len(concat_bytes)
            ratio = complen / size

            out.add(
                src=src.name,
                tgt=tgt.name,
                srctgt_comp=complen,
                srctgt_size=size,
                srctgt_ratio=ratio,
                srctgt_time=timed(),
            )

    return out.getvalue()


class DistanceTable:
    src: pl.String
    tgt: pl.String
    src_label: pl.String
    tgt_label: pl.String
    distance: pl.Float32
    time: pl.UInt64


@tablenode(schema(DistanceTable))
def distances(
    schema: pl.Schema,
    bld: Builder,
    metric: CompressionMetric,
    comp_df: pl.LazyFrame,
    compare_comp_df: pl.LazyFrame,
) -> pl.LazyFrame:
    out = TableBuilder(schema)

    bld.log.info(f"Computing distance using {metric.name}")

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

    out.from_lazyframe(metric(metric_df))

    return out.getvalue()


class ClassificationTable:
    src: pl.String
    src_label: pl.String
    classifier: pl.String
    class_param: pl.Float32
    labelled_as: pl.String


@tablenode(schema(ClassificationTable))
def classifications(
    schema: pl.Schema, bld: Builder, classifier: Classifier, distances: pl.LazyFrame
) -> pl.LazyFrame:
    out = TableBuilder(schema)
    src_df = distances.select("src", "src_label").unique(maintain_order=True)
    src_names = pl.Series(src_df.select("src").collect()).to_list()
    src_labels = pl.Series(src_df.select("src_label").collect()).to_list()

    bld.log.debug(f"Classifying using {classifier.name}-{classifier.param}")

    with bld.progressbar(len(src_names)) as pb:
        for src, label in zip(src_names, src_labels):
            pb.inc(1)
            c = classifier.classify(distances, src)
            if c is not None:
                out.add(
                    src=src,
                    src_label=label,
                    classifier=classifier.name,
                    class_param=classifier.param,
                    labelled_as=c.labelled_as,
                )

    return out.getvalue()


def comp_tool_analysis(tool: CompressionTool, classifier: Classifier, suite: Suite):
    default_path = suite.root / "results" / tool.name
    compression_file = default_path / "compressions.parquet"
    pairwise_compression_file = default_path / "pairwise_compressions.parquet"
    distance_file = default_path / "distances.parquet"
    classification_file = (
        default_path / f"{classifier.name}-{classifier.param}_classifications.parquet"
    )

    comp_node = compression(
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

    return classification_node
