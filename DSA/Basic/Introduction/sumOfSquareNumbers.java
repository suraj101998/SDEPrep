package DSA.Basic.Introduction;
/*
Problem No- 633
Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:
Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5

Example 2:
Input: c = 3
Output: false
 
Constraints:
0 <= c <= 231 - 1
 */


public class sumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        long a=0, b= (long) Math.sqrt(c);
        while(a<=b){
            long s = a*a + b*b;
            if (s==c){
                return true;
            }
            if(s<c){
                ++a;
            }else{
                --b;
            }
        }
        return false;
    }
}
