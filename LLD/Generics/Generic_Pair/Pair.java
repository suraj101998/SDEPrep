package LLD.Generics.Generic_Pair;
/*
 * Generic Pair Class Implementation
Problem Statement
Design and implement a generic class named Pair that encapsulates a pair of values, where these values can be of any type. The class should provide mechanisms to store two values of generic types and methods to access these values. Ensure your implementation is generic enough to support pairs of different types.

Instructions
Declare two private instance variables within the Pair class to store the pair values. The types of these variables should be generic, allowing for any object type.
Implement a constructor for the Pair class that initializes the pair with two values. The constructor should accept two parameters corresponding to the types of the pair values.
Implement methods getFirst() and getSecond() within the Pair class to retrieve the first and second values of the pair, respectively.
 */
public class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second){
        this.first = first;
        this.second = second;
    }

    public T getFirst(){
        return first;
    }

    public U getSecond(){
        return second;
    }

    public static void main(String[] args) {
        // Create an instance of the 'Pair' class with Integer and String values
        Pair<Integer, String> intStringPair = new Pair<>(10, "Hello");
        System.out.println("Integer-String Pair: " + intStringPair.getFirst() + ", " + intStringPair.getSecond());

        // Pair with a String and a Double
        Pair<String, Double> stringDoublePair = new Pair<>("Pi", 3.14);
        System.out.println("String-Double Pair: " + stringDoublePair.getFirst() + ", " + stringDoublePair.getSecond());

        // Create an instance of the 'Pair' class with Boolean values
        Pair<Boolean, Boolean> booleanPair = new Pair<>(true, false);
        System.out.println("Boolean Pair: " + booleanPair.getFirst() + ", " + booleanPair.getSecond());

        // Pair with null values
        Pair<String, String> nullPair = new Pair<>(null, null);
        System.out.println("Pair with nulls: " + nullPair.getFirst() + ", " + nullPair.getSecond());

        // Pair with Integer boundary values
        Pair<Integer, Integer> boundaryPair = new Pair<>(Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("Integer Boundary Pair: " + boundaryPair.getFirst() + ", " + boundaryPair.getSecond());
    }
}
