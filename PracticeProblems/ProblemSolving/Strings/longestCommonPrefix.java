package PracticeProblems.ProblemSolving.Strings;
// Problem Description
// Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings in the array.

import java.util.ArrayList;

// The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

// Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".



// Problem Constraints
// 0 <= sum of length of all strings <= 1000000



// Input Format
// The only argument given is an array of strings A.



// Output Format
// Return the longest common prefix of all strings in A.



// Example Input
// Input 1:

// A = ["abcdefgh", "aefghijk", "abcefgh"]
// Input 2:

// A = ["abab", "ab", "abcd"];


// Example Output
// Output 1:

// "a"
// Output 2:

// "ab"


// Example Explanation
// Explanation 1:

// Longest common prefix of all the strings is "a".
// Explanation 2:

// Longest common prefix of all the strings is "ab".

public class longestCommonPrefix {
        public String longestCommonPrefix(ArrayList<String> A) {
        if (A == null || A.size() == 0) {
            return "";
        }
        
        // Start with the first string in the array as the initial prefix
        String prefix = A.get(0);
        
        // Compare the prefix with each string in the array
        for (int i = 1; i < A.size(); i++) {
            prefix = commonPrefix(prefix, A.get(i));
            // If at any point the common prefix is empty, we can return early
            if (prefix.isEmpty()) {
                return "";
            }
        }
        
        return prefix;
    }
    
    private String commonPrefix(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        
        // Compare characters up to the length of the shorter string
        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }
        
        // If all characters match up to the length of the shorter string,
        // return the entire shorter string as the common prefix
        return str1.substring(0, minLength);
    }
}
