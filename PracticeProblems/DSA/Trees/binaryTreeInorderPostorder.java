/*
 * Problem Description
Given the inorder and postorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First argument is an integer array A denoting the inorder traversal of the tree.

Second argument is an integer array B denoting the postorder traversal of the tree.



Output Format
Return the root node of the binary tree.



Example Input
Input 1:

 A = [2, 1, 3]
 B = [2, 3, 1]
Input 2:

 A = [6, 1, 3, 2]
 B = [6, 3, 2, 1]


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
public class binaryTreeInorderPostorder {
   private HashMap<Integer, Integer> inorderIndexMap;
   private int postIndex;

   public TreeNode buildTree(int[] A, int[] B) {
       inorderIndexMap = new HashMap<>();
       for (int i = 0; i < A.length; i++) {
           inorderIndexMap.put(A[i], i);
       }
       postIndex = B.length - 1;
       return constructTree(A, B, 0, A.length - 1);
   }

   private TreeNode constructTree(int[] inorder, int[] postorder, int inStart, int inEnd) {
       if (inStart > inEnd) {
           return null;
       }

       // The current root is the last element of postorder (tracked by postIndex)
       int rootVal = postorder[postIndex];
       TreeNode root = new TreeNode(rootVal);
       postIndex--;
       // Find the index of the root in inorder traversal
       int inIndex = inorderIndexMap.get(rootVal);
       root.right = constructTree(inorder, postorder, inIndex + 1, inEnd);
       root.left = constructTree(inorder, postorder, inStart, inIndex - 1);
       return root;
   }
}
