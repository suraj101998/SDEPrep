package DSA.Advanced.LinkedList;
/*
 * Problem Description
Given a linked list where every node represents a linked list and contains two pointers of its type:
Pointer to next node in the main list (right pointer)
Pointer to a linked list where this node is head (down pointer). All linked lists are sorted.
You are asked to flatten the linked list into a single list. Use down pointer to link nodes of the flattened list. The flattened linked list should also be sorted.

Problem Constraints
1 <= Total nodes in the list <= 100000
1 <= Value of node <= 109

Input Format
The only argument given is head pointer of the doubly linked list.

Output Format
Return the head pointer of the Flattened list.

Example Input
Input 1:

   3 -> 4 -> 20 -> 20 ->30
   |    |    |     |    |
   7    11   22    20   31
   |               |    |
   7               28   39
   |               |
   8               39
Input 2:

   2 -> 4 
   |    |       
   7    11    
   |            
   7

Example Output
Output 1:
 3 -> 4 -> 7 -> 7 -> 8 -> 11 -> 20 -> 20 -> 20 -> 22 -> 28 -> 30 -> 31 -> 39 -> 39 
Output 2:
 2 -> 4 -> 7 -> 7 -> 11

Example Explanation
Explanation 1:
 The return linked list is the flatten sorted list.
 */

class ListNode {
    int val;
    ListNode right, down;
    ListNode(int x) {
        val = x;
        right = down = null;
    }
}

public class flattenLinkedList {
    ListNode flatten(ListNode root) {
        if (root == null || root.right == null) {
                return root;
            }
            root.right = flatten(root.right);
            root = merge(root, root.right);
            return root;
    }
    ListNode merge(ListNode a, ListNode b) {
            if (a == null) return b;
            if (b == null) return a;
            ListNode result;
            if (a.val < b.val) {
                result = a;
                result.down = merge(a.down, b);
            } else {
                result = b;
                result.down = merge(a, b.down);
            }
            result.right = null;
            return result;
    }
}
