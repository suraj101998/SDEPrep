package DSA.Advanced.Trees;
/*
 * Problem Description
Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.



Problem Constraints
1 <= size of tree <= 100000

0 <= value of node <= 109



Input Format
First and only argument is head of tree A.



Output Format
Return 1 if the tree can be partitioned into two trees of equal sum else return 0.



Example Input
Input 1:

 
                5
               /  \
              3    7
             / \  / \
            4  6  5  6
Input 2:

 
                1
               / \
              2   10
                  / \
                 20  2


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 Remove edge between 5(root node) and 7: 
        Tree 1 =                                               Tree 2 =
                        5                                                     7
                       /                                                     / \
                      3                                                     5   6    
                     / \
                    4   6
        Sum of Tree 1 = Sum of Tree 2 = 18
Explanation 2:
 The given Tree cannot be partitioned.
 */
import java.util.ArrayList;
import java.util.List;

public class equalTreePartition {
    private boolean canPartition = false;
    private int totalSum = 0;

    private int calculateTotalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + calculateTotalSum(node.left) + calculateTotalSum(node.right);
    }

    private int calculateSubtreeSum(TreeNode node) {
        if (node == null) return 0;
        int currentSum = node.val + calculateSubtreeSum(node.left) + calculateSubtreeSum(node.right);
        if (currentSum * 2 == totalSum) {
            canPartition = true;
        }
        return currentSum;
    }

    public int solve(TreeNode A) {
        if (A == null) return 0;
        totalSum = calculateTotalSum(A);
        if (totalSum % 2 != 0) {
            return 0;
        }
        calculateSubtreeSum(A);
        if (canPartition) {
            return 1;
        } else {
            return 0;
        }
    }
}
