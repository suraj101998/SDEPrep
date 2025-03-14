package DSA.Advanced.Stacks;

import java.util.Stack;

/*
 * Problem Description
Given an array of integers A.

A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.

Find the area of the largest rectangle formed by the histogram.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10000



Input Format
The only argument given is the integer array A.



Output Format
Return the area of the largest rectangle in the histogram.



Example Input
Input 1:

 A = [2, 1, 5, 6, 2, 3]
Input 2:

 A = [2]


Example Output
Output 1:

 10
Output 2:

 2


Example Explanation
Explanation 1:

The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
Explanation 2:

Largest rectangle has area 2.
 */
public class largestHistogramRectangle {
        public int largestRectangleArea(int[] A) {
        int n = A.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[i] < A[stack.peek()]) {
                int height = A[stack.pop()];
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int height = A[stack.pop()];
                int width;
                if (stack.isEmpty()) {
                    width = n;
                } else {
                    width = n - stack.peek() - 1;
                }
            maxArea = Math.max(maxArea, height * width);
        }
        
        return maxArea;
    }
}
