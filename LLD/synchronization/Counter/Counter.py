# Concurrent Counter Management
# Problem statement
# This Python program is created to implement multithreading concepts. The program has a Counter class with methods to increment, decrement, and retrieve the counter value. It then creates multiple threads to perform concurrent increment and decrement operations on the counter.

# Requirements
# Class Counter
# Represents a counter object with an initial count.
# Provides methods for incrementing, decrementing, and retrieving the counter value.
# Methods:
# __init__(self, initial_count): Initializes the counter with the specified initial count.
# incValue(self, offset): Increments the counter value by the specified offset.
# decValue(self, offset): Decrements the counter value by the specified offset.
# getValue(self): Retrieves the current value of the counter.
# Concurrent Operations
# Functions concurrent_inc() and concurrent_dec() perform concurrent increment and decrement operations on the counter.
# Each function is executed by multiple threads to simulate concurrent operations.
# Instructions
# Implement the methods of the Counter class as per the provided TODO comments.
# The program will create and start multiple threads for concurrent increment and decrement operations.
# After all threads complete execution, the final value of the counter will be printed.
# Ensure that the Python environment supports threading to execute the program effectively.

import threading

# Counter class with thread-safe methods
class Counter:
    def __init__(self, initial_count):
        self.count = initial_count
        self.lock = threading.Lock()

    def incValue(self, offset):
        with self.lock:
            self.count += offset

    def getValue(self):
        with self.lock:
            return self.count

    def decValue(self, offset):
        with self.lock:
            self.count -= offset


# Function for concurrent increment operation
def concurrent_inc(counter, offset):
    for _ in range(1000):
        counter.incValue(offset)


# Function for concurrent decrement operation
def concurrent_dec(counter, offset):
    for _ in range(1000):
        counter.decValue(offset)


# Create a Counter instance with initial value 0
counter = Counter(0)

# Create and start multiple threads for concurrent increment and decrement
threads = []
for _ in range(10):
    thread_inc = threading.Thread(target=concurrent_inc, args=(counter, 1))
    thread_dec = threading.Thread(target=concurrent_dec, args=(counter, 1))
    threads.append(thread_inc)
    threads.append(thread_dec)
    thread_inc.start()
    thread_dec.start()

# Wait for all threads to complete
for thread in threads:
    thread.join()

# Check the final value of the counter
print("Final counter value:", counter.getValue())
