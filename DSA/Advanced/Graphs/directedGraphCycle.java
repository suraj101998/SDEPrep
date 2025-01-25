package DSA.Advanced.Graphs;

import java.util.ArrayList;

/*
 * Problem Description

Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

The cycle must contain atleast two nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints

2 <= A <= 105

1 <= M <= min(200000,A*(A-1))

1 <= B[i][0], B[i][1] <= A



Input Format

The first argument given is an integer A representing the number of nodes in the graph.

The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].



Output Format

Return 1 if cycle is present else return 0.



Example Input

Input 1:

 A = 5
 B = [  [1, 2] 
        [4, 1] 
        [2, 4] 
        [3, 4] 
        [5, 2] 
        [1, 3] ]
Input 2:

 A = 5
 B = [  [1, 2]
        [2, 3] 
        [3, 4] 
        [4, 5] ]


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1
Explanation 2:

 The given graph doesn't contain any cycle.
 */
public class directedGraphCycle {
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        // Mark the node as being visited (part of the current DFS path)
        visited[node] = 1;
        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 1) {
                // Cycle detected, since the neighbor is in the current DFS path
                return true;
            }
            if (visited[neighbor] == 0) {
                // If the neighbor is not visited, perform DFS on it
                if (dfs(neighbor, adj, visited)) {
                    return true;
                }
            }
        }
        // Mark the node as completely processed
        visited[node] = 2;
        return false;
    }

    public int solve(int A, int[][] B) {
        // Step 1: Build the adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : B) {
            adj.get(edge[0]).add(edge[1]);
        }
        // Step 2: Initialize visited array to keep track of visit states
        int[] visited = new int[A + 1];  // 0 = unvisited, 1 = visiting, 2 = visited
        // Step 3: Perform DFS on each unvisited node
        for (int i = 1; i <= A; i++) {
            if (visited[i] == 0) {  // If the node has not been visited
                if (dfs(i, adj, visited)) {
                    return 1;  // Cycle detected
                }
            }
        } 
        // Step 4: No cycle found
        return 0;
    }    
}
