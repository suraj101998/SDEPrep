package PracticeProblems.ProblemSolving.twoDmatrices;
// Problem Description
// Given a 2D integer array A, return the transpose of A.

import java.util.ArrayList;

// The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.


// Problem Constraints
// 1 <= A.size() <= 1000

// 1 <= A[i].size() <= 1000

// 1 <= A[i][j] <= 1000



// Input Format
// First argument is a 2D matrix of integers.



// Output Format
// You have to return the Transpose of this 2D matrix.



// Example Input
// Input 1:

// A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
// Input 2:

// A = [[1, 2],[1, 2],[1, 2]]


// Example Output
// Output 1:

// [[1, 4, 7], [2, 5, 8], [3, 6, 9]]
// Output 2:

// [[1, 1, 1], [2, 2, 2]]


// Example Explanation
// Explanation 1:

// Clearly after converting rows to column and columns to rows of [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
//  we will get [[1, 4, 7], [2, 5, 8], [3, 6, 9]].
// Explanation 2:

// After transposing the matrix, A becomes [[1, 1, 1], [2, 2, 2]]

public class matrixTranspose {
        public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int rows = A.size();
        int cols = A.get(0).size();
        // Initialize the transpose matrix with the dimensions flipped
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < cols; i++) {
            transpose.add(new ArrayList<>());
            for (int j = 0; j < rows; j++) {
                transpose.get(i).add(0); // Add dummy values to initialize the inner lists
            }
        }
        // Populate the transpose matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose.get(j).set(i, A.get(i).get(j));
            }
        }
        return transpose;
    }
}
