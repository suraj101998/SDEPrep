# Get Distinct Numbers (Assignment)
# Problem Statement
# Implement a function getDistinctNumbers that takes a list of numbers as input and returns a list containing only the distinct numbers from the input list.

# Instructions
# Implement the getDistinctNumbers function inside the distinctNumbers.py file.
# It should take a single argument numbers, which is a list of numbers.
# The function should return a new list containing only the distinct numbers from the input list.
# The order of elements should be same as the order in which they occur in the input list

#TODO: Complete the function

def getDistinctNumbers(numbers):
    seen = set()
    distinct_numbers = []
    
    for num in numbers:
        if num not in seen:
            seen.add(num)
            distinct_numbers.append(num)
    
    return distinct_numbers