import os
from abc import abstractmethod
from matplotlib import pyplot as plt
import numpy as np
import polars as pl
from statsmodels.graphics.mosaicplot import mosaic
from sklearn.metrics import (
    confusion_matrix,
    ConfusionMatrixDisplay,
)
from sklearn import manifold

from simbench.build import (
    figurenode,
    schema,
    Node,
    Constant,
    DataFrameStore,
)
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


class Plot:
    name: str
    xlabel: str
    ylabel: str
    title: str | None

    @abstractmethod
    def compute_data(self, bld, analysis): ...

    def plot(self, data: pl.DataFrame, ax: Axes, label: str, xlog=False, ylog=False):
        if xlog:
            ax.set_xscale("log")
        if ylog:
            ax.set_yscale("log")

        if self.title:
            ax.set_title(self.title)
            ax.legend(loc="lower right")

        ax.set_xlabel(self.xlabel)
        ax.set_ylabel(self.ylabel)
        ax.grid(True, which="both", color="0.9")

        ax.plot(data["x"], data["y"], label=label)
        plt.rcParams.update({"text.usetex": True, "font.family": "Helvetica"})
        return ax


def plot_node(plotter: Plot):
    def plot_analysis(
        bld: Builder, analysis, ax: Axes, force=False, xlog=False, ylog=False
    ):
        plot_dir = analysis.suite.root / "results" / "plot_data"
        plot_dir.mkdir(parents=True, exist_ok=True)

        plot_file = plot_dir / f"{analysis.parameter_name}_{plotter.name}.parquet"

        if force and plot_file.exists():
            os.remove(plot_file)
            bld.log.info(f"Deleted {plot_file} to update plot")

        node = Node(
            plotter.compute_data,
            DataFrameStore(plot_file),
            {"analysis": Constant(analysis)},
        )
        data = node.pull(bld)

        plot_label = f"{analysis.parameter_name}"
        plotter.plot(data, ax, label=plot_label, xlog=xlog, ylog=ylog)

    return plot_analysis


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

    df = distances.collect().sort(by="distance").filter(pl.col("src") != pl.col("tgt"))

    Relevant = df["src_label"] == df["tgt_label"]
    F = df["src_label"] != df["tgt_label"]

    RelevantRet = Relevant.cum_sum()
    TotRet = RelevantRet + F.cum_sum()
    max_elements = len(df["distance"].to_list())
    Prec = RelevantRet / TotRet

    ax.set_xscale("log")
    ax.plot(
        TotRet,
        Prec,
        label=f"{toolname if toolname else 'score'}",
        linestyle=f"{linetype if linetype else '-'}",
        color=linecolor,
        linewidth=2,
    )

    ax.grid(True, which="both")
    ax.set_xlim(0.0, max_elements)
    ax.set_ylim(0.0, 1.02)
    ax.set_xlabel("n", fontsize=24)
    ax.set_ylabel("P( a = b | dist(a,b) <= d_n)", fontsize=24)
    ax.legend(loc="lower left", fontsize=24)
    ax.set_title(
        "Probability of correctly classifying programs by taking edges in ascending order"
    )
    return ax


def entropy_plot(ax: Axes, toolname: str | None, distances: pl.LazyFrame) -> Axes:
    assert distances.collect_schema() == schema(DistanceTable), (
        "Must provide a distance file to plot f-score"
    )

    df = distances.collect().sort(by="distance").filter(pl.col("src") != pl.col("tgt"))
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
    ax.legend(loc="upper right")
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
    # (5*300) * (5*300 - 1)
    ax.plot([448500 for _ in y], y, linestyle=":", color="r")

    return ax


def mds_clustering_plot(bld: Builder, analysis):
    dist_df = analysis.distance_node.pull(bld).sort(by=["src_label", "src"]).collect()
    labels = dist_df.select("src_label").unique().to_list()
    srcs = pl.Series(dist_df.select("src").unique()).to_list()

    best_matrix = [
        dist_df.filter(pl.col("src") == src).sort(by="tgt")["distance"] for src in srcs
    ]

    # Add noise to avoid cancellation
    rng = np.random.RandomState(seed=4)
    noise = rng.rand(1500, 1500)

    best_matrix = best_matrix + noise

    # MDS needs a symmetric matrix so we cheat :)
    upper_tri_distances = np.tril(np.array(best_matrix))
    distances = np.where(
        upper_tri_distances, upper_tri_distances, upper_tri_distances.T
    )

    # Set diagonal to 0
    np.fill_diagonal(distances, 0)

    mds = manifold.MDS(
        n_components=2,
        max_iter=3000,
        random_state=23,
        n_jobs=1,
        metric=True,
        dissimilarity="precomputed",
        verbose=1,
    )

    X_mds = mds.fit(
        distances,
    ).embedding_

    # pca = PCA(n_components=2)
    # pca.fit_transform(X_mds)
    colors = ["red", "green", "yellow", "blue", "black"]
    fig, ax = plt.subplots(1, 1)
    for i in range(0, 5):
        ax.scatter(
            X_mds[(300 * i) : (300 * (i + 1) + 1), 0],
            X_mds[(300 * i) : (300 * (i + 1) + 1), 1],
            color=colors[i],
            label=labels[i],
        )

    ax.legend()
    plt.show()


