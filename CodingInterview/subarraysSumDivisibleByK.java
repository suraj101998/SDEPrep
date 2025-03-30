package CodingInterview;

import java.util.HashMap;
/*
 * number of subarrays whose sum is divisible by k, we can take advantage of prefix sums and modular arithmetic.
 */
public class subarraysSumDivisibleByK {

    // Function to calculate the number of subarrays whose sum is divisible by k
    public static long subarraysDivByK(int[] nums, int k) {
        // Map to store frequency of prefix sum modulo k
        HashMap<Integer, Integer> map = new HashMap<>();
        // Initialize the map with 0 modulo count as 1, because sum 0 is divisible by k
        map.put(0, 1);
        
        long prefixSum = 0;
        long result = 0;
        
        // Iterate through the array
        for (int num : nums) {
            // Update the prefix sum
            prefixSum += num;
            
            // Find modulo of the current prefix sum with k
            int mod = (int) (prefixSum % k);
            
            // To handle negative mod, make sure mod is always non-negative
            if (mod < 0) {
                mod += k;
            }
            
            // If this mod has appeared before, it means there are subarrays
            // whose sum is divisible by k
            result += map.getOrDefault(mod, 0);
            
            // Update the frequency of the current mod in the map
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        
        return result;
    }

    // Main method to test the function with values provided directly
    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 7}; // Test array
        int k = 6; // Divisor
        
        // Call the method with test values
        long result = subarraysDivByK(nums, k);
        
        // Output the result
        System.out.println("Number of subarrays divisible by " + k + ": " + result);
    }
}

/*
 * Approach:
Prefix Sum: First, calculate the cumulative sum of the array as you iterate through it.
Modulo Operation: For each prefix sum, calculate its remainder when divided by k. 
If two prefix sums have the same remainder, then the sum of the subarray between those two indices is divisible by k.
HashMap: Use a HashMap (or a frequency array) to keep track of the frequency of each modulo result.

Explanation:
Input Values:
The nums[] array is provided with values {23, 2, 4, 6, 7} and the divisor k = 6.

Execution:
The method subarraysDivByK calculates the number of subarrays whose sum is divisible by k by iterating through the array and updating the prefix sum at each index.
It uses a HashMap to track the frequency of the mod value and accumulates the result whenever it finds a valid subarray.

Output:
The method returns the number of subarrays whose sum is divisible by k.

Result:
The result is printed in the main method: "Number of subarrays divisible by 6: 7"

Example Walkthrough:
Input: nums = {23, 2, 4, 6, 7}, k = 6

Prefix Sum and Modulo Operations:
At index 0: prefixSum = 23, prefixSum % 6 = 5
At index 1: prefixSum = 25, prefixSum % 6 = 1
At index 2: prefixSum = 29, prefixSum % 6 = 5
At index 3: prefixSum = 35, prefixSum % 6 = 5
At index 4: prefixSum = 42, prefixSum % 6 = 0
The total count of subarrays whose sum is divisible by 6 is 7.

Time and Space Complexity:
Time Complexity:
We iterate over the array once, performing constant-time operations (lookup and insert into the HashMap) for each element.
Thus, the time complexity is O(n), where n is the length of the array.

Space Complexity:
We store at most k distinct mod values in the HashMap.
The space complexity is O(k), where k is the modulus value.
 */
