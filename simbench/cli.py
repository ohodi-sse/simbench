import click
import datetime as dt
from pathlib import Path

from .data import File, load_parquet, write_parquet, print_md_data, collect_datafiles
from . import similarity as sim
from loguru import logger
import pandas as pd


@click.command()
@click.option("--load_file")
@click.option("--file_from_dir")
def get_similarities(file_from_dir: str, load_file: str) -> pd.DataFrame:
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

        write_parquet(analysis_file, df)
        return df


@click.command()
@click.argument("dir")
@click.option("--save", default=False, help="Writes the collected data to a file")
def collect_data(dir: str, save: bool) -> pd.DataFrame:
    dirpath = Path(dir)
    df = collect_datafiles(dirpath)

    time = dt.datetime.now().strftime("%Y-%m-%d")
    data_file = dirpath / f"datafiles_{time}.parquet"

    if save:
        write_parquet(data_file, df)
        return df
    else:
        return df


@click.command()
@click.argument("filepath")
def show_file(filepath: Path):
    data = load_parquet(filepath)
    formatted = print_md_data(data)
    print(formatted)


@click.group()
def cli():
    pass


cli.add_command(get_similarities)
cli.add_command(show_file)
cli.add_command(collect_data)

if __name__ == "__main__":
    cli()
