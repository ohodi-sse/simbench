from abc import abstractmethod
from dataclasses import dataclass
import polars as pl

from abc import ABC


class Classification:
    name: str
    labelled_as: str
    similar_files: list[tuple[str, int]]

    def __init__(self, name, label, similar_files):
        self.name = name
        self.labelled_as = label
        self.similar_files = similar_files


@dataclass
class Classifier(ABC):
    @abstractmethod
    def classify(
        self, distance_df: pl.LazyFrame, src: str
    ) -> Classification | None: ...

    @property
    @abstractmethod
    def name(self) -> str: ...

    @property
    @abstractmethod
    def param(self) -> float: ...

    def matches(self, match):
        import re

        return re.match(match, f"{self.name}-{self.param}") is not None


@dataclass
class KNN(Classifier):
    k: int

    @property
    def name(self) -> str:
        return "knn"

    @property
    def param(self) -> int:
        return self.k

    def classify(self, distance_df: pl.LazyFrame, src: str) -> Classification:
        from simbench.build import schema
        from simbench.tables import DistanceTable

        assert self.k > 0, "k must be positive"
        assert distance_df.collect_schema() == schema(DistanceTable), (
            "Must use a distance dataframe for classification"
        )

        filter_expr = (pl.col("src") == src) & (pl.col("tgt") != src)
        src_sim = (
            distance_df.filter(filter_expr)
            .select(["tgt_label", "tgt", "distance"])
            .sort(by="distance", descending=True)
        )

        k_best = src_sim.head(self.k)
        counts = (
            k_best.group_by("tgt_label")
            .agg(pl.len(), pl.col("distance").mean())
            .sort(by=["len", "distance"], descending=[True, True])
        )  # The sorting here takes care of the tie-breaking
        # This means src is labelled as the closest label based on mean distance when given a tie

        label = counts.select("tgt_label").collect()["tgt_label"][0]

        k_best_names = pl.Series(k_best.select("tgt").collect()).to_list()
        return Classification(src, label, k_best_names)

    def __post_init__(self):
        assert isinstance(self.k, int)


@dataclass
class Threshold(Classifier):
    threshold: float

    @property
    def name(self) -> str:
        return "thrsh"

    @property
    def param(self) -> float:
        return self.threshold

    def classify(self, distance_df: pl.LazyFrame, src: str) -> Classification | None:
        from simbench.build import schema
        from simbench.tables import DistanceTable

        assert 0.0 <= self.threshold and self.threshold <= 1.0, (
            "Threshold must be between 0 and 1"
        )
        assert distance_df.collect_schema() == schema(DistanceTable), (
            "Must use a distance dataframe for classification"
        )

        filter_expr = (
            (pl.col("src") == src)
            & (pl.col("tgt") != src)
            & (pl.col("distance") < self.threshold)
        )
        in_radius = distance_df.filter(filter_expr).select(
            ["tgt_label", "tgt", "distance"]
        )

        best_names = pl.Series(in_radius.select("tgt").collect()).to_list()

        if not best_names:
            return None

        counts = in_radius.group_by("tgt_label").agg(pl.len())

        label = (
            counts.sort(by="len", descending=True)
            .select(pl.col("tgt_label"))
            .collect()["tgt_label"][0]
        )

        return Classification(src, label, best_names)

    def __post_init__(self):
        assert isinstance(self.threshold, float)
