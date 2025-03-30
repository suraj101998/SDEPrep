package CodingInterview;
/*
 * minimum start value such that the cumulative sum of an array never drops below 1. This is solved efficiently in O(n) time.
 * Given an integer List nums, find the minimum value that can be added as a starting value such that the running sum of the List is always at least 1.
 */
import java.util.List;

public class minStartValue {

    // Function to calculate the minimum start value
    public static int minStartVal(List<Integer> nums) {
        int minSum = 0;
        int currentSum = 0;

        // Calculate the cumulative sum and track the minimum sum encountered
        for (int num : nums) {
            currentSum += num;
            minSum = Math.min(minSum, currentSum);
        }

        // The minimum start value should ensure the running sum is at least 1
        return 1 - minSum;
    }

    // Main method to test the function
    public static void main(String[] args) {
        List<Integer> nums = List.of(-3, 2, -3, 4, 2);
        System.out.println("Minimum Start Value: " + minStartVal(nums));
    }
}

/*
Explanation:
Approach:
Iterate through the List and compute the cumulative sum.
Track the minimum cumulative sum encountered.
If the minimum cumulative sum is x, the minimum start value must be 1−x to ensure the running sum stays at least 1.

Input and Output:
Input: A List of integers.
Output: The minimum starting value to keep the cumulative sum ≥ 1.

Example:
Input: nums = List.of(-3, 2, -3, 4, 2)

Execution:
Start with currentSum = 0 and minSum = 0.

Iterate through the list:
Add -3: currentSum = -3, minSum = -3
Add 2: currentSum = -1, minSum = -3
Add -3: currentSum = -4, minSum = -4
Add 4: currentSum = 0, minSum = -4
Add 2: currentSum = 2, minSum = -4

The minimum cumulative sum is -4, so the minimum start value is 1−(−4)=5.
Output: 5

Complexity Analysis:
Time Complexity: Iterating through the List: O(n)
Total: O(n)

Space Complexity:Only a few variables (currentSum and minSum) are used.
Total: O(1)
*/