from loguru import logger
from pathlib import Path
import polars as pl

from simbench.similarities import SimilarityMetric
import simbench.similarities as sim
import simbench.data as data
import simbench.classification as cla


def get_data_overview_path(dir: Path) -> Path:
    data_filename = f"{dir.name}_data_overview.parquet"
    return Path.cwd() / dir / data_filename


def get_similarity_path(dir: Path, metric: SimilarityMetric) -> Path:
    sim_filename = f"{metric.name()}_similarities.parquet"
    return Path.cwd() / dir / sim_filename


def get_classification_path(
    dir: Path, metric: SimilarityMetric, classifier: Classifier
) -> Path:
    classf_filename = f"{metric.name()}_{classifier.name()}_classifications.parquet"
    return Path.cwd() / dir / classf_filename


def get_performance_overview_path(
    dir: Path, metric: SimilarityMetric, classifier: Classifier
) -> Path:
    perf_filename = f"{metric.name()}_{classifier.name()}_performance_overview.parquet"
    return Path.cwd() / dir / perf_filename


def full_analysis(
    datadir: Path, metric: SimilarityMetric, classifier: Classifier, write: bool
) -> None:
    dirpath = Path.cwd() / Path(datadir)

    data_path = get_data_overview_path(datadir)
    if data_path.is_file():
        logger.debug(f"Collecting files for analysis from {dirpath}")
        data_df = data.load_parquet(data_path)
    else:
        logger.debug(f"Calculating data overview for {datadir.name}")
        data_df = data.collect_datafiles(dirpath)

    similarity_path = get_similarity_path(datadir, metric)
    if similarity_path.is_file():
        logger.debug(f"Collecting files for analysis from {dirpath}")
        similarity_df = data.load_parquet(similarity_path)
    else:
        logger.debug(f"Calculating similarities for {metric.name()}")
        similarity_df = sim.similarities_from_data(metric, data_df)

    classify_path = get_classification_path(datadir, classifier)
    if classify_path.is_file():
        class_df = data.load_parquet(classify_path)
    else:
        logger.debug(f"Classifying files with {classifier.name()}")
        class_df = cla.create_classification_dataframe(similarity_df, 1)

    perf_path = get_performance_overview_path(datadir, metric)
    if perf_path.is_file():
        perf_df = data.load_parquet(perf_path)
    else:
        logger.debug(f"Calculating performance overview for {metric.name()}")
        perf_df = cla.get_performance_overview(class_df)

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
