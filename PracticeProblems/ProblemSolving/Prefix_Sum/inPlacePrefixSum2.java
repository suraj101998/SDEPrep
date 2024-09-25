package PracticeProblems.ProblemSolving.Prefix_Sum;
// Problem Description
// Given an array A of N integers. Construct prefix sum of the array in the given array itself.

import java.util.ArrayList;

// Problem Constraints
// 1 <= N <= 105
// 1 <= A[i] <= 103


// Input Format
// Only argument A is an array of integers.


// Output Format
// Return an array of integers denoting the prefix sum of the given array.


// Example Input
// Input 1:

// A = [1, 2, 3, 4, 5]
// Input 2:

// A = [4, 3, 2]


// Example Output
// Output 1:

// [1, 3, 6, 10, 15]
// Output 2:

// [4, 7, 9]


// Example Explanation
// Explanation 1:

// The prefix sum array of [1, 2, 3, 4, 5] is [1, 3, 6, 10, 15].
// Explanation 2:

// The prefix sum array of [4, 3, 2] is [4, 7, 9].
public class inPlacePrefixSum2 {
        public ArrayList<Integer> solve(ArrayList<Integer> A) {
        for (int i=1; i<A.size(); i++){
            A.set(i, A.get(i)+A.get(i-1));
        }
        return A;
    }
}
