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
