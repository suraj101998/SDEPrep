package DSA.Advanced.Trees;
/*
 * Problem Description
Two elements of a Binary Search Tree (BST), represented by root A are swapped by mistake. Tell us the 2 values, when swapped, will restore the Binary Search Tree (BST).
A solution using O(n) space is pretty straightforward. Could you devise a constant space solution?
Note: The 2 values must be returned in ascending order

Problem Constraints
1 <= size of tree <= 100000

Input Format
First and only argument is the head of the tree,A

Output Format
Return the 2 elements which need to be swapped.

Example Input
Input 1:
         1 
        / \ 
       2   3
Input 2: 
         2
        / \
       3   1

Example Output
Output 1:
 [2, 1]
Output 2:
 [3, 1]

Example Explanation
Explanation 1:
Swapping 1 and 2 will change the BST to be 
         2
        / \
       1   3
which is a valid BST 
Explanation 2:
Swapping 1 and 3 will change the BST to be 
         2
        / \
       1   3
which is a valid BST 
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

public class recoverBST {
    public ArrayList<Integer> recoverTree(TreeNode A) {
        TreeNode current = A;
        TreeNode prev = null;
        TreeNode first = null, second = null;
        while (current != null) {
            if (current.left == null) {
                if (prev != null && prev.val > current.val) {
                    if (first == null) {
                        first = prev;
                    }
                    second = current;
                }
                prev = current;
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
                    if (prev != null && prev.val > current.val) {
                        if (first == null) {
                            first = prev;
                        }
                        second = current;
                    }
                    prev = current;
                    current = current.right;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(Math.min(first.val, second.val));
        result.add(Math.max(first.val, second.val));
        return result;
    }   
}
