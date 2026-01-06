import click
from pathlib import Path

from simbench.build import (
    Builder,
    Suite,
)

from simbench.analysis import (
    Analysis,
)

from simbench.analysis import Config
import polars as pl
from loguru import logger
import matplotlib.pyplot as plt


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
    "--classifier",
    "classifier_pattern",
    help="filter on which classifiers to run",
    default=".*",
)
@click.pass_obj
def analyse(cfg, suite, tool_pattern, classifier_pattern):
    bld = Builder(logger)

    for tool in cfg.tools:
        if not tool.matches(tool_pattern):
            cfg.log.debug(f"Skipping {tool} with name: {tool.name}")
            continue
        cfg.log.info(f"Computing classifications for {tool}")

        filtered_classifiers = [
            c for c in cfg.classifiers if c.matches(classifier_pattern)
        ]
        analysis = Analysis(tool, Suite(suite), filtered_classifiers)

        analysis.performance_node.pull(bld)


@click.command()
@click.argument("suite", type=click.Path(file_okay=False, path_type=Path))
@click.option("--tool", "tool_pattern", help="filter the tools to be run", default=".*")
@click.option(
    "--classifier",
    "classifier_pattern",
    help="filter on which classifiers to run",
    default=".*",
)
@click.pass_obj
def plot(cfg, suite, tool_pattern, classifier_pattern) -> None:
    from simbench.plots import (
        fscore_plot_node,
        classification_plot_node,
        confusion_matrix_plot_node,
        fscore_classification_plot_node,
    )

    bld = Builder(logger)

    for tool in cfg.tools:
        if not tool.matches(tool_pattern):
            cfg.log.debug(f"Skipping {tool} with name: {tool.name}")
            continue

        filtered_classifiers = [
            c for c in cfg.classifiers if c.matches(classifier_pattern)
        ]
        analysis = Analysis(tool, Suite(suite), filtered_classifiers)

        fig, (ax1, ax2) = plt.subplots(1, 2, sharey=True)
        fscore_plot_node(ax=ax1, distances=analysis.distance_node).pull(bld)
        fscore_classification_plot_node(
            ax=ax2, performance=analysis.performance_node
        ).pull(bld)

        classification_nodes = analysis.classification_nodes
        fig, axes = plt.subplots(2, len(classification_nodes))
        for i, (_, classification_node) in enumerate(classification_nodes.items()):
            classification_plot_node(
                ax=axes[i, 0], classifications=classification_node
            ).pull(bld)
            confusion_matrix_plot_node(
                ax=axes[i, 1], classifications=classification_node
            ).pull(bld)

        plt.show()

    click.echo("Done")


cli.add_command(show_file)
cli.add_command(analyse)
cli.add_command(plot)
