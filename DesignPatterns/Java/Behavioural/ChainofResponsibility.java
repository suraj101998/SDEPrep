package DesignPatterns.Java.Behavioural;
/*
 * Chain of Responsibility Pattern
Definition: Passes requests along a chain of handlers until one handles it.
Use Case: Logging, authentication, event propagation.
 */
abstract class Handler {
    protected Handler next;

    public void setNext(Handler next) { this.next = next; }

    public abstract void handleRequest(int level);
}

class LowHandler extends Handler {
    public void handleRequest(int level) {
        if (level <= 10) System.out.println("Low Handler processed request.");
        else if (next != null) next.handleRequest(level);
    }
}

class HighHandler extends Handler {
    public void handleRequest(int level) {
        System.out.println("High Handler processed request.");
    }
}

public class ChainofResponsibility {
    public static void main(String[] args) {
        Handler low = new LowHandler();
        Handler high = new HighHandler();
        low.setNext(high);

        low.handleRequest(5);  // Processed by Low Handler
        low.handleRequest(15); // Processed by High Handler
    }
}
