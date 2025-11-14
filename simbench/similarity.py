from abc import abstractmethod
from dataclasses import dataclass
import io
from typing import Protocol
from pathlib import Path
from .data import File, AnalysisSimDF, SIMILARITIES_SCHEMA

from loguru import logger
import polars as pl
import zstd
import gzip
import zstandard
import zlib


class Compress(Protocol):
    @abstractmethod
    def __call__(self, file: bytes, out: io.BytesIO) -> None:
        pass

    @abstractmethod
    def name(self) -> str:
        pass


@dataclass(frozen=True)
class Zstd:
    compression_lvl: int

    def __call__(self, file: bytes, out: io.BytesIO) -> None:
        assert self.compression_lvl in range(1, 20), (
            f"Compression level {self.compression_lvl} is out of range"
        )
        out.write(zstd.compress(file, self.compression_lvl))

    def name(self) -> str:
        return f"zstd_clvl_{self.compression_lvl}"

    def __post_init__(self):
        assert isinstance(self.compression_lvl, int)


@dataclass(frozen=True)
class Zstandard:
    compression_lvl: int

    def __call__(self, file: bytes, out: io.BytesIO) -> None:
        assert self.compression_lvl in range(1, 20), (
            f"Compression level {self.compression_lvl} is out of range"
        )
        out.write(zstandard.compress(file, self.compression_lvl))

    def name(self) -> str:
        return f"zstandard_clvl_{self.compression_lvl}"

    def __post_init__(self):
        assert isinstance(self.compression_lvl, int)


@dataclass(frozen=True)
class Zlib:
    compression_lvl: int

    def __call__(self, file: bytes, out: io.BytesIO) -> None:
        assert self.compression_lvl in range(1, 20), (
            f"Compression level {self.compression_lvl} is out of range"
        )
        out.write(zlib.compress(file, self.compression_lvl))

    def name(self) -> str:
        return f"zlib_clvl_{self.compression_lvl}"

    def __post_init__(self):
        assert isinstance(self.compression_lvl, int)


@dataclass(frozen=True)
class Gzip:
    compression_lvl: int

    def __call__(self, file: bytes, out: io.BytesIO) -> None:
        assert self.compression_lvl in range(1, 10), (
            f"Compression level {self.compression_lvl} is out of range"
        )
        out.write(gzip.compress(file, self.compression_lvl))

    def name(self) -> str:
        return f"gzip_clvl_{self.compression_lvl}"

    def __post_init__(self):
        assert isinstance(self.compression_lvl, int)


class SimilarityMetric(Protocol):
    @abstractmethod
    def __call__(self, afile, bfile) -> float: ...

    @abstractmethod
    def name(self) -> str: ...


@dataclass(frozen=True)
class NCD(SimilarityMetric):
    compressor: Compress

    def __call__(self, abytes: bytes, bbytes: bytes) -> float:
        concatbytes = abytes + bbytes
        outa = io.BytesIO()
        outb = io.BytesIO()
        outab = io.BytesIO()

        self.compressor(abytes, outa)
        self.compressor(bbytes, outb)
        self.compressor(concatbytes, outab)

        ca = outa.getbuffer().nbytes
        cb = outb.getbuffer().nbytes
        cab = outab.getbuffer().nbytes

        return 1 - (cab - min(ca, cb)) / max(ca, cb)

    def name(self):
        return f"NCD-{self.compressor.name()}"


def parse_compressor(compstr: str) -> Compress | None:
    parts = compstr.split("_")

    name = parts[0]
    clvl = 1

    if len(parts) > 1:
        assert parts[1] == "clvl", (
            f'Second part of compressor string {compstr} must be "clvl"'
        )
        clvl = int(parts[2])

    match name:
        case "zstd":
            return Zstd(compression_lvl=clvl)
        case "gzip":
            return Gzip(compression_lvl=clvl)
        case "zstandard":
            return Zstandard(compression_lvl=clvl)
        case "zlib":
            return Zlib(compression_lvl=clvl)
        case e:
            raise ValueError(f"{e} is not a valid compressor name")


def metric(metric_name: str, compressor: Compress) -> SimilarityMetric | None:
    match metric_name:
        case "NCD":
            return NCD(compressor)
        case e:
            raise ValueError(f"No metric type called {e}")


def get_metric(metric_name: str, compressor_name: str) -> SimilarityMetric | None:
    comp = parse_compressor(compressor_name)
    assert comp, f"Failed to instantiate compressor from {compressor_name}"
    return metric(metric_name, comp)


def get_similarities(
    metric: SimilarityMetric, afile: File, bfiles: list[File]
) -> list[float]:
    similarities = []
    for bfile in bfiles:
        similarities.append(metric(afile.get_bytes(), bfile.get_bytes()))

    return similarities


def create_similarity_matrix(
    metric: SimilarityMetric, files: list[File]
) -> AnalysisSimDF:
    data = {col: [] for col in SIMILARITIES_SCHEMA}

    assert isinstance(files[0], File), (
        "Can only create similarity matrix from File list"
    )

    for src in files:
        for target in files:
            data["src"].append(src.name)
            data["src_label"].append(src.label)
            data["target"].append(target.name)
            data["tool_name"].append(metric.name())
            data["similarity"].append(metric(src.get_bytes(), target.get_bytes()))

    return pl.LazyFrame(data, schema=SIMILARITIES_SCHEMA)


def similarities_from_data(metric: SimilarityMetric, df: pl.LazyFrame) -> pl.LazyFrame:
    file_paths = [
        Path(fp) for fp in pl.Series(df.select("src_file").collect()).to_list()
    ]
    files = [File(fp.name, fp.parent.stem, fp) for fp in file_paths]
    similarities = create_similarity_matrix(metric, files)

    return similarities


# OBSOLETE AS LONG AS WE CANNOT EXPLOIT COMMUTATIVITY
# def create_similarity_matrix_fast(
#     metric: SimilarityMetric, files: [File]
# ) -> pl.DataFrame:
#     labels = [str(file) for file in files]
#     # logger.debug(f"Labels: {labels}")
#     data = []
#     for i, file in enumerate(files):
#         data.extend(get_similarities(metric, file, files[i:]))
#         if i == 0:
#             dim = len(data)
#     # logger.debug(f"Data: {data}")
#
#     X = np.zeros((dim, dim))
#     X[np.triu_indices(X.shape[0], k=0)] = data
#     X = X + X.T - np.diag(np.diag(X))
#
#     dataframe = pl.DataFrame(X, columns=labels, index=labels)
#
#     return dataframe
