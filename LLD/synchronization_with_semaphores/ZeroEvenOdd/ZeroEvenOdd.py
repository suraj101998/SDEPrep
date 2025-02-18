# Zero Even Odd Challenge
# Problem Statement
# In this challenge, you are required to design a multithreading solution that ensures the ordered printing of numbers in a zero-even-odd sequence up to a given n. Specifically, you'll be working with a class ZeroEvenOdd that provides three methods:

# zero(printNumber): prints "0" to the standard output.
# even(printNumber): prints even numbers to the standard output.
# odd(printNumber): prints odd numbers to the standard output.
# Each of these methods is intended to be executed by a different thread.

# Task Description
# Your task is to implement the ZeroEvenOdd class to ensure that:

# The zero method prints "0" and is called n times.
# The even method prints even numbers from 2 to n.
# The odd method prints odd numbers from 1 to n.
# The numbers are printed in sequence, with "0" printed between each number, resulting in a pattern like "0102030405" for n = 5.
# Requirements
# Utilize semaphores from Python's threading module to synchronize the execution order of zero, even, and odd methods.
# The PrintNumber class is provided to encapsulate the logic for printing numbers and should be used as is.
# Ensure your implementation allows the threads to cooperate smoothly, maintaining the correct sequence regardless of how they are scheduled by the Python interpreter.
# Implementation Details
# The ZeroEvenOdd class constructor accepts an integer n, representing the maximum number to print.
# You need to correctly initialize and use semaphores to control the execution flow between the threads running zero, even, and odd methods.

import threading

class ZeroEvenOdd:
    def __init__(self, n):
        self.n = n
        self.zero_sem = threading.Semaphore(1)  # Zero starts first
        self.odd_sem = threading.Semaphore(0)   # Odd waits
        self.even_sem = threading.Semaphore(0)  # Even waits

    def zero(self, printNumber):
        for i in range(1, self.n + 1):
            self.zero_sem.acquire()  # Wait for zero
            printNumber.accept(0)  # Print "0"
            if i % 2 == 1:
                self.odd_sem.release()  # Allow odd to print
            else:
                self.even_sem.release()  # Allow even to print

    def even(self, printNumber):
        for i in range(2, self.n + 1, 2):
            self.even_sem.acquire()  # Wait for zero
            printNumber.accept(i)  # Print even number
            self.zero_sem.release()  # Allow zero to print again

    def odd(self, printNumber):
        for i in range(1, self.n + 1, 2):
            self.odd_sem.acquire()  # Wait for zero
            printNumber.accept(i)  # Print odd number
            self.zero_sem.release()  # Allow zero to print again


class PrintNumber:
    def accept(self, x):
        print(x, end='')


def test_zero_even_odd():
    n = 8
    zeo = ZeroEvenOdd(n)
    pn = PrintNumber()

    threads = [
        threading.Thread(target=zeo.zero, args=(pn,)),
        threading.Thread(target=zeo.even, args=(pn,)),
        threading.Thread(target=zeo.odd, args=(pn,))
    ]

    for t in threads:
        t.start()

    for t in threads:
        t.join()


if __name__ == "__main__":
    test_zero_even_odd()
