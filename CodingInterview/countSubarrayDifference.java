package CodingInterview;
/*Infosys
 Problem Statement:
You are given an array A consisting of N integers.
Task: Find the maximum absolute difference between the sum of elements of any two non-empty subarrays 
of A.

Note:
A subarray is defined as a contiguous part of the array.

Input Format:
The first line contains an integer N, denoting the number of elements in A.
Each line i of the next N subsequent lines (where 0 ≤ i < N) contains an integer describing A[i].

Constraints:
1≤𝑁≤10^5
1≤N≤10^5

Input:
5 9 9 0 -2
Output: 25
Explanation: We can select two subarrays as [5, 9, 9] ans [-2].
the absolute difference between the sum of two elements is equal to 25.
 */

public class countSubarrayDifference {
        public static int findMaxAbsoluteDifference(int[] array) {
            int maxSubarraySum = kadane(array); // Find the maximum subarray sum
            int minSubarraySum = kadane(invertArray(array)); // Find the minimum subarray sum by inverting the array
            
            // The maximum absolute difference between the two sums
            return Math.max(maxSubarraySum - minSubarraySum, Math.abs(maxSubarraySum + minSubarraySum));
        }
    
        // Helper method to implement Kadane's algorithm to find the maximum subarray sum
        private static int kadane(int[] array) {
            int maxSoFar = array[0];
            int maxEndingHere = array[0];
            
            for (int i = 1; i < array.length; i++) {
                maxEndingHere = Math.max(array[i], maxEndingHere + array[i]);
                maxSoFar = Math.max(maxSoFar, maxEndingHere);
            }
            
            return maxSoFar;
        }
    
        // Helper method to invert the signs of the elements in the array
        private static int[] invertArray(int[] array) {
            int[] invertedArray = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                invertedArray[i] = -array[i];
            }
            return invertedArray;
        }
    
        public static void main(String[] args) {
            int[] array = {5,9,9,0,-2};
            System.out.println(findMaxAbsoluteDifference(array));  // Output the maximum absolute difference
        }    
}
