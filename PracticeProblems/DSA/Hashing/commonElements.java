package PracticeProblems.DSA.Hashing;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
 * Problem Description
Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.
NOTE:
Each element in the result should appear as many times as it appears in both arrays.
The result can be in any order.

Problem Constraints
1 <= N, M <= 105
1 <= A[i] <= 109

Input Format
First argument is an integer array A of size N.
Second argument is an integer array B of size M.

Output Format
Return an integer array denoting the common elements.

Example Input
Input 1:
 A = [1, 2, 2, 1]
 B = [2, 3, 1, 2]

Input 2:
 A = [2, 1, 4, 10]
 B = [3, 6, 2, 10, 10]


Example Output
Output 1:
 [1, 2, 2]

Output 2:
 [2, 10]

Example Explanation
Explanation 1:
 Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.

Explantion 2:
 Elements (2, 10) appears in both the array.
 */

public class commonElements {
      public int[] solve(int[] A, int[] B) {
      // Just write your code below to complete the function. Required input is available to you as the function arguments.
      // Do not print the result or any output. Just return the result via this function.
        int N = A.length;
        int M = B.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (map.containsKey(A[i])) {
                int count = map.get(A[i]);
                map.put(A[i], count + 1);
            } else {
                map.put(A[i], 1);
            }
        }
        
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            if (map.containsKey(B[i])) {
                int count = map.get(B[i]);
                
                if (count > 0) {
                    resultList.add(B[i]);
                    map.put(B[i], count - 1);
                }
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        
        return result;
  }
}
