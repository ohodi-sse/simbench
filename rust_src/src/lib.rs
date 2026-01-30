use pyo3::prelude::*;
mod tables;

#[pymodule]
mod rust_src {

    use crate::tables::{compression, pairwise_compressions, strings_to_sources};
    use pyo3::exceptions::PyTypeError;
    use pyo3::prelude::*;
    use pyo3_polars::PyDataFrame;

    #[pyfunction]
    fn py_compressions(pathstrings: Vec<String>) -> PyResult<PyDataFrame> {
        let srcs = strings_to_sources(&pathstrings);

        match srcs {
            Ok(res) => Ok(PyDataFrame(
                compression(res).map_err(|e| PyTypeError::new_err(e.to_string()))?,
            )),
            Err(e) => Err(PyTypeError::new_err(e.to_string())),
        }
    }

    #[pyfunction]
    fn py_pairwise_compressions(pathstrings: Vec<String>) -> PyResult<PyDataFrame> {
        let srcs = strings_to_sources(&pathstrings);

        match srcs {
            Ok(res) => Ok(PyDataFrame(
                pairwise_compressions(res).map_err(|e| PyTypeError::new_err(e.to_string()))?,
            )),
            Err(e) => Err(PyTypeError::new_err(e.to_string())),
        }
    }
}
