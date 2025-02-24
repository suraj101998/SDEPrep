package CodingInterview;
/*
IVY Technologies

Count Binary Substrings

Given a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
Substrings that occur multiple times are counted the number of times they occur.

Example 1:

Input: s = "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
Notice that some of these substrings repeat and are counted the number of times they occur.
Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
Example 2:

Input: s = "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.

*/

import java.util.*;
class countBinarySubstrings {
    public int solution(String s) {
        int i = 0, n = s.length();
        List<Integer> t = new ArrayList<>();
        while (i < n) {
            int cnt = 1;
            while (i + 1 < n && s.charAt(i + 1) == s.charAt(i)) {
                ++i;
                ++cnt;
            }
            t.add(cnt);
            ++i;
        }
        int ans = 0;
        for (i = 1; i < t.size(); ++i) {
            ans += Math.min(t.get(i - 1), t.get(i));
        }
        return ans;
    }
}