package ScalerProblems.ProblemSolving.Strings;
// Problem Description
// Given a string A of size N, find and return the longest palindromic substring in A.

// Substring of string A is A[i...j] where 0 <= i <= j < len(A)

// Palindrome string:
// A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.

// Incase of conflict, return the substring which occurs first ( with the least starting index).



// Problem Constraints
// 1 <= N <= 6000



// Input Format
// First and only argument is a string A.



// Output Format
// Return a string denoting the longest palindromic substring of string A.



// Example Input
// Input 1:
// A = "aaaabaaa"
// Input 2:
// A = "abba


// Example Output
// Output 1:
// "aaabaaa"
// Output 2:
// "abba"


// Example Explanation
// Explanation 1:
// We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
// Explanation 2:
// We can see that longest palindromic substring is of length 4 and the string is "abba".

public class longestPalindromicSubstring {
    public String longestPalindrome(String A) {
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
}
