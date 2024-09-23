package ScalerProblems.DSA.LinkedList;
/*
 * Problem Description
You are given A which is the head of a linked list. Also given is the value B and position C. Complete the function that should insert a new node with the said value at the given position.

Notes:

In case the position is more than length of linked list, simply insert the new node at the tail only.
In case the pos is 0, simply insert the new node at head only.
Follow 0-based indexing for the node numbering.


Problem Constraints
0 <= size of linked list <= 105

1 <= value of nodes <= 109

1 <= B <= 109

0 <= C <= 105



Input Format
The first argument A is the head of a linked list.

The second argument B is an integer which denotes the value of the new node

The third argument C is an integer which denotes the position of the new node



Output Format
Return the head of the linked list


Example Input
Input 1:
A = 1 -> 2
B = 3
C = 0
Input 2:
A = 1 -> 2
B = 3
C = 1


Example Output
Output 1:
3 -> 1 -> 2
Output 2:
1 -> 3 -> 2


Example Explanation
For Input 1:
The new node is add to the head of the linked list
For Input 2:
The new node is added after the first node of the linked list
 */
// class ListNode {
//      public int val;
//      public ListNode next;
//      ListNode(int x) { val = x; next = null; }
//  }
public class insertInLinkedList {
    public ListNode solve(ListNode A, int B, int C) {
        // Create the new node with value B
        ListNode newNode = new ListNode(B);
        // Case 1: If the list is empty, return the new node as the head
        if (A == null) {
            return newNode;
        }
        // Case 2: Inserting at the head (position 0)
        if (C == 0) {
            newNode.next = A;
            return newNode;
        }
        // Case 3: Traverse the list to find the insertion point
        ListNode temp = A;
        int count = 0;
        while (temp != null && count < C - 1) {
            temp = temp.next;
            count++;
        }
        // If we reach the end of the list, append the node at the end
        if (temp == null) {
            // Traverse to the last node
            temp = A;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode; // Append the new node at the end
            return A;
        }
        // Case 4: Insert the new node in the middle
        newNode.next = temp.next;
        temp.next = newNode;
        return A;
    }
}
