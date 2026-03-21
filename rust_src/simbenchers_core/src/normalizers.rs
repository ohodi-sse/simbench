use camino::{Utf8Path, Utf8PathBuf};
use color_eyre::eyre::eyre;
use color_eyre::{Result, eyre::OptionExt};

use duct::cmd;
use indicatif::{ParallelProgressIterator, ProgressStyle};
use rayon::iter::IntoParallelRefIterator;
use rayon::prelude::*;
use std::env;
use std::fs::File;
use std::io::{BufWriter, Write};
use std::path::Path;
use tempfile::tempdir_in;

fn get_parent_dir(filepath: &Utf8Path) -> Result<&Utf8Path> {
    filepath
        .parent()
        .ok_or_eyre("Failed to extract parent directory")
}

fn _get_file_name(filepath: &Utf8Path) -> Result<&str> {
    filepath
        .file_name()
        .ok_or_eyre("Failed to extract filename")
}

fn get_file_extension(filepath: &Utf8Path) -> Result<&str> {
    filepath
        .extension()
        .ok_or_eyre("Failed to extract filename")
}

fn compile_java(filepath: impl AsRef<Path>, compiled_path: impl AsRef<Path>) -> Result<()> {
    let filepath = Utf8Path::from_path(filepath.as_ref()).ok_or(eyre!(
        "Failed to create Utf8Path from {:?}",
        filepath.as_ref()
    ))?;
    debug_assert!(
        get_file_extension(filepath)? == "java",
        "Can only compile java file, found {}",
        filepath
    );
    let compiled_path = Utf8Path::from_path(compiled_path.as_ref()).ok_or(eyre!(
        "Failed to create Utf8Path from {:?}",
        compiled_path.as_ref()
    ))?;
    debug_assert!(
        get_file_extension(compiled_path)? == "jar",
        "Extension {:?} of {:?} should be jar",
        get_file_extension(compiled_path)?,
        compiled_path
    );
    debug_assert!(filepath.exists(), "Failed to locate file {}", filepath);

    // Create temporary directory
    let tmp_dir = tempdir_in(get_parent_dir(filepath)?.as_std_path())?;
    let tmp_file = tmp_dir.path().join("Main.java");

    // Copy file into new directory
    cmd!("cp", filepath, &tmp_file).run()?;
    debug_assert!(&tmp_file.exists(), "File was not copied properly");
    // Compile into the temporary directory
    cmd!("javac", "-nowarn", "-Xlint:-deprecation", &tmp_file)
        .dir(tmp_dir.path())
        .run()?;
    debug_assert!(
        tmp_dir.path().join("Main.class").exists(),
        "File was not compiled properly"
    );
    let current_path = env::current_dir()?;

    // Collect as jar file
    cmd!("jar", "cf", current_path.join(compiled_path), ".")
        .dir(tmp_dir.path())
        .run()?;
    debug_assert!(&compiled_path.exists(), "Jar was not created");

    let check = cmd!("jar", "tf", compiled_path)
        .stdout_capture()
        .run()?
        .stdout;

    debug_assert!(String::from_utf8(check.clone())?.contains("Main.class"));

    tmp_dir.close()?;

    Ok(())
}

fn optimize_w_proguard(filepath: impl AsRef<Path>, processed_path: impl AsRef<Path>) -> Result<()> {
    let filepath = Utf8Path::from_path(filepath.as_ref())
        .ok_or_else(|| eyre!("Failed to create Utf8Path from {:?}", filepath.as_ref()))?;

    debug_assert!(filepath.try_exists().is_ok());

    let processed_path = Utf8Path::from_path(processed_path.as_ref()).ok_or_else(|| {
        eyre!(
            "Failed to create Utf8Path from {:?}",
            processed_path.as_ref()
        )
    })?;

    let proguard_path = env::current_dir()?.join("processing_tools/proguard-7.8.2/");
    let binary_path = proguard_path.join("bin/proguard.sh");
    debug_assert!(binary_path.try_exists().is_ok());

    let config_file = proguard_path.join("optimizer.pro");
    debug_assert!(config_file.try_exists().is_ok());

    let full_file_path = env::current_dir()?.join(filepath);

    let full_processed_path = env::current_dir()?.join(processed_path);
    cmd!(
        binary_path,
        format!("@{}", config_file.to_string_lossy()),
        "-injars",
        full_file_path,
        "-outjars",
        full_processed_path
    )
    .stdout_null() // REMOVE THIS FOR DEBUGGING
    .run()?;

    Ok(())
}

