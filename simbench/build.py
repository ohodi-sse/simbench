from dataclasses import dataclass
import time
from pathlib import Path
import json
from typing import Self, Callable
from abc import ABC, abstractmethod
from contextlib import contextmanager
import itertools

import polars as pl
import simbench.data as data
from loguru import logger

from simbench.analysis import CompressionTool, Config
from simbench.compressors import Compressor
from simbench.data import Source


@dataclass
class Builder:
    log: logger

    @contextmanager
    def profile(self, *message):
        # self.log.info(f"Started {'/'.join(str(m) for m in message)}")
        starttime = endtime = time.perf_counter_ns()
        yield lambda: endtime - starttime
        endtime = time.perf_counter_ns()
        # self.log.info(f"Done with {'/'.join(str(m) for m in message)}")


class Pullable[A](ABC):
    @abstractmethod
    def pull(self, bld) -> A: ...


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
            return json.loads(self.file.read_text())

    def pull(self, bld):
        return json.loads(self.file.read_text())

    def store(self, item, bld):
        return self.file.write_text(json.dumps(item))


@dataclass
class ByteStore[bytes](Store[bytes], Pullable[bytes]):
    file: Path

    def load(self, bld) -> bytes | None:
        if self.file.exists():
            return self.file.read_bytes()
        return

    def pull(self, bld) -> bytes:
        return self.file.read_bytes()

    def store(self, item: bytes, bld):
        return self.file.write_bytes(item)


@dataclass
class SourceStore[Source](Store[Source], Pullable[Source]):
    src: Source

    def load(self, bld) -> Source | None:
        if self.src.path.exists():
            return self.src
        return

    def pull(self, bld) -> Source:
        return self.src

    def store(self, item: bytes, bld):
        return self.src.path.write_bytes(item)


@dataclass
class ParquetStore[LazyFrame](Store[LazyFrame], Pullable[LazyFrame]):
    file: Path
    schema: pl.Schema

    def load(self, bld) -> LazyFrame | None:
        if self.file.exists():
            return pl.scan_parquet(self.file, schema=self.schema)
        return

    def pull(self, bld):
        return pl.LazyFrame(self.file)

    def store(self, item, bld):
        return self.file.write_text(json.dumps(item))


@dataclass
class Node[A](Pullable[A]):
    action: Callable
    store: Store[A]
    dependencies: dict[str, Pullable]

    def pull(self, bld) -> A:
        if (a := self.store.load(bld)) is not None:
            print(f"Found file: {self.store.file}")
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


@Node.from_action
def the_answer(bld: Builder) -> int:
    with bld.profile("compute the answer"):
        return 42


answer = the_answer(JsonStore(Path("the_answer.json")))

bld = Builder(logger)

bs = ByteStore(Path("flake.nix"))


@Node.from_action
def lines(bld: Builder, file: Pullable[bytes]) -> int:
    with bld.profile("reading the lines of the file"):
        return len(file.pull(bld).splitlines())


node = lines(JsonStore(Path("lines.json")), file={"flake.nix": bs})

# print(node.pull(bld))


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
                (s.name : Sour for s in p.iterdir()) for p in self.problems()
        )

    def get_comp_node(self, bld: Builder):
        comp_st = ParquetStore(
            self.compression_file, pl.Schema(data.CompressionTable.schema())
        )

        dependencies = {s.name: SourceStore(data.Source(s)) for s in self.sources()}

        @Node.from_action
        def comp(bld, **kwargs):
            compute_compression(bld, self.tool, **kwargs)

        return comp(comp_st, **dependencies)

    def get_pair_node(self, bld: Builder):
        pair_st = ParquetStore(
            self.pairwise_compression_file,
            pl.Schema(data.ComparisonCompressionTable.schema()),
        )

        @Node.from_action
        def pairwise(bld, **kwargs):
            compute_pairwise_compressions(bld, self.tool, **kwargs)

        pairwise_node = pairwise(pair_st, **dependencies)

        dist_deps = {"comp_df": comp_node, "compare_comp_df": pairwise_node}

        @Node.from_action
        def dist(bld, **kwargs):
            compute_distance(bld, self.tool, **kwargs)

        dist_st = ParquetStore(
            self.distance_file, pl.Schema(data.DistanceTable.schema())
        )

        dist_node = dist(dist_st, **dist_deps)

        return comp_node, pairwise_node, dist_node


def compute_compression(
    bld: Builder,
    tool: CompressionTool,
    **kwargs,
):
    compressor = tool.compressor

    schema = pl.Schema(
        {
            "src": pl.String(),
            "src_comp": pl.UInt64(),
            "src_size": pl.UInt64(),
            "src_ratio": pl.Float64(),
            "src_time": pl.UInt64(),
            "src_label": pl.String(),
        }
    )

    def compute_row(src: data.Source):
        src_bytes = src.get_bytes()

        with bld.profile("compress", compressor.name, src.name) as timed:
            complen: int = compressor.compress_length(src_bytes)

        return {
            "src": src.name,
            "src_comp": complen,
            "src_size": len(src_bytes),
            "src_ratio": complen / len(src_bytes),
            "src_time": timed(),
            "src_label": src.label,
        }

    rows = [compute_row(src) for k, src in kwargs.items()]
    data_dict = {k: [] for k, _ in schema.items()}

    for row in rows:
        for k, v in row.items():
            data_dict[k].append(v)

    return data_dict


def compute_pairwise_compressions(bld: Builder, tool: CompressionTool, **kwargs):
    compressor = tool.compressor
    schema = pl.Schema(
        {
            "src": pl.String(),
            "tgt": pl.String(),
            "srctgt_size": pl.UInt64(),
            "srctgt_comp": pl.UInt64(),
            "srctgt_ratio": pl.Float64(),
            "srctgt_time": pl.UInt64(),
        }
    )

    def compute_row(
        bld: Builder,
        src: data.Source,
        tgt: data.Source,
        byte_lookup: dict[str, bytes],
    ):
        concat_bytes = byte_lookup[src.name] + byte_lookup[tgt.name]

        with bld.profile("paircompress", compressor.name, src.name, tgt.name) as timed:
            complen = compressor.compress_length(concat_bytes)

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

    sources = [v for _, v in kwargs.items()]
    byte_lookup = {src.name: src.get_bytes() for src in sources}  # For speed

    pb = data.get_progressbar(len(byte_lookup))
    data_list = []

    for src in sources:
        pb.inc(1)
        for tgt in sources:
            data_list.append(compute_row(bld, src, tgt, byte_lookup))

    data_dict = {k: [] for k, _ in schema.items()}
    for row in data_list:
        for k, v in row.items():
            data_dict[k].append(v)

    pb.finish()

    return data_dict


def compute_distance(
    bld: Builder,
    tool: CompressionTool,
    comp_df: pl.LazyFrame,
    compare_comp_df: pl.LazyFrame,
) -> pl.LazyFrame:
    schema = pl.Schema(
        {
            "src": pl.String,
            "tgt": pl.String,
            "src_label": pl.String,
            "tgt_label": pl.String,
            "distance": pl.Float32,
            "time": pl.UInt64,
        }
    )

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
    dist_df = tool.metric(metric_df)

    return dist_df
