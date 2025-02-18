# Parallel Binary Tree Size Calculation
# Problem Statement
# You are tasked with creating a Python program that can calculate the size (number of nodes) of a binary tree using parallel processing. The program should leverage the concurrent.futures module and threading to achieve parallelism and improve performance.

# Requirements
# The program should include the following components:

# Node class:
# Represents a node in the binary tree.
# Has attributes: data (integer value), left (reference to the left child), and right (reference to the right child).
# TreeSizeCalculator class:
# Takes the root node of the binary tree and an instance of concurrent.futures.Executor as input.
# Provides a method calculate_size to calculate the size (number of nodes) of the binary tree.
# Utilizes parallel processing by submitting tasks to the executor to calculate the size of the left and right subtrees concurrently.
# Waits for all tasks to complete before returning the total size.
# Instructions
# Implement the _calculate_size_recursive method in the TreeSizeCalculator class, which recursively calculates the size of the binary tree using parallel processing.
# Ensure that the calculate_size method properly invokes the _calculate_size_recursive method and handles the case when the root node is None.
# _calculate_size_recursive function doesn't return any value but should update the size property given in the constructor.

import threading
from concurrent.futures import Executor, Future, ThreadPoolExecutor

class Node:
    def __init__(self, data: int):
        self.data = data
        self.left = None
        self.right = None

class TreeSizeCalculator:
    def __init__(self, root: Node, executor: Executor):
        self.root = root
        self.executor = executor
        self.size_lock = threading.Lock()
        self.size = 0  # This will be updated concurrently

    def calculate_size(self):
        if not self.root:
            return 0

        self._calculate_size_recursive(self.root)
        return self.size

    def _calculate_size_recursive(self, node: Node):
        if not node:
            return
        
        # Increment size safely using a lock
        with self.size_lock:
            self.size += 1

        # Parallel execution of left and right subtrees
        left_future: Future = None
        right_future: Future = None

        if node.left:
            left_future = self.executor.submit(self._calculate_size_recursive, node.left)
        if node.right:
            right_future = self.executor.submit(self._calculate_size_recursive, node.right)

        # Wait for tasks to complete
        if left_future:
            left_future.result()
        if right_future:
            right_future.result()