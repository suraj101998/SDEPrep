package DesignPatterns.Java.Behavioural;
/*
 * State Pattern
Definition: Allows an object to alter its behavior when its internal state changes. 
The object will appear to change its class.​
Use Case: Useful for implementing state machines, such as a TCP connection that can be in states 
like Established, Listening, or Closed.​
 */
// State interface
interface State {
    void handle();
}

// Concrete States
class ConcreteStateA implements State {
    public void handle() {
        System.out.println("Handling state A");
    }
}

class ConcreteStateB implements State {
    public void handle() {
        System.out.println("Handling state B");
    }
}

// Context
class Context {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.handle();
    }
}

// Client
public class StatePattern {
    public static void main(String[] args) {
        Context context = new Context();

        State stateA = new ConcreteStateA();
        context.setState(stateA);
        context.request(); // Output: Handling state A

        State stateB = new ConcreteStateB();
        context.setState(stateB);
        context.request(); // Output: Handling state B
    }
}

