package Rectangle.Java;

public class Pointer {
    int x;
    int y;

    public Pointer(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Pointer(Pointer bottomRight){
        this.x = bottomRight.x;
        this.y = bottomRight.y;
    }
}

