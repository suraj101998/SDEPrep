package PracticeProblems.DSA.LinkedList;
/*
 * Problem Description
Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list.



Problem Constraints
1 <= |A| <= 103

B always divides A



Input Format
The first argument of input contains a pointer to the head of the linked list.

The second arugment of input contains the integer, B.



Output Format
Return a pointer to the head of the modified linked list.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5, 6]
 B = 2
Input 2:

 A = [1, 2, 3, 4, 5, 6]
 B = 3


Example Output
Output 1:

 [2, 1, 4, 3, 6, 5]
Output 2:

 [3, 2, 1, 6, 5, 4]


Example Explanation
Explanation 1:

 For the first example, the list can be reversed in groups of 2.
    [[1, 2], [3, 4], [5, 6]]
 After reversing the K-linked list
    [[2, 1], [4, 3], [6, 5]]
Explanation 2:

 For the second example, the list can be reversed in groups of 3.
    [[1, 2, 3], [4, 5, 6]]
 After reversing the K-linked list
    [[3, 2, 1], [6, 5, 4]]
 */
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
public class KreverseLinkedList {
    public ListNode reverseList(ListNode A, int B) {
        if (A == null || B <= 1) {
            return A;
        }
        
        ListNode newNode = new ListNode(0);
        newNode.next = A;
        ListNode prevGroupEnd = newNode;
        ListNode current = A;
        while (current != null) {
            ListNode groupStart = current;
            ListNode groupEnd = current;
            for (int i = 1; i < B && groupEnd != null; i++) {
                groupEnd = groupEnd.next;
            }
            if (groupEnd == null) {
                break;
            }
            ListNode nextGroupStart = groupEnd.next;
            // Disconnect the current group from the next one
            groupEnd.next = null;
            // Reverse the current group
            ListNode reversedGroupHead = reverse(groupStart);
            prevGroupEnd.next = reversedGroupHead;
            groupStart.next = nextGroupStart;
            prevGroupEnd = groupStart;
            current = nextGroupStart;
        }
        return newNode.next;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        } 
        return prev;
    }
}
