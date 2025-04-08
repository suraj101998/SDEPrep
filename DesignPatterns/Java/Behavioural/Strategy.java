package DesignPatterns.Java.Behavioural;
/*
 * Strategy Pattern
Definition: Encapsulates different algorithms and allows them to be swapped dynamically.
Use Case: Sorting algorithms, payment gateways.
 */
interface Strategies {
    void execute();
}

class ConcreteStrategyA implements Strategies {
    public void execute() { System.out.println("Executing Strategy A"); }
}

class ConcreteStrategyB implements Strategies {
    public void execute() { System.out.println("Executing Strategy B"); }
}

class Context {
    private Strategies strategy;
    public void setStrategy(Strategies strategy) { this.strategy = strategy; }
    public void executeStrategy() { strategy.execute(); }
}

public class Strategy {
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new ConcreteStrategyA());
        context.executeStrategy();
    }
}

