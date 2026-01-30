use color_eyre::Result;
use color_eyre::eyre::eyre;
use duct::ReaderHandle;
use duct::cmd;
use indicatif::ParallelProgressIterator as _;
use polars::df;
use polars::prelude::*;
use rayon::prelude::*;
use std::io::Read;
use std::os::unix::ffi::OsStringExt;
use std::path::PathBuf;
use std::time::*;

pub struct Source {
    name: String,
    label: String,
    path: PathBuf,
    bytes: Vec<u8>,
}

impl Source {
    fn new(path: PathBuf) -> Result<Source> {
        let bytes: Vec<u8> = std::fs::read(path.clone())?;
        let name = String::from(
            path.file_name()
                .ok_or(eyre!("Path does not exist"))?
                .to_str()
                .ok_or(eyre!("Hello stupid"))?,
        );
        let label = String::from(
            path.parent()
                .ok_or(eyre!("Path does not exist"))?
                .to_str()
                .ok_or(eyre!("Cannot"))?,
        );

        Ok(Source {
            name,
            label,
            path,
            bytes,
        })
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

pub fn compression(srcs: Vec<Source>) -> Result<DataFrame> {
    //let bar = ProgressBar::new(srcs.len() as u64);

    let result_rows: Result<Vec<CompressionTable>> = srcs
        .iter()
        .map(|s| -> Result<CompressionTable> { compute_comp_row(s) })
        .collect();

    let result_rows = result_rows?;

    let dataframe = dataframe_from_struct!(
        result_rows,
        [src, src_comp, src_size, src_ratio, src_time, src_label]
    );

    Ok(dataframe?)
}

fn compute_comp_row(s: &Source) -> Result<CompressionTable> {
    let buffer = &s.bytes;
    //let comp_lvl: i32 = 3;
    //let mut dstbuffer: Vec<u8> = vec![0; 10000];

    let now = Instant::now();
    //
    // let mut zstd_process = Command::new("zstd")
    //     .arg("-c")
    //     .arg(format!("-{:?}", comp_lvl))
    //     .stdin(Stdio::piped())
    //     .stderr(Stdio::inherit())
    //     .spawn()?;
    //
    // let mut stdin = zstd_process.stdin.take().unwrap();
    // stdin.write_all(buffer.as_slice())?;
    let stdout = cmd!("zstd", "-c", OsString::from_vec(buffer.clone())).read()?;

    //let result = zstd_safe::compress(dstbuffer.as_mut_slice(), buffer.as_slice(), comp_lvl);
    let optlen = stdout.len();

    let timed = now.elapsed();

    // let optlen = match result {
    //     Ok(complen) => complen,
    //     Err(e) => {
    //         return Err(eyre!(
    //             "Buffer of size {e} could not contain the compressed file"
    //         ));
    //     }
    // };

    let srclen = buffer.len() as u64;

    Ok(CompressionTable {
        src: s.name.clone(),
        src_comp: optlen as u64,
        src_size: srclen,
        src_ratio: (optlen as f64) / (srclen as f64),
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

pub fn pairwise_compressions(srcs: Vec<Source>) -> Result<DataFrame> {
    //let bar = ProgressBar::new(srcs.len() as u64);

    let result_rows: Result<Vec<PairwiseCompressionTable>> = srcs
        .par_iter()
        .progress()
        .flat_map(|s1| srcs.par_iter().map(|s2| compute_pair_row(s1, s2)))
        .collect();

    let result_rows = result_rows?;

    let dataframe = dataframe_from_struct!(
        result_rows,
        [
            src,
            tgt,
            srctgt_comp,
            srctgt_size,
            srctgt_ratio,
            srctgt_time
        ]
    );

    Ok(dataframe?)
}

fn compute_pair_row(s1: &Source, s2: &Source) -> Result<PairwiseCompressionTable> {
    let mut buffer = Vec::with_capacity(s1.bytes.len() + s2.bytes.len());
    buffer.extend(&s1.bytes);
    buffer.extend(&s2.bytes);

    let dstbuffer = [0; 1000];
    let comp_lvl: i32 = 3;

    let now = Instant::now();
    let result = zstd_safe::compress(dstbuffer.as_mut_slice(), buffer.as_slice(), comp_lvl);

    // let srclen = buffer.len() as u64;
    // let process: ReaderHandle = cmd!("zstd", "-c", format!("-{:?}", comp_lvl), "-")
    //     .stdin_bytes(buffer)
    //     .reader?;
    //
    // let result: Result<Vec<u8>> = process.bytes().collect();

    //println!("{:?}", stdout);
    let optlen = result.len();

    //let result = zstd_safe::compress(dstbuffer.as_mut_slice(), buffer.as_slice(), comp_lvl);
    let timed = now.elapsed();

    Ok(PairwiseCompressionTable {
        src: s1.name.clone(),
        tgt: s2.name.clone(),
        srctgt_size: srclen,
        srctgt_comp: optlen as u64,
        srctgt_ratio: (optlen as f64) / (srclen as f64),
        srctgt_time: timed.as_nanos() as u64,
    })
}
