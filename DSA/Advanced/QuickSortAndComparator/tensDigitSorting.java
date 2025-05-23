package DSA.Advanced.QuickSortAndComparator;
/*
Problem Description
Given an array A of N integers. Sort the array in increasing order of the value at the tens place digit of every number.
If a number has no tens digit, we can assume value to be 0.
If 2 numbers have same tens digit, in that case number with max value will come first
Solution should be based on comparator.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^9

Input Format
First argument A is an array of integers.

Output Format
Return the array after sorting

Example Input
Input 1:
A = [15, 11, 7, 19]

Input 2:
A = [2, 24, 22, 19]

Example Output
Output 1:
[7, 19, 15, 11]

Output 2:
[2, 19, 24, 22]

Example Explanation
For Input 1:
The sorted order is [7, 19, 15, 11]. The tens digit of 7 is 0, 
and that of 19, 15 and 11 is 1.

For Input 2:
The sorted order is [2, 19, 24, 22]. The tens digit of 2 is 0, 
that of 19 is 1 and that of 22 and 24 is 2.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;

public class tensDigitSorting {
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        Comparator<Integer> customComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int tensA = (a / 10) % 10;
                int tensB = (b / 10) % 10;
                // Compare by tens digit first
                if (tensA != tensB) {
                    return Integer.compare(tensA, tensB);
                }
                // If tens digits are the same, compare by value in descending order
                return Integer.compare(b, a);
            }
        };
        Collections.sort(A, customComparator);
        return A;
    }
    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(15, 11, 7, 19));
        ArrayList<Integer> result = solve(A);
        System.out.println("ans: "+result);
    }
}