def cluster_boxplot(bld: Builder, analysis1, analysis2):
    def get_labels(label, dist_df):
        good_label_distances = dist_df.filter(
            (pl.col("src_label") == label)
            & (pl.col("src_label") == pl.col("tgt_label"))
        )["distance"]
        bad_label_distances = dist_df.filter(
            (pl.col("src_label") == label)
            & (pl.col("src_label") != pl.col("tgt_label"))
        )["distance"]
        good_label_distances = [lab for lab in good_label_distances if lab < 1.5]
        bad_label_distances = [lab for lab in bad_label_distances if lab < 1.5]

        return good_label_distances, bad_label_distances

    dist_df1 = analysis1.distance_node.pull(bld).collect()
    dist_df2 = analysis2.distance_node.pull(bld).collect()
    labels = dist_df1["src_label"].unique().to_list()
    n = len(labels)

    fig, ax = plt.subplots(2, n)

    for i, label in enumerate(labels):
        good_labels1, bad_labels1 = get_labels(label, dist_df1)
        good_labels2, bad_labels2 = get_labels(label, dist_df2)
        ax[0][i].boxplot([good_labels1, bad_labels1])
        ax[1][i].boxplot([good_labels2, bad_labels2])
    plt.show()


def min_1(d: float):
    return 0.0 if d > 1.0 else d


class SumGoodEdges(Plot):
    def __init__(self):
        self.name = "sum_good_edges_plot"
        self.xlabel = r"$s(p,q)$"
        self.ylabel = r"$P( p \equiv q \mid s(p,q) \geq x)$"
        self.title = None

    def compute_data(self, bld, analysis):
        dist_df = analysis.distance_node.pull(bld)
        dist_df = dist_df.filter(pl.col("src") != pl.col("tgt"))
        dist_df = (
            dist_df.select(
                [
                    (pl.col("src_label") == pl.col("tgt_label")).alias("within_class"),
                    pl.col("distance").map_elements(min_1, return_dtype=pl.Float64),
                ]
            )
            .sort(by="distance")
            .collect()
        )

        height = int(dist_df.height)
        dist_dict = {"x": [], "y": []}

        good_edges = 0
        with bld.progressbar(height) as pb:
            for i, (within_class, dist) in enumerate(dist_df.iter_rows()):
                if within_class:
                    good_edges += 1

                dist_dict["x"].append(dist)
                dist_dict["y"].append((good_edges / (height / 5)))

                pb.inc(1)

        return pl.DataFrame(dist_dict)


class Histogram:
    def __init__(self):
        self.name = "good_histogram_plot"
        self.xlabel = r"$d(p,q)$"
        self.ylabel = "Frequency"
        self.title = None

    def compute_data(self, bld, analysis, ax, xlabel):
        dist_df = analysis.distance_node.pull(bld)
        dist_df = dist_df.filter(pl.col("src") != pl.col("tgt")).collect()
        distances = dist_df["distance"]
        counts, bins = np.histogram(distances, density=True, bins=100)

        plt.rcParams.update({"text.usetex": True, "font.family": "Helvetica"})
        ax.set_xlabel(xlabel)

        ax.set_axisbelow(True)
        ax.grid(True, which="both", color="0.9", linestyle="dashed")

        ax.hist(bins[:-1], bins, weights=counts)

        return ax


class GoodEdges(Plot):
    def __init__(self):
        self.name = "good_edges_plot"
        self.xlabel = r"$s(p,q)$"
        self.ylabel = r"$P( p \equiv q \mid s(p,q) \geq x)$"
        self.title = None

    def compute_data(self, bld, analysis):
        dist_df = analysis.distance_node.pull(bld)
        dist_df = dist_df.filter(pl.col("src") != pl.col("tgt"))
        dist_df = (
            dist_df.select(
                [
                    (pl.col("src_label") == pl.col("tgt_label")).alias("within_class"),
                    pl.col("distance").map_elements(min_1, return_dtype=pl.Float64),
                ]
            )
            .sort(by="distance")
            .collect()
        )

        height = int(dist_df.height)
        dist_dict = {"x": [], "y": []}

        good_edges = 0
        with bld.progressbar(height) as pb:
            for i, (within_class, dist) in enumerate(dist_df.iter_rows()):
                if within_class:
                    good_edges += 1

                dist_dict["x"].append(dist)
                dist_dict["y"].append(good_edges / (i + 1))

                pb.inc(1)

        return pl.DataFrame(dist_dict)


