package LLD.executors_and_callables.Threads.callable2;

public class Node {
    public int data;
    public Node left, right; // Ensure fields are public

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}