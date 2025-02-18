class Point:
    def __init__(self, x, y):
        self._x = x
        self._y = y

    def display(self):
        print(f"[{self._x}, {self._y}]")


class ThreedPoint(Point):
    def __init__(self, x, y, z):
        super().__init__(x, y)  # Call the parent class constructor
        self._z = z  # Initialize the new attribute for 3D point

    def display(self):
        print(f"[{self._x}, {self._y}, {self._z}]")  # Display all three coordinates