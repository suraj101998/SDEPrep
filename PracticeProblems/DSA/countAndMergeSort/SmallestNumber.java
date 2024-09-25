package PracticeProblems.DSA.countAndMergeSort;
// Problem Description
// An integer is given to you in the form of an array, with each element being a separate digit.

// Find the smallest number (leading zeroes are allowed) that can be formed by rearranging the digits of the given number in an array. Return the smallest number in the form an array.

// Note - Do not use any sorting algorithm or library's sort method.



// Problem Constraints
// 1 ≤ N ≤ 105

// 0 ≤ A[i] ≤ 9



// Input Format
// First argument A is an array of length N, representing digits of the number.



// Output Format
// Return the array representing the smallest possible number in form of an array.



// Example Input
// Input 1:

// A = [6, 3, 4, 2, 7, 2, 1]
// Input 2:

// A = [4, 2, 7, 3, 9, 0]


// Example Output
// Output 1:

// [1, 2, 2, 3, 4, 6, 7]
// Output 2:

// [0, 2, 3, 4, 7, 9]


// Example Explanation
// Explanation 1:

// It can be proved that a rearrangement for 6342721 cannot be smaller than 1223467.
// Explanation 2:

// Similarly, a rearrangement for 427390 cannot be smaller than 023479, i.e. 23479.

public class SmallestNumber {
    public int[] smallestNumber(int[] A) {
        int[] count = new int[10]; // Array to store count of each digit (0-9)
        int N = A.length;
        // Step 1: Count occurrences of each digit
        for (int i = 0; i < N; i++) {
            count[A[i]]++;
        }
        // Step 2: Rebuild the array in ascending order based on counts
        int[] result = new int[N];
        int index = 0;
        for (int digit = 0; digit <= 9; digit++) {
            while (count[digit] > 0) {
                result[index++] = digit;
                count[digit]--;
            }
        }
        return result;
    }
}
