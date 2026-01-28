from matplotlib import pyplot as plt
import numpy as np
import polars as pl
from statsmodels.graphics.mosaicplot import mosaic
from sklearn.metrics import (
    confusion_matrix,
    ConfusionMatrixDisplay,
)

from simbench.build import figurenode, schema
from simbench.tables import ClassificationTable, DistanceTable

from matplotlib.patches import Patch
from matplotlib.axes import Axes
from matplotlib import font_manager

import itertools
from math import log2
from collections import deque
import matplotlib.colors as mcolors
from simbench.build import Builder
from loguru import logger


def confusion_matrix_plot(ax: Axes, classifications: pl.LazyFrame) -> Axes:
    src_labels = pl.Series(classifications.select("src_label").collect()).to_list()
    labelled_as = pl.Series(classifications.select("labelled_as").collect()).to_list()
    labels = list(set(src_labels))

    cm = confusion_matrix(src_labels, labelled_as, labels=labels)
    disp = ConfusionMatrixDisplay(confusion_matrix=cm, display_labels=labels)
    disp.plot(ax=ax)
    return ax


def classification_plot(ax: Axes, classifications: pl.LazyFrame) -> Axes:
    assert classifications.collect_schema() == schema(ClassificationTable), (
        "The provided data is not a classification dataframe"
    )

    classifier_name = classifications.select("classifier").unique().collect().item()
    classifier_param = int(
        classifications.select("class_param").unique().collect().item()
    )

    classes = pl.Series(
        classifications.select("src_label").unique().collect()
    ).to_list()
    n_classes = len(classes)

    clfy_per_group = [
        [
            classifications.filter(
                (pl.col("src_label") == clabel) & (pl.col("labelled_as") == label)
            )
            .collect()
            .height
            for label in classes
        ]
        for clabel in classes
    ]
    class_lists = [range(n_classes)] * 2
    mosaic_tuples = tuple(itertools.product(*class_lists))

    res_list = deque(clfy_per_group[0])
    for i, v in enumerate(clfy_per_group):
        if i == 0:
            pass
        else:
            tmp = deque(v)
            tmp.rotate(-i)
            res_list += tmp

    data_dict = {t: res_list[i] for i, t in enumerate(mosaic_tuples)}

    plt.rcParams.update({"font.size": 16})

    font_color = "#2c3e50"

    cmap = plt.get_cmap("nipy_spectral")

    pallet = [mcolors.to_hex(cmap(i)) for i in np.linspace(0, 1, n_classes)]
    colors = deque(pallet[:n_classes])
    all_colors = []
    for i in range(n_classes):
        if i > 0:
            colors.rotate(-1)
        all_colors.extend(colors)

    props = {
        (str(a), str(b)): {"color": all_colors[i]}
        for i, (a, b) in enumerate(mosaic_tuples)
    }

    mosaic(data_dict, labelizer=lambda k: "", properties=props, ax=ax)

    title_font_dict = {
        "fontsize": 20,
        "color": font_color,
    }
    axis_label_font_dict = {
        "fontsize": 16,
        "color": font_color,
    }

    ax.tick_params(axis="x", which="both", bottom=False, top=False)
    # ax.axes.yaxis.set_ticks([])
    ax.tick_params(axis="x", which="major", labelsize=14)

    labels = [n for n in classes]
    step = 1.0 / len(classes)
    ticks = np.arange(0 + step / 2, 1 + step / 2, step)
    ax.set_xticks(ticks, labels)
    ax.set_title(
        f"Classification Report using {classifier_name}-{classifier_param}",
        fontdict=title_font_dict,
        pad=25,
    )
    ax.set_xlabel("Observed Class", fontdict=axis_label_font_dict, labelpad=10)
    ax.set_ylabel("Predicted Class", fontdict=axis_label_font_dict, labelpad=35)

    legend_elements = [
        Patch(facecolor=all_colors[i], label=f"Class {name}")
        for i, name in enumerate(classes)
    ]
    ax.legend(handles=legend_elements, bbox_to_anchor=(1, 1.018), fontsize=16)

    return ax


def classification_dist_v_elements_plot(
    ax: Axes, toolname, linetype, linecolor, distances: pl.LazyFrame
) -> Axes:
    assert distances.collect_schema() == schema(DistanceTable), (
        "Must provide a distance file to plot f-score"
    )
    df = distances.collect()
    df = df.sort(by="distance").filter(pl.col("src") != pl.col("tgt"))

    Relevant = df["src_label"] == df["tgt_label"]
    F = df["src_label"] != df["tgt_label"]
    S = Relevant.cum_sum() + F.cum_sum()

    # ax.set_xscale("log")
    ax.plot(
        S,
        df["distance"],
        label=f"Distance d for {toolname if toolname else ''}",
        linestyle="-.",
        color=linecolor,
        linewidth=2,
    )
    return ax


