# Factorial Class Implementation in Python
# Problem Statement
# You are tasked with implementing a multi-threaded solution to compute factorials of large numbers efficiently. Your implementation should involve creating a custom thread class that computes the factorial of a given number in a separate thread.

# Requirements
# Factorial Thread Class:
# Create a class named FactorialThread that inherits from Python's threading.Thread class.
# The __init__ method should accept a single parameter n, which represents the number to compute the factorial of. It should also initialize a result attribute to None.
# Implement the run method in such a way that it computes the factorial of n using the math.factorial function and stores the result in the result attribute.
# Compute Large Factorial Function:
# Write a function named compute_large_factorial that takes an integer n as input and returns the factorial of n.
# Inside this function, create an instance of the FactorialThread class, start the thread, wait for the calculation to finish, and then return the result.
# Instructions
# You should use Python's threading and math modules for implementing the solution.
# Pay attention to thread safety and ensure your thread correctly completes its execution before the result is accessed.

import threading
import math

# FactorialThread class inheriting from threading.Thread
class FactorialThread(threading.Thread):
    def __init__(self, n):
        super().__init__()  # Initialize Thread class
        self.n = n
        self.result = None  # Store the factorial result

    def run(self):
        self.result = math.factorial(self.n)  # Compute factorial

# Function to compute factorial using a separate thread
def compute_large_factorial(n):
    thread = FactorialThread(n)  # Create a thread
    thread.start()  # Start the thread
    thread.join()  # Wait for thread to complete
    return thread.result  # Return computed factorial