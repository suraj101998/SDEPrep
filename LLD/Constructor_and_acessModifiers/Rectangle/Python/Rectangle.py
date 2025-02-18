import copy

from config.point import Point


class Rectangle:
    def __init__(self, *args):
        if len(args) == 2 and all(isinstance(arg, Point) for arg in args):
            # Case 1: Two Point objects
            self.topLeft = Point(args[0].x, args[0].y)
            self.bottomRight = Point(args[1].x, args[1].y)

        elif len(args) == 4 and all(isinstance(arg, int) for arg in args):
            # Case 2: Four integer coordinates
            self.topLeft = Point(args[0], args[1])
            self.bottomRight = Point(args[2], args[3])

        elif len(args) == 1 and isinstance(args[0], Rectangle):
            # Case 3: Copy constructor with a Rectangle object
            self.topLeft = Point(args[0].topLeft.x, args[0].topLeft.y)
            self.bottomRight = Point(args[0].bottomRight.x, args[0].bottomRight.y)

        else:
            raise ValueError("Invalid arguments for Rectangle constructor")

    def __str__(self):
        return f"Top Left: {self.topLeft}, Bottom Right: {self.bottomRight}"