def classification_probability_plot(
    ax: Axes,
    toolname,
    linetype: str | None,
    linecolor: str | None,
    distances: pl.LazyFrame,
) -> Axes:
    assert distances.collect_schema() == schema(DistanceTable), (
        "Must provide a distance file to plot f-score"
    )
    df = distances.collect()
    df = df.sort(by="distance").filter(pl.col("src") != pl.col("tgt"))

    Relevant = df["src_label"] == df["tgt_label"]
    F = df["src_label"] != df["tgt_label"]
    S = Relevant.cum_sum() + F.cum_sum()
    max_elements = len(df["distance"].to_list())

    RelevantRet = Relevant.cum_sum()
    TotRet = RelevantRet + F.cum_sum()
    Prec = RelevantRet / TotRet

    # TotRelevant = Relevant.sum()
    # Recall = RelevantRet / TotRelevant
    # F1 = [2 * p * c / (p + c) if p + c > 0 else 0 for (p, c) in zip(Prec, Recall)]
    # ax.plot(S, F1, label=f"F1 {toolname if toolname else ''}")
    ax.set_xscale("log")
    ax.plot(
        S,
        Prec,
        label=f"{toolname if toolname else 'score'}",
        linestyle=f"{linetype if linetype else '-'}",
        color=linecolor,
        linewidth=2,
    )
    # ax.xaxis.set_major_formatter(StrMethodFormatter("{x:.0f}"))

    ax.grid(True, which="both")
    ax.set_xlim(0.0, max_elements)
    ax.set_ylim(0.0, 1.02)
    ax.set_xlabel("n", fontsize=24)
    ax.set_ylabel("P( a = b | dist(a,b) <= d)", fontsize=24)
    ax.legend(loc="lower left", fontsize=24)

    return ax


def entropy_plot(ax: Axes, toolname: str | None, distances: pl.LazyFrame) -> Axes:
    assert distances.collect_schema() == schema(DistanceTable), (
        "Must provide a distance file to plot f-score"
    )
    df = distances.collect()
    df = df.sort(by="distance").filter(pl.col("src") != pl.col("tgt"))

    Relevant = df["src_label"] == df["tgt_label"]
    F = df["src_label"] != df["tgt_label"]
    S = df["distance"]

    RelevantRet = Relevant.cum_sum()
    TotRet = RelevantRet + F.cum_sum()
    Prec = RelevantRet / TotRet

    Entropy = [
        (-px) * log2(px) - (1 - px) * log2(1 - px) if px != 1.0 else 0.0 for px in Prec
    ]

    ax.plot(S, Entropy, label=f"Entropy {toolname if toolname else ''}")

    ax.set_xlabel("Distance")
    ax.set_xlim(0.0, 1.0)
    ax.grid(True)
    ax.set_ylabel("Score")
    ax.legend(loc="upper right")
    ax.set_title("Scores for distances")

    return ax


def cluster_plot(ax: Axes, toolname: str | None, distances: pl.LazyFrame) -> Axes:
    assert distances.collect_schema() == schema(DistanceTable), (
        "Must provide a distance file to plot f-score"
    )
    df = distances.collect()
    df = df.sort(by="distance").filter(pl.col("src") != pl.col("tgt"))

    Relevant = df["src_label"] == df["tgt_label"]
    F = df["src_label"] != df["tgt_label"]
    S = df["distance"]

    RelevantRet = Relevant.cum_sum()
    TotRet = RelevantRet + F.cum_sum()
    TotRelevant = Relevant.sum()
    Total = TotRelevant + F.sum()

    avg_cluster_size = TotRet / Total
    ax.plot(S, avg_cluster_size, label="Avg cluster size as % of all points")

    ax.set_xlabel("Distance")
    ax.set_xlim(0.0, 1.0)
    ax.set_ylabel("Score")
    ax.legend(loc="upper right", fontsize=48)
    ax.set_title("Scores for distances")

    return ax


