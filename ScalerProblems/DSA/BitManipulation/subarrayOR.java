package ScalerProblems.DSA.BitManipulation;
// Problem Description
// You are given an array of integers A of size N.

// The value of a subarray is defined as BITWISE OR of all elements in it.

// Return the sum of value of all subarrays of A % 109 + 7.



// Problem Constraints
// 1 <= N <= 105

// 1 <= A[i] <= 108



// Input Format
// The first argument given is the integer array A.



// Output Format
// Return the sum of Value of all subarrays of A % 109 + 7.



// Example Input
// Input 1:

//  A = [1, 2, 3, 4, 5]
// Input 2:

//  A = [7, 8, 9, 10]


// Example Output
// Output 1:

//  71
// Output 2:

//  110


// Example Explanation
// Explanation 1:

//  Value([1]) = 1
//  Value([1, 2]) = 3
//  Value([1, 2, 3]) = 3
//  Value([1, 2, 3, 4]) = 7
//  Value([1, 2, 3, 4, 5]) = 7
//  Value([2]) = 2
//  Value([2, 3]) = 3
//  Value([2, 3, 4]) = 7
//  Value([2, 3, 4, 5]) = 7
//  Value([3]) = 3
//  Value([3, 4]) = 7
//  Value([3, 4, 5]) = 7
//  Value([4]) = 4
//  Value([4, 5]) = 5
//  Value([5]) = 5
//  Sum of all these values = 71
// Explanation 2:

//  Sum of value of all subarray is 110.

public class subarrayOR {
    public int solve(int[] A) {
        int MOD = 1000000007;
        int n = A.length;
        long totalSum = 0;
        // Loop through each bit position from 0 to 29
        // We only need to check up to 29 because 1 <= A[i] <= 10^8
        for (int bit = 0; bit < 30; bit++) {
            // Initialize count and sum for the current bit
            int count = 0;
            long sum = 0;
            // Traverse the array to calculate the contribution of the current bit
            for (int i = 0; i < n; i++) {
                // Check if the current bit is set in A[i]
                if ((A[i] & (1 << bit)) != 0) {
                    // If the bit is set, count the number of subarrays ending at i
                    count = i + 1;
                }
                // Add the count to the sum
                sum += count;
                // Take modulo to keep the sum manageable
                sum %= MOD;
            }
            // Multiply the sum by the value of the bit and add to the total sum
            totalSum += sum * (1 << bit);
            // Take modulo to keep the total sum manageable
            totalSum %= MOD;
        }
        // Convert the totalSum from long to int
        int result = (int) totalSum;
        return result;
    }
}
