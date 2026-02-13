from simbench.cli import cli
from click.testing import CliRunner
from loguru import logger
from pathlib import Path


def test_analyse_simple(test_suite):
    runner = CliRunner()
    logger.debug(f"Running from {Path.cwd()}")

    logger.debug(f"Running from {Path.cwd() / test_suite.root}")
    result = runner.invoke(
        cli,
        [
            "analyse",
            str(test_suite.root),
            "--tool",
            "zstd-1",
            "--normalizer",
            "unprocessed",
        ],
    )

    assert result.exit_code == 0, f"Cli failed with {result.exception}"

    logger.debug(f"Cli outputs: \n{result.output}")
