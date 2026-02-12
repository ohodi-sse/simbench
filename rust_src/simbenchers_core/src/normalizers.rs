use camino::{Utf8Path, Utf8PathBuf};
use color_eyre::eyre::eyre;
use color_eyre::{Result, eyre::OptionExt};

use duct::cmd;
use indicatif::{ParallelProgressIterator, ProgressIterator};
use rayon::iter::IntoParallelRefIterator;
use rayon::prelude::*;
use std::env;
use std::fs::File;
use std::io::Write;
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
    assert!(
        get_file_extension(filepath)? == "java",
        "Can only compile java file, found {}",
        filepath
    );
    let compiled_path = Utf8Path::from_path(compiled_path.as_ref()).ok_or(eyre!(
        "Failed to create Utf8Path from {:?}",
        compiled_path.as_ref()
    ))?;
    assert!(
        get_file_extension(compiled_path)? == "jar",
        "Extension {:?} of {:?} should be jar",
        get_file_extension(compiled_path)?,
        compiled_path
    );
    assert!(filepath.exists(), "Failed to locate file {}", filepath);

    if compiled_path.exists() {
        println!("The compiled file {:?} already exists", compiled_path);
        return Ok(());
    };

    // Create temporary directory
    let tmp_dir = tempdir_in(get_parent_dir(filepath)?.as_std_path())?;
    let tmp_file = tmp_dir.path().join("Main.java");

    // Copy file into new directory
    cmd!("cp", filepath, &tmp_file).run()?;
    assert!(&tmp_file.exists(), "File was not copied properly");
    // Compile into the temporary directory
    cmd!("javac", &tmp_file).dir(tmp_dir.path()).run()?;
    assert!(
        tmp_dir.path().join("Main.class").exists(),
        "File was not compiled properly"
    );
    let current_path = env::current_dir()?;

    // Collect as jar file
    cmd!("jar", "cf", current_path.join(compiled_path), ".")
        .dir(tmp_dir.path())
        .run()?;
    assert!(&compiled_path.exists(), "Jar was not created");

    let check = cmd!("jar", "tf", compiled_path)
        .stdout_capture()
        .run()?
        .stdout;

    assert!(String::from_utf8(check.clone())?.contains("Main.class"));

    tmp_dir.close()?;

    Ok(())
}

fn optimize_w_proguard(filepath: impl AsRef<Path>, processed_path: impl AsRef<Path>) -> Result<()> {
    let filepath = Utf8Path::from_path(filepath.as_ref()).ok_or(eyre!(
        "Failed to create Utf8Path from {:?}",
        filepath.as_ref()
    ))?;

    assert!(filepath.try_exists().is_ok());

    let processed_path = Utf8Path::from_path(processed_path.as_ref()).ok_or(eyre!(
        "Failed to create Utf8Path from {:?}",
        processed_path.as_ref()
    ))?;

    let proguard_path = env::current_dir()?.join("processing_tools/proguard-7.8.2/");
    let binary_path = proguard_path.join("bin/proguard.sh");
    assert!(binary_path.try_exists().is_ok());

    let config_file = proguard_path.join("optimizer.pro");
    assert!(config_file.try_exists().is_ok());

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

    assert!(
        filepath
            .extension()
            .ok_or_eyre("Failed to extract extension")?
            == "jar"
    );
    assert!(filepath.exists(), "Failed to find file {}", filepath);
    assert!(
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

    assert!(
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

// fn google_format(
//     filepath: impl AsRef<Path>,
//     decompiled_path: impl AsRef<Path>,
// ) -> Result<()> {
//     let filepath = Utf8Path::from_path(filepath.as_ref())
//         .ok_or_eyre("Failed to convert filepath to Utf8Path")?;
//
//     assert!(
//         filepath
//             .extension()
//             .ok_or_eyre("Failed to extract extension")?
//             == "jar"
//     );
//     assert!(filepath.exists(), "Failed to find file {}", filepath);
//     assert!(
//         decompiled_path
//             .as_ref()
//             .extension()
//             .ok_or_eyre("Failed to extract extension")?
//             == "java"
//     );
//     let full_compiled_path = env::current_dir()?.join(filepath);
//     let full_decompiled_path = env::current_dir()?.join(&decompiled_path);
//
//         toolspath = TOOLSPATH / "google_java_formatter"
//         formatter_path = toolspath / "google-java-format-1.33.0-all-deps.jar"
//         processed_file = self.new_path(src)
//         processed_file.parent.mkdir(parents=True, exist_ok=True)
//         processed_file.touch()
//
//         logger.debug(f"Formatting {src.name} using the Google Java Formatter")
//         with open(processed_file, "ab") as outfile:
//             processed_bytes = subprocess.run(
//                 ["java", "-jar", formatter_path, src.path],
//                 capture_output=True,
//             )
//             assert processed_bytes.returncode == 0, f"{processed_bytes.stderr}"
//             assert len(processed_bytes.stdout) > 0, (
//                 f"No data was loaded from {src.path}"
//             )
//             outfile.write(processed_bytes.stdout)
//
//         return Source(processed_file)
// }

pub fn batch_compile(source_files: Vec<String>, target_files: Vec<String>) -> Result<()> {
    assert_eq!(source_files.len(), target_files.len());

    source_files
        .iter()
        .zip(target_files.iter())
        .progress()
        .try_for_each(|(src, tgt)| compile_java(Utf8PathBuf::from(src), Utf8PathBuf::from(tgt)))
}
pub fn batch_optimize(source_files: Vec<String>, target_files: Vec<String>) -> Result<()> {
    assert_eq!(source_files.len(), target_files.len());

    source_files
        .par_iter()
        .zip(target_files.par_iter())
        .progress()
        .try_for_each(|(src, tgt)| {
            optimize_w_proguard(Utf8PathBuf::from(src), Utf8PathBuf::from(tgt))
        })
}
pub fn batch_decompile(source_files: Vec<String>, target_files: Vec<String>) -> Result<()> {
    assert_eq!(source_files.len(), target_files.len());

    source_files
        .iter()
        .zip(target_files.iter())
        .progress()
        .try_for_each(|(src, tgt)| {
            decompile_w_procyon(Utf8PathBuf::from(src), Utf8PathBuf::from(tgt))
        })
}

#[cfg(test)]
mod tests {
    use super::*;
    use std::{fs::remove_file, io::Read};

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

        decompile_w_procyon(compiled_file, &decompiled_file)?;

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
