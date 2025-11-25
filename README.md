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
├── analyses
├── class1
├── class2
├── class3
├── class4
└── class5
```

The _analyses_ directory is where the analyses will be put. 

To try to classify all run 
```
uv run simbench analyse <path-to-data-dir>
```
This will calculate the pairwise similarity in all files in directories class1-class5 using NCD instantiated from a zstd compressor with compression level 1.
It will then do a best match classification, and print the performance results of the classifier. 

To change the compressor used add a _-c_ option along with the name of the compressor as follows:
```
uv run simbench analyse -c gzip 
```
If you want to specify the compression level as well it can be done like so:
```
uv run simbench analyse -c gzip_clvl_9
```

To change the classifier used _-cl_ can be used:
```
uv run simbench analyse -c gzip_clvl_9 -cl knn_10
```
The above will run the analysis with gzip with compression level 9 and a KNN classifier with K=10. 

