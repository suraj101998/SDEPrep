package DSA.Advanced.Trees;
/*
 * Problem Description
Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.
The diameter of a tree is the number of edges on the longest path between two nodes in the tree.

Problem Constraints
0 <= N <= 105

Input Format
First and only Argument represents the root of binary tree A.

Output Format
Return an single integer denoting the diameter of the tree.

Example Input
Input 1:
           1
         /   \
        2     3
       / \
      4   5
Input 2:
            1
          /   \
         2     3
        / \     \
       4   5     6

Example Output
Output 1:
 3
Output 2:
 4

Example Explanation
Explanation 1:
 Longest Path in the tree is 4 -> 2 -> 1 -> 3 and the number of edges in this path is 3 so diameter is 3.
Explanation 2:
 Longest Path in the tree is 4 -> 2 -> 1 -> 3 -> 6 and the number of edges in this path is 4 so diameter is 4.
 */

public class binaryTreeDiameter {
    private int maxDiameter = 0;
    public int solve(TreeNode A) {
        height(A);
        return maxDiameter;
    }
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }    
}
