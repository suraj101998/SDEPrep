package DSA.Basic.InterviewProblems;
// Problem Description
// You are given an array A of N elements. Find the number of triplets i,j and k such that i<j<k and A[i]<A[j]<A[k]

import java.util.ArrayList;

// Problem Constraints
// 1 <= N <= 103
// 1 <= A[i] <= 109


// Input Format
// First argument A is an array of integers.


// Output Format
// Return an integer.


// Example Input
// Input 1:
// A = [1, 2, 4, 3]
// Input 2:
// A = [2, 1, 2, 3]


// Example Output
// Output 1:
// 2
// Output 2:
// 1


// Example Explanation
// For Input 1:
// The triplets that satisfy the conditions are [1, 2, 3] and [1, 2, 4].
// For Input 2:
 
// The triplet that satisfy the conditions is [1, 2, 3].
public class countIncrasingTriplet {
        public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int count = 0;
        
        // Iterate through each element considering it as the middle element of the triplet
        for (int j = 1; j < n - 1; j++) {
            int leftCount = 0;
            int rightCount = 0;
            
            // Count elements less than A[j] to the left of j
            for (int i = 0; i < j; i++) {
                if (A.get(i) < A.get(j)) {
                    leftCount++;
                }
            }
            
            // Count elements greater than A[j] to the right of j
            for (int k = j + 1; k < n; k++) {
                if (A.get(k) > A.get(j)) {
                    rightCount++;
                }
            }
            
            // Multiply counts to get the number of valid triplets with A[j] as the middle element
            count += leftCount * rightCount;
        }
        
        return count;
    }
}
