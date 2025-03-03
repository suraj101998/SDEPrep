package DSA.Advanced.Trees;
/*
 * Problem Description

Given a binary search tree A, where each node contains a positive integer, and an integer B, you have to find whether or not there exist two different nodes X and Y such that X.value + Y.value = B.

Return 1 to denote that two such nodes exist. Return 0, otherwise.



Problem Constraints

1 <= size of tree <= 100000

1 <= B <= 109



Input Format

First argument is the head of the tree A.

Second argument is the integer B.



Output Format

Return 1 if such a pair can be found, 0 otherwise.



Example Input

Input 1:

         10
         / \
        9   20

B = 19
Input 2:

 
          10
         / \
        9   20

B = 40


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 10 + 9 = 19. Hence 1 is returned.
Explanation 2:

 No such pair exists.
 */
import java.util.List;
import java.util.ArrayList;
public class twoSumBST {
    public int t2Sum(TreeNode A, int B) {
        List<Integer> inorderList = new ArrayList<>();
        inOrderTraversal(A, inorderList);
        int l = 0;
        int r = inorderList.size() - 1;
        while (l < r) {
            int sum = inorderList.get(l) + inorderList.get(r);
            
            if (sum == B) {
                return 1;
            } else if (sum < B) {
                l++;
            } else {
                r--;
            }
        }
        
        return 0;
    }
    private void inOrderTraversal(TreeNode node, List<Integer> inorderList) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, inorderList);
        inorderList.add(node.val);
        inOrderTraversal(node.right, inorderList);
    }
}
