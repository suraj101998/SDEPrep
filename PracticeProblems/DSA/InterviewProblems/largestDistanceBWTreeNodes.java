package PracticeProblems.DSA.InterviewProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Problem Description

Find largest distance Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes.

The goal of the problem is to find largest distance between two nodes in a tree. Distance between two nodes is a number of edges on a path between the nodes (there will be a unique path between any pair of nodes since it is a tree).

The nodes will be numbered 0 through N - 1.

The tree is given as an array A, there is an edge between nodes A[i] and i (0 <= i < N). Exactly one of the i's will have A[i] equal to -1, it will be root node.



Problem Constraints

2 <= |A| <= 40000



Input Format

First and only argument is vector A



Output Format

Return the length of the longest path



Example Input

Input 1:

 
A = [-1, 0]
Input 2:

 
A = [-1, 0, 0]


Example Output

Output 1:

 1
Output 2:

 2


Example Explanation

Explanation 1:

 Path is 0 -> 1.
Explanation 2:

 Path is 1 -> 0 -> 2.
 */
public class largestDistanceBWTreeNodes {
    public int solve(int[] A) {
        int n = A.length;

        // Build the adjacency list representation of the tree
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (A[i] == -1) {
                root = i; // Identify the root
            } else {
                tree.get(A[i]).add(i);
                tree.get(i).add(A[i]);
            }
        }

        // Step 1: Find the farthest node from the root
        int[] firstBFS = bfs(tree, root);
        int farthestNode = firstBFS[0];

        // Step 2: Find the farthest distance from the farthestNode
        int[] secondBFS = bfs(tree, farthestNode);
        int longestDistance = secondBFS[1];
        return longestDistance;
    }
    // BFS to find the farthest node and its distance
    private int[] bfs(List<List<Integer>> tree, int start) {
        int n = tree.size();
        boolean[] visited = new boolean[n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {start, 0}); // {node, distance}
        visited[start] = true;
        int farthestNode = start;
        int maxDistance = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int distance = current[1];
            if (distance > maxDistance) {
                maxDistance = distance;
                farthestNode = node;
            }
            for (int neighbor : tree.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[] {neighbor, distance + 1});
                }
            }
        }
        return new int[] {farthestNode, maxDistance};
    }    
}
