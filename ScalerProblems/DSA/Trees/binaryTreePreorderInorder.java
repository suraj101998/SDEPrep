/*
 * Problem Description
Given preorder and inorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First argument is an integer array A denoting the preorder traversal of the tree.

Second argument is an integer array B denoting the inorder traversal of the tree.



Output Format
Return the root node of the binary tree.



Example Input
Input 1:

 A = [1, 2, 3]
 B = [2, 1, 3]
Input 2:

 A = [1, 6, 2, 3]
 B = [6, 1, 3, 2]


Example Output
Output 1:

   1
  / \
 2   3
Output 2:

   1  
  / \
 6   2
    /
   3


Example Explanation
Explanation 1:

 Create the binary tree and return the root node of the tree.
 */
import java.util.*;
public class binaryTreePreorderInorder {
    private HashMap<Integer, Integer> inorderIndexMap;
    private int preIndex;

    public TreeNode buildTree(int[] A, int[] B) {
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            inorderIndexMap.put(B[i], i);
        }
        preIndex = 0;
        return constructTree(A, B, 0, B.length - 1);
    }

    private TreeNode constructTree(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        // The current root is the element at preIndex in preorder (root of the current subtree)
        int rootVal = preorder[preIndex];
        TreeNode root = new TreeNode(rootVal);
        preIndex++;
        int inIndex = inorderIndexMap.get(rootVal);

        // Build the left and right subtrees
        root.left = constructTree(preorder, inorder, inStart, inIndex - 1);
        root.right = constructTree(preorder, inorder, inIndex + 1, inEnd);
        return root;
    }
}
