from dataclasses import dataclass, field
import time
import functools
from pathlib import Path
import json
from typing import Callable, get_type_hints
from abc import ABC, abstractmethod
from typing import Protocol
from contextlib import contextmanager
import itertools

import polars as pl
from matplotlib.figure import Figure
from loguru import logger

from indicatif import ProgressBar, ProgressStyle

Logger = type(logger)


@dataclass(frozen=True)
class Source:
    path: Path

    @property
    def name(self):
        return self.path.name

    @property
    def label(self):
        return self.path.parent.name

    def __post_init__(self):
        if not self.path.is_file():
            raise ValueError(f"Path {self.path} is not a file.")

    def get_bytes(self) -> bytes:
        return self.path.read_bytes()


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
    file: Path

    @abstractmethod
    def load(self, bld) -> A | None: ...

    @abstractmethod
    def store(self, item: A, bld: Builder): ...

    @property
    def store_time(self):
        if self.file.exists():
            return self.file.stat().st_mtime
        return time.time()


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
class FigureStore(Store[Figure]):
    file: Path

    def load(self, bld):
        return None  # Returning None will always overwrite the plot

    def store(self, item: Figure, bld):
        page_width, page_height = 8.3, 11.7  # A4 size in inches
        item.set_size_inches(page_width, page_height)
        item.savefig(self.file, format="pdf", bbox_inches="tight", pad_inches=1.5)
        assert self.file.exists(), f"Failed to create file {self.file}"


@dataclass
class Node[A](Pullable[A]):
    action: Callable
    store: Store[A]
    dependencies: dict[str, Pullable]

    def updated_dependencies(self):
        status_pairs = [
            (dep.store.store_time < self.store.store_time, dep.store.file.name)
            for _, dep in self.dependencies.items()
            if isinstance(dep, Node)
        ]

        return [file for (val, file) in status_pairs if not val]

    def pull(self, bld) -> A:
        if self.updated_dependencies():
            bld.log.debug(f"Found updated dependencies: {self.updated_dependencies()}")

        if (a := self.store.load(bld)) is not None and not self.updated_dependencies():
            return a

        outputs = {k: dep.pull(bld) for k, dep in self.dependencies.items()}

        a = self.action(bld=bld, **outputs)
        self.store.store(a, bld=bld)

        return a


@dataclass
class Suite:
    root: Path

    def problems(self):
        return (self.root / "problems").iterdir()

    def sources(self):
        return itertools.chain.from_iterable(
            (Source(s) for s in p.iterdir()) for p in self.problems()
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


def figurenode(fn):
    def wrapper(path: Path, toolname, **dependencies):
        return Node(
            functools.partial(fn, toolname=toolname), FigureStore(path), dependencies
        )

    return wrapper


class Normalizer(Protocol):
    @property
    @abstractmethod
    def name(self) -> str: ...

    @abstractmethod
    def process(self, src: bytes) -> bytes: ...


class IDNormalizer(Normalizer):
    @property
    def name(self) -> str:
        return "unprocessed"

    def process(self, src):
        return src
