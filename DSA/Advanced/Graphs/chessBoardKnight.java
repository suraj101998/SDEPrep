package DSA.Advanced.Graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem Description

Given any source point, (C, D) and destination point, (E, F) on a chess board of size A x B, we need to find whether Knight can move to the destination or not.


The above figure details the movements for a knight ( 8 possibilities ).

If yes, then what would be the minimum number of steps for the knight to move to the said point. If knight can not move from the source point to the destination point, then return -1.

NOTE: A knight cannot go out of the board.



Problem Constraints

1 <= A, B <= 500



Input Format

The first argument of input contains an integer A.
The second argument of input contains an integer B.
The third argument of input contains an integer C.
The fourth argument of input contains an integer D.
The fifth argument of input contains an integer E.
The sixth argument of input contains an integer F.



Output Format

If it is possible to reach the destination point, return the minimum number of moves.
Else return -1.



Example Input

Input 1:

 A = 8
 B = 8
 C = 1
 D = 1
 E = 8
 F = 8
Input 2:

 A = 2
 B = 4
 C = 2
 D = 1
 E = 4
 F = 4


Example Output

Output 1:

 6
Output 2:

 -1


Example Explanation

Explanation 1:

 The size of the chessboard is 8x8, the knight is initially at (1, 1) and the knight wants to reach position (8, 8).
 The minimum number of moves required for this is 6.
Explanation 2:

 It is not possible to move knight to position (4, 4) from (2, 1)
 */
public class chessBoardKnight {
    public int knight(int A, int B, int C, int D, int E, int F) {
        // If source and destination are the same
        if (C == E && D == F) {
            return 0;
        }
        // Directions for knight's 8 possible moves
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
        // Queue for BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{C, D, 0}); // {current_x, current_y, steps}
        // Visited array
        boolean[][] visited = new boolean[A + 1][B + 1];
        visited[C][D] = true;
        // BFS loop
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int steps = current[2];
            // Explore all 8 possible moves
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // Check if the new position is within bounds and not visited
                if (nx >= 1 && nx <= A && ny >= 1 && ny <= B && !visited[nx][ny]) {
                    // If the destination is reached
                    if (nx == E && ny == F) {
                        return steps + 1;
                    }
                    // Mark the position as visited and add to queue
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, steps + 1});
                }
            }
        }
        // If destination is not reachable
        return -1;
    }    
}
