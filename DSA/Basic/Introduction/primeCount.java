/*
Problem Description: 
You will be given an integer n. You need to return the count of prime numbers less than or equal to n.

Problem Constraints
0 <= n <= 10^3

Input Format
Single input parameter n in function.

Output Format
Return the count of prime numbers less than or equal to n.

Example Input
Input 1:
19
Input 2:
1

Example Output
Output 1:
8
Output 2:
0

Example Explanation
Explanation 1:
Primes <= 19 are 2, 3, 5, 7, 11, 13, 17, 19
Explanation 2:
There are no primes <= 1
 */

package DSA.Basic.Introduction;

/*Approach:
1. Check if A is less than 2. If true, return 0.
2. Initialize a boolean array isPrime of size A + 1 with all entries set to true.
3. Iterate from 2 to A, setting all isPrime entries to true.
4. Iterate from 2 to the square root of A.
5. For each i, if isPrime[i] is true, mark all multiples of i (starting from i * i) as false.
6. Initialize a variable count to 0.
7. Iterate from 2 to A, incrementing count for each isPrime[i] that is true.
8. Return the value of count.
 */

public class primeCount {
    public int solve(int A) {
        if (A < 2) {
            return 0;
        }
        boolean[] isPrime = new boolean[A + 1];
        // Initialize all entries as true
        for (int i = 2; i <= A; i++) {
            isPrime[i] = true;
        }
        // Implementing Sieve of Eratosthenes
        for (int i = 2; i * i <= A; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= A; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        // Count prime numbers
        int count = 0;
        for (int i = 2; i <= A; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
