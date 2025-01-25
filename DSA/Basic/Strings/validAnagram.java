package DSA.Basic.Strings;
/*
Problem No- 248
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false
 
Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 */


import java.util.Arrays;

public class validAnagram {
        public boolean isAnagram(String s, String t) {
        s=s.toLowerCase();
        t=t.toLowerCase();
        if (s.length()!=t.length()){
            return false;
        }else{
            char[] m=s.toCharArray();
            char[] n=t.toCharArray();
            Arrays.sort(m);
            Arrays.sort(n);
            if (Arrays.equals(m,n)==true){
                return true;
            }else{
                return false;
            }
        }
    }    
}
