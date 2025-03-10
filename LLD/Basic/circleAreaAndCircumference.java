
/*
 * create a circle with given radius calculate its area and circumferenece
 */
public class circleAreaAndCircumference {
    // Private fields for encapsulation
    private double radius;

    // Constructor to initialize the radius
    public circleAreaAndCircumference(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius; // πr²
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius; // 2πr
    }

    public static void main(String[] args) {
        circleAreaAndCircumference circle = new circleAreaAndCircumference(5); // Create a Circle object with radius 5
        System.out.println("Radius: " + circle.getRadius());
        System.out.println("Area: " + circle.calculateArea());
        System.out.println("Circumference: " + circle.calculateCircumference());
    }
}
