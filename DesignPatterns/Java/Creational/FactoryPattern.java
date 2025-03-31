
/*
 * Factory Method Pattern
Definition: Defines an interface for creating an object but lets subclasses decide which class to instantiate.
Use Case: Hiding object creation logic, creating different object types at runtime.
 */
interface Animal {
    void speak();
}

class Dog implements Animal {
    public void speak() { System.out.println("Woof!"); }
}

class Cat implements Animal {
    public void speak() { System.out.println("Meow!"); }
}

class AnimalFactory {
    public static Animal getAnimal(String type) {
        if (type.equalsIgnoreCase("Dog")) return new Dog();
        else return new Cat();
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        Animal animal = AnimalFactory.getAnimal("Dog");
        animal.speak();
    }
}
// output: Woof!
