package ScalerProblems.DSA.QuickSortAndComparator;
// Problem Description

// Given an integer array A of length N, considering the last element as pivot p, rearrange the elements such that for all i:

// if A[i] < p then it should be present on left side of the partition
// if A[i] > p then it should be present on right side of the partition
// Rearrange the given array as well as return the partition index.

// Note: All elements are distinct

// Problem Constraints
// 1 ≤ N ≤ 105
// 1 ≤ A[i] ≤ 109

// Input Format
// The only input argument is the given vector A.

// Output Format
// Return the partition index as well as rearrange the input array to satisfy the given conditions.

// Example Input
// Input:
// A = [6, 2, 0, 4, 5]

// Example Output
// Output:
//  Valid
// A possible solution can be:
// A = [2, 0, 4, 5, 6] and partitionIndex = 3

// Example Explanation
// Explanation:

// The rearrangement is valid because every element in [0, 2] index range is less than the pivot element, and every element in [3, 4] index range is greater than the pivot element.

public class partitionIndex {
    public int partition(int[] arr) {
        int n = arr.length;
        int pivotVal = arr[n - 1];
        int i = 0;
        for (int j = 0; j < n; ++j) {
            if (arr[j] < pivotVal) {
                // move smaller values to the left end
                // expand region 1
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                ++i;
            }
        }
        // moving pivot to the partition index
        int temp = arr[i];
        arr[i] = arr[n - 1];
        arr[n - 1] = temp;
        return i;
    }
}
