package ScalerProblems.ProblemSolving.SlidingWindow;
// Problem Description

import java.util.ArrayList;

// Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.

// Note: It is possible to swap any two elements, not necessarily consecutive.



// Problem Constraints

// 1 <= length of the array <= 100000
// -109 <= A[i], B <= 109



// Input Format

// The first argument given is the integer array A.
// The second argument given is the integer B.



// Output Format

// Return the minimum number of swaps.



// Example Input

// Input 1:

//  A = [1, 12, 10, 3, 14, 10, 5]
//  B = 8
// Input 2:

//  A = [5, 17, 100, 11]
//  B = 20


// Example Output

// Output 1:

//  2
// Output 2:

//  1


// Example Explanation

// Explanation 1:

//  A = [1, 12, 10, 3, 14, 10, 5]
//  After swapping  12 and 3, A => [1, 3, 10, 12, 14, 10, 5].
//  After swapping  the first occurence of 10 and 5, A => [1, 3, 5, 12, 14, 10, 10].
//  Now, all elements less than or equal to 8 are together.
// Explanation 2:

//  A = [5, 17, 100, 11]
//  After swapping 100 and 11, A => [5, 17, 11, 100].
//  Now, all elements less than or equal to 20 are together.
public class minimumSwaps {
        public int solve(ArrayList<Integer> A, int B) {
        int n=A.size();
        int count =0;
        // Count the number of elements <= B
        for (int lessNum : A) {
            if (lessNum <= B) {
                count++;
            }
        }
        // Initialize the number of elements > B in the first window
        int greaterNum = 0;
        for (int i = 0; i < count; i++) {
            if (A.get(i) > B) {
                greaterNum++;
            }
        }
        // Using sliding window to find the minimum swaps
        int minSwaps = greaterNum;
        for (int i = 0, j = count; j < n; i++, j++) {
            if (A.get(i) > B) {
                greaterNum--;
            }
            if (A.get(j) > B) {
                greaterNum++;
            }
            minSwaps = Math.min(minSwaps, greaterNum);
        }

        return minSwaps;
    }
}
