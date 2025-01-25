package DSA.Advanced.LinkedList;
/*
 * Problem Description
Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.

Problem Constraints
1 <= |A| <= 105

Input Format
The first and the only argument of input contains a pointer to the head of the given linked list.

Output Format
Return 0, if the linked list is not a palindrome.
Return 1, if the linked list is a palindrome.

Example Input
Input 1:
A = [1, 2, 2, 1]
Input 2:
A = [1, 3, 2]

Example Output
Output 1:
 1 
Output 2:
 0 

Example Explanation
Explanation 1:
 The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.
Explanation 2:
 The second linked list is not a palindrom as [1, 3, 2] is not equal to [2, 3, 1].
 */
public class palindromeList {
    public int lPalin(ListNode A) {
        if (A == null || A.next == null) return 1;
        ListNode slow = A, fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = A;
        ListNode temp = secondHalf;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                reverseList(temp);
                return 0;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        reverseList(temp);
        return 1;
    }
    private ListNode reverseList(ListNode head) {
        ListNode prev = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
