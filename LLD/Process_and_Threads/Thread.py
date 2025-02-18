# Multithreaded Class Demonstration Challenge
# Problem Statement
# In this programming exercise, your goal is to implement a multithreaded application that demonstrates basic threading concepts in Python. Specifically, you will create two classes, Adder and Subtractor, both of which will inherit from Python's threading.Thread class. Additionally, a Client class will manage these threads.

# Task
# Your task is divided into three parts:

# 1. Implement the Adder Class
# Inherit from the threading.Thread class.
# Override the run method to print "I am the Adder class".
# 2. Implement the Subtractor Class
# Inherit from the threading.Thread class.
# Override the run method to print "I am the Subtractor class".
# 3. Implement the Client Class
# Create a static method named main.
# Inside the main method, print "I am the main class".
# Initialize one instance of the Adder class and one instance of the Subtractor class, then start both threads.
# Ensure that the main method waits for both threads to complete before it exits.
# Guidelines
# Make sure your implementation correctly uses Python's threading capabilities to run Adder and Subtractor concurrently.
# The order in which "I am the Adder class" and "I am the Subtractor class" are printed is not deterministic and may vary on each run due to the nature of threading.
# Note: The actual output may vary in order due to the concurrency involved in thread execution.

# Submission Requirements
# Ensure your Python script correctly implements the above-described functionality.
# Pay attention to the correctness of the threading implementation, including proper thread starting and joining.
# Your script will be tested for both functionality and adherence to the problem statement.


import threading

# Define the Adder class that inherits from threading.Thread
class Adder(threading.Thread):
    def run(self):
        print("I am the Adder class")

# Define the Subtractor class that inherits from threading.Thread
class Subtractor(threading.Thread):
    def run(self):
        print("I am the Subtractor class")

# Define the Client class with a static main method to manage thread execution
class Client:
    @staticmethod
    def main():
        print("I am the main class")  # Print main class message

        # Initialize instances of Adder and Subtractor threads
        adder_thread = Adder()
        subtractor_thread = Subtractor()

        # Start both threads
        adder_thread.start()
        subtractor_thread.start()

        # Ensure that the main method waits for both threads to complete
        adder_thread.join()
        subtractor_thread.join()

# Run the program
if __name__ == "__main__":
    Client.main()
