package DSA.Advanced.Trees;
/*
 * Problem Description

Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST), where each internal node (non-leaf nodes) have exactly one child.



Problem Constraints

1 <= number of nodes <= 100000



Input Format

First and only argument is an integer array denoting the preorder traversal of binary tree.



Output Format

Return a string "YES" if true else "NO".



Example Input

Input 1:

 A : [4, 10, 5, 8]
Input 2:

 A : [1, 5, 6, 4]


Example Output

Output 1:

 "YES"
Output 2:

 "NO"


Example Explanation

Explanation 1:

 The possible BST is:
            4
             \
             10
             /
             5
              \
              8
Explanation 2:

 There is no possible BST which have the above preorder traversal.
 */
public class BSTWithOneChild {
    public String solve(int[] A) {
        if (A.length == 0) {
            return "YES";
        }
        int lowerBound = Integer.MIN_VALUE;
        int upperBound = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                if (A[i] <= lowerBound) {
                    return "NO";
                }
                upperBound = A[i - 1];
            } else {
                if (A[i] >= upperBound) {
                    return "NO";
                }
                lowerBound = A[i - 1];
            }
        }
        return "YES";
    }
}
