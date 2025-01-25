package DSA.Advanced.Trees;
/*
 * Problem Description
Given two BST's A and B, return the (sum of all common nodes in both A and B) % (109 +7) .
In case there is no common node, return 0.

NOTE:
Try to do it one pass through the trees.

Problem Constraints
1 <= Number of nodes in the tree A and B <= 105
1 <= Node values <= 106

Input Format
First argument represents the root of BST A.
Second argument represents the root of BST B.

Output Format
Return an integer denoting the (sum of all common nodes in both BST's A and B) % (109 +7) .

Example Input
Input 1:

 Tree A:
    5
   / \
  2   8
   \   \
    3   15
        /
        9

 Tree B:
    7
   / \
  1  10
   \   \
    2  15
       /
      11
Input 2:

  Tree A:
    7
   / \
  1   10
   \   \
    2   15
        /
       11

 Tree B:
    7
   / \
  1  10
   \   \
    2  15
       /
      11

Example Output
Output 1:
 17
Output 2:
 46

Example Explanation
Explanation 1:
 Common Nodes are : 2, 15
 So answer is 2 + 15 = 17
Explanation 2:
 Common Nodes are : 7, 2, 1, 10, 15, 11
 So answer is 7 + 2 + 1 + 10 + 15 + 11 = 46
 */

import java.util.Stack;

public class commonNodesIn2BST {
    public int solve(TreeNode A, TreeNode B) {
        int temp = (int) common(A, B);
        return temp;
    }
    public static long common(TreeNode root1, TreeNode root2) {
        int mod = 1000000007;
        long sum = 0;
        Stack < TreeNode > s1 = new Stack < TreeNode > ();
        Stack < TreeNode > s2 = new Stack < TreeNode > ();

        while (true) {
            if (root1 != null) {
                s1.push(root1);
                root1 = root1.left;
            }
            else if (root2 != null) {
                s2.push(root2);
                root2 = root2.left;
            }  
            else if (!s1.isEmpty() && !s2.isEmpty()) {
                root1 = s1.peek();
                root2 = s2.peek();
                if (root1.val == root2.val) {
                    long temp = (long) root1.val;
                    sum = ((sum % mod) + (temp % mod)) % mod;
                    s1.pop();
                    s2.pop();
                    root1 = root1.right;
                    root2 = root2.right;
                } else if (root1.val < root2.val) {
                    s1.pop();
                    root1 = root1.right; 
                    root2 = null;
                } else if (root1.val > root2.val) {
                    s2.pop();
                    root2 = root2.right;
                    root1 = null;
                }
            }
            else
                break;
        }
        return sum;
    }    
}
