package ScalerProblems.DSA.GCDandModularArithmetic;
// Problem Description
// Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.

// Find the maximum value of GCD.



// Problem Constraints
// 2 <= N <= 105
// 1 <= A[i] <= 109



// Input Format
// First argument is an integer array A.



// Output Format
// Return an integer denoting the maximum value of GCD.



// Example Input
// Input 1:

//  A = [12, 15, 18]
// Input 2:

//  A = [5, 15, 30]


// Example Output
// Output 1:

//  6
// Output 2:

//  15


// Example Explanation
// Explanation 1:

//  If you delete 12, gcd will be 3.
//  If you delete 15, gcd will be 6.
//  If you delete 18, gcd will 3.
//  Maximum value of gcd is 6.
// Explanation 2:

//  If you delete 5, gcd will be 15.
//  If you delete 15, gcd will be 5.
//  If you delete 30, gcd will be 5.
//  Maximum value of gcd is 15.

public class deleteOne {
    public int solve(int[] A) {
        int N = A.length;

        // Edge case: if the array has less than 2 elements, return 0
        if (N < 2) {
            return 0;
        }

        // Initialize prefix and suffix GCD arrays
        int[] pgcd = new int[N];
        int[] sgcd = new int[N];

        // Fill the prefix GCD array
        pgcd[0] = A[0];
        for (int i = 1; i < N; i++) {
            pgcd[i] = gcd(pgcd[i - 1], A[i]);
        }

        // Fill the suffix GCD array
        sgcd[N - 1] = A[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            sgcd[i] = gcd(sgcd[i + 1], A[i]);
        }

        // Calculate the maximum GCD after removing one element
        int ans = Math.max(sgcd[1], pgcd[N - 2]); // Handle boundary cases

        // Calculate maximum GCD for the rest of the elements
        for (int i = 1; i < N - 1; i++) {
            ans = Math.max(ans, gcd(pgcd[i - 1], sgcd[i + 1]));
        }

        return ans;
    }

    // Helper method to calculate GCD
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
