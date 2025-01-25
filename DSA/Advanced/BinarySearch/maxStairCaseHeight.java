package DSA.Advanced.BinarySearch;
/*
Problem Description
Given an integer A representing the number of square blocks. The height of each square block is 1. 
The task is to create a staircase of max-height using these blocks.
The first stair would require only one block, and the second stair would require two blocks, and so on.
Find and return the maximum height of the staircase.

Problem Constraints
0 <= A <= 10^9

Input Format
The only argument given is integer A.

Output Format
Return the maximum height of the staircase using these blocks.

Example Input
Input 1:
 A = 10
Input 2:
 A = 20

Example Output
Output 1:
 4
Output 2:
 5

Example Explanation
Explanation 1:
 The stairs formed will have height 1, 2, 3, 4.
Explanation 2:
 The stairs formed will have height 1, 2, 3, 4, 5.
*/


/*
 * Approach:
1. Initial Setup:
    If A=0, return 0 as the height is 0.
    Set the binary search range with l = 0 and r = A.
    Initialize result to store the maximum valid height.
2. Binary Search:
    Compute the middle value mid of the current range.
    Calculate the total number of blocks needed for mid.
    If sum equals A, return mid (exact height found).
    If sum is less than A, update result to mid 
    and search in the right half (l = mid + 1).
    If sum is greater than A, search in the left half (r = mid - 1).
3. Return Result:
    After binary search, result contains the maximum staircase height that can be built with A blocks.

TC = O(logA)
SC = O(1)
 */


public class maxStairCaseHeight {
    public static int solve(int A) {
            if (A == 0) {
                return 0;
            }
            int l = 0, r = A;
            int result = 0;      
            while (l <= r) {
                int mid = l + (r - l) / 2;
                long sum = (long) mid * (mid + 1) / 2;  
                if (sum == A) {
                    return mid; 
                } else if (sum < A) {
                    result = mid; 
                    l = mid + 1;
                } else {
                    r = mid - 1; 
                }
            }
            return result;
        }
        public static void main(String[] args){
            int A = 10;
            int result = solve(A);
            System.out.println("max height: " +result);
    }
}
