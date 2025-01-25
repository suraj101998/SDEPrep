package DSA.Advanced.Graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem Description

Given a matrix of integers A of size N x M consisting of 0, 1 or 2.

Each cell can have three values:

The value 0 representing an empty cell.

The value 1 representing a fresh orange.

The value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.

Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.



Problem Constraints

1 <= N, M <= 1000

0 <= A[i][j] <= 2



Input Format

The first argument given is the integer matrix A.



Output Format

Return the minimum number of minutes that must elapse until no cell has a fresh orange.

If this is impossible, return -1 instead.



Example Input

Input 1:


A = [   [2, 1, 1]
        [1, 1, 0]
        [0, 1, 1]   ]


Input 2:


 
A = [   [2, 1, 1]
        [0, 1, 1]
        [1, 0, 1]   ]








Example Output

Output 1:

 4
Output 2:

 -1


Example Explanation

Explanation 1:

Minute 0: [ [2, 1, 1]
            [1, 1, 0]
            [0, 1, 1] ]
Minute 1: [ [2, 2, 1]
            [2, 1, 0]
            [0, 1, 1] ]
Minute 2: [ [2, 2, 2]
            [2, 2, 0]
            [0, 1, 1] ]
Minute 3: [ [2, 2, 2]
            [2, 2, 0]
            [0, 2, 1] ]
Minute 4: [ [2, 2, 2]
            [2, 2, 0]
            [0, 2, 2] ]
At Minute 4, all the oranges are rotten.
Explanation 2:

The fresh orange at 2nd row and 0th column cannot be rotten, So return -1.
 */
public class rottenOranges {
    public int solve(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        // Step 1: Initialize queue and count fresh oranges
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (A[i][j] == 2) {
                    // Add rotten orange to the queue
                    queue.add(new int[]{i, j});
                } else if (A[i][j] == 1) {
                    // Count fresh oranges
                    freshCount++;
                }
            }
        }
        // Step 2: Edge case - no fresh oranges
        if (freshCount == 0) return 0;
        // Step 3: BFS setup
        int minutes = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean newRotten = false;
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0], y = current[1];
                // Check all 4 directions
                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    // If within bounds and has a fresh orange
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && A[nx][ny] == 1) {
                        // Rot the fresh orange
                        A[nx][ny] = 2;
                        queue.add(new int[]{nx, ny});
                        freshCount--;
                        newRotten = true;
                    }
                }
            }
            // Increment time if at least one orange rotted this round
            if (newRotten) minutes++;
        }
        // Step 4: Check if all fresh oranges are rotten
        return freshCount == 0 ? minutes : -1;
    }    
}
