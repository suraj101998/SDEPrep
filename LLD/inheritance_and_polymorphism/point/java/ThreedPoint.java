package LLD.inheritance_and_polymorphism.point.java;

public class ThreedPoint extends Point {
    private int z;
    @Override
    public void display(){
        System.out.println("[" + x + ", " + y + ", " + z + "]");
    }
}