def greedy_set_cover(sets_dict):
    all_elements = set.union(*sets_dict.values())
    covered_elements = set()
    selected_sets = []

    while covered_elements != all_elements:
        best_set_key = None
        max_new_elements = -1

        for key, current_set in sets_dict.items():
            # Find elements in current_set that are not yet covered
            new_elements = current_set - covered_elements
            if len(new_elements) > max_new_elements:
                max_new_elements = len(new_elements)
                best_set_key = key

        if best_set_key is None:
            # This can happen if the universal_set cannot be fully covered
            # by the given sets (e.g., if an element is missing from all sets)
            assert False

        selected_sets.append(best_set_key)
        covered_elements.update(sets_dict[best_set_key])

        # Optionally, remove the chosen set to optimize future searches
        # This prevents picking the same set multiple times if it's not useful
        del sets_dict[best_set_key]

    return selected_sets, covered_elements


class GoodMajorityCluster(Plot):
    def __init__(self):
        self.name = "good_majority_cluster_plot"
        self.xlabel = "#Edges"
        self.ylabel = "#Clusters required to cover entire space"
        self.title = "Size of greedy covering of program space"

    def compute_data(self, bld, analysis):
        dist_df = analysis.distance_node.pull(bld)
        dist_df = dist_df.filter(pl.col("src") != pl.col("tgt"))

        dist_df = (
            dist_df.select(
                [
                    pl.col("src"),
                    pl.col("tgt"),
                    (pl.col("src_label") == pl.col("tgt_label")).alias("within_class"),
                    pl.col("distance").map_elements(min_1, return_dtype=pl.Float64),
                ]
            )
            .sort(by="distance")
            .collect()
        )

        height = int(dist_df.height)
        srcs = dist_df["src"].unique().to_list()
        sphere_dict = {src: {src} for src in srcs}

        dist_dict = {"x": [], "y": []}

        items = np.array(dist_df)
        assert len(items) == height

        count = 50
        with bld.progressbar(count) as pb:
            total = 0

            x = np.logspace(1, np.log10(height), count, dtype=int)

            for arr in np.array_split(items, x):
                for src, tgt, within_class, dist in arr:
                    if within_class:
                        sphere_dict[src].add(tgt)

                selected_sets, covered_elements = greedy_set_cover(sphere_dict.copy())
                dist_dict["x"].append(total)
                dist_dict["y"].append(len(selected_sets))

                total += len(arr)

                pb.inc(1)

        return pl.DataFrame(dist_dict)


class BiggestCluster(Plot):
    def __init__(self):
        self.name = "biggest_cluster_plot"
        self.xlabel = "#Edges"
        self.ylabel = "| max(C) |"
        self.title = "Size of biggest cluster when including edges in ascending order"

    def compute_data(self, bld, analysis):
        dist_df = analysis.distance_node.pull(bld)
        dist_df = dist_df.filter(pl.col("src") != pl.col("tgt"))

        dist_df = (
            dist_df.select(
                [
                    pl.col("src"),
                    pl.col("tgt"),
                    (pl.col("src_label") == pl.col("tgt_label")).alias("within_class"),
                    pl.col("distance").map_elements(min_1, return_dtype=pl.Float64),
                ]
            )
            .sort(by="distance")
            .collect()
        )

        srcs = dist_df["src"].unique().to_list()
        sphere_dict = {src: {src} for src in srcs}

        height = int(dist_df.height)
        dist_dict = {"x": [], "y": []}

        with bld.progressbar(height) as pb:
            biggest_cluster = 0
            for i, (src, tgt, within_class, dist) in enumerate(dist_df.iter_rows()):
                if within_class:
                    sphere_dict[src].add(tgt)

                if len(sphere_dict[src]) > biggest_cluster:
                    biggest_cluster = len(sphere_dict[src])

                dist_dict["x"].append(i)
                dist_dict["y"].append(biggest_cluster)
                pb.inc(1)

        new_dist_df = pl.from_dict(dist_dict)

        return new_dist_df


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


