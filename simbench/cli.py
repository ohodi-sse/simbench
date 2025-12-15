import sys
import matplotlib.pyplot as plt
import click
from pathlib import Path

from simbench.plots import (
    create_nclass_classification_plot,
    f_score_classification_plot,
    f_score_plot,
)
from . import data
from simbench.analysis import Config, Analysis
from simbench.classification import get_performance

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
@click.option(
    "--classifier",
    "classifier_pattern",
    help="filter on which classifiers to run",
    default=".*",
)
@click.pass_obj
def analyse(cfg, suite, tool_pattern, classifier_pattern, force):
    for tool in cfg.tools:
        if not tool.matches(tool_pattern):
            cfg.log.debug(f"Skipping {tool}")
            continue

        analysis = Analysis(suite, tool)
        cfg.log.info(f"Working on {analysis.path}, force={force}")

        cfg.log.info("Computing compressions")
        comp_df = analysis.compressions(cfg, update=force)
        cfg.log.info(comp_df.collect())
        cfg.log.info("Computing pairwise compressions")
        pair_comp_df = analysis.pairwise_compressions(cfg, update=force)
        cfg.log.info("Extrapolating distances")
        dist_df = analysis.distances(comp_df, pair_comp_df, update=force)

        class_df = data.ClassificationTable.lazyframe()
        for classifier in cfg.classifiers:
            if not classifier.matches(classifier_pattern):
                cfg.log.debug(f"Skipping {classifier}")
                continue

            class_df = pl.concat([class_df, classifier.classifications(dist_df)])

        perf_df = get_performance(class_df)
        logger.debug(f"Performance:\n {perf_df.collect()}")
        f_score_classification_plot(perf_df)

        f_score_plot(dist_df)
        plt.show()


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


# @click.command()
# @click.argument("file", type=click.Path(exists=True))
# def fscore(file: Path) -> None:
#     dist_df = pl.scan_parquet(file)
#     assert dist_df.collect_schema() == data.DistanceTable.schema, (
#         "Can only calculate F-score from distance file"
#     )
#
#     plot = get_performance_scikit(dist_df)
#
#     plt.show()
#

cli.add_command(show_file)
cli.add_command(analyse)
cli.add_command(plot_classification)
