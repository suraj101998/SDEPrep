package DSA.Advanced.Trees;
/*
 * Problem Description
Given a binary tree, return the inorder traversal of its nodes' values.
NOTE: Using recursion and stack are not allowed.

Problem Constraints
1 <= number of nodes <= 105

Input Format
First and only argument is root node of the binary tree, A.

Output Format
Return an integer array denoting the inorder traversal of the given binary tree.

Example Input
Input 1:
   1
    \
     2
    /
   3
Input 2:
   1
  / \
 6   2
    /
   3

Example Output
Output 1:
 [1, 3, 2]
Output 2:
 [6, 1, 3, 2]

Example Explanation
Explanation 1:
 The Inorder Traversal of the given tree is [1, 3, 2].
Explanation 2:
 The Inorder Traversal of the given tree is [6, 1, 3, 2].
 */

import java.util.ArrayList;

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *         val = x;
 *         left = null;
 *         right = null;
 *     }
 * }
 */
public class morrisInorderTraversal {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode current = A;
        while (current != null) {
            if (current.left == null) {
                result.add(current.val);
                current = current.right;
            } else {
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;
                    result.add(current.val);
                    current = current.right;
                }
            }
        }
        return result;
    }
}
