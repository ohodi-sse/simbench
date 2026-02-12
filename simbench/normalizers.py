import tree_sitter as ts
import tree_sitter_java as tsjava

from simbench.build import Normalizer, Source
from pathlib import Path
import subprocess
import shutil
from loguru import logger
from rust_src import rust_batch_decompile, rust_batch_compile, rust_batch_optimize


TOOLSPATH = Path("processing_tools")


class GoogleFormatter(Normalizer):
    @property
    def name(self):
        return "google_java_formatted"

    def process(self, src: Source) -> Source:
        toolspath = TOOLSPATH / "google_java_formatter"
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


class CompileNormalizer(Normalizer):
    @property
    def name(self):
        return "compiled"

    @property
    def required_output_file_extension(self) -> str | None:
        return ".jar"

    def dependencies(self, source_files: list[Source]) -> list[Path]:
        return [src.path for src in source_files]

    def process(self, source_files: list[Path], target_files: list[Path]):
        assert len(source_files) == len(target_files)

        source_strings = [str(src) for src in source_files]
        target_strings = [str(tgt) for tgt in target_files]

        logger.debug("Compiling source files")
        rust_batch_compile(source_strings, target_strings)


class DecompileNormalizer(Normalizer):
    @property
    def name(self):
        return "decompiled"

    @property
    def required_output_file_extension(self) -> str | None:
        return ".java"

    def dependencies(self, source_files: list[Source]) -> list[Path]:
        compiler_normalizer = CompileNormalizer()
        source_dependencies = compiler_normalizer.get_normalized_sources(source_files)
        return [src.path for src in source_dependencies.sources.values()]

    def process(self, source_files, target_files):
        assert len(source_files) == len(target_files)

        source_strings = [str(src) for src in source_files]
        target_strings = [str(tgt) for tgt in target_files]
        logger.debug("Decompiling compiled files")
        rust_batch_decompile(source_strings, target_strings)


class OptimizingNormalizer(Normalizer):
    @property
    def name(self):
        return "optimized"

    @property
    def required_output_file_extension(self) -> str | None:
        return ".jar"

    def dependencies(self, source_files: list[Source]) -> list[Path]:
        compiler_normalizer = CompileNormalizer()
        source_dependencies = compiler_normalizer.get_normalized_sources(source_files)
        return [src.path for src in source_dependencies.sources.values()]

    def process(self, source_files, target_files):
        assert len(source_files) == len(target_files)

        source_strings = [str(src) for src in source_files]
        target_strings = [str(tgt) for tgt in target_files]
        logger.debug("Optimizing decompiled files")
        rust_batch_optimize(source_strings, target_strings)


class OptimizedDecompiledNormalizer(Normalizer):
    @property
    def name(self):
        return "optimized_decompiled"

    @property
    def required_output_file_extension(self) -> str | None:
        return ".java"

    def dependencies(self, source_files: list[Source]) -> list[Path]:
        compiler_normalizer = OptimizingNormalizer()
        source_dependencies = compiler_normalizer.get_normalized_sources(source_files)
        return [src.path for src in source_dependencies.sources.values()]

    def process(self, source_files, target_files):
        assert len(source_files) == len(target_files)

        source_strings = [str(src) for src in source_files]
        target_strings = [str(tgt) for tgt in target_files]
        logger.debug("Decompiling optimized files")
        rust_batch_decompile(source_strings, target_strings)


class DecompileWOImports(Normalizer):
    @property
    def name(self):
        return "decompiled_wo_imports"

    @property
    def required_output_file_extension(self) -> str | None:
        return ".java"

    def dependencies(self, source_files: list[Source]) -> list[Path]:
        dep = OptimizedDecompiledNormalizer()
        source_dependencies = dep.get_normalized_sources(source_files)
        return [src.path for src in source_dependencies.sources.values()]

    def process(self, source_files, target_files):
        for s, t in zip(source_files, target_files):
            bs = Source(s).get_bytes()
            new_bytes = bytearray(bs)
            parser = ts.Parser(ts.Language(tsjava.language()))
            tree = parser.parse(bs)

            query = ts.Query(
                ts.Language(tsjava.language()),
                "[(import_declaration) (line_comment)] @item",
            )
            queryCursor = ts.QueryCursor(query)
            captures = queryCursor.captures(tree.root_node)
            if captures:
                ranges = [(node.start_byte, node.end_byte) for node in captures["item"]]

                for start, end in sorted(ranges, reverse=True):
                    del new_bytes[start:end]

            new_bytes = new_bytes.strip()

            t.write_bytes(bytes(new_bytes))
            assert t.exists()
