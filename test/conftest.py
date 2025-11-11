import pytest
from pathlib import Path

from simbench.data import File, collect_datafiles


@pytest.fixture(scope="module")
def predata_shape():
    return (5 * 300, 2)


@pytest.fixture(scope="module")
def testdir():
    return Path.cwd() / "./test/testfiles/"


@pytest.fixture(scope="module")
def testfiles(testdir):
    testfiles = [File(f) for f in testdir.iterdir() if f.name.endswith(".java")]
    return testfiles


@pytest.fixture(scope="module")
def analysisfile():
    return Path("analyses/test_analysis.parquet")


@pytest.fixture(scope="module")
def datafilesDF():
    testdir = Path.cwd() / "predata/"
    return collect_datafiles(testdir)


@pytest.fixture(params=["zstd", "zstandard", "gzip"])
def compressorname(request):
    return request.param
