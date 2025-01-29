package DSA.Basic.Strings;
// Problem Description
// You are given a function isalpha() consisting of a character array A.

import java.util.ArrayList;

// Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z, and 0-9) else, return 0.



// Problem Constraints
// 1 <= |A| <= 105



// Input Format
// Only argument is a character array A.



// Output Format
// Return 1 if all the characters of the character array are alphanumeric (a-z, A-Z and 0-9), else return 0.



// Example Input
// Input 1:

//  A = ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0']
// Input 2:

//  A = ['S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']


// Example Output
// Output 1:

//  1
// Output 2:

//  0


// Example Explanation
// Explanation 1:

//  All the characters are alphanumeric.
// Explanation 2:

//  All the characters are NOT alphabets i.e ('#').

public class isAlphanumeric {
        public int solve(ArrayList<Character> A) {
        for (Character c : A) {
            if (!Character.isLetterOrDigit(c)) {
                return 0; // Return 0 if any character is not alphanumeric
            }
        }
        return 1; // Return 1 if all characters are alphanumeric
    }
}
