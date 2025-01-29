/*
Problem Description
Given an integer array A of size N. In one second, you can increase the value of one element by 1.
Find the minimum time in seconds to make all elements of the array equal.
Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 1000

Input Format
First argument is an integer array A.

Output Format
Return an integer denoting the minimum time to make all elements equal.

Example Input
A = [2, 4, 1, 3, 2]

Example Output
8

Example Explanation
We can change the array A = [4, 4, 4, 4, 4]. The time required will be 8 seconds.
 */
package DSA.Basic.Arrays;
import java.util.ArrayList;

/*Approach:
1. Check if A is empty. If true, return 0.
2. Initialize an integer max_ele to the first element of A. iterate over elements of A from index 1 to A.size() - 1.
3. check if the current element is greater than max_ele. If true, update max_ele to the current element.
4. Initialize an integer total_time to 0. iterate over elements of A from index 0 to A.size() - 1.
5. add the difference between max_ele and the current element to total_time. Return total_time.
 */
public class equalAllElements {
    public int solve(ArrayList<Integer> A) {
        //edge case for empty array
        if(A.size()==0){
            return 0;
        }
        //first find the max element in the Array
        int max_ele = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i)>max_ele){
                max_ele = A.get(i);
            }
        }
        //calculate time taken to make all element equal to max_ele
        int total_time = 0;
        for (int i = 0; i < A.size(); i++) {
            total_time += (max_ele-A.get(i));
        }
        return total_time;
    }
}
