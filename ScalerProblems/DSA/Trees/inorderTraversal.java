

import java.util.ArrayList;
import java.util.List;

/*
 * Problem Description
Given a binary tree, return the inorder traversal of its nodes' values.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return an integer array denoting the inorder traversal of the given binary tree.



Example Input
Input 1:

   1
    \
     2
    /
   3
Input 2:

   1
  / \
 6   2
    /
   3


Example Output
Output 1:

 [1, 3, 2]
Output 2:

 [6, 1, 3, 2]


Example Explanation
Explanation 1:

 The Inorder Traversal of the given tree is [1, 3, 2].
Explanation 2:

 The Inorder Traversal of the given tree is [6, 1, 3, 2].
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) {
      val = x;
      left=null;
      right=null;
     }
 }
public class inorderTraversal {
        public int[] inorderTraversal(TreeNode A) {
        List<Integer> result = new ArrayList<>();
        preOrderHelper(A, result);
        int ans[] = new int[result.size()];
        for(int i =0; i<result.size(); i++){
            ans[i]= result.get(i);
        }
        return ans;
    }
    private void preOrderHelper(TreeNode node, List<Integer> result){
        if(node==null){ return; }
        preOrderHelper(node.left, result);
        result.add(node.val);
        preOrderHelper(node.right, result);
    }
}
