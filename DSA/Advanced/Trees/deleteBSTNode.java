package DSA.Advanced.Trees;
/*
 * Problem Description

Given a Binary Search Tree(BST) A. If there is a node with value B present in the tree delete it and return the tree.

Note - If there are multiple options, always replace a node by its in-order predecessor


Problem Constraints

2 <= No. of nodes in BST <= 105
1 <= value of nodes <= 109
Each node has a unique value


Input Format

The first argument is the root node of a Binary Search Tree A.
The second argument is the value B.


Output Format

Delete the given node if found and return the root of the BST.


Example Input

Input 1:

            15
          /    \
        12      20
        / \    /  \
       10  14  16  27
      /
     8

     B = 10

Input 2:

            8
           / \
          6  21
         / \
        1   7

     B = 6



Example Output

Output 1:

            15
          /    \
        12      20
        / \    /  \
       8  14  16  27

Output 2:

            8
           / \
          1  21
           \
            7



Example Explanation

Explanation 1:

Node with value 10 is deleted 
Explanation 2:

Node with value 6 is deleted
 */

public class deleteBSTNode {
    public TreeNode solve(TreeNode A, int B) {
        if (A == null){ return null; }
        if (A.val == B){
            if(A.left == null && A.right == null){ return null; }
            else if(A.left != null && A.right == null){ return A.left; }
            else if(A.left == null && A.right != null){ return A.right; }
            else{
                TreeNode temp = A.left;
                while (temp.right != null){
                    temp =temp.right;
                }
                int swapTemp = A.val;
                A.val = temp.val;
                temp.val = swapTemp;
                A.left = solve(A.left, B);
                return A;
            }
        }
        else if (B < A.val){ A.left = solve(A.left, B); }
        else{ A.right = solve(A.right, B); }
        return A;
    }
}
