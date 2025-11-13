import pytest
from pathlib import Path
from simbench.data import load_parquet
from loguru import logger

from simbench.data import File, collect_datafiles
from simbench.classification import get_classifier


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
    path = Path("test/analyses/NCD_zstd_similarities.parquet")
    return load_parquet(path)


@pytest.fixture(scope="session")
def datafilesDF():
    testdir = Path.cwd() / "test/"
    return collect_datafiles(testdir)


@pytest.fixture(params=["zstd", "zstandard", "gzip"])
def compressorname(request):
    return request.param


@pytest.fixture(params=["bm", "knn_10"])
def classifiername(request):
    return request.param


@pytest.fixture(params=["bm", "knn_10"])
def classifier(request):
    return get_classifier(request.param)


@pytest.fixture(scope="session")
def choose_data():
    datapath = Path.cwd() / "data/Project_CodeNet_Java250/"
    classes = [d.name for d in datapath.iterdir()]

    return classes


@pytest.fixture(scope="session")
def choose_predata():
    datapath = Path.cwd() / "predata"
    classes = [d.name for d in datapath.iterdir() if d.name != "analyses"]

    return classes
