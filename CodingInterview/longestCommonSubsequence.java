package CodingInterview;
/*
 * Longest Common Subsequence (LCS) using Dynamic Programming. This approach ensures a time complexity of O(m⋅n), where 𝑚 and 𝑛 are the lengths of the two strings.
 */

 public class longestCommonSubsequence {

    // Function to find the length of the Longest Common Subsequence
    public static int findLCS(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // Create a DP table to store lengths of LCS for substrings
        int[][] dp = new int[m + 1][n + 1];

        // Build the DP table bottom-up
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // Characters match, increment LCS length
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Take the maximum LCS by excluding one character
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The bottom-right cell contains the length of LCS
        return dp[m][n];
    }

    // Main method to test the function
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        System.out.println("Length of Longest Common Subsequence: " + findLCS(text1, text2));
    }
}
/* 
Explanation:
Approach:
Use a Dynamic Programming table dp where:
dp[i][j] represents the length of the LCS for the first i characters of text1 and the first j characters of text2.

Base Case:
If either string is empty, the LCS length is 0.
Recursive Relation:
If text1[i - 1] == text2[j - 1], then:
dp[i][j]=dp[i−1][j−1]+1

Otherwise:
dp[i][j]=max(dp[i−1][j],dp[i][j−1])
The result is stored in dp[m][n], where 
𝑚 and 𝑛 are the lengths of the two strings.

Input and Output:
Input: Two strings.
Output: The length of the longest common subsequence.

Example:
Input: text1 = "abcde", text2 = "ace"
Execution:
Initialize dp as a 6×4 table (both strings + 1 for base case).

Fill the table:
Compare characters one by one and build the LCS length.
Result: dp[5][3] = 3, corresponding to the LCS "ace".
Output: 3

Complexity Analysis:
Time Complexity:
Filling the dp table involves m⋅n operations, where 𝑚 and 𝑛 are the lengths of the two strings.
Total: O(m⋅n)

Space Complexity:
The dp table requires O(m⋅n) space.
Total: O(m⋅n)
*/