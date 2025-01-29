package DSA.Advanced.DyanmicProgramming;

import java.util.ArrayList;

/*
 * Problem Description

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.








Adjacent numbers for jth column of ith row is jth and (j+1)th column of (i + 1)th row








Problem Constraints

|A| <= 1000

A[i] <= 1000



Input Format

First and only argument is the vector of vector A defining the given triangle



Output Format

Return the minimum sum



Example Input

Input 1:

 
A = [ 
         [2],
        [3, 4],
       [6, 5, 7],
      [4, 1, 8, 3]
    ]
Input 2:

 A = [ [1] ]


Example Output

Output 1:

 11
Output 2:

 1


Example Explanation

Explanation 1:

 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
Explanation 2:

 Only 2 can be collected.
 */
public class MinSumPathTriangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                int minAdjacent = Math.min(a.get(row + 1).get(col), a.get(row + 1).get(col + 1));
                a.get(row).set(col, a.get(row).get(col) + minAdjacent);
            }
        }
        return a.get(0).get(0);
    }    
}
