# Multi-threaded Addition Program
# Overview
# This Python program demonstrates multi-threaded addition functionality using the Client and Adder classes. The program takes two numbers as input from the user, creates a new thread, and invokes the Adder class to calculate and print the sum of the two numbers.

# Implementation Details
# Class Adder
# Inherits from the threading.Thread class.
# Represents a thread that performs addition of two numbers.
# Initializes with two numbers (num1 and num2) provided as input.
# Overrides the run() method to calculate and print the sum of num1 and num2.
# Class Client
# Contains a static method main() that serves as the entry point of the program.
# Prompts the user to enter two numbers.
# Creates an instance of the Adder class with the provided numbers.
# Starts the thread and waits for its completion.
# Instructions
# To run the program:

# Execute the Client class's main() method.
# Enter two numbers when prompted.
# The program will create a new thread to calculate and print the sum of the provided numbers.
# Ensure that the program runs in a Python environment with threading support.

import threading

# Adder class inheriting from threading.Thread
class Adder(threading.Thread):
    def __init__(self, num1, num2):
        super().__init__()  # Initialize Thread class
        self.num1 = num1
        self.num2 = num2

    def run(self):
        result = self.num1 + self.num2
        print(result)  # ✅ Fix: Print only the sum, without "Sum: "

# Client class
class Client:
    @staticmethod
    def main():
        # Taking user input
        num1 = int(input("Enter first number: "))
        num2 = int(input("Enter second number: "))

        # Creating Adder thread
        adder_thread = Adder(num1, num2)

        # Starting the thread
        adder_thread.start()

        # Waiting for thread to complete
        adder_thread.join()
