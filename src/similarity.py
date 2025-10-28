from abc import abstractmethod
from dataclasses import dataclass
import io
from typing import Protocol
from loguru import logger

import pandas as pd

from data import File
import zstd
import gzip
import zstandard
import zlib


class Compress(Protocol):
    @abstractmethod
    def __call__(self, file: bytes, out: io.StringIO) -> None:
        pass

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
        return f"zstd_clvl{self.compression_lvl}"

    def __post_init__(self):
        assert isinstance(self.compression_lvl, int)
        # assert isinstance(self, Compress)


@dataclass(frozen=True)
class Zstandard:
    compression_lvl: int

    def __call__(self, file: bytes, out: io.BytesIO) -> None:
        assert self.compression_lvl in range(1, 20), (
            f"Compression level {self.compression_lvl} is out of range"
        )
        out.write(zstandard.compress(file, self.compression_lvl))

    def name(self) -> str:
        return f"zstandard_clvl{self.compression_lvl}"

    def __post_init__(self):
        assert isinstance(self.compression_lvl, int)
        # assert isinstance(self, Compress)


@dataclass(frozen=True)
class Zlib:
    compression_lvl: int

    def __call__(self, file: bytes, out: io.BytesIO) -> None:
        assert self.compression_lvl in range(1, 20), (
            f"Compression level {self.compression_lvl} is out of range"
        )
        out.write(zlib.compress(file, self.compression_lvl))

    def name(self) -> str:
        return f"zlib_clvl{self.compression_lvl}"

    def __post_init__(self):
        assert isinstance(self.compression_lvl, int)
        # assert isinstance(self, Compress)


@dataclass(frozen=True)
class Gzip:
    compression_lvl: int

    def __call__(self, file: bytes, out: io.StringIO) -> None:
        assert self.compression_lvl in range(1, 10), (
            f"Compression level {self.compression_lvl} is out of range"
        )
        out.write(gzip.compress(file, level=self.compression_lvl))

    def name(self) -> str:
        return f"gzip_clvl{self.compression_lvl}"

    def __post_init__(self):
        assert isinstance(self.compression_lvl, int)
        # assert isinstance(self, Compress)


class SimilarityMetric(Protocol):
    @abstractmethod
    def __call__(self, afile, bfile) -> float: ...


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

        logger.debug(f"file a: {ca}")
        logger.debug(f"file b: {cb}")
        logger.debug(f"file concat: {cab}")
        return (cab - min(ca, cb)) / max(ca, cb)


def get_compressor(comp_name: str) -> Compress:
    match comp_name:
        case "zstd":
            return Zstd(compression_lvl=1)
        case "gzip":
            return Gzip(compression_lvl=1)
        case "zstandard":
            return Zstandard(compression_lvl=1)
        case "zlib":
            return Zlib(compression_lvl=1)
        case e:
            raise ValueError(f"{e} is not a valid compressor name")


def metric(metric_name: str, compressor: Compress) -> SimilarityMetric | None:
    match metric_name:
        case "NCD":
            return NCD(compressor)
        case e:
            raise ValueError(f"No metric type called {e}")


def get_metric(metric_name: str, compressor_name: str) -> SimilarityMetric | None:
    comp = get_compressor(compressor_name)
    return metric(metric_name, comp)


def get_similarities(metric: SimilarityMetric, afile: File, bfiles: [File]) -> [float]:
    similarities = []
    for bfile in bfiles:
        similarities.append((1 - metric(afile.get_bytes(), bfile.get_bytes())))

    return similarities


def create_similarity_matrix(metric: SimilarityMetric, files: [File]) -> pd.DataFrame:
    data = {}
    for file in files:
        data[file.name] = get_similarities(metric, file, files)

    dataframe = pd.DataFrame(data)

    return dataframe
