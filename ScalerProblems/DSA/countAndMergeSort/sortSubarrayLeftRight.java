package ScalerProblems.DSA.countAndMergeSort;
// Problem Description
// You are given an array A of integers of length N and two indices, B and C.

// Your task is to sort the subarray [B, C] within the given array. The rest of the array should remain unchanged.



// Problem Constraints
// 1 ≤ N ≤ 105

// 0 ≤ A[i] ≤ 109

// 0 ≤ B ≤ C ≤ N - 1



// Input Format
// First argument is the array A of length N. The next two arguments are the integers B and C.



// Output Format
// Return the array after sorting the [B, C] subarray.



// Example Input
// Input:

// A = [59, 11, 8, 91, 49, 44, 8]
// B = 4
// C = 6
// Input 2:

// A = [50, 40, 30, 20, 10]
// B = 0
// C = 3


// Example Output
// Output:

// [59, 11, 8, 91, 8, 44, 49]
// Output:

// [20, 30, 40, 50, 10]


// Example Explanation
// Explanation 1:

// Initially the subarray [B, C], i.e. A[4, 6] = [49, 44, 8].
// After sorting this becomes [8, 44, 49].
// It can be seen that this subarray gets sorted and rest of the array remains unchanged!
// Explanation 2:

// Initially the subarray [B, C], i.e. A[0, 3] = [50, 40, 30, 20].
// After sorting this becomes [20, 30, 40, 50].
// It can be seen that this subarray gets sorted and rest of the array remains unchanged!

public class sortSubarrayLeftRight {
    public int[] sortSubarray(int[] A, int B, int C) {
        // Step 1: Extract the subarray from B to C
        int[] subarray = new int[C - B + 1];
        for (int i = B; i <= C; i++) {
            subarray[i - B] = A[i];
        }
        // Step 2: Sort the extracted subarray
        for (int i = 0; i < subarray.length; i++) {
            for (int j = i + 1; j < subarray.length; j++) {
                if (subarray[i] > subarray[j]) {
                    // Swap subarray[i] and subarray[j]
                    int temp = subarray[i];
                    subarray[i] = subarray[j];
                    subarray[j] = temp;
                }
            }
        }
        // Step 3: Place the sorted subarray back into the original array A
        for (int i = B; i <= C; i++) {
            A[i] = subarray[i - B];
        }
        // Step 4: Return the modified array
        return A;
    }
}
