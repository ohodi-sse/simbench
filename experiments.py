import marimo

__generated_with = "0.23.8"
app = marimo.App()


@app.cell(hide_code=True)
def _():
    import matplotlib.pyplot as plt
    import numpy as np

    from sklearn.metrics import log_loss, average_precision_score
    import polars as pl
    import marimo as mo
    from simbench.analysis import AnalysisComparison, Config, init_analysis
    from simbench.build import Builder, Suite
    from simbench.cli import get_filtered_analysis_comparison
    from pathlib import Path

    more_colors = list(plt.get_cmap('cividis').colors)

    colors = [
        [0.0, 0.135112, 0.304751],
        [0.40, 0.135112, 0.104751],
    ]
    return (
        Builder,
        Config,
        Path,
        colors,
        get_filtered_analysis_comparison,
        log_loss,
        mo,
        np,
        pl,
        plt,
    )


@app.cell
def _(Builder, Config, Path):
    # Then we extract the comparison object, which will pull all dependencies for the specified configuration. 
    tools = ".*" # Using all tools 
    normalizers = "(unprocessed|google_java_formatted|token_format|decompiled)"
    classifiers = ".*"

    cfg = Config()
    bld = Builder(cfg.log)
    suite = Path("suites/predata/")
    return bld, cfg, classifiers, normalizers, suite, tools


@app.cell
def _(
    bld,
    cfg,
    classifiers,
    get_filtered_analysis_comparison,
    normalizers,
    suite,
    tools,
):
    #Then we extract the comparison object, which will pull all dependencies for   the specified configuration.
    comparison_obj = get_filtered_analysis_comparison(cfg,suite,tools, normalizers, classifiers)
    perf_df = comparison_obj.performance_table_comparison.pull(bld)
    return comparison_obj, perf_df


@app.cell(hide_code=True)
def _(mo):
    mo.md(r"""
    Here follows the performance data, which evaluates each similarity measure as a kNN classifier with k = 1,10,50
    """)
    return


@app.cell
def _(perf_df):
    perf_df.collect()
    return


@app.cell(hide_code=True)
def _(mo):
    mo.md(r"""
    Similarly, we can get a table containg all of the log-loss score evaluations over each similarity measure:
    """)
    return


@app.cell
def _(bld, comparison_obj):
    comparison_obj.evaluation_table_comparison.pull(bld).collect()
    return


@app.cell(hide_code=True)
def _(mo):
    mo.md(r"""
    The plots of the paper are generated below:
    """)
    return


@app.cell(hide_code=True)
def _(edit_dist_chars, np, pl):
    def load(name,df):

        # remove comparisons of programs with themselves
        df = df.filter(pl.col("src") != pl.col("tgt"))

        similarities =  df["distance"].to_numpy()
        labels = (
            df.select(label=pl.col("src_label") == pl.col("tgt_label"))
            .cast(dtypes=pl.Int8)["label"]
            .to_numpy()
        )
        return (name, similarities, labels)

    def apply_iso(x):
        from sklearn.isotonic import IsotonicRegression
        name, arr, labels = x
        iso = IsotonicRegression(out_of_bounds='clip')
        iso.fit(arr, labels)
        return (f"\\mathrm{{Iso}} \\circ {name}", iso.predict(arr), labels)

    def apply_platt(x):
        from sklearn.linear_model import LogisticRegression
        name, arr, labels = x
        plat = LogisticRegression()
        plat.fit(arr.reshape(-1, 1), labels)
        y_ = plat.predict_proba(arr.reshape(-1, 1))[:, 1]
        return (f"\\mathrm{{Plt}} \\circ {name}", y_, labels)

    (_, _, xlb) = load("",edit_dist_chars)

    def apply_zero():
        from scipy.stats import beta

        return (f"s_{{0}}", np.zeros(len(xlb)), xlb)

    def apply_random(split,reverse=False):
        from scipy.stats import beta

        xlb_ordered = xlb 
        if reverse:
            xlb_ordered = (1 - xlb) 

        bads = beta.rvs(a=1, b=split, size=len(xlb)) * xlb_ordered
        goods = beta.rvs(a=split, b=1, size=len(xlb)) * (1 -  xlb_ordered)

        if split != 1:
            return (r"\mathrm{\tilde{{\equiv}}}", bads + goods, xlb)
        else:
            return (r"\mathrm{\tilde{R}}", bads + goods, xlb)


    return apply_iso, apply_random, load


