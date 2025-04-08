package DesignPatterns.Java.Structural;
/*
 * Facade Pattern
Definition: Provides a simplified interface to a complex system.
Use Case: Hiding system complexity from clients (e.g., database connection).
 */
class CPU {
    void start() { System.out.println("CPU started"); }
}

class Memory {
    void load() { System.out.println("Memory loaded"); }
}

class Computer {
    private CPU cpu = new CPU();
    private Memory memory = new Memory();

    void start() {
        cpu.start();
        memory.load();
        System.out.println("Computer started");
    }
}

public class Facade {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.start();
    }
}

