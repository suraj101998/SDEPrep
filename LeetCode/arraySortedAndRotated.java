package LeetCode;
/*
Problem No- 1752
Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.
There may be duplicates in the original array.
Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.

Example 1:
Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].

Example 2:
Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.

Example 3:
Input: nums = [1,2,3]
Output: true
Explanation: [1,2,3] is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.

Constraints:
1 <= nums.length <= 100
1 <= nums[i] <= 100
 */


public class arraySortedAndRotated {
    public boolean check(int[] nums) {
        // Variable to keep track of the number of times a pair is out of order.
        int countOutOfOrder = 0;
      
        // 'n' is the length of the array.
        int n = nums.length;
        // Iterate over the elements of the array.
        for (int i = 0; i < n; ++i) {
            // Check if the current element is greater than the next element 
            // The next element of the last item is the first item, hence the modulo operation.
            if (nums[i] > nums[(i + 1) % n]) {
                // Increment the out of order count.
                ++countOutOfOrder;
            }
        }
        // The array is non-decreasing if there is at most one out-of-order pair.
        return countOutOfOrder <= 1;
    }
}
