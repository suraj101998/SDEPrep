package DSA.Advanced.DyanmicProgramming;
/*
 * Problem Description
Given a 2 x N grid of integers, A, your task is to choose numbers from the grid such that sum of these numbers is maximized. 
However, you cannot choose two numbers that are adjacent horizontally, vertically, or diagonally. 
Return the maximum possible sum.
Note: You are allowed to choose more than 2 numbers from the grid.

Problem Constraints
1 <= N <= 20000
1 <= A[i] <= 2000

Input Format
The first and the only argument of input contains a 2d matrix, A.

Output Format
Return an integer, representing the maximum possible sum.

Example Input
Input 1:
 A = [   
        [1]
        [2]    
     ]

Input 2:
 A = [   
        [1, 2, 3, 4]
        [2, 3, 4, 5]    
     ]

Example Output
Output 1:
 2
Output 2:
 8

Example Explanation

Explanation 1:
 We will choose 2 (From 2nd row 1st column).
Explanation 2:
 We will choose 3 (From 2nd row 2nd column) and 5 (From 2nd row 4th column).
 */

public class maxSumWithoutAdjacentElement {
    public int adjacent(int[][] A) {
        int n = A[0].length;
        // Handle base case where there's only one column
        if (n == 1) {
            return Math.max(A[0][0], A[1][0]);
        }
        // Initializing prev1 and prev2 for the first column
        int prev1 = Math.max(A[0][0], A[1][0]);
        int prev2 = Math.max(A[0][1], A[1][1]);
        // Loop through from column 2 to n-1
        for (int i = 2; i < n; i++) {
            int current = Math.max(prev2, Math.max(prev1 + A[0][i], prev1 + A[1][i]));
            prev1 = prev2;  // Update prev1
            prev2 = current;  // Update prev2
        }
        // Return the result from prev2, which holds the maximum sum
        return prev2;
    }    
}
