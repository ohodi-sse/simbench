import pytest
from pathlib import Path
from simbench.data import load_parquet

from simbench.data import File, collect_datafiles


@pytest.fixture(scope="session")
def predata_shape():
    return (5 * 300, 3)


@pytest.fixture(scope="session")
def testdir():
    return Path.cwd() / "./test/testfiles/"


@pytest.fixture(scope="session")
def testfiles(testdir):
    testfiles = [
        File(filepath.name, testdir.name, filepath)
        for filepath in testdir.iterdir()
        if filepath.name.endswith(".java")
    ]
    return testfiles


@pytest.fixture(scope="session")
def similaritiesfile():
    path = Path("analyses/test_analysis.parquet")
    return load_parquet(path)


@pytest.fixture(scope="session")
def datafilesDF():
    testdir = Path.cwd() / "predata/"
    return collect_datafiles(testdir)


@pytest.fixture(params=["zstd", "zstandard", "gzip"])
def compressorname(request):
    return request.param


@pytest.fixture(scope="session")
def choose_test_data():
    import random

    datapath = Path.cwd() / "data/Project_CodeNet_Java250/"
    classes = [d.name for d in datapath.iterdir()]

    assert len(classes) == 250, "There should be 250 testclasses"
    random.seed(5)  # original seed is 5
    sample_data = random.sample(classes, 5)

    return sample_data
