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


def get_compfile_path(dir: Path, metric: SimilarityMetric) -> Path:
    filename = f"{metric.name()}_{metric.compressor.name()}_{metric.compressor.compression_lvl}-compressions.parquet"
    return Path.cwd() / dir / "analyses" / filename


def get_compclass_path(dir: Path, metric: SimilarityMetric) -> Path:
    filename = f"{metric.compressor.name()}_{metric.compressor.compression_lvl}-concat_compressions.parquet"
    return Path.cwd() / dir / "analyses" / filename


def get_dist_path(dir: Path, metric: SimilarityMetric) -> Path:
    sim_filename = f"{metric.name()}_{metric.compressor.name()}_{metric.compressor.compression_lvl}-distances.parquet"
    return Path.cwd() / dir / "analyses" / sim_filename


def get_classification_path(
    dir: Path, metric: SimilarityMetric, classifier: Classifier
) -> Path:
    classf_filename = f"{metric.name()}_{metric.compressor.name()}_{metric.compressor.compression_lvl}-{classifier.name()}-classifications.parquet"
    return Path.cwd() / dir / "analyses" / classf_filename


def get_performance_overview_path(
    dir: Path, metric: SimilarityMetric, classifier: Classifier
) -> Path:
    filename = f"{metric.name()}_{metric.compressor.name()}_{metric.compressor.compression_lvl}-{classifier.name()}-performance_overview.parquet"
    return Path.cwd() / dir / "analyses" / filename


def run_analysis(
    datadir: Path, metric: SimilarityMetric, classifier: Classifier, write: bool
) -> tuple[
    pl.LazyFrame, pl.LazyFrame, pl.LazyFrame, pl.LazyFrame, pl.LazyFrame, pl.LazyFrame
]:
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

    filelist = data.filelist_from_data(data_df)

    compfile_path = get_compfile_path(datadir, metric)
    if compfile_path.is_file():
        logger.debug(f"Loading file compressions from {compfile_path}")
        compfile_df = data.load_parquet(compfile_path)
    else:
        logger.debug(f"Calculating file compressions for {metric.name()}")
        compfile_df = sim.create_comp_file(metric.compressor, filelist)

    compclass_path = get_compclass_path(datadir, metric)
    if compclass_path.is_file():
        logger.debug(f"Loading concatenated compressions from {compclass_path}")
        compclass_df = data.load_parquet(compclass_path)
    else:
        logger.debug(f"Calculating concatenated compressions for {metric.name()}")
        compclass_df = sim.create_comp_class(metric.compressor, filelist)

    dist_path = get_dist_path(datadir, metric)
    if dist_path.is_file():
        logger.debug(f"Loading distances from {dist_path}")
        distance_df = data.load_parquet(dist_path)
    else:
        logger.debug(f"Calculating distances for {metric.name()}")

        distance_df = sim.create_distance_file_polars(
            metric, compfile_df, compclass_df, filelist
        )

    classify_path = get_classification_path(datadir, metric, classifier)
    if classify_path.is_file():
        logger.debug(f"Loading classifications from {classify_path}")
        class_df = data.load_parquet(classify_path)
    else:
        logger.debug(f"Classifying files with {classifier.name()}")
        class_df = create_classification_dataframe(distance_df, classifier)

    perf_path = get_performance_overview_path(datadir, metric, classifier)
    if perf_path.is_file():
        logger.debug(f"Loading performance overview from {perf_path}")
        perf_df = data.load_parquet(perf_path)
    else:
        logger.debug(f"Calculating performance overview for {metric.name()}")
        perf_df = get_performance_scikit(class_df)

    if write:
        logger.info(f"Writing data overview to {str(data_path)}")
        data_df.collect().write_parquet(data_path.resolve())

        logger.info(f"Writing compression data to {str(compfile_path)}")
        compfile_df.collect().write_parquet(compfile_path.resolve())

        logger.info(f"Writing concatenated compression data to {str(compclass_path)}")
        compclass_df.collect().write_parquet(compclass_path.resolve())

        logger.info(f"Writing distance data to {str(dist_path)}")
        distance_df.collect().write_parquet(dist_path.resolve())

        logger.info(f"Writing classifications to {str(classify_path)}")
        class_df.collect().write_parquet(classify_path.resolve())

        logger.info(f"Writing performance overview to {str(perf_path)}")
        perf_df.collect().write_parquet(perf_path.resolve())

        return (data_df, compfile_df, compclass_df, distance_df, class_df, perf_df)
    else:
        return (data_df, compfile_df, compclass_df, distance_df, class_df, perf_df)


def extract_bad_matches(dist_df: pl.LazyFrame) -> pl.LazyFrame:
    assert dist_df.collect_schema() == data.DISTANCE_SCHEMA, (
        "Can only extract bad matches from distance file"
    )

    classifier = get_classifier("bm")
    assert classifier

    class_df = create_classification_dataframe(dist_df, classifier)
    expr = pl.col("src_label") != pl.col("labelled_as")
    bad_srcs = pl.Series(class_df.filter(expr).select("src").collect()).to_list()

    bad_srcs_list = [
        dist_df.filter((pl.col("src") == bad_src) & (pl.col("src") != pl.col("target")))
        .sort(by="similarity", descending=True)
        .select("src")
        .collect()
        .item(0, "src")
        for bad_src in bad_srcs
    ]

    bad_targets_list = [
        dist_df.filter((pl.col("src") == bad_src) & (pl.col("src") != pl.col("target")))
        .sort(by="similarity", descending=True)
        .select("target")
        .collect()
        .item(0, "target")
        for bad_src in bad_srcs
    ]

    bad_matches = [(s, t) for (s, t) in zip(bad_srcs_list, bad_targets_list)]
    logger.debug(bad_matches)

    return bad_matches
