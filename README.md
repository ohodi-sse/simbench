# Overview 

The following is a benchmark suite for testing how well the metric know as Normalized Compressed Distance (NCD) works for finding similarities between files.
It can be instantiated from a series of compression algorithms like zstd, gzip and others. 

# Installation

This benchmark suite uses the package manager uv. It is therefore required to have it installed. 
For more information we refer to the official documentation: [UV Installation](https://docs.astral.sh/uv/getting-started/installation/)

To check that everything works it is recommended to start by running the following:

```python 
uv run pytest
```

# Using the suite 

To use the benchmark suite on a some data you need to first sort your data. 
This means you should have a file structure which looks as follows:

```
data
├── class1
├── class2
├── class3
├── class4
└── class5
```


To try to classify all run 
```bash
uv run simbench analyse <path-to-data-dir>
```

This will run the full benchmark analysis on the data. 
Since some of the analyses take time, the benchmark is built to cache intermediate results as polars dataframes.


## Filtering
It is possible to filter which tools and classifiers will be used by the analysis.
This is done by specifying a regex which will then run all matching tools. 
```bash
uv run simbench analyse <path-to-data-dir> --tool "(.*zstd.*|.*BERT.*)" --normalizer "(unprocessed|token_format)"
```
The command above thus runs the experiment for all zstd and BERT tool combinations on unprocessed and tokenized data.
The regex patterns match on the names as defined for the different tools defined in compressors.py, similarity_measures.py and normalizers.py

This can also be done both for classifiers. 


## Evaluation and performance
To compare the performance of different tools and similarity measures run the following:
```bash
uv run simbench comparison-performance-table <path-to-data-dir> --show 
```

Similarly, to get some evaluation data run
```bash
uv run simbench comparison-evaluation-table <path-to-data-dir> --show 
```

## Subsampling 
In the case where it is infeasible to run the analyses on all datapoint, one can choose the sample size. 
To ensure reproducibility it is advised to run this in conjunction with the seed parameter. 
This will store the results in a new directory specifying the seed which was used for the results

```bash
uv run simbench analyse <path-to-data-dir> --seed <value> --samples <number of samples>
```


# Experiments

To recreate the experiments run for the paper, refer to experiments.py. This runs using marimo notebooks.
To run it use:
```bash 
uv run marimo run experiments.py
```
```
```
