package DSA.Advanced.DyanmicProgramming;

import java.util.Scanner;

/*
 * Problem Description

Given a positive integer A, write a program to find the Ath Fibonacci number.

In a Fibonacci series, each term is the sum of the previous two terms and the first two terms of the series are 0 and 1. i.e. f(0) = 0 and f(1) = 1. Hence, f(2) = 1, f(3) = 2, f(4) = 3 and so on.

NOTE: 0th term is 0. 1th term is 1 and so on.



Problem Constraints

0 <= A <= 44



Input Format

First and only argument is an integer A.



Output Format

Return an integer denoting the Ath Fibonacci number.



Example Input

Input 1:

 A = 4
Input 2:

 A = 6


Example Output

Output 1:

 3
Output 2:

 8


Example Explanation

Explanation 1:

 Terms of Fibonacci series are: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
 0th term is 0 So, 4th term of Fibonacci series is 3. 
Explanation 2:

 6th term of Fibonacci series is 8.
 */
public class fibonacci {
    public static int fibo(int A){
        // Base cases
        if (A == 0) {
            return 0;
        }
        if (A == 1) {
            return 1;
        }
        // Variables to store the previous two Fibonacci numbers
        int prev2 = 0, prev1 = 1;
        // Calculating Fibonacci number iteratively
        for (int i = 2; i <= A; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
    public static void main(String[] args) {
        int A = 8;
        int result = fibo(A);
        System.out.println("ans: "+result);
    }    
}
