# Word Counting Python (Assignment)
# Problem Statement
# Write a Python function called word_frequencies that takes a list of strings as input and returns a dictionary containing the frequency of each word in the input list.

# Requirements
# Your function should perform the following steps using functional programming concepts:

# Flatten the list: Convert the list of strings into a single string.
# Tokenization: Split the string into individual words.
# Normalization: Convert all words to lowercase to treat uppercase and lowercase versions of the same word as equal.
# Word Counting: Count the frequency of each word.
# Result: Return a dictionary containing each word and its frequency.
# Example
# Let us consider the input list of strings:

# sentences = [ "Python is a popular programming language", "I love coding in Python", "Java is also a great language" ]

# The output dictionary containing the word frequencies would be: {'python': 2, 'is': 2, 'a': 2, 'popular': 1, 'programming': 1, 'language': 2, 'i': 1, 'love': 1, 'coding': 1, 'in': 1, 'java': 1, 'also': 1, 'great': 1}

# Instructions
# Implement the word_frequencies function provided in the wordCounting.py file.
# Ensure that the function follows the specified steps to calculate word frequencies.
# Use functional programming concepts to solve this question.

from typing import List, Dict
import re
from collections import Counter

def word_frequencies(sentences: List[str]) -> Dict[str, int]:
    # Step 1: Flatten the list and join all sentences into a single string
    text = " ".join(sentences)

    # Step 2: Tokenization - Split the string into individual words using regex
    words = re.findall(r'\b\w+\b', text.lower())  # Convert to lowercase and split words

    # Step 3: Word Counting - Count the frequency of each word
    word_count = Counter(words)

    # Step 4: Return the dictionary of words and frequencies
    return dict(word_count)

# Sample Input
sentences = [
    "Python is a popular programming language",
    "I love coding in Python",
    "Java is also a great language"
]

# Get word frequencies
result = word_frequencies(sentences)

# Print the result
print(result)

# Expected Output:
# {'python': 2, 'is': 2, 'a': 2, 'popular': 1, 'programming': 1, 'language': 2, 'i': 1, 'love': 1, 'coding': 1, 'in': 1, 'java': 1, 'also': 1, 'great': 1}
