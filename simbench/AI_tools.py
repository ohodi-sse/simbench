from interactive_predict import InteractivePredictor
import numpy as np
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
from loguru import logger

from code2vec import load_model_dynamically
from config import Config


class AITool(ABC, NamedCallable):
    def __init__(self):
        self._tokenizer = None
        self._model = None
        self._config = None

    @property
    @abstractmethod
    def _load_model(self) -> PreTrainedModel: ...

    @property
    def model(self):
        if self._model is None:
            self._model = self._load_model()
        return self._model

    def normalize(self, embedding):
        import torch.nn.functional as F

        return F.normalize(embedding, p=2, dim=-1, eps=1e-8)

    @abstractmethod
    def embed_code(self, src: Source) -> torch.Tensor: ...

    def cosine_distance(self, e1, e2):
        from torch.nn.functional import cosine_similarity

        # computing the normalized cosine similarity. If embedding has failed this will fail, and return an empty list.
        # This will produce a similarity of 0 in the AIDistanceTable in tables.py
        try:
            cos = cosine_similarity(e1.unsqueeze(0), e2.unsqueeze(0), dim=-1).item()
        except ValueError:
            cos = []

        return cos

    @property
    @abstractmethod
    def name(self) -> str: ...

    def __call__(self, file1, file2):
        return self.cosine_distance(file1, file2)

    @abstractmethod
    def preprocess(self, src: Source): ...


class HuggingFace(AITool):
    @property
    @abstractmethod
    def _load_tokenizer(self) -> PreTrainedTokenizer: ...

    @property
    def tokenizer(self):
        if self._tokenizer is None:
            self._tokenizer = self._load_tokenizer()
        return self._tokenizer

    def embed_code(self, src: Source) -> torch.Tensor:
        code = src.get_bytes().decode("utf-8")
        inputs = self.tokenizer(
            code, return_tensors="pt", truncation=True, padding=True
        )
        with torch.no_grad():
            outputs = self.model(**inputs)

        # Using mean as it should be better at finding semantic similarity
        embedding = outputs.last_hidden_state.mean(dim=1)

        return embedding.squeeze(0)

    def preprocess(self, src: Source):
        return self.normalize(self.embed_code(src))


class CodeBERT(HuggingFace):
    @property
    def name(self):
        return "CodeBERT"

    def _load_model(self):
        model = RobertaModel.from_pretrained("microsoft/codebert-base")
        model.eval()
        return model

    def _load_tokenizer(self):
        return RobertaTokenizer.from_pretrained("microsoft/codebert-base")


class GraphCodeBERT(HuggingFace):
    @property
    def name(self):
        return "GraphCodeBERT"

    def _load_model(self):
        model = AutoModel.from_pretrained("microsoft/graphcodebert-base")
        model.eval()
        return model

    def _load_tokenizer(self):
        return AutoTokenizer.from_pretrained("microsoft/graphcodebert-base")


class Code2Vec(AITool):
    @property
    def name(self):
        return "Code2Vec"

    def _load_config(self):
        conf = Config(
            set_defaults=True,
            load_from_args=False,
            verify=True,
        )

        return conf

    @property
    def config(self):
        if self._config is None:
            self._config = self._load_config()
        return self._config

    def _load_model(self):
        model = load_model_dynamically(self.config)
        predictor = InteractivePredictor(self.config, model)
        return predictor

    def embed_code(self, src: Source) -> torch.Tensor:
        # predict_lines, hash_to_string_dict = self.path_extractor.extract_paths(code)
        predictor = self.model
        try:
            code_vector = predictor.one_time_predict(str(src.path))
        except ValueError:
            logger.warning(f"Failed to embed code for {src.name}")
            code_vector = np.array([])

        code_vector_as_tensor = torch.from_numpy(code_vector)

        return code_vector_as_tensor

    def preprocess(self, src: Source):
        return self.normalize(self.embed_code(src))


# class GraphCode2Vec(AITool):
#     @property
#     def name(self):
#         return "GraphCode2Vec"
#
#     def args(self, gnn, pretrain_path, gp):
#         args = {}
#
#         args["device"] = 0
#         args["sub_token_path"] = "../processing_tools/graphcode2vec/source/tokens/jars"
#         args["emb_file"] = "../processing_tools/graphcode2vec/source/emb100.txt"
#         args["num_layer"] = 5
#         args["lstm_emb_dim"] = 150
#         args["JK"] = sum
#         args["dropout_ratio"] = 0.2
#         args["graph_pooling"] = gp
#         args["gnn_type"] = gnn
#         args["subword_embedding"] = "lstm"
#         args["bidirection"] = True
#         args["repWay"] = "append"
#         args["input_model_file"] = pretrain_path
#
#         return args
#
#     def _load_model(self):
#         args = self.args(
#             gnn="gat",
#             pretrain_path="../processing_tools/graphcode2vec/pretrain_model/context_attention/gat/model_0.pth",
#             gp="attention",
#         )
#         torch.manual_seed(0)
#         np.random.seed(0)
#         device = (
#             torch.device("cuda:" + str(args["device"]))
#             if torch.cuda.is_available()
#             else torch.device("cpu")
#         )
#         if torch.cuda.is_available():
#             torch.cuda.manual_seed_all(0)
#
#         num_class = 5
#
#         # set up model
#         tokenizer_word2vec = TokenIns(
#             word2vec_file=os.path.join(args["sub_token_path"], args["emb_file"]),
#             tokenizer_file=os.path.join(args["sub_token_path"], "fun.model"),
#         )
#         embeddings, word_emb_dim, vocab_size = (
#             tokenizer_word2vec.load_word2vec_embeddings()
#         )
#         model = GNN_encoder(
#             args["num_layer"],
#             vocab_size,
#             word_emb_dim,
#             args["lstm_emb_dim"],
#             num_class,
#             JK=args["JK"],
#             drop_ratio=args["dropout_ratio"],
#             graph_pooling=args["graph_pooling"],
#             gnn_type=args["gnn_type"],
#             subword_emb=args["subword_embedding"],
#             bidrection=args["bidirection"],
#             task="java250",
#             repWay=args["repWay"],
#         )
#         model.gnn.embedding.fine_tune_embeddings(True)
#
#         model.gnn.embedding.init_embeddings(embeddings)
#         print(f"Load Pretraning model {args['input_model_file']}")
#         model.from_pretrained(args["input_model_file"] + ".pth", device)
#
#         return model
#
#     def _load_tokenizer(self):
#         # Since the tokenization has been built into the model in graphcode2vec
#         # we simply make a dummy function
#         def tokenizer(code, return_tensors, truncation, padding):
#             return code
#
#         return tokenizer
