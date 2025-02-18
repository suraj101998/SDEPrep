# Generic Linked List Implementation
# Problem Statement
# You are tasked with implementing a generic linked list data structure in Python. The linked list should be able to store elements of any type and provide methods for appending new elements and printing the list.

# Requirements
# The implementation should include the following components:

# Node class:
# A generic class that represents a node in the linked list.
# Each node should have a data attribute to store the element and a next attribute to store the reference to the next node.
# LinkedList class:
# A generic class that represents the linked list.
# Should have a head attribute to store the reference to the first node and a tail attribute to store the reference to the last node.
# Should have an append method to add a new element to the end of the list.
# Should have a print_list method to print the elements of the list in the order they are stored.
# The implementation should be type-safe and support elements of any type.
# Instructions
# Implement the Node class according to the specified requirements.
# Implement the LinkedList class with the required attributes and methods.
# Ensure that the implementation is type-safe by using type annotations and the typing module.

from typing import TypeVar, Generic, Optional

T = TypeVar('T')

class Node(Generic[T]):
    def __init__(self, data: T):
        self.data: T = data
        self.next: Optional[Node[T]] = None  # Reference to the next node

class LinkedList(Generic[T]):
    def __init__(self):
        self.head: Optional[Node[T]] = None  # First node reference
        self.tail: Optional[Node[T]] = None  # Last node reference

    def append(self, data: T):
        new_node = Node(data)
        if self.head is None:
            self.head = new_node
            self.tail = new_node
        else:
            assert self.tail is not None  # For type safety
            self.tail.next = new_node
            self.tail = new_node

    def print_list(self):
        current_node = self.head
        while current_node:
            print(current_node.data, end=" -> ")
            current_node = current_node.next
        print("None")

# Example usage:

# Create a linked list of integers
ll_int = LinkedList[int]()
ll_int.append(1)
ll_int.append(2)
ll_int.append(3)
ll_int.print_list()  # Output: 1 -> 2 -> 3 -> None

# Create a linked list of strings
ll_str = LinkedList[str]()
ll_str.append("a")
ll_str.append("b")
ll_str.append("c")
ll_str.print_list()  # Output: a -> b -> c -> None
