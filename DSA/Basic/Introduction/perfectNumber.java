/*
 * Problem Description
You are given an integer A. You have to tell whether it is a perfect number or not.
Perfect number is a positive integer which is equal to the sum of its proper positive divisors.
A proper divisor of a natural number is the divisor that is strictly less than the number.

Problem Constraints
1 <= A <= 106
Input Format
First and only argument contains a single positive integer A.
Output Format
Return 1 if A is a perfect number and 0 otherwise.

Example Input
Input 1:
A = 4
Input 2:
A = 6

Example Output
Output 1:
0 
Output 2:
1 

Example Explanation
Explanation 1:
For A = 4, the sum of its proper divisors = 1 + 2 = 3, is not equal to 4.
Explanation 2:
For A = 6, the sum of its proper divisors = 1 + 2 + 3 = 6, is equal to 6.
 */
package DSA.Basic.Introduction;
/*Approach:
1. Check if A is less than or equal to 1. If true, return 0.
2. Initialize an integer variable sum to 1 (since 1 is a proper divisor of all positive integers greater than 1).
3. Iterate from 2 to the square root of A.
4. For each i, check if A % i == 0 (i.e., if i is a divisor of A).
5. If true, add i to sum.
6. If i is not equal to A / i, add A / i to sum.
7. Check if sum is equal to A, If true, return 1, else return 0.
 */
public class perfectNumber {
    public int solve(int A) {
        if (A <= 1) {
            return 0;
        }
        int sum = 1; // Start with 1 since 1 is a proper divisor of all positive integers greater than 1
        // Iterate from 2 to sqrt(A) to find proper divisors
        for (int i = 2; i * i <= A; i++) {
            if (A % i == 0) {
                sum += i;
                if (i != A / i) {
                    sum += A / i;
                }
            }
        }
        // Check if the sum of proper divisors is equal to the number
        if (sum == A) {
            return 1;
        } else {
            return 0;
        }
    }
}
