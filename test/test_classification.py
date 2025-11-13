import polars as pl
from loguru import logger
import pytest


from simbench.classification import (
    classify_best_match,
    classify_knn_match,
    create_classification_dataframe,
    check_classification,
    get_confusion_matrix,
    get_performance_overview,
)


def test_best_match_classify(similaritiesfile):
    test_src = "s005618736.java"

    assert isinstance(similaritiesfile, pl.LazyFrame)

    classification = classify_best_match(similaritiesfile, test_src)

    assert classification.name == test_src, (
        "Gave the classification the wrong name: {classification.name} should be {test_src}"
    )
    assert classification.labelled_as == "p00001"
    assert test_src not in classification.similar_files, (
        "Test file is compared against when choosing label"
    )


def test_knn_classify(similaritiesfile):
    test_src = "s005618736.java"

    assert isinstance(similaritiesfile, pl.LazyFrame)

    classification = classify_knn_match(similaritiesfile, test_src, k=10)
    assert classification.name == test_src, "Best match is the file itself"
    assert classification.labelled_as == "p00001"
    assert test_src not in classification.similar_files, (
        "Test file is compared against when choosing label"
    )


def test_k1_equals_best_match(similaritiesfile):
    test_src = "s005618736.java"

    assert isinstance(similaritiesfile, pl.LazyFrame)

    best_match = classify_best_match(similaritiesfile, test_src)
    knn_1 = classify_knn_match(similaritiesfile, test_src, k=1)

    assert best_match.name == knn_1.name
    assert best_match.labelled_as == knn_1.labelled_as
    assert best_match.similar_files == knn_1.similar_files


@pytest.mark.slow
def test_classification_dataframe(similaritiesfile):
    class_df = create_classification_dataframe(similaritiesfile, 1)

    assert isinstance(class_df, pl.LazyFrame)
    assert check_classification(class_df, "s492836966.java")


@pytest.mark.slow
def test_confusion_matrix(similaritiesfile):
    class_df = create_classification_dataframe(similaritiesfile, 1)
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

    assert total_sum == confusion_df.collect().height * 1500, (
        "Each row should label all data of the set"
    )


def test_performance_overview(similaritiesfile):
    class_df = create_classification_dataframe(similaritiesfile, 1)

    perf_df = get_performance_overview(class_df)

    assert isinstance(perf_df, pl.LazyFrame)

    perf_collect = perf_df.collect()
    logger.debug(perf_collect)
    scores = [perf_collect.select(col).item() for col in ["Acc", "Prec", "Rec", "F1"]]

    assert [0 <= score and score <= 1 for score in scores], (
        "Scores must be between 0 and 1"
    )


def test_data_choice(choose_test_data):
    assert choose_test_data == ["p02659", "p02641", "p02921", "p02582", "p03644"]
