import polars as pl
from sklearn.metrics import (
    precision_recall_fscore_support,
    accuracy_score,
    confusion_matrix,
)
import numpy as np
import itertools

from simbench.build import TableBuilder, schema, tablenode, Builder, NamedCallable
from simbench.compressors import Compressor, Diff
from simbench.metrics import Metric
from simbench.classification import Classifier
from rust_src import rust_compressions, rust_pairwise_compressions


class CompressionTable:
    src: pl.String
    src_comp: pl.UInt64
    src_size: pl.UInt64
    src_ratio: pl.Float64
    src_time: pl.UInt64
    src_label: pl.String


@tablenode(schema(CompressionTable))
def compressions(
    schema: pl.Schema,
    bld: Builder,
    compressor: Compressor,
    **sources,
):
    out = TableBuilder(schema)

    bld.log.info(f"Computing compression table for {compressor.name}")

    paths = [str(s.path) for _, s in sources.items()]
    rust_df = rust_compressions(compressor.name, compressor.level, paths).lazy()
    out.from_lazyframe(rust_df)
    return out.getvalue()


class PairwiseCompressionTable:
    src: pl.String
    tgt: pl.String
    srctgt_size: pl.UInt64
    srctgt_comp: pl.UInt64
    srctgt_ratio: pl.Float64
    srctgt_time: pl.UInt64


@tablenode(schema(PairwiseCompressionTable))
def pairwise_compressions(
    schema: pl.Schema,
    bld: Builder,
    compressor: Compressor,
    **sources,
):
    out = TableBuilder(schema)

    bld.log.info(f"Computing pairwise compressions table for {compressor.name}")
    paths = [str(s.path) for _, s in sources.items()]
    rust_df = rust_pairwise_compressions(
        compressor.name, compressor.level, paths
    ).lazy()

    out.from_lazyframe(rust_df)
    return out.getvalue()


class DiffTable:
    src: pl.String
    tgt: pl.String
    src_label: pl.String
    tgt_label: pl.String
    tgt_len: pl.UInt64
    diff_len: pl.UInt64
    diff_time: pl.UInt64


@tablenode(schema(DiffTable))
def pairwise_diff(
    schema: pl.Schema,
    bld: Builder,
    diff: Diff,
    **sources,
):
    out = TableBuilder(schema)

    bld.log.info(f"Computing pairwise diffs table for {diff.name}")

    byte_lookup = {name: src.get_bytes() for name, src in sources.items()}  # For speed
    srcs = [src for _, src in sources.items()]

    n = len(byte_lookup) ** 2
    with bld.progressbar(n) as pb:
        for src, tgt in itertools.product(srcs, repeat=2):
            pb.inc(1)

            with bld.profile() as timed:
                difflen = diff.diff_length(byte_lookup[src.name], byte_lookup[tgt.name])

            tgtlen = len(byte_lookup[tgt.name])
            out.add(
                src=src.name,
                tgt=tgt.name,
                src_label=src.label,
                tgt_label=tgt.label,
                tgt_len=tgtlen,
                diff_len=difflen,
                diff_time=timed(),
            )

    return out.getvalue()


class DistanceTable:
    src: pl.String
    tgt: pl.String
    src_label: pl.String
    tgt_label: pl.String
    distance: pl.Float32
    time: pl.UInt64


@tablenode(schema(DistanceTable))
def comp_distances(
    schema: pl.Schema,
    bld: Builder,
    metric: Metric,
    comp_df: pl.LazyFrame,
    compare_comp_df: pl.LazyFrame,
) -> pl.LazyFrame:
    out = TableBuilder(schema)

    bld.log.info(f"Computing distance using {metric.name}")

    tgt_df = comp_df.rename(
        {
            "src": "tgt",
            "src_comp": "tgt_comp",
            "src_size": "tgt_size",
            "src_time": "tgt_time",
            "src_ratio": "tgt_ratio",
            "src_label": "tgt_label",
        }
    )
    comp_file_df = comp_df.join(tgt_df, how="cross")
    metric_df = comp_file_df.join(compare_comp_df, on=["src", "tgt"], how="inner")

    out.from_lazyframe(metric(metric_df))

    return out.getvalue()


