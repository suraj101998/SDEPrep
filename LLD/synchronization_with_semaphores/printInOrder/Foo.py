# Print in Order Challenge
# Problem Statement
# In this challenge, you are required to ensure that three different methods print in strict sequence: "first", "second", and "third". You are given a class Foo with three methods:

# first(): prints "first"
# second(): prints "second"
# third(): prints "third"
# Your task is to modify the Foo class to ensure that these methods can only run in sequence (first, then second, then third), regardless of the order in which they're called in the code.

# Requirements
# The class Foo is already provided with semaphore placeholders for synchronization.
# You need to initialize any required semaphores in the __init__ method of the Foo class.
# Implement the first, second, and third methods using semaphores to enforce the correct sequence of execution.
# The output list attribute of the Foo class should collect the strings "first", "second", and "third" in the exact order of method execution to validate the sequence.
# Implementation Details
# Use Python's threading module for thread creation and synchronization.
# Leverage semaphores from the threading module to enforce the execution order of first(), second(), and third() methods.


import threading

class Foo:
    def __init__(self):
        self.second_semaphore = threading.Semaphore(0)  # Block second()
        self.third_semaphore = threading.Semaphore(0)   # Block third()
        self.output = []

    def first(self):
        self.output.append("first")  # Print "first"
        self.second_semaphore.release()  # Allow second() to proceed

    def second(self):
        self.second_semaphore.acquire()  # Wait for first()
        self.output.append("second")  # Print "second"
        self.third_semaphore.release()  # Allow third() to proceed

    def third(self):
        self.third_semaphore.acquire()  # Wait for second()
        self.output.append("third")  # Print "third"


# Function to execute methods in threads
def worker_foo(method, foo_instance):
    method_dict = {
        "first": foo_instance.first,
        "second": foo_instance.second,
        "third": foo_instance.third
    }
    method_dict[method]()


# Create a Foo instance
foo = Foo()

# Create threads for calling first(), second(), and third()
threads = []
for method in ["third", "second", "first"]:  # Calling out of order
    thread = threading.Thread(target=worker_foo, args=(method, foo))
    threads.append(thread)
    thread.start()

# Wait for all threads to complete
for thread in threads:
    thread.join()

# Check the output sequence
print("Output sequence:", foo.output)
