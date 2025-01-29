package DSA.Advanced.Stacks;

import java.util.Stack;

/*
 * Problem Description
Given an array of integers A.

The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.

Calculate and return the sum of values of all possible subarrays of A modulo 109+7.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 1000000



Input Format
The first and only argument given is the integer array A.



Output Format
Return the sum of values of all possible subarrays of A modulo 109+7.



Example Input
Input 1:

 A = [1]
Input 2:

 A = [4, 7, 3, 8]


Example Output
Output 1:

 0
Output 2:

 26


Example Explanation
Explanation 1:

Only 1 subarray exists. Its value is 0.
Explanation 2:

value ( [4] ) = 4 - 4 = 0
value ( [7] ) = 7 - 7 = 0
value ( [3] ) = 3 - 3 = 0
value ( [8] ) = 8 - 8 = 0
value ( [4, 7] ) = 7 - 4 = 3
value ( [7, 3] ) = 7 - 3 = 4
value ( [3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3] ) = 7 - 3 = 4
value ( [7, 3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3, 8] ) = 8 - 3 = 5
sum of values % 10^9+7 = 26
 */
public class maxAndMin {
    private static final int MOD = 1000000007;
    public int solve(int[] A) {
        int n = A.length;
        long result = 0;
        int[] nextSmaller = new int[n];
        int[] prevSmaller = new int[n];
        int[] nextGreater = new int[n];
        int[] prevGreater = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                prevSmaller[i] = -1;
            } else {
                prevSmaller[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nextSmaller[i] = n;
            } else {
                nextSmaller[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                prevGreater[i] = -1;
            } else {
                prevGreater[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nextGreater[i] = n;
            } else {
                nextGreater[i] = stack.peek();
            }
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            long minContribution = (long)(i - prevSmaller[i]) * (nextSmaller[i] - i);
            long maxContribution = (long)(i - prevGreater[i]) * (nextGreater[i] - i);
            result = (result + (maxContribution - minContribution) * A[i]) % MOD;
        }
        if (result < 0) {
            result += MOD;
        }
        return (int) result;
    }
}
