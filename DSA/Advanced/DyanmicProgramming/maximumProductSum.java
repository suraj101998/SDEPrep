package DSA.Advanced.DyanmicProgramming;
/*
 * Problem Description

Given an integer array A of size N. Find the contiguous subarray within the given array (containing at least one number) which has the largest product.

Return an integer corresponding to the maximum product possible.

NOTE: Answer will fit in 32-bit integer value.



Problem Constraints

1 <= N <= 5 * 105

-100 <= A[i] <= 100



Input Format

First and only argument is an integer array A.



Output Format

Return an integer corresponding to the maximum product possible.



Example Input

Input 1:

 A = [4, 2, -5, 1]
Input 2:

 A = [-3, 0, -5, 0]


Example Output

Output 1:

 8
Output 2:

 0


Example Explanation

Explanation 1:

 We can choose the subarray [4, 2] such that the maximum product is 8.
Explanation 2:

 0 will be the maximum product possible.
 */
public class maximumProductSum {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProduct(final int[] A) {
        int max_ending_here = A[0];
        int min_ending_here = A[0];
        int max_so_far = A[0];
        for (int i = 1; i < A.length; i++) {
            // If the current element is negative, swap max and min because
            // multiplying a negative number can turn the min into max and vice versa
            if (A[i] < 0) {
                int temp = max_ending_here;
                max_ending_here = min_ending_here;
                min_ending_here = temp;
            }
            max_ending_here = Math.max(A[i], max_ending_here * A[i]);
            min_ending_here = Math.min(A[i], min_ending_here * A[i]);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }    
}
