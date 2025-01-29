package DSA.Advanced.BinarySearch;
/* 
Problem Description
You are given a 2-D matrix C of size A × B.
You need to build a new 1-D array of size A by taking one element from each row of the 2-D matrix 
in such a way that the cost of the newly built array is minimized.
The cost of an array is the minimum possible value of the absolute difference between 
any two adjacent elements of the array.
So if the newly built array is X, the element picked from row 1 will become X[1], element 
picked from row 2 will become X[2], and so on. Determine the minimum cost of the newly built array.

Problem Constraints
2 <= A <= 1000
2 <= B <= 1000
1 <= C[i][j] <= 106

Input Format
The first argument is an integer A denoting number of rows in the 2-D array.
The second argument is an integer B denoting number of columns in the 2-D array.
The third argument is a 2-D array C of size A x B.

Output Format
Return an integer denoting the minimum cost of the newly build array.

Example Input
Input 1:
 A = 2
 B = 2
 C = [ [8, 4]
      [6, 8] ]
Input 2:
 A = 3
 B = 2
 C = [ [7, 3]
       [2, 1]
       [4, 9] ]

Example Output
Output 1: 0
Output 2: 1

Example Explanation
Explanation 1:
 Newly build array : [8, 8]. The minimum cost will be 0 since the absolute difference will be 0(8-8).
Explanation 2:
 Newly build array : [3, 2, 4]. The minimum cost will be 1 since the minimum absolute 
 difference will be 1(3 - 2).
 */

 /*
  * 
Approach:
1. Initialize Minimum Cost:
    Start with minCost as Integer.MAX_VALUE to keep track of the overall minimum difference.
    Set the first row (prevRow) of the matrix C as the base for comparison.
2. Iterate Over Rows:
    For each row i from 1 to A-1, consider it as the current row (currRow).
    Reset currMinCost to Integer.MAX_VALUE to store the minimum cost for this row.
3. Calculate Cost for Each Pair:
    For each element currentElement in currRow, calculate the absolute difference with each element prevElement in prevRow.
    Update currMinCost with the smallest difference found in the row.
4. Update Overall Minimum:
    After iterating through all elements of the current row, update minCost with the smallest currMinCost.
5. Update Previous Row:
    Set prevRow to currRow for the next iteration.
6. Return Result:
    The final value of minCost is the minimum absolute difference across all rows.

TC = O(A × B²)
    Outer loop runs for A-1 rows.
    For each row, there are two nested loops:
    First loop iterates over B elements in the current row.
    Second loop iterates over B elements in the previous row.
    Total complexity: O(A × B²).

SC = O(B)
    prevRow and currRow arrays each require space proportional to B.
    Total space complexity: O(B).
  */

  
public class minimumDifference {
    public static int solve(int A, int B, int[][] C) {
            int minCost = Integer.MAX_VALUE;
            int[] prevRow = C[0];
            for (int i = 1; i < A; i++) {
                int[] currRow = C[i];
                int currMinCost = Integer.MAX_VALUE;
                for (int j = 0; j < B; j++) {
                    int currentElement = currRow[j];
                    for (int k = 0; k < B; k++) {
                        int prevElement = prevRow[k];
                        int cost = Math.abs(currentElement - prevElement);
                        currMinCost = Math.min(currMinCost, cost);
                    }
                }
                minCost = Math.min(minCost, currMinCost);
                prevRow = currRow;
            }
    
            return minCost;
        }
        public static void main(String[] args){
            int[][] C = {
                {8, 4},
                {6, 8}
            };
            int B= 2;
            int A= 2;
            int result = solve(A,B,C);
        System.out.println("Min Difference: "+result);
    }
}
