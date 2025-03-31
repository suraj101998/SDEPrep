package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class evenElementFrequency {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 3, 4, 8, 8};

        // Convert array to a list
        List<Integer> numbers = Arrays.stream(arr).boxed().collect(Collectors.toList());

        // Filter even numbers and count occurrences
        Map<Integer, Long> evenFrequencyMap = numbers.stream()
                .filter(n -> n % 2 == 0)  // Filter even numbers
                .collect(Collectors.groupingBy(n -> n, Collectors.counting())); // Count occurrences

        // Print the even numbers with their frequency
        evenFrequencyMap.forEach((key, value) -> 
            System.out.println("Even Number: " + key + ", Count: " + value));
    }
}