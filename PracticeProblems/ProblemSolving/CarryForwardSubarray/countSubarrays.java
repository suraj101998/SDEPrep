package PracticeProblems.ProblemSolving.CarryForwardSubarray;
// Problem Description

import java.util.ArrayList;
import java.util.Arrays;

// Misha likes finding all Subarrays of an Array. Now she gives you an array A of N elements and told you to find the number of subarrays of A, that have unique elements.

// Since the number of subarrays could be large, return value % 109 +7.



// Problem Constraints

// 1 <= N <= 105

// 1 <= A[i] <= 106



// Input Format

// The only argument given is an Array A, having N integers.



// Output Format

// Return the number of subarrays of A, that have unique elements.



// Example Input

// Input 1:

//  A = [1, 1, 3]
// Input 2:

//  A = [2, 1, 2]


// Example Output

// Output 1:

//  4
// Output 1:

//  5


// Example Explanation

// Explanation 1:

//  Subarrays of A that have unique elements only:
//  [1], [1], [1, 3], [3]
// Explanation 2:

//  Subarrays of A that have unique elements only:
//  [2], [1], [2, 1], [1, 2], [2]

public class countSubarrays {
        public int solve(ArrayList<Integer> A) {
        int MOD = 1000000007;
        int count = 0;
        int[] lastOccurrence = new int[1000001];
        Arrays.fill(lastOccurrence, -1);
        
        int start = 0;
        for (int end = 0; end < A.size(); end++) {
            int current = A.get(end);
            if (lastOccurrence[current] >= start) {
                start = lastOccurrence[current] + 1;
            }
            lastOccurrence[current] = end;
            count = (count + (end - start + 1)) % MOD;
        }
        
        return count;
    }
}
