# Multithreaded Table Creator
# Problem Statement
# In this programming challenge, you are tasked with completing the implementation of a multithreaded table creator that prints the multiplication table for a given number. This task involves inheriting from Python's threading.Thread class to create a custom TableCreator class capable of running in its own thread.

# Your implementation should enable multiple instances of TableCreator to run concurrently, each generating a multiplication table for a different number. The core functionality of your TableCreator class will revolve around printing a multiplication table for the number provided to it, from 1 to 10.

# Requirements
# TableCreator Class
# Initialization (__init__ method): Your class should accept a single integer (num) during initialization. This integer represents the number for which the multiplication table is to be generated.
# Thread Execution (run method): Implement the run method to print the multiplication table for the initialized number, from 1 to 10. Each line printed should follow the format: "<num> times <i> is <result>", where <num> is the initialized number, <i> is the current multiplier (from 1 to 10), and <result> is the product of <num> and <i>.
# Client Code
# Already provided.
# Notes
# Make sure to properly initialize the threading superclass in your TableCreator class.
# Consider how concurrency affects the execution and output of your program. While exact output order cannot be guaranteed due to the nature of threads, your implementation should ensure all tables are correctly printed out by each respective thread.

import threading

# TableCreator class inheriting from threading.Thread
class TableCreator(threading.Thread):
    def __init__(self, num):
        super().__init__()  # Initialize Thread superclass
        self.num = num  # Store the number for which we generate the table

    def run(self):
        # Print the multiplication table for self.num from 1 to 10
        for i in range(1, 11):
            print(f"{self.num} times {i} is {self.num * i}")

# Client class to manage execution
class Client:
    @staticmethod
    def main():
        n = int(input("Enter a number: "))  # Get user input for number of threads

        threads = []
        for i in range(1, n + 1):
            thread = TableCreator(i)  # Create a new thread for each number
            threads.append(thread)

        for thread in threads:
            thread.start()  # Start each thread

        for thread in threads:
            thread.join()  # Wait for all threads to finish
