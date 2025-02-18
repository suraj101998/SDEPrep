# Student Class Implementation in Python
# Problem Statement
# You are required to create a Python class for managing student details. The class should encapsulate the functionality required for handling student information.

# Requirements
# The Student class should have two data members:

# age: int (representing the age of the student)
# name: String (representing the name of the student)
# The constructor should accept both age and name as parameters and initialize the respective data members.
# Instructions
# Implement the Student class according to the specified requirements. Ensure that the class contains the specified data members and constructor. The constructor should properly initialize the age and name data members with the provided parameters.

class Student:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def display(self):
        print(f"My name is {self.name}. I am {self.age} years old")

    def say_hello(self, other_name):
        print(f"{self.name} says hello to {other_name}")