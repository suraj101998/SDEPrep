package LeetCode;
/*
Problem No- 345
Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:
Input: s = "hello"
Output: "holle"

Example 2:
Input: s = "leetcode"
Output: "leotcede"
 
Constraints:
1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
 */


public class reverseStringVowels {
    public String reverseVowels(String s) {
        boolean[] vowels = new boolean[128];
        for (char c: "aeiouAEIOU".toCharArray()){
            vowels[c] = true;
        }
        char[] cs =s.toCharArray();
        int i =0,j=cs.length-1;
        while(i<j){
            while(i<j && !vowels[cs[i]]){
                ++i;
            }
            while(i<j && !vowels[cs[j]]){
                --j;
            }
            if(i<j){
                char t =cs[i];
                cs[i]=cs[j];
                cs[j]=t;
                ++i;
                --j;
            }
        }
         return String.valueOf(cs);
    }
}
