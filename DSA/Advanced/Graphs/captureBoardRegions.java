package DSA.Advanced.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem Description

Given a 2-D board A of size N x M containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.



Problem Constraints

1 <= N, M <= 1000



Input Format

First and only argument is a N x M character matrix A.



Output Format

Return nothing. Make changes to the the input only as matrix is passed by reference.



Example Input

Input 1:

 A = [ 
       [X, X, X, X],
       [X, O, O, X],
       [X, X, O, X],
       [X, O, X, X] 
     ]
Input 2:

 A = [
       [X, O, O],
       [X, O, X],
       [O, O, O]
     ]


Example Output

Output 1:

 After running your function, the board should be:
 A = [
       [X, X, X, X],
       [X, X, X, X],
       [X, X, X, X],
       [X, O, X, X]
     ]
Output 2:

 After running your function, the board should be:
 A = [
       [X, O, O],
       [X, O, X],
       [O, O, O]
     ]


Example Explanation

Explanation 1:

 O in (4,2) is not surrounded by X from below.
Explanation 2:

 No O's are surrounded.
 */
public class captureBoardRegions {
    public void solve(ArrayList<ArrayList<Character>> board) {
        if (board == null || board.size() == 0 || board.get(0).size() == 0) {
            return;
        }
        int rows = board.size();
        int cols = board.get(0).size();
        // Directions for traversing 4-connected neighbors
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        // Mark all 'O' connected to the boundary
        for (int i = 0; i < rows; i++) {
            if (board.get(i).get(0) == 'O') {
                markBoundaryConnected(board, i, 0, dx, dy);
            }
            if (board.get(i).get(cols - 1) == 'O') {
                markBoundaryConnected(board, i, cols - 1, dx, dy);
            }
        }
        for (int j = 0; j < cols; j++) {
            if (board.get(0).get(j) == 'O') {
                markBoundaryConnected(board, 0, j, dx, dy);
            }
            if (board.get(rows - 1).get(j) == 'O') {
                markBoundaryConnected(board, rows - 1, j, dx, dy);
            }
        }
        // Flip all unmarked 'O' to 'X' and marked 'B' back to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board.get(i).get(j) == 'O') {
                    board.get(i).set(j, 'X');
                } else if (board.get(i).get(j) == 'B') {
                    board.get(i).set(j, 'O');
                }
            }
        }
    }

    private void markBoundaryConnected(ArrayList<ArrayList<Character>> board, int x, int y, int[] dx, int[] dy) {
        int rows = board.size();
        int cols = board.get(0).size();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        board.get(x).set(y, 'B'); // Mark the cell as boundary connected
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && board.get(nx).get(ny) == 'O') {
                    board.get(nx).set(ny, 'B');
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }    
}
