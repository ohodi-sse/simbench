from simbench.cli import cli
import polars as pl
from click.testing import CliRunner
from loguru import logger
from pathlib import Path


def test_cli_collect_data(testdir, compressorname):
    runner = CliRunner()
    logger.debug(f"Running from {Path.cwd()}")
    result = runner.invoke(
        cli, ["collect-data", "--dir", testdir.parent, "--compressor", compressorname]
    )

    assert result.exit_code == 0

    logger.debug(f"Cli outputs: \n{result.output}")
    assert compressorname in result.output
