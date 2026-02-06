use color_eyre::Result;
use color_eyre::eyre::eyre;
use flate2::Compression;
use flate2::write::GzEncoder;
use flate2::write::ZlibEncoder;
use indicatif::ParallelProgressIterator as _;
use polars::df;
use polars::prelude::*;
use rayon::prelude::*;
use std::io::prelude::*;
use std::path::PathBuf;
use std::time::*;

pub struct Source {
    name: String,
    label: String,
    bytes: Vec<u8>,
}

impl Source {
    fn new(path: PathBuf) -> Result<Source> {
        let bytes: Vec<u8> = std::fs::read(path.clone())?;
        let name = String::from(
            path.file_name()
                .ok_or(eyre!("Path does not exist"))?
                .to_str()
                .ok_or(eyre!("Cannot convert file name to str"))?,
        );
        let label = String::from(
            path.parent()
                .ok_or(eyre!("Path does not exist"))?
                .file_name()
                .ok_or(eyre!("Cannot extract label from path"))?
                .to_str()
                .ok_or(eyre!("Cannot convert label name to str"))?,
        );

        Ok(Source { name, label, bytes })
    }
}

#[derive(Debug, Clone, Copy)]
pub enum Compressor {
    Zstd(u32),
    Zlib(u32),
    Gzip(u32),
}

pub fn parse_compressor(compressor_name: &str, compression_lvl: u32) -> Result<Compressor> {
    match compressor_name {
        "zstd" => Ok(Compressor::Zstd(compression_lvl)),
        "zlib" => Ok(Compressor::Zlib(compression_lvl)),
        "gzip" => Ok(Compressor::Gzip(compression_lvl)),
        _ => Err(eyre!("Failed to parse compressor")),
    }
}

pub fn strings_to_sources(strings: &[String]) -> Result<Vec<Source>> {
    strings
        .iter()
        .map(|s| Source::new(PathBuf::from(&s)))
        .collect()
}

struct CompressionTable {
    src: String,
    src_comp: u64,
    src_size: u64,
    src_ratio: f64,
    src_time: u64,
    src_label: String,
}

macro_rules! dataframe_from_struct {
    ($input:expr, [$($field:ident),+]) => {
        {
            let len = $input.len();

            // Extract the field values into separate vectors
            $(let mut $field = Vec::with_capacity(len);)*

            for e in $input.into_iter() {
                $($field.push(e.$field);)*
            }
            df! {
                $(stringify!($field) => $field,)*
            }
        }
    };
}

pub fn compressions(compressor: Compressor, srcs: Vec<Source>) -> Result<DataFrame> {
    let result_rows: Result<Vec<CompressionTable>> = srcs
        .iter()
        .map(|s| -> Result<CompressionTable> { compute_comp_row(compressor, s) })
        .collect();

    let result_rows = result_rows?;

    let dataframe = dataframe_from_struct!(
        result_rows,
        [src, src_comp, src_size, src_ratio, src_time, src_label]
    );

    Ok(dataframe?)
}

fn compute_comp_row(compressor: Compressor, s: &Source) -> Result<CompressionTable> {
    let buffer = &s.bytes;

    let srclen = buffer.len() as u64;

    let now = Instant::now();

    let complen: usize = match compressor {
        Compressor::Zstd(lvl) => {
            let mut dstbuffer = [0; 50000];
            let result =
                zstd_safe::compress(dstbuffer.as_mut_slice(), buffer.as_slice(), lvl as i32).ok();
            result.ok_or(eyre!("Failed to store concatenated files in buffer"))?
        }
        Compressor::Zlib(lvl) => {
            let mut e = ZlibEncoder::new(Vec::new(), Compression::new(lvl));
            e.write_all(buffer)?;
            e.finish()?.len()
        }
        Compressor::Gzip(lvl) => {
            let mut e = GzEncoder::new(Vec::new(), Compression::new(lvl));
            e.write_all(buffer)?;
            e.finish()?.len()
        }
    };

    let timed = now.elapsed();

    Ok(CompressionTable {
        src: s.name.clone(),
        src_comp: complen as u64,
        src_size: srclen,
        src_ratio: (complen as f64) / (srclen as f64),
        src_time: timed.as_nanos() as u64,
        src_label: s.label.clone(),
    })
}

struct PairwiseCompressionTable {
    src: String,
    tgt: String,
    srctgt_size: u64,
    srctgt_comp: u64,
    srctgt_ratio: f64,
    srctgt_time: u64,
}

pub fn pairwise_compressions(compressor: Compressor, srcs: Vec<Source>) -> Result<DataFrame> {
    let result_rows: Result<Vec<PairwiseCompressionTable>> = srcs
        .par_iter()
        .progress()
        .flat_map(|s1| {
            srcs.par_iter()
                .map(|s2| compute_pair_row(compressor, s1, s2))
        })
        .collect();

    let result_rows = result_rows?;

    let dataframe = dataframe_from_struct!(
        result_rows,
        [
            src,
            tgt,
            srctgt_size,
            srctgt_comp,
            srctgt_ratio,
            srctgt_time
        ]
    );

    Ok(dataframe?)
}

// Fast version using only zstd safe
fn compute_pair_row(
    compressor: Compressor,
    s1: &Source,
    s2: &Source,
) -> Result<PairwiseCompressionTable> {
    let mut buffer = Vec::with_capacity(s1.bytes.len() + s2.bytes.len());
    buffer.extend(&s1.bytes);
    buffer.extend(&s2.bytes);

    let srclen = buffer.len() as u64;
    let now = Instant::now();
    let complen: usize = match compressor {
        Compressor::Zstd(lvl) => {
            let mut dstbuffer = [0; 10000];
            let result =
                zstd_safe::compress(dstbuffer.as_mut_slice(), buffer.as_slice(), lvl as i32).ok();
            result.ok_or(eyre!("Failed to store concatenated files in buffer"))?
        }
        Compressor::Zlib(lvl) => {
            let mut e = ZlibEncoder::new(Vec::new(), Compression::new(lvl));
            e.write_all(&buffer)?;
            e.finish()?.len()
        }
        Compressor::Gzip(lvl) => {
            let mut e = GzEncoder::new(Vec::new(), Compression::new(lvl));
            e.write_all(&buffer)?;
            e.finish()?.len()
        }
    };

    let timed = now.elapsed();

    Ok(PairwiseCompressionTable {
        src: s1.name.clone(),
        tgt: s2.name.clone(),
        srctgt_comp: complen as u64,
        srctgt_size: srclen,
        srctgt_ratio: (complen as f64) / (srclen as f64),
        srctgt_time: timed.as_nanos() as u64,
    })
}
