package DSA.Advanced.DyanmicProgramming;
/*
 * Problem Description

As it is Tushar's Birthday on March 1st, he decided to throw a party to all his friends at TGI Fridays in Pune. Given are the eating capacity of each friend, filling capacity of each dish and cost of each dish. A friend is satisfied if the sum of the filling capacity of dishes he ate is equal to his capacity. Find the minimum cost such that all of Tushar's friends are satisfied (reached their eating capacity).

NOTE:

Each dish is supposed to be eaten by only one person. Sharing is not allowed.

Each friend can take any dish unlimited number of times.

There always exists a dish with filling capacity 1 so that a solution always exists.



Problem Constraints

|A| <= 1000

|B| <= 1000

|C| <= 1000



Input Format

First Argument is vector A, denoting eating capacities

Second Argument is vector B, denoting filling capacities

Third Argument is vector C, denoting cost



Output Format

Return a single integer, the answer to the problem



Example Input

Input 1:

A = [2, 4, 6]
B = [2, 1, 3]
C = [2, 5, 3]
Input 2:

A = [2]
B = [1]
C = [2]


Example Output

Output 1:

12
Output 2:

4


Example Explanation

Explanation 1:

First friend takes dish 1, Second friend takes dish 1 twice and third friend takes dish 3 twice.
So 2 + 2*2 + 3*2 = 12.
Explanation 2:

Only way is to take 2 dishes of cost 2, hence 4.
 */
public class tusharBirthdayParty {
    public static int solve(final int[] A, final int[] B, final int[] C) {
        int maxCapacity = 0;
        for (int capacity : A) {
            maxCapacity = Math.max(maxCapacity, capacity);
        }
        
        // Initialize DP array
        int[] dp = new int[maxCapacity + 1];
        for (int i = 1; i <= maxCapacity; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        // Fill DP array for all capacities up to maxCapacity
        for (int i = 0; i < B.length; i++) {
            for (int j = B[i]; j <= maxCapacity; j++) {
                if (dp[j - B[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - B[i]] + C[i]);
                }
            }
        }

        // Calculate total cost for all friends
        int totalCost = 0;
        for (int capacity : A) {
            totalCost += dp[capacity];
        }

        return totalCost;
    }
    public static void main(String[] args){
        int[] A = {2, 4, 6};
        int[] B = {2, 1, 3};
        int[] C = {2, 5, 3};
        int result = solve(A, B, C);
        System.out.println("ans: "+result);
    }    
}
