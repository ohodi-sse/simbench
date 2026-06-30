import random
from simbench.AI_tools import AITool
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
    shutil.rmtree(suite.root / "results", ignore_errors=True)
    shutil.rmtree(suite.root / "compiled_problems", ignore_errors=True)
    shutil.rmtree(suite.root / "optimized_problems", ignore_errors=True)
    shutil.rmtree(suite.root / "decompiled_problems", ignore_errors=True)
    shutil.rmtree(suite.root / "google_java_formatted_problems", ignore_errors=True)
    shutil.rmtree(suite.root / "imports_removed_problems", ignore_errors=True)
    # shutil.rmtree(suite.root / "optimized_decompiled_problems", ignore_errors=True)
    shutil.rmtree(suite.root / "decompiled_wo_imports_problems", ignore_errors=True)
    shutil.rmtree(suite.root / "hashed_src_label_problems", ignore_errors=True)
    shutil.rmtree(suite.root / "5_partitioned_problems", ignore_errors=True)


@pytest.fixture(params=[tool for tool in get_all_tools()])
def test_tool(request):
    return request.param


@pytest.fixture(params=[tool for tool in get_all_tools() if isinstance(tool, AITool)])
def test_ai_tools(request):
    return request.param


@pytest.fixture(scope="session")
def test_classifiers(test_suite):
    return get_all_classifiers(1)


@pytest.fixture(params=[n for n in get_all_normalizers()])
def test_normalizer(request):
    return request.param


# Randomly sampling some tool/normalizer combinations for testing classifiers.
@pytest.fixture(params=random.sample([n for n in get_all_normalizers()], 2))
def test_random_tool(request):
    return request.param


@pytest.fixture(params=random.sample([n for n in get_all_normalizers()], 2))
def test_random_normalizer(request):
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
