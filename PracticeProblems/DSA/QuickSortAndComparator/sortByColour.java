package PracticeProblems.DSA.QuickSortAndComparator;
// Problem Description
// Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
// We will represent the colors as,

// red -> 0
// white -> 1
// blue -> 2
// Note: Using the library sort function is not allowed.


// Problem Constraints
// 1 <= N <= 1000000
// 0 <= A[i] <= 2

// Input Format
// First and only argument of input contains an integer array A.

// Output Format
// Return an integer array in asked order

// Example Input
// Input 1 :
// A = [0, 1, 2, 0, 1, 2]
// Input 2:
// A = [0]

// Example Output
// Output 1: [0, 0, 1, 1, 2, 2]
// Output 2: [0]

// Example Explanation
// Explanation 1: [0, 0, 1, 1, 2, 2] is the required order.
// Explanation 2: [0] is the required order

import java.util.ArrayList;
public class sortByColour {
    public ArrayList<Integer> sortColors(ArrayList<Integer> A) {
        int low = 0;
        int mid = 0;
        int high = A.size() - 1;
        while (mid <= high) {
            if (A.get(mid) == 0) {
                swap(A, low, mid);
                low++;
                mid++;
            } else if (A.get(mid) == 1) {
                mid++;
            } else {
                swap(A, mid, high);
                high--;
            }
        }
        return A;
    }
    private void swap(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
}
