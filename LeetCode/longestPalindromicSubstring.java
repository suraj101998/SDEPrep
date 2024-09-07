package LeetCode;
/*
Problem No- 5

Given a string s, return the longest palindromic substring in s.
Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
        Example 2:

Input: s = "cbbd"
Output: "bb"

Constraints:

        1 <= s.length <= 1000
s consist of only digits and English letters.
*/


public class longestPalindromicSubstring {

    public static String longestPalindrome(String A) {
        int n = A.length();
        if (n == 0) return "";

        boolean[][] dp = new boolean[n][n];
        int maxLength = 1;
        int start = 0;

        // Every single character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check for palindromes of length 2
        for (int i = 0; i < n - 1; i++) {
            if (A.charAt(i) == A.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for palindromes of length greater than 2
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;

                // Check if the current substring is a palindrome
                if (dp[i + 1][j - 1] && A.charAt(i) == A.charAt(j)) {
                    dp[i][j] = true;
                    if (len > maxLength) {
                        start = i;
                        maxLength = len;
                    }
                }
            }
        }

        return A.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        String A1 = "babad";
        System.out.println(longestPalindrome(A1)); // Output: "aaabaaa"

        String A2 = "cbbd";
        System.out.println(longestPalindrome(A2)); // Output: "abba"
    }
}