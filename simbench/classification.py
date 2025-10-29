import pandas as pd
from data import File


def classify_best_match(
    similarities: pd.DataFrame, training_files: [File], file: File
) -> float:
    # Takes a file with all similarities and extracts the column corresponding to the file in question
    # It should limit itself to compare with files in the training set
    #
    # print(f"File column: {file_column}")
    # training_filtered = file_column[training_files]
    # file_column_filtered = similarities.loc[[training_files], [str(file)]]

    file_column = similarities.loc[[str(file)], training_files]
    print(file_column)
    best_match = max(file_column.to_numpy().max())

    return best_match


def classify_data(
    similarities: pd.DataFrame,
    classifier,
    training_files: pd.DataFrame,
    test_files: pd.DataFrame,
) -> pd.DataFrame:
    classification_table = {}
    indexes = ["true class", "classified as"]
    for testfile in test_files:
        label = classify_best_match(
            similarities, training_files, testfile
        )  # should use generic classifier of type callable
        truelabel = testfile.group

        classification_table[str(testfile)] = [truelabel, label]

    df = pd.DataFrame(classification_table, index=indexes)

    return df
