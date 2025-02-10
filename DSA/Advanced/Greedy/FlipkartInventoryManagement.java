package DSA.Advanced.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Problem Description
In the recent expansion into grocery delivery, Flipkart faces a crucial challenge in effective inventory management. Each grocery item on the platform carries its own expiration date and profit margin, represented by two arrays, A and B of size N. A[i] denotes the time left before expiration date for the ith item, and B[i] denotes profit margin for the ith item. To mitigate potential losses due to expiring items, Flipkart is seeking a strategic solution.
The objective is to identify a method to strategically buy certain items, ensuring they are sold before their expiration date, thereby maximizing overall profit. Can you assist Flipkart in developing an innovative approach to optimize their grocery inventory and enhance profitability?
Your task is to find the maximum profit one can earn by buying groceries considering that you can only buy one grocery item at a time.

NOTE:
You can assume that it takes 1 minute to buy a grocery item, so you can only buy the ith grocery item when the current time <= A[i] - 1.
You can start buying from day = 0.
Return your answer modulo 109 + 7.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109
0 <= B[i] <= 109


Input Format
The first argument is an integer array A represents the deadline for buying the grocery items.
The second argument is an integer array B represents the profit obtained after buying the grocery items.

Output Format
Return an integer denoting the maximum profit you can earn.

Example Input
Input 1:
 A = [1, 3, 2, 3, 3]
 B = [5, 6, 1, 3, 9]

Input 2:
 A = [3, 8, 7, 5]
 B = [3, 1, 7, 19]

Example Output
Output 1:
 20

Output 2:
 30

Example Explanation
Explanation 1:
 At time 0, buy item with profit 5.
 At time 1, buy item with profit 6.
 At time 2, buy item with profit 9.
 At time = 3 or after , you can't buy any item, as there is no item with deadline >= 4.
 So, total profit that one can earn is 20.

Explanation 2:
 At time 0, buy item with profit 3.
 At time 1, buy item with profit 1.
 At time 2, buy item with profit 7.
 At time 3, buy item with profit 19.
 We are able to buy all items within their deadline. So, total profit that one can earn is 30.
 */

public class FlipkartInventoryManagement {
    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int MOD = 1000000007;
        int n = A.size();
        int[][] items = new int[n][2];
        for (int i = 0; i < n; i++) {
            items[i][0] = A.get(i);
            items[i][1] = B.get(i);
        }
        Arrays.sort(items, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long totalProfit = 0;
        for (int[] item : items) {
            int deadline = item[0];
            int profit = item[1];
            if (minHeap.size() < deadline) {
                minHeap.add(profit);
                totalProfit += profit;
            }
            else if (!minHeap.isEmpty() && minHeap.peek() < profit) {
                totalProfit += profit - minHeap.poll();
                minHeap.add(profit);
            }
            totalProfit %= MOD;
        }
        return (int) totalProfit;
    }
    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 3, 2, 3, 3));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(5, 6, 1, 3, 9));
        int result = solve(A, B);
        System.out.println("ans: "+result);
    }    
}
