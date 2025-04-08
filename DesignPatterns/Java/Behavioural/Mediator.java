package DesignPatterns.Java.Behavioural;
/*
 * Mediator Pattern
Definition: Defines an object that encapsulates how a set of objects interact, 
promoting loose coupling by preventing objects from referring to each other explicitly. ​
Use Case: Useful in chat applications where a mediator handles message distribution among users.
 */
import java.util.ArrayList;
import java.util.List;

// Mediator interface
interface MediatorPattern {
    void sendMessage(String message, Colleague colleague);
}

// Concrete Mediator
class ConcreteMediator implements MediatorPattern {
    private List<Colleague> colleagues = new ArrayList<>();
    public void addColleague(Colleague colleague) { colleagues.add(colleague); }
    public void sendMessage(String message, Colleague originator) {
        for (Colleague colleague : colleagues) {
            if (colleague != originator) {
                colleague.receive(message);
            }
        }
    }
}

// Colleague interface
abstract class Colleague {
    protected MediatorPattern mediator;
    public Colleague(MediatorPattern mediator) { this.mediator = mediator; }
    public abstract void receive(String message);
}

// Concrete Colleague
class ConcreteColleague extends Colleague {
    public ConcreteColleague(MediatorPattern mediator) { super(mediator); }
    public void send(String message) { mediator.sendMessage(message, this); }
    public void receive(String message) {
        System.out.println("Colleague received: " + message);
    }
}

// Client
public class Mediator {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleague colleague1 = new ConcreteColleague(mediator);
        ConcreteColleague colleague2 = new ConcreteColleague(mediator);

        mediator.addColleague(colleague1);
        mediator.addColleague(colleague2);

        colleague1.send("Hello");
        // Output:
        // Colleague received: Hello
    }
}