fn decompile_w_procyon(
    filepath: impl AsRef<Path>,
    decompiled_path: impl AsRef<Path>,
) -> Result<()> {
    let filepath = Utf8Path::from_path(filepath.as_ref())
        .ok_or_eyre("Failed to convert filepath to Utf8Path")?;

    debug_assert!(
        filepath
            .extension()
            .ok_or_eyre("Failed to extract extension")?
            == "jar"
    );
    debug_assert!(filepath.exists(), "Failed to find file {}", filepath);
    debug_assert!(
        decompiled_path
            .as_ref()
            .extension()
            .ok_or_eyre("Failed to extract extension")?
            == "java"
    );
    let full_compiled_path = env::current_dir()?.join(filepath);
    let full_decompiled_path = env::current_dir()?.join(&decompiled_path);

    if full_decompiled_path.exists() {
        println!("The path {:?} already exists", full_decompiled_path);
        return Ok(());
    };

    debug_assert!(
        full_decompiled_path
            .parent()
            .ok_or_eyre("Parent cannot be extracted")?
            .exists(),
        "The path {:?} does not exist!",
        full_decompiled_path
            .parent()
            .ok_or_eyre("Parent cannot be extracted")
    );

    let mut output_file = File::create(full_decompiled_path)?;

    let decompiler_tool =
        env::current_dir()?.join("processing_tools/compiledecompile/procyon-decompiler-0.6.0.jar");
    // Compiling
    let decompilation = cmd!("java", "-jar", decompiler_tool, "-jar", full_compiled_path)
        .stdout_capture()
        .run()?;

    output_file.write_all(decompilation.stdout.as_slice())?;

    Ok(())
}

fn google_format(filepath: impl AsRef<Path>, formatted_path: impl AsRef<Path>) -> Result<()> {
    let filepath = Utf8Path::from_path(filepath.as_ref()).ok_or(eyre!(
        "Failed to create Utf8Path from {:?}",
        filepath.as_ref()
    ))?;
    assert!(
        get_file_extension(filepath)? == "java",
        "Can only compile java file, found {}",
        filepath
    );
    let formatted_path = Utf8Path::from_path(formatted_path.as_ref()).ok_or(eyre!(
        "Failed to create Utf8Path from {:?}",
        formatted_path.as_ref()
    ))?;

    let full_file_path = env::current_dir()?.join(filepath);
    let full_formatted_path = env::current_dir()?.join(formatted_path);

    let toolpath = env::current_dir()?
        .join("processing_tools/google_java_formatter/google-java-format-1.33.0-all-deps.jar");

    let output = cmd!("java", "-jar", toolpath, full_file_path)
        .stdout_capture()
        .run()?;

    // let mut output_file = File::create(full_formatted_path)?;
    let mut out = BufWriter::new(File::create(full_formatted_path)?);
    out.write_all(output.stdout.as_slice())?;
    out.flush()?;

    Ok(())
}

macro_rules! batch_process {
    ($name:ident,$f:ident) => {
        pub fn $name(source_files: &[String], target_files: &[String]) -> Result<()> {
            assert_eq!(source_files.len(), target_files.len());

            let style = ProgressStyle::with_template(    "{spinner:.green} [{elapsed_precise}] [{wide_bar:.cyan/blue}] {pos}/{len} ({per_sec}, {eta})")?;
            source_files
                .par_iter()
                .zip(target_files.par_iter())
                .progress_with_style(style)
                .try_for_each(|(src, tgt)| $f(Utf8PathBuf::from(src), Utf8PathBuf::from(tgt)))
        }
    };
}

batch_process!(batch_compile, compile_java);
batch_process!(batch_optimize, optimize_w_proguard);
batch_process!(batch_decompile, decompile_w_procyon);
batch_process!(batch_format, google_format);

#[cfg(test)]
mod tests {
    use super::*;
    use std::{fs::remove_file, io::Read};

    #[test]
    fn test_formatter() -> Result<()> {
        let testfile = Utf8Path::new("../tests/s001421950.java");

        let new_path = Path::new("s001421950_formatted.java");
        google_format(testfile, new_path)?;
        assert!(&new_path.exists());

        let mut file = File::open(new_path)?;
        let mut contents: Vec<u8> = vec![];
        file.read_to_end(&mut contents)?;

        assert!(!contents.is_empty());

        remove_file(new_path)?;

        assert!(!new_path.exists());

        Ok(())
    }

