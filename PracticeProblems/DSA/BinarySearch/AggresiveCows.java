package PracticeProblems.DSA.BinarySearch;

import java.util.Arrays;
/*
Problem Description
Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.
His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?

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
public class AggresiveCows {
        public int solve(int[] A, int B) {
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

    private boolean canPlaceCows(int[] A, int B, int mid){
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
}
