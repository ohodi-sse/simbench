from dataclasses import dataclass, field
import time
from pathlib import Path
import json
from typing import Self, Callable, get_type_hints
from abc import ABC, abstractmethod
from contextlib import contextmanager
import itertools

import polars as pl
import simbench.data as data
from loguru import logger

from simbench.analysis import CompressionTool, Config
from simbench.compressors import Compressor, Zstd
from simbench.data import Source


@dataclass
class Builder:
    log: logger

    @contextmanager
    def profile(self, *message):
        #self.log.info(f"Started {'/'.join(str(m) for m in message)}")
        starttime = endtime = time.perf_counter_ns()
        yield lambda: endtime - starttime
        endtime = time.perf_counter_ns()
        #self.log.info(f"Done with {'/'.join(str(m) for m in message)}")


class Pullable[A](ABC):
    @abstractmethod
    def pull(self, bld) -> A: ...

@dataclass
class Constant[A]:
    data : A

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
        assert self.file.parent.exists(), self.file.parent

    def load(self, bld) -> pl.LazyFrame | None:
        if self.file.exists():
            return self.pull(bld)
        return
    
    def store(self, item : pl.LazyFrame, bld):
        item.collect().write_parquet(self.file)

    def pull(self, bld):
        return pl.scan_parquet(self.file, schema=self.schema)



@dataclass
class Node[A](Pullable[A]):
    action: Callable
    store: Store[A]
    dependencies: dict[str, Pullable]

    def pull(self, bld) -> A:
        if (a := self.store.load(bld)) is not None:
            bld.log.debug(f"Found file: {self.store.file}")
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


#
#      src 
#       |
#  [ compression ]
#

@dataclass
class Suite:
    root: Path
    
    def problems(self):
        return (self.root / "data").iterdir()

    def sources(self):
        return itertools.chain.from_iterable(
                (data.Source(s) for s in p.iterdir()) for p in self.problems()
        )

class Table(ABC):
    @classmethod
    def schema(cls):
        return get_type_hints(cls)

    @classmethod
    def scan(cls, *args, **kwargs):
        return pl.scan_parquet(*args, schema=cls.schema(), **kwargs)

    @classmethod
    def dataframe(cls, *args, **kwargs):
        return pl.DataFrame(*args, schema=cls.schema(), **kwargs)

    @classmethod
    def lazyframe(cls, *args, **kwargs):
        return pl.LazyFrame(*args, schema=cls.schema(), **kwargs)


@dataclass
class TableBuilder[T]:
    schema: T
    columns: dict[str, list[object]] = field(init=False)

    def __post_init__(self):
        self.columns = { k : [] for k in self.schema.columns().keys() }

    def add(self, **kwargs):
        assert kwargs.keys() == self.schema.columns().keys(), kwargs
        for k, v in kwargs.items():
            self.columns[k].append(v)

    def getvalue(self):
        return pl.LazyFrame(self.columns, schema=self.schema.schema())

class CompressionSchema:
    src: pl.String()
    src_comp: pl.UInt64()
    src_size: pl.UInt64()
    src_ratio: pl.Float64()
    src_time: pl.UInt64()
    src_label: pl.String()
    
    @classmethod
    def schema(cls):
        return pl.Schema(cls.columns())
    
    @classmethod
    def columns(cls):
        return get_type_hints(cls)




def compression(bld : Builder, compressor : Compressor, suite: Suite):

    out = TableBuilder(CompressionSchema())

    for src in suite.sources():
        src_bytes = src.get_bytes()

        with bld.profile("compress", compressor.name, src.name) as timed:
            complen: int = compressor.compress_length(src_bytes)

        out.add(
            src= src.name,
            src_comp= complen,
            src_size=  len(src_bytes),
            src_ratio= complen / len(src_bytes),
            src_time= timed(),
            src_label= src.label,
        )

    return out.getvalue()



node = Node(compression_table, ParquetStore(Path("test.parquet"), CompressionSchema.schema()), 
    dependencies = { "compressor": Constant(Zstd(1)), 
                    "suite" : Constant(Suite(Path("suites/predata/")))
                    } )

bld = Builder(logger)
x = node.pull(bld)

print(x.collect())

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
                (s for s in p.iterdir()) for p in self.problems()
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
