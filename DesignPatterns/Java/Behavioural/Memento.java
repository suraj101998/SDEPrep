package DesignPatterns.Java.Behavioural;
/*
 * Memento Pattern
Definition: Captures and externalizes an object's internal state so that it can be restored later, 
without violating encapsulation. ​
Use Case: Useful in text editors for implementing undo functionality.
 */

 public class Memento {

    // Memento Class - Stores State
    static class MementoPattern {
        private String state;

        public MementoPattern(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    // Originator Class - Creates & Restores Memento
    static class Originator {
        private String state;

        public void setState(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }

        public MementoPattern saveState() {
            return new MementoPattern(state);
        }

        public void restoreState(MementoPattern memento) {
            this.state = memento.getState();
        }
    }

    // Caretaker Class - Stores Memento
    static class Caretaker {
        private MementoPattern memento;

        public void save(MementoPattern memento) {
            this.memento = memento;
        }

        public MementoPattern retrieve() {
            return memento;
        }
    }

    // Main Method to Test
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("Draft");
        System.out.println("Current State: " + originator.getState());

        caretaker.save(originator.saveState());  // Save state

        originator.setState("Final Version");
        System.out.println("Changed State: " + originator.getState());

        originator.restoreState(caretaker.retrieve());  // Restore state
        System.out.println("Restored State: " + originator.getState());
    }
}

 

