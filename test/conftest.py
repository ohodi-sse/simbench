import pytest
from pathlib import Path
from loguru import logger
import shutil

from simbench.analysis import Analysis, get_all_classifiers, get_all_tools
from simbench.build import Suite, Builder


@pytest.fixture(scope="session")
def test_bld():
    return Builder(logger)


@pytest.fixture(scope="session")
def test_suite():
    return Suite(Path("./test/testfiles/"))


@pytest.fixture(params=[tool for tool in get_all_tools()])
def test_tool(request):
    return request.param


@pytest.fixture(scope="session")
def test_classifiers():
    return get_all_classifiers()


@pytest.fixture(scope="function")
def test_analysis(test_tool, test_suite, test_classifiers):
    analysis = Analysis(tool=test_tool, suite=test_suite, classifiers=test_classifiers)
    yield analysis

    # cleanup
    shutil.rmtree(analysis.default_path)


#
# @pytest.fixture(scope="session")
# def predata_shape():
#     return (5 * 300, 3)
#
#
# @pytest.fixture(scope="session")
# def testdir():
#     return Path.cwd() / "./test/testfiles/"
#
#
# @pytest.fixture(scope="session")
# def testfiles(testdir):
#     testfiles = [
#         File(filepath.name, testdir.name, filepath)
#         for filepath in testdir.iterdir()
#         if filepath.name.endswith(".java")
#     ]
#     return testfiles
#
#
# @pytest.fixture(scope="session")
# def similaritiesfile():
#     path = Path("test/analyses/NCD_zstd_1-distances.parquet")
#     return load_parquet(path)
#
#
# @pytest.fixture(scope="session")
# def datafilesDF():
#     testdir = Path.cwd() / "test/"
#     return collect_datafiles(testdir)
#
#
# @pytest.fixture(params=[i for i in range(1, 2)])
# def compression_lvl(request):
#     return f"clvl_{request.param}"
#
#
# @pytest.fixture(params=["zstd", "zstandard", "gzip"])
# def compressorname(request, compression_lvl):
#     return f"{request.param}_{compression_lvl}"
#
#
# @pytest.fixture(params=["bm", "knn_10"])
# def classifiername(request):
#     return request.param
#
#
# @pytest.fixture(params=["bm", "knn_10"])
# def classifier(request):
#     return get_classifier(request.param)
#
#
# @pytest.fixture(scope="session")
# def choose_data():
#     datapath = Path.cwd() / "data/Project_CodeNet_Java250/"
#     classes = [d.name for d in datapath.iterdir()]
#
#     return classes
#
#
# @pytest.fixture(scope="session")
# def choose_predata():
#     datapath = Path.cwd() / "predata"
#     classes = [
#         d.name for d in datapath.iterdir() if d.is_dir() and d.name != "analyses"
#     ]
#
#     return classes
