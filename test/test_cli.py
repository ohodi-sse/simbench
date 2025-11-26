from simbench.cli import cli
from click.testing import CliRunner
from loguru import logger
from pathlib import Path
import polars as pl
from simbench.classification import get_classifier


def test_analyse(testdir, compressorname, classifiername):
    runner = CliRunner()
    logger.debug(f"Running from {Path.cwd()}")

    logger.debug(f"Running from {Path.cwd() / testdir}")
    result = runner.invoke(
        cli,
        [
            "analyse",
            str(testdir.parent),
            "--compressor",
            compressorname,
            "--classifier",
            classifiername,
        ],
    )

    assert result.exit_code == 0, f"Cli failed with {result.exception}"

    logger.debug(f"Cli outputs: \n{result.output}")

    classifier = get_classifier(classifiername)
    assert classifier, "Failed to instantiate classifier"
    classifierstr = classifier.name()

    # assert compressorname in result.output, "Expected compressorname in output"
    # assert classifierstr in result.output, "Expected classifier name in output"
    #


def test_merge_functions(testdir):
    runner = CliRunner()

    analysispath = testdir.parent / "analyses"

    result = runner.invoke(
        cli,
        [
            "merge-many",
            str(analysispath),
            "performance_overview.parquet",
        ],
    )

    assert result.exit_code == 0, f"Cli failed with {result.exception}"

    assert "Done" in result.output
