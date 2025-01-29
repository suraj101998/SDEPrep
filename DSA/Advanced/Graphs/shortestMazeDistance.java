package DSA.Advanced.Graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Problem Description

Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls.

1 represents a wall in a matrix and 0 represents an empty location in a wall.

There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall (maze boundary is also considered as a wall). When the ball stops, it could choose the next direction.

Given two array of integers of size B and C of size 2 denoting the starting and destination position of the ball.

Find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the starting position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.



Problem Constraints

2 <= N, M <= 100

0 <= A[i] <= 1

0 <= B[i][0], C[i][0] < N

0 <= B[i][1], C[i][1] < M



Input Format

The first argument given is the integer matrix A.

The second argument given is an array of integer B.

The third argument if an array of integer C.



Output Format

Return a single integer, the minimum distance required to reach destination



Example Input

Input 1:


A = [ [0, 0], 
      [0, 0] ]
B = [0, 0]
C = [0, 1]


Input 2:

A = [ [0, 1], 
      [1, 0] ]
B = [0, 0]
C = [1, 1]












Example Output

Output 1:


 1


Output 2:

 -1












Example Explanation

Explanation 1:

 Go directly from start to destination in distance 1.
Explanation 2:

 It is impossible to reach the destination from (0, 0) to (1, 1) as there are walls at (1, 0) and (0, 1)
 */
public class shortestMazeDistance {
    public int solve(int[][] A, int[] B, int[] C) {
        int n = A.length;
        int m = A[0].length;
        // Directions for moving up, down, left, right
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // Distance array to store the shortest distance to each cell
        int[][] distance = new int[n][m];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        // Priority queue for Dijkstra's algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, B[0], B[1]}); // {distance, x, y}
        distance[B[0]][B[1]] = 0;
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currDist = current[0];
            int x = current[1];
            int y = current[2];
            // If we reach the destination
            if (x == C[0] && y == C[1]) {
                return currDist;
            }
            // Explore all four directions
            for (int[] dir : directions) {
                int newX = x, newY = y, steps = 0;
                // Roll the ball until it hits a wall or boundary
                while (newX + dir[0] >= 0 && newX + dir[0] < n &&
                       newY + dir[1] >= 0 && newY + dir[1] < m &&
                       A[newX + dir[0]][newY + dir[1]] == 0) {
                    newX += dir[0];
                    newY += dir[1];
                    steps++;
                }
                int newDist = currDist + steps;
                if (newDist < distance[newX][newY]) {
                    distance[newX][newY] = newDist;
                    pq.add(new int[]{newDist, newX, newY});
                }
            }
        }
        // If we cannot reach the destination
        return -1;
    }    
}
