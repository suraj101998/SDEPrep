package PracticeProblems.DSA.countAndMergeSort;
// Problem Description
// Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.


// Problem Constraints
// 1 <= |A| <= 105
// 1 <= A[i] <= 105


// Input Format
// The first argument is an integer array A.


// Output Format
// Return an integer array that is the sorted array A.


// Example Input
// Input 1:
// A = [1, 3, 1]
// Input 2:
// A = [4, 2, 1, 3]


// Example Output
// Output 1:
// [1, 1, 3]
// Output 2:
// [1, 2, 3, 4]


// Example Explanation
// For Input 1:
// The array in sorted order is [1, 1, 3].
// For Input 2:
// The array in sorted order is [1, 2, 3, 4].

public class countSort {
    public int[] solve(int[] A) {
        int n = A.length;
        int maxElement = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] > maxElement) {
                maxElement = A[i];
            }
        }
        int[] countArray = new int[maxElement + 1];
        for (int i = 0; i < n; i++) {
            countArray[A[i]]++;
        }
        for (int i = 1; i <= maxElement; i++) {
            countArray[i] += countArray[i - 1];
        }
        int[] sortedArray = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            sortedArray[countArray[A[i]] - 1] = A[i];
            countArray[A[i]]--;
        }
        return sortedArray;
    }
}
