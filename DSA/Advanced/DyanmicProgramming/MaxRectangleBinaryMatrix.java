package DSA.Advanced.DyanmicProgramming;
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
public class MaxRectangleBinaryMatrix {
    public int maximalRectangle(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int N = A.length;      // Number of rows
        int M = A[0].length;   // Number of columns
        int[] height = new int[M];
        int maxArea = 0;
        for (int i = 0; i < N; i++) {
            // Update the height array based on the current row
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 0) {
                    height[j] = 0;
                } else {
                    height[j]++;
                }
            }  
            // Calculate the largest rectangle area for the current row's histogram
            maxArea = Math.max(maxArea, largestRectangleInHistogram(height));
        }
        return maxArea;
    }

    private int largestRectangleInHistogram(int[] height) {
        int maxArea = 0;
        int n = height.length;
        int[] stack = new int[n + 1]; // Stack to store indices of the histogram bars
        int top = -1;  // Stack top pointer
        for (int i = 0; i < n; i++) {
            // While the current bar is lower than the bar at the stack top, calculate area
            while (top >= 0 && height[stack[top]] > height[i]) {
                int h = height[stack[top]];
                top--;  // Pop the top element
                int width = (top == -1) ? i : (i - stack[top] - 1);
                maxArea = Math.max(maxArea, h * width);
            }
            stack[++top] = i; // Push the current index to the stack
        }
        // Calculate area for remaining bars in the stack
        while (top >= 0) {
            int h = height[stack[top]];
            top--;  // Pop the top element
            int width = (top == -1) ? n : (n - stack[top] - 1);
            maxArea = Math.max(maxArea, h * width);
        }
        return maxArea;
    }    
}
