package PracticeProblems.DSA.TwoPointers;
/*
 * Problem Description
Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
Assume that no characters are repeated.
Note: The answer might not fit in an integer, so return your answer % 1000003

Problem Constraints
1 <= |A| <= 1000

Input Format
First argument is a string A.

Output Format
Return an integer denoting the rank of the given string.

Example Input
Input 1:
A = "acb"
Input 2:
A = "a"

Example Output
Output 1:
2
Output 2:
1

Example Explanation
Explanation 1:
Given A = "acb".
The order permutations with letters 'a', 'c', and 'b' : 
abc
acb
bac
bca
cab
cba
So, the rank of A is 2.

Explanation 2:
Given A = "a".
Rank is clearly 1.
 */
public class sortedPermutationRank {
    private static final int MOD = 1000003;
    private long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = (fact * i) % MOD;
        }
        return fact;
    }
    public int findRank(String A) {
        int n = A.length();
        long rank = 1;
        long[] fact = new long[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        for (int i = 0; i < n; i++) {
            int smallerChars = 0;
            for (int j = i + 1; j < n; j++) {
                if (A.charAt(j) < A.charAt(i)) {
                    smallerChars++;
                }
            }
            rank = (rank + (smallerChars * fact[n - i - 1]) % MOD) % MOD;
        }
        return (int) rank;
    }
}
