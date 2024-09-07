package ScalerProblems.DSA.GCDandModularArithmetic;
// Problem Description
// Given an array of integers A, calculate the sum of A [ i ] % A [ j ] for all possible i, j pairs. Return sum % (109 + 7) as an output.



// Problem Constraints
// 1 <= length of the array A <= 105

// 1 <= A[i] <= 103



// Input Format
// The only argument given is the integer array A.



// Output Format
// Return a single integer denoting sum % (109 + 7).



// Example Input
// Input 1:

//  A = [1, 2, 3]
// Input 2:

//  A = [17, 100, 11]


// Example Output
// Output 1:

//  5
// Output 2:

//  61


// Example Explanation
// Explanation 1:

//  (1 % 1) + (1 % 2) + (1 % 3) + (2 % 1) + (2 % 2) + (2 % 3) + (3 % 1) + (3 % 2) + (3 % 3) = 5

public class modSum {
    public int solve(int[] A) {
        long mod = 1000000007;
        int maxVal = 1000; // given 1 <= A[i] <= 103
        
        // Step 1: Count frequency of each number in A
        int[] freq = new int[maxVal + 1];
        for (int num : A) {
            freq[num]++;
        }
        
        // Step 2: Calculate total sum of A[i] % A[j] efficiently
        long sum = 0;
        
        // Iterate over each possible value of A[i]
        for (int i = 1; i <= maxVal; i++) {
            if (freq[i] > 0) {
                // Total contribution of i in terms of modulo
                // For a specific value i, we need to calculate the sum of (i % j) for all j
                long contribution = 0;
                for (int j = 1; j <= maxVal; j++) {
                    if (freq[j] > 0) {
                        contribution = (contribution + i % j * freq[j]) % mod;
                    }
                }
                // Multiply by the number of times i appears in the array
                sum = (sum + contribution * freq[i]) % mod;
            }
        }
        
        return (int) sum;
    }
}
