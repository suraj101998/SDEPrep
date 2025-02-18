package LLD.Generics.Generic_LinkedList;
/*
 * Generic Singly Linked List Implementation
Problem Statement
Your task is to implement a generic singly linked list in Java, capable of storing data of any type. The class ListNode has been provided, which represents the nodes of the linked list. You are required to complete the implementation of the LinkedList class, which should include methods for adding elements to the list, displaying the list contents, checking if the list is empty, and determining the size of the list.

Instructions
Inside the LinkedList class, initialize the head node to null in the constructor. The head node will be used to keep track of the start of the list.
Implement the add method to add a new node with the specified data at the end of the list. This method should take the data to be added as a parameter and does not return anything.
Implement the display method to print the data of each node in the list, separated by spaces. Ensure that no additional spaces or newline characters are printed at the end of the output.
Implement the isEmpty method to return true if the list is empty (i.e., the head is null), otherwise false. This method does not take any parameters and returns a boolean value.
Implement the size method to return the number of nodes currently in the list. This method does not take any parameters and returns an integer value representing the size of the list.
 */
class ListNode<T> {
    T data;
    ListNode<T> next;

    public ListNode(T data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList<T> {
    private ListNode<T> head;

    // Constructor to initialize head as null
    public LinkedList() {
        this.head = null;
    }

    // Method to add a new node at the end of the list
    public void add(T data) {
        ListNode<T> newNode = new ListNode<>(data);
        if (head == null) {
            head = newNode;
        } else {
            ListNode<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to display the elements of the linked list
    public void display() {
        if (head == null) {
            System.out.print(""); // Ensure empty output for an empty list
            return;
        }

        StringBuilder result = new StringBuilder();
        ListNode<T> temp = head;

        while (temp != null) {
            result.append(temp.data).append(" "); // Append each element with a trailing space
            temp = temp.next;
        }

        System.out.print(result.toString()); // Output without an extra newline
    }

    // Method to check if the linked list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Method to return the number of nodes in the linked list
    public int size() {
        int count = 0;
        ListNode<T> temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
