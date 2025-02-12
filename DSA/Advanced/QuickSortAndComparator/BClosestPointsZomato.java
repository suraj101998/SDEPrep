package DSA.Advanced.QuickSortAndComparator;
import java.util.Arrays;
import java.util.Comparator;

/*
Problem Description
You are developing a feature for Zomato that helps users find the nearest restaurants to their current location. 
It uses GPS to determine the user's location and has access to a database of restaurants, each with its own set of coordinates in a two-dimensional space representing their geographical location on a map. The goal is to identify the "B" closest restaurants to the user, providing a quick and convenient way to choose where to eat.
Given a list of restaurant locations, denoted by A (each represented by its x and y coordinates on a map), and an integer B representing the number of closest restaurants to the user. The user's current location is assumed to be at the origin (0, 0).
Here, the distance between two points on a plane is the Euclidean distance.
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2).

Problem Constraints
1 <= B <= length of the list A <= 10^5
-10^5 <= A[i][0] <= 10^5
-10^5 <= A[i][1] <= 10^5

Input Format
The argument given is list A and an integer B.

Output Format
Return the B closest points to the origin (0, 0) in any order.

Example Input
Input 1:
 A = [ 
       [1, 3],
       [-2, 2] 
     ]
 B = 1

Input 2:
 A = [
       [1, -1],
       [2, -1]
     ] 
 B = 1

Example Output
Output 1:
 [ [-2, 2] ]

Output 2:
 [ [1, -1] ]

Example Explanation
Explanation 1:
 The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
 So one closest point will be [-2,2].

Explanation 2:
 The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
 So one closest point will be [1,-1].
 */

public class BClosestPointsZomato {
        public static int[][] solve(int[][] A, int B) {
        // Sort the restaurant locations based on the squared distance from the origin (0,0)
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // Calculate squared distance for both points a and b
                int distance1 = a[0] * a[0] + a[1] * a[1];
                int distance2 = b[0] * b[0] + b[1] * b[1];
                // Compare based on the squared distance
                return Integer.compare(distance1, distance2);
            }
        });
        
        int[][] ans = new int[B][2];
        // Copy the first B closest points from the sorted array
        for (int i = 0; i < B; i++) {
            ans[i][0] = A[i][0];
            ans[i][1] = A[i][1];
        }
        return ans;
    }
    public static void main(String[] args){
        int[][] A = {{1, 3},{-2, 2}};
        int B = 1;
        int[][] result = solve(A, B);
        System.out.println("ans: "+Arrays.deepToString(result));
    }
}
