import simbench.cli as cli
import polars as pl


def test_cli_collect_data(testdir):
    similarities = cli.collect_data(dir=testdir)

    assert isinstance(similarities, pl.DataFrame)
