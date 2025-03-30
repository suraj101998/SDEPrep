package CodingInterview;
/*
 * Longest Increasing Subsequence (LIS) using Dynamic Programming with Binary Search. This approach ensures a time complexity of O(nlogn).
 */
import java.util.*;

public class longestIncreasingSubsequence {

    // Function to find the length of the longest increasing subsequence
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // List to store the potential LIS
        ArrayList<Integer> lis = new ArrayList<>();
        
        for (int num : nums) {
            // Perform binary search to find the position to replace or insert the current number
            int pos = Collections.binarySearch(lis, num);
            
            // If num is not found, binarySearch returns -(insertion_point) - 1
            if (pos < 0) {
                pos = -(pos + 1);
            }
            
            // Replace the element at pos or extend the LIS
            if (pos < lis.size()) {
                lis.set(pos, num);
            } else {
                lis.add(num);
            }
        }
        
        // The size of the 'lis' list is the length of the LIS
        return lis.size();
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of Longest Increasing Subsequence: " + lengthOfLIS(nums));
    }
}

/* 
Explanation:
Approach:

The problem is solved using Dynamic Programming with Binary Search:
Use a list (lis) to maintain the potential LIS.
For every number in the input array:
Perform a binary search in lis to find its position (pos).
If the number is smaller than an element in lis, replace the element at pos.
If the number is greater than all elements in lis, append it.
The size of the list lis at the end gives the length of the LIS.

Key Insight:
We don’t store the actual subsequence; instead, we maintain a list where each element represents the smallest possible ending value of an increasing subsequence of a given length.
Input and Output:
Input: An integer array.
Output: The length of the longest increasing subsequence.

Example:
Input: {10, 9, 2, 5, 3, 7, 101, 18}

Execution:
Start with an empty list lis = [].
Iterate through the numbers:

10 → Append → lis = [10]
9 → Replace 10 → lis = [9]
2 → Replace 9 → lis = [2]
5 → Append → lis = [2, 5]
3 → Replace 5 → lis = [2, 3]
7 → Append → lis = [2, 3, 7]
101 → Append → lis = [2, 3, 7, 101]
18 → Replace 101 → lis = [2, 3, 7, 18]

Result: Length of lis = 4.

Complexity Analysis:
Time Complexity:
Iterating through the array: 
O(n)

Binary search for each element: 
O(logn)

Total: 
O(nlogn)

Space Complexity:
The lis list grows to at most 
O(n) in the worst case.

Total: 
O(n)
*/