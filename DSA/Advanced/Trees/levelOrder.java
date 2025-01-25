package DSA.Advanced.Trees;
/*
 * Problem Description
Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return a 2D integer array denoting the level order traversal of the given binary tree.



Example Input
Input 1:

    3
   / \
  9  20
    /  \
   15   7
Input 2:

   1
  / \
 6   2
    /
   3


Example Output
Output 1:

 [
   [3],
   [9, 20],
   [15, 7]
 ]
Output 2:

 [ 
   [1]
   [6, 2]
   [3]
 ]


Example Explanation
Explanation 1:

 Return the 2D array. Each row denotes the traversal of each level.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder {
    public int[][] solve(TreeNode A) {
        if (A == null) {
            return new int[0][0];
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);

        // Level order traversal
        while (!q.isEmpty()) {
            int sz = q.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode rn = q.poll();
                currentLevel.add(rn.val);
                // Enqueue the left and right children
                if (rn.left != null) {
                    q.add(rn.left);
                }
                if (rn.right != null) {
                    q.add(rn.right);
                }
            }
            result.add(currentLevel);
        }

        int[][] ans = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            List<Integer> level = result.get(i);
            ans[i] = new int[level.size()];
            for (int j = 0; j < level.size(); j++) {
                ans[i][j] = level.get(j);
            }
        }
        return ans;
    }
}
