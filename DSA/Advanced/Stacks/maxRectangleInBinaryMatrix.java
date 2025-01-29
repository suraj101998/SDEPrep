package DSA.Advanced.Stacks;

import java.util.Stack;

/*
 * Problem Description
Given a 2-D binary matrix A of size N x M filled with 0's and 1's, find the largest rectangle containing only ones and return its area.

Problem Constraints
1 <= N, M <= 100

Input Format
The first argument is a 2-D binary array A.

Output Format
Return an integer denoting the area of the largest rectangle containing only ones.



Example Input
Input 1:

 A = [
       [1, 1, 1]
       [0, 1, 1]
       [1, 0, 0] 
     ]
Input 2:

 A = [
       [0, 1, 0]
       [1, 1, 1]
     ] 


Example Output
Output 1:

 4
Output 2:

 3


Example Explanation
Explanation 1:

 As the max area rectangle is created by the 2x2 rectangle created by (0, 1), (0, 2), (1, 1) and (1, 2).
Explanation 2:

 As the max area rectangle is created by the 1x3 rectangle created by (1, 0), (1, 1) and (1, 2).
 */
public class maxRectangleInBinaryMatrix {
        public int maximalRectangle(int[][] A) {
        if (A.length == 0) {
            return 0;
        }
        int n = A.length;
        int m = A[0].length;
        int[] heights = new int[m];
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 0) {
                    heights[j] = 0;
                } else {
                    heights[j] += 1;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i <= n; i++) {
            int h;
            if (i == n) {
                h = 0;
            } else {
                h = heights[i];
            }
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];    
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
        return maxArea;
    }
}
