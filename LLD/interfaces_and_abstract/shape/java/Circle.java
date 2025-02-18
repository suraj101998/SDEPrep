package LLD.interfaces_and_abstract.shape.java;

public class Circle extends Shape {
    private double radius;
    private static final double PI = Math.PI;

    // Constructor
    public Circle(int positionX, int positionY, String fillColor, String borderColor, double radius) {
        super(positionX, positionY, fillColor, borderColor);
        this.radius = radius;
    }

    // Getter method
    public double getRadius() {
        return radius;
    }

    // Implementing abstract methods
    @Override
    public double calculateArea() {
        return PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * PI * radius;
    }
}

