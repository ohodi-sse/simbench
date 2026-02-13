from simbench.build import NamedCallable, Source
from abc import ABC, abstractmethod
import torch
from transformers import (
    RobertaTokenizer,
    RobertaModel,
    AutoModel,
    AutoTokenizer,
    PreTrainedTokenizer,
    PreTrainedModel,
)


class AITool(ABC, NamedCallable):
    def __init__(self):
        self._tokenizer = None
        self._model = None

    @property
    def model(self):
        if self._model is None:
            self._model = self._load_model()
        return self._model

    @property
    def tokenizer(self):
        if self._tokenizer is None:
            self._tokenizer = self._load_tokenizer()
        return self._tokenizer

    @property
    @abstractmethod
    def _load_model(self) -> PreTrainedModel: ...

    @property
    @abstractmethod
    def _load_tokenizer(self) -> PreTrainedTokenizer: ...

    def normalize(self, embedding):
        return embedding / embedding.norm(p=2)

    def embed_code(self, code: str):
        inputs = self.tokenizer(
            code, return_tensors="pt", truncation=True, padding=True
        )
        with torch.no_grad():
            outputs = self.model(**inputs)

        # Using mean as it should be better at finding semantic similarity
        embedding = outputs.last_hidden_state.mean(dim=1)

        return embedding.squeeze(0)  # shape: (768,)

    def cosine_distance(self, e1, e2):
        import torch.nn.functional as F

        return 1 - F.cosine_similarity(e1.unsqueeze(0), e2.unsqueeze(0)).item()

    @property
    @abstractmethod
    def name(self) -> str: ...

    def __call__(self, file1, file2):
        return self.cosine_distance(file1, file2)

    def preprocess(self, src: Source):
        return self.normalize(self.embed_code(src.get_bytes().decode("utf-8")))


class CodeBERT(AITool):
    @property
    def name(self):
        return "CodeBERT"

    def _load_model(self):
        model = RobertaModel.from_pretrained("microsoft/codebert-base")
        model.eval()
        return model

    def _load_tokenizer(self):
        return RobertaTokenizer.from_pretrained("microsoft/codebert-base")


class GraphCodeBERT(AITool):
    @property
    def name(self):
        return "GraphCodeBERT"

    def _load_model(self):
        model = AutoModel.from_pretrained("microsoft/graphcodebert-base")
        model.eval()
        return model

    def _load_tokenizer(self):
        return AutoTokenizer.from_pretrained("microsoft/graphcodebert-base")
