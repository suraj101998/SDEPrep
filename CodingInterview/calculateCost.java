package CodingInterview;
/*
ITC Infotech
You are given N wires, each with a different length. The length of the i-th wire is represented by A[i]. You want to make all the wires equal in length by either extending or cutting them. The cost to change the length of a wire is equal to the absolute difference between its original length and the desired target length.

Write a program that calculates the minimum total cost required to make all the wires have the same length. The target length can be any length from the array A.

Input:
The first line contains an integer N (1 ≤ N ≤ 1000) — the number of wires.
The second line contains N integers A[i] (1 ≤ A[i] ≤ 1000) — the lengths of the wires.
Output:
Print a single integer — the minimum total cost to make all wires the same length.

INPUT:
5
2 3 1 4 5

OUTPUT:

6

For an input N = 5 and A = [2, 3, 1, 4, 5], the program calculates the cost for each target length:

For target 2: |2-2| + |3-2| + |1-2| + |4-2| + |5-2| = 0 + 1 + 1 + 2 + 3 = 7
For target 3: |2-3| + |3-3| + |1-3| + |4-3| + |5-3| = 1 + 0 + 2 + 1 + 2 = 6
For target 1: |2-1| + |3-1| + |1-1| + |4-1| + |5-1| = 1 + 2 + 0 + 3 + 4 = 10
For target 4: |2-4| + |3-4| + |1-4| + |4-4| + |5-4| = 2 + 1 + 3 + 0 + 1 = 7
For target 5: |2-5| + |3-5| + |1-5| + |4-5| + |5-5| = 3 + 2 + 4 + 1 + 0 = 10
The minimum cost is 6 when the target length is 3. Therefore, result = 6.

*/


import java.util.*;
public class calculateCost {
    public static int minimumCost(int N, int[] A) {
        int result = -404;

        // Write your logic here:
        int minCost = Integer.MAX_VALUE;

        // Iterate over each element in A as a potential target length
        for (int target : A) {
            int currentCost = 0;
            
            // Calculate the cost of making all wires equal to the target length
            for (int length : A) {
                currentCost += Math.abs(length - target);
            }
            
            // Update the minimum cost found
            if (currentCost < minCost) {
                minCost = currentCost;
            }
        }

        result = minCost;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int result = minimumCost(N, A);
        System.out.println(result);
    }

}
