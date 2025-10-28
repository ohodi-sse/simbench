def get_recall(true_positives, false_negatives):
    return (
        true_positives / (true_positives + false_negatives)
        if (true_positives + false_negatives) > 0
        else 0
    )


def get_precision(true_positives, false_positives):
    return (
        true_positives / (true_positives + false_positives)
        if (true_positives + false_positives) > 0
        else 0
    )


def get_f_score(precision, recall):
    return (
        (2 * precision * recall) / (precision + recall)
        if (precision + recall) > 0
        else 0
    )


def get_confusion_matrix(scheme: callable, compressors: list[callable]):
    # A confusion matrix per group
    classify_files(scheme, compressors)

    first = True

    for label, group in data.classification_per_group_per_tool.items():
        (n, m) = group.shape

        info = {}
        info["Method"] = label
        true_positives = []
        false_negatives = []
        false_positives = []

        for index in range(n):
            true_pos = group[index][index]

            true_positives.append(true_pos)
            false_positives.append(np.sum(group[index, :]) - true_pos)
            false_negatives.append(np.sum(group[:, index]) - true_pos)

        true_pos_arr = np.array(true_positives)

        info["Macro Precision"] = [
            sum(
                [
                    get_precision(tp, fp)
                    for (tp, fp) in zip(true_positives, false_positives)
                ]
            )
            / len(true_positives)
        ]

        info["Macro Recall"] = [
            sum(
                [
                    get_recall(tp, fn)
                    for (tp, fn) in zip(true_positives, false_negatives)
                ]
            )
            / len(true_positives)
        ]

        # Micro F1 is calculated as micro recall, simply because these are equivalent in the micro case
        info["Micro F1-score"] = [
            sum(true_pos_arr) / sum(true_pos_arr + np.array(false_negatives))
        ]

        info["Macro F1-score"] = get_f_score(
            info["Macro Precision"][0], info["Macro Recall"][0]
        )

        if first:
            dataframe = pd.DataFrame(info)
            first = False
        else:
            newdata = pd.DataFrame(info)
            dataframe = pd.concat([dataframe, newdata], ignore_index=True)

    return dataframe
