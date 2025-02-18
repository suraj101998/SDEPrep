/*
 * Create a Node class with following requirements

Two data members
i. data : int
ii. next : Node
A constructor which takes an integer parameter. This constructor should set data property and leave the next set to null.
A constructor which takes a Node parameter. This constructor should make a deep copy of the passed node.
 */

 public class Node {
    // write the code of node class here
    int data;
    Node next;

    // Constructor that takes an integer parameter
    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    // Constructor that takes a Node parameter (Deep Copy Constructor)
    public Node(Node node) {
        if (node != null) {
            this.data = node.data;
            this.next = (node.next != null) ? new Node(node.next) : null;
        }
    }
}
