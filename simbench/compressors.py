from dataclasses import dataclass
from abc import ABC, abstractmethod
import io
from simbench.build import NamedCallable

import zstd
import gzip
import zlib
import lzma
import difflib


@dataclass
class Compressor(ABC):
    level: int

    @abstractmethod
    def __call__(self, file: bytes, out: io.BytesIO) -> None: ...

    def compress_length(self, content: bytes) -> int:
        buffer = io.BytesIO()
        self(content, buffer)
        return buffer.getbuffer().nbytes

    @property
    @abstractmethod
    def name(self) -> str: ...


@dataclass
class Zstd(Compressor):
    @property
    def name(self) -> str:
        return "zstd"

    def __call__(self, file: bytes, out: io.BytesIO) -> None:
        out.write(zstd.compress(file, self.level))

    def __post_init__(self):
        assert isinstance(self.level, int)
        assert self.level in range(1, 20), (
            f"Compression level {self.level} is out of range"
        )


@dataclass
class Zlib(Compressor):
    @property
    def name(self) -> str:
        return "zlib"

    def __call__(self, file: bytes, out: io.BytesIO) -> None:
        out.write(zlib.compress(file, self.level))

    def __post_init__(self):
        assert isinstance(self.level, int)
        assert self.level in range(1, 20), (
            f"Compression level {self.level} is out of range"
        )


@dataclass
class LZMA(Compressor):
    @property
    def name(self) -> str:
        return "LZMA"

    def __call__(self, file: bytes, out: io.BytesIO) -> None:
        out.write(lzma.compress(file, self.level))

    def __post_init__(self):
        assert isinstance(self.level, int)
        assert self.level in range(1, 10), (
            f"Compression level {self.level} is out of range"
        )


@dataclass
class Gzip(Compressor):
    @property
    def name(self) -> str:
        return "gzip"

    def __call__(self, file: bytes, out: io.BytesIO) -> None:
        out.write(gzip.compress(file, self.level))

    def __post_init__(self):
        assert isinstance(self.level, int)
        assert self.level in range(1, 10), (
            f"Compression level {self.level} is out of range"
        )


class Diff(ABC):
    @abstractmethod
    def __call__(self, file: bytes, file2: bytes, out: io.BytesIO) -> None: ...

    def diff_length(self, file: bytes, file2: bytes) -> int:
        buffer = io.BytesIO()
        self(file, file2, buffer)
        return buffer.getbuffer().nbytes

    @property
    @abstractmethod
    def name(self) -> str: ...


class BSDiff(Diff):
    @property
    def name(self) -> str:
        return "bsdiff"

    def __call__(self, file: bytes, file2: bytes, out: io.BytesIO) -> None:
        import bsdiff4

        out.write(bsdiff4.diff(file, file2))


class Difflib(NamedCallable):
    @property
    def name(self) -> str:
        return "difflib"

    def __call__(self, file1: bytes, file2: bytes) -> float:
        # strls1 = file1.decode("utf-8").splitlines(keepends=True)
        # strls2 = file2.decode("utf-8").splitlines(keepends=True)
        # diff = difflib.unified_diff(strls1, strls2, n=0)
        similarity = difflib.SequenceMatcher(None, file1, file2).ratio()
        distance = 1 - similarity

        return distance
