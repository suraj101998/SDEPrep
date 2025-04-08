package DesignPatterns.Java.Structural;
/*
 * Composite Pattern
Definition: Treats individual objects and compositions of objects uniformly in a tree structure.
Use Case: When dealing with hierarchical structures like file systems, menus, or UI components.
 */
import java.util.ArrayList;
import java.util.List;

interface Component {
    void showDetails();
}

class Leaf implements Component {
    private String name;

    public Leaf(String name) { this.name = name; }

    public void showDetails() { System.out.println(name); }
}

class Composites implements Component {
    private List<Component> children = new ArrayList<>();

    public void add(Component component) { children.add(component); }

    public void showDetails() {
        for (Component child : children) { child.showDetails(); }
    }
}

public class Composite {
    public static void main(String[] args) {
        Composites root = new Composites();
        root.add(new Leaf("File 1"));
        root.add(new Leaf("File 2"));

        Composites subDir = new Composites();
        subDir.add(new Leaf("File 3"));
        root.add(subDir);

        root.showDetails(); // Displays all files
    }
}

