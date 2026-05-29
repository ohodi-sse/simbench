import marimo

__generated_with = "0.23.8"
app = marimo.App(width="medium")


@app.cell
def _():
    import marimo as mo
    from simbench.analysis import AnalysisComparison, Config
    from simbench.build import Builder, Suite
    from simbench.cli import get_filtered_analysis_comparison
    from pathlib import Path

    return Builder, Config, Path, get_filtered_analysis_comparison, mo


@app.cell
def _(Builder, Config, Path):
    # Setting experiment parameters 
    #seed = 2 
    #samples = 2000 
    tools = ".*" # Using all tools 
    normalizers = "(unprocessed|token_format)"
    classifiers = "knn-1"

    cfg = Config()
    bld = Builder(cfg.log)
    suite = Path("suites/predata/")
    return bld, cfg, classifiers, normalizers, suite, tools


@app.cell(hide_code=True)
def _(mo):
    mo.md(r"""
    In the following we will "pull" the performance table. It loads all cached dependencies and computes the rest.
    This may take a quite some time. It of courses dependes on the analysis specified.
    """)
    return


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
    comparison_obj = get_filtered_analysis_comparison(cfg,suite,tools, normalizers, classifiers)
    perf_df = comparison_obj.performance_table_comparison.pull(bld)
    return (perf_df,)


@app.cell(hide_code=True)
def _(mo):
    mo.md(r"""
    We can now examine the performance dataframe
    """)
    return


@app.cell
def _(mo, perf_df):
    mo.ui.dataframe(perf_df)
    return


@app.cell
def _():
    return


if __name__ == "__main__":
    app.run()
