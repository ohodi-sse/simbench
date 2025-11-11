import polars as pl

from simbench.data import (
    File,
    collect_datafiles,
    load_parquet,
    get_similarity,
    get_label,
)

import simbench.similarity as sim
from simbench.classification import classify_best_match, classify_knn_match


def test_best_match_classify(analysisfile):
    test_src = "s005618736.java"
    similarities = load_parquet(analysisfile)

    assert isinstance(similarities, pl.DataFrame)

    classification = classify_best_match(similarities, test_src)

    assert classification.name != test_src, "Best match is the file itself"
    assert classification.labelled_as == "p00001"


def test_knn_classify(analysisfile):
    test_src = "s005618736.java"
    similarities = load_parquet(analysisfile)

    assert isinstance(similarities, pl.DataFrame)

    classification = classify_knn_match(similarities, test_src)

    assert classification.name != test_src, "Best match is the file itself"
    assert classification.labelled_as == "p00001"
