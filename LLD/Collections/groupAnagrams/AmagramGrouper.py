# Group Anagrams
# Problem Statement
# You are given an array of strings strs, you need to group the anagrams together and store them in a list of strings. Write a function in Python that takes an array of strings as input and returns a list of lists where each inner list contains the strings that are grouped together i.e. the anagrams.

# Note: A string s2 is called an anagram of string s1, if the frequency of each character in the string s2 is equal to the frequency of each character in the string s1.

# Example
# Let us consider the array of strings given as input be ["eat", "tea", "tan", "ate", "nat", "bat"]. Now, if we look at the array we can see that "eat" and "tea" are anagrams because in "eat" the characters are 'e','a' & 't' having frequency of 1 each. Similarly, "tea" also has 'a','e' & 't' characters only and their frequency is also 1 each. Since all the characters have the same frequency and all the characters are common in both strings hence they are anagrams.

# We group these anagrams together in a list which will look like [["eat","tea"],["tan","nat","bat"],["ate"]].

# Instructions
# Implement the group_anagrams function provided in the code snippet above.
# The input array of strings can also be empty or None. In that case, you need to return an empty list.
# Use a dictionary to efficiently group the anagrams.


from collections import defaultdict

def group_anagrams(strs):
    if not strs:
        return []

    anagrams = defaultdict(list)

    for word in strs:
        sorted_key = ''.join(sorted(word))  # Sorting the word to create a unique key
        anagrams[sorted_key].append(word)   # Grouping anagrams together

    return list(anagrams.values())

# Example usage:
input_strings = ["eat", "tea", "tan", "ate", "nat", "bat"]
print(group_anagrams(input_strings))
