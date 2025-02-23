# Filter Fruits Python
# Problem Statement
# You are given a list of strings having different fruit names. You need to filter out the names of the fruits whose name starts from the character A or a.

# Instructions
# Implement the filter_fruits_starting_with_a function inside the filterFruits file.
# Return the answer in the same order as they appear in the input.
# If no name satisfies the criteria then return an empty list.

def filter_fruits_starting_with_a(fruits):
    return [fruit for fruit in fruits if fruit.lower().startswith('a')]


