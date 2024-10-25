package PracticeProblems.DSA.Trees;
/*
 * Problem Description
Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.
Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.

Problem Constraints
1 <= size of tree <= 100000
1 <= B, C <= 109

Input Format
First argument is head of tree A.
Second argument is integer B.
Third argument is integer C.

Output Format
Return the LCA.

Example Input
Input 1:

 
      1
     /  \
    2    3
B = 2
C = 3
Input 2:

      1
     /  \
    2    3
   / \
  4   5
B = 4
C = 5

Example Output
Output 1:
 1
Output 2:
 2

Example Explanation

Explanation 1:
 LCA is 1.
Explanation 2:
 LCA is 2.
 */

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

public class leastCommonAncestor {
    public int lca(TreeNode root, int B, int C) {
        if (!findNode(root, B) || !findNode(root, C)) {
            return -1;
        }
        TreeNode lcaNode = findLCA(root, B, C);
        return lcaNode != null ? lcaNode.val : -1;
    }
    private TreeNode findLCA(TreeNode root, int B, int C) {
        if (root == null || root.val == B || root.val == C) {
            return root;
        }
        TreeNode leftLCA = findLCA(root.left, B, C);
        TreeNode rightLCA = findLCA(root.right, B, C);
        if (leftLCA != null && rightLCA != null) {
            return root;
        }
        return leftLCA != null ? leftLCA : rightLCA;
    }
    private boolean findNode(TreeNode root, int val) {
        if (root == null) {
            return false;
        }
        if (root.val == val) {
            return true;
        }
        return findNode(root.left, val) || findNode(root.right, val);
    }    
}
