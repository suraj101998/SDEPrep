package DSA.Advanced.DyanmicProgramming;
/*
 * Problem Description

Given a M x N grid A of integers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Return the minimum sum of the path.

NOTE: You can only move either down or right at any point in time.



Problem Constraints

1 <= M, N <= 2000

-1000 <= A[i][j] <= 1000



Input Format

First and only argument is a 2-D grid A.



Output Format

Return an integer denoting the minimum sum of the path.



Example Input

Input 1:

 A = [
       [1, 3, 2]
       [4, 3, 1]
       [5, 6, 1]
     ]
Input 2:

 A = [
       [1, -3, 2]
       [2, 5, 10]
       [5, -5, 1]
     ]


Example Output

Output 1:

 8
Output 2:

 -1


Example Explanation

Explanation 1:

 The path will be: 1 -> 3 -> 2 -> 1 -> 1.
Input 2:

 The path will be: 1 -> -3 -> 5 -> -5 -> 1.
 */
public class MinSumPathMatrix {
    public static int minPathSum(int[][] A) {
        int M = A.length;
        int N = A[0].length;
        int[][] dp = new int[M][N];
        dp[0][0] = A[0][0];
        for (int j = 1; j < N; j++) {
            dp[0][j] = dp[0][j - 1] + A[0][j];
        }
        for (int i = 1; i < M; i++) {
            dp[i][0] = dp[i - 1][0] + A[i][0];
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = A[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[M - 1][N - 1];
    } 
    public static void main(String[] args){
        int[][] A = {
            {1, -3, 2},
            {2, 5, 10},
            {5, -5, 1}
        };
        int result = minPathSum(A);
        System.out.println("ans: "+result);

    }   
}
