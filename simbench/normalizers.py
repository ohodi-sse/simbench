import tree_sitter as ts
import tree_sitter_java as tsjava

from simbench.build import Normalizer, Source, DependentNormalizer
from pathlib import Path
from loguru import logger
from rust_src import (
    rust_batch_decompile,
    rust_batch_compile,
    rust_batch_optimize,
    rust_batch_format,
)


class IDNormalizer(Normalizer):
    @property
    def name(self) -> str:
        return "unprocessed"

    @property
    def required_output_file_extension(self) -> str | None:
        return ".java"

    def dependencies(self, sources: list[Source]) -> list[Source]:
        return sources

    def __call__(self, sources: list[str], targets: list[str]):
        return


class CompileNormalizer(DependentNormalizer):
    def __init__(self):
        self.depends_on_normalizer = IDNormalizer()

    @property
    def name(self):
        return "compiled"

    @property
    def required_output_file_extension(self) -> str | None:
        return ".jar"

    def __call__(self, sources: list[str], targets: list[str]):
        logger.debug("Compiling source files")
        rust_batch_compile(sources, targets)


class GoogleFormatter(DependentNormalizer):
    def __init__(self):
        self.depends_on_normalizer = IDNormalizer()

    @property
    def name(self):
        return "google_java_formatted"

    @property
    def required_output_file_extension(self) -> str | None:
        return ".java"

    def __call__(self, sources: list[str], targets: list[str]):
        logger.debug("Formatting unprocessed files")
        rust_batch_format(sources, targets)


class DecompileNormalizer(DependentNormalizer):
    def __init__(self):
        self.depends_on_normalizer = CompileNormalizer()

    @property
    def name(self):
        return "decompiled"

    @property
    def required_output_file_extension(self) -> str | None:
        return ".java"

    def __call__(self, sources: list[str], targets: list[str]):
        logger.debug("Decompiling compiled files")
        rust_batch_decompile(sources, targets)


class OptimizingNormalizer(DependentNormalizer):
    def __init__(self):
        self.depends_on_normalizer = CompileNormalizer()

    @property
    def name(self):
        return "optimized"

    @property
    def required_output_file_extension(self) -> str | None:
        return ".jar"

    def __call__(self, sources: list[str], targets: list[str]):
        logger.debug("Optimizing decompiled files")
        rust_batch_optimize(sources, targets)


class OptimizedDecompiledNormalizer(DependentNormalizer):
    def __init__(self):
        self.depends_on_normalizer = OptimizingNormalizer()

    @property
    def name(self):
        return "optimized_decompiled"

    @property
    def required_output_file_extension(self) -> str | None:
        return ".java"

    def __call__(self, sources: list[str], targets: list[str]):
        logger.debug("Decompiling optimized files")
        rust_batch_decompile(sources, targets)


class DecompileWOImports(DependentNormalizer):
    def __init__(self):
        self.depends_on_normalizer = OptimizedDecompiledNormalizer()

    @property
    def name(self):
        return "decompiled_wo_imports"

    @property
    def required_output_file_extension(self) -> str | None:
        return ".java"

    def __call__(self, sources, targets):
        for s, t in zip(sources, targets):
            bs = Source(Path(s)).get_bytes()
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
            t = Path(t)
            t.write_bytes(bytes(new_bytes))
            assert t.exists()
