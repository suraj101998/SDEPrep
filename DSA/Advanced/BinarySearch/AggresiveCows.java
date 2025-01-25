package DSA.Advanced.BinarySearch;
import java.util.Arrays;
/*
 * Problem Description
Farmer John has built a new long barn with N stalls. Given an array of integers A of size N 
where each element of the array represents the location of the stall and 
an integer B which represents the number of cows.

His cows don't like this barn layout and become aggressive towards each other once put into a stall. 
To prevent the cows from hurting each other, John wants to assign the cows to the stalls, 
such that the minimum distance between any two of them is as large as possible. 
What is the largest minimum distance?

Problem Constraints
2 <= N <= 100000
0 <= A[i] <= 109
2 <= B <= N

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the largest minimum distance possible among the cows.

Example Input
Input 1:
A = [1, 2, 3, 4, 5]
B = 3

Input 2:
A = [1, 2]
B = 2

Example Output
Output 1:
 2

Output 2:
 1

Example Explanation
Explanation 1:
 John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively. So the minimum distance will be 2.

Explanation 2:
 The minimum distance will be 1.
 */

/*
Approach:
1. Sort the Stall Positions:
    Sort the array A to arrange stall positions in increasing order.

2. Binary Search for Maximum Minimum Distance:
    Initialize the search range as l = 1 (minimum possible distance) 
    and r = A[A.length - 1] - A[0] (maximum possible distance).
    For each midpoint mid in this range, check if it is feasible to place B cows 
    with at least mid distance between them using the canPlaceCows function.
    If feasible, update ans to mid and move the search range to larger distances (l = mid + 1). 
    Otherwise, reduce the search range (r = mid - 1).

3. Check Feasibility:
    In canPlaceCows, start placing cows at the first stall.
    For each subsequent stall, check if the distance from the last placed cow is at least mid. 
    If yes, place a cow.
    Return true if all B cows are placed; otherwise, return false.

TC = O(N log D)
Sorting the array takes O(N log N).
Binary search iterates over log(D) (where D is the distance range). 
For each midpoint, canPlaceCows checks feasibility in O(N).

SC = O(1)
 */ 
public class AggresiveCows {
    public static int solve(int[] A, int B) {
            Arrays.sort(A);
            int l= 1, r = A[A.length-1]-A[0], ans = 0;
            while(l<=r){
                int mid = l + (r-l)/2;
                if(canPlaceCows(A,B,mid)){
                                    ans = mid;
                                    l = mid+1;
                                }
                                else{
                                    r = mid-1;
                                }
                            }
                            return ans;
                        }
                    
    private static boolean canPlaceCows(int[] A, int B, int mid){
            int cows =1, position = A[0];
            for(int i=0; i<A.length; i++){
                if(A[i]-position >= mid){
                    cows++;
                    position = A[i];
                }
            }
            if(cows < B){
                return false;
            }
            else{
                return true;
            }
        }
    
    public static void main(String[] args){
            int[] A= {1, 2, 3, 4, 5};
            int B = 3;
            int result = solve(A,B);
            System.out.println("cows: "+result);
    }
}
