package CodingInterview;
/*
 * calculate the maximum depth of a binary tree
 */
// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeMaximumDepth {

    // Method to calculate maximum depth
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0; // Base case: if tree is empty, depth is 0
        }

        // Recursively find the depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Maximum depth is 1 (current node) + maximum of left and right subtree depths
        return 1 + Math.max(leftDepth, rightDepth);
    }

    // Main method
    public static void main(String[] args) {
        // Example tree:
        //         3
        //       /   \
        //      9    20
        //          /  \
        //         15   7

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int depth = maxDepth(root);
        System.out.println("Maximum Depth of the Binary Tree: " + depth); // Output: 3
    }
}

/*
 * Explanation of Approach:
Recursive Approach:
For each node, compute the depth of the left and right subtrees recursively.
The maximum depth at a given node is:
1 + max(leftDepth, rightDepth), where 1 accounts for the current node.

Base Case:
If the node is null (i.e., tree is empty or leaf node is reached), return 0.

Combine Results:
Take the maximum depth of the left and right subtrees and add 1 for the current node.

Example Walkthrough:
For the given binary tree:
        3
      /   \
     9    20
         /  \
        15   7

At node 15 and 7 (leaf nodes), depth = 1 (base case).

At node 20, depth = 1 + max(1, 1) = 2.

At node 9 (no children), depth = 1.

At root 3, depth = 1 + max(1, 2) = 3.

The maximum depth of the tree is 3.

Time Complexity:
The function visits each node exactly once.
TC = O(N), where N is the number of nodes in the binary tree.

Space Complexity:
The recursive function uses stack space proportional to the height of the tree.
In the worst case (skewed tree), the height is N, so SC = O(N).
In the best case (balanced tree), the height is log(N), so SC = O(log N).        
 */