package LLD.Generics;
/*
 * Generic Array Printing Method

Develop a generic method named printArray within a class named PrintArrayElements. This method should be capable of printing the elements of any array, regardless of its data type, to the console. Each element should be followed by a space, and no newline character should be printed after the last element. The purpose of this assignment is to familiarize you with generics in Java, allowing you to work with arrays of different types using a single method.

Instructions
Inside the PrintArrayElements class, implement the printArray method. This method should be generic, enabling it to accept an array of any type as its parameter.
The method should iterate through the array and print each element followed by a space. Ensure that no newline character is printed after the last element of the array.
 */
public class PrintArrayElements {
    public static <T> void printArray(T[] array) {
        for(T element : array){
            System.out.print(element +" ");
        }
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};
        String[] words = {"apple", "banana", "orange"};
        Integer[] emptyArray = {};
        Integer[] singleElement = {42};
        Double[] doubles = {1.1, 2.2, 3.3};
        Character[] characters = {'a', 'b', 'c'};
        Integer[] arrayWithNulls = {1, null, 3};

        
        System.out.print("Numbers: ");
        printArray(numbers);
        System.out.println();

        
        System.out.print("Words: ");
        printArray(words);
        System.out.println();

        
        System.out.print("Empty Array: ");
        printArray(emptyArray);
        System.out.println();

        
        System.out.print("Single Element: ");
        printArray(singleElement);
        System.out.println();

        
        System.out.print("Doubles: ");
        printArray(doubles);
        System.out.println();

        
        System.out.print("Characters: ");
        printArray(characters);
        System.out.println();

        
        System.out.print("Array With Nulls: ");
        printArray(arrayWithNulls);
        System.out.println();
    }
}