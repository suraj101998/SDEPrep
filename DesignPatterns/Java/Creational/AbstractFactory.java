
/*
 * Abstract Factory Pattern
Definition: Provides an interface for creating families of related objects without specifying their concrete classes.
Use Case: UI components that vary based on operating system (Windows/Mac).
 */
interface Button { void paint(); }
class WindowsButton implements Button { public void paint() { System.out.println("Windows Button"); } }
class MacButton implements Button { public void paint() { System.out.println("Mac Button"); } }

interface GUIFactory { Button createButton(); }
class WindowsFactory implements GUIFactory { public Button createButton() { return new WindowsButton(); } }
class MacFactory implements GUIFactory { public Button createButton() { return new MacButton(); } }

public class AbstractFactory {
    public static void main(String[] args) {
        GUIFactory factory = new WindowsFactory(); 
        Button button = factory.createButton();
        button.paint();
    }
}
// Output: Windows Button