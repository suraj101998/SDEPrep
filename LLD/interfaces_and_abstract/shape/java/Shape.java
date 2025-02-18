package LLD.interfaces_and_abstract.shape.java;

abstract class Shape {
    private int positionX;
    private int positionY;
    private String fillColor;
    private String borderColor;

    // Constructor
    public Shape(int positionX, int positionY, String fillColor, String borderColor) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    // Getter methods
    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    // Abstract methods for area and perimeter
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
}
