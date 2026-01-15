from time import time

# import tree_sitter as ts
# import tree_sitter_java as java
from simbench.build import Normalizer, Source, Builder
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
class CompileDecompileNormalizer(Normalizer):
    @property
    def name(self):
        return "decompiled"

    def process(self, src: Source) -> Source:
        toolspath = Path("compiledecompile")
        tmp_dir = src.path.parent / Path(f"{src.name}-tmp")

        tmp_dir.mkdir(parents=True, exist_ok=True)
        tmp_file = tmp_dir / "Main.java"
        # compiler_path = toolspath / "InMemoryCompiler" / "IMCompiler"
        tmp_file.write_bytes(src.get_bytes())
        logger.debug(f"Compiling {src.name}")
        compiled_bytes = subprocess.run(
            ["javac", "-d", tmp_dir, tmp_file], capture_output=True
        )
        assert compiled_bytes.returncode == 0, f"{compiled_bytes.stderr}"
        decompiler_path = toolspath / "procyon-decompiler-0.6.0.jar"
        compiled_file = tmp_dir / "Main.class"

        logger.debug(f"Decompiling {src.name}")
        processed_bytes = subprocess.run(
            ["java", "-jar", decompiler_path, compiled_file],
            capture_output=True,
        )
        shutil.rmtree(tmp_dir)
        assert not tmp_file.exists()
        assert processed_bytes.returncode == 0, f"{processed_bytes.stderr}"

        new_file = self.new_path(src)
        new_file.parent.mkdir(parents=True, exist_ok=True)
        new_file.write_bytes(processed_bytes.stdout)
        return Source(new_file)
