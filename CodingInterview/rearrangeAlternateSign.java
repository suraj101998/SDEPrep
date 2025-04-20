package CodingInterview;

import java.util.Arrays;

/*
 * Problem Statement Recap
You are given an even-length integer array nums.
You need to rearrange it so that:
It starts with a positive integer.
Every consecutive pair has opposite signs.
The relative order of positive and negative integers is preserved.

Approach:
Instead of using two separate lists and merging them, 
we directly place the values at appropriate even and odd indices in a new result array.
Positive numbers go at even indices (0, 2, 4,...)
Negative numbers go at odd indices (1, 3, 5,...)

This ensures:
Alternate signs
Starts with a positive
Relative order is preserved

Time & Space Complexity:
Time Complexity: O(N)
(Single pass to fill the result array)

Space Complexity: O(N)
(Result array of same size as input)

 */
public class rearrangeAlternateSign{
    public static void main(String[] args) {
        int[] nums = {3, 1, -2, -5, 2, -4};
        int[] result = rearrangeArray(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int posIndex = 0;
        int negIndex = 1;

        for (int num : nums) {
            if (num > 0) {
                result[posIndex] = num;
                posIndex += 2;
            } else {
                result[negIndex] = num;
                negIndex += 2;
            }
        }

        return result;
    }
}