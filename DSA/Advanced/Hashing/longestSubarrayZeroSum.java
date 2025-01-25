package DSA.Advanced.Hashing;
/* Problem Description
Given an array A of N integers.
Find the length of the longest subarray in the array which sums to zero.
If there is no subarray which sums to zero then return 0.

Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109

Input Format
Single argument which is an integer array A.

Output Format
Return an integer.

Example Input
Input 1:
 A = [1, -2, 1, 2]

Input 2:
 A = [3, 2, -1]

Example Output
Output 1:
3

Output 2:
0

Example Explanation
Explanation 1:
 [1, -2, 1] is the largest subarray which sums up to 0.

Explanation 2:
 No subarray sums up to 0.
 */

import java.util.HashMap;

public class longestSubarrayZeroSum {
    public static int solve(int[] A) {
        HashMap<Long, Integer> pref = new HashMap<Long, Integer>();
        Long curr = 0L;
        int ans = 0;
        pref.put(0L, 0);
        for(int i = 1 ; i <= A.length ; i++){
            curr += A[i - 1];
            if(pref.containsKey(curr)){
                ans = Math.max(ans, i - pref.get(curr));
            }
            else{
                pref.put(curr, i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A= {1, -2, 1, 2};
        int result = solve(A);
        System.out.println("ans: "+result);
    }
}

