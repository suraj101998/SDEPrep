# Shape Class Implementation in Python
# Problem Statement
# Implement an abstract class Shape in Python along with child classes like Rectangle and Circle. Shape is an abstract class with abstract methods area() and perimeter(). Rectangle and Circle are child classes of Shape, implementing the area() and perimeter() methods specific to their shapes.

# Rectangle takes length and width as parameters.
# Circle takes radius as a parameter.
# Requirements
# Implement an abstract class Shape with the following abstract methods:
# area(): Calculates the area of the shape.
# perimeter(): Calculates the perimeter of the shape.
# Implement child classes Rectangle and Circle inheriting from Shape.
# Rectangle should have a constructor that accepts length and width.
# Circle should have a constructor that accepts the radius.
# Instructions
# Implement the Shape, Rectangle, and Circle classes according to the specified requirements.
# Ensure that the Shape class contains the abstract methods area() and perimeter().
# Ensure that the Rectangle class properly implements the area() and perimeter() methods for rectangles.
# Ensure that the Circle class properly implements the area() and perimeter() methods for circles.
# Use math.pi as the value of pi for calculating the area of a circle.

from abc import ABC, abstractmethod
import math

# TODO: Implement the Shape class
class Shape(ABC):
    @abstractmethod
    def area(self):
        pass

    @abstractmethod
    def perimeter(self):
        pass

# Rectangle class inheriting from Shape
class Rectangle(Shape):
    def __init__(self, length, width):
        self.length = length
        self.width = width
    
    def area(self):
        return self.length * self.width
    
    def perimeter(self):
        return 2 * (self.length + self.width)

# Circle class inheriting from Shape
class Circle(Shape):
    def __init__(self, radius):
        self.radius = radius
    
    def area(self):
        return math.pi * self.radius ** 2
    
    def perimeter(self):
        return 2 * math.pi * self.radius



# Example usage
rectangle = Rectangle(5, 4)
print("Rectangle area:", rectangle.area())  # Output: Rectangle area: 20
print("Rectangle perimeter:", rectangle.perimeter())  # Output: Rectangle perimeter: 18

circle = Circle(3)
print("Circle area:", circle.area())  # Output: Circle area: 28.274333882308138
print("Circle perimeter:", circle.perimeter())  # Output: Circle perimeter: 18.84955592153876
