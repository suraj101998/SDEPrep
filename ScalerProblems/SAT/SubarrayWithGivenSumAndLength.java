/*
Subarray with given sum and length
Problem Description
Given an array A of length N. Also given are integers B and C.
        Return 1 if there exists a subarray with length B having sum C and 0 otherwise
Problem Constraints
1 <= N <= 105

        1 <= A[i] <= 104

        1 <= B <= N

1 <= C <= 109
Input Format
First argument A is an array of integers.
The remaining arguments B and C are integers
Output Format
Return 1 if such a subarray exist and 0 otherwise
Example Input
Input 1:
A = [4, 3, 2, 6, 1]
B = 3
C = 11
Input 2:
A = [4, 2, 2, 5, 1]
B = 4
C = 6
Example Output
Output 1:
        1
Output 2:
        0
Example Explanation
Explanation 1:
The subarray [3, 2, 6] is of length 3 and sum 11.
Explanation 2:
There are no such subarray.
*/

package ScalerProblems.SAT;

public class SubarrayWithGivenSumAndLength {

    public static int subarrayWithGivenSumAndLength(int[] A, int B, int C) {
        int N = A.length;

        // Check if B is greater than N, which makes it impossible to find such a subarray
        if (B > N) {
            return 0;
        }

        // Compute the sum of the first window of size B
        int currentSum = 0;
        for (int i = 0; i < B; i++) {
            currentSum += A[i];
        }

        // Check if the first window matches the required sum
        if (currentSum == C) {
            return 1;
        }

        // Use sliding window technique to check remaining subarrays
        for (int i = B; i < N; i++) {
            currentSum += A[i] - A[i - B];
            if (currentSum == C) {
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] A1 = {4, 3, 2, 6, 1};
        int B1 = 3;
        int C1 = 11;
        System.out.println(subarrayWithGivenSumAndLength(A1, B1, C1)); // Output: 1

        int[] A2 = {4, 2, 2, 5, 1};
        int B2 = 4;
        int C2 = 6;
        System.out.println(subarrayWithGivenSumAndLength(A2, B2, C2)); // Output: 0
    }
}