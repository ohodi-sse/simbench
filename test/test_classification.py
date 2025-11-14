from numpy import extract
import polars as pl
from loguru import logger
import pytest


from simbench.analysis import extract_bad_matches
from simbench.classification import (
    BestMatch,
    KNN,
    create_classification_dataframe,
    check_classification,
    get_confusion_matrix,
    get_performance_overview,
)


def test_best_match_classify(similaritiesfile):
    test_src = "test1.java"

    assert isinstance(similaritiesfile, pl.LazyFrame)

    bm_classifier = BestMatch()
    classification = bm_classifier(similaritiesfile, test_src)

    assert classification.name == test_src, (
        "Gave the classification the wrong name: {classification.name} should be {test_src}"
    )
    assert classification.labelled_as == "testfiles"
    assert test_src not in classification.similar_files, (
        "Test file is compared against when choosing label"
    )


def test_knn_classify(similaritiesfile):
    test_src = "test2.java"

    assert isinstance(similaritiesfile, pl.LazyFrame)

    knn_classifier = KNN(3)
    classification = knn_classifier(similaritiesfile, test_src)
    assert classification.name == test_src, "Best match is the file itself"
    assert classification.labelled_as == "testfiles"
    assert test_src not in classification.similar_files, (
        "Test file is compared against when choosing label"
    )


def test_k1_equals_best_match(similaritiesfile):
    test_src = "test1.java"

    assert isinstance(similaritiesfile, pl.LazyFrame)

    bm_classifier = BestMatch()
    knn_classifier = KNN(1)
    best_match = bm_classifier(similaritiesfile, test_src)
    knn_1 = knn_classifier(similaritiesfile, test_src)

    assert best_match.name == knn_1.name
    assert best_match.labelled_as == knn_1.labelled_as
    assert best_match.similar_files == knn_1.similar_files


@pytest.mark.slow
def test_classification_dataframe(similaritiesfile, classifier):
    class_df = create_classification_dataframe(similaritiesfile, classifier)

    assert isinstance(class_df, pl.LazyFrame)
    assert check_classification(class_df, "test1.java")


@pytest.mark.slow
def test_confusion_matrix(similaritiesfile, classifier):
    class_df = create_classification_dataframe(similaritiesfile, classifier)
    confusion_df = get_confusion_matrix(class_df)

    assert isinstance(confusion_df, pl.LazyFrame)
    summed_cols = (
        confusion_df.select("true_pos", "true_neg", "false_pos", "false_neg")
        .sum()
        .collect()
    )
    logger.debug(summed_cols)

    total_sum = sum([summed_cols.select(c).item() for c in summed_cols.columns])
    logger.debug(total_sum)

    assert total_sum == 14, "Each row should label all data of the set"


@pytest.mark.slow
def test_performance_overview(similaritiesfile, classifier):
    class_df = create_classification_dataframe(similaritiesfile, classifier)

    perf_df = get_performance_overview(class_df)

    assert isinstance(perf_df, pl.LazyFrame)

    perf_collect = perf_df.collect()
    logger.debug(perf_collect)
    scores = [perf_collect.select(col).item() for col in ["Acc", "Prec", "Rec", "F1"]]

    assert [0 <= score and score <= 1 for score in scores], (
        "Scores must be between 0 and 1"
    )


def test_data_choice(choose_data):
    assert len(choose_data) == 245, "There should be 245 data classes"


def test_predata_choice(choose_predata):
    assert len(choose_predata) == 5, "There should be 5 predata classes"
    assert sorted(choose_predata) == sorted(
        ["p02659", "p02641", "p02921", "p02582", "p03644"]
    )


def test_extract_bad_matches(similaritiesfile):
    bad_matches = extract_bad_matches(similaritiesfile)

    assert bad_matches == []
