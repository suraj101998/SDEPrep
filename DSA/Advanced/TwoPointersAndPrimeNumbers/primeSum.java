package DSA.Advanced.TwoPointersAndPrimeNumbers;
/*
 * Problem Description

Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.







If there is more than one solution possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then 
[a, b] < [c, d], If a < c OR a==c AND b < d. 
NOTE: A solution will always exist. Read Goldbach's conjecture.








Problem Constraints

4 <= A <= 2*107



Input Format

First and only argument of input is an even number A.



Output Format

Return a integer array of size 2 containing primes whose sum will be equal to given number.



Example Input

 4


Example Output

 [2, 2]


Example Explanation

 There is only 1 solution for A = 4.
 */
import java.util.*;
public class primeSum {
    public int[] primesum(int A) {
        boolean[] isPrime = new boolean[A + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;  // 0 and 1 are not prime
        for (int i = 2; i * i <= A; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= A; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= A / 2; i++) {
            if (isPrime[i] && isPrime[A - i]) {
                return new int[]{i, A - i};
            }
        }
        return new int[]{};
    }
}
