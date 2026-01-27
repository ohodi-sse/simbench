import polars as pl

from simbench.analysis import init_analysis
from simbench.classification import (
    KNN,
)


def test_best_match_classify(test_tool, test_suite, test_bld, test_normalizer):
    test_src = "test1.java"

    bm_classifier = KNN(1)

    analysis = init_analysis(
        tool=test_tool,
        suite=test_suite,
        classifiers=[bm_classifier],
        normalizer=test_normalizer,
    )
    classifiers = analysis.classification_nodes
    assert len(classifiers) == 1

    cl_df = classifiers["knn-1"].pull(test_bld)
    classification = cl_df.filter(pl.col("src") == test_src).collect()

    assert classification["labelled_as"].item() in ["class1", "class2"], (
        f"{cl_df.collect()}"
    )


def test_knn_classify(test_tool, test_suite, test_bld, test_normalizer):
    test_src = "test2.java"

    classifier = KNN(3)
    analysis = init_analysis(
        tool=test_tool,
        suite=test_suite,
        classifiers=[classifier],
        normalizer=test_normalizer,
    )

    classifiers = analysis.classification_nodes
    cl_df = classifiers["knn-3"].pull(test_bld)

    classification = cl_df.filter(pl.col("src") == test_src).collect()

    assert classification["labelled_as"].item() in ["class1", "class2"], (
        f"{cl_df.collect()}"
    )


def test_performance_overview(
    test_tool, test_suite, test_bld, test_classifiers, test_normalizer
):
    analysis = init_analysis(
        tool=test_tool,
        suite=test_suite,
        classifiers=test_classifiers,
        normalizer=test_normalizer,
    )

    perf_df = analysis.performance_node.pull(test_bld).collect()

    assert isinstance(perf_df, pl.DataFrame)

    scoreslist = [
        pl.Series(perf_df.select(col)).to_list() for col in ["Acc", "Prec", "Rec", "F1"]
    ]

    assert [
        all([0 <= score and score <= 1 for score in scores]) for scores in scoreslist
    ], "Scores must be between 0 and 1"