    #[test]
    fn test_compile_java() -> Result<()> {
        let testfile = Utf8Path::new("../tests/s001421950.java");

        let new_path = Path::new("s001421950.jar");
        compile_java(testfile, new_path)?;
        assert!(&new_path.exists());

        let mut file = File::open(new_path)?;
        let mut contents: Vec<u8> = vec![];
        file.read_to_end(&mut contents)?;

        assert!(!contents.is_empty());

        remove_file(new_path)?;

        assert!(!new_path.exists());

        Ok(())
    }
    #[test]
    fn test_optimize_w_proguard() -> Result<()> {
        let testfile = Utf8Path::new("../tests/s001421950.java");

        let mut tmpbld = tempfile::Builder::new();
        let compiled_file = tmpbld
            .prefix("s001421950_")
            .rand_bytes(4)
            .suffix(".jar")
            .tempfile()?;

        compile_java(testfile, &compiled_file)?;

        let optimized_file = Path::new("s001421950_proguard.jar");

        optimize_w_proguard(&compiled_file, optimized_file)?;

        let mut file = File::open(optimized_file)?;
        let mut contents: Vec<u8> = vec![];
        file.read_to_end(&mut contents)?;

        assert!(!contents.is_empty());
        remove_file(optimized_file)?;

        assert!(!optimized_file.exists());

        Ok(())
    }

    #[test]
    fn test_decompile_w_procyon() -> Result<()> {
        let testfile = Utf8Path::new("../tests/s001421950.java");
        // let compiled_file = Utf8Path::new("../tests/s001421950.jar");
        let mut tmpbld = tempfile::Builder::new();
        let compiled_file = tmpbld
            .prefix("s001421950_")
            .rand_bytes(4)
            .suffix(".jar")
            .tempfile()?;

        compile_java(testfile, &compiled_file)?;

        let decompiled_file = Path::new("s001421950_decompiled_test1.java");

        decompile_w_procyon(compiled_file, decompiled_file)?;

        let mut file = File::open(decompiled_file)?;
        let mut contents = String::new();
        file.read_to_string(&mut contents)?;
        assert!(!contents.is_empty());

        remove_file(decompiled_file)?;
        assert!(!decompiled_file.exists());

        Ok(())
    }

    #[test]
    fn test_compile_decompile_compile_procyon() -> Result<()> {
        let testfile = Utf8Path::new("../tests/s001421950.java");
        // let compiled_file = Utf8Path::new("../tests/s001421950.jar");
        let mut tmpbld = tempfile::Builder::new();
        let compiled_file = tmpbld
            .prefix("s001421950_")
            .rand_bytes(4)
            .suffix(".jar")
            .tempfile()?;

        let decompiled_file = Path::new("s001421950_decompiled_test2.java");

        compile_java(testfile, &compiled_file)?;
        decompile_w_procyon(&compiled_file, decompiled_file)?;

        let new_path = Path::new("s001421950_recompiled.jar");
        compile_java(decompiled_file, new_path)?;
        assert!(&new_path.exists());

        remove_file(decompiled_file)?;
        assert!(!decompiled_file.exists());

        remove_file(new_path)?;
        assert!(!new_path.exists());

        Ok(())
    }

    #[test]
    fn test_compile_optimize_decompile_compile_procyon() -> Result<()> {
        let testfile = Utf8Path::new("../tests/s001421950.java");
        // let compiled_file = Utf8Path::new("../tests/s001421950.jar");
        let mut tmpbld = tempfile::Builder::new();
        let compiled_file = tmpbld
            .prefix("s001421950_")
            .rand_bytes(4)
            .suffix(".jar")
            .tempfile()?;

        compile_java(testfile, &compiled_file)?;

        let optimized_file = Path::new("s001421950_proguard2.jar");
        optimize_w_proguard(&compiled_file, optimized_file)?;

        let decompiled_file = Path::new("s001421950_decompiled_test3.java");

        decompile_w_procyon(optimized_file, decompiled_file)?;

        remove_file(optimized_file)?;
        assert!(!optimized_file.exists());

        let compiled_file2 = tmpbld
            .prefix("s001421950_")
            .rand_bytes(4)
            .suffix(".jar")
            .tempfile()?;

        compile_java(decompiled_file, &compiled_file2)?;

        let mut file = File::open(compiled_file2)?;
        let mut contents: Vec<u8> = vec![];
        file.read_to_end(&mut contents)?;
        assert!(!contents.is_empty());

        remove_file(decompiled_file)?;
        assert!(!decompiled_file.exists());

        Ok(())
    }
}