def fscore_classification_plot(
    ax: Axes,
    performance: pl.LazyFrame,
) -> Axes:
    perf_df = performance.collect()
    print(perf_df.sort(by="F1", descending=True))
    classifier = perf_df["classifier"].item(0)
    params = perf_df["class_param"]
    ax.plot(params, perf_df["Prec"], label="Precision")
    ax.plot(params, perf_df["Rec"], label="Recall")
    ax.plot(params, perf_df["F1"], label="F1")
    ax.set_xlabel("Parameter")
    ax.set_ylabel("Score")
    ax.legend(loc="upper right")
    if classifier == "thrsh":
        ax.set_xlim(0.0, 1.0)
    else:
        ax.set_xlim(0, 100)
    ax.set_title(f"Performance of {classifier}")

    return ax


@figurenode
def fscore_overview_figure(
    bld: Builder,
    distances,
    performances,
    normalizer,
):
    classifier_types = pl.Series(
        performances.collect().select(pl.col("classifier")).unique()
    ).to_list()

    fig, axes = plt.subplots(
        len(classifier_types) + 1, 1, sharey=True, layout="constrained"
    )
    fig.suptitle(f"Performance scores on {normalizer.name} data", fontsize=16)
    entropy_plot(ax=axes[0], toolname=None, distances=distances)
    cluster_plot(ax=axes[0], toolname=None, distances=distances)
    classification_probability_plot(
        ax=axes,
        toolname="dummy",  # analysis.tool.name,
        linetype=":",  # style[0],
        linecolor="r",  # style[1],
        distances=distances,
    )
    for i, classifier in enumerate(reversed(sorted(classifier_types))):
        tmp_perf_df = performances.filter(pl.col("classifier") == classifier)
        fscore_classification_plot(ax=axes[i + 1], performance=tmp_perf_df)

    return fig


@figurenode
def classification_overview_figure(bld: Builder, **classifications):
    fig, axes = plt.subplots(len(classifications), 2)

    for i, (_, classification) in enumerate(classifications.items()):
        classification_plot(ax=axes[i, 0], classifications=classification)
        confusion_matrix_plot(ax=axes[i, 1], classifications=classification)

    return fig


def analysis_styling(analyses, colors) -> dict[str, tuple[str, str]]:
    styling = {}

    linestyles = ["-", "--", "-.", ":", "None", " ", ""]

    colormap = {}
    linemap = {}
    if len(analyses) > len(colors):
        logger.warning("Not enough colors!")

    n_norms = len(set([a.normalizer for a in analyses]))

    for i, analysis in enumerate(analyses):
        tool = analysis.tool.name
        norm = analysis.normalizer.name

        if norm not in linemap.keys():
            linemap[norm] = linestyles[int(i) % len(colors)]

        if tool not in colormap.keys():
            colormap[tool] = colors[int(i / n_norms) % len(colors)]

        linecolor = colormap[tool]
        linetype = linemap[norm]

        styling[analysis.parameter_name] = (linetype, linecolor)

    return styling


def plot_critical_line(ax: Axes) -> Axes:
    from numpy import arange

    y = [r for r in arange(0.0, 1.2, 0.1)]
    ax.plot([448500 for _ in y], y, linestyle=":", color="r")

    return ax


@figurenode
def fscore_comparison_figure(
    bld: Builder,
    **analyses,
):
    font_path = "/usr/share/fonts/truetype/atkinson-hyperlegible/Atkinson-Hyperlegible-Regular-102.ttf"
    font_manager.fontManager.addfont(font_path)
    plt.rcParams["font.family"] = "Atkinson Hyperlegible"

    size_mul = 2
    fig, axes = plt.subplots(
        1,
        1,
        sharey=True,
        layout="constrained",
        figsize=(size_mul * 10, size_mul * 5.625),
    )

    github_light_syntax_colors = [
        "#CF222E",  # GitHub red
        "#8250DF",  # purple for functions
        "#116329",  # green for types
        "#0550AE",  # blue for numeric constants
        "#DBAB09",  # Yellow accents
        "#1F2328",  # default text color
        "#6A737D",  # neutral gray for comments
    ]

    styles = analysis_styling(
        [v for v in analyses.values()], github_light_syntax_colors
    )
    tools = set([a.tool.name for a in analyses.values()])
    plot_critical_line(ax=axes)
    for i, (name, analysis) in enumerate(analyses.items()):
        naming = f"{analysis.tool.name} on {analysis.normalizer.name} data"
        if len(tools) > 1:
            style = styles[name]
            classification_probability_plot(
                ax=axes,
                toolname=naming,
                linetype=style[0],
                linecolor=style[1],
                distances=analysis.distance_node.pull(bld),
            )
        else:
            classification_probability_plot(
                ax=axes,
                toolname=naming,
                linetype=None,
                linecolor=github_light_syntax_colors[i],
                distances=analysis.distance_node.pull(bld),
            )

    return fig
