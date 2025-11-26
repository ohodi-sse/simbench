from pathlib import Path
from loguru import logger
import polars as pl
import pytest

from simbench.data import (
    COMP_FILE_SCHEMA,
    COMP_CLASS_SCHEMA,
    DISTANCE_SCHEMA,
    collect_datafiles,
    get_similarity,
    get_label,
)

import simbench.similarity as sim
from simbench.classification import BestMatch


def test_compressor():
    assert True


def test_create_comp_file(compressorname, testfiles):
    comp = sim.parse_compressor(compressorname)

    assert comp
    assert comp.compression_lvl == 1, (
        f"Failed to correctly instantiate compressor from name {compressorname}"
    )
    compfile_df = sim.create_comp_file(comp, testfiles)

    assert compfile_df.collect_schema() == COMP_FILE_SCHEMA
    logger.debug(compfile_df.collect())


def test_create_comp_class(compressorname, testfiles):
    comp = sim.parse_compressor(compressorname)

    assert comp
    assert comp.compression_lvl == 1, (
        f"Failed to correctly instantiate compressor from name {compressorname}"
    )
    compclass_df = sim.create_comp_class(comp, testfiles)

    assert compclass_df.collect_schema() == COMP_CLASS_SCHEMA
    logger.debug(compclass_df.collect())


def test_create_distance_file(compressorname, testfiles):
    comp = sim.parse_compressor(compressorname)

    assert comp
    assert comp.compression_lvl == 1, (
        f"Failed to correctly instantiate compressor from name {compressorname}"
    )

    compfile_df = sim.create_comp_file(comp, testfiles)

    compclass_df = sim.create_comp_class(comp, testfiles)

    metric = sim.get_metric("NCD", compressorname)
    assert metric
    assert metric.compressor.compression_lvl == 1, (
        f"Failed to correctly instantiate compressor from name {compressorname}"
    )
    distance_df = sim.create_distance_file(metric, compfile_df, compclass_df, testfiles)

    logger.debug(distance_df.collect())
    assert distance_df.collect_schema() == DISTANCE_SCHEMA


#
# def test_similariy_metric(testfiles):
#     metric = sim.get_metric("NCD", "zstd")
#     assert metric, "Failed to instantiate metric"
#     similarity = sim.get_similarities(metric, testfiles[0], [testfiles[2]])
#
#     logger.debug(f"Similarity is: {similarity}")
#
#     assert isinstance(similarity, list)
#     assert round(similarity[0], 2) == 0.64
#
#
# def test_similariy_metric_2(testfiles):
#     metric = sim.get_metric("NCD", "zstd")
#
#     assert metric, "Failed to instantiate metric"
#     similarity = sim.get_similarities(metric, testfiles[0], [testfiles[0]])
#
#     logger.debug(f"Similarity is: {similarity}")
#
#     assert isinstance(similarity, list)
#     assert round(similarity[0], 2) == 0.18
#
#
# def test_create_sim_matrix(testfiles):
#     metric = sim.get_metric("NCD", "zstd")
#
#     assert metric, "Failed to instantiate metric"
#     df = sim.create_similarity_matrix(metric, testfiles)
#
#     assert isinstance(df, pl.LazyFrame)
#
#     filter_expr = (pl.col("src") == "test1.java") & (pl.col("tgt") == "test2.java")
#     similarity = df.filter(filter_expr).select("similarity").collect()
#
#     assert similarity.shape == (1, 1), "Failed to extract unique element"
#     assert round(similarity.item(), 2) == 0.64
#


def test_collect_data(predata_shape):
    testdir = Path.cwd() / "predata/"
    collect_df = collect_datafiles(testdir).collect()

    assert isinstance(collect_df, pl.DataFrame)
    assert collect_df.shape == predata_shape


def test_get_similarity(similaritiesfile):
    test_src = "test1.java"
    test_target = "test2.java"

    similarity = get_similarity(similaritiesfile, test_src, test_target)

    assert round(similarity, 2) == 0.64, (
        "Failed to assert the similarity of two test files"
    )


def test_parse_compressor(compressorname):
    comp = sim.parse_compressor(compressorname)

    assert comp
    assert comp.compression_lvl == 1, (
        f"Failed to correctly instantiate compressor from name {compressorname}"
    )


#
# @pytest.mark.slow
# def test_similarities_from_data(datafilesDF):
#     assert isinstance(datafilesDF, pl.LazyFrame), "Analysis data frame is malformed"
#
#     metric = sim.get_metric("NCD", "zstd")
#
#     assert metric, "Failed to instantiate metric"
#
#     df = sim.similarities_from_data(metric, datafilesDF)
#
#     assert isinstance(df.collect(), pl.DataFrame), "Similarity dataframe is malformed"


def test_get_label(similaritiesfile, datafilesDF):
    test_src = "test3.java"
    assert isinstance(similaritiesfile, pl.LazyFrame)

    label = get_label(datafilesDF, test_src)

    assert label == "testfiles"
