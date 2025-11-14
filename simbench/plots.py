from matplotlib import pyplot as plt
import numpy as np
import polars as pl
from simbench.data import CLASSIFICATIONS_SCHEMA, CONFUSION_SCHEMA
from statsmodels.graphics.mosaicplot import mosaic
from matplotlib.patches import Patch
import itertools
from collections import deque
import matplotlib.colors as mcolors
from loguru import logger


def create_nclass_classification_plot(class_df: pl.LazyFrame):
    assert class_df.collect_schema() == CLASSIFICATIONS_SCHEMA, (
        "The provided data is not a valid confusion matrix"
    )

    plots = []

    classes = pl.Series(class_df.select("src_label").collect().unique()).to_list()
    n_classes = len(classes)
    logger.debug(classes)
    logger.debug(class_df.collect())
    clfy_per_group = [
        [
            class_df.filter(
                (pl.col("src_label") == clabel) & (pl.col("labelled_as") == label)
            )
            .collect()
            .height
            for label in classes
        ]
        for clabel in classes
    ]
    logger.debug(clfy_per_group)
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
    ax.set_title("Classification Report", fontdict=title_font_dict, pad=25)
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


def show_plots():
    plt.show()


# def create_heatmap_plots():
#     plots = []
#     for sim_id, sim_matrix in data.sim_matrices.items():
#         fig, ax = plt.subplots()
#         ax.set_title(f"Similarity heatmap: {sim_id}")
#
#         im = ax.imshow(sim_matrix, cmap="viridis", interpolation="nearest")
#         fig.colorbar(im, ax=ax)
#
#         if data.NUM_SAMPLE_DIRS > 15:
#             ax.axis("off")
#         else:
#             labels = range(1, data.NUM_SAMPLE_DIRS + 1)
#             ticks = [t for t in range(0, len(data.sample_files), data.NUM_SAMPLE_FILES)]
#             ax.set_xticks(ticks, labels)
#             ax.set_yticks(ticks, labels)
#         fig.tight_layout()
#
#         plots.append((fig, ax))
#
#     return plots
#
#
# def create_fscores_plot():
#     fig, ax = plt.subplots()
#     ax.set_title("F-scores per tool")
#
#     ax.set_xlabel("Similarity threshold")
#     ax.set_ylabel("F-score")
#
#     thresholds = np.arange(0.1, 1, 0.02)
#     for sim_id, sim_matrix in data.sim_matrices.items():
#         # Calculate F-scores (use upper triangle of the matrix for symmetric matrices)
#         fscores = [
#             data.get_fscore(
#                 np.triu(sim_matrix) if sim_matrix.isSymmetric else sim_matrix, t
#             )
#             for t in thresholds
#         ]
#         ax.plot(thresholds, fscores, label=sim_id)
#
#     ax.legend()
#     return fig, ax
#
#
# def create_confusion_plot(confusion_df: pl.LazyFrame) -> None:
#     assert confusion_df.schema == CONFUSION_SCHEMA
#     plots = []
#
#     confusion_df
#     for clfy_id, clfy_per_group in data.classification_per_group_per_tool.items():
#         fig, ax = plt.subplots()
#         ax.set_title(f"Classification heatmap: {clfy_id}")
#         clfy_per_group = (clfy_per_group - np.min(clfy_per_group)) / (
#             np.max(clfy_per_group) - np.min(clfy_per_group)
#         )  # Normalize to [0, 1]
#         im = ax.imshow(clfy_per_group, cmap="viridis", interpolation="nearest")
#         fig.colorbar(im, ax=ax)
#
#         if data.NUM_SAMPLE_DIRS > 15:
#             ax.axis("off")
#         else:
#             labels = range(1, data.NUM_SAMPLE_DIRS + 1)
#             ticks = [i for i in range(data.NUM_SAMPLE_DIRS)]
#             ax.set_xticks(ticks, labels)
#             ax.set_yticks(ticks, labels)
#         fig.tight_layout()
#
#         plots.append((fig, ax))
#
#     return plots
