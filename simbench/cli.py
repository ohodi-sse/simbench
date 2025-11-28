from numpy._core.fromnumeric import sort
import io
import sys
import itertools
import zstd
import matplotlib.pyplot as plt
import click
from pathlib import Path

from simbench.plots import (
    create_nclass_classification_plot,
    f_score_classification_plot,
    f_score_plot,
    f_score_radius_plot,
    f_score_knn_plot,
)
from . import data

from .data import (
    CLASSIFICATIONS_SCHEMA,
    DISTANCE_SCHEMA,
    PERFORMANCE_SCHEMA,
    load_parquet,
    merge_dataframes,
    merge_many,
)
from .analysis import run_analysis
from .classification import get_classifier, get_performance_scikit
from . import similarity as sim

import polars as pl
from loguru import logger

from dataclasses import dataclass, field

from abc import ABC, abstractmethod


@dataclass
class Tool(ABC):
    @property
    @abstractmethod
    def name(self) -> str: ...

    def matches(self, match):
        import re

        return re.fullmatch(match, self.name) is not None


class CompressionMetric(ABC):
    @property
    @abstractmethod
    def name(self) -> str: ...


@dataclass
class NCD(CompressionMetric):
    name = "ncd"


@dataclass
class Zstd(Tool):
    level: int
    metric: CompressionMetric

    def __post_init__(self):
        assert isinstance(self.level, int)
        assert self.level in range(1, 20), (
            f"Compression level {self.level} is out of range"
        )
        assert isinstance(self.metric, CompressionMetric)

    @property
    def name(self):
        return f"zstd-{self.level}-{self.metric.name}"

    def compress(self, file: bytes, out: io.BytesIO):
        out.write(zstd.compress(file, self.level))

    def distances(self): ...


@dataclass
class Analysis:
    suite: Path
    tool: Tool

    @property
    def path(self):
        return self.suite / "results" / self.tool.name

    @property
    def compression_file(self):
        return self.path / "compressions.parquet"

    def problems(self):
        return (self.suite / "data").iterdir()

    def sources(self):
        return itertools.chain.from_iterable(
            (data.Source(s) for s in p.iterdir()) for p in self.problems()
        )

    def compressions(self, update=False) -> data.CompressionTable:
        import time

        file = self.compression_file

        if file.exists():
            df = data.CompressionTable.scan(file)
        else:
            file.parent.mkdir(parents=True, exist_ok=True)

        df = data.CompressionTable.dataframe([])

        if update:
            changed = list(self.sources())
        else:
            changed = []
            for src in self.sources():
                if src.name in df["src"]:
                    continue
                changed.append(src)

        new = []
        for src in changed:
            src_bytes = src.get_bytes()

            best = None
            for i in range(3):
                buffer = io.BytesIO()
                starttime = time.perf_counter_ns()
                self.tool.compress(src_bytes, buffer)
                complen = buffer.getbuffer().nbytes
                comptime = time.perf_counter_ns() - starttime
                best = comptime if best is None else min(best, comptime)

            new.append(
                {
                    "src": src.name,
                    "src_time": best,
                    "src_comp": complen,
                    "src_size": len(src_bytes),
                    "src_ratio": complen / len(src_bytes),
                    "src_label": src.label,
                }
            )

        if not update:
            df = pl.concat([df, data.CompressionTable.dataframe(new)])
        else:
            df = data.CompressionTable.dataframe(new)

        if changed:
            df.write_parquet(file)

        return df.lazy()


@dataclass
class Config:
    log: logger
    tools: list[Tool] = field(default_factory=list)


@click.group()
@click.pass_context
def cli(ctx):
    ctx.obj = Config(
        logger,
        tools=[Zstd(10, NCD())],
    )


@click.command()
@click.argument("file")
@click.option("-fl", "--filter", default=None, help="Filter on source")
def show_file(file: str, filter) -> None:
    assert file.endswith(".parquet"), "Can only show parquet file"

    data = load_parquet(Path(file))

    if filter:
        data = data.filter(pl.col("src") == filter)

    logger.info(data.collect())


