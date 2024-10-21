package PracticeProblems.DSA.LinkedList;
/*
 * Problem Description
Sort a linked list, A in O(n log n) time.

Problem Constraints
0 <= |A| = 105

Input Format
The first and the only arugment of input contains a pointer to the head of the linked list, A.

Output Format
Return a pointer to the head of the sorted linked list.

Example Input
Input 1:
A = [3, 4, 2, 8]
Input 2:
A = [1]

Example Output
Output 1:
[2, 3, 4, 8]
Output 2:
[1]

Example Explanation
Explanation 1:
 The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].
Explanation 2:
 The sorted form of [1] is [1].
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class sortLists {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMiddle(head);
        ListNode nextOfMiddle = middle.next;
        middle.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(nextOfMiddle);
        return mergeTwoLists(left, right);
    }
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }

        return dummy.next;
    }
}
