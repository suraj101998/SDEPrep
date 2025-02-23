package LLD.Collections;
/*
 * Find below the code of a class “Car”. We intend to use the objects of this class in a PriorityQueue.

public class Car {
    private int speed;
    private int power;
    public Car(int speed, int power){
        this.speed = speed;
        this.power = power;
    }

    @Override
    public String toString() {
        return "[S=" + this.speed + ", P=" + this.power + "]";
    }
}
Make the “Car” class implement Comparable interface appropriately, so that the Car with lower speed is considered smaller.
 */
public class Car implements Comparable<Car> {

    private int speed;
    private int power;

    public Car(int speed, int power){
        this.speed = speed;
        this.power = power;
    }

    @Override
    public int compareTo(Car other){
        return Integer.compare(this.speed, other.speed);
    }
    @Override
    public String toString() {
        return "[S=" + this.speed + ", P=" + this.power + "]";
    }

    
}
