package DSA.Advanced.InterviewProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Problem Description
Given a list containing head pointers of N sorted linked lists.
Merge these given sorted linked lists and return them as one sorted list.

Problem Constraints
1 <= total number of elements in given linked lists <= 100000

Input Format
The first and only argument is a list containing N head pointers.

Output Format
Return a pointer to the head of the sorted linked list after merging all the given linked lists.

Example Input
Input 1:
 1 -> 10 -> 20
 4 -> 11 -> 13
 3 -> 8 -> 9

Input 2:
 10 -> 12
 13
 5 -> 6

Example Output
Output 1:
 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20

Output 2:
 5 -> 6 -> 10 -> 12 ->13

Example Explanation
Explanation 1:
 The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.

Explanation 2:
 The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.
 */

public class mergeKsortedLists {
    public static ListNode mergeKLists(ArrayList<ListNode> a) {
        if (a == null || a.isEmpty()) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);
        for (ListNode node : a) {
            if (node != null) {
                minHeap.add(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (!minHeap.isEmpty()) {
            ListNode smallestNode = minHeap.poll();
            current.next = smallestNode;
            current = current.next;
            if (smallestNode.next != null) {
                minHeap.add(smallestNode.next);
            }
        }
        return dummy.next;
    }
    public static ListNode createLinkedList(ArrayList<Integer> arr) {
        if (arr.isEmpty()) return null;
        ListNode head = new ListNode(arr.get(0));
        ListNode current = head;
        
        for (int i = 1; i < arr.size(); i++) {
            current.next = new ListNode(arr.get(i));
            current = current.next;
        }
        
        return head;
    }
    
    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>(Arrays.asList(1, 10, 20)));
        lists.add(new ArrayList<>(Arrays.asList(4, 11, 13)));
        lists.add(new ArrayList<>(Arrays.asList(3, 8, 9)));

        // Convert ArrayLists into linked lists
        ArrayList<ListNode> linkedLists = new ArrayList<>();
        for (ArrayList<Integer> list : lists) {
            linkedLists.add(createLinkedList(list));
        }

        // Merge k sorted lists
        ListNode mergedHead = mergeKLists(linkedLists);
        
        // Print the merged linked list
        printLinkedList(mergedHead);
    }    
}
