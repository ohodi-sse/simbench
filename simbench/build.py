
from dataclasses import dataclass

from pathlib import Path
import json
from typing import Self, Callable
from abc import ABC, abstractmethod
from contextlib import contextmanager

from loguru import logger 

@dataclass
class Builder:
    log : logger

    @contextmanager
    def profile(self, message):
        self.log.info(f"Started {message}")
        yield
        self.log.info(f"Done with {message}")

class Pullable[A](ABC):
    def pull(self, bld) -> A:
        ...

class Store[A](ABC):

    @abstractmethod
    def load(self, bld) -> A | None:
        ...
    
    @abstractmethod
    def store(self, item: A, bld: Builder = None):
        ...


@dataclass
class JsonStore[A](Store[A], Pullable[A]):
    file: Path

    def load(self, bld):
        if self.file.exists():
            return json.loads(self.file.read_text())
    
    def pull(self, bld):
        return json.loads(self.file.read_text())

    def store(self, item, bld):
        return self.file.write_text(json.dumps(item))

@dataclass
class ByteStore[bytes](Store[bytes], Pullable[bytes]):
    file: Path

    def load(self, bld):
        if self.file.exists():
            return self.file.read_bytes()
    
    def pull(self, bld):
        return self.file.read_bytes()

    def store(self, item, bld):
        return self.file.write_bytes(item)


@dataclass
class Node[A](Pullable[A]):
    action: Callable
    store : Store[A]
    dependencies: dict[str, Pullable]

    def pull(self, bld) -> A:
        if (a := self.store.load(bld)) is not None:
            return a

        outputs = {};
        for k, dep in self.dependencies.items():
            outputs[k] = dep.pull(bld)

        a = self.action(bld=bld, **outputs)
        self.store.store(a, bld=bld)

        return a
   
    @classmethod
    def from_action(cls, fun):

        def inner(store, **kwargs):
            return Node(fun, store, dependencies=kwargs)

        return inner



@Node.from_action
def the_answer(bld: Builder) -> int:
    with bld.profile("compute the answer"):
        return 42

answer = the_answer(JsonStore(Path("the_answer.json")))

bld = Builder(logger)

bs = ByteStore(Path("flake.nix"))

@Node.from_action
def lines(bld: Builder, file: bytes) -> int:
    with bld.profile("reading the lines of the file"):
        return len(file.splitlines())

lines = Node.from_action(lines)

node = lines(JsonStore(Path("lines.json")), file=bs)

print(node.pull(bld))






