package DSA.Advanced.ArraysOneDimensional;
/*
Problem No- 217
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:s
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109
 */


import java.util.HashMap;

public class arrayContainsDuplicate {
        public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> myMap= new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            if (myMap.containsKey(nums[i])){
                return true;
            }
            myMap.put(nums[i],1);
        }
        return false;
    }
}
