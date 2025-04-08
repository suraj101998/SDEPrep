package DesignPatterns.Java.Behavioural;
/*
 * Template Method Pattern
Definition: Defines the skeleton of an algorithm in the superclass but lets subclasses override specific 
steps of the algorithm without changing its structure.​

Use Case: Useful when multiple classes share the same general workflow but implement specific steps 
differently, such as parsing different file formats.
 */
// Abstract Class
abstract class DataParser {
    // Template method
    public void parseData() {
        readData();
        processData();
        writeData();
    }

    abstract void readData();
    abstract void processData();

    void writeData() {
        System.out.println("Writing data to output.");
    }
}

// Concrete Class
class CSVDataParser extends DataParser {
    void readData() {
        System.out.println("Reading data from CSV file.");
    }

    void processData() {
        System.out.println("Processing data from CSV file.");
    }
}

// Client
public class TemplateMethod {
    public static void main(String[] args) {
        DataParser parser = new CSVDataParser();
        parser.parseData();
        // Output:
        // Reading data from CSV file.
        // Processing data from CSV file.
        // Writing data to output.
    }
}

