package DSA.Basic.InterviewProblems;
// Problem Description
// You are given two lowercase strings A and B each of length N. Return 1 if they are anagrams to each other and 0 if not.

// Note : Two strings A and B are called anagrams to each other if A can be formed after rearranging the letters of B.


// Problem Constraints
// 1 <= N <= 105
// A and B are lowercase strings


// Input Format
// Both arguments A and B are a string.


// Output Format
// Return 1 if they are anagrams and 0 if not


// Example Input
// Input 1:
// A = "cat"
// B = "bat"
// Input 2:
// A = "secure"
// B = "rescue"


// Example Output
// Output 1:
// 0
// Output 2:
// 1


// Example Explanation
// For Input 1:
// The words cannot be rearranged to form the same word. So, they are not anagrams.
// For Input 2:
// They are an anagram.

public class checkAnagrams {
    public int solve(String A, String B) {
        //if length of both the strings are not equal, then they are not anagram
        if(A.length() != B.length()){
            return 0;
        }
        int[] count = new int[26];

        //count characters in A and B 
        for(int i=0; i<A.length(); i++){
            count[A.charAt(i) - 'a']++;
            count[B.charAt(i) - 'a']--;
        }

        //check if all counts are 0
        for(int i=0; i<26; i++){
            if(count[i] != 0){
                return 0;
            }
        }
        return 1;
    }
}
