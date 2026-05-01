import os
import shutil
from simbench.evaluation import dataframe_as_latex_table
from simbench.compressors import Diff, EditDistanceDiff, Zstd
from simbench.AI_tools import Code2Vec
from simbench.metrics import (
    DiffMetric,
    NormalizedDiffMetric,
    SummedDiffMetric,
)
from simbench.plots import (
    plot_node,
    GoodEdges,
    Histogram,
    chrissers_plot,
)
from simbench.normalizers import (
    IDNormalizer,
    HashedProblemLabel,
    PartitionedProblemClasses,
    DecompileNormalizer,
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
        .sort(by="distance", descending=True)
        .filter(pl.col("src") != pl.col("tgt"))
    )

    if filter:
        data = data.filter(pl.col("src") == filter)

    if csv:
        print(data.collect().write_csv(file=None))
    else:
        logger.info(data.collect())


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
        cfg.log.info(f"Using {normalizer.name} data for the following analyses!")
        for tool in cfg.tools:
            if not tool.matches(tool_pattern) or not normalizer.matches(
                normalizer_pattern
            ):
                cfg.log.debug(
                    f"Skipping {tool} with name: {tool.name} on {normalizer.name} data"
                )
                continue
            cfg.log.info(f"Computing classifications for {tool}")

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
    if tool_pattern or normalizer_pattern:
        patterns = [(tool_pattern, normalizer_pattern)]
    else:
        bld.log.info("Running with prespecified filters")
    patterns = [
        # (".*zstd-1.*", "token_format"),
        # ("(Code2Vec).*", ".*"),
        # ("^(?!Code2Vec).*", "(unprocessed)"),  # (.*diff.*|.*NCD.*)
        (
            "^(zstd-1.*|.*BERT.*|Code2Vec).*",
            "(unprocessed|.*token.*|.*google.*|decompiled)",
        ),  # (.*diff.*|.*NCD.*)
        # ("^(?!Code2Vec).*", ".*"),
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
        if force and Path(comparison.comparison_table_file).exists():
            os.remove(comparison.comparison_table_file)

        table = comparison.table_comparison.pull(bld).collect()

        if show:
            latex_table = dataframe_as_latex_table(table)
            print(latex_table)


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
def mds_plot(suite: Path, force: bool):
    from simbench.compressors import Zstd
    from simbench.classification import KNN
    from simbench.metrics import NCD
    from simbench.normalizers import OptimizedDecompiledNormalizer

    bld = Builder(logger)
    analysis1 = init_analysis(
        CompressionTool(NCD(), Zstd(1)),
        Suite(suite),
        [KNN(1)],
        IDNormalizer(),
    )
    analysis1 = init_analysis(
        DiffTool(DiffMetric(), EditDistanceDiff()),
        Suite(suite),
        [KNN(1)],
        IDNormalizer(),
    )
    analysis5 = init_analysis(
        CompressionTool(NCD(), Zstd(1)),
        Suite(suite),
        [KNN(1)],
        DecompileNormalizer(),
    )
    analysis2 = init_analysis(
        CompressionTool(NCD(), Zstd(1)),
        Suite(suite),
        [KNN(1)],
        HashedProblemLabel(),  # OptimizedDecompiledNormalizer(),
    )
    analysis3 = init_analysis(
        CompressionTool(NCD(), Zstd(1)),
        Suite(suite),
        [KNN(1)],
        PartitionedProblemClasses(25),  # OptimizedDecompiledNormalizer(),
    )

    analysis4 = init_analysis(
        CompressionTool(NCD(), Zstd(1)),
        Suite(suite),
        [KNN(1)],
        PartitionedProblemClasses(5),  # OptimizedDecompiledNormalizer(),
    )
    # analysis5 = init_analysis(
    #     GenericTool(GenericMetric(), Code2Vec()),
    #     Suite(suite),
    #     [KNN(1)],
    #     IDNormalizer(),
    # )
    fig, ax = plt.subplots(1, 1)
    good_edges = plot_node(GoodEdges())
    good_edges(bld, analysis1, ax, xlog=True, force=force)
    good_edges(bld, analysis2, ax, xlog=True, force=force)
    good_edges(bld, analysis3, ax, xlog=True, force=force)
    good_edges(bld, analysis4, ax, xlog=True, force=force)
    good_edges(bld, analysis5, ax, xlog=True, force=force)
    #
    # cluster_plot = plot_node(BiggestCluster())
    # cluster_plot(bld, analysis1, ax[1], xlog=True, force=force)
    # cluster_plot(bld, analysis2, ax[1], xlog=True, force=force)
    # cluster_plot(bld, analysis3, ax[1], xlog=True, force=force)
    # cluster_plot(bld, analysis4, ax[1], xlog=True, force=force)
    # cluster_plot(bld, analysis5, ax[1], xlog=True, force=force)
    #
    # good_majority = plot_node(GoodMajorityCluster())
    # good_majority(bld, analysis1, ax[2], xlog=True, force=force)
    # good_majority(bld, analysis2, ax[2], xlog=True, force=force)
    # good_majority(bld, analysis3, ax[2], xlog=True, force=force)
    # good_majority(bld, analysis4, ax[2], xlog=True, force=force)
    # good_majority(bld, analysis5, ax[2], xlog=True, force=force)

    plt.show()

    # cluster_boxplot(bld, analysis1, analysis2)
    # mds_clustering_plot(bld, analysis1)


@click.command()
@click.argument("suite", type=click.Path(file_okay=True, path_type=Path))
@click.option("--force", default=None, is_flag=True)
def perr_plot(suite: Path, force: bool):
    from simbench.compressors import Zstd
    from simbench.classification import KNN
    from simbench.metrics import NCD
    from simbench.normalizers import OptimizedDecompiledNormalizer

    bld = Builder(logger)

    diff = init_analysis(
        DiffTool(DiffMetric(), EditDistanceDiff()),
        Suite(suite),
        [KNN(1)],
        IDNormalizer(),
    )

    normdiff = init_analysis(
        DiffTool(NormalizedDiffMetric(), EditDistanceDiff()),
        Suite(suite),
        [KNN(1)],
        IDNormalizer(),
    )
    sumdiff = init_analysis(
        DiffTool(SummedDiffMetric(), EditDistanceDiff()),
        Suite(suite),
        [KNN(1)],
        IDNormalizer(),
    )
    fig, ax = plt.subplots(1, 3, figsize=(8, 3), layout="constrained")

    histogram = Histogram()
    ax[0].set_ylabel("Frequency")
    histogram.compute_data(bld, diff, ax[0], "diff max")
    histogram.compute_data(bld, normdiff, ax[1], "diff norm")
    histogram.compute_data(bld, sumdiff, ax[2], "diff sum")

    plot_name = "diff_unprocessed_histogram.pdf"
    bld.log.debug("Saving plot to file: " + plot_name)
    plt.savefig(plot_name, dpi=300, bbox_inches="tight")
    plt.show()


@click.command()
@click.argument("suite", type=click.Path(file_okay=True, path_type=Path))
@click.option("--force", default=None, is_flag=True)
def perr_fit(suite: Path, force: bool):
    from simbench.compressors import Zstd
    from simbench.classification import KNN
    from simbench.metrics import NCD
    from simbench.normalizers import OptimizedDecompiledNormalizer

    bld = Builder(logger)

    plt.savefig("christians_plot_ide.pdf", dpi=300, bbox_inches="tight")
    plt.show()


@click.command()
@click.argument("file1", type=click.Path(file_okay=True, path_type=Path))
@click.argument("file2", type=click.Path(file_okay=True, path_type=Path))
@click.option("--key", default="distance")
def wilcoxon(file1, file2, key):
    wilcoxon_signed_rank_test(file1, file2, key)


cli.add_command(mds_plot)
cli.add_command(perr_plot)
cli.add_command(perr_fit)
cli.add_command(wilcoxon)
cli.add_command(diff_normalizer)
cli.add_command(show_file)
cli.add_command(analyse)
cli.add_command(plot_comparison)
cli.add_command(perr_table_comparisons)
