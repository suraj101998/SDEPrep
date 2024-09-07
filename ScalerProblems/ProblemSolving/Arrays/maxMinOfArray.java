/*Problem Description
Given an array A of size N. You need to find the sum of Maximum and Minimum element in the given array.
Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109

Input Format
First argument A is an integer array.

Output Format
Return the sum of maximum and minimum element of the array

Example Input
Input 1:
A = [-2, 1, -4, 5, 3]
Input 2:
A = [1, 3, 4, 1]

Example Output
Output 1:
1
Output 2:
5

Example Explanation
Explanation 1:
Maximum Element is 5 and Minimum element is -4. (5 + (-4)) = 1. 
Explanation 2:
Maximum Element is 4 and Minimum element is 1. (4 + 1) = 5.
 */
package ScalerProblems.ProblemSolving.Arrays;

import java.util.ArrayList;
/*Approach:
1. Check if A is null or if its size is 0. If true, return 0.
2. Initialize maxElement to Integer.MIN_VALUE and minElement to Integer.MAX_VALUE. iterate over the elements of A.
3. For each element num in A: If num is greater than maxElement, update maxElement to num. If num is less than minElement, update minElement to num.
4. Return the sum of maxElement and minElement.
 */
public class maxMinOfArray {
        public int solve(ArrayList<Integer> A) {
        if (A == null || A.size() == 0) {
            return 0; // Edge case: empty array
        }
        int maxElement = Integer.MIN_VALUE;
        int minElement = Integer.MAX_VALUE;
        // Traverse the array to find max and min elements
        for (int num : A) {
            if (num > maxElement) {
                maxElement = num;
            }
            if (num < minElement) {
                minElement = num;
            }
        }
        // Return the sum of max and min elements
        return maxElement + minElement;
    }
}
