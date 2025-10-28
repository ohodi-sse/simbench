import click
import os
import datetime as dt
from pathlib import Path
from data import load_parquet, write_parquet, File


# from similarity import create_similarity_matrix, SimilarityMetric
import similarity as sim


@click.group()
def cli(dir):
    pass


@cli.command()
@click.argument("dir")
def get_analysis(dir: str):
    dirpath = Path(os.getcwd()) / Path(dir)
    time = dt.datetime.now()
    analysis_file = dirpath / f"analysis_{time}.parquet"

    if analysis_file.is_file():
        _df = load_parquet(analysis_file)

    files = [
        File(Path(dirpath / f))
        for f in os.listdir(dirpath)
        if os.path.isfile(dirpath / f)
    ]

    metric = sim.get_metric("NCD", "zstd")
    df = sim.create_similarity_matrix(metric, files)

    write_parquet(analysis_file, df)


if __name__ == "__main__":
    cli()
