package PracticeProblems.ProblemSolving.SlidingWindow;
// Problem Description
// Given an array A of length N. Also given are integers B and C.

import java.util.ArrayList;

// Return 1 if there exists a subarray with length B having sum C and 0 otherwise



// Problem Constraints
// 1 <= N <= 105

// 1 <= A[i] <= 104

// 1 <= B <= N

// 1 <= C <= 109



// Input Format
// First argument A is an array of integers.

// The remaining arguments B and C are integers



// Output Format
// Return 1 if such a subarray exist and 0 otherwise


// Example Input
// Input 1:
// A = [4, 3, 2, 6, 1]
// B = 3
// C = 11
// Input 2:

// A = [4, 2, 2, 5, 1]
// B = 4
// C = 6


// Example Output
// Output 1:
// 1
// Output 2:

// 0


// Example Explanation
// Explanation 1:
// The subarray [3, 2, 6] is of length 3 and sum 11.
// Explanation 2:
// There are no such subarray.
public class subarraySumAndLength {
        public int solve(ArrayList<Integer> A, int B, int C) {
        int sum =0;
        if (A.size()<B){
            return 0;
        }
        // Calculate the sum of the first subarray of length B
        for (int i=0; i<B; i++){
            sum +=A.get(i);
        }
        // If the sum of the first subarray is equal to C, return 1
        if (sum == C) {
            return 1;
        }
        // Use a sliding window to check other subarrays of length B
        for (int i = B; i < A.size(); i++){
            sum += A.get(i) - A.get(i - B);
            if (sum == C){
                return 1;
            }
        }
        return 0;
    }
}
