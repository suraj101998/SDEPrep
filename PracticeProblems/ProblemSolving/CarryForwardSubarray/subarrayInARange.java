package PracticeProblems.ProblemSolving.CarryForwardSubarray;
// Problem Description
// Given an array A of length N, return the subarray from B to C.

import java.util.ArrayList;

// Problem Constraints
// 1 <= N <= 105

// 1 <= A[i] <= 109

// 0 <= B <= C < N



// Input Format
// The first argument A is an array of integers

// The remaining argument B and C are integers.



// Output Format
// Return a subarray


// Example Input
// Input 1:
// A = [4, 3, 2, 6]
// B = 1
// C = 3
// Input 2:

// A = [4, 2, 2]
// B = 0
// C = 1


// Example Output
// Output 1:
// [3, 2, 6]
// Output 2:

// [4, 2]


// Example Explanation
// Explanation 1:
// The subarray of A from 1 to 3 is [3, 2, 6].
// Explanation 2:
// The subarray of A from 0 to 1 is [4, 2].
public class subarrayInARange {
        public ArrayList<Integer> solve(ArrayList<Integer> A, int B, int C) {
        ArrayList<Integer> subArray = new ArrayList<>();
        for (int i=B; i<=C; i++){
            subArray.add(A.get(i));
        }
        return subArray;
    }
}
