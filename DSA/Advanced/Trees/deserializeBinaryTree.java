package DSA.Advanced.Trees;
/*
 * Problem Description
You are given an integer array A denoting the Level Order Traversal of the Binary Tree.

You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.

NOTE:

In the array, the NULL/None child is denoted by -1.
For more clarification check the Example Input.


Problem Constraints
1 <= number of nodes <= 105

-1 <= A[i] <= 105



Input Format
Only argument is an integer array A denoting the Level Order Traversal of the Binary Tree.



Output Format
Return the root node of the Binary Tree.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
Input 2:

 A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]


Example Output
Output 1:

           1
         /   \
        2     3
       / \
      4   5
Output 2:

            1
          /   \
         2     3
        / \ .   \
       4   5 .   6


Example Explanation
Explanation 1:

 Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 Since 3, 4 and 5 each has both NULL child we had represented that using -1.
Explanation 2:

 Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 Since 3 has left child as NULL while 4 and 5 each has both NULL child.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class deserializeBinaryTree {
    public TreeNode solve(int[] A) {
        if (A.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(A[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < A.length) {
            TreeNode currentNode = queue.poll();
            // Process the left child
            if (A[i] != -1) {
                TreeNode leftChild = new TreeNode(A[i]);
                currentNode.left = leftChild;
                queue.offer(leftChild);
            }
            i++;
            // Process the right child
            if (i < A.length && A[i] != -1) {
                TreeNode rightChild = new TreeNode(A[i]);
                currentNode.right = rightChild;
                queue.offer(rightChild);
            }
            i++;
        }
        return root;
    }
}
