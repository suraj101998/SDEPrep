package DSA.Advanced.TwoPointersAndPrimeNumbers;
/*
 * Problem Description

Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).



Problem Constraints

1 <= |A| <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format

The first argument given is the integer array A.

The second argument given is integer B.



Output Format

Return the number of pairs for which sum is equal to B modulo (10^9+7).



Example Input

Input 1:

A = [1, 1, 1]
B = 2
Input 2:

A = [1, 5, 7, 10]
B = 8


Example Output

Output 1:

 3
Output 2:

 1


Example Explanation

Explanation 1:

 The pairs of A[i] and A[j] which sum up to 2 are (0, 1), (0, 2) and (1, 2).
 There are 3 pairs.
Explanation 2:

 There is only one pair, such that i = 0, and j = 2 sums up to 8.
 */
public class pairsWithGivenSum {
    public int solve(int[] A, int B) {
        int MOD = 1000000007;
        int n = A.length;
        int l = 0, r = n - 1;
        long count = 0;
        while (l < r) {
            int sum = A[l] + A[r];
            if (sum == B) {
                if (A[l] == A[r]) {
                    long freq = r - l + 1;
                    count += (freq * (freq - 1) / 2) % MOD;
                    count %= MOD;
                    break;
                }
                else {
                    int leftCount = 1, rightCount = 1;
                    while (l + 1 < r && A[l] == A[l + 1]) {
                        leftCount++;
                        l++;
                    }
                    while (r - 1 > l && A[r] == A[r - 1]) {
                        rightCount++;
                        r--;
                    }
                    count += (leftCount * (long)rightCount) % MOD;
                    count %= MOD;
                    
                    l++;
                    r--;
                }
            }
            else if (sum < B) {
                l++;
            }
            else {
                r--;
            }
        }
        return (int) count;
    }
}
