package DSA.Advanced.Trees;
/*
 * Problem Description
Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.

Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format
First and only argument is head of the binary tree A.



Output Format
Return an array, representing the right view of the binary tree.



Example Input
Input 1:

 
            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8 
Input 2:

 
            1
           /  \
          2    3
           \
            4
             \
              5


Example Output
Output 1:

 [1, 3, 7, 8]
Output 2:

 [1, 3, 4, 5]


Example Explanation
Explanation 1:

Right view is described.
Explanation 2:

Right view is described.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binaryTreeRightView {
    public int[] solve(TreeNode A) {
        if (A == null) {
            return new int[0];
        }
        List<Integer> rightView = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);

        // Level order traversal
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode rn = q.poll();
                // Only add the last node of each level
                if (i == sz-1) {
                    rightView.add(rn.val);
                }
                // Enqueue the left and right children
                if (rn.left != null) {
                    q.add(rn.left);
                }
                if (rn.right != null) {
                    q.add(rn.right);
                }
            }
        }
        int[] result = new int[rightView.size()];
        for (int i = 0; i < rightView.size(); i++) {
            result[i] = rightView.get(i);
        }
        return result;
    }
}
