package DSA.Advanced.LinkedList;
/*
 * Problem Description
Merge two sorted linked lists, A and B, and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists and should also be sorted.

Problem Constraints
0 <= |A|, |B| <= 105

Input Format
The first argument of input contains a pointer to the head of linked list A.
The second argument of input contains a pointer to the head of linked list B.

Output Format
Return a pointer to the head of the merged linked list.

Example Input
Input 1:
 A = 5 -> 8 -> 20
 B = 4 -> 11 -> 15

Input 2:
 A = 1 -> 2 -> 3
 B = Null

Example Output
Output 1:
 4 -> 5 -> 8 -> 11 -> 15 -> 20
Output 2:
 1 -> 2 -> 3

Example Explanation
Explanation 1:
 Merging A and B will result in 4 -> 5 -> 8 -> 11 -> 15 -> 20 
Explanation 2:
 We don't need to merge as B is empty. 
 */

/**
 * Definition for singly-linked list.
 * class Node {
 *     public int val;
 *     public Node next;
 *     Node(int x) { val = x; next = null; }
 * }
 */

public class merge2SortedLists {
    public Node mergeTwoLists(Node A, Node B) {
        if (A == null) return B;
        if (B == null) return A;
        Node temp = new Node(-1);
        Node current = temp;
        while (A != null && B != null) {
            if (A.val <= B.val) {
                current.next = A;
                A = A.next;
            } else {
                current.next = B;
                B = B.next;
            }
            current = current.next;
        }
        if (A != null) current.next = A;
        if (B != null) current.next = B;
        return temp.next;
    }  
}
