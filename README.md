# Overview 

The following is a benchmark suite for testing how well the metric know as Normalized Compressed Distance (NCD) works for finding similarities between files.
It can be instantiated from a series of compression algorithms like zstd, gzip and others. 



# Installation

This benchmark suite uses the package manager uv. It is therefore required to have it installed.

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
```
uv run simbench analyse <path-to-data-dir>
```

This will run the full benchmark analysis on the data. 
It is possible to filter which tools and classifiers will be used by the analysis.
This is done by specifying a regex which will then run all matching tools. 
This can be done both for tools and classifiers. 



