/*
Problem Description
        You are given an array A of length N and Q queries given by the 2D array B of size Q×2.
        Each query consists of two integers B[i][0] and B[i][1].
        For every query, your task is to find the count of even numbers in the range from A[B[i][0]] to A[B[i][1]].

        Problem Constraints
        1 <= N <= 105
        1 <= Q <= 105
        1 <= A[i] <= 109
        0 <= B[i][0] <= B[i][1] < N
        
        Input Format
        First argument A is an array of integers.
        Second argument B is a 2D array of integers.

        Output Format
        Return an array of integers.

        Example Input
        Input 1:
        A = [1, 2, 3, 4, 5]
        B = [   [0, 2]
        [2, 4]
        [1, 4]   ]
        Input 2:
        A = [2, 1, 8, 3, 9, 6]
        B = [   [0, 3]
        [3, 5]
        [1, 3]
        [2, 4]   ]

        Example Output
        Output 1:
        [1, 1, 2]
        Output 2:
        [2, 1, 1, 1]

        Example Explanation
        For Input 1:
        The subarray for the first query is 1, 2, 3 which contains 1 even number.
        The subarray for the second query is 3, 4, 5 which contains 1 even number.
        The subarray for the third query is 2, 3, 4, 5 which contains 2 even numbers.
        For Input 2:
        The subarray for the first query is 2, 1, 8, 3 which contains 2 even numbers.
        The subarray for the second query is 3, 9, 6 which contains 1 even number.
        The subarray for the third query is 1, 8, 3 which contains 1 even number.
        The subarray for the fourth query is 8, 3, 9 which contains 1 even number.
*/
package ScalerProblems.SAT;
import java.util.ArrayList;
import java.util.List;
public class CountEvenNumbersInRange {
    public static List<Integer> countEvenNumbers(int[] A, int[][] B) {
        int N = A.length;
        int Q = B.length;
        // Step 1: Create prefix_even_count array
        int[] prefixEvenCount = new int[N];
        prefixEvenCount[0] = A[0] % 2 == 0 ? 1 : 0;
        for (int i = 1; i < N; i++) {
            prefixEvenCount[i] = prefixEvenCount[i - 1] + (A[i] % 2 == 0 ? 1 : 0);
        }
        // Step 2: Answer each query using the prefix_even_count array
        List<Integer> result = new ArrayList<>();
        for (int[] query : B) {
            int l = query[0];
            int r = query[1];
            int evenCount;
            if (l == 0) {
                evenCount = prefixEvenCount[r];
            } else {
                evenCount = prefixEvenCount[r] - prefixEvenCount[l - 1];
            }
            result.add(evenCount);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] A1 = {1, 2, 3, 4, 5};
        int[][] B1 = { {0, 2}, {2, 4}, {1, 4} };
        System.out.println(countEvenNumbers(A1, B1)); // Output: [1, 1, 2]

        int[] A2 = {2, 1, 8, 3, 9, 6};
        int[][] B2 = { {0, 3}, {3, 5}, {1, 3}, {2, 4} };
        System.out.println(countEvenNumbers(A2, B2)); // Output: [2, 1, 1, 1]
    }
}