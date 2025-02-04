package DSA.Advanced.DyanmicProgramming;

import java.util.Arrays;

import DSA.Advanced.BitManipulation.strangeEquality;

/*
 * Problem Description

Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum total value that we can fit in the knapsack. If the maximum total value is ans, then return ⌊ans × 100⌋ , i.e., floor of (ans × 100).

NOTE:

You can break an item for maximizing the total value of the knapsack



Problem Constraints

1 <= N <= 105

1 <= A[i], B[i] <= 103

1 <= C <= 103




Input Format

First argument is an integer array A of size N denoting the values on N items.

Second argument is an integer array B of size N denoting the weights on N items.

Third argument is an integer C denoting the knapsack capacity.




Output Format

Return a single integer denoting the maximum total value of A such that sum of the weights of this subset is smaller than or equal to C.



Example Input

Input 1:

 A = [60, 100, 120]
 B = [10, 20, 30]
 C = 50
Input 2:

 A = [10, 20, 30, 40]
 B = [12, 13, 15, 19]
 C = 10


Example Output

Output 1:

 24000
Output 2:

 2105


Example Explanation

Explanation 1:

Taking the full items with weight 10 and 20 and 2/3 of the item with weight 30 will give us 
the maximum value i.e 60 + 100 + 80 = 240. So we return 24000.
Explanation 2:

Taking 10/19 the fourth item gives us the maximum value i.e. 21.0526. So we return 2105.
 */
public class fractionalKnapsack {
    public static int solve(int[] A, int[] B, int C) {
        int n = A.length;

        // Create an array to store value-to-weight ratios along with their index
        double[][] items = new double[n][2];
        for (int i = 0; i < n; i++) {
            items[i][0] = (double) A[i] / B[i]; // value-to-weight ratio
            items[i][1] = i; // original index
        }

        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b[0], a[0]));

        double totalValue = 0.0;
        int remainingCapacity = C;

        // Pick items greedily
        for (int i = 0; i < n; i++) {
            int index = (int) items[i][1];
            if (remainingCapacity == 0) {
                break;
            }

            if (B[index] <= remainingCapacity) {
                // Take the full item
                totalValue += A[index];
                remainingCapacity -= B[index];
            } else {
                // Take a fraction of the item
                totalValue += items[i][0] * remainingCapacity;
                remainingCapacity = 0;
            }
        }

        // Return the floor of (totalValue * 100)
        return (int) Math.floor(totalValue * 100 + 1e-9); // Add small epsilon to handle precision errors
    }
    public static void main(String[] args){
        int[] A = {10, 20, 30, 40};
        int[] B = {12, 13, 15, 19};
        int C = 10;
        int result = solve(A, B, C);
        System.out.println("ans: "+result);
    }    
}
