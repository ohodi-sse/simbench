from simbench.cli import cli
from click.testing import CliRunner
from loguru import logger
from pathlib import Path
from simbench.classification import get_classifier


def test_collect_data(testdir, compressorname):
    runner = CliRunner()
    logger.debug(f"Running from {Path.cwd()}")
    result = runner.invoke(
        cli, ["collect-data", "--dir", testdir.parent, "--compressor", compressorname]
    )

    assert result.exit_code == 0, f"Cli failed with {result.exception}"

    logger.debug(f"Cli outputs: \n{result.output}")
    assert compressorname in result.output


def test_analyse(testdir, compressorname, classifiername):
    runner = CliRunner()
    logger.debug(f"Running from {Path.cwd()}")

    logger.debug(f"Running from {Path.cwd() / testdir}")
    result = runner.invoke(
        cli,
        [
            "analyse",
            "--dir",
            testdir.parent,
            "--compressor",
            compressorname,
            "--classifier",
            classifiername,
        ],
    )

    assert result.exit_code == 0, f"Cli failed with {result.exception}"

    logger.debug(f"Cli outputs: \n{result.output}")

    classifierstr = get_classifier(classifiername).name()

    assert compressorname in result.output
    assert classifierstr in result.output
