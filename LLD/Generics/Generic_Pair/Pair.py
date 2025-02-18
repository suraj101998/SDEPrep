# Generic Pair Class
# Problem statement
# We define a generic Pair class that takes two type parameters T and U, representing the types of the first and second elements of the pair, respectively. The constructor __init__ initializes the pair with the given first and second elements. We have a __repr__ method to customize the string representation of the pair. We have to demonstrate the usage of the Pair class with examples of creating pairs of various types.
# Pair Class
# Constructor:
# __init__(self, first: T, second: U): Initializes the pair with the given first and second elements of types T and U, respectively.
# Methods:
# __repr__(self): Returns the string representation of the pair as shown in the sample output format like "Pair(1,apple)".
# Examples
# Creating pairs of various types
# pair1 = Pair(1, "apple")
# pair2 = Pair(3.14, True)
# pair3 = Pair("hello", [1, 2, 3])
# print(pair1) # Output: Pair(1, 'apple')
# print(pair2) # Output: Pair(3.14, True)
# print(pair3) # Output: Pair('hello', [1, 2, 3])

from typing import TypeVar, Generic

T = TypeVar('T')
U = TypeVar('U')

class Pair(Generic[T, U]):
    def __init__(self, first: T, second: U):
        """Initializes the pair with two values of generic types T and U."""
        self.first = first
        self.second = second

    def __repr__(self) -> str:
        """Returns the string representation of the pair in the format 'Pair(first, second)'."""
        return f"Pair({self.first}, {self.second})"  # Use str() implicitly

# Example usage:
pair1 = Pair(1, "apple")
print(pair1)  # Output: Pair(1, apple)

pair2 = Pair(3.14, [1, 2, 3])
print(pair2)  # Output: Pair(3.14, [1, 2, 3])

pair3 = Pair((1, 2), {"a": 1, "b": 2})
print(pair3)  # Output: Pair((1, 2), {'a': 1, 'b': 2})