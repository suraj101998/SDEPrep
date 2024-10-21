package PracticeProblems.DSA.Backtracking;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem Description
Given an MxN matrix where each element can either be 0 or 1. We need to find the length of shortest path between a given source cell to a destination cell.
A cell with value 0 denotes that it's a hurdle. The path can only be created out of the cells with values 1.
If NO path exists then print -1.
The matrix A is given as input of size M x N.
The coordinates of Source cell are given by B, C.
The coordinates of Destination cell are given by D, E.

Problem Constraints
1 <= N , M <= 8
0 <= A[i][j] <= 1
0 <= B, C < N
0 <= D, E < M
A[B][C] == A[D][E] == 1

Input Format
First Argument is a 2-D Integer Array denotes the matrix A, of size MxN.
Second Argument is an Integer B, denoting the Source Row Index
Third Argument is an Integer C, denoting the Source Column Index
Fourth Argument is an Integer D, denoting the Destination Row Index
Fifth Argument is an Integer E, denoting the Destination Column Index

Output Format
Output a single integer denoting the length of the minimum distance from Source to destination

Example Input
Input 1 :
A = [[1, 1, 0, 0],
     [0, 1, 1, 0],
     [0, 0, 1, 1],
     [0, 0, 0, 1]]
B = 0, C = 0
D = 3, E = 3
Input 2 :
A = [[1, 1, 1],
     [1, 0, 1],
     [1, 1, 1]]
B = 0, C = 0
D = 0, E = 2
Input 3 :
A = [[1, 0, 1],
     [1, 0, 1],
     [1, 0, 1]]
B = 0, C = 0
D = 0, E = 2

Example Output
Output 1 :
6
Output 2 :
2
Output 3 :
-1

Example Explanation
For Input 1 :
The shortest path is (0,0) -> (0,1) -> (1,1) -> (1,2) -> (2,2) -> (2,3) -> (3,3)
For Input 2 :
The shortest path is (0,0) -> (0,1) -> (0,2) 
For Input 3 :
No path exists so we return -1
 */
public class shortestPathInBinaryMaze {
    private static final int[] rowDirection = {-1, 1, 0, 0};
    private static final int[] colDirection = {0, 0, -1, 1};
    public int FindShortestPath(int[][] A, int B, int C, int D, int E) {
        int rows = A.length;
        int cols = A[0].length;
        if (A[B][C] == 0 || A[D][E] == 0) {
            return -1;
        }
        if (B == D && C == E) {
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        visited[B][C] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{B, C, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            int currentDistance = current[2];
            for (int i = 0; i < 4; i++) {
                int newRow = currentRow + rowDirection[i];
                int newCol = currentCol + colDirection[i];
                if (isValidCell(newRow, newCol, rows, cols, A, visited)) {
                    if (newRow == D && newCol == E) {
                        return currentDistance + 1;
                    }
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol, currentDistance + 1});
                }
            }
        }
        return -1;
    }
    private boolean isValidCell(int row, int col, int rows, int cols, int[][] A, boolean[][] visited) {
        if (row < 0 || row >= rows) {
            return false;
        }
        if (col < 0 || col >= cols) {
            return false;
        }
        if (A[row][col] != 1) {
            return false;
        }
        if (visited[row][col]) {
            return false;
        }
        return true;
    }   
}
