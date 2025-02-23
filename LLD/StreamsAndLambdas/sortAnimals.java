package LLD.StreamsAndLambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Sorting using Streams - Sort Animals
Problem Statement
You are given a list of strings which stores the names of animals. Your task is to use streams and lambdas to sort the given list according to the length of the strings in descending order of length.

If two or more strings have the same size then return in the order in which they exist in the original list.

Instructions
Implement the sortAnimalsByLengthDescending method inside the AnimalSorter class
You need to use streams and Lambdas for doing the operation.
If the size of the given list is 0 then return an empty list.
 */
public class sortAnimals {
    public static List<String> sortAnimalsByLengthDescending(List<String> animals) {
        return animals.stream()
        .sorted((a,b) -> Integer.compare(b.length(), a.length()))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> animals = Arrays.asList("zebra", "lion", "tiger", "elephant", "giraffe");
        List<String> sortedAnimals = sortAnimalsByLengthDescending(animals);
        System.out.println(sortedAnimals);

        animals = Arrays.asList("cat","dog","animal-x","elephant","mouse");
        sortedAnimals = sortAnimalsByLengthDescending(animals);
        System.out.println(sortedAnimals);

        animals = Arrays.asList();
        sortedAnimals = sortAnimalsByLengthDescending(animals);
        System.out.println(sortedAnimals);

        animals = Arrays.asList("a","b","d","c","a");
        sortedAnimals = sortAnimalsByLengthDescending(animals);
        System.out.println(sortedAnimals);
    }
}
