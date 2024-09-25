/*
Problem Description
Given an array A of N integers. 
Count the number of elements that have at least 1 elements greater than itself.
Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109

Input Format
First and only argument is an array of integers A.

Output Format
Return the count of elements.

Example Input
Input 1:
A = [3, 1, 2]
Input 2:
A = [5, 5, 3]

Example Output
Output 1:
2
Output 2:
1

Example Explanation
Explanation 1:
The elements that have at least 1 element greater than itself are 1 and 2
Explanation 2:
The elements that have at least 1 element greater than itself is 3
 */
package PracticeProblems.ProblemSolving.Arrays;

import java.util.ArrayList;

/*Approach:
1. Check if N is 0. If true, return 0. Initialize maxElement and secondMax to Integer.MIN_VALUE.
2. iterate over the elements of A from index 0 to N - 1. 
3. check if the current element is greater than maxElement. If true, update secondMax to maxElement and maxElement to the current element. else, check if the current element is greater than secondMax. If true, update secondMax to the current element.
4. Initialize an integer variable count to 0. iterate over the elements of A from index 0 to N - 1.
5. check if the current element is less than maxElement. If true, increment count by 1. Return count.
 */
public class elementCount {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        if (N == 0) {
            return 0;
        }
        int maxElement = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        // Find the maximum and second maximum elements
        for (int i = 0; i < N; i++) {
            if (A.get(i) > maxElement) {
                secondMax = maxElement;
                maxElement = A.get(i);
            } else if (A.get(i) > secondMax) {
                secondMax = A.get(i);
            }
        }
        // Count elements that have at least one element greater than themselves
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (A.get(i) < maxElement) {
                count++;
            }
        }
        return count;
    }    
}
