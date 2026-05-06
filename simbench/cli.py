from simbench.differs import EditDistanceLines
import os
from simbench.similarity_measures import (
    DiffMeasure,
    NormalizedDiffMeasure,
    SummedDiffMeasure,
)
from simbench.plots import (
    plot_node,
    GoodEdges,
    Histogram,
)
from simbench.normalizers import (
    IDNormalizer,
)
from simbench.comparing import wilcoxon_signed_rank_test, find_analysis_difference
import click
from pathlib import Path
import polars as pl
from loguru import logger
import matplotlib.pyplot as plt


from simbench.build import (
    Builder,
    Suite,
)

from simbench.analysis import (
    AnalysisComparison,
    Config,
    get_all_normalizers,
    init_analysis,
    get_all_tools,
    CompressionTool,
    DiffTool,
)


@click.group()
@click.pass_context
def cli(ctx):
    ctx.obj = Config()


@click.command()
@click.argument("file")
@click.option("-fl", "--filter", default=None, help="Filter on source")
@click.option(
    "--csv", "csv", default=None, help="Output the file as csv. Pairs well with xan"
)
def show_file(file: str, filter, csv) -> None:
    assert file.endswith(".parquet"), "Can only show parquet file"
    data = (
        pl.scan_parquet(Path(file))
        # .sort(by="distance", descending=True)
        # .filter(pl.col("src") != pl.col("tgt"))
    )

    if filter:
        data = data.filter(pl.col("src") == filter)

    if csv:
        print(data.collect().write_csv(file=None))
    else:
        logger.info(data.collect())


def get_filtered_analysis_comparison(
    cfg, suite, tool_pattern, normalizer_pattern, classifier_pattern, seed, samples
):
    bld = Builder(cfg.log)
    if tool_pattern != ".*" or normalizer_pattern != ".*":
        patterns = [(tool_pattern, normalizer_pattern)]
    else:
        bld.log.info("Running with prespecified filters")
        patterns = [
            (
                ".*",  # "^(zstd-9.*|.*BERT.*|Code2Vec).*",
                "(unprocessed|token_format|.*google.*|decompiled)",
            ),
        ]

    for tool_pattern, normalizer_pattern in patterns:
        filtered_tools = [t for t in cfg.tools if t.matches(tool_pattern)]
        filtered_classifiers = [
            c for c in cfg.classifiers if c.matches(classifier_pattern)
        ]
        normalizers = [
            norm for norm in get_all_normalizers() if norm.matches(normalizer_pattern)
        ]

        comparison = AnalysisComparison(
            Suite(suite, seed=seed, n_samples=samples),
            filtered_tools,
            filtered_classifiers,
            normalizers,
        )
        return comparison


@click.command()
@click.argument("file")
def count_bad(file: str) -> None:
    assert file.endswith(".parquet"), "Can only show parquet file"
    data = pl.scan_parquet(Path(file))
    bad = data.filter(pl.col("failed_emb")).collect()["failed_emb"]
    print(f"Failed to embed: {len(bad)}")


@click.command()
@click.argument("suite", type=click.Path(file_okay=False, path_type=Path))
@click.option("--tool", "tool_pattern", help="filter the tools to be run", default=".*")
@click.option(
    "--normalizer",
    "normalizer_pattern",
    help="filter the normalizers to be run",
    default=".*",
)
@click.option(
    "--classifier",
    "classifier_pattern",
    help="filter on which classifiers to run",
    default=".*",
)
@click.pass_obj
def analyse(cfg, suite, tool_pattern, normalizer_pattern, classifier_pattern):
    bld = Builder(cfg.log)

    for normalizer in cfg.normalizers:
        for tool in cfg.tools:
            if not tool.matches(tool_pattern) or not normalizer.matches(
                normalizer_pattern
            ):
                continue

            bld.log.info(
                f"Using {tool.name} on {normalizer.name} data for the following analyses!"
            )

            filtered_classifiers = [
                c for c in cfg.classifiers if c.matches(classifier_pattern)
            ]
            cfg.log.info(f"Using the following classifiers {filtered_classifiers}")
            analysis = init_analysis(
                tool, Suite(suite), filtered_classifiers, normalizer
            )

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
@click.option(
    "--normalizer",
    "normalizer_pattern",
    help="filter the normalizers to be run",
    default=".*",
)
@click.option("--show/--no-show", default=False)
@click.pass_obj
def plot_comparison(
    cfg, suite, tool_pattern, classifier_pattern, normalizer_pattern, show
):
    bld = Builder(logger)

    filtered_tools = [t for t in cfg.tools if t.matches(tool_pattern)]
    filtered_classifiers = [c for c in cfg.classifiers if c.matches(classifier_pattern)]
    normalizers = [
        norm for norm in get_all_normalizers() if norm.matches(normalizer_pattern)
    ]

    comparison = AnalysisComparison(
        Suite(suite), filtered_tools, filtered_classifiers, normalizers
    )

    plt.rcParams.update({"figure.figsize": (10, 5.625), "font.size": 16})
    comparison.performance_comparison_pdf.pull(bld)
    if show:
        plt.show()

    click.echo("Done")


