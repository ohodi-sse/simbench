import click
import datetime as dt
from pathlib import Path

from .data import load_parquet, collect_datafiles
from . import similarity as sim
import polars as pl


@click.command()
@click.option("--load_file")
@click.option("--file_from_dir")
def get_similarities(file_from_dir: str, load_file: str) -> pl.DataFrame:
    if load_file:
        df = load_parquet(Path(load_file))
        return df

    if file_from_dir:
        dirpath = Path.cwd() / file_from_dir

        data = collect_datafiles(dirpath)

        time = dt.datetime.now().strftime("%Y-%m-%d_%H:%M")
        analysis_file = dirpath / f"similarities_{time}.parquet"

        metric = sim.get_metric("NCD", "zstd")
        df = sim.similarities_from_data(metric, data)

        df.write_parquet(analysis_file)
        return df


@click.command()
@click.argument("dir")
@click.option("--save", help="Writes the collected data to a file")
def collect_data(dir: str, save) -> pl.DataFrame:
    dirpath = Path.cwd() / Path(dir)
    files_to_analyze = collect_datafiles(dirpath)

    time = dt.datetime.now().strftime("%Y-%m-%d")
    data_filepath = Path.cwd() / f"analyses/similarities_{time}.parquet"

    metric = sim.get_metric("NCD", "zstd")
    similarity_df = sim.similarities_from_data(metric, files_to_analyze)
    if save:
        similarity_df.write_parquet(data_filepath.resolve())
        return similarity_df
    else:
        print(similarity_df)
        return similarity_df


@click.command()
@click.argument("filepath")
def show_file(filepath: str):
    data = load_parquet(Path(filepath))
    print(data)


@click.group()
def cli():
    pass


cli.add_command(get_similarities)
cli.add_command(show_file)
cli.add_command(collect_data)
