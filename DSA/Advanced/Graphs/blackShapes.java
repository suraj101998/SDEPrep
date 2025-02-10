package DSA.Advanced.Graphs;

import java.util.ArrayList;

/*
 * Problem Description
Given character matrix A of dimensions N×M consisting of O's and X's, where O = white, X = black.
Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)

Problem Constraints
1 <= N, M <= 1000
A[i][j] = 'X' or 'O'

Input Format
The First and only argument is character matrix A.

Output Format
Return a single integer denoting number of black shapes.

Example Input
Input 1:
 A = [ [X, X, X], [X, X, X], [X, X, X] ]

Input 2:
 A = [ [X, O], [O, X] ]

Example Output
Output 1:
 1

Output 2:
 2

Example Explanation
Explanation 1:
 All X's belong to single shapes

 Explanation 2:
 Both X's belong to different shapes
 */
public class blackShapes {
    public static int black(ArrayList<String> A) {
        if (A == null || A.size() == 0) {
            return 0;
        }
        int rows = A.size();
        int cols = A.get(0).length();
        int count = 0;
        // Directions for 4-connected neighbors
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        // Convert the ArrayList<String> to a modifiable grid
        char[][] grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            grid[i] = A.get(i).toCharArray();
        }
        // Traverse the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'X') {
                    count++;
                    floodFill(grid, i, j, dx, dy, rows, cols);
                }
            }
        }
        return count;
    }

    private static void floodFill(char[][] grid, int x, int y, int[] dx, int[] dy, int rows, int cols) {
        // Mark the current cell as visited
        grid[x][y] = 'V';
        // Traverse all 4-connected neighbors
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && grid[nx][ny] == 'X') {
                floodFill(grid, nx, ny, dx, dy, rows, cols);
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>();
        A.add("XXX");
        A.add("XOX");
        A.add("XXX");
        System.out.println("Number of black shapes: " + black(A));
    }
}
