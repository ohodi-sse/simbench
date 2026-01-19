import polars as pl

from simbench.tables import ClassificationTable, schema


def find_classification_difference(class1_path, class2_path):
    # This function takes two classification files, and returns a dataframe containing all
    # solutions that were intially misclassified in class1 but rectified in class2
    # The intended use of this function is to locate code examples for which the
    # preprocessing of class2 has improved the performance of the classification

    class_df1 = pl.read_parquet(class1_path)
    class_df2 = pl.read_parquet(class2_path)

    assert isinstance(class_df1, pl.DataFrame)
    assert isinstance(class_df2, pl.DataFrame)

    assert class_df1.schema == schema(ClassificationTable)
    prejoindf = class_df2.select(pl.col("src"), pl.col("labelled_as").alias("label2"))
    diff_df = (
        class_df1.select(
            pl.col("src"), pl.col("src_label"), pl.col("labelled_as").alias("label1")
        )
        .join(prejoindf, on="src")
        .filter(pl.col("src_label") != pl.col("label1"))
        .filter(pl.col("src_label") == pl.col("label2"))
        .filter(pl.col("label1") != pl.col("label2"))
    )

    return diff_df
