package ScalerProblems.DSA.BitManipulation;
// Problem Description
// Given an array A of N integers. Find the sum of bitwise XOR all pairs of numbers in the array.

// Since the answer can be large, return the remainder after the dividing the answer by 109+7.



// Problem Constraints
// 1 <= N <= 105

// 1 <= A[i] < 109



// Input Format
// Only argument A is an array of integers



// Output Format
// Return an integer denoting the sum of xor of all pairs of number in the array.



// Example Input
// Input 1:
// A = [1, 2, 3]
// Input 2:
// A = [3, 4, 2]


// Example Output
// Output 1:
// 6
// Output 2:
// 14


// Example Explanation
// For Input 1:
// Pair    Xor
// {1, 2}  3
// {1, 3}  2
// {2, 3}  1
// Sum of xor of all pairs = 3 + 2 + 1 = 6.
// For Input 2:
// Pair    Xor
// {3, 4}  7
// {3, 2}  1
// {4, 2}  6
// Sum of xor of all pairs = 7 + 1 + 6 = 14.

public class sumOfXORofAllpairs {
    private static final int MOD = 1000000007;

    public int solve(int[] A) {
        int n = A.length;
        long result = 0;
        
        // Iterate over each bit position
        for (int bit = 0; bit < 30; bit++) {
            int count1 = 0;
            
            // Count the numbers with the current bit set
            for (int num : A) {
                if ((num & (1 << bit)) != 0) {
                    count1++;
                }
            }
            
            int count0 = n - count1; // Numbers with the current bit not set
            
            // Calculate contribution of this bit position
            long contribution = (long) count1 * count0 * (1 << bit);
            result = (result + contribution) % MOD;
        }
        
        return (int) result;
    }
}
