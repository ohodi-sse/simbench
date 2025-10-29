from data import File
from pathlib import Path
import similarity as sim
from loguru import logger
import pandas as pd
import os
import time
import pytest

from data import (
    collect_datafiles,
    split_collected_data,
    split_classes,
    load_parquet,
)
from classification import classify_best_match, classify_data


@pytest.fixture
def predata_size():
    return 300 * 5


@pytest.fixture
def testfiles():
    dirpath = Path(os.getcwd()) / Path("./src/testfiles/")
    testfiles = [
        File(dirpath / Path(f)) for f in os.listdir(dirpath) if f.endswith(".txt")
    ]
    return testfiles


def test_compressor():
    assert True


def test_get_similarity1(testfiles):
    metric = sim.get_metric("NCD", "zstd")
    similarity = sim.get_similarities(metric, testfiles[0], [testfiles[2]])

    logger.debug(f"Similarity is: {similarity}")

    assert isinstance(similarity, list)
    assert similarity[0] == 0.3555555555555555


def test_get_similarity2(testfiles):
    metric = sim.get_metric("NCD", "zstd")

    similarity = sim.get_similarities(metric, testfiles[0], [testfiles[0]])

    logger.debug(f"Similarity is: {similarity}")

    assert isinstance(similarity, list)
    assert similarity[0] == 0.8285714285714285


def test_create_sim_matrix(testfiles):
    metric = sim.get_metric("NCD", "zstd")
    df = sim.create_similarity_matrix(metric, testfiles)

    assert isinstance(df, pd.DataFrame)


def test_matrix_equal(testfiles):
    metric = sim.get_metric("NCD", "zstd")

    start = time.time()
    df1 = sim.create_similarity_matrix(metric, testfiles)
    _end1 = time.time() - start

    start = time.time()
    df2 = sim.create_similarity_matrix_fast(metric, testfiles)
    _end2 = time.time() - start

    # assert df1.equals(df2)
    # assert end2 < end1


def test_collect_data():
    testdir = Path(os.getcwd()) / Path("predata/")
    collect_df = collect_datafiles(testdir)

    assert isinstance(collect_df, pd.DataFrame)
    assert collect_df.size == 300 * 5


def test_split_collected(predata_size):
    datafile = Path("./predata/datafiles_2025-10-29.parquet")

    train_classes, test_class = split_classes(os.getcwd() / Path("./predata"))
    X_train, X_test, y_train, y_test = split_collected_data(datafile, train_classes)

    assert X_train.size == 900  # round(round(0.8 * 5) * 0.8 * 300)
    assert X_test.size == round((1 - 0.8) * predata_size)


@pytest.mark.slow
def test_similarities_from_data():
    testdir = Path(os.getcwd()) / Path("predata/")
    collect_df = collect_datafiles(testdir)

    metric = sim.get_metric("NCD", "zstd")
    sims = sim.similarities_from_data(metric, collect_df)

    assert isinstance(sims, pd.DataFrame)
    assert sims.size == 25 * 300 * 300


def test_best_match_classify():
    filename = Path("predata/similarities_2025-10-29_11:09.parquet")
    datafiles = Path("./predata/datafiles_2025-10-29.parquet")

    similarities = load_parquet(filename)

    assert isinstance(similarities, pd.DataFrame)

    testfile = File(os.getcwd() / Path("predata/p00005/s581579443.java"))

    (train_classes, test_class) = split_classes(os.getcwd() / Path("./predata"))
    training_files, test_files, _, _ = split_collected_data(datafiles, train_classes)
    # print(f"Training files: {training_files.flatten()}")

    match = classify_best_match(similarities, training_files.flatten(), testfile)

    assert isinstance(match, float)


def test_classify():
    filename = Path("predata/similarities_2025-10-29_11:09.parquet")
    datafiles = Path("./predata/datafiles_2025-10-29.parquet")

    similarities = load_parquet(filename)

    assert isinstance(similarities, pd.DataFrame)

    (train_classes, test_class) = split_classes(os.getcwd() / Path("./predata"))
    training_files, test_files, _, _ = split_collected_data(datafiles, train_classes)

    classfications = classify_data(similarities, "dummy", training_files, test_files)

    print(classfications)

    assert False
