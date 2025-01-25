package DSA.Basic.InterviewProblems;
// Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.


// Input Format

// The only argument given is string A.
// Output Format

// Return the length of the longest consecutive 1’s that can be achieved.
// Constraints

// 1 <= length of string <= 1000000
// A contains only characters 0 and 1.
// For Example

// Input 1:
//     A = "111000"
// Output 1:
//     3

// Input 2:
//     A = "111011101"
// Output 2:
//     7
public class longestConsecutiveOnes {
    public int solve(String A) {
        int n = A.length();
        int totalOnes = 0;
        
        // Count total number of 1's in the string
        for (char c : A.toCharArray()) {
            if (c == '1') {
                totalOnes++;
            }
        }

        // If the string is all 1's
        if (totalOnes == n) {
            return totalOnes;
        }

        // Arrays to store cumulative counts of 1's from left and right
        int[] left = new int[n];
        int[] right = new int[n];

        // Fill the left array
        left[0] = A.charAt(0) == '1' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            if (A.charAt(i) == '1') {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 0;
            }
        }

        // Fill the right array
        right[n - 1] = A.charAt(n - 1) == '1' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            if (A.charAt(i) == '1') {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 0;
            }
        }

        // Calculate the maximum length of consecutive 1's
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '0') {
                int leftOnes = i > 0 ? left[i - 1] : 0;
                int rightOnes = i < n - 1 ? right[i + 1] : 0;
                
                int currentLength = leftOnes + rightOnes + 1;
                
                if (leftOnes + rightOnes < totalOnes) {
                    maxLength = Math.max(maxLength, currentLength);
                } else {
                    maxLength = Math.max(maxLength, leftOnes + rightOnes);
                }
            }
        }

        // Check if the whole string has only one '0' or none
        if (totalOnes == 0) {
            return 0;
        }

        // Return the maximum length found
        return maxLength;
    }
}
