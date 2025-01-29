/*
Problem Description
Given an array A and an integer B, find the number of occurrences of B in A.
Problem Constraints
1 <= B, Ai <= 109
1 <= length(A) <= 105

Input Format
Given an integer array A and an integer B.

Output Format
Return an integer, number of occurrences of B in A.

Example Input
Input 1:
 A = [1, 2, 2], B = 2 
Input 2:
 A = [1, 2, 1], B = 3 

Example Output
Output 1:
 2
Output 2:
 0

Example Explanation
Explanation 1:
Element at index 2, 3 is equal to 2 hence count is 2.
Explanation 2:
There is no element equal to 3 in the array.
 */
package DSA.Basic.Arrays;

import java.util.ArrayList;

/*Approach:
1. Initialize an integer variable count to 0. iterate over the elements of A from index 0 to A.size() - 1.
2. check if A.get(i) is equal to B. If the condition is true, increment count by 1.
3. return the value of count after loop completes.
*/
public class linearSearch {
    public int solve(ArrayList<Integer> A, int B) {
        int count =0;
        for (int i =0; i<A.size(); i++){
            if(A.get(i)==B){
                count++;
            }
        }
        return count;
    }    
}
