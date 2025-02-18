package Math;

/*
 * Problem Description

Create a class Math with following requirements
- A class level data member called PI set to 3.14.
- A class level public method called getCircleArea, which takes as input an integer parameter called radius. This function should return area of the circle as a double
 */
public class Math {
    public static final double PI = 3.14;
    public static double getCircleArea(int radius) {
        return PI * radius * radius;
    }
}
