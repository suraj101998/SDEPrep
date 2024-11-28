package PracticeProblems.DSA.DyanmicProgramming;
/*
 * Problem Description
Given an integer A, how many structurally unique BST's (binary search trees) exist that can store values 1...A?

Problem Constraints
1 <= A <=18

Input Format
First and only argument is the integer A

Output Format
Return a single integer, the answer to the problem

Example Input
Input 1:
 1
Input 2:
 2

Example Output
Output 1:
 1
Output 2:
 2

Example Explanation

Explanation 1:
 Only single node tree is possible.
Explanation 2:
 2 trees are possible, one rooted at 1 and other rooted at 2.
 */
public class uniqueBST2 {
    public int numTrees(int A) {
        int[] dp = new int[A + 1];
        dp[0] = 1;  // There's 1 BST with 0 nodes (empty tree)
        dp[1] = 1;  // There's 1 BST with 1 node (single node tree)
        for (int i = 2; i <= A; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];  // Calculate number of BSTs with root j
            }
        }
        return dp[A];
    }    
}