@app.cell(hide_code=True)
def _(colors, log_loss, np, plt):
    def hist(data, path, iso=False, baseline=0):
        from pathlib import Path
        from sklearn.isotonic import IsotonicRegression
        from sklearn.linear_model import LogisticRegression


        fig, rows = plt.subplots(
            1,
            len(data),
            squeeze=False,
            figsize=(2 * len(data), 2.5),
            sharey=True,
            #sharex=True,
            constrained_layout=True,
        )

        all_pairs = []
        for (_, pairs, _) in data:
            all_pairs.append(pairs)


        _, bins = np.histogram(all_pairs, bins=20)

        _ax = rows[0,0]

        mmin, mmax = 0, 1
        maxshow = mmax + 0.05

        for _ax in rows.flatten():
            _ax.set_xlim(mmin, mmax)
            _ax.set_ylim(mmin, maxshow)
            _ax.set_aspect("equal", adjustable="box")

        for _ax in rows.flatten():
            _ax.set_yticks(np.linspace(mmin, mmax, 2))
            _ax.set_xticks(np.linspace(mmin, mmax, 2))
            _ax.set_yticks(np.linspace(mmin, mmax, 5), minor=True)
            _ax.set_xticks(np.linspace(mmin, mmax, 5), minor=True)

            _ax.grid(which="minor", linestyle="--", linewidth=0.5, alpha=0.7)
            _ax.plot([0, 1], [0, 1], transform=_ax.transAxes, linestyle="--", linewidth=0.5, alpha=0.8, color="lightgray")
            _ax.tick_params(axis="both", which="both", length=0)


        for i, ((name, pairs, labels), _ax) in enumerate(
            zip(data, rows.flatten())
        ):
            spairs = pairs
            sequiv = spairs[labels == 1]
            _ax.set_title(
                f"${name}$"
            )

            if baseline:
                _ax.set_xlabel(f"$\\mathcal{{L}}_{{\\equiv}} = {(log_loss(labels, spairs) - baseline) * 1000:0.1f} (\\Delta_\\mathrm{{\\tilde{{R}}}} 10^{{-3}})$")
            else:
                _ax.set_xlabel(f"$\\mathcal{{L}} = {log_loss(labels, spairs) - baseline:0.3f}$")

            ps, _ = np.histogram(spairs[labels == 0], bins=bins)
            es, _ = np.histogram(sequiv, bins=bins)

            ptop = max(ps) * 1.1 / mmax 
            etop = max(es) * 1.1 / mmax

            #_ax.set_yticklabels([0, "$3\\cdot10^{5}$"])
            _ax.stairs(ps / ptop, bins, fill=True, color=colors[0], alpha=0.2)
            _ax.stairs(es / etop, bins, fill=True, color=colors[0], alpha=0.3)

            _ax.stairs(ps / ptop, bins, color=colors[0])

            _ax.stairs(es / etop, bins, color=colors[0], ls="dotted")

            x = (bins[:-1] + bins[1:]) / 2
            y = es / (ps + es)

            y_ = np.interp(x, np.concat([x[~np.isnan(y)], [0, 1]]), np.concat([y[~np.isnan(y)], [0, 1]]))

            _ax.plot(x, y_, color="white", lw=5)
            _ax.plot(x, y_, color="black", ls="dashed", lw=1)

            if iso:
                iso = IsotonicRegression(out_of_bounds='clip')
                iso.fit(pairs, labels)
                x_ = x
                y_ = iso.predict(x_)
                _ax.plot(x_, y_, color="white", lw=5)
                _ax.plot(x_, y_, color="blue", lw=1)


        Path(path).parent.mkdir(parents=True, exist_ok=True);
        fig.savefig(path)
        return fig

    return (hist,)


@app.function(hide_code=True)
def min_1(d: float):
    return 0.0 if (d > 1.0) | (d < 0.0) else d


@app.cell
def _(bld, comparison_obj):
    # Setting experiment parameters 
    edit_dist_chars = comparison_obj.get_analysis(tool_name="edit_distance_chars",normalizer_name="google_java_formatted").pull(bld).distance_node.pull(bld).collect()

    edit_dist_lines = comparison_obj.get_analysis(tool_name="edit_distance_lines",normalizer_name="google_java_formatted").pull(bld).distance_node.pull(bld).collect()
    return edit_dist_chars, edit_dist_lines


@app.cell(hide_code=True)
def _(mo):
    mo.md(r"""
    We simulate distributions for the random, and the ideal similarity measure, and plot it alongside the results for diff on line and character level.
    """)
    return


@app.cell
def _(apply_random, edit_dist_chars, edit_dist_lines, load):
    unproccessed_diff = {
        r"\text{diff}\langle\mathrm{lines}\rangle": edit_dist_lines,
        r"\text{diff}\langle\mathrm{chars}\rangle": edit_dist_chars,
    }
    diffs = [apply_random(1)] + [load(k, v) for k, v in unproccessed_diff.items()] + [apply_random(0.000000001)]
    return (diffs,)


@app.cell
def _(diffs, hist):
    hist(diffs, "figures/diff/diff-isotonic-map.pdf", iso=True)
    return


@app.cell
def _(apply_iso, diffs, hist):
    _diff_iso = [apply_iso(x) for x in diffs]
    hist(_diff_iso, "figures/diff/diff-isotonic.pdf", baseline=0.5)
    return


if __name__ == "__main__":
    app.run()
