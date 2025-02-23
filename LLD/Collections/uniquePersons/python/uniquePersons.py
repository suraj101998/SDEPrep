# Unique Persons Finder Challenge
# Problem Statement
# In this challenge, you will work with a Person class, which represents individuals with name and age attributes. Your task is to implement the find_unique_persons function. This function should take a list of Person objects as input and return a new list that contains only unique persons based on their names. It's important that this function maintains the order of appearance and includes only the first occurrence of each unique name, disregarding subsequent duplicates.

# Task Description
# The Person Class
# The Person class is predefined with the following attributes:

# name: A string representing the person's name.
# age: An integer representing the person's age.
# You should use this class as provided without modification.

# The finduniquepersons Function
# Implement the find_unique_persons function to meet the following requirements:

# Accept a list of Person objects as its input.
# Return a new list of Person objects, ensuring each name appears only once. If there are multiple persons with the same name, only include the first person encountered with that name in the output list.
# Maintain the order of persons as they appear in the input list.

class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

def find_unique_persons(people):
    seen_names = set()
    unique_persons = []

    for person in people:
        if person.name not in seen_names:
            seen_names.add(person.name)
            unique_persons.append(person)

    return unique_persons

# Example usage:
person1 = Person("Alice", 30)
person2 = Person("Bob", 25)
person3 = Person("Alice", 35)
person4 = Person("Charlie", 40)

people = [person1, person2, person3, person4]

unique_persons = find_unique_persons(people)
for person in unique_persons:
    print(f"Name: {person.name}, Age: {person.age}")
