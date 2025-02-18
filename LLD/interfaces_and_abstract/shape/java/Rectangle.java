package LLD.interfaces_and_abstract.shape.java;

public class Rectangle extends Shape {
    private double width;
    private double height;

    // Constructor
    public Rectangle(int positionX, int positionY, String fillColor, String borderColor, double width, double height) {
        super(positionX, positionY, fillColor, borderColor);
        this.width = width;
        this.height = height;
    }

    // Getter methods
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    // Implementing abstract methods
    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
}