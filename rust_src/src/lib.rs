use pyo3::prelude::*;

#[pymodule]
mod rust_src {

    use pyo3::exceptions::{PyRuntimeError, PyTypeError};
    use pyo3::prelude::*;
    use pyo3_polars::PyDataFrame;
    use simbenchers_core::normalizers::batch_optimize;
    use simbenchers_core::{
        normalizers::{batch_compile, batch_decompile},
        tables::{compressions, pairwise_compressions, strings_to_sources},
    };

    #[pyfunction]
    #[pyo3(name = "rust_compressions")]
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
                pairwise_compressions(comp, res)
                    .map_err(|e| PyTypeError::new_err(e.to_string()))?,
            )),
            (Err(e), _) => Err(PyTypeError::new_err(e.to_string())),
            (_, Err(e)) => Err(PyTypeError::new_err(e.to_string())),
        }
    }

    #[pyfunction]
    #[pyo3(name = "rust_batch_compile")]
    fn rust_batch_compile(
        source_strings: Vec<String>,
        target_strings: Vec<String>,
    ) -> PyResult<()> {
        batch_compile(source_strings, target_strings)
            .map_err(|e| PyRuntimeError::new_err(format!("{:?}", e)))
    }
    #[pyfunction]
    #[pyo3(name = "rust_batch_optimize")]
    fn rust_batch_optimize(
        source_strings: Vec<String>,
        target_strings: Vec<String>,
    ) -> PyResult<()> {
        batch_optimize(source_strings, target_strings)
            .map_err(|e| PyRuntimeError::new_err(format!("{:?}", e)))
    }
    #[pyfunction]
    #[pyo3(name = "rust_batch_decompile")]
    fn rust_batch_decompile(
        source_strings: Vec<String>,
        target_strings: Vec<String>,
    ) -> PyResult<()> {
        batch_decompile(source_strings, target_strings)
            .map_err(|e| PyRuntimeError::new_err(format!("{:?}", e)))
    }
}
