/*
Problem Description
Given an array A and an integer B. A pair(i, j) in the array is a good pair if i != j and (A[i] + A[j] == B). Check if any good pair exist or not.
Problem Constraints
1 <= A.size() <= 104
1 <= A[i] <= 109
1 <= B <= 109

Input Format
First argument is an integer array A.
Second argument is an integer B.

Output Format
Return 1 if good pair exist otherwise return 0.

Example Input
Input 1:
A = [1,2,3,4]
B = 7
Input 2:
A = [1,2,4]
B = 4
Input 3:
A = [1,2,2]
B = 4

Example Output
Output 1:
1
Output 2:
0
Output 3:
1

Example Explanation
Explanation 1:
 (i,j) = (3,4)
Explanation 2:
No pair has sum equal to 4.
Explanation 3:
 (i,j) = (2,3)
 */
package DSA.Basic.Arrays;
/*Approach:
1. Check if N is less than 2. If true, return 0 (cannot have a pair with less than two elements).
2. iterate over all pairs (i, j) in the list A.
3. check if i is not equal to j and if the sum of A.get(i) and A.get(j) is equal to B. If true, return -1.
4. If no good pair is found after the loops complete, return 0. 
 */
import java.util.ArrayList;
public class goodPair {
    public int solve(ArrayList<Integer> A, int B) {
        int N = A.size();        
        // Edge case
        if (N < 2) {
            return 0; // Cannot have a pair with less than two elements
        }
        // Nested loop to check all pairs (i, j)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && A.get(i) + A.get(j) == B) {
                    return 1; // Found a good pair
                }
            }
        }
        return 0; // No good pair found
    }    
}
