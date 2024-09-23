package ScalerProblems.DSA.Queues;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Problem Description
Given an array A of both positive and negative integers.

Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.

NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.



Problem Constraints
1 <= size of array A <= 105

-109 <= A[i] <= 109

1 <= B <= size of array



Input Format
The first argument denotes the integer array A.
The second argument denotes the value B



Output Format
Return an integer that denotes the required value.



Example Input
Input 1:

 A = [2, 5, -1, 7, -3, -1, -2]
 B = 4
Input 2:

 A = [2, -1, 3]
 B = 2


Example Output
Output 1:

 18
Output 2:

 3


Example Explanation
Explanation 1:

 Subarrays of size 4 are : 
    [2, 5, -1, 7],   min + max = -1 + 7 = 6
    [5, -1, 7, -3],  min + max = -3 + 7 = 4      
    [-1, 7, -3, -1], min + max = -3 + 7 = 4
    [7, -3, -1, -2], min + max = -3 + 7 = 4   
    Sum of all min & max = 6 + 4 + 4 + 4 = 18 
Explanation 2:

 Subarrays of size 2 are : 
    [2, -1],   min + max = -1 + 2 = 1
    [-1, 3],   min + max = -1 + 3 = 2
    Sum of all min & max = 1 + 2 = 3
 */
public class minMaxSum {
        public int solve(int[] A, int B) {
        int MOD = 1000000007;
        int n = A.length;
        long result = 0;

        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove indices that are out of this window
            if (!maxDeque.isEmpty() && maxDeque.peekFirst() <= i - B) {
                maxDeque.pollFirst();
            }
            if (!minDeque.isEmpty() && minDeque.peekFirst() <= i - B) {
                minDeque.pollFirst();
            }

            // Remove smaller elements from maxDeque
            while (!maxDeque.isEmpty() && A[maxDeque.peekLast()] <= A[i]) {
                maxDeque.pollLast();
            }
            // Remove larger elements from minDeque
            while (!minDeque.isEmpty() && A[minDeque.peekLast()] >= A[i]) {
                minDeque.pollLast();
            }

            // Add current element at the end of both deques
            maxDeque.addLast(i);
            minDeque.addLast(i);

            // Start calculating the sum when the first window is fully formed
            if (i >= B - 1) {
                int maxElement = A[maxDeque.peekFirst()];
                int minElement = A[minDeque.peekFirst()];
                result = (result + maxElement + minElement) % MOD;

                // Ensure result is positive even after the modulo operation
                if (result < 0) {
                    result += MOD;
                }
            }
        }

        // Return the final result modulo 10^9 + 7
        return (int) result;
    }
}