@click.command()
@click.argument("suite", type=click.Path(file_okay=False, path_type=Path))
@click.option("--tool", "tool_pattern", help="filter the tools to be run", default=".*")
@click.option(
    "--classifier",
    "classifier_pattern",
    help="filter on which classifiers to run",
    default=".*",
)
@click.option(
    "--normalizer",
    "normalizer_pattern",
    help="filter the normalizers to be run",
    default=".*",
)
@click.option("--show/--no-show", default=False)
@click.option("--force", default=None, is_flag=True)
@click.option("--seed", default=None, type=int)
@click.option("--samples", default=None, type=int)
@click.pass_obj
def perr_table_comparisons(
    cfg,
    suite,
    tool_pattern,
    classifier_pattern,
    normalizer_pattern,
    show,
    force,
    seed,
    samples,
):
    bld = Builder(logger)

    comparison = get_filtered_analysis_comparison(
        cfg,
        suite,
        tool_pattern,
        normalizer_pattern,
        classifier_pattern,
        seed,
        samples,
    )

    if force and Path(comparison.comparison_evaluation_table_file).exists():
        os.remove(comparison.comparison_evaluation_table_file)

    if force and Path(comparison.comparison_performance_table_file).exists():
        os.remove(comparison.comparison_performance_table_file)

    performance_table = comparison.performance_table_comparison.pull(bld).collect()
    evaluation_table = comparison.evaluation_table_comparison.pull(bld).collect()

    if show:
        print(evaluation_table)
        print(performance_table)
        # latex_table = dataframe_as_latex_table(evaluation_table)
        # print(latex_table)


@click.command()
@click.argument("suite", type=click.Path(file_okay=True, path_type=Path))
@click.argument("tool_pattern")
@click.argument("normalizer_pattern_1")
@click.argument("normalizer_pattern_2")
@click.option("--seed", default=None)
def diff_normalizer(
    suite: Path, tool_pattern: str, normalizer_pattern_1, normalizer_pattern_2, seed
):
    from simbench.classification import KNN

    tool = [t for t in get_all_tools() if t.matches(tool_pattern)]
    assert len(tool) == 1, (
        f"The pattern {tool_pattern} returns {tool}. The pattern must specify exactly one tool"
    )

    normalizers = get_all_normalizers()
    normalizer1 = [norm for norm in normalizers if norm.matches(normalizer_pattern_1)]
    assert len(normalizer1) == 1, (
        f"The pattern {normalizer_pattern_1} returns {normalizer1}. The pattern must specify exactly one normalizer from {[n.name for n in normalizers]}"
    )
    normalizer2 = [norm for norm in normalizers if norm.matches(normalizer_pattern_2)]
    assert len(normalizer2) == 1, (
        f"The pattern {normalizer_pattern_2} returns {normalizer2}. The pattern must specify exactly one normalizer from {[n.name for n in normalizers]}"
    )

    analysis1 = init_analysis(tool[0], Suite(suite), [KNN(1)], normalizer1[0])
    analysis2 = init_analysis(tool[0], Suite(suite), [KNN(1)], normalizer2[0])

    find_analysis_difference(analysis1, analysis2, seed)


@click.command()
@click.argument("suite", type=click.Path(file_okay=True, path_type=Path))
@click.option("--force", default=None, is_flag=True)
def perr_plot(suite: Path, force: bool):
    from simbench.classification import KNN

    bld = Builder(logger)

    diff = init_analysis(
        DiffTool(DiffMeasure(), EditDistanceLines()),
        Suite(suite),
        [KNN(1)],
        IDNormalizer(),
    )

    normdiff = init_analysis(
        DiffTool(NormalizedDiffMeasure(), EditDistanceLines()),
        Suite(suite),
        [KNN(1)],
        IDNormalizer(),
    )

    fig, ax = plt.subplots(1, 2, figsize=(8, 3), layout="constrained")

    histogram = Histogram()
    ax[0].set_ylabel("Frequency")
    histogram.compute_data(bld, diff, ax[0], "diff max")
    histogram.compute_data(bld, normdiff, ax[1], "diff norm")

    plot_name = "diff_unprocessed_histogram.pdf"
    bld.log.debug("Saving plot to file: " + plot_name)
    plt.savefig(plot_name, dpi=300, bbox_inches="tight")
    plt.show()


@click.command()
@click.argument("file1", type=click.Path(file_okay=True, path_type=Path))
@click.argument("file2", type=click.Path(file_okay=True, path_type=Path))
@click.option("--key", default="distance")
def wilcoxon(file1, file2, key):
    wilcoxon_signed_rank_test(file1, file2, key)


cli.add_command(perr_plot)
cli.add_command(wilcoxon)
cli.add_command(diff_normalizer)
cli.add_command(show_file)
cli.add_command(count_bad)
cli.add_command(analyse)
cli.add_command(plot_comparison)
cli.add_command(perr_table_comparisons)
