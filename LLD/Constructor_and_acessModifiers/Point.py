# Point Class Implementation in Python
# Problem Statement
# You are tasked with implementing a Python class for managing points in a two-dimensional plane. The class should allow constructing objects with x and y coordinates. Additionally, the class should support equality comparison between points, provide a string representation of points, and support shallow and deep copying.

# Your task is to implement a Point class with the following specifications:

# Requirements
# The Point class should have the following data members:
# x: int or float (representing the x-coordinate of the point)
# y: int or float (representing the y-coordinate of the point)
# The Point class should have the following methods:
# __eq__: This method should return True if two points have the same x and y coordinates, False otherwise.
# __str__: This method should return a string representation of the point in the format "(x, y)".
# __copy__: This method should create a shallow copy of the point.
# __deepcopy__: This method should create a deep copy of the point using the copy module.
# The Point class should have one constructor:
# __init__: This constructor should accept two arguments, representing the x and y coordinates of the point, respectively.
# Instructions
# Implement the Point class according to the specified requirements.
# Ensure that the class contains the specified data members and methods.
# Implement the constructor to initialize the x and y coordinates of the point.
# Implement methods for equality comparison, string representation, shallow copying, and deep copying.
# Ensure that the __eq__, __str__, __copy__, and __deepcopy__ methods are correctly implemented and provide the expected functionality.
# Test the Point class thoroughly to ensure its correctness and functionality.

import copy


class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __eq__(self, other):
        return isinstance(other, Point) and self.x == other.x and self.y == other.y

    def __str__(self):
        return f"({self.x}, {self.y})"

    def __copy__(self):
        # Create a new instance of Point with the same coordinates
        return Point(self.x, self.y)

    def __deepcopy__(self, memo):
        # Create a new instance of Point with deep copies of coordinates
        return Point(copy.deepcopy(self.x, memo), copy.deepcopy(self.y, memo))
