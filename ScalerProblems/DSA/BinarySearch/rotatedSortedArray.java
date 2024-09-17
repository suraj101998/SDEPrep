package ScalerProblems.DSA.BinarySearch;

// For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].

// Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.

// You can assume that no duplicates exist in the array.

// NOTE: You are expected to solve this problem with a time complexity of O(log(N)).


// Problem Constraints
// 1 <= N <= 1000000
// 1 <= A[i] <= 109
// All elements in A are Distinct.


// Input Format
// The First argument given is the integer array A.
// The Second argument given is the integer B.


// Output Format
// Return index of B in array A, otherwise return -1


// Example Input
// Input 1:

// A = [4, 5, 6, 7, 0, 1, 2, 3]
// B = 4 
// Input 2:

// A : [ 9, 10, 3, 5, 6, 8 ]
// B : 5


// Example Output
// Output 1:

//  0 
// Output 2:

//  3


// Example Explanation
// Explanation 1:

// Target 4 is found at index 0 in A. 
// Explanation 2:

// Target 5 is found at index 3 in A.

public class rotatedSortedArray {
    public int search(final int[] A, int B) {
        int start = 0, end = A.length - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            // If the target is found at mid
            if (A[mid] == B) {
                return mid;
            }
            
            // Determine which side is sorted
            if (A[start] <= A[mid]) { // Left half is sorted
                if (B >= A[start] && B < A[mid]) {
                    end = mid - 1;  // Target is in the left half
                } else {
                    start = mid + 1;  // Target is in the right half
                }
            } else { // Right half is sorted
                if (B > A[mid] && B <= A[end]) {
                    start = mid + 1;  // Target is in the right half
                } else {
                    end = mid - 1;  // Target is in the left half
                }
            }
        }
        
        return -1;  // Target is not found
    }
}
