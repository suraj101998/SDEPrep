package PracticeProblems.DSA.Hashing;
// Problem Description
// Given an array of integers A and an integer B.
// Find the total number of subarrays having sum equals to B.

import java.util.HashMap;

// Problem Constraints
//  1 <= length of the array <= 50000
// -1000 <= A[i] <= 1000


// Input Format
// The first argument given is the integer array A.
// The second argument given is integer B.


// Output Format
// Return the total number of subarrays having sum equals to B.


// Example Input
// Input 1:
// A = [1, 0, 1]
// B = 1
// Input 2:
// A = [0, 0, 0]
// B = 0


// Example Output
// Output 1:
// 4
// Output 2:
// 6


// Example Explanation
// Explanation 1:
// [1], [1, 0], [0, 1] and [1] are four subarrays having sum 1.
// Explanation 1:
// All the possible subarrays having sum 0.

public class subarraySumEqualsK {
    public int solve(int[] A, int B) {
        int N=A.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int currentSum = 0;
        for(int i=0; i<N; i++){
            currentSum += A[i];
            if (currentSum == B) {
                ans++;
            }
            if (map.containsKey(currentSum - B)) {
                ans += map.get(currentSum - B);
            }
            if (!map.containsKey(currentSum)) {
                map.put(currentSum, 1);
            } else {
                int ov = map.get(currentSum);
                map.put(currentSum, ov + 1);
            }
        }
        return ans;
    }
}
