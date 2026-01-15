import pytest
from pathlib import Path
from loguru import logger
import shutil

from simbench.analysis import Analysis, get_all_classifiers, get_all_tools
from simbench.build import IDNormalizer, Suite, Builder
from simbench.classification import KNN
from simbench.simple_normalizer import CompileDecompileNormalizer


@pytest.fixture(scope="session")
def test_bld():
    return Builder(logger)


@pytest.fixture(scope="session")
def test_suite():
    suite = Suite(Path("./test/testfiles/"))
    yield suite
    shutil.rmtree(suite.root / "results")
    shutil.rmtree(suite.root / "decompiled_problems")


@pytest.fixture(params=[tool for tool in get_all_tools()])
def test_tool(request):
    return request.param


@pytest.fixture(scope="session")
def test_classifiers(test_suite):
    max_files = test_suite.sources()
    return get_all_classifiers(len(list(max_files)))


@pytest.fixture(params=[IDNormalizer(), CompileDecompileNormalizer()])
def test_normalizer(request):
    return request.param


@pytest.fixture(scope="function")
def test_analysis(test_tool, test_suite, test_classifiers, test_normalizer):
    analysis = Analysis(
        tool=test_tool,
        suite=test_suite,
        classifiers=test_classifiers,
        normalizer=test_normalizer,
    )
    yield analysis
    # cleanup
    shutil.rmtree(analysis.default_path)
