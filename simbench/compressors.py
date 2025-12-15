from dataclasses import dataclass
from abc import ABC, abstractmethod
import io

import zstd
import gzip
import zlib


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
