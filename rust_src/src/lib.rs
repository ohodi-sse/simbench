use pyo3::exceptions::{PyRuntimeError, PyTypeError};
use pyo3::prelude::*;
use pyo3_polars::PyDataFrame;
use simbenchers_core::normalizers::{batch_format, batch_optimize};
use simbenchers_core::{
    normalizers::{batch_compile, batch_decompile},
    tables::{compressions, pairwise_compressions, strings_to_sources},
};

#[pyfunction]
#[pyo3(name = "rust_compressions")]
#[pyo3(signature = (compressor_name, compression_lvl,pathstrings, /))]
fn rust_compressions(
    compressor_name: String,
    compression_lvl: u32,
    pathstrings: Vec<String>,
) -> PyResult<PyDataFrame> {
    let srcs = strings_to_sources(&pathstrings);
    let compressor =
        simbenchers_core::tables::parse_compressor(compressor_name.as_str(), compression_lvl);

    match (compressor, srcs) {
        (Ok(comp), Ok(res)) => Ok(PyDataFrame(
            compressions(comp, res).map_err(|e| PyTypeError::new_err(e.to_string()))?,
        )),
        (Err(e), _) => Err(PyRuntimeError::new_err(format!("{:?}", e))),
        (_, Err(e)) => Err(PyRuntimeError::new_err(format!("{:?}", e))),
    }
}

#[pyfunction]
#[pyo3(name = "rust_pairwise_compressions")]
#[pyo3(signature = (compressor_name, compression_lvl,pathstrings, /))]
fn rust_pairwise_compressions(
    compressor_name: String,
    compression_lvl: u32,
    pathstrings: Vec<String>,
) -> PyResult<PyDataFrame> {
    let srcs = strings_to_sources(&pathstrings);
    let compressor =
        simbenchers_core::tables::parse_compressor(compressor_name.as_str(), compression_lvl);

    match (compressor, srcs) {
        (Ok(comp), Ok(res)) => Ok(PyDataFrame(
            pairwise_compressions(comp, res).map_err(|e| PyTypeError::new_err(e.to_string()))?,
        )),
        (Err(e), _) => Err(PyTypeError::new_err(e.to_string())),
        (_, Err(e)) => Err(PyTypeError::new_err(e.to_string())),
    }
}

macro_rules! expose_rust_fn {
    ($name:ident,$python_name:literal,$f:ident) => {
        #[pyfunction]
        #[pyo3(name = $python_name)]
        #[pyo3(signature = (source_strings, target_strings, /))]
        fn $name(source_strings: Vec<String>, target_strings: Vec<String>) -> PyResult<()> {
            $f(&source_strings, &target_strings)
                .map_err(|e| PyRuntimeError::new_err(format!("{:?}", e)))
        }
    };
}

expose_rust_fn!(rust_batch_compile, "rust_batch_compile", batch_compile);
expose_rust_fn!(
    rust_batch_decompile,
    "rust_batch_decompile",
    batch_decompile
);
expose_rust_fn!(rust_batch_optimize, "rust_batch_optimize", batch_optimize);
expose_rust_fn!(rust_batch_format, "rust_batch_format", batch_format);

#[pymodule]
fn rust_src(_py: Python, m: &Bound<'_, PyModule>) -> PyResult<()> {
    rayon::ThreadPoolBuilder::new()
        .num_threads(4)
        .build_global()
        .unwrap();

    m.add_function(wrap_pyfunction!(rust_compressions, m)?)?;
    m.add_function(wrap_pyfunction!(rust_pairwise_compressions, m)?)?;
    m.add_function(wrap_pyfunction!(rust_batch_decompile, m)?)?;
    m.add_function(wrap_pyfunction!(rust_batch_compile, m)?)?;
    m.add_function(wrap_pyfunction!(rust_batch_optimize, m)?)?;
    m.add_function(wrap_pyfunction!(rust_batch_format, m)?)?;
    Ok(())
}
