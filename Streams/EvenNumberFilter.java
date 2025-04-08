package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class EvenNumberFilter {

    public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                      .filter(n -> n % 2 == 0) // Keep even numbers
                      .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNumbers = filterEvenNumbers(inputList);

        System.out.println("Even Numbers: " + evenNumbers);
    }
}

