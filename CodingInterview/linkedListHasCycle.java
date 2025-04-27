package CodingInterview;
/*
 * 1->2->4->5> null
 * 1->2->4->2->7->8->9->7
 */

class ListNode{
    int val;
    ListNode next;

    ListNode(int x){
        val = x;
    }
}
public class linkedListHasCycle {

    public boolean hasCycle(ListNode first){
        //empty cycle
        if(first==null || first.next == null){ return false;}
        ListNode slow= first;
        ListNode fast= first;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){ return true;}
        }
        return false;
    }

    public static void main(String[] args){
        linkedListHasCycle cycleDetection = new linkedListHasCycle();

        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(4);
        ListNode fourth = new ListNode(2);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        ListNode seventh = new ListNode(5);
 
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;

        boolean hasCycle = cycleDetection.hasCycle(first);
        System.out.println("ans: "+hasCycle);
    }
}