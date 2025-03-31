
/*
 * Prototype Pattern
Definition: Creates new objects by cloning an existing object.
Use Case: When object creation is costly, and duplication is preferred
 (e.g., Database connections, game characters).
 */
class Prototype implements Cloneable {
    String name;

    Prototype(String name) { this.name = name; }

    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }
}

public class PrototypeExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype obj1 = new Prototype("Original");
        Prototype obj2 = obj1.clone();
        System.out.println(obj2.name);
    }
}
// Output: Original