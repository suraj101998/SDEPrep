package ScalerProblems.DSA.QuickSortAndComparator;
// Problem Description
// Given an array A of non-negative integers, arrange them such that they form the largest number.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Note: The result may be very large, so you need to return a string instead of an integer.
// Problem Constraints
// 1 <= len(A) <= 100000
// 0 <= A[i] <= 2*109

// Input Format
// The first argument is an array of integers.

// Output Format
// Return a string representing the largest number.

// Example Input
// Input 1:
//  A = [3, 30, 34, 5, 9]

// Input 2:
//  A = [2, 3, 9, 0]

// Example Output
// Output 1:
//  "9534330"

// Output 2:
//  "9320"

// Example Explanation
// Explanation 1:
// Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.

// Explanation 2:
// Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.

public class largestNumber {
        public String largestNumbers(int[] A) {
        ArrayList<String> numbers = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            String numStr = String.valueOf(num);
            numbers.add(numStr);
        }
        Collections.sort(numbers, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                if (order2.compareTo(order1) > 0) {
                    return 1;
                } else if (order2.compareTo(order1) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        if (numbers.get(0).equals("0")) {
            return "0";
        }
        StringBuilder largestNumber = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            String num = numbers.get(i);
            largestNumber.append(num);
        }
        return largestNumber.toString();
    }
}
