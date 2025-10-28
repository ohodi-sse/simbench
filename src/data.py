from pathlib import Path

import pandas as pd
import pyarrow as pa
import pyarrow.parquet as pq


class File:
    name: str
    path: Path
    group: int = -1
    _bytes: bytes = None

    def __init__(self, path: Path, group: int = -1):
        if not path.is_file():
            raise ValueError(f"Path {path} is not a file.")
        self.path = path
        self.name = path.name
        self.group = group

    def __str__(self) -> str:
        return f"{self.group}_{self.name}"

    def get_bytes(self) -> bytes:
        if self._bytes is None:
            self._bytes = self.path.read_bytes()
        return self._bytes


def write_parquet(filename: Path, data: pd.DataFrame) -> None:
    table = pa.Table.from_pandas(data)
    pq.write_table(table, filename)


def load_parquet(filename: Path) -> pd.DataFrame:
    if not filename.is_file():
        raise ValueError(f"Path {filename} is not a valid file.")
    df = pq.read_table(filename.name)
    return df


def print_md_data(data: pd.DataFrame) -> None:
    data.to_markdown()
