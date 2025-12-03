import sys
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
from .classification import get_performance_scikit
from simbench.analysis import Config, Analysis

import polars as pl
from loguru import logger


@click.group()
@click.pass_context
def cli(ctx):
    ctx.obj = Config()


@click.command()
@click.argument("file")
@click.option("-fl", "--filter", default=None, help="Filter on source")
def show_file(file: str, filter) -> None:
    assert file.endswith(".parquet"), "Can only show parquet file"
    data = pl.scan_parquet(Path(file))

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
            logger.debug(f"Skipping {tool}")
            continue

        analysis = Analysis(suite, tool)
        cfg.log.info(f"Working on {analysis.path}, force={force}")

        comp_df = analysis.compressions(update=force)
        pair_comp_df = analysis.pairwise_compressions(update=force)
        dist_df = analysis.distances(comp_df, pair_comp_df)


@click.command("plot-cl")
@click.argument("file", type=click.Path(exists=True))
def plot_classification(file: Path) -> None:
    classifications = pl.scan_parquet(file)

    assert classifications.collect_schema() == data.ClassificationTable.schema, (
        "Must provide a classification file for this plot"
    )

    create_nclass_classification_plot(classifications)
    f_score_plot(classifications)

    click.echo("Done")


@click.command("plot-f")
@click.argument("file", type=click.Path(exists=True))
def plot_fscore(file: Path) -> None:
    perf = pl.scan_parquet(file)
    assert perf.collect_schema() == data.PerformanceTable.schema, (
        "Must provide a performance file for this plot"
    )

    fig, ax = f_score_classification_plot(perf)

    plt.show()
    click.echo("Done")


@click.command("plot-knn")
@click.argument("file", type=click.Path(exists=True))
def plot_fscore_knn(file: Path) -> None:
    distances = pl.scan_parquet(file)

    assert distances.collect_schema() == data.DistanceTable.schema, (
        "Must provide a distance file for this plot"
    )

    f_score_knn_plot(distances)

    click.echo("Done")


@click.command("plot-thr")
@click.argument("file", type=click.Path(exists=True))
def plot_fscore_thr(file: Path) -> None:
    distances = pl.scan_parquet(file)

    assert distances.collect_schema() == data.DistanceTable.schema, (
        "Must provide a distance file for this plot"
    )

    f_score_radius_plot(distances)

    click.echo("Done")


@click.command()
@click.argument("file", type=click.Path(exists=True))
def fscore(file: Path) -> None:
    dist_df = pl.scan_parquet(file)
    assert dist_df.collect_schema() == data.DistanceTable.schema, (
        "Can only calculate F-score from distance file"
    )

    plot = get_performance_scikit(dist_df)

    plt.show()


cli.add_command(show_file)
cli.add_command(analyse)
cli.add_command(plot_classification)
cli.add_command(plot_fscore)
cli.add_command(plot_fscore_knn)
cli.add_command(plot_fscore_thr)
cli.add_command(fscore)
