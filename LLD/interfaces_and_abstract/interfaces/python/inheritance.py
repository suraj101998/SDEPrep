# Interface Inheritance and Implementation
# Problem Statement
# You are tasked with creating a Python class hierarchy that demonstrates the implementation of multiple interfaces and inheritance between interfaces. The system should provide functionality for defining and implementing interfaces with abstract methods.

# Requirements
# The class hierarchy should include the following components:

# Interface I1:
# Abstract methods:
# fun1(self)
# fun(self)
# Interface I2:
# Abstract methods:
# fun2(self)
# fun(self)
# Interface I (derived from I1 and I2):
# Inherits the abstract methods from both I1 and I2.
# Class C (implementing I):
# This class implements the interface I and provides concrete implementations for the abstract methods defined in I.
# Ensure that interfaces I1 and I2 contain only abstract method signatures without any implementation details.
# Instructions
# Implement the I1, I2, and I interfaces according to the specified requirements.
# Implement the C class, which inherits from the I interface and provides concrete implementations for the abstract methods.

from abc import ABC, abstractmethod

# Interface I1
class I1(ABC):
    @abstractmethod
    def fun1(self):
        pass

    @abstractmethod
    def fun(self):
        pass

# Interface I2
class I2(ABC):
    @abstractmethod
    def fun2(self):
        pass

    @abstractmethod
    def fun(self):
        pass

# Interface I (Inheriting from I1 and I2)
class I(I1, I2):
    pass  # Inherits all abstract methods from I1 and I2

# Class C implementing Interface I
class C(I):
    def fun1(self):
        print("fun1() implemented in class C")

    def fun2(self):
        print("fun2() implemented in class C")

    def fun(self):
        print("fun() implemented in class C")