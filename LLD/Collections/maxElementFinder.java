package LLD.Collections;
/*
 * Maximum Element Finder Using Bounded Generics
Problem Statement
Develop a method named findMax that utilizes bounded generics to identify and return the maximum element from an array. The elements of the array must implement the Comparable interface, ensuring the method works with any type that has a natural ordering. The method should handle null or empty arrays gracefully, returning null in such cases.

Instructions
Implement the findMax method within the maxElementFinder class. This method should be generic and use bounded generics to restrict its parameters to types that extend the Comparable interface.
The findMax method should accept an array of a generic type that extends Comparable and return the maximum element found in the array.
In the case of a null or empty array, the method should return null without throwing an exception.
 */
public class maxElementFinder {
    public static <T extends Comparable<T>> T findMax(T[] array) {

        if(array == null || array.length ==0){
            return null;
        }
        T maxElement = array[0];
        for(int i=0; i<array.length; i++){
            if(array[i].compareTo(maxElement) > 0){
                maxElement = array[i];
            }
        }
        return maxElement;
    }


    public static void main(String[] args) {
        Integer[] numbers = {4, 7, 1, 9, 3, 5};
        Double[] decimals = {3.14, 2.71, 1.618, 2.718};
        String[] words = {"Apple", "Banana", "Peach", "Orange"};
        Character[] letters = {'a', 'e', 'i', 'o', 'u'};
        Integer[] negativeNumbers = {-1, -3, -7, -4};
        Float[] floatDecimals = {1.0f, 3.14f, -1.618f, 2.718f};

        // Demonstrating max element for each array
        System.out.println("Maximum Integer: " + maxElementFinder.findMax(numbers));
        System.out.println("Maximum Double: " + maxElementFinder.findMax(decimals));
        System.out.println("Maximum String: " + maxElementFinder.findMax(words));
        System.out.println("Maximum Character: " + maxElementFinder.findMax(letters));
        System.out.println("Maximum Negative Integer: " + maxElementFinder.findMax(negativeNumbers));
        System.out.println("Maximum Float: " + maxElementFinder.findMax(floatDecimals));

        // Handling null and empty arrays
        Integer[] nullArray = null;
        Integer[] emptyArray = {};
        System.out.println("Maximum of null array: " + maxElementFinder.findMax(nullArray)); // Expected to be null or throw an exception based on implementation
        System.out.println("Maximum of empty array: " + maxElementFinder.findMax(emptyArray)); // Expected to be null or throw an exception based on implementation
    }
}
