# Frequency Count(Assignment)
# Problem Statement
# You are given an array of integers, and you need to count the frequency of each integer present in the array using a Dicitonary and return the map as the answer.

# Use Dicitonary to solve the question.
# The keys of the dicitonary are the elements of the array.
# The values of the dicitonary are the frequencies of those elements.
# Instructions
# Implement the count_frequency method.
# You don't need to print anything, just implement the function and return the dicitonary that stores the elements and their frequencies.
# The order of the keys inside the dicitonary does not matter.


def count_frequency(arr):
    freq_map = {}  # Initialize an empty dictionary

    for num in arr:
        if num in freq_map:
            freq_map[num] += 1  # Increment count if key exists
        else:
            freq_map[num] = 1  # Initialize count if key is new

    return freq_map  # Return the frequency dictionary

# Example usage:
arr = [1, 2, 3, 4, 1, 2, 3, 1, 2, 1]
frequency = count_frequency(arr)
print(frequency)  # Output: {1: 4, 2: 3, 3: 2, 4: 1}
