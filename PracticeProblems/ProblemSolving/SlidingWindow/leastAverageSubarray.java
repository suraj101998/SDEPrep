package PracticeProblems.ProblemSolving.SlidingWindow;
// Problem Description
// Given an array A of size N, find the subarray of size B with the least average.

import java.util.ArrayList;

// Problem Constraints
// 1 <= B <= N <= 105
// -105 <= A[i] <= 105


// Input Format
// First argument contains an array A of integers of size N.
// Second argument contains integer B.


// Output Format
// Return the index of the first element of the subarray of size B that has least average.
// Array indexing starts from 0.


// Example Input
// Input 1:
// A = [3, 7, 90, 20, 10, 50, 40]
// B = 3
// Input 2:

// A = [3, 7, 5, 20, -10, 0, 12]
// B = 2


// Example Output
// Output 1:
// 3
// Output 2:

// 4


// Example Explanation
// Explanation 1:
// Subarray between indexes 3 and 5
// The subarray {20, 10, 50} has the least average 
// among all subarrays of size 3.
// Explanation 2:

//  Subarray between [4, 5] has minimum average
public class leastAverageSubarray {
        public int solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        int sum =0;
        // Calculate the sum of the first subarray of size B
        for(int i=0; i<B;i++){
            sum +=A.get(i);
        }
        // Initialize the minimum sum as the sum of the first subarray
        int minSum = sum;
        int minIndex = 0;
        // Use a sliding window to find the subarray with the least average
        for(int i=B; i<N; i++){
            sum += A.get(i)-A.get(i-B);
            if(sum<minSum){
                minSum=sum;
                minIndex= i-B+1;
            }
        }
        return minIndex;
    }
}
