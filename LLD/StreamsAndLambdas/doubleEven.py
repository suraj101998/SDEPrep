# Filter and Double Even Numbers (Assignment)
# Problem Statement
# Implement a function filter_and_double_even_numbers that takes a list of integers as input. It should filter out the even numbers from the input list, double each of them, and return a list containing the doubled values.

# Instructions
# Implement the filter_and_double_even_numbers function inside the doubleEvenNumbers file.
# It should take a single argument numbers, which is a list of integers.
# The function should filter out even numbers from the input list, double each of them, and return a list containing the doubled values of those even numbers
# The output should be in the same order in which the even numbers appear in the original input list.

def is_even(num):
    return num % 2 == 0

def double(num):
    return num * 2

# Function to filter and double even numbers
def filter_and_double_even_numbers(numbers):
    result = []
    for num in numbers:
        if is_even(num):
            result.append(double(num))
    return result
