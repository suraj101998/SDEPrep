package DSA.Advanced.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * Problem Description
Given a undirected weighted graph with A nodes labelled from 1 to A with M edges given in a form of 2D-matrix B of size M * 3 where B[i][0] and B[i][1] denotes the two nodes connected by an edge of weight B[i][2].
For each edge check whether it belongs to any of the possible minimum spanning tree or not , return 1 if it belongs else return 0.
Return an one-dimensional binary array of size M denoting answer for each edge.

NOTE:
The graph may be disconnected in that case consider mst for each component.
No self-loops and no multiple edges present.
Answers in output array must be in order with the input array B output[i] must denote the answer of edge B[i][0] to B[i][1].

Problem Constraints
1 <= A, M <= 3*105
1 <= B[i][0], B[i][1] <= A
1 <= B[i][1] <= 103

Input Format
The first argument given is an integer A representing the number of nodes in the graph.
The second argument given is an matrix B of size M x 3 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1] with weight B[i][2].

Output Format
Return an one-dimensional binary array of size M denoting answer for each edge.

Example Input
Input 1:
 A = 3
 B = [ [1, 2, 2]
       [1, 3, 2]
       [2, 3, 3]
     ]

Example Output
Output 1:
 [1, 1, 0]

Example Explanation
Explanation 1:
 Edge (1, 2) with weight 2 is included in the MST           1
                                                          /   \
                                                         2     3
 Edge (1, 3) with weight 2 is included in the same MST mentioned above.
 Edge (2,3) with weight 3 cannot be included in any of the mst possible.
 So we will return [1, 1, 0]
 */

public class edgeInMST {
    static class UnionFind {
        int[] parent, rank;

        UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]); // Path compression
            }
            return parent[node];
        }

        boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if (rootU == rootV) {
                return false; // Already connected
            }
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
            return true;
        }
    }

    public static int[] solve(int A, int[][] B) {
        int M = B.length;
        int[] result = new int[M];

        // Store edges with their original index for result mapping
        int[][] edges = new int[M][4];
        for (int i = 0; i < M; i++) {
            edges[i][0] = B[i][0]; // Node 1
            edges[i][1] = B[i][1]; // Node 2
            edges[i][2] = B[i][2]; // Weight
            edges[i][3] = i;       // Original index
        }

        // Sort edges by weight
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));

        // Initialize Union-Find
        UnionFind uf = new UnionFind(A + 1);

        int i = 0;
        while (i < M) {
            int weight = edges[i][2];

            // Collect all edges with the same weight
            List<int[]> candidates = new ArrayList<>();
            while (i < M && edges[i][2] == weight) {
                candidates.add(edges[i]);
                i++;
            }

            // Check for inclusion of these edges in the MST
            List<int[]> toUnion = new ArrayList<>();
            for (int[] edge : candidates) {
                int u = edge[0];
                int v = edge[1];
                if (uf.find(u) != uf.find(v)) {
                    result[edge[3]] = 1; // Mark as included in MST
                    toUnion.add(edge);  // Queue for actual union operation
                }
            }

            // Perform union after evaluating the batch
            for (int[] edge : toUnion) {
                uf.union(edge[0], edge[1]);
            }
        }

        return result;
    }
    public static void main(String[] args){
        int A = 3;
        int[][] B = {
            {1, 2, 2},
            {1, 3, 2},
            {2, 3, 3}
        };
        int[] result = solve(A, B);
        System.out.println("ans: "+Arrays.toString(result));
    }    
}
