package DSA.Advanced.InterviewProblems;
/*
 * Problem Description

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message denoted by string A containing digits, determine the total number of ways to decode it modulo 109 + 7.



Problem Constraints

1 <= length(A) <= 105



Input Format

The first and the only argument is a string A.



Output Format

Return an integer, representing the number of ways to decode the string modulo 109 + 7.



Example Input

Input 1:

 A = "12"
Input 2:

 A = "8"


Example Output

Output 1:

 2
Output 2:

 1


Example Explanation

Explanation 1:

 Given encoded message "12", it could be decoded as "AB" (1, 2) or "L" (12).
 The number of ways decoding "12" is 2.
Explanation 2:

 Given encoded message "8", it could be decoded as only "H" (8).
 The number of ways decoding "8" is 1.
 */
public class waysToDecode {
    public int numDecodings(String A) {
        final int MOD = 1000000007;
        int n = A.length();
        
        // Handle edge cases
        if (n == 0 || A.charAt(0) == '0') return 0;

        // DP array to store the number of ways to decode
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: 1 way to decode an empty string
        dp[1] = (A.charAt(0) != '0') ? 1 : 0; // 1 way to decode the first character if it's valid
        
        // Fill DP array
        for (int i = 2; i <= n; i++) {
            int singleDigit = A.charAt(i - 1) - '0'; // Current single digit
            int twoDigit = (A.charAt(i - 2) - '0') * 10 + singleDigit; // Current two digits
            
            // Add ways from single-digit decoding
            if (singleDigit >= 1 && singleDigit <= 9) {
                dp[i] = (dp[i] + dp[i - 1]) % MOD;
            }
            
            // Add ways from two-digit decoding
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] = (dp[i] + dp[i - 2]) % MOD;
            }
        }
        
        // Result is the number of ways to decode the entire string
        return dp[n];
    }    
}
