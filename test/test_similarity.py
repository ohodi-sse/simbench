from pathlib import Path
from loguru import logger
import polars as pl
import pytest

from simbench.data import (
    File,
    collect_datafiles,
    load_parquet,
    get_similarity,
    get_label,
)

import simbench.similarity as sim
from simbench.classification import classify_best_match
import simbench.cli as cli


@pytest.fixture
def predata_shape():
    return (5 * 300, 2)


@pytest.fixture(scope="module")
def testdir():
    return Path.cwd() / "./test/testfiles/"


@pytest.fixture(scope="module")
def testfiles(testdir):
    testfiles = [File(f) for f in testdir.iterdir() if f.name.endswith(".txt")]
    return testfiles


@pytest.fixture
def analysisfile():
    return Path("analyses/test_analysis.parquet")


@pytest.fixture(scope="module")
def datafilesDF():
    testdir = Path.cwd() / "predata/"
    return collect_datafiles(testdir)


def test_compressor():
    assert True


def test_similariy_metric(testfiles):
    metric = sim.get_metric("NCD", "zstd")
    similarity = sim.get_similarities(metric, testfiles[0], [testfiles[2]])

    logger.debug(f"Similarity is: {similarity}")

    assert isinstance(similarity, list)
    assert round(similarity[0], 2) == 0.36


def test_similariy_metric_2(testfiles):
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


def test_get_similarity(analysisfile):
    data = load_parquet(analysisfile)

    test_src = "s005618736.java"
    test_target = "s007352793.java"

    similarity = get_similarity(data, test_src, test_target)

    assert round(similarity, 2) == 0.29, (
        "Failed to assert the similarity of two test files"
    )


@pytest.mark.slow
def test_similarities_from_data(datafilesDF):
    assert isinstance(datafilesDF, pl.DataFrame), "Analysis data frame is malformed"

    metric = sim.get_metric("NCD", "zstd")
    df = sim.similarities_from_data(metric, datafilesDF)

    assert isinstance(df, pl.DataFrame), "Similarity dataframe is malformed"


def test_get_label(analysisfile, datafilesDF):
    test_src = "s005618736.java"
    similarities = load_parquet(analysisfile)

    assert isinstance(similarities, pl.DataFrame)

    label = get_label(similarities, test_src)
    ref_label = datafilesDF.filter(pl.col("src") == test_src).select("src_label").item()

    assert label == ref_label


def test_best_match_classify(analysisfile):
    test_src = "s005618736.java"
    similarities = load_parquet(analysisfile)

    assert isinstance(similarities, pl.DataFrame)

    classification = classify_best_match(similarities, test_src)

    assert classification.name != test_src, "Best match is the file itself"
    assert classification.labelled_as == "p00001"


def test_cli_collect_data(testdir):
    similarities = cli.collect_data(dir=testdir)

    assert isinstance(similarities, pl.DataFrame)
