package DSA.Basic.Prefix_Sum;
// Problem Description
// You are given an array A of integers of size N.

import java.util.ArrayList;

// Your task is to find the equilibrium index of the given array

// The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.

// If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.

// Note:

// Array indexing starts from 0.
// If there is no equilibrium index then return -1.
// If there are more than one equilibrium indexes then return the minimum index.


// Problem Constraints
// 1 <= N <= 105
// -105 <= A[i] <= 105


// Input Format
// First arugment is an array A .


// Output Format
// Return the equilibrium index of the given array. If no such index is found then return -1.


// Example Input
// Input 1:
// A = [-7, 1, 5, 2, -4, 3, 0]
// Input 2:

// A = [1, 2, 3]


// Example Output
// Output 1:
// 3
// Output 2:

// -1


// Example Explanation
// Explanation 1:
// i   Sum of elements at lower indexes    Sum of elements at higher indexes
// 0                   0                                   7
// 1                  -7                                   6
// 2                  -6                                   1
// 3                  -1                                  -1
// 4                   1                                   3
// 5                  -3                                   0
// 6                   0                                   0

// 3 is an equilibrium index, because: 
// A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
// Explanation 1:

// i   Sum of elements at lower indexes    Sum of elements at higher indexes
// 0                   0                                   5
// 1                   1                                   3
// 2                   3                                   0
// Thus, there is no such index.
public class equilibriumIndex {
        public int solve(ArrayList<Integer> A) {
        // Edge case: if the list is null or empty
        if (A == null || A.size() == 0) {
            return -1;
        }
 
        int N = A.size();
       
        // Calculate the prefix sum
        ArrayList<Integer> prefixSum = new ArrayList<>(N);
        prefixSum.add(A.get(0));
        for (int i = 1; i < N; i++) {
            prefixSum.add(prefixSum.get(i - 1) + A.get(i));
        }
       
        // Iterate to find the equilibrium index
        for (int i = 0; i < N; i++) {
            int leftSum = (i == 0) ? 0 : prefixSum.get(i - 1); //left side start from 0 so range 0-i so psum is i element only
            int rightSum = prefixSum.get(N - 1) - prefixSum.get(i); //rightside start from i to last(i.e N-1) so psum = last - (i-1)
           
            if (leftSum == rightSum) {
                return i;
            }
        }
       
        return -1;
    }
}
