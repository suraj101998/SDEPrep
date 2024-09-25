package PracticeProblems.DSA.LinkedList;
/*
 * Problem Description
Given a linked list A, remove the B-th node from the end of the list and return its head.
For example, given linked list: 1->2->3->4->5, and B = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

NOTE: If B is greater than the size of the list, remove the first node of the list.

Try doing it using constant additional space.



Problem Constraints
1 <= |A| <= 106


Input Format
The first argument of input contains a pointer to the head of the linked list. The second argument of input contains the integer B.


Output Format
Return the head of the linked list after deleting the B-th element from the end.


Example Input
Input 1:
A = 1->2->3->4->5
B = 2
Input 2:
A = 1
B = 1


Example Output
Output 1:
1->2->3->5
Output 2:
  


Example Explanation
Explanation 1:
In the first example, 4 is the second last element.
Explanation 2:
In the second example, 1 is the first and the last element.
 */
// class ListNode {
//      public int val;
//      public ListNode next;
//      ListNode(int x) { val = x; next = null; }
// }
public class removeNthNodefromEnd {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        // Create a newNode node that points to the head of the list
        ListNode newNode = new ListNode(0);
        newNode.next = A;
        ListNode fast = newNode;
        ListNode slow = newNode;
        for (int i = 0; i < B; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                // If B is greater than or equal to the length of the list, remove the first node
                return A.next;
            }
        }

        // Move both fast and slow pointers until fast reaches the end
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Skip the node to be deleted
        slow.next = slow.next.next;

        // Return the modified list
        return newNode.next;
    }
}
