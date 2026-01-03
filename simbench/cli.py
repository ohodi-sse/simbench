import click
from pathlib import Path

from simbench.build import (
    Builder,
    Suite,
    analyse_classifications,
    comp_tool_analysis,
)
from simbench.plots import (
    create_nclass_classification_plot,
    f_score_classification_plot,
    f_score_plot,
)

from simbench.analysis import Config
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
        cfg.log.info(f"Computing classifications for {tool}")

        class_nodes = {}
        for classifier in cfg.classifiers:
            if not classifier.matches(classifier_pattern):
                cfg.log.debug(f"Skipping {classifier}")
                continue

            classification_node = comp_tool_analysis(
                tool=tool, classifier=classifier, suite=Suite(suite)
            )

            class_nodes[f"{classifier.name}-{classifier.param}"] = classification_node

        performance_node = analyse_classifications(tool, Suite(suite), **class_nodes)
        performance_node.pull(bld)


@click.command("plot-cl")
@click.argument("file", type=click.Path(exists=True))
def plot_classification(file: Path) -> None:
    classifications = pl.scan_parquet(file)
    create_nclass_classification_plot(classifications)
    click.echo("Done")


@click.command("plot-f")
@click.argument("file", type=click.Path(exists=True))
def plot_fscore(file: Path) -> None:
    distances = pl.scan_parquet(file)
    f_score_plot(distances)
    click.echo("Done")


@click.command("plot-fcl")
@click.argument("file", type=click.Path(exists=True))
def plot_fscore_cl(file: Path) -> None:
    performances = pl.scan_parquet(file)
    f_score_classification_plot(performances)
    click.echo("Done")


cli.add_command(show_file)
cli.add_command(analyse)
cli.add_command(plot_classification)
cli.add_command(plot_fscore)
cli.add_command(plot_fscore_cl)
