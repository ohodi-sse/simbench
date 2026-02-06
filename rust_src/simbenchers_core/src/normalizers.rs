use camino::Utf8Path;
use color_eyre::eyre::eyre;
use color_eyre::{Result, eyre::OptionExt};

use duct::cmd;
use std::fs::{self, DirEntry};
use std::fs::{File, remove_file};
use std::io::Read;
use std::path::Path;
use std::path::PathBuf;
use tempfile::tempdir_in;

fn get_parent_dir<'a>(filepath: &'a Utf8Path) -> Result<&'a Utf8Path> {
    filepath
        .parent()
        .ok_or_eyre("Failed to extract parent directory")
}

fn get_file_name<'a>(filepath: &'a Utf8Path) -> Result<&str> {
    filepath
        .file_name()
        .ok_or_eyre("Failed to extract filename")
}

fn get_file_extension<'a>(filepath: &'a Utf8Path) -> Result<&'a str> {
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
        "Can only compile java file"
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
    // Collect as jar file
    cmd!("jar", "cf", compiled_path, ".")
        .dir(tmp_dir.path())
        .run()?;
    assert!(compiled_path.exists(), "Jar was not created");
    let check = cmd!("jar", "tf", compiled_path)
        .stdout_capture()
        .run()?
        .stdout;

    println!("{:?}", String::from_utf8(check.clone()));
    assert!(String::from_utf8(check.clone())?.contains("Main.class"));

    tmp_dir.close()?;

    Ok(())
}

fn optimize_w_proguard(filepath: impl AsRef<Path>) -> Result<impl AsRef<Path>> {
    let filepath = Utf8Path::from_path(filepath.as_ref()).ok_or(eyre!(
        "Failed to create Utf8Path from {:?}",
        filepath.as_ref()
    ))?;

    let proguard_path = Utf8Path::new("../../processing_tools/proguard-7.8.2/");
    let binary_path = proguard_path.join("bin/proguard.sh");
    assert!(binary_path.try_exists().is_ok());

    let config_file = proguard_path.join("optimizer.pro");
    assert!(config_file.try_exists().is_ok());

    let file_prefix = filepath.file_prefix().ok_or_eyre("Failed to get prefix")?;

    let outfile = filepath
        .with_file_name(String::from(file_prefix) + "_proguard")
        .with_extension("jar");
    assert!(filepath.try_exists().is_ok());

    cmd!(
        String::from("./") + binary_path.as_str(),
        format!("@{:?}", config_file),
        "-injars",
        filepath,
        "-outjars",
        &outfile
    )
    .run()?;

    Ok(outfile)
}

fn decompile_w_procyon(
    filepath: impl AsRef<Path>,
    decompiled_path: impl AsRef<Path>,
) -> Result<impl AsRef<Path>> {
    let filepath = Utf8Path::from_path(filepath.as_ref())
        .ok_or_eyre("Failed to convert filepath to Utf8Path")?;

    assert!(
        filepath
            .extension()
            .ok_or_eyre("Failed to extract extension")?
            == "jar"
    );
    assert!(
        decompiled_path
            .as_ref()
            .extension()
            .ok_or_eyre("Failed to extract extension")?
            == "java"
    );

    let output_file = File::create(&decompiled_path)?;

    // Compiling
    cmd!(
        "java",
        "-jar",
        "../../processing_tools/compiledecompile/procyon-decompiler-0.6.0.jar",
        "-jar",
        filepath,
    )
    .stdout_file(output_file)
    .run()?;

    Ok(decompiled_path)
}

#[test]
fn test_compile_java() -> Result<()> {
    let testfile = Utf8Path::new("../tests/s001421950.java");

    let mut tmpbld = tempfile::Builder::new();
    let newfile = tmpbld
        .prefix("s001421950")
        .suffix(".jar")
        .rand_bytes(4)
        .tempfile()?;
    compile_java(testfile, &newfile)?;
    assert!(&newfile.path().exists());

    Ok(())
}
#[test]
fn test_optimize_w_proguard() -> Result<()> {
    let testfile = Utf8Path::new("../tests/s001421950.java");
    // let compiled_file = Utf8Path::new("../tests/s001421950.jar");
    let mut tmpbld = tempfile::Builder::new();
    let compiled_file = tmpbld
        .prefix("s001421950_")
        .rand_bytes(4)
        .suffix(".jar")
        .tempfile()?;

    compile_java(testfile, &compiled_file)?;
    let optimized_file = optimize_w_proguard(&compiled_file)?;
    assert!(optimized_file.as_ref().exists());

    remove_file(optimized_file)?;

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

    let decompiled_file = tmpbld
        .prefix("s001421950_")
        .rand_bytes(4)
        .suffix(".java")
        .tempfile()?;

    compile_java(testfile, &compiled_file)?;

    let output_file = decompile_w_procyon(compiled_file, decompiled_file)?;

    let mut file = File::open(output_file)?;
    let mut contents = String::new();
    file.read_to_string(&mut contents)?;

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

    let decompiled_file = tmpbld
        .prefix("s001421950_")
        .rand_bytes(4)
        .suffix("decompiled.java")
        .tempfile()?;

    compile_java(testfile, &compiled_file)?;
    decompile_w_procyon(compiled_file, &decompiled_file)?;

    let compiled_file2 = tmpbld
        .prefix("s001421950_")
        .rand_bytes(4)
        .suffix(".jar")
        .tempfile()?;

    compile_java(decompiled_file, &compiled_file2)?;

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

    let optimized_file = optimize_w_proguard(&compiled_file)?;
    assert!(optimized_file.as_ref().exists());

    let decompiled_file = tmpbld
        .prefix("s001421950_")
        .rand_bytes(4)
        .suffix("decompiled.java")
        .tempfile()?;

    decompile_w_procyon(optimized_file, &decompiled_file)?;

    let compiled_file2 = tmpbld
        .prefix("s001421950_")
        .rand_bytes(4)
        .suffix(".jar")
        .tempfile()?;

    compile_java(decompiled_file, &compiled_file2)?;

    Ok(())
}
