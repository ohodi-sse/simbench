from pathlib import Path
from loguru import logger
import polars as pl
import time
import pytest

from simbench.data import (
    File,
    FileInfoDF,
    AnalysisSimDF,
    collect_datafiles,
    split_collected_data,
    split_classes,
    load_parquet,
)

import simbench.similarity as sim
from simbench.classification import classify_best_match, classify_data


@pytest.fixture
def predata_shape():
    return (300, 2)


@pytest.fixture
def testfiles():
    dirpath = Path.cwd() / "./test/testfiles/"
    testfiles = [File(f) for f in dirpath.iterdir() if f.name.endswith(".txt")]
    return testfiles


def test_compressor():
    assert True


def test_get_similarity1(testfiles):
    metric = sim.get_metric("NCD", "zstd")
    similarity = sim.get_similarities(metric, testfiles[0], [testfiles[2]])

    logger.debug(f"Similarity is: {similarity}")

    assert isinstance(similarity, list)
    assert round(similarity[0], 2) == 0.36


def test_get_similarity2(testfiles):
    metric = sim.get_metric("NCD", "zstd")

    similarity = sim.get_similarities(metric, testfiles[0], [testfiles[0]])

    logger.debug(f"Similarity is: {similarity}")

    assert isinstance(similarity, list)
    assert round(similarity[0], 2) == 0.83


def test_create_sim_matrix(testfiles):
    metric = sim.get_metric("NCD", "zstd")
    df = sim.create_similarity_matrix(metric, testfiles)

    assert isinstance(df, pl.DataFrame)

    filter_expr = (pl.col("src") == "test1.txt") & (pl.col("target") == "test2.txt")
    similarity = df.filter(filter_expr).select("similarity")

    assert similarity.shape == (1, 1), "Failed to extract unique element"
    assert round(similarity.item(), 2) == 0.36, ""


def test_collect_data(predata_shape):
    testdir = Path.cwd() / "predata/"
    collect_df = collect_datafiles(testdir)

    assert isinstance(collect_df, pl.DataFrame)
    assert collect_df.shape == predata_shape


@pytest.mark.slow
def test_similarities_from_data():
    testdir = Path.cwd() / "predata/"
    collect_df = collect_datafiles(testdir)

    metric = sim.get_metric("NCD", "zstd")
    df = sim.similarities_from_data(metric, collect_df)

    assert isinstance(df, pl.DataFrame)

    test_src = "s005618736.java"
    test_target = "s007352793.java"

    filter_expr = (pl.col("src") == test_src) & (pl.col("target") == test_target)
    similarity = df.filter(filter_expr).select("similarity")
    assert similarity == 0.56


# def test_best_match_classify():
#     filename = Path("../predata/similarities_2025-10-29_11:09.parquet")
#     datafiles = Path("../predata/datafiles_2025-10-29.parquet")
#
#     similarities = load_parquet(filename)
#
#     assert isinstance(similarities, pl.DataFrame)
#
#     testfile = File(os.getcwd() / Path("predata/p00005/s581579443.java"))
#
#     (train_classes, test_class) = split_classes(os.getcwd() / Path("./predata"))
#     training_files, test_files, _, _ = split_collected_data(datafiles, train_classes)
#
#     match = classify_best_match(similarities, training_files.flatten(), testfile)
#
#     assert isinstance(match, float)
#
#
# def test_classify():
#     filename = Path("predata/similarities_2025-10-29_11:09.parquet")
#     datafiles = Path("./predata/datafiles_2025-10-29.parquet")
#
#     similarities = load_parquet(filename)
#
#     assert isinstance(similarities, pl.DataFrame)
#
#     (train_classes, test_class) = split_classes(os.getcwd() / Path("./predata"))
#     training_files, test_files, _, _ = split_collected_data(datafiles, train_classes)
#
#     classfications = classify_data(similarities, "dummy", training_files, test_files)
#
#     print(classfications)
#
#     assert False
#

# def test_dataframe_model1():
#     testdict = {
#         "src": "test1",
#         "target": "test2",
#         "src_label": "group1",
#         "tool_name": "NCD",
#         "similarity": 0.5,
#     }
#     testclass = AnalysisDataFrame(testdict)
#
#     assert isinstance(testclass, AnalysisDataFrame)
