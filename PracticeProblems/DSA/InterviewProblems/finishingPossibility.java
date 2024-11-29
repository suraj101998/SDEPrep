package PracticeProblems.DSA.InterviewProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Problem Description

There are a total of A courses you have to take, labeled from 1 to A.

Some courses may have prerequisites, for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].

So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.



Problem Constraints

1 <= A <= 6*104

1 <= length(B) = length(C) <= 105

1 <= B[i], C[i] <= A



Input Format

The first argument of input contains an integer A, representing the number of courses.

The second argument of input contains an integer array, B.

The third argument of input contains an integer array, C.



Output Format

Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.



Example Input

Input 1:

 A = 3
 B = [1, 2]
 C = [2, 3]
Input 2:

 A = 2
 B = [1, 2]
 C = [2, 1]


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 It is possible to complete the courses in the following order:
    1 -> 2 -> 3
Explanation 2:

 It is not possible to complete all the courses.
 */
public class finishingPossibility {
        public int solve(int A, int[] B, int[] C) {
        // Step 1: Build the graph and in-degree array
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[A + 1];
        
        for (int i = 0; i <= A; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int i = 0; i < B.length; i++) {
            adjList.get(B[i]).add(C[i]);
            inDegree[C[i]]++;
        }
        
        // Step 2: Perform topological sort using Kahn's algorithm
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= A; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int processedNodes = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            processedNodes++;
            
            for (int neighbor : adjList.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        // Step 3: Check if all nodes are processed
        return processedNodes == A ? 1 : 0;
    }
}
