package LLD.interfaces_and_abstract.shape.java;

public class Triangle extends Shape {
    private final int side1;
    private final int side2;
    private final int side3;

    public Triangle(int positionX, int positionY, String fillColor, String borderColor, int side1, int side2, int side3) {
        super(positionX, positionY, fillColor, borderColor);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public int getSide1() {
        return side1;
    }

    public int getSide2() {
        return side2;
    }

    public int getSide3() {
        return side3;
    }

    @Override
    public double calculateArea() {
        // Heron's formula for area of a triangle
        double s = (side1 + side2 + side3) / 2.0;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
}
