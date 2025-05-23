package DSA.Advanced.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * Problem Description
Given a weighted undirected graph having A nodes, a source node C and destination node D.
Find the shortest distance from C to D and if it is impossible to reach node D from C then return -1.
You are expected to do it in Time Complexity of O(A + M).

Note:
There are no self-loops in the graph.
No multiple edges between two pair of vertices.
The graph may or may not be connected.
Nodes are Numbered from 0 to A-1.
Your solution will run on multiple testcases. If you are using global variables make sure to clear them.

Problem Constraints
1 <= A <= 105
0 <= B[i][0], B[i][1] < A
1 <= B[i][2] <= 2
0 <= C < A
0 <= D < A

Input Format
The first argument given is an integer A, representing the number of nodes.
The second argument given is the matrix B, where B[i][0] and B[i][1] are connected through an edge of weight B[i][2].
The third argument given is an integer C, representing the source node.
The fourth argument is an integer D, representing the destination node.
Note: B[i][2] will be either 1 or 2.

Output Format
Return the shortest distance from C to D. If it is impossible to reach node D from C then return -1.

Example Input
Input 1:
A = 6
B = [   [2, 5, 1]
        [1, 3, 1] 
        [0, 5, 2] 
        [0, 2, 2] 
        [1, 4, 1] 
        [0, 1, 1] ] 
C = 3
D = 2

Input 2:
A = 2
B = [   [0, 1, 1]
    ] 
C = 0
D = 1

Example Output
Output 1:
 4

Output 2:
 1

Example Explanation
Explanation 1:
The path to be followed will be:
    3 -> 1 (Edge weight : 1)
    1 -> 0 (Edge weight : 1)
    0 -> 2 (Edge weight : 2)
Total length of path = 1 + 1 + 2 = 4.

Explanation 2:
 Path will be 0-> 1.
 */
public class anotherBFS {
    public static int solve(int A, int[][] B, int C, int D) {
        // Adjacency list representation of the graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the graph from the edge list
        for (int[] edge : B) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        // Distance array to store the shortest distance to each node
        int[] distance = new int[A];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[C] = 0;

        // Deque for 0-1 BFS
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(C);

        while (!deque.isEmpty()) {
            int current = deque.pollFirst();

            // Process all neighbors
            for (int[] neighbor : graph.get(current)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDist = distance[current] + weight;

                if (newDist < distance[nextNode]) {
                    distance[nextNode] = newDist;
                    if (weight == 1) {
                        deque.addFirst(nextNode);
                    } else {
                        deque.addLast(nextNode);
                    }
                }
            }
        }

        // Return the shortest distance to D or -1 if unreachable
        return distance[D] == Integer.MAX_VALUE ? -1 : distance[D];
    }
    
    public static void main(String[] args){
        int A = 6;
        int[][] B = {
            {2, 5, 1},
            {1, 3, 1},
            {0, 5, 2},
            {0, 2, 2},
            {1, 4, 1}, 
            {0, 1, 1}
        };     
        int C = 3;
        int D = 2;
        int result = solve(A, B, C, D);
        System.out.println("ans: "+result);
    }
}
