from data import File
from pathlib import Path
import similarity as sim
from loguru import logger
import pandas as pd


def test_compressor():
    assert True


def test_get_similarity1():
    testfile1 = File(Path("./src/testfiles/test1.txt"), 1)
    testfile2 = File(Path("./src/testfiles/test2.txt"), 2)

    comp = sim.Zstd(compression_lvl=1)
    metric = sim.NCD(comp)

    similarity = sim.get_similarities(metric, testfile1, [testfile2])

    logger.debug(f"Similarity is: {similarity}")

    assert isinstance(similarity, list)
    assert similarity[0] == 0.3555555555555555


def test_get_similarity2():
    testfile1 = File(Path("./src/testfiles/test1.txt"), 1)

    metric = sim.get_metric("NCD", "zstd")

    similarity = sim.get_similarities(metric, testfile1, [testfile1])

    logger.debug(f"Similarity is: {similarity}")

    assert isinstance(similarity, list)
    assert similarity[0] == 0.8285714285714285


def test_create_sim_matrix():
    testfile1 = File(Path("./src/testfiles/test1.txt"), 1)
    testfile2 = File(Path("./src/testfiles/test2.txt"), 2)

    files = [testfile1, testfile2]

    metric = sim.get_metric("NCD", "zstd")
    df = sim.create_similarity_matrix(metric, files)

    assert isinstance(df, pd.DataFrame)
