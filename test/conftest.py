import pytest
from pathlib import Path
from loguru import logger
import shutil

from simbench.analysis import (
    init_analysis,
    get_all_classifiers,
    get_all_normalizers,
    get_all_tools,
)
from simbench.build import Suite, Builder


@pytest.fixture(scope="session")
def test_bld():
    return Builder(logger)


@pytest.fixture(scope="session")
def test_suite():
    suite = Suite(Path("./test/testfiles/"))
    yield suite
    shutil.rmtree(suite.root / "results")
    shutil.rmtree(suite.root / "decompiled_problems")
    shutil.rmtree(suite.root / "google_java_formatted_problems")


@pytest.fixture(params=[tool for tool in get_all_tools()])
def test_tool(request):
    return request.param


@pytest.fixture(scope="session")
def test_classifiers(test_suite):
    max_files = test_suite.sources()
    return get_all_classifiers(len(list(max_files)))


@pytest.fixture(params=[n for n in get_all_normalizers()])
def test_normalizer(request):
    return request.param


@pytest.fixture(scope="function")
def test_analysis(test_tool, test_suite, test_classifiers, test_normalizer):
    analysis = init_analysis(
        tool=test_tool,
        suite=test_suite,
        classifiers=test_classifiers,
        normalizer=test_normalizer,
    )
    yield analysis
    # cleanup
    shutil.rmtree(analysis.default_path)
