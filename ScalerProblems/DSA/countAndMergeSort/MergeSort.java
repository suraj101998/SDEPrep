package ScalerProblems.DSA.countAndMergeSort;
// Problem Description
// Given an integer array A, sort the array using Merge Sort.


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


public class MergeSort {
    public int[] solve(int[] A) {
        mergeSort(A, 0, A.length - 1);
        return A;
    }

    private void mergeSort(int[] A, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            mergeSort(A, lo, mid);
            mergeSort(A, mid + 1, hi);
            merge2SortedSubArrays(A, lo, mid, hi);
        }
    }

    private void merge2SortedSubArrays(int[] A, int lo, int mid, int hi) {
        int[] temp = new int[hi - lo + 1];
        int i = lo, j = mid + 1, k = 0;

        while (i <= mid && j <= hi) {
            if (A[i] <= A[j]) {
                temp[k++] = A[i++];
            } else {
                temp[k++] = A[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = A[i++];
        }

        while (j <= hi) {
            temp[k++] = A[j++];
        }

        // Copy sorted elements back into original array
        for (int x = 0; x < temp.length; x++) {
            A[lo + x] = temp[x];
        }
    }
}
