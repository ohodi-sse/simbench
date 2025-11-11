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
    assert round(similarity[0], 2) == 0.82


def test_create_sim_matrix(testfiles):
    metric = sim.get_metric("NCD", "zstd")
    df = sim.create_similarity_matrix(metric, testfiles)

    assert isinstance(df, pl.DataFrame)

    filter_expr = (pl.col("src") == "test1.java") & (pl.col("target") == "test2.java")
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


def test_parse_compressor(compressorname):
    comp = sim.parse_compressor(compressorname)

    assert comp.compression_lvl == 1, (
        f"Failed to correctly instantiate compressor from name {compressorname}"
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

    assert label == "p00001"
