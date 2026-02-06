from simbench.build import NamedCallable, Source
import torch
from transformers import (
    RobertaTokenizer,
    RobertaModel,
    AutoModel,
    AutoTokenizer,
)

device = torch.device("cuda" if torch.cuda.is_available() else "cpu")


class CodeBERT(NamedCallable):
    tokenizer = RobertaTokenizer.from_pretrained("microsoft/codebert-base")
    model = RobertaModel.from_pretrained("microsoft/codebert-base")
    model.eval()

    def normalize(self, embedding):
        return embedding / embedding.norm(p=2)

    def embed_code(self, code: str):
        inputs = self.tokenizer(
            code, return_tensors="pt", truncation=True, padding=True
        )
        with torch.no_grad():
            outputs = self.model(**inputs)

        # embedding = outputs.last_hidden_state[:, 0, :]
        # Using mean as it should be better at finding semantic similarity
        embedding = outputs.last_hidden_state.mean(dim=1)

        return embedding.squeeze(0)  # shape: (768,)

    def cosine_distance(self, e1, e2):
        import torch.nn.functional as F

        return 1 - F.cosine_similarity(e1.unsqueeze(0), e2.unsqueeze(0)).item()

    @property
    def name(self):
        return "CodeBERT"

    def __call__(self, file1, file2):
        return self.cosine_distance(file1, file2)

    def preprocess(self, src: Source):
        return self.normalize(self.embed_code(src.get_bytes().decode("utf-8")))


class GraphCodeBERT(NamedCallable):
    tokenizer = AutoTokenizer.from_pretrained("microsoft/graphcodebert-base")
    model = AutoModel.from_pretrained("microsoft/graphcodebert-base")
    model.eval()

    def normalize(self, embedding):
        return embedding / embedding.norm(p=2)

    def embed_code(self, code: str):
        inputs = self.tokenizer(
            code, return_tensors="pt", truncation=True, padding=True
        )
        with torch.no_grad():
            outputs = self.model(**inputs)

        # embedding = outputs.last_hidden_state[:, 0, :]
        # Using mean as it should be better at finding semantic similarity
        embedding = outputs.last_hidden_state.mean(dim=1)

        return embedding.squeeze(0)  # shape: (768,)

    def cosine_distance(self, e1, e2):
        import torch.nn.functional as F

        return 1 - F.cosine_similarity(e1.unsqueeze(0), e2.unsqueeze(0)).item()

    @property
    def name(self):
        return "GraphCodeBERT"

    def __call__(self, file1, file2):
        return self.cosine_distance(file1, file2)

    def preprocess(self, src: Source):
        return self.normalize(self.embed_code(src.get_bytes().decode("utf-8")))
