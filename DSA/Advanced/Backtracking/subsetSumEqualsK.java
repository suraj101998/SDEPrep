package DSA.Advanced.Backtracking;
/*
 * Problem Description
Given an integer array A of size N.
You are also given an integer B, you need to find whether their exist a subset in A whose sum equal B.
If there exist a subset then return 1 else return 0.
Note : Sum of elements of an empty subset is 0.

Problem Constraints
1 <= N <= 17
-109 <= A[i] <= 109
-109 <= B <= 109

Input Format
First argument is an integer array A.
Second argument is an integer B.

Output Format
Return 1 if there exist a subset with sum B else return 0.

Example Input
Input 1:
 A = [3, 34, -3, 12, 5, 2]
 B = 9

Input 2:
 A = [-8, 34, 4, 0, -5, -2]
 B = -20

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 There is a subset (-3, 12) with sum 9.
Explanation 2:
 There is no subset that add up to -20.
 */
public class subsetSumEqualsK {
    public static int SubsetSum(int[] A, int B) {
        if (subsetSumHelper(A, B, 0, 0)) {
            return 1;
        } else {
            return 0;
        }
    }
    private static boolean subsetSumHelper(int[] A, int target, int index, int currentSum) {
        if (currentSum == target) {
            return true;
        }
        if (index == A.length) {
            return false;
        }
        boolean include = subsetSumHelper(A, target, index + 1, currentSum + A[index]);
        boolean exclude = subsetSumHelper(A, target, index + 1, currentSum);
        return include || exclude;
    }
    public static void main(String[] args){
        int[] A = {3, 34, -3, 12, 5, 2};
        int B = 9;
        int result = SubsetSum(A, B);
        System.out.println("ans: "+result);
    }
}
