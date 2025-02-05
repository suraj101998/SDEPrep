package DSA.Advanced.Trees;
/*
 * Problem Description
Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9

Input Format
First and only argument is head of the binary tree A.

Output Format
Return an integer, representing the Bth element.

Example Input
Input 1:
            2
          /   \
         1    3
B = 2
Input 2: 
            3
           /
          2
         /
        1
B = 1

Example Output
Output 1:
 2
Output 2:
 1

Example Explanation
Explanation 1:
2nd element is 2.
Explanation 2:
1st element is 1.
 */

public class KthSmallestElementinBST {
    private int count = 0;
    private int result = -1;
    public int kthsmallest(TreeNode root, int B) {
        inorderTraversal(root, B);
        return result;
    }
    private void inorderTraversal(TreeNode node, int B) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, B);
        count++;
        if (count == B) {
            result = node.val;
            return;
        }
        inorderTraversal(node.right, B);
    }
}
