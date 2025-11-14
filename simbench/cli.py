import click
from pathlib import Path

from simbench.plots import create_nclass_classification_plot

from .data import CLASSIFICATIONS_SCHEMA, load_parquet, collect_datafiles
from .analysis import run_analysis
from .classification import get_classifier
from . import similarity as sim
import polars as pl

from loguru import logger


@click.group()
def cli():
    pass


@click.command()
@click.option("-lf", "--load_file", help="")
def get_similarities(load_file: str) -> pl.DataFrame:
    data = load_parquet(Path(load_file))
    logger.info(data)


@click.command()
@click.option(
    "-d",
    "--dir",
    help="Specify path to the data. It loads files in all subdirectories, and labels files according to their subdirectory",
)
@click.option(
    "-c",
    "--compressor",
    default="zstd",
    help="Choose compressor: zstd, zstandard, gzip",
)
@click.option(
    "-w", "--write", default=False, help="Writes the collected data to a file"
)
def collect_data(dir: str, write: bool, compressor: str) -> pl.DataFrame:
    logger.debug("Instantiating similarity metric")

    metric = sim.get_metric("NCD", compressor)
    logger.debug("Metric initialized")

    dirpath = Path.cwd() / Path(dir)

    logger.debug(f"Collecting files for analysis from {dirpath}")
    files_to_analyze = collect_datafiles(dirpath)

    # files_to_analyze.write_parquet(
    #     (Path.cwd() / "analyses/datafile_overview.parquet").resolve()
    # )
    logger.debug(f"Calculating similarities for {metric.name()}")
    similarity_df = sim.similarities_from_data(metric, files_to_analyze)

    logger.debug(f"Similarities: {similarity_df}")
    if write:
        data_filepath = Path.cwd() / f"analyses/similarities_{metric.name()}.parquet"
        logger.info(f"Writing to {str(data_filepath)}")
        similarity_df.collect().write_parquet(data_filepath.resolve())
    else:
        click.echo(similarity_df.collect())

    logger.info("Done")


@click.command()
@click.option(
    "-d",
    "--dir",
    help="Specify path to the data. It loads files in all subdirectories, and labels files according to their subdirectory",
)
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

    (data_df, sim_df, class_df, perf_df) = run_analysis(dirpath, metric, classif, write)

    click.echo(f"Data overview: \n{data_df.collect()}")
    click.echo(f"Similarities: \n{sim_df.collect()}")
    click.echo(f"Classifications: \n{class_df.collect()}")
    click.echo(f"Performance overview: \n{perf_df.collect()}")
    click.echo("Done")


@click.command("plot")
@click.option(
    "-f",
    "--file",
    help="Specify path to the data. It loads files in all subdirectories, and labels files according to their subdirectory",
)
def plot_classification(file: str) -> None:
    filepath = Path(file)
    assert filepath.is_file(), f"Filepath {filepath} is invalid"

    classifications = load_parquet(filepath)
    logger.debug(classifications.collect_schema())
    logger.debug(CLASSIFICATIONS_SCHEMA)
    assert classifications.collect_schema() == CLASSIFICATIONS_SCHEMA, (
        "Must provide a classification file for this plot"
    )

    create_nclass_classification_plot(classifications)

    click.echo("Done")


cli.add_command(get_similarities)
cli.add_command(collect_data)
cli.add_command(analyse)
cli.add_command(plot_classification)
