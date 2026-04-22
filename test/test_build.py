from simbench.AI_tools import AITool
from simbench.analysis import CompressionAnalysis
from simbench.build import Node, schema
from simbench.tables import (
    CompressionTable,
    DistanceTable,
    PairwiseCompressionTable,
    ClassificationTable,
)
import polars as pl


def test_comp_node(test_analysis, test_bld):
    if isinstance(test_analysis, CompressionAnalysis):
        comp_node = test_analysis.comp_node
        assert isinstance(comp_node, Node)

        comp_df = comp_node.pull(test_bld)
        assert isinstance(comp_df, pl.LazyFrame)

        assert schema(CompressionTable) == comp_df.collect().schema


def test_pair_node(test_analysis, test_bld):
    if isinstance(test_analysis, CompressionAnalysis):
        pair_node = test_analysis.pair_node
        assert isinstance(pair_node, Node)

        pair_df = pair_node.pull(test_bld)
        assert isinstance(pair_df, pl.LazyFrame)
        assert schema(PairwiseCompressionTable) == pair_df.collect().schema


def test_dist_node(test_analysis, test_bld):
    if not isinstance(test_analysis.tool, AITool):
        dist_node = test_analysis.distance_node
        assert isinstance(dist_node, Node)

        dist_df = dist_node.pull(test_bld)
        assert isinstance(dist_df, pl.LazyFrame)
        assert schema(DistanceTable) == dist_df.collect().schema
    elif (
        isinstance(test_analysis.tool, AITool)
        and test_analysis.normalizer.name == "unprocessed"
    ):
        dist_node = test_analysis.distance_node
        assert isinstance(dist_node, Node)

        dist_df = dist_node.pull(test_bld)
        assert isinstance(dist_df, pl.LazyFrame)
        assert schema(DistanceTable) == dist_df.collect().schema


def test_classification_node(test_analysis, test_bld):
    cl_nodes = test_analysis.classification_nodes
    assert isinstance(cl_nodes, dict)

    cl_df_list = [cl_df.pull(test_bld) for _, cl_df in cl_nodes.items()]
    assert all([isinstance(cl_df, pl.LazyFrame) for cl_df in cl_df_list])
    assert all(
        [schema(ClassificationTable) == cl_df.collect().schema for cl_df in cl_df_list]
    )
