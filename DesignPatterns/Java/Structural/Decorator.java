package DesignPatterns.Java.Structural;
/*
 * Decorator Pattern
Definition: Dynamically adds responsibilities to an object without modifying its code.
Use Case: Extending functionality at runtime (e.g., adding sugar to coffee).
 */
interface Coffee {
    String getDescription();
    double cost();
}

class SimpleCoffee implements Coffee {
    public String getDescription() { return "Simple Coffee"; }
    public double cost() { return 5.0; }
}

class MilkDecorator implements Coffee {
    private Coffee coffee;

    public MilkDecorator(Coffee coffee) { this.coffee = coffee; }

    public String getDescription() { return coffee.getDescription() + ", Milk"; }
    public double cost() { return coffee.cost() + 2.0; }
}

public class Decorator {
    public static void main(String[] args) {
        Coffee coffee = new MilkDecorator(new SimpleCoffee());
        System.out.println(coffee.getDescription() + " $" + coffee.cost());
    }
}
