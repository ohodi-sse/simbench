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
import itertools
from collections import deque
import matplotlib.colors as mcolors
from simbench.build import Builder


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
    ax.axes.yaxis.set_ticks([])
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


def fscore_plot_node(ax: Axes, distances: pl.LazyFrame) -> Axes:
    assert distances.collect_schema() == schema(DistanceTable), (
        "Must provide a distance file to plot f-score"
    )
    df = distances.collect()
    df = df.sort(by="distance")
    print(df)

    Tot = df.height
    print(Tot)
    Relevant = df["src_label"] == df["tgt_label"]
    F = df["src_label"] != df["tgt_label"]
    S = df["distance"]

    RelevantRet = Relevant.cum_sum()
    TotRet = RelevantRet + F.cum_sum()
    TotRelevant = Relevant.sum()

    Prec = RelevantRet / TotRet
    Recall = RelevantRet / TotRelevant

    F1 = [2 * p * c / (p + c) if p + c > 0 else 0 for (p, c) in zip(Prec, Recall)]

    ax.plot(S, Prec, label="Prec")
    ax.plot(S, Recall, label="Recall")
    ax.plot(S, F1, label="F1")
    ax.plot(S, RelevantRet / TotRelevant, label="Counted")

    ax.set_xlabel("Distance")
    ax.set_ylabel("Score")
    ax.legend(loc="upper right")
    ax.set_title("Scores for distances")

    return ax


def fscore_classification_plot_node(
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
    ax.set_title(f"Performance of {classifier}")

    return ax


@figurenode
def fscore_overview_figure(
    bld: Builder,
    distances,
    performances,
):
    classifier_types = pl.Series(
        performances.collect().select(pl.col("classifier")).unique()
    ).to_list()

    fig, axes = plt.subplots(
        len(classifier_types) + 1, 1, sharey=True, layout="constrained"
    )
    fig.suptitle("Performance scores", fontsize=16)
    fscore_plot_node(ax=axes[0], distances=distances)

    for i, classifier in enumerate(classifier_types):
        tmp_perf_df = performances.filter(pl.col("classifier") == classifier)
        fscore_classification_plot_node(ax=axes[i + 1], performance=tmp_perf_df)

    return fig


@figurenode
def classification_overview_figure(bld: Builder, **classifications):
    fig, axes = plt.subplots(len(classifications), 2)

    for i, (_, classification) in enumerate(classifications.items()):
        classification_plot(ax=axes[i, 0], classifications=classification)
        confusion_matrix_plot(ax=axes[i, 1], classifications=classification)

    return fig
