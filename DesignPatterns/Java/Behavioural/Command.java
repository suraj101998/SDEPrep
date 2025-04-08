package DesignPatterns.Java.Behavioural;
/*
 * Command Pattern
Definition: Encapsulates a request as an object, thereby allowing for parameterization of clients with 
queues, requests, and operations. ​
Use Case: Useful for implementing undo/redo operations in applications.
 */
// Command interface
interface CommandPattern {
    void execute();
}

// Receiver
class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }
    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

// Concrete Command
class TurnOnCommand implements CommandPattern {
    private Light light;
    public TurnOnCommand(Light light) { this.light = light; }
    public void execute() { light.turnOn(); }
}

// Invoker
class RemoteControl {
    private CommandPattern command;
    public void setCommand(CommandPattern command) { this.command = command; }
    public void pressButton() { command.execute(); }
}

// Client
public class Command {
    public static void main(String[] args) {
        Light light = new Light();
        CommandPattern turnOn = new TurnOnCommand(light);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(turnOn);
        remote.pressButton(); // Output: Light is ON
    }
}

