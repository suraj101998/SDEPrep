package DSA.Advanced.BitManipulation;
// Problem Description
// Given an array A of length N where all the elements are distinct and are in the range [1, N+2].

// Two numbers from the range [1, N+2] are missing from the array A. Find the two missing numbers.



// Problem Constraints
// 1 <= N <= 105

// 1 <= A[i] <= N+2

// The elements of array A are distinct



// Input Format
// Only argument A is an array of integers



// Output Format
// Return a sorted array of size 2 denoting the missing elements.



// Example Input
// Input 1:
// A = [3, 2, 4]
// Input 2:
// A = [5, 1, 3, 6]


// Example Output
// Output 1:
// [1, 5]
// Output 2:
// [2, 4]


// Example Explanation
// For Input 1:
// The missing numbers are 1 and 5.
// For Input 2:
// The missing numbers are 2 and 4.

public class findTwoMissingNumber {
    public int[] solve(int[] A) {
        int N = A.length;

        // Calculate the expected sum and sum of squares for the range 1 to N+2
        long expectedSum = (long) (N + 2) * (N + 3) / 2;
        long expectedSumSquares = (long) (N + 2) * (N + 3) * (2 * N + 5) / 6;

        // Calculate the actual sum and sum of squares from the array
        long actualSum = 0;
        long actualSumSquares = 0;

        for (int num : A) {
            actualSum += num;
            actualSumSquares += (long) num * num;
        }

        // Calculate the difference to get the sum and sum of squares of missing numbers
        long sumMissing = expectedSum - actualSum;
        long sumSquaresMissing = expectedSumSquares - actualSumSquares;

        // We have two equations:
        // x + y = sumMissing
        // x^2 + y^2 = sumSquaresMissing

        // From the above equations:
        // (x + y)^2 = x^2 + y^2 + 2xy
        // sumMissing^2 = sumSquaresMissing + 2xy
        // 2xy = sumMissing^2 - sumSquaresMissing
        // xy = (sumMissing^2 - sumSquaresMissing) / 2

        long sumMissingSquared = sumMissing * sumMissing;
        long productMissing = (sumMissingSquared - sumSquaresMissing) / 2;

        // Now solve the quadratic equation to get the missing numbers
        // x^2 - sumMissing * x + productMissing = 0

        // Roots of the quadratic equation are the missing numbers
        double discriminant = Math.sqrt(sumMissing * sumMissing - 4 * productMissing);
        int x = (int) ((sumMissing + discriminant) / 2);
        int y = (int) ((sumMissing - discriminant) / 2);

        // Return the missing numbers in sorted order
        int[] result = new int[2];
        result[0] = Math.min(x, y);
        result[1] = Math.max(x, y);

        return result;
    }
}
