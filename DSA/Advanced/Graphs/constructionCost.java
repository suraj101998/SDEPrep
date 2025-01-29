package DSA.Advanced.Graphs;

import java.util.Arrays;

/*
 * Problem Description

Flipkart has ‘A’ local distribution centers located across a large metropolitan city. Each distribution center needs to be interconnected through roads to facilitate efficient movement of goods. The cost of constructing a road between any two distribution centers is represented by the weight of the edge connecting them.

Given a graph with ‘A’ nodes representing the distribution centers and C weighted edges representing the possible roads between them, your task is to find the minimum total cost of constructing roads such that every distribution center can be reached from the first distribution center.

Cost Calculation:
The cost of constructing the roads is the sum of the weights of the edges selected for the construction.

NOTE: Return the answer modulo 10^9+7 as the answer can be large.



Problem Constraints

1 <= A <= 100000
0 <= C <= 100000
1 <= B[i][0], B[i][1] <= N
1 <= B[i][2] <= 109



Input Format

First argument is an integer A.
Second argument is a 2-D integer array B of size C×3 denoting edges. B[i][0]and B[i][1]are the distribution centers connected by the ith edge with construction cost B[i][2].



Output Format

Return an integer denoting the minimum construction cost.



Example Input

Input 1:

A = 3
B = [   [1, 2, 14]
        [2, 3, 7]
        [3, 1, 2]   ]
Input 2:

A = 3
B = [   [1, 2, 20]
        [2, 3, 17]  ]


Example Output

Output 1:

9
Output 2:

37


Example Explanation

Explanation 1:
To connect the distribution centers, we can select only two roads: from center 2 to center 3 (cost 7) and from center 3 to center 1 (cost 2). This allows us to reach the first distribution center from both center 2 and center 3, resulting in a total construction cost of 7+2=9



Explanation 2:
In this case, we must construct both roads (from center 1 to center 2 and from center 2 to center 3) to ensure that all distribution centers are reachable from the first center. The total cost will be 20+17=37
 */
public class constructionCost {
    private static final int MOD = 1000000007;

    // Union-Find class with path compression and union by rank
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

        // Find the root of a component
        int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]); // Path compression
            }
            return parent[node];
        }

        // Union two components by rank
        boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if (rootU == rootV) {
                return false; // Already in the same component
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

    public int solve(int A, int[][] B) {
        // Sort edges by weight
        Arrays.sort(B, (a, b) -> Integer.compare(a[2], b[2]));

        // Initialize Union-Find for A nodes
        UnionFind uf = new UnionFind(A + 1); // Nodes are 1-indexed

        long totalCost = 0;
        int edgesUsed = 0;

        // Process edges in sorted order
        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (uf.union(u, v)) { // If this edge connects two components
                totalCost = (totalCost + weight) % MOD;
                edgesUsed++;
                if (edgesUsed == A - 1) {
                    break; // MST is complete
                }
            }
        }

        return (int) totalCost;
    }    
}
