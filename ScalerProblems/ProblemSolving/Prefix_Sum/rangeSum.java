package ScalerProblems.ProblemSolving.Prefix_Sum;
// Problem Description
// You are given an integer array A of length N.
// You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
// For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
// More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.

import java.util.ArrayList;

// Problem Constraints
// 1 <= N, M <= 105
// 1 <= A[i] <= 109
// 0 <= L <= R < N


// Input Format
// The first argument is the integer array A.
// The second argument is the 2D integer array B.


// Output Format
// Return an integer array of length M where ith element is the answer for ith query in B.


// Example Input
// Input 1:
// A = [1, 2, 3, 4, 5]
// B = [[0, 3], [1, 2]]
// Input 2:

// A = [2, 2, 2]
// B = [[0, 0], [1, 2]]


// Example Output
// Output 1:
// [10, 5]
// Output 2:

// [2, 4]


// Example Explanation
// Explanation 1:
// The sum of all elements of A[0 ... 3] = 1 + 2 + 3 + 4 = 10.
// The sum of all elements of A[1 ... 2] = 2 + 3 = 5.
// Explanation 2:

// The sum of all elements of A[0 ... 0] = 2 = 2.
// The sum of all elements of A[1 ... 2] = 2 + 2 = 4.
import java.util.ArrayList;
public class rangeSum {
       public ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int N = A.size();
        int M = B.size();
        ArrayList<Long> result = new ArrayList<>(M);
        // Step 1: Create the prefix sum array
        long[] prefixSum = new long[N];
        prefixSum[0] = A.get(0);
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] + A.get(i);
        }  
        // Step 2: Process each query
        for (ArrayList<Integer> query : B) {
            int L = query.get(0);
            int R = query.get(1);
            
            long sum;
            if (L == 0) {
                sum = prefixSum[R];
            } else {
                sum = prefixSum[R] - prefixSum[L - 1];
            }
            result.add(sum);
        }
        return result;
    } 
}
