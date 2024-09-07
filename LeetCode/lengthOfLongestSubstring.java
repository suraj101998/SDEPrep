package LeetCode;
/*
Problem No- 3
 Given a string s, find the length of the longest 
substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/

// Approach: In this approach, we will make a map that will take care of counting the elements and maintaining the frequency of each and every element as a unity by taking the latest index of every element.

import java.util.*;
class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Map<Character, Integer> hash_map = new HashMap<>();
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (hash_map.containsKey(ch)) {
                i = Math.max(hash_map.get(ch), i);
            }
            result = Math.max(result, j - i + 1);
            hash_map.put(ch, j + 1);
            j++;
        }
        return result;
    }
}