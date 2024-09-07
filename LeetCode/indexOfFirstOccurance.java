package LeetCode;
/*
Problem No- 28
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

Constraints:
1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
 */


public class indexOfFirstOccurance {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        for(int i=0; i<m-n+1;++i){
            if (haystack.substring(i,i+n).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
