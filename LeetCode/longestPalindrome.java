package LeetCode;
/*
Problem No- 409
Given a string s which consists of lowercase or uppercase letters, return the length of the longest 
palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome.

Example 1:
Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

Example 2:
Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
 
Constraints:
1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.
 */

 public class longestPalindrome {
    public static int longestPalindromes(String s) {
        int count[] = new int[128];
        int n= s.length();
        int ans = 0;
        for(int i=0; i<n; ++i){
            ++count[s.charAt(i)];
        }
        for (int v: count){
            ans += v/2*2;
        }
        ans += ans < n ? 1:0;
        return ans;
    }
    public static void main(String[] args){
        String s="ijmadampo";
        int result= longestPalindromes(s);
        System.out.println(result);

    }    
}
