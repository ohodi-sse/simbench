import subprocess
import shutil
from collections import Counter
from loguru import logger
from hashlib import sha512
import tree_sitter as ts
import tree_sitter_java as tsjava
from simbench.build import Normalizer, Source, DependentNormalizer
from pathlib import Path
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
        logger.info("Compiling source files")
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
        logger.info("Formatting unprocessed files")
        rust_batch_format(sources, targets)


def remove_final(sources):
    for src_path in sources:
        src = Source(Path(src_path))
        bs = src.get_bytes()
        new_bytes = bytearray(bs)
        parser = ts.Parser(ts.Language(tsjava.language()))
        tree = parser.parse(bs)

        query = ts.Query(
            ts.Language(tsjava.language()),
            "[(line_comment)] @item",
        )
        queryCursor = ts.QueryCursor(query)
        captures = queryCursor.captures(tree.root_node)
        if captures:
            for node in captures["item"]:
                ranges = []
                text = bs[node.start_byte : node.end_byte]
                if text == b"final":
                    ranges.append([(node.start_byte, node.end_byte)])

                for start, end in sorted(ranges, reverse=True):
                    del new_bytes[start:end]

        new_bytes = new_bytes.strip()
        src.path.write_bytes(bytes(new_bytes))
        assert src.path.exists()


def remove_comments(sources):
    for src_path in sources:
        src = Source(Path(src_path))
        bs = src.get_bytes()
        new_bytes = bytearray(bs)
        parser = ts.Parser(ts.Language(tsjava.language()))
        tree = parser.parse(bs)

        query = ts.Query(
            ts.Language(tsjava.language()),
            "[(line_comment)] @item",
        )
        queryCursor = ts.QueryCursor(query)
        captures = queryCursor.captures(tree.root_node)
        if captures:
            ranges = [(node.start_byte, node.end_byte) for node in captures["item"]]

            for start, end in sorted(ranges, reverse=True):
                del new_bytes[start:end]

        new_bytes = new_bytes.strip()
        src.path.write_bytes(bytes(new_bytes))
        assert src.path.exists()


def rewrite_instanceof(sources):
    for src_path in sources:
        src = Source(Path(src_path))
        bs = src.get_bytes()
        new_bytes = bytearray(bs)
        parser = ts.Parser(ts.Language(tsjava.language()))
        tree = parser.parse(bs)

        query = ts.Query(
            ts.Language(tsjava.language()),
            "(instanceof_expression name: (identifier) @item)",
        )
        queryCursor = ts.QueryCursor(query)
        captures = queryCursor.captures(tree.root_node)
        if captures:
            ranges = [(node.start_byte, node.end_byte) for node in captures["item"]]
            for start, end in sorted(ranges, reverse=True):
                logger.debug(f"Found: {new_bytes[start:end]}")
                del new_bytes[start:end]

        new_bytes = new_bytes.strip()
        src.path.write_bytes(bytes(new_bytes))
        assert src.path.exists()


def move_and_sort_imports(sources):
    for src_path in sources:
        src = Source(Path(src_path))
        bs = src.get_bytes()
        parser = ts.Parser(ts.Language(tsjava.language()))
        tree = parser.parse(bs)
        root = tree.root_node

        import_nodes = []
        package_node = None

        # Collect top-level import + package nodes
        for child in root.children:
            if child.type == "import_declaration":
                import_nodes.append(child)
            elif child.type == "package_declaration":
                package_node = child

        if not import_nodes:
            return bs  # nothing to do

        # Extract import byte slices
        imports = [bs[node.start_byte : node.end_byte] for node in import_nodes]

        # Optional: deduplicate while preserving order
        seen = set()
        deduped_imports = []
        for imp in imports:
            if imp not in seen:
                seen.add(imp)
                deduped_imports.append(imp)
        imports = deduped_imports

        # Build import block
        import_block = b"\n".join(imports) + b"\n\n"

        # Remove imports from original bytes (reverse order!)
        new_bs = bs
        for node in sorted(import_nodes, key=lambda n: n.start_byte, reverse=True):
            new_bs = new_bs[: node.start_byte] + new_bs[node.end_byte :]

        # Trim leading whitespace (optional but usually desired)
        new_bs = new_bs.lstrip()

        # Insert import block
        if package_node:
            pkg_end = package_node.end_byte

            new_bs = new_bs[:pkg_end] + b"\n\n" + import_block + new_bs[pkg_end:]
        else:
            new_bs = import_block + new_bs

        src.path.write_bytes(new_bs)
        assert src.path.exists()


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
        logger.info("Decompiling compiled files")
        rust_batch_decompile(sources, targets)
        remove_comments(targets)


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
        logger.info("Optimizing decompiled files")
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
        logger.info("Decompiling optimized files")
        rust_batch_decompile(sources, targets)
        remove_comments(targets)


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


class HashedProblemLabel(DependentNormalizer):
    def __init__(self):
        self.depends_on_normalizer = IDNormalizer()

    @property
    def name(self):
        return "hashed_src_label"

    @property
    def required_output_file_extension(self) -> str | None:
        return ".txt"

    def __call__(self, sources, targets):
        for s, t in zip(sources, targets):
            src = Source(Path(s))
            hashed_label = sha512(src.label.encode("utf-8")).digest() * 5

            t = Path(t)
            t.write_text(hashed_label.hex())
            assert t.exists()


class PartitionedProblemClasses(DependentNormalizer):
    number_of_partitions: int

    def __init__(self, num_partitions):
        self.depends_on_normalizer = IDNormalizer()
        self.number_of_partitions = num_partitions

    @property
    def name(self):
        return f"{self.number_of_partitions}_partitioned"

    @property
    def required_output_file_extension(self) -> str | None:
        return ".txt"

    def __call__(self, sources, targets):
        # spacing = np.linspace(0, len(sources), self.number_of_partitions, dtype=int)
        # num_classes = int(math.sqrt(len(sources)))
        # total_partitions = num_classes * self.number_of_partitions
        class_counter = []
        for s, t in list(zip(sources, targets)):
            src = Source(Path(s))
            class_counter.append(src.label)
            val = Counter(class_counter)[src.label] % self.number_of_partitions
            partition_specific_str = src.label + f"partition_{val}"
            hashed_label = sha512(partition_specific_str.encode("utf-8")).digest() * 5

            t = Path(t)
            t.write_text(hashed_label.hex())
            assert t.exists()


class TokenNormalizer(DependentNormalizer):
    def __init__(self):
        self.depends_on_normalizer = DecompileNormalizer()

    @property
    def name(self):
        return "token_format"

    @property
    def required_output_file_extension(self) -> str | None:
        return ".java"

    def write_tokens(self, node, source, target):
        # If no children → leaf node → token
        if node.child_count == 0:
            token = source[node.start_byte : node.end_byte]
            target.write(f"{token.decode('utf-8')}\n")
            return

        for child in node.children:
            self.write_tokens(child, source, target)

    def __call__(self, sources: list[str], targets: list[str]):
        logger.info("Reformatting tokens")
        for s, t in zip(sources, targets):
            src = Source(Path(s))
            bs = src.get_bytes()
            parser = ts.Parser(ts.Language(tsjava.language()))
            tree = parser.parse(bs)
            cursor = tree.walk()

            with open(Path(t), "w") as tgt:
                self.write_tokens(cursor.node, bs, tgt)


class IdentifierNoSemantics(DependentNormalizer):
    def __init__(self):
        self.depends_on_normalizer = IDNormalizer()

    @property
    def name(self):
        return "identifiers_no_semantics"

    @property
    def required_output_file_extension(self) -> str | None:
        return ".java"

    def __call__(self, sources: list[str], targets: list[str]):
        logger.info("Formatting decompiled files")
        for s, t in zip(sources, targets):
            grep = subprocess.run(
                ["grep", "-oE", "[a-zA-Z]+", s], capture_output=True, text=True
            )

            words = sorted(set(grep.stdout.split()))

            joined = " ".join(words)
            with open(t, "w") as tgt_file:
                tgt_file.write(
                    f"// {joined}"
                    + "\npublic class Main { public static void main(String[] args) {} }"
                )


class DecompileFixedImports(DependentNormalizer):
    def __init__(self):
        self.depends_on_normalizer = DecompileNormalizer()

    @property
    def name(self):
        return "decompiled_fixed_imports"

    @property
    def required_output_file_extension(self) -> str | None:
        return ".java"

    def __call__(self, sources: list[str], targets: list[str]):
        logger.info("Cleaning decompiled files")
        for s, t in zip(sources, targets):
            shutil.copy(s, t)

        remove_final(targets)
        remove_comments(targets)
        for t in targets:
            logger.debug(t)


class DecompiledFormatted(DependentNormalizer):
    def __init__(self):
        self.depends_on_normalizer = DecompileNormalizer()

    @property
    def name(self):
        return "decompiled_formatted"

    @property
    def required_output_file_extension(self) -> str | None:
        return ".java"

    def __call__(self, sources: list[str], targets: list[str]):
        logger.info("Cleaning decompiled files")
        rust_batch_format(sources, targets)
        remove_final(targets)
        remove_comments(targets)
