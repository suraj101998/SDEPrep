package DSA.Advanced.Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem Description
Given an integer array A of size N denoting collection of numbers , return all possible permutations.
NOTE:
No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
Return the answer in any order
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. 
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.

Problem Constraints
1 <= N <= 9

Input Format
Only argument is an integer array A of size N.

Output Format
Return a 2-D array denoting all possible permutation of the array.

Example Input
A = [1, 2, 3]

Example Output
[ [1, 2, 3]
  [1, 3, 2]
  [2, 1, 3] 
  [2, 3, 1] 
  [3, 1, 2] 
  [3, 2, 1] ]

Example Explanation
All the possible permutation of array [1, 2, 3].
 */
public class permutations {
    public int[][] permute(int[] A) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(A, 0, result);
        // Convert List<List<Integer>> to int[][]
        int[][] permutations = new int[result.size()][A.length];
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < A.length; j++) {
                permutations[i][j] = result.get(i).get(j);
            }
        }
        return permutations;
    }
    private void generatePermutations(int[] A, int index, List<List<Integer>> result) {
        if (index == A.length) {
            List<Integer> currentPermutation = new ArrayList<>();
            for (int num : A) {
                currentPermutation.add(num);
            }
            result.add(currentPermutation);
            return;
        }
        for (int i = index; i < A.length; i++) {
            swap(A, index, i);  // Swap the current element with element at i
            generatePermutations(A, index + 1, result);  // Recurse
            swap(A, index, i);  // Backtrack (undo the swap)
        }
    }
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
