package PracticeProblems.DSA.Hashing;
import java.util.ArrayList;
import java.util.HashMap;

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
Input 1
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
public class longestSubarrayZeroSum2 {
    public int solve(ArrayList<Integer> A) {
        HashMap<Long, Integer> pSum = new HashMap<>();
        long totalSum = 0;
        int maxLength = 0;
        for (int i = 0; i < A.size(); i++) {
            totalSum += A.get(i);
            if (totalSum == 0) {
                maxLength = i + 1;
            }
            if (pSum.containsKey(totalSum)) {
                int previousIndex = pSum.get(totalSum);
                maxLength = Math.max(maxLength, i - previousIndex);
            } else {
                pSum.put(totalSum, i);
            }
        }
        return maxLength;
    }
}
