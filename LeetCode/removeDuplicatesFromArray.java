package LeetCode;
/*
Problem No - 26
 Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.

Custom Judge:
The judge will test your solution with the following code:
int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length
int k = removeDuplicates(nums); // Calls your implementation
assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

Example 1:
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

Example 2:
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 
Constraints:
1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
nums is sorted in non-decreasing order.



/*
Approach:

1. The main idea is to solve this problem is to consider all subarrays one by one having the same elements.
2. Keep an index k = 0, which states that the first k elements are already taken.
3. Consider a subarray [i,j-1] where all elements have same value(x). Substitute nums[k] = x, and increment the index k by 1 since we are done with the current unique element and had placed this at the correct position. Also, change index i to j.
4. Repeat step 2 until we’re done with all the unique elements.
5. Finally, return k which is our answer (number of unique elements). Also, note that all unique elements are placed at first k positions and their relative order remains the same.

*/

public class removeDuplicatesFromArray {
    public int removeDuplicates(int[] nums) {
        int n = nums.length, k=0;
        for (int i=0; i<n; i++){
            int j= i;
            while(j<n && nums[i]==nums[j]){
                j++;
            }
            nums[k++] = nums[i];
            i=j-1;
        }
        return k;
    }
}
