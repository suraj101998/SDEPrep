package DSA.Advanced.BitManipulation;
/*Problem Description
Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.
NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Problem Constraints
1 <= |A| <= 2000000
0 <= A[i] <= INTMAX

Input Format
The first and only argument of input contains an integer array A.

Output Format
Return a single integer denoting the single element.

Example Input
Input 1:
 A = [1, 2, 2, 3, 1]

Input 2:
 A = [1, 2, 2]

Example Output
Output 1:
 3

Output 2:
 1

Example Explanation
Explanation 1:
3 occurs once.

Explanation 2:
1 occurs once.
*/
public class singleNumber {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public static int singleNum(final int[] A) {
            int single = 0;        
            // XOR all the numbers in the array
            for (int i = 0; i < A.length; i++) {
                int currentElement = A[i];
                single = single ^ currentElement;
            }        
            return single;
        }
        public static void main(String[] args){
            int[] A = {1, 2, 2, 3, 1};
            int result = singleNum(A);
            System.out.println("ans: "+result);
        }
}
