# Generic Comparison Function
# Problem Statement
# You are tasked with implementing a generic comparison function compare in Python that can compare two objects of the same type. The function should support direct comparison of objects as well as comparison based on a provided key function that extracts a comparable key from each object.

# Requirements
# The compare function should have the following signature:

# compare:
# The function should accept the following arguments:
# x (type T): The first object to compare.
# y (type T): The second object to compare.
# key (type Callable[[T], any], optional): A function that extracts a comparable key from each object. If not provided, the function should perform direct comparison of the objects.
# The function should return an integer value based on the comparison result:
# -1 if x is less than y.
# 0 if x is equal to y.
# 1 if x is greater than y.
# The function should handle both direct comparison of objects and comparison based on a provided key function.
# Instructions
# Implement the compare function according to the specified requirements.
# Ensure that the function handles both direct comparison and comparison using a key function.
# You can extract the value of object x to compare by calling key(x) if a key function is provided for the object.

from typing import TypeVar, Callable, Any

T = TypeVar('T')

def compare(x: T, y: T, key: Callable[[T], Any] = None) -> int:
    """
    Compare two objects of the same type.

    Args:
        x (T): The first object to compare.
        y (T): The second object to compare.
        key (Callable[[T], any], optional): A function to extract a key from each object for comparison.
            Defaults to None, which means direct comparison of objects.

    Returns:
        int: -1 if x < y, 0 if x == y, 1 if x > y.
    """
    if key is not None:
        x, y = key(x), key(y)  # Extract keys if key function is provided

    if x < y:
        return -1
    elif x > y:
        return 1
    else:
        return 0

# Example usage:

# Direct comparison
print(compare(5, 10))  # Output: -1
print(compare("abc", "abc"))  # Output: 0
print(compare(20, 10))  # Output: 1

# Comparison with key function
students = [
    {"name": "Alice", "age": 25},
    {"name": "Bob", "age": 30},
    {"name": "Charlie", "age": 20}
]

# Sorting students by age
sorted_students = sorted(students, key=lambda x: x['age'])
print(sorted_students)  
# Output: [{'name': 'Charlie', 'age': 20}, {'name': 'Alice', 'age': 25}, {'name': 'Bob', 'age': 30}]

# Testing with custom key function
print(compare(students[0], students[1], key=lambda x: x['age']))  # Output: -1
print(compare(students[1], students[0], key=lambda x: x['age']))  # Output: 1
print(compare(students[1], students[1], key=lambda x: x['age']))  # Output: 0
