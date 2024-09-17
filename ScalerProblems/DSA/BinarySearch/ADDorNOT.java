package ScalerProblems.DSA.BinarySearch;

// In a single operation, any one element of the array can be increased by 1. You are allowed to do at most B such operations.

// Find the number with the maximum number of occurrences and return an array C of size 2, where C[0] is the number of occurrences, and C[1] is the number with maximum occurrence.
// If there are several such numbers, your task is to find the minimum one.



// Problem Constraints
// 1 <= N <= 105

// -109 <= A[i] <= 109

// 0 <= B <= 109



// Input Format
// The first argument given is the integer array A.
// The second argument given is the integer B.



// Output Format
// Return an array C of size 2, where C[0] is number of occurence and C[1] is the number with maximum occurence.



// Example Input
// Input 1:

//  A = [3, 1, 2, 2, 1]
//  B = 3
// Input 2:

//  A = [5, 5, 5]
//  B = 3


// Example Output
// Output 1:

//  [4, 2]
// Output 2:

//  [3, 5]


// Example Explanation
// Explanation 1:

//  Apply operations on A[2] and A[4]
//  A = [3, 2, 2, 2, 2]
//  Maximum occurence =  4
//  Minimum value of element with maximum occurence = 2
// Explanation 2:

//  A = [5, 5, 5]
//  Maximum occurence =  3
//  Minimum value of element with maximum occurence = 5
import java.util.Arrays;
public class ADDorNOT {
    public int[] solve(int[] A, int B) {
        // Step 1: Sort the array
        Arrays.sort(A);
        
        int n = A.length;
        int maxOccurrences = 1;  // At least one occurrence of each element
        int element = A[0];  // Initialize with the smallest element
        
        // Step 2: Sliding window to find the number with the max occurrences
        int start = 0;
        long sum = 0;  // Using long to avoid overflow

        for (int end = 0; end < n; end++) {
            // Calculate total operations required to make all elements from start to end equal to A[end]
            if (end > 0) {
                sum += (long)(A[end] - A[end - 1]) * (end - start);
            }
            
            // If the sum exceeds the allowed operations B, move the start
            while (sum > B) {
                sum -= (A[end] - A[start]);
                start++;
            }
            
            // Step 3: If the current window gives a better result, update
            int currentOccurrences = end - start + 1;
            if (currentOccurrences > maxOccurrences) {
                maxOccurrences = currentOccurrences;
                element = A[end];
            } else if (currentOccurrences == maxOccurrences) {
                element = Math.min(element, A[end]);
            }
        }
        
        return new int[]{maxOccurrences, element};
    }
}
