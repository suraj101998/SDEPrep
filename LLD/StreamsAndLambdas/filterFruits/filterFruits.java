package LLD.StreamsAndLambdas.filterFruits;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Filter Fruits
Problem Statement
You are given a list of strings having different fruit names. You need to filter out the names of the fruits whose name starts from the character A.

Use streams to execute the operations and return a List of String containing the fruit names whose name starts with A.

Instructions
Implement the filterFruitsStartingWithA method inside the FruitFilter class
You need to use Java Streams for doing the operation.
Return the answer in the same order as they appear in the input.
If no name satisfies the criteria then return an empty list.
 */
public class filterFruits {
        public static List<String> filterFruitsStartingWithA(List<String> fruits) {
        return fruits.stream().
        filter(fruit -> fruit.startsWith("A")).
        collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> allFruits = Arrays.asList("Apple", "Banana", "Apricot", "Avocado", "Orange");
        List<String> fruitsStartingWithA = filterFruitsStartingWithA(allFruits);
        System.out.println("Fruits starting with 'A': " + fruitsStartingWithA);

        allFruits = Arrays.asList("Grapes", "Almond", "DragonFruit");
        fruitsStartingWithA = filterFruitsStartingWithA(allFruits);
        System.out.println("Fruits starting with 'A': " + fruitsStartingWithA);

        allFruits = Arrays.asList("Grapes","DragonFruit");
        fruitsStartingWithA = filterFruitsStartingWithA(allFruits);
        System.out.println("Fruits starting with 'A': " + fruitsStartingWithA);
    }
}
