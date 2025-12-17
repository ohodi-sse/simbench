import sys
import matplotlib.pyplot as plt
import click
from pathlib import Path

from simbench.build import (
    Builder,
    ParquetStore,
    compute_compression,
    compute_pairwise_compressions,
    compute_distance,
    SourceStore,
)
from simbench.plots import (
    create_nclass_classification_plot,
    f_score_classification_plot,
    f_score_plot,
)
from . import data
from simbench.analysis import Config, Analysis
from simbench.classification import get_performance
from simbench.build import Node
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
    bld = Builder(logger)

    for tool in cfg.tools:
        if not tool.matches(tool_pattern):
            cfg.log.debug(f"Skipping {tool}")
            continue

        analysis = Analysis(suite, tool)
        sources = list(analysis.sources())
        comp_st = ParquetStore(
            analysis.compression_file, pl.Schema(data.CompressionTable.schema())
        )

        dependencies = {
            s.name: SourceStore(data.Source(s.path)) for s in analysis.sources()
        }

        @Node.from_action
        def comp(bld, **kwargs):
            compute_compression(bld, tool, **kwargs)

        comp_node = comp(comp_st, **dependencies)
        print("Calculated compressions")

        pair_st = ParquetStore(
            analysis.pairwise_compression_file,
            pl.Schema(data.ComparisonCompressionTable.schema()),
        )

        @Node.from_action
        def pairwise(bld, **kwargs):
            compute_pairwise_compressions(bld, tool, **kwargs)

        pairwise_node = pairwise(pair_st, **dependencies)

        dist_deps = {"comp_df": comp_node, "compare_comp_df": pairwise_node}

        @Node.from_action
        def dist(bld, **kwargs):
            compute_distance(bld, tool, **kwargs)

        dist_st = ParquetStore(
            analysis.distance_file, pl.Schema(data.DistanceTable.schema())
        )

        dist_node = dist(dist_st, **dist_deps).pull(bld)


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
