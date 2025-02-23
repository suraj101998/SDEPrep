package LLD.Collections.genericComaprision;
/*
 * Generic Comparison
Problem Statement
Implement a generic method named compare that can compare two objects of any type that supports comparison (i.e., any type that implements the Comparable interface). This method should leverage the objects' compareTo method to perform the comparison.

Instructions
Create a generic method compare within a class named GenericComparison.
The method should take two parameters of the same type and return the result of comparing the two.
Ensure the objects passed as parameters implement the Comparable interface.
 */
public class GenericComparision {
    public static <T extends Comparable<T>> int compare(T obj1, T obj2) {
        return obj1.compareTo(obj2);
    }


    public static void main(String[] args) {
        
        int resultInt1 = compare(5, 10);
        System.out.println("Comparison result for integers: " + resultInt1);

        int resultInt2 = compare(-33, -33);
        System.out.println("Comparison result for integers: " + resultInt2);

        int resultStr1 = compare("apple", "banana");
        System.out.println("Comparison result for strings: " + resultStr1);

        int resultStr2 = compare("mango", "banana");
        System.out.println("Comparison result for strings: " + resultStr2);

        int resultStr3 = compare("mango", "mango");
        System.out.println("Comparison result for strings: " + resultStr3);

        int resultDouble = compare(10.5, 10.5);
        System.out.println("Comparison result for doubles: " + resultDouble);

        int resultChar = compare('a', 'b');
        System.out.println("Comparison result for characters: " + resultChar);
    }
}
