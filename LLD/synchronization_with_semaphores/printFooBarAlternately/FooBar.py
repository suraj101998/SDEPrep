# FooBar Printer Challenge
# Problem Statement
# In this challenge, you are tasked with implementing a multithreaded application that alternates printing the words "foo" and "bar" in sequence using Python's threading capabilities. The goal is to synchronize two threads to ensure that "foo" and "bar" are printed in the correct order, forming the sequence "foobar" repeated n times, where n is a given integer.

# Task Description
# Your task is to implement a class named FooBar that will have two methods: foo and bar. These methods, when executed by different threads, should print "foo" and "bar" respectively, ensuring that "foo" is always printed before "bar" in each sequence.

# Requirements
# The class FooBar should accept an integer n in its constructor. This integer n represents the number of times the sequence "foobar" should be printed.
# Implement two methods in the FooBar class:
# foo: This method should print the word "foo". It will be called by one thread.
# bar: This method should print the word "bar". It will be called by another thread.
# Ensure that "foo" and "bar" are printed in the correct sequence, forming "foobar" exactly n times.
# Implementation Details
# Use Python's threading module to create and manage threads.
# Utilize synchronization mechanisms such as semaphores to coordinate the execution order of the threads.
# The program should create two threads, one for each method (foo and bar), and start them in such a way that they produce the correct output.

import threading

class FooBar:
    def __init__(self, n):
        self.n = n
        self.foo_semaphore = threading.Semaphore(1)  # Start with foo
        self.bar_semaphore = threading.Semaphore(0)  # Bar waits initially

    def foo(self):
        for _ in range(self.n):
            self.foo_semaphore.acquire()  # Wait for foo
            print("foo", end="")  # Print foo
            self.bar_semaphore.release()  # Allow bar to execute

    def bar(self):
        for _ in range(self.n):
            self.bar_semaphore.acquire()  # Wait for bar
            print("bar", end="")  # Print bar
            self.foo_semaphore.release()  # Allow foo to execute again


def test_foobar():
    n = 5
    fb = FooBar(n)

    threads = [threading.Thread(target=fb.foo), threading.Thread(target=fb.bar)]

    for t in threads:
        t.start()
    for t in threads:
        t.join()


if __name__ == "__main__":
    test_foobar()
