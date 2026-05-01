import random
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

# Logger = type(logger)


@dataclass(frozen=True)
class Source:
    path: Path

    @property
    def name(self):
        return self.path.name

    @property
    def label(self):
        return self.path.parent.name

    def get_bytes(self) -> bytes:
        return self.path.read_bytes()


@dataclass
class Builder:
    def __init__(self, logger):
        self.log = logger

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
            ),
        )
        yield pb
        pb.finish()


class NamedCallable(Protocol):
    @property
    @abstractmethod
    def name(self) -> str: ...

    @abstractmethod
    def __call__(self, file1: bytes, file2: bytes) -> float: ...

    @abstractmethod
    def preprocess(self, src: Source): ...


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
class SourceStore(Store[Source], Pullable[Source]):
    file: Path
    source: Source

    def __init__(self, file: Path) -> None:
        self.file = file
        self.source = Source(file)

    def load(self, bld) -> Source | None:
        if self.source.path.exists():
            return self.pull(bld)

    def store(self, item: Source, bld):
        assert isinstance(item, Source)
        self.source.path.write_bytes(item.get_bytes())
        assert self.source.path.exists()

    def pull(self, bld) -> Source:
        return self.source


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
class DataFrameStore(Store[pl.DataFrame], Pullable[pl.DataFrame]):
    file: Path

    def __post_init__(self):
        assert self.file.parent.exists(), (
            f"Cannot find {self.file.parent} at callsite {Path.cwd()}"
        )

    def load(self, bld) -> pl.DataFrame | None:
        if self.file.exists():
            return self.pull(bld)
        return

    def store(self, item: pl.DataFrame, bld):
        item.write_parquet(self.file)
        assert self.file.exists(), f"Failed to create file {self.file}"

    def pull(self, bld) -> pl.DataFrame:
        return pl.read_parquet(self.file)


@dataclass
class FigureStore(Store[Figure]):
    file: Path

    def load(self, bld):
        return None  # Returning None will always overwrite the plot

    def store(self, item: Figure, bld):
        item.savefig(self.file, format="pdf", bbox_inches="tight", pad_inches=1.5)
        assert self.file.exists(), f"Failed to create file {self.file}"


@dataclass
class Node[A](Pullable[A]):
    action: Callable
    store: Store[A]
    dependencies: dict[str, Pullable]

    def updated_dependencies(self):
        return [
            dep.store.file.name
            for dep in self.dependencies.values()
            if isinstance(dep, Node) and dep.store.store_time < self.store.store_time
        ]

    def pull(self, bld) -> A:
        if self.updated_dependencies():
            bld.log.debug(f"Found updated dependencies: {self.updated_dependencies()}")

        if (a := self.store.load(bld)) is not None and not self.updated_dependencies():
            bld.log.info(f"Loaded precomputed store: {self.store.file}")
            return a

        outputs = {k: dep.pull(bld) for k, dep in self.dependencies.items()}

        a = self.action(bld=bld, **outputs)
        self.store.store(a, bld=bld)
        bld.log.success(f"Stored result to {self.store.file}")

        return a


@dataclass
class Suite:
    root: Path
    seed: None | int
    n_samples: None | int

    def __init__(self, root, seed=None, n_samples=None):
        self.root = root
        self.seed = seed
        self.n_samples = n_samples

    def problems(self):
        return (self.root / "problems").iterdir()

    def sources(self):
        if self.seed and self.n_samples:
            random.seed(self.seed)
            source_list = list(
                itertools.chain.from_iterable(
                    (Source(s) for s in p.iterdir() if s.is_file())
                    for p in self.problems()
                )
            )

            k = min(self.n_samples, len(source_list))
            sample_sources = random.sample(list(source_list), k)
            return itertools.chain(sample_sources)

        return itertools.chain.from_iterable(
            (Source(s) for s in p.iterdir() if s.is_file()) for p in self.problems()
        )

    def paths_as_strs(self):
        return [str(src.path) for src in self.sources()]


@dataclass
class SourceDict(Pullable):
    sources: dict[str, Source]

    def pull(self, bld: Builder):
        return self.sources


class Normalizer(Protocol):
    @property
    @abstractmethod
    def name(self) -> str: ...

    @abstractmethod
    def dependencies(self, sources: list[Source]) -> list[Source]: ...

    @abstractmethod
    def __call__(self, sources: list[str], targets: list[str]): ...

    def process(self, sources: list[Source], targets: list[Source]):
        # This function acts as a bridge to rust, since pyo3 does not support objects
        assert len(sources) == len(targets)

        source_strings = [str(src.path) for src in sources]
        target_strings = [str(tgt.path) for tgt in targets]

        self(source_strings, target_strings)

    def matches(self, match):
        import re

        return re.fullmatch(match, self.name) is not None

    @property
    @abstractmethod
    def required_output_file_extension(self) -> str: ...

    def new_source(self, src: Source) -> Source:
        label = src.label
        problems_dir = src.path.parent.parent
        root_dir = problems_dir.parent

        # Create new directory for processed files using the name of the processing method
        processed_problems_dir = (
            root_dir
            / f"{self.name + '_' if self.name != 'unprocessed' else ''}problems"
        )
        processed_problems_dir.mkdir(parents=True, exist_ok=True)
        assert processed_problems_dir.exists(), (
            f"Failed to create directory {processed_problems_dir}"
        )
        processed_labels_dir = processed_problems_dir / label
        processed_labels_dir.mkdir(parents=True, exist_ok=True)

        new_name = Path(src.name).with_suffix(self.required_output_file_extension).name
        new_path = processed_labels_dir / new_name

        return Source(new_path)

    def get_normalized_sources(self, sources: list[Source]):
        sources: list[Source] = self.dependencies(sources)
        targets: list[Source] = [self.new_source(src) for src in sources]

        if all(tgt.path.exists() for tgt in targets):
            return SourceDict({tgt.name: tgt for tgt in targets})

        self.process(sources, targets)
        assert all(tgt.path.exists() for tgt in targets)

        return SourceDict({tgt.name: tgt for tgt in targets})


class DependentNormalizer(Normalizer):
    depends_on_normalizer: Normalizer

    def dependencies(self, sources: list[Source]) -> list[Source]:
        bld = Builder(logger)
        source_dict = self.depends_on_normalizer.get_normalized_sources(sources).pull(
            bld
        )
        return source_dict.values()


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
    def wrapper(path: Path, **dependencies):
        return Node(fn, FigureStore(path), dependencies)

    return wrapper
