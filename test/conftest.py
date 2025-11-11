import pytest
from pathlib import Path

from simbench.data import File, collect_datafiles


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
