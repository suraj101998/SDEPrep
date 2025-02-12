package DSA.Advanced.InterviewProblems;
/*Problem Description
Given an integer A, find and return the total number of digit 1 appearing in all non-negative integers less than or equal to A.

Problem Constraints
0 <= A <= 10^9

Input Format
The only argument given is the integer A.

Output Format
Return the total number of digit 1 appearing in all non-negative integers less than or equal to A.

Example Input
Input 1:
 A = 10

Input 2:
 A = 11

Example Output
Output 1:
 2

Output 2:
 4

Example Explanation
Explanation 1:
Digit 1 appears in 1 and 10 only and appears one time in each. So the answer is 2.

Explanation 2:
Digit 1 appears in 1(1 time) , 10(1 time) and 11(2 times) only. So the answer is 4.
*/
public class numberOfDigitOne {
    public static int solve(int A) {
        int count =0, factor=1;
        int n=A;
        while (factor<=n){
            int lowerNumber = n - (n/factor) * factor;
            int higherNumber = n / (factor*10);
            int currentDigits = (n/factor) % 10;
            if (currentDigits ==0){
                count += higherNumber * factor;
            }else if(currentDigits ==1){
                count += higherNumber * factor + lowerNumber + 1;
            }else{
                count += (higherNumber + 1) * factor;
            }
            factor *= 10;
        }
        return count;
    }
    public static void main(String[] args){
        int A = 11;
        int result = solve(A);
        System.out.println("ans: "+result);
    }
}
