package ScalerProblems.DSA.QuickSortAndComparator;
// Problem Description
// Given an integer array A, sort the array using Quick Sort.


// Problem Constraints
// 1 <= |A| <= 105
// 1 <= A[i] <= 109


// Input Format
// First argument is an integer array A.


// Output Format
// Return the sorted array.


// Example Input
// Input 1:-
// A = [1, 4, 10, 2, 1, 5]
// Input 2:-
// A = [3, 7, 1]


// Example Output
// Output 1:-
// [1, 1, 2, 4, 5, 10]
// Output 2:-
// [1, 3, 7]


// Example Explanation
// Explanation 1 and 2:
// Return the sorted array.

public class quickSort {
    public int[] solve(int[] A) {
        quickSorts(A, 0, A.length - 1);
        return A;
    }
    private void quickSorts(int[] A, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(A, low, high);
            quickSorts(A, low, pivotIndex - 1);
            quickSorts(A, pivotIndex + 1, high);
        }
    }
    private int partition(int[] A, int low, int high) {
        int pivot = A[high]; // Pivot element is chosen as the last element
        int i = low - 1; // Index of the smaller element
        for (int j = low; j < high; j++) {
            if (A[j] < pivot) {
                i++;
                // Swap A[i] and A[j]
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        // Swap the pivot element with the element at index i+1
        int temp = A[i + 1];
        A[i + 1] = A[high];
        A[high] = temp;
        return i + 1;
    }
}
