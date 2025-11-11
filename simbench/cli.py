import click
from pathlib import Path

from .data import load_parquet, collect_datafiles
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

    logger.debug(f"Calculating similarities for {metric.name()}")
    similarity_df = sim.similarities_from_data(metric, files_to_analyze)

    logger.debug(f"Similarities: {similarity_df}")
    if write:
        data_filepath = Path.cwd() / f"analyses/similarities_{metric.name()}.parquet"
        logger.info(f"Writing to {str(data_filepath)}")
        similarity_df.write_parquet(data_filepath.resolve())
    else:
        click.echo(similarity_df)

    logger.info("Done")


cli.add_command(get_similarities)
cli.add_command(collect_data)
