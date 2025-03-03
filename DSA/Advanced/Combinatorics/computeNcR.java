package DSA.Advanced.Combinatorics;
/*
 * Problem Description
Given three integers A, B, and C, where A represents n, B represents r, and C represents m, find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.

x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

Problem Constraints
1 <= A * B <= 106
1 <= B <= A
1 <= C <= 106

Input Format
The first argument given is integer A ( = n).
The second argument given is integer B ( = r).
The third argument given is integer C ( = m).

Output Format
Return the value of nCr % m.

Example Input
Input 1:
 A = 5
 B = 2
 C = 13

Input 2:
 A = 6
 B = 2
 C = 13

Example Output
Output 1:
 10

Output 2:
 2

Example Explanation
Explanation 1:
 The value of 5C2 % 11 is 10.

Explanation 2:
 The value of 6C2 % 13 is 2.
 */

public class computeNcR {
    public static int solve(int A, int B, int C) {
        // Edge case when B is greater than A, return 0
        if (B > A) {
            return 0;
        }
        // DP table to store nCr % C
        int[][] dp = new int[A + 1][B + 1];
        // Initialize the DP table
        for (int i = 0; i <= A; i++) {
            dp[i][0] = 1; // Base case: iC0 = 1
            for (int j = 1; j <= Math.min(i, B); j++) {
                // Use recursive relation
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % C;
            }
        }
        // The result is dp[A][B], which is ACB % C
        return dp[A][B];
    }
    public static void main(String[] args){
       int A = 5;
       int B = 2;
       int C = 13;
       int result = solve(A, B, C);
       System.out.println("ans: "+result);
    }
}
