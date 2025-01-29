package DSA.Advanced.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

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
public class primeSum {
    public int[] primesum(int A) {
        boolean[] isPrime = sieve(A);
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= A; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        int left = 0, right = primes.size() - 1;
        while (left <= right) {
            int sum = primes.get(left) + primes.get(right);
            if (sum == A) {
                return new int[]{primes.get(left), primes.get(right)};
            } else if (sum < A) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1};
    }
    private boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
