package ScalerProblems.DSA.Hashing;
// Problem Description
// Given an array A of N integers.

import java.util.HashMap;

// Find the count of the subarrays in the array which sums to zero. Since the answer can be very large, return the remainder on dividing the result with 109+7


// Problem Constraints
// 1 <= N <= 105
// -109 <= A[i] <= 109


// Input Format
// Single argument which is an integer array A.


// Output Format
// Return an integer.


// Example Input
// Input 1:

//  A = [1, -1, -2, 2]
// Input 2:

//  A = [-1, 2, -1]


// Example Output
// Output 1:

// 3
// Output 2:

// 1


// Example Explanation
// Explanation 1:

//  The subarrays with zero sum are [1, -1], [-2, 2] and [1, -1, -2, 2].
// Explanation 2:

//  The subarray with zero sum is [-1, 2, -1].

public class countZeroSumSubarray {
    public int solve(int[] A) {
      long sum =0;
      int count =0;
      int N= A.length;
      int mod = 1000000007;
      HashMap<Long, Integer> map = new HashMap<>();
      map.put(0L,1);
      for(int i=0; i<N; i++){
          sum += A[i];
          if(!map.containsKey(sum)){
              map.put(sum,1);
          }
          else{
              count = (count + map.get(sum)) % mod;
              map.put(sum, map.get(sum) + 1);
          }
      }
      return count;
    }
}