def logistic_regression(bld: Builder, analysis, ax, xlabel):
    from sklearn.linear_model import LogisticRegression
    from sklearn.metrics import log_loss
    from scipy.stats import beta, gamma

    dist_df = analysis.distance_node.pull(bld)
    dist_df = dist_df.filter(pl.col("src") != pl.col("tgt")).collect()
    distances = dist_df["distance"]
    counts, bins = np.histogram(distances, density=True, bins=100)

    X = (
        dist_df.pivot(values="distance", index="tgt", columns="src")
        .select(pl.exclude("tgt"))
        .to_numpy()
    )
    dist_df = dist_df.select(
        [
            pl.col("src"),
            pl.col("tgt"),
            (pl.col("src_label") == pl.col("tgt_label"))
            .alias("within_class")
            .cast(pl.Int8),
            pl.col("distance").map_elements(min_1, return_dtype=pl.Float64),
        ]
    ).sort(by="distance")
    y_true = dist_df["within_class"].to_numpy()
    distances = dist_df["distance"].to_numpy().reshape(-1, 1)

    model = LogisticRegression(max_iter=1000)
    mfit = model.fit(bins.reshape(-1, 1), counts)

    y_pred = mfit.predict(distances)

    d_vals = np.linspace(0, 1, 200).reshape(-1, 1)
    probs = mfit.predict_proba(d_vals)[:, 1]

    ax.plot(d_vals, probs, label="Logistic fit")

    probs = counts / counts.sum()
    plt.rcParams.update({"text.usetex": True, "font.family": "Helvetica"})
    ax.set_xlabel(xlabel)

    ax.set_axisbelow(True)
    ax.grid(True, which="both", color="0.9", linestyle="dashed")

    ax.hist(bins[:-1], bins, weights=probs)

    res = log_loss(y_true, y_pred)
    print(res)


def gamma_regression(bld: Builder, analysis, ax, xlabel):
    from sklearn.linear_model import LogisticRegression
    from sklearn.metrics import log_loss
    from scipy.stats import beta, gamma

    dist_df = analysis.distance_node.pull(bld)
    dist_df = dist_df.filter(pl.col("src") != pl.col("tgt")).collect()
    distances = dist_df["distance"]
    counts, bins = np.histogram(distances, density=True, bins=200)

    dist_df = dist_df.select(
        [
            pl.col("src"),
            pl.col("tgt"),
            (pl.col("src_label") == pl.col("tgt_label"))
            .alias("within_class")
            .cast(pl.Int8),
            pl.col("distance").map_elements(min_1, return_dtype=pl.Float64),
        ]
    ).sort(by="distance")

    y_true = dist_df["within_class"].to_numpy()
    distances = dist_df["distance"].to_numpy().reshape(-1, 1)
    distances = np.clip(distances, 1e-8, None)
    params = gamma.fit(distances, floc=0)

    d_vals = np.linspace(0, 1, 200).reshape(-1, 1)
    shape, loc, scale = params
    pdf = gamma.pdf(d_vals, shape, loc=loc, scale=scale)

    ax.plot(d_vals, pdf, label="Logistic fit")

    plt.rcParams.update({"text.usetex": True, "font.family": "Helvetica"})
    ax.set_xlabel(xlabel)

    ax.set_axisbelow(True)
    ax.grid(True, which="both", color="0.9", linestyle="dashed")


def beta_regression(bld: Builder, analysis, ax, xlabel):
    from sklearn.linear_model import LogisticRegression
    from sklearn.metrics import log_loss
    from scipy.stats import beta

    dist_df = analysis.distance_node.pull(bld)
    dist_df = dist_df.filter(pl.col("src") != pl.col("tgt")).collect()
    distances = dist_df["distance"]
    counts, bins = np.histogram(distances, density=True, bins=200)

    dist_df = dist_df.select(
        [
            pl.col("src"),
            pl.col("tgt"),
            (pl.col("src_label") == pl.col("tgt_label"))
            .alias("within_class")
            .cast(pl.Int8),
            pl.col("distance").map_elements(min_1, return_dtype=pl.Float64),
        ]
    ).sort(by="distance")
    y_true = dist_df["within_class"].to_numpy()
    distances = dist_df["distance"].to_numpy().reshape(-1, 1)
    distances = np.clip(distances, 1e-8, None)
    d_scaled = (distances - distances.min()) / (distances.max() - distances.min())
    a, b, _, _ = beta.fit(d_scaled, floc=0)

    d_vals = np.linspace(0, 1, 200).reshape(-1, 1)
    pdf = beta.pdf(d_vals, a, b)

    ax.plot(d_vals, pdf, label="Logistic fit")

    plt.rcParams.update({"text.usetex": True, "font.family": "Helvetica"})
    ax.set_xlabel(xlabel)

    ax.set_axisbelow(True)
    ax.grid(True, which="both", color="0.9", linestyle="dashed")


