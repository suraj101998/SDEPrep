package DSA.Advanced.Combinatorics;
/*
 * Problem Description
Given a positive integer A.
Return the number of ways it can be written as a sum of consecutive positive integers.

Problem Constraints
1 <= A <= 109

Input Format
The first and the only argument of input contains an integer, A.

Output Format
Return an integer, representing the answer as described in the problem statement.

Example Input
Input 1:
 A = 5

Input 2:
 A = 15

Example Output
Output 1:
 2

Output 2:
 4

Example Explanation
Explanation 1:
 The 2 ways are:
 => [5]
 => [2, 3]

Explanation 2:
 The 4 ways are:
 => [15]
 => [7, 8]
 => [4, 5, 6] 
 => [1, 2, 3, 4, 5]
 */

public class consecutiveNumbersSum {
    public static int solve(int A) {
        int count = 0;
        for (int k = 1; k * (k - 1) / 2 < A; k++) {
            int remainder = A - (k * (k - 1)) / 2;
            if (remainder >= 0 && remainder % k == 0) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        int A = 15;
        int result = solve(A);
        System.out.println("ans: "+result);
    }
}
