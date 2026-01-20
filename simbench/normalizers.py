# import tree_sitter as ts
# import tree_sitter_java as java
from simbench.build import Normalizer, Source
from pathlib import Path
import subprocess
import shutil
from loguru import logger


# def treesitter_normalizer():
#     ignore = ["comments", "imports"]
#
#     cursor = root.walk()
#     godeeper = True
#     while True:
#         assert cursor.node is not None
#         if godeeper and cursor.node.type not in ignore:
#             if not cursor.goto_first_child():
#                 print(cursor.text)
#                 godeeper = False
#         elif cursor.goto_next_sibling():
#             godeeper = True
#         elif cursor.goto_parent():
#             godeeper = False
#         else:
#             break
#
#


class GoogleFormatter(Normalizer):
    @property
    def name(self):
        return "google_java_formatted"

    def process(self, src: Source) -> Source:
        toolspath = Path("processing_tools") / "google_java_formatter"
        formatter_path = toolspath / "google-java-format-1.33.0-all-deps.jar"
        processed_file = self.new_path(src)
        processed_file.parent.mkdir(parents=True, exist_ok=True)
        processed_file.touch()

        logger.debug(f"Formatting {src.name} using the Google Java Formatter")
        with open(processed_file, "ab") as outfile:
            processed_bytes = subprocess.run(
                ["java", "-jar", formatter_path, src.path],
                capture_output=True,
            )
            assert processed_bytes.returncode == 0, f"{processed_bytes.stderr}"
            assert len(processed_bytes.stdout) > 0, (
                f"No data was loaded from {src.path}"
            )
            outfile.write(processed_bytes.stdout)

        return Source(processed_file)


class CompileDecompileNormalizer(Normalizer):
    @property
    def name(self):
        return "decompiled"

    def process(self, src: Source) -> Source:
        toolspath = Path("processing_tools") / "compiledecompile"
        tmp_dir = src.path.parent / Path(f"{src.name}-tmp")

        tmp_dir.mkdir(parents=True, exist_ok=True)
        tmp_file = tmp_dir / "Main.java"

        tmp_file.write_bytes(src.get_bytes())
        logger.debug(f"Compiling {src.name}")
        compiled_bytes = subprocess.run(
            ["javac", "-d", tmp_dir, tmp_file], capture_output=True
        )
        assert compiled_bytes.returncode == 0, f"{compiled_bytes.stderr}"
        decompiler_path = toolspath / "procyon-decompiler-0.6.0.jar"

        processed_file = self.new_path(src)
        processed_file.parent.mkdir(parents=True, exist_ok=True)
        processed_file.touch()

        logger.debug(f"Decompiling {src.name}")
        with open(processed_file, "ab") as outfile:
            for filename in tmp_dir.iterdir():
                if filename == processed_file or not filename.name.endswith(".class"):
                    # don't want to copy the output into the output
                    continue
                logger.debug(f"Found class {filename.name}")
                processed_bytes = subprocess.run(
                    ["java", "-jar", decompiler_path, filename],
                    capture_output=True,
                )

                assert processed_bytes.returncode == 0, f"{processed_bytes.stderr}"
                outfile.write(processed_bytes.stdout)

        shutil.rmtree(tmp_dir)
        assert not tmp_file.exists()

        return Source(processed_file)
