package DesignPatterns.Java.Behavioural;
/*
 * Iterator Pattern
Definition: Provides a way to access the elements of a collection sequentially 
without exposing its underlying representation. ​
Use Case: Useful when you need to traverse a collection without revealing its internal structure.
 */
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

// Aggregate interface
interface Aggregate {
    Iterator<String> createIterator();
}

// Concrete Aggregate
class ConcreteAggregate implements Aggregate {
    private List<String> items = new ArrayList<>();
    public void addItem(String item) { items.add(item); }
    public Iterator<String> createIterator() { return items.iterator(); }
}

// Client
public class IteratorPattern {
    public static void main(String[] args) {
        ConcreteAggregate aggregate = new ConcreteAggregate();
        aggregate.addItem("Item 1");
        aggregate.addItem("Item 2");

        Iterator<String> iterator = aggregate.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

