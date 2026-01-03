from dataclasses import dataclass

import polars as pl
import simbench.data as data
from abc import ABC, abstractmethod
from simbench.compressors import Compressor


class CompressionMetric(ABC):
    compressor: Compressor

    @property
    @abstractmethod
    def name(self) -> str: ...

    @abstractmethod
    def metric_expr(self) -> pl.Expr: ...

    def __call__(self, metric_df: pl.LazyFrame) -> pl.LazyFrame:
        metric_df = metric_df.select(
            pl.col(["src", "tgt", "src_label", "tgt_label"]),
            distance=self.metric_expr(),
            time=self.time_expr(),
        )

        dist_df = metric_df.sort(by="distance")
        assert dist_df.collect_schema() == data.DistanceTable.schema(), (
            f"\n{dist_df.collect_schema()}\n does not adhere to \n{data.DistanceTable.schema()}"
        )

        return dist_df

    def time_expr(self):
        return pl.col("src_time") + pl.col("tgt_time") + pl.col("srctgt_time")


@dataclass(frozen=True)
class NCD(CompressionMetric):
    @property
    def name(self) -> str:
        return "ncd"

    def metric_expr(self) -> pl.Expr:
        return (
            (pl.col("srctgt_comp") - pl.min_horizontal("src_comp", "tgt_comp"))
            / pl.max_horizontal("src_comp", "tgt_comp")
        ).cast(pl.Float32)