@tablenode(schema(DistanceTable))
def generic_distances(
    schema: pl.Schema,
    bld: Builder,
    tool: NamedCallable,
    **sources,
) -> pl.LazyFrame:
    out = TableBuilder(schema)

    bld.log.debug("Preprocessing files. This may take a while!")

    preprocess_lookup = {}

    srcs = [src for _, src in sources.items()]
    with bld.progressbar(len(srcs)) as pb:
        for name, src in sources.items():
            preprocess_lookup[name] = tool.preprocess(src)
            pb.inc(1)

    n = len(preprocess_lookup) ** 2
    with bld.progressbar(n) as pb:
        for src, tgt in itertools.product(srcs, repeat=2):
            pb.inc(1)

            with bld.profile() as timed:
                dist = tool(preprocess_lookup[src.name], preprocess_lookup[tgt.name])

            out.add(
                src=src.name,
                tgt=tgt.name,
                src_label=src.label,
                tgt_label=tgt.label,
                distance=dist,
                time=timed(),
            )

    return out.getvalue()


@tablenode(schema(DistanceTable))
def diff_distances(
    schema: pl.Schema,
    bld: Builder,
    metric: Metric,
    diff_df: pl.LazyFrame,
) -> pl.LazyFrame:
    out = TableBuilder(schema)

    bld.log.info(f"Computing distance using {metric.name}")

    out.from_lazyframe(metric(diff_df))

    return out.getvalue()


class ClassificationTable:
    src: pl.String
    src_label: pl.String
    classifier: pl.String
    class_param: pl.Float32
    labelled_as: pl.String


@tablenode(schema(ClassificationTable))
def classifications(
    schema: pl.Schema, bld: Builder, classifier: Classifier, distances: pl.LazyFrame
) -> pl.LazyFrame:
    out = TableBuilder(schema)
    src_df = distances.select("src", "src_label").unique(maintain_order=True)
    src_names = pl.Series(src_df.select("src").collect()).to_list()
    src_labels = pl.Series(src_df.select("src_label").collect()).to_list()

    bld.log.debug(f"Classifying using {classifier.name}-{classifier.param}")

    with bld.progressbar(len(src_names)) as pb:
        for src, label in zip(src_names, src_labels):
            pb.inc(1)
            c = classifier.classify(distances, src)

            if c is not None:
                out.add(
                    src=src,
                    src_label=label,
                    classifier=classifier.name,
                    class_param=classifier.param,
                    labelled_as=c.labelled_as,
                )

    return out.getvalue()


class PerformanceTable:
    classifier: pl.String
    class_param: pl.Float32
    FP: pl.UInt64
    FN: pl.UInt64
    Acc: pl.Float32
    Prec: pl.Float32
    Rec: pl.Float32
    F1: pl.Float32


@tablenode(schema(PerformanceTable))
def performance(schema: pl.Schema, bld: Builder, **classifications) -> pl.LazyFrame:
    out = TableBuilder(schema)

    def get_performance_row(class_df: pl.LazyFrame):
        classif = pl.Series(class_df.select("classifier").unique().collect()).item()
        param = pl.Series(class_df.select("class_param").unique().collect()).item()

        src_labels = pl.Series(class_df.select("src_label").collect()).to_list()
        labelled_as = pl.Series(class_df.select("labelled_as").collect()).to_list()
        cm = confusion_matrix(src_labels, labelled_as)

        FP = sum(cm.sum(axis=0) - np.diag(cm))
        FN = sum(cm.sum(axis=1) - np.diag(cm))
        averaging = "macro"

        accuracy = accuracy_score(src_labels, labelled_as)
        precision, recall, f_score, _ = precision_recall_fscore_support(
            src_labels, labelled_as, average=averaging, zero_division=0.0
        )

        return classif, param, FP, FN, accuracy, precision, recall, f_score

    for _, classification in classifications.items():
        assert isinstance(classification, pl.LazyFrame), f"Got: {classification}"

        if classification.collect().is_empty():
            continue

        classif, param, FP, FN, accuracy, precision, recall, f_score = (
            get_performance_row(classification)
        )

        out.add(
            classifier=classif,
            class_param=param,
            FP=FP,
            FN=FN,
            Acc=accuracy,
            Prec=precision,
            Rec=recall,
            F1=f_score,
        )

    return out.getvalue()
