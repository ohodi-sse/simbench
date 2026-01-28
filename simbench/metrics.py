from dataclasses import dataclass

import polars as pl
from abc import ABC, abstractmethod


class Metric(ABC):
    @property
    @abstractmethod
    def name(self) -> str: ...

    @abstractmethod
    def metric_expr(self) -> pl.Expr: ...

    def __call__(self, metric_df: pl.LazyFrame) -> pl.LazyFrame:
        from simbench.build import schema
        from simbench.tables import DistanceTable

        metric_df = metric_df.select(
            pl.col(["src", "tgt", "src_label", "tgt_label"]),
            distance=self.metric_expr(),
            time=self.time_expr(),
        )

        dist_df = metric_df.sort(by="distance")
        assert dist_df.collect_schema() == schema(DistanceTable), (
            f"\n{dist_df.collect_schema()}\n does not adhere to \n{schema(DistanceTable)}"
        )

        return dist_df

    @abstractmethod
    def time_expr(self) -> pl.Expr: ...


@dataclass(frozen=True)
class NCD(Metric):
    @property
    def name(self) -> str:
        return "ncd"

    def metric_expr(self) -> pl.Expr:
        return (
            (pl.col("srctgt_comp") - pl.min_horizontal("src_comp", "tgt_comp"))
            / pl.max_horizontal("src_comp", "tgt_comp")
        ).cast(pl.Float32)

    def time_expr(self) -> pl.Expr:
        return pl.col("src_time") + pl.col("tgt_time") + pl.col("srctgt_time")


class DiffMetric(Metric):
    @property
    def name(self) -> str:
        return "diffdistance"

    def metric_expr(self) -> pl.Expr:
        return (pl.min_horizontal("tgt_len", "diff_len") / pl.col("tgt_len")).cast(
            pl.Float32
        )

    def time_expr(self) -> pl.Expr:
        return pl.col("diff_time")


class GenericMetric(Metric):
    @property
    def name(self) -> str:
        return "derived"

    def metric_expr(self) -> pl.Expr:
        return pl.col("distance")

    def time_expr(self) -> pl.Expr:
        return pl.col("time")
