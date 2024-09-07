package ScalerProblems.ProblemSolving.twoDmatrices;
// Problem Description
// You are given a N X N integer matrix. You have to find the sum of all the main diagonal elements of A.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main diagonal of a matrix A is a collection of elements A[i, j] such that i = j.


// Problem Constraints
// 1 <= N <= 103

// -1000 <= A[i][j] <= 1000



// Input Format
// There are 1 lines in the input. First 2 integers R, C are the number of rows and columns. Then R * C integers follow corresponding to the rowwise numbers in the 2D array A.



// Output Format
// Return an integer denoting the sum of main diagonal elements.



// Example Input
// Input 1:

// 3 3 1 -2 -3 -4 5 -6 -7 -8 9
// Input 2:

// 2 2 3 2 2 3


// Example Output
// Output 1:

//  15 
// Output 2:

//  6 


// Example Explanation
// Explanation 1:

// The size of matrix is 3.
// So, considering the indexing from 0.
// Main diagonal elements will be A[0][0], A[1][1] and A[2][2]
// A[1][1] + A[2][2] + A[3][3] = 1 + 5 + 9 = 15
// Explanation 2:

// The size of matrix is 2.
// So, considering the indexing from 0.
// Main diagonal elements will be A[0][0] and A[1][1].
// A[1][1] + A[2][2] = 3 + 3 = 6

public class mainDiagonalSum {
        public int solve(final List<ArrayList<Integer>> A) {
        int N = A.size();
        int sum = 0;
        // Summing up the main diagonal elements
        for (int i = 0; i < N; i++) {
            sum += A.get(i).get(i);
        }
        
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the dimensions of the matrix
        int R = scanner.nextInt();
        int C = scanner.nextInt();
        // Create the matrix and read the elements
        List<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < C; j++) {
                row.add(scanner.nextInt());
            }
            matrix.add(row);
        }
        // Create a Solution object and call the solve method
        mainDiagonalSum solution = new mainDiagonalSum();
        int result = solution.solve(matrix);
        // Print the result
        System.out.println(result);
        scanner.close();
    }
}
