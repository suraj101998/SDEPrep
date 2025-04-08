package DesignPatterns.Java.Behavioural;
/*
 * Observer Pattern
Definition: A subject notifies multiple Observe when state changes.
Use Case: Event listeners, UI updates, stock price notifications.
 */
import java.util.ArrayList;
import java.util.List;

interface Observe {
    void update(String message);
}

class User implements Observe {
    private String name;

    public User(String name) { this.name = name; }

    public void update(String message) { System.out.println(name + " received: " + message); }
}

class Subject {
    private List<Observe> Observe = new ArrayList<>();

    public void addObserver(Observe observer) { Observe.add(observer); }
    
    public void notifyObserve(String message) {
        for (Observe observer : Observe) observer.update(message);
    }
}

public class Observer {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observe user1 = new User("Alice");
        Observe user2 = new User("Bob");

        subject.addObserver(user1);
        subject.addObserver(user2);
        subject.notifyObserve("New Video Uploaded!");
    }
}

