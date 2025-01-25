package DSA.Basic.Introduction;
/*
Problem No- 9
Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Constraints:
-231 <= x <= 231 - 1
 */


public class isPalindromeNumber {
    public boolean isPalindrome(int x) {
        int reverseNum= 0;
        int tempNum = x;
        while (tempNum>0){
            int lastDigit = tempNum % 10;
            reverseNum = reverseNum*10+ lastDigit;
            tempNum=tempNum/10;
        }
        if (x==reverseNum){
            return true;
        }
        return false;
    }
}
