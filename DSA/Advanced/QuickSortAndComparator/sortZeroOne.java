package DSA.Advanced.QuickSortAndComparator;
// Problem Description
// Given an array A of 0s and 1s of length N. Sort this array.
// Note - Do not use any sorting algorithm or library's sort method.

// Problem Constraints
// 1 ≤ N ≤ 105
// 0 ≤ A[i] ≤ 1

// Input Format
// First argument A is an array of length N.

// Output Format
// Return the sorted array.

// Example Input
// Input 1:
// A = [0,0,1,0,1,1,0]
// Input 2:
// A = [1,0]


// Example Output
// Output 1:
// [0,0,0,0,1,1,1]
// Output 2:
// [0,1]
import java.util.ArrayList;
public class sortZeroOne {
    public ArrayList<Integer> sort01(ArrayList<Integer> A) {
        int left = 0;
        int right = 0;
        while (right < A.size()) {
            if (A.get(right) == 0) {
                int temp = A.get(left);
                A.set(left, A.get(right));
                A.set(right, temp);
                left++;
            }
            right++;
        }
        return A;
    }
}
