# User Management System
# Problem Statement
# You are tasked with creating a Python class hierarchy for managing users, including students and employees. The system should encapsulate the functionality required for storing and displaying user information, as well as specialized information for students and employees.

# Requirements
# 1.User class:

# Attributes: _username, _email
# Methods:
# init(self, username, email): Constructor to initialize the user's username and email.
# displayInfo(self): Prints the user's username and email.
# getUsername(self): Returns the user's username.
# getEmail(self): Returns the user's email.
# 2.Student class (derived from User):

# Attributes: _studentId, _course
# Methods:
# init(self, username, email, studentId, course): Constructor to initialize the student's username, email, student ID, and course.
# displayInfo(self): Prints the student's username, email, student ID, and course.
# getStudentId(self): Returns the student's ID.
# getCourse(self): Returns the student's course.
# 3.Employee class (derived from User):

# Attributes: _employeeId, _department
# Methods:
# init(self, username, email, employeeId, department): Constructor to initialize the employee's username, email, employee ID, and department.
# displayInfo(self): Prints the employee's username, email, employee ID, and department.
# getEmployeeId(self): Returns the employee's ID.
# getDepartment(self): Returns the employee's department.
# Display Format:
# For both the User and Student classes, the displayInfo() method should print the information in the following format:

# Username: [username]
# Email: [email]
# For the Student class, additional information should be displayed as follows:

# Student ID: [studentId]
# Course: [course]
# Instructions
# Implement the User, Student, and Employee classes according to the specified requirements.
# Ensure that the Student and Employee classes inherit from the User class and override the necessary methods.
# Follow the specified display format for printing user and student information.

class User:
    def __init__(self, username, email):
        self._username = username
        self._email = email

    def displayInfo(self):
        print(f"Username: {self._username}")
        print(f"Email: {self._email}")

    def getUsername(self):
        return self._username  # Returns the username

    def getEmail(self):
        return self._email  # Returns the email


class Student(User):
    def __init__(self, username, email, studentId, course):
        super().__init__(username, email)
        self._studentId = studentId
        self._course = course

    def displayInfo(self):
        super().displayInfo()
        print(f"Student ID: {self._studentId}")
        print(f"Course: {self._course}")

    def getStudentId(self):
        return self._studentId  # Returns the student ID

    def getCourse(self):
        return self._course  # Returns the course


class Employee(User):
    def __init__(self, username, email, employeeId, department):
        super().__init__(username, email)
        self._employeeId = employeeId
        self._department = department

    def displayInfo(self):
        super().displayInfo()
        print(f"Employee ID: {self._employeeId}")
        print(f"Department: {self._department}")

    def getEmployeeId(self):
        return self._employeeId  # Returns the employee ID

    def getDepartment(self):
        return self._department  # Returns the department