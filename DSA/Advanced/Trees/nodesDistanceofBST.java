package DSA.Advanced.Trees;
/*
 * Problem Description
Given a binary search tree.
Return the distance between two nodes with given two keys B and C. It may be assumed that both keys exist in BST.
NOTE: Distance between two nodes is number of edges between them.

Problem Constraints
1 <= Number of nodes in binary tree <= 1000000
0 <= node values <= 109

Input Format
First argument is a root node of the binary tree, A.
Second argument is an integer B.
Third argument is an integer C.

Output Format
Return an integer denoting the distance between two nodes with given two keys B and C

Example Input
Input 1:    
         5
       /   \
      2     8
     / \   / \
    1   4 6   11
 B = 2
 C = 11
Input 2:

    
         6
       /   \
      2     9
     / \   / \
    1   4 7   10
 B = 2
 C = 6

Example Output
Output 1:
 3
Output 2:
 1

Example Explanation
Explanation 1:
 Path between 2 and 11 is: 2 -> 5 -> 8 -> 11. Distance will be 3.
Explanation 2:
 Path between 2 and 6 is: 2 -> 6. Distance will be 1

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

public class nodesDistanceofBST {
    public int solve(TreeNode A, int B, int C) {
        TreeNode lca = findLCA(A, B, C);
        int distanceToB = findDistance(lca, B);
        int distanceToC = findDistance(lca, C);
        return distanceToB + distanceToC;
    }
    private TreeNode findLCA(TreeNode root, int B, int C) {
        if (root == null) return null;
        if (root.val > B && root.val > C) {
            return findLCA(root.left, B, C);
        } else if (root.val < B && root.val < C) {
            return findLCA(root.right, B, C);
        }
        return root;
    }
    private int findDistance(TreeNode root, int target) {
        int distance = 0;
        while (root != null) {
            if (root.val == target) {
                return distance;
            } else if (root.val > target) {
                root = root.left;
            } else {
                root = root.right;
            }
            distance++;
        }
        return -1;
    }    
}
