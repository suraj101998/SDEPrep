package DSA.Advanced.DyanmicProgramming;

import java.util.HashMap;
/*
 * Problem Description

Given a strictly increasing array A of positive integers forming a sequence.

A sequence X1, X2, X3, ..., XN is fibonacci like if


N > =3
Xi + Xi+1 = Xi+2 for all i+2 <= N
Find and return the length of the longest Fibonacci-like subsequence of A.

If one does not exist, return 0.

NOTE: A subsequence is derived from another sequence A by deleting any number of elements (including none) from A, without changing the order of the remaining elements.



Problem Constraints

3 <= length of the array <= 1000

1 <= A[i] <= 109



Input Format

The only argument given is the integer array A.



Output Format

Return the length of the longest Fibonacci-like subsequence of A.
If one does not exist, return 0.



Example Input

Input 1:

 A = [1, 2, 3, 4, 5, 6, 7, 8]
Input 2:

 A = [1, 3, 7, 11, 12, 14, 18]


Example Output

Output 1:

 5
Output 2:

 3


Example Explanation

Explanation 1:

 The longest subsequence that is fibonacci-like: [1, 2, 3, 5, 8].
Explanation 2:

 The longest subsequence that is fibonacci-like: [1, 11, 12], [3, 11, 14] or [7, 11, 18].
 The length will be 3.
 */
public class longestFiboSeqlength {
    public static int solve(int[] A) {
        int n = A.length;
        if (n < 3) return 0;
        // Map to store the index of each value in A
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(A[i], i);
        }
        // Map to store the length of Fibonacci-like subsequences
        HashMap<String, Integer> dp = new HashMap<>();
        int maxLength = 0;
        // Iterate over all pairs (j, k) where j < k
        for (int k = 0; k < n; k++) {
            for (int j = 0; j < k; j++) {
                int Ai = A[k] - A[j]; // Find A[i]
                if (Ai >= A[j]) continue; // Ensure A[i] < A[j] for strictly increasing
                if (indexMap.containsKey(Ai)) {
                    int i = indexMap.get(Ai); // Get the index of A[i]
                    String key = i + "," + j; // Key for dp map
                    int length = dp.getOrDefault(key, 2) + 1;
                    dp.put(j + "," + k, length); // Update dp for (j, k)
                    maxLength = Math.max(maxLength, length);
                } else {
                    dp.put(j + "," + k, 2); // Default length for new pair
                }
            }
        }
        return maxLength >= 3 ? maxLength : 0; // Return maxLength if >= 3, else 0
    }
    public static void main(String[] args){
        int[] A = {1, 3, 7, 11, 12, 14, 18};
        int result = solve(A);
        System.out.println("ans: "+result);
    }    
}
