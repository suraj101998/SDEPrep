package PracticeProblems.DSA.Heaps;

import java.util.Arrays;

/*
 * Problem Description

Max Heap is a special kind of complete binary tree in which, for every node, the value present in that node is greater than the value present in its children nodes.




Find the number of distinct Max Heap that can be made from A distinct integers.

In short, you have to ensure the following properties for the max heap :

Heap has to be a complete binary tree ( A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.)
Every node is greater than all its children.
NOTE: If you want to know more about Heaps, please visit this link. Return your answer modulo 109 + 7.






Problem Constraints

1 <= A <= 100



Input Format

The first and only argument is an integer A.



Output Format

Return an integer denoting the number of distinct Max Heap.



Example Input

Input 1:

 A = 4
Input 2:

 A = 10


Example Output

Output 1:

 3
Output 2:

 3360


Example Explanation

Explanation 1:

 Let us take 1, 2, 3, 4 as our 4 distinct integers
 Following are the 3 possible max heaps from these 4 numbers :
      4           4                     4
    /  \         / \                   / \ 
   3    2   ,   2   3      and        3   1
  /            /                     /    
 1            1                     2
Explanation 2:

 Number of distinct heaps possible with 10 distinct integers = 3360.
 */
public class waysToFormMaxHeap {
    private static final int MOD = 1000000007;
    private static int[] dp;
    private static int[][] comb;
    private static int[] log2;

    public int solve(int A) {
        if (A <= 1) return 1;
        dp = new int[A + 1];
        Arrays.fill(dp, -1);
        dp[0] = dp[1] = 1;
        log2 = new int[A + 1];
        for (int i = 2; i <= A; i++) {
            log2[i] = log2[i / 2] + 1;
        }
        comb = new int[A + 1][A + 1];
        computeCombinations(A);
        return countMaxHeaps(A);
    }
    
    private void computeCombinations(int n) {
        for (int i = 0; i <= n; i++) {
            comb[i][0] = comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = (int) ((comb[i - 1][j - 1] + comb[i - 1][j]) % MOD);
            }
        }
    }
    
    private int countMaxHeaps(int n) {
        if (dp[n] != -1) return dp[n];
        int left = getLeft(n);
        dp[n] = (int) ((comb[n - 1][left] * (long) countMaxHeaps(left) % MOD) * countMaxHeaps(n - 1 - left) % MOD);
        return dp[n];
    }
    
    private int getLeft(int n) {
        if (n == 1) return 0;
        int h = log2[n];
        int maxNodesAtH = 1 << h;
        int actualNodesAtH = n - ((1 << h) - 1);
        if (actualNodesAtH >= maxNodesAtH / 2) return (1 << h) - 1;
        return (1 << h) - 1 - (maxNodesAtH / 2 - actualNodesAtH);
    }    
}
