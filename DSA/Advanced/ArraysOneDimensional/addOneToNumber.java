package DSA.Advanced.ArraysOneDimensional;
/*Problem Description
Given a non-negative number represented as an array of digits, 
add 1 to the number ( increment the number represented by the digits ).
The digits are stored such that the most significant digit is at the head of the list.
NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. 
For example: for this problem, the following are some good questions to ask :

Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
A: For the purpose of this question, YES
Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.

Problem Constraints
1 <= size of the array <= 1000000

Input Format
First argument is an array of digits.

Output Format
Return the array of digits after adding one.

Example Input
Input 1:
[1, 2, 3]

Example Output
Output 1:
[1, 2, 4]

Example Explanation
Explanation 1:
Given vector is [1, 2, 3].
The returned vector should be [1, 2, 4] as 123 + 1 = 124.
*/

import java.util.Arrays;

public class addOneToNumber {
    public static int[] plusOne(int[] A) {
        int n = A.length;
        for (int i = n - 1; i >= 0; i--) {
            // If the current digit is less than 9, just add 1 and return
            if (A[i] < 9) {
                A[i]++;
                int start = 0;
                while (start < n && A[start] == 0) {
                    start++;
                }
                if (start == n) {
                    return new int[] { 0 };
                }
                int[] result = new int[n - start];
                for (int j = start; j < n; j++) {
                    result[j - start] = A[j];
                }
                return result;
            }
            // If the current digit is 9, set it to 0
            A[i] = 0;
        }
        // If all the digits were 9, we need to add a new digit at the beginning. eg: 999+1 = 1000
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
    public static void main(String[] args) {
      int[] A= {9, 9, 9};
      int[] result = plusOne(A);
      System.out.println("ans : "+Arrays.toString(result));
    }
}
