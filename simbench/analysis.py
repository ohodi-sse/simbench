from loguru import logger
from pathlib import Path
import polars as pl

from simbench.similarity import SimilarityMetric
import simbench.similarity as sim
import simbench.data as data
from simbench.classification import (
    Classifier,
    create_classification_dataframe,
    get_classifier,
    get_performance_scikit,
)


def get_data_overview_path(dir: Path) -> Path:
    data_filename = f"{dir.name}_file_overview.parquet"
    return Path.cwd() / dir / data_filename


def get_similarity_path(dir: Path, metric: SimilarityMetric) -> Path:
    sim_filename = f"{metric.name()}-similarities.parquet"
    return Path.cwd() / dir / "analyses" / sim_filename


def get_classification_path(
    dir: Path, metric: SimilarityMetric, classifier: Classifier
) -> Path:
    classf_filename = f"{metric.name()}-{classifier.name()}-classifications.parquet"
    return Path.cwd() / dir / "analyses" / classf_filename


def get_performance_overview_path(
    dir: Path, metric: SimilarityMetric, classifier: Classifier
) -> Path:
    perf_filename = f"{metric.name()}-{classifier.name()}-performance_overview.parquet"
    return Path.cwd() / dir / "analyses" / perf_filename


def run_analysis(
    datadir: Path, metric: SimilarityMetric, classifier: Classifier, write: bool
) -> tuple[pl.LazyFrame, pl.LazyFrame, pl.LazyFrame, pl.LazyFrame]:
    assert isinstance(datadir, Path), "Run analysis has to be passed a Path object"

    dirpath = Path.cwd() / datadir
    assert dirpath.is_dir(), (
        f"{dirpath} is not a valid path. The project should be run from the root folder of the project"
    )

    data_path = get_data_overview_path(datadir)
    if data_path.is_file():
        logger.debug(f"Loading files for analysis from {data_path}")
        data_df = data.load_parquet(data_path)
    else:
        logger.debug(f"Calculating data overview for {datadir.name}")
        data_df = data.collect_datafiles(dirpath)

    similarity_path = get_similarity_path(datadir, metric)
    if similarity_path.is_file():
        logger.debug(f"Loading similarities from {similarity_path}")
        similarity_df = data.load_parquet(similarity_path)
    else:
        logger.debug(f"Calculating similarities for {metric.name()}")
        similarity_df = sim.similarities_from_data(metric, data_df)

    classify_path = get_classification_path(datadir, metric, classifier)
    if classify_path.is_file():
        logger.debug(f"Loading classifications from {similarity_path}")
        class_df = data.load_parquet(classify_path)
    else:
        logger.debug(f"Classifying files with {classifier.name()}")
        class_df = create_classification_dataframe(similarity_df, classifier)

    perf_path = get_performance_overview_path(datadir, metric, classifier)
    if perf_path.is_file():
        logger.debug(f"Loading performance overview from {similarity_path}")
        perf_df = data.load_parquet(perf_path)
    else:
        logger.debug(f"Calculating performance overview for {metric.name()}")
        perf_df = get_performance_scikit(class_df)

    if write:
        logger.info(f"Writing data overview to {str(data_path)}")
        data_df.collect().write_parquet(data_path.resolve())

        logger.info(f"Writing similarity data to {str(similarity_path)}")
        similarity_df.collect().write_parquet(similarity_path.resolve())

        logger.info(f"Writing classifications to {str(classify_path)}")
        class_df.collect().write_parquet(classify_path.resolve())

        logger.info(f"Writing performance overview to {str(perf_path)}")
        perf_df.collect().write_parquet(perf_path.resolve())

        return (data_df, similarity_df, class_df, perf_df)
    else:
        return (data_df, similarity_df, class_df, perf_df)


def extract_bad_matches(similarity_df: pl.LazyFrame) -> pl.LazyFrame:
    assert similarity_df.collect_schema() == data.SIMILARITIES_SCHEMA

    classifier = get_classifier("bm")
    assert classifier

    class_df = create_classification_dataframe(similarity_df, classifier)
    expr = pl.col("src_label") != pl.col("labelled_as")
    bad_srcs = pl.Series(class_df.filter(expr).select("src").collect()).to_list()

    bad_srcs_list = [
        similarity_df.filter(
            (pl.col("src") == bad_src) & (pl.col("src") != pl.col("target"))
        )
        .sort(by="similarity", descending=True)
        .select("src")
        .collect()
        .item(0, "src")
        for bad_src in bad_srcs
    ]

    bad_targets_list = [
        similarity_df.filter(
            (pl.col("src") == bad_src) & (pl.col("src") != pl.col("target"))
        )
        .sort(by="similarity", descending=True)
        .select("target")
        .collect()
        .item(0, "target")
        for bad_src in bad_srcs
    ]

    bad_matches = [(s, t) for (s, t) in zip(bad_srcs_list, bad_targets_list)]
    logger.debug(bad_matches)

    return bad_matches
