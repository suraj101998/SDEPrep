package DSA.Advanced.BitManipulation;
/*Problem Description
Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
Find the two integers that appear only once.
Note: Return the two numbers in ascending order.

Problem Constraints
2 <= |A| <= 100000
1 <= A[i] <= 109

Input Format
The first argument is an array of integers of size N.

Output Format
Return an array of two integers that appear only once.

Example Input
Input 1:
A = [1, 2, 3, 1, 2, 4]

Input 2:
A = [1, 2]

Example Output
Output 1:
[3, 4]

Output 2:
[1, 2]

Example Explanation
Explanation 1:
3 and 4 appear only once.

Explanation 2:
1 and 2 appear only once.
*/

import java.util.Arrays;

public class singleNumberIII {
    public static int[] solve(int[] A) {
        int N = A.length;
        int val =0;
        for( int i =0; i<N; i++){
            val = val ^ A[i];
        }
        int pos =0;
        for(int i=0; i<32; i++){
            if((val & (1<<i)) != 0){
                pos=i;
                break;
            }
        }
        int s1=0, s2=0;
        for(int i=0; i<N; i++){
            if((A[i] & (1<<pos)) == 0){
                s1 = s1 ^ A[i];
            }
            else{
                s2 = s2 ^ A[i];
            }
        }
        if (s1 > s2) {
            return new int[]{s2, s1};
        } else {
            return new int[]{s1, s2};
        }
    }
    public static void main(String[] args){
        int[] A = {1, 2, 3, 1, 2, 4};
        int[] result = solve(A);
        System.out.println("ans: "+Arrays.toString(result));
    }
}
