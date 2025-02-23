# Process Sentences Python (Assignment)
# Problem Statement
# Given a list of strings sentences representing sentences, write a Python method called processSentences that performs the following operations:

# Filter out sentences that contain the word "python".
# Map each filtered sentences to its length.
# Find the average length of the sentences.
# Convert the average length to an integer by rounding down.
# Return the rounded average length.
# Instructions
# Implement the processSentences method inside the processSentence.py file
# Return the rounded down average length.

def processSentences(sentences):
    # Filter out sentences containing the word "python"
    filtered_sentences = [sentence for sentence in sentences if "python" in sentence.lower()]

    # Map each remaining sentence to its length
    sentence_lengths = [len(sentence) for sentence in filtered_sentences]

    # Find the average length of the sentences
    if sentence_lengths:
        average_length = sum(sentence_lengths) / len(sentence_lengths)
    else:
        average_length = 0

    # Convert the average length to an integer by rounding down
    rounded_average_length = int(average_length)

    return rounded_average_length