package CodingInterview;
/*
 * Equal
 * 
 * a company hierarchy where the employees are represented as nodes in a tree. 
 * The tree is defined by the manager array, where each index corresponds to an employee, and the value at that index indicates their manager. The headID represents the root of the tree (the top manager, i.e., CEO).
The goal is to calculate the total time required to inform all employees about some information, starting from the headID. The time to inform each employee is represented by the informTime array.
Input: n=6, headID=2, manager= [2 2 -1 2 2 2], informTime= [0 0 1 0 0] output= 1
 */
import java.util.ArrayList;
import java.util.List;

public class equalCascade {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // Step 1: Build the tree structure from the manager array
        List<List<Integer>> subordinates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            subordinates.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                subordinates.get(manager[i]).add(i);
            }
        }

        // Step 2: DFS to calculate the total time required
        return dfs(headID, subordinates, informTime);
    }

    private int dfs(int current, List<List<Integer>> subordinates, int[] informTime) {
        int maxTime = 0;
        for (int subordinate : subordinates.get(current)) {
            maxTime = Math.max(maxTime, dfs(subordinate, subordinates, informTime));
        }
        return maxTime + informTime[current];
    }

    // Driver code for testing
    public static void main(String[] args) {
        equalCascade solution = new equalCascade();
        int n = 6;
        int headID = 2;
        int[] manager = {2, 2, -1, 2, 2, 2};
        int[] informTime = {0, 0, 1, 0, 0, 0};
        int result = solution.numOfMinutes(n, headID, manager, informTime);
        System.out.println(result); // Output: 1
    }
}

