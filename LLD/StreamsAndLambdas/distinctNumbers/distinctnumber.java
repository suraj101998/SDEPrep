package LLD.StreamsAndLambdas.distinctNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Distinct Numbers
Problem Statement
You are given a list of integers, and you need to use streams and lambdas to return all the distinct numbers (distinct()) that are present in the given list.

Instructions
Implement the getDistinctNumbers method inside the DistinctNumbers class
You need to use Java Streams and Lambdas for doing the operation.
Return the answer in the same order as they appear in the input.
Hint: use distinct()
 */
public class distinctnumber {
        public static List<Integer> getDistinctNumbers(List<Integer> numbers) {
        return numbers.stream().
        distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 3, 5, 6, 1, 7, 8, 9, 7);
        List<Integer> distinctNumbers = getDistinctNumbers(numbers);
        System.out.println("Distinct numbers: " + distinctNumbers);

        numbers = Arrays.asList(5,5,5,6,6,6,4,4,4);
        distinctNumbers = getDistinctNumbers(numbers);
        System.out.println("Distinct numbers: " + distinctNumbers);

    }
}
