from abc import ABC, abstractmethod
from simbench.build import NamedCallable, Source

import difflib


class Diff(ABC):
    @abstractmethod
    def __call__(self, file1, file2) -> int: ...

    @property
    @abstractmethod
    def name(self) -> str: ...

    @abstractmethod
    def preprocess(self, src: Source): ...


class Difflib(NamedCallable):
    @property
    def name(self) -> str:
        return "difflib_chars"

    def __call__(self, file1: bytes, file2: bytes) -> float:
        similarity = difflib.SequenceMatcher(None, file1, file2).ratio()
        distance = 1 - similarity

        return distance

    def preprocess(self, src: Source):
        return src.get_bytes()


class EditDistanceLines(Diff):
    @property
    def name(self) -> str:
        return "edit_distance_lines"

    def __call__(self, file1, file2) -> int:
        matcher = difflib.SequenceMatcher(None, file1, file2)

        count = 0
        for tag, i1, i2, j1, j2 in matcher.get_opcodes():
            if tag != "equal":
                count += max(i2 - i1, j2 - j1)

        return count

    def preprocess(self, src: Source):
        return src.get_bytes().decode("utf-8").splitlines(keepends=True)


class EditDistanceChars(Diff):
    @property
    def name(self) -> str:
        return "edit_distance_chars"

    def __call__(self, file1, file2) -> int:
        matcher = difflib.SequenceMatcher(None, file1, file2)

        count = 0
        for tag, i1, i2, j1, j2 in matcher.get_opcodes():
            if tag != "equal":
                count += max(i2 - i1, j2 - j1)

        return count

    def preprocess(self, src: Source):
        return list(src.get_bytes())
