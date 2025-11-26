from numpy._core.fromnumeric import sort
import matplotlib.pyplot as plt
import click
from pathlib import Path

from simbench.plots import (
    create_nclass_classification_plot,
    f_score_plot,
    f_score_radius_plot,
    plot_mds,
    f_score_knn_plot,
)

from .data import (
    CLASSIFICATIONS_SCHEMA,
    DISTANCE_SCHEMA,
    SIMILARITIES_SCHEMA,
    load_parquet,
    collect_datafiles,
    merge_dataframes,
    merge_many,
)
from .analysis import run_analysis
from .classification import get_classifier, get_performance_scikit
from . import similarity as sim

import polars as pl
from loguru import logger


@click.group()
def cli():
    pass


@click.command()
@click.argument("file")
def show_file(file: str) -> pl.DataFrame:
    assert file.endswith(".parquet"), "Can only show parquet file"

    data = load_parquet(Path(file))
    logger.info(data.collect())


@click.command()
@click.argument("dir")
@click.option(
    "-c",
    "--compressor",
    default="zstd",
    help="Choose compressor: zstd, zstandard, gzip",
)
@click.option(
    "-w", "--write", default=False, help="Writes the collected data to a file"
)
@click.option(
    "-cl",
    "--classifier",
    default="bm",
    help="Choose one of the following classifiers: bm, knn_?",
)
def analyse(dir: str, compressor: str, classifier: str, write: bool):
    dirpath = Path(dir)
    logger.debug("Instantiating similarity metric")
    metric = sim.get_metric("NCD", compressor)

    assert metric, f"Failed to initialize metric from {compressor}"
    logger.debug(f"Metric initialized as: {metric.name()}")

    classif = get_classifier(classifier)
    assert classif, f"Failed to initialize classifier from {classifier}"
    logger.debug(f"Classifier initialized as: {classif.name()}")

    (data_df, compf_df, compc_df, sim_df, class_df, perf_df) = run_analysis(
        dirpath, metric, classif, write
    )

    click.echo(f"Data overview: \n{data_df.collect()}")
    click.echo(f"Similarities: \n{sim_df.collect()}")
    click.echo(f"Classifications: \n{class_df.collect()}")
    click.echo(f"Performance overview: \n{perf_df.collect()}")
    click.echo("Done")


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

    assert distances.collect_schema() == DISTANCE_SCHEMA, (
        "Must provide a distance file for this plot"
    )

    f_score_plot(distances)

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


@click.command("plot-mds")
@click.argument("path")
def plot_mds_cli(path: str) -> None:
    filepath = Path(path)

    similarities = load_parquet(filepath)

    assert similarities.collect_schema() == DISTANCE_SCHEMA, (
        "Must provide a similarities file for this plot"
    )

    plot_mds(similarities)

    click.echo("Done")


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
cli.add_command(plot_mds_cli)
cli.add_command(fscore)
