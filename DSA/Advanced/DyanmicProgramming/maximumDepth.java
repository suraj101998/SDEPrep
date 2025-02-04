package DSA.Advanced.DyanmicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Problem Description

Given a Tree of A nodes having A-1 edges. Each node is numbered from 1 to A where 1 is the root of the tree.

You are given Q queries. In each query, you will be given two integers L and X. Find the value of such node which lies at level L mod (MaxDepth + 1) and has value greater than or equal to X.

Answer to the query is the smallest possible value or -1, if all the values at the required level are smaller than X.

NOTE:

Level and Depth of the root is considered as 0.
It is guaranteed that each edge will be connecting exactly two different nodes of the tree.
Please read the input format for more clarification.


Problem Constraints

2 <= A, Q(size of array E and F) <= 105

1 <= B[i], C[i] <= A

1 <= D[i], E[i], F[i] <= 106



Input Format

The first argument is an integer A denoting the number of nodes.

The second and third arguments are the integer arrays B and C where for each i (0 <= i < A-1), B[i] and C[i] are the nodes connected by an edge.

The fourth argument is an integer array D, where D[i] denotes the value of the (i+1)th node

The fifth and sixth arguments are the integer arrays E and F where for each i (0 <= i < Q), E[i] denotes L and F[i] denotes X for ith query.



Output Format

Return an array of integers where the ith element denotes the answer to ith query.



Example Input

Input 1:

 A = 5
 B = [1, 4, 3, 1]
 C = [5, 2, 4, 4]
 D = [7, 38, 27, 37, 1]
 E = [1, 1, 2]
 F = [32, 18, 26]
Input 2:

 A = 3
 B = [1, 2]
 C = [3, 1]
 D = [7, 15, 27]
 E = [1, 10, 1]
 F = [29, 6, 26]


Example Output

Output 1:

 [37, 37, 27]
Output 2:

 [-1, 7, 27]


Example Explanation

Explanation 1:

      1[7]
     /    \
   5[1]  4[37]
        /    \
       2[38]  3[27]

 Query 1: 
    L = 1, X = 32
    Nodes for level 1 are 5, 4
    Value of Node 5 = 1 < 32
    Value of Node 4 = 37 >= 32
    Ans = 37
Explanation 2:

      1[7]
     /    \
   2[15]  3[27]

 Query 1: 
    L = 1, X = 6
    Nodes for level 1 are 2, 3 having value 15 and 27 respectively.
    Answer = -1 (Since no node is greater or equal to 29).
 Query 1: 
    L = 10 % 2 = 0, X = 6
    Nodes for level 0 is 1 having value 7.
    Answer = 7.   
 */


public class maximumDepth {

    public static int[] solve(int A, int[] B, int[] C, int[] D, int[] E, int[] F) {
        // Step 1: Build the graph
        List<Integer>[] graph = new ArrayList[A + 1];
        for (int i = 0; i <= A; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < A - 1; i++) {
            graph[B[i]].add(C[i]);
            graph[C[i]].add(B[i]);  // Since it's an undirected graph
        }
        // Step 2: DFS to calculate levels and assign node values
        int[] level = new int[A + 1];  // Level of each node
        List<Integer>[] levelNodes = new ArrayList[A + 1];  // Nodes at each level
        for (int i = 0; i <= A; i++) {
            levelNodes[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[A + 1];
        dfs(1, 0, graph, level, levelNodes, visited, D);
        // Step 3: Sort the nodes at each level
        for (int i = 0; i <= A; i++) {
            Collections.sort(levelNodes[i]);
        }
        // Step 4: Answer the queries
        int[] result = new int[E.length];
        int maxDepth = Arrays.stream(level).max().getAsInt();
        
        for (int i = 0; i < E.length; i++) {
            int levelQuery = E[i] % (maxDepth + 1);
            int minValue = F[i];
            result[i] = findSmallestGreaterThanEqual(levelNodes[levelQuery], minValue);
        }
        return result;
    }
    
    // DFS function to calculate the levels of the nodes
    private static  void dfs(int node, int currentLevel, List<Integer>[] graph, int[] level, List<Integer>[] levelNodes, boolean[] visited, int[] D) {
        visited[node] = true;
        level[node] = currentLevel;
        levelNodes[currentLevel].add(D[node - 1]);
        
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, currentLevel + 1, graph, level, levelNodes, visited, D);
            }
        }
    }
    
    // Function to find the smallest value greater than or equal to X
    private static int findSmallestGreaterThanEqual(List<Integer> levelNodes, int minValue) {
        int left = 0;
        int right = levelNodes.size() - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (levelNodes.get(mid) >= minValue) {
                result = levelNodes.get(mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    
    public static void main(String[] args){
        int A = 5;
        int[] B = {1, 4, 3, 1};
        int[] C = {5, 2, 4, 4};
        int[] D = {7, 38, 27, 37, 1};
        int[] E = {1, 1, 2};
        int[] F = {32, 18, 26};
        int[] result = solve(A, B, C, D, E, F);
        System.out.println("ans: "+Arrays.toString(result));

    }
}