@click.command()
@click.argument("suite", type=click.Path(file_okay=False, path_type=Path))
@click.option("--tool", "tool_pattern", help="filter the tools to be run", default=".*")
@click.option(
    "-f", "--force", is_flag=True, default=False, help="force update of files"
)
@click.option("--classifier", help="filter on which classifiers to run", default=".*")
@click.pass_obj
def analyse(cfg, suite, tool_pattern, classifier, force):
    for tool in cfg.tools:
        if not tool.matches(tool_pattern):
            cfg.log.debug(f"Skipping {tool}")

        analysis = Analysis(suite, tool)
        cfg.log.info(f"Working on {analysis.path}, force={force}")
        x = analysis.compressions(update=force)

        x.collect().write_csv(sys.stdout)

    # logger.debug("Instantiating similarity metric")
    # metric = sim.get_metric("NCD", compressor)

    # assert metric, f"Failed to initialize metric from {compressor}"
    # logger.debug(f"Metric initialized as: {metric.name()}")

    # classif = get_classifier(classifier)
    # assert classif, f"Failed to initialize classifier from {classifier}"
    # logger.debug(f"Classifier initialized as: {classif.name()}")

    # (data_df, compf_df, compc_df, sim_df, class_df, perf_df) = run_analysis(
    #     dirpath, metric, classif, write
    # )

    # click.echo(f"Data overview: \n{data_df.collect()}")
    # # click.echo(f"Similarities: \n{sim_df.collect()}")
    # click.echo(f"Classifications: \n{class_df.collect()}")
    # click.echo(f"Performance overview: \n{perf_df.collect()}")
    # click.echo("Done")


@click.command("plot-cl")
@click.argument("path")
def plot_classification(path: str) -> None:
    filepath = Path(path)

    classifications = load_parquet(filepath)

    assert classifications.collect_schema() == CLASSIFICATIONS_SCHEMA, (
        "Must provide a classification file for this plot"
    )

    create_nclass_classification_plot(classifications)
    f_score_plot(classifications)

    click.echo("Done")


@click.command("plot-f")
@click.argument("path")
def plot_fscore(path: str) -> None:
    filepath = Path(path)

    distances = load_parquet(filepath)

    assert distances.collect_schema() == PERFORMANCE_SCHEMA, (
        "Must provide a performance file for this plot"
    )

    fig, ax = f_score_classification_plot(distances)

    plt.show()
    click.echo("Done")


@click.command("plot-knn")
@click.argument("path")
def plot_fscore_knn(path: str) -> None:
    filepath = Path(path)

    distances = load_parquet(filepath)

    assert distances.collect_schema() == DISTANCE_SCHEMA, (
        "Must provide a distance file for this plot"
    )

    f_score_knn_plot(distances)

    click.echo("Done")


@click.command("plot-thr")
@click.argument("path")
def plot_fscore_thr(path: str) -> None:
    filepath = Path(path)

    distances = load_parquet(filepath)

    assert distances.collect_schema() == DISTANCE_SCHEMA, (
        "Must provide a distance file for this plot"
    )

    f_score_radius_plot(distances)

    click.echo("Done")


# @click.command("plot-mds")
# @click.argument("path")
# def plot_mds_cli(path: str) -> None:
#     filepath = Path(path)
#
#     similarities = load_parquet(filepath)
#
#     assert similarities.collect_schema() == DISTANCE_SCHEMA, (
#         "Must provide a similarities file for this plot"
#     )
#
#     plot_mds(similarities)
#
#     click.echo("Done")


@click.command("merge")
@click.argument("path1")
@click.argument("path2")
def merge_parquet(path1: str, path2: str):
    filepath1 = Path(path1)
    filepath2 = Path(path2)

    file1 = load_parquet(filepath1)
    file2 = load_parquet(filepath2)

    merged = merge_dataframes(file1, file2)

    logger.debug(merged)
    return merged


@click.command("merge-many")
@click.argument("dir")
@click.argument("suffix")
@click.option(
    "-s", "--sort-by", default=None, help="Pick a key to sort the merged dataframes by"
)
@click.option("-w", "--write", default=False, help="Writes the merged data to a file")
def merge_many_cli(dir: str, suffix: str, sort_by: str, write: bool):
    dirpath = Path(dir)

    merged = merge_many(dirpath, suffix)

    if sort_by:
        merged = merged.sort(by=sort_by, descending=True)

    if write:
        data_filepath = dirpath / f"merged_{suffix}"
        logger.info(f"Writing to {str(data_filepath)}")
        merged.write_parquet(data_filepath.resolve())
    else:
        click.echo(merged)

    click.echo("Done")


@click.command()
@click.argument("file")
def fscore(file: str) -> None:
    filepath = Path(file)

    dist_df = load_parquet(filepath)
    assert dist_df.collect_schema() == DISTANCE_SCHEMA, (
        "Can only calculate F-score from distance file"
    )

    plot = get_performance_scikit(dist_df)

    plt.show()


cli.add_command(show_file)
cli.add_command(analyse)
cli.add_command(plot_classification)
cli.add_command(merge_parquet)
cli.add_command(merge_many_cli)
cli.add_command(plot_fscore)
cli.add_command(plot_fscore_knn)
cli.add_command(plot_fscore_thr)
cli.add_command(fscore)
