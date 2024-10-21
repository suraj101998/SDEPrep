package PracticeProblems.DSA.Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem Description
You are climbing a staircase and it takes A steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
You need to return all the distinct ways to climb to the top in lexicographical order.

Problem Constraints
2 <= A <= 25

Input Format
The first and the only argument contains an integer A, the number of steps.

Output Format
Return an 2-D Integer Array, which denotes all the unique valid paths to reach the top.

Example Input
Input 1:
 A = 2
Input 2:
 A = 3

Example Output
Output 1:
[ [1, 1], [2] ]
Output 2:
[ [1, 1, 1], [1, 2], [2, 1] ]

Example Explanation

Explanation 1:
 Distinct ways to reach top: 1 + 1, 2.

 Explanation 2:
 Distinct ways to reach top: 1 + 1 + 1, 1 + 2, 2 + 1.
 */
public class printStaircasePaths {
    public int[][] WaysToClimb(int A) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        backtrack(A, currentPath, result);
        int[][] paths = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            List<Integer> path = result.get(i);
            paths[i] = path.stream().mapToInt(Integer::intValue).toArray();
        }
        return paths;
    }
    private void backtrack(int remainingSteps, List<Integer> currentPath, List<List<Integer>> result) {
        if (remainingSteps == 0) {
            result.add(new ArrayList<>(currentPath));
            return;
        }
        if (remainingSteps >= 1) {
            currentPath.add(1);
            backtrack(remainingSteps - 1, currentPath, result);
            currentPath.remove(currentPath.size() - 1); // Backtrack
        }
        if (remainingSteps >= 2) {
            currentPath.add(2);
            backtrack(remainingSteps - 2, currentPath, result);
            currentPath.remove(currentPath.size() - 1); // Backtrack
        }
    }
}
