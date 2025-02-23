# Student Sorting Challenge
# Problem Statement
# The objective of this challenge is to implement a Python method that sorts a list of Student objects. The students should be sorted primarily by their marks in ascending order, and if two students have the same marks, they should be further sorted by their names in alphabetical order.

# Task Description
# You are provided with a basic Student class that includes name and marks attributes. Your task is to implement a function sort_students that takes a list of Student objects as input and returns a new list of Student objects sorted according to the criteria mentioned above.

# Requirements
# Student Class: Utilize the provided Student class without modification. This class includes:
# name: A string representing the student's name.
# marks: An integer representing the student's marks.
# sort_students Function: Implement this function to sort the list of students. Use Python's built-in sorting capabilities to achieve the sorting with the specified criteria.

class Student:
    def __init__(self, name, marks):
        self.name = name
        self.marks = marks

def sort_students(students):
    return sorted(students, key=lambda student: (student.marks, student.name))

# Example usage:
student1 = Student("Alice", 85)
student2 = Student("Bob", 75)
student3 = Student("Charlie", 85)
student4 = Student("David", 90)

students = [student1, student2, student3, student4]

sorted_students = sort_students(students)
for student in sorted_students:
    print(f"Name: {student.name}, Marks: {student.marks}")
