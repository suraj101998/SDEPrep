package PracticeProblems.DSA.Trees;
/*
 * Problem Description
Given a binary tree A, invert the binary tree and return it.
Inverting refers to making the left child the right child and vice versa.

Problem Constraints
1 <= size of tree <= 100000

Input Format
First and only argument is the head of the tree A.

Output Format
Return the head of the inverted tree.

Example Input
Input 1:
 
     1
   /   \
  2     3
Input 2:
 
     1
   /   \
  2     3
 / \   / \
4   5 6   7

Example Output
Output 1:
 
     1
   /   \
  3     2
Output 2:
 
     1
   /   \
  3     2
 / \   / \
7   6 5   4

Example Explanation
Explanation 1:
Tree has been inverted.
Explanation 2:
Tree has been inverted.
 */

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */


public class invertBinaryTree {
    public TreeNode invertTree(TreeNode A) {
        if (A == null) {
            return null;
        }
        TreeNode temp = A.left;
        A.left = A.right;
        A.right = temp;
        invertTree(A.left);
        invertTree(A.right);
        return A;
    }    
}
