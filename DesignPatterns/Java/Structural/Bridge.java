package DesignPatterns.Java.Structural;
/*
 * Bridge Pattern
Definition: Decouples abstraction from implementation, allowing them to evolve independently.
Use Case: Managing different drawing APIs (e.g., Windows and Linux).
 */
interface DrawAPI { void drawCircle(int radius); }
class RedCircle implements DrawAPI { public void drawCircle(int radius) { System.out.println("Red Circle with radius " + radius); } }
class GreenCircle implements DrawAPI { public void drawCircle(int radius) { System.out.println("Green Circle with radius " + radius); } }

abstract class Shape { protected DrawAPI drawAPI; Shape(DrawAPI drawAPI) { this.drawAPI = drawAPI; } abstract void draw(); }
class Circle extends Shape { int radius; Circle(int radius, DrawAPI drawAPI) { super(drawAPI); this.radius = radius; } void draw() { drawAPI.drawCircle(radius); } }

public class Bridge {
    public static void main(String[] args) {
        Shape redCircle = new Circle(10, new RedCircle());
        redCircle.draw();
    }
}

