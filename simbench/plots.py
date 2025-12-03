from matplotlib import pyplot as plt
import numpy as np
import polars as pl
import simbench.classification as cla
from . import data as dt
from statsmodels.graphics.mosaicplot import mosaic
from sklearn.metrics import (
    confusion_matrix,
    ConfusionMatrixDisplay,
)

from matplotlib.patches import Patch
import itertools
from collections import deque
import matplotlib.colors as mcolors
from loguru import logger
from indicatif import ProgressBar, ProgressStyle


def create_nclass_classification_plot(classification_df: pl.LazyFrame):
    assert classification_df.collect_schema() == dt.ClassificationTable.schema, (
        "The provided data is not a valid confusion matrix"
    )

    plots = []

    classifier_name = classification_df.select("classifier").unique().collect().item()
    classes = pl.Series(
        classification_df.select("src_label").unique().collect()
    ).to_list()
    n_classes = len(classes)
    logger.debug(classification_df.collect())
    clfy_per_group = [
        [
            classification_df.filter(
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

    data = {t: res_list[i] for i, t in enumerate(mosaic_tuples)}

    fig, ax = plt.subplots(figsize=(11, 10))
    plt.rcParams.update({"font.size": 16})

    font_color = "#2c3e50"

    cmap = plt.get_cmap("nipy_spectral")

    # Get n equally spaced colors from the colormap
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

    mosaic(data, labelizer=lambda k: "", properties=props, ax=ax)

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
        f"Classification Report using {classifier_name}",
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

    plt.tight_layout()
    plots.append((fig, ax))

    plt.show()
    return plots


def plot_confusion_matrix(classification_df: pl.LazyFrame) -> None:
    src_labels = pl.Series(classification_df.select("src_label").collect()).to_list()
    labelled_as = pl.Series(classification_df.select("labelled_as").collect()).to_list()
    labels = list(set(src_labels))
    logger.debug(labels)

    cm = confusion_matrix(src_labels, labelled_as, labels=labels)
    disp = ConfusionMatrixDisplay(confusion_matrix=cm, display_labels=labels)

    disp.plot()
    plt.show()


def f_score_plot(distance_df: pl.LazyFrame) -> None:
    assert distance_df.collect_schema() == dt.DistanceTable.schema, (
        "Must provide a distance file to plot f-score"
    )
    df = distance_df.collect()
    df = df.sort(by="distance")

    Tot = df.height

    R = df["src_label"] == df["tgt_label"]
    F = df["src_label"] != df["tgt_label"]

    S = df["distance"]

    TotRel = R.sum()
    FN = R.cum_sum()
    TotNRet = FN + F.cum_sum()

    print(TotNRet)

    # FP = TotF - TN
    TP = TotRel - FN

    Prec = TP / (Tot - TotNRet)
    Recall = TP / TotRel

    # F-Score
    F1 = [2 * p * c / (p + c) if p + c > 0 else 0 for (p, c) in zip(Prec, Recall)]

    plt.plot(S, Prec, label="Prec")
    plt.plot(S, Recall, label="Recall")
    plt.plot(S, F1, label="F1")

    plt.xlabel("Distance")
    plt.ylabel("Score")
    plt.title("Scoring using Best Match")

    plt.legend()
    plt.show()


def f_score_classification_plot(
    performance_df: pl.LazyFrame,
) -> None:  # tuple[Any, Any]:
    plots = []

    unique_classifiers = pl.Series(
        performance_df.select("classifier").unique().collect()
    ).to_list()

    fig, ax = plt.subplots(len(unique_classifiers))

    for i, classifier in enumerate(unique_classifiers):
        class_perf_df = performance_df.filter(pl.col("classifier") == classifier)

        Acc = pl.Series(class_perf_df.select(pl.col("Acc")).collect()).to_list()
        Prec = pl.Series(class_perf_df.select(pl.col("Prec")).collect()).to_list()
        Recall = pl.Series(class_perf_df.select(pl.col("Rec")).collect()).to_list()
        F1 = pl.Series(class_perf_df.select(pl.col("F1")).collect()).to_list()
        t_range = pl.Series(
            class_perf_df.select(pl.col("class_param")).collect()
        ).to_list()  # [i for i in range(0, len(F1))]
        t_range = [float(i) for i in t_range]

        ax[i].plot(t_range, Prec, label="Prec")
        ax[i].plot(t_range, Acc, label="Acc")
        ax[i].plot(t_range, Recall, label="Recall")
        ax[i].plot(t_range, F1, label="F1")

        ax[i].set_title(classifier)
        ax[i].set_xlabel("Distance")
        ax[i].set_ylabel("Score")
        # ax[i].title("Scoring using Radius Nearest Neighbours")
        ax[i].legend()

    return fig, ax


# def plot_mds(distance_df: pl.LazyFrame) -> None:
#     similarities = pl.Series(distance_df.select("distance").collect()).to_list()
#
#     X = []
#
#     srcs = pl.Series(distance_df.select("src").collect().unique()).to_list()
#
#     for s in srcs:
#         X.append(
#             pl.Series(
#                 distance_df.filter(pl.col("src") == s).select("distance").collect()
#             ).to_list()
#         )
#     X = np.array(X)  # The matrix is not symmetric due to the metric
#
#     logger.debug(X)
#     n = distance_df.select("src_label").collect().unique().height
#     mds = manifold.MDS(
#         n_components=n,
#         max_iter=3000,
#         eps=1e-9,
#         n_init=1,
#         random_state=42,
#         dissimilarity="precomputed",
#         n_jobs=1,
#     )
#     X_mds = mds.fit(X).embedding_
#
#     plt.scatter(X_mds[:, 0], X_mds[:, 1], color="turquoise", s=100, lw=0, label="MDS")


# def plot_all_f()


def show_plots():
    plt.show()