def plot_histogram(bld: Builder, analysis, ax, xlabel):
    dist_df = analysis.distance_node.pull(bld)
    dist_df = dist_df.filter(pl.col("src") != pl.col("tgt")).collect()

    good_distances = (
        dist_df.filter(pl.col("src_label") == pl.col("tgt_label"))["distance"]
    ).to_list()

    bad_distances = (
        dist_df.filter(pl.col("src_label") != pl.col("tgt_label"))["distance"]
    ).to_list()
    colors = ["blue", "green"]
    n_bins = 200

    # good_counts, good_bins = np.histogram(good_distances, density=True, bins=n_bins)
    # bad_counts, bad_bins = np.histogram(bad_distances, density=True, bins=n_bins)
    ax.hist([good_distances, bad_distances], bins=n_bins, stacked=True, label=colors)


def chrissers_plot(bld: Builder, analysis, ax, xlabel):
    from sklearn.linear_model import LogisticRegression
    from scipy.stats import beta

    dist_df = analysis.distance_node.pull(bld)
    dist_df = dist_df.filter(pl.col("src") != pl.col("tgt")).collect()

    good_distances = (
        dist_df.filter(pl.col("src_label") == pl.col("tgt_label"))["distance"]
    ).to_list()
    bad_distances = (
        dist_df.filter(pl.col("src_label") != pl.col("tgt_label"))["distance"]
    ).to_list()
    all_distances = dist_df["distance"].to_list()

    bins = np.histogram_bin_edges(
        np.concatenate([good_distances, bad_distances]), bins=100
    )
    colors = ["blue", "green"]
    counts1, _ = np.histogram(good_distances, bins=bins)
    counts2, _ = np.histogram(all_distances, bins=bins)

    ratio = counts1 / np.where(counts2 == 0, np.nan, counts2)
    ratio = [0 if c2 == 0 else c1 / c2 for (c1, c2) in zip(counts1, counts2)]
    bin_centers = (bins[:-1] + bins[1:]) / 2
    ax.hist(
        [good_distances, all_distances],
        bins=bins,
        stacked=True,
        color=["#d9d9d9", "#969696"],
        label=["equivalent", "all"],
        alpha=0.9,
    )
    ax.set_yscale("log")
    # ax.hist(all_distances, bins=bins, density=True, alpha=0.5, label="all distances")
    ax.set_xlabel("Similarity")
    ax.set_ylabel("Density")

    # Ratio on second axis
    ax2 = ax.twinx()
    ax2.plot(bin_centers, ratio, linestyle="-", label="ratio ", color="#ffb703")
    ax2.set_ylabel("Ratio")

    # Combine legends
    lines1, labels1 = ax.get_legend_handles_labels()
    lines2, labels2 = ax2.get_legend_handles_labels()
    ax.legend(lines1 + lines2, labels1 + labels2)

    dist_df = dist_df.select(
        [
            pl.col("src"),
            pl.col("tgt"),
            (pl.col("src_label") == pl.col("tgt_label"))
            .alias("within_class")
            .cast(pl.Int8),
            pl.col("distance").map_elements(min_1, return_dtype=pl.Float64),
        ]
    ).sort(by="distance")
    y_true = dist_df["within_class"].to_numpy()
    distances = dist_df["distance"].to_numpy().reshape(-1, 1)

    y_true = dist_df["within_class"].to_numpy()
    distances = dist_df["distance"].to_numpy()

    model = LogisticRegression(max_iter=1000)
    mfit = model.fit(distances.reshape(-1, 1), y_true)

    d_vals = np.linspace(0, 1, 100).reshape(-1, 1)
    probs = mfit.predict_proba(d_vals)[:, 1]

    # ax2.plot(d_vals, probs, linestyle="-", label="ratio ", color="red")

    distances = np.clip(distances, 1e-8, None)
    d_scaled = (distances - distances.min()) / (distances.max() - distances.min())
    a, b, _, _ = beta.fit(d_scaled, floc=0)
    print(f"{analysis.tool.name} has parameters alpha: {a}, beta: {b}")
    pdf = beta.pdf(distances, a, b)

    ax.plot(d_vals, pdf, label="Beta fit", color="blue")

    # ax.plot(bin_centers, ratio)
    # ax.hist(good_distances, bins=bins, alpha=0.5, label="dist1")
    # ax.hist(all_distances, bins=bins, alpha=0.5, label="dist2")
