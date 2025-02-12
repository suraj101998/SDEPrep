package DSA.Advanced.InterviewProblems;
/*Problem Description
Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.
If such arrangement is not possible, it must be rearranged as the lowest possible order, i.e., sorted in ascending order.
NOTE:
The replacement must be in-place, do not allocate extra memory.
DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.

Problem Constraints
1 <= N <= 5 * 10^5
1 <= A[i] <= 10^9

Input Format
The first and the only argument of input has an array of integers, A.

Output Format
Return an array of integers, representing the next permutation of the given array.

Example Input
Input 1:
 A = [1, 2, 3]

Input 2:
 A = [3, 2, 1]

Example Output
Output 1:
 [1, 3, 2]

Output 2:
 [1, 2, 3]

Example Explanation
Explanation 1:
 Next permutaion of [1, 2, 3] will be [1, 3, 2].

Explanation 2:
 No arrangement is possible such that the number are arranged into the numerically next greater permutation of numbers.
 So will rearranges it in the lowest possible order.
*/

import java.util.Arrays;

public class NextPermutation {
    public static int[] nextPermutation(int[] A) {
        int N =A.length;
        int i= N-2;
        while (i>=0 && A[i] >= A[i+1]){
            i--;
        }
        if (i>=0){
            int j =N-1;
            while(A[j]<=A[i]){
                j--;
            }
            swap (A,i,j);
        }
        reverse (A, i+1, N-1);
        return A;
    }
    public static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i]= A[j];
        A[j]= temp;
    }
    public static void reverse(int[] A, int start, int end){
        while(start < end){
            swap(A,start,end);
            start++;
            end--;
        }
    }
    public static void main(String[] args){
        int[] A ={1, 2, 3};
        int[] result = nextPermutation(A);
        System.out.println("ans: "+Arrays.toString(result));
    }
}
