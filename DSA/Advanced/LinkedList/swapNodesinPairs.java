package DSA.Advanced.LinkedList;
/*
 * Problem Description
Given a linked list A, swap every two adjacent nodes and return its head.
NOTE: Your algorithm should use only constant space. You may not modify the values in the list; only nodes themselves can be changed.

Problem Constraints
1 <= |A| <= 106

Input Format
The first and the only argument of input contains a pointer to the head of the given linked list.

Output Format
Return a pointer to the head of the modified linked list.

Example Input
Input 1:
 A = 1 -> 2 -> 3 -> 4
Input 2:
 A = 7 -> 2 -> 1

Example Output
Output 1:
 2 -> 1 -> 4 -> 3
Output 2:
 2 -> 7 -> 1

Example Explanation
Explanation 1:
 In the first example (1, 2) and (3, 4) are the adjacent nodes. Swapping them will result in 2 -> 1 -> 4 -> 3
Explanation 2:
 In the second example, 3rd element i.e. 1 does not have an adjacent node, so it won't be swapped. 
 */

/**
 * Definition for singly-linked list.
 * class Node {
 *     public int val;
 *     public Node next;
 *     Node(int x) { val = x; next = null; }
 * }
 */

public class swapNodesinPairs {
    public Node swapPairs(Node A) {
        if (A == null || A.next == null) {
            return A;
        }
        Node dummy = new Node(0);
        dummy.next = A;
        Node prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            Node first = prev.next;
            Node second = first.next;
            first.next = second.next;
            second.next = first;
            prev.next = second;
            prev = first;
        }
        return dummy.next;
    }   
}
