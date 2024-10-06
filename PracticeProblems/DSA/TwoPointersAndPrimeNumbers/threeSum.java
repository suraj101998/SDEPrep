package PracticeProblems.DSA.TwoPointersAndPrimeNumbers;
/*
 * Problem Description
Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.
Assume that there will only be one solution.

Problem Constraints
-108 <= B <= 108
1 <= N <= 104
-108 <= A[i] <= 108

Input Format
First argument is an integer array A of size N.
Second argument is an integer B denoting the sum you need to get close to.

Output Format
Return a single integer denoting the sum of three integers which is closest to B.

Example Input
Input 1:
A = [-1, 2, 1, -4]
B = 1
Input 2: 
A = [1, 2, 3]
B = 6

Example Output
Output 1:
2
Output 2:
6

Example Explanation
Explanation 1:
 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
Explanation 2:
 Take all elements to get exactly 6.
 */
import java.util.*;
public class threeSum {
    public int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);        
        int closestSum = Integer.MAX_VALUE;
        int N = A.length;
        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;
            while (left < right) {
                int currentSum = A[i] + A[left] + A[right];
                // Update closest sum if the current sum is closer to the target
                if (closestSum == Integer.MAX_VALUE || Math.abs(currentSum - B) < Math.abs(closestSum - B)) {
                    closestSum = currentSum;
                }
                if (currentSum < B) {
                    left++;
                } else if (currentSum > B) {
                    right--;
                } else {
                    return currentSum;
                }
            }
        }
        return closestSum;
    }
}
