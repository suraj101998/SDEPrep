package Rectangle.Java;

public class Rectangle {
    Pointer topLeft;
    Pointer bottomRight;

    public Rectangle(int tlX, int tlY, int brX, int brY){
        this.topLeft = new Pointer(tlX, tlY);
        this.bottomRight = new Pointer(brX, brY);
    }

    public Rectangle(Pointer topLeft, Pointer bottomRight){
        this.topLeft = new Pointer(topLeft);
        this.bottomRight = new Pointer(bottomRight);
    }

    public Rectangle(Rectangle r){
        this.topLeft = new Pointer(r.topLeft);
        this.bottomRight = new Pointer(r.bottomRight);
    }
}
