/*
Problem Description
You are given an integer array A. You have to find the second largest element/value in the array or report that no such element exists.
Problem Constraints
1 <= |A| <= 105
0 <= A[i] <= 109

Input Format
The first argument is an integer array A.

Output Format
Return the second largest element. If no such element exist then return -1.

Example Input
Input 1:
 A = [2, 1, 2] 
Input 2:
 A = [2]

Example Output
Output 1:
 1 
Output 2:
 -1 


Example Explanation
Explanation 1:
First largest element = 2
Second largest element = 1
Explanation 2:
There is no second largest element in the array.
 */
package ScalerProblems.ProblemSolving.Arrays;
import java.util.ArrayList;

/*Approach:
1. Check if the size of A is less than 2. If true, return -1.
2. Initialize first and second to Integer.MIN_VALUE. iterate over the elements of A from index 0 to A.size() - 1.
3. for each element num: If num is greater than first, update second to first and first to num. Otherwise, if num is greater than second and not equal to first, update second to num.
4. If second is still Integer.MIN_VALUE, return -1 else Return the value of second.
 */
public class secondLargest {
    public int solve(ArrayList<Integer> A) {
        if (A.size()<2){
            return -1;
        }
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for(int i =0; i<A.size(); i++){
            int num = A.get(i);
             if (num > first) {
                 second = first;
                  first = num;
             }
             else if (num > second && num != first) {
                 second =num;
             }
        }
        return second == Integer.MIN_VALUE ? -1 : second;
    }
}
