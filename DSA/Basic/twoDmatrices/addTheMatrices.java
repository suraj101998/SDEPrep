package DSA.Basic.twoDmatrices;
// Problem Description

import java.util.ArrayList;

// You are given two matrices A & B of same size, you have to return another matrix which is the sum of A and B.
// Note: Matrices are of same size means the number of rows and number of columns of both matrices are equal.

// Problem Constraints

// 1 <= A.size(), B.size() <= 1000 1 <= A[i].size(), B[i].size() <= 1000 1 <= A[i][j], B[i][j] <= 1000
// Input Format

// The first argument is the 2D integer array A The second argument is the 2D integer array B
// Output Format

// You have to return a vector of vector of integers after doing required operations.
// Example Input

// Input 1:
// A = [[1, 2, 3],   
//      [4, 5, 6],   
//      [7, 8, 9]]  

// B = [[9, 8, 7],   
//      [6, 5, 4],   
//      [3, 2, 1]]
 
// Input 2:
// A = [[1, 2, 3],   
//      [4, 1, 2],   
//      [7, 8, 9]]  

// B = [[9, 9, 7],   
//      [1, 2, 4],   
//      [4, 6, 3]]
 
// Example Output

// Output 1:
// [[10, 10, 10],   
//  [10, 10, 10],   
//  [10, 10, 10]]
// Output 2:
// [[10, 11, 10],   
//  [5,   3,  6],   
//  [11, 14, 12]]
// Example Explanation

// Explanation 1:
// A + B = [[1+9, 2+8, 3+7],  
//          [4+6, 5+5, 6+4],  
//          [7+3, 8+2, 9+1]]   
//       = [[10, 10, 10],   
//          [10, 10, 10],   
//          [10, 10, 10]].
// Explanation 2:
// A + B = [[1+9, 2+9, 3+7],  
//          [4+1, 1+2, 2+4],  
//          [7+4, 8+6, 9+3]]   
//       = [[10, 11, 10],   
//          [5,   3,  6],   
//          [11, 14, 12]].

public class addTheMatrices {
        public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        // Determine the number of rows and columns
        int rows = A.size();
        int cols = A.get(0).size();
        
        // Initialize the result matrix with the same size as A and B
        ArrayList<ArrayList<Integer>> C = new ArrayList<>();
        
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                // Compute the sum of the corresponding elements and add to the row
                row.add(A.get(i).get(j) + B.get(i).get(j));
            }
            // Add the row to the result matrix
            C.add(row);
        }
        
        return C;
    }

    // Main method for testing
    public static void main(String[] args) {
        addTheMatrices solution = new addTheMatrices();
        
        // Example input
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        
        A.add(new ArrayList<Integer>() {{ add(1); add(2); add(3); }});
        A.add(new ArrayList<Integer>() {{ add(4); add(5); add(6); }});
        A.add(new ArrayList<Integer>() {{ add(7); add(8); add(9); }});
        
        B.add(new ArrayList<Integer>() {{ add(9); add(8); add(7); }});
        B.add(new ArrayList<Integer>() {{ add(6); add(5); add(4); }});
        B.add(new ArrayList<Integer>() {{ add(3); add(2); add(1); }});
        
        // Compute the sum
        ArrayList<ArrayList<Integer>> result = solution.solve(A, B);
        
        // Print the result
        for (ArrayList<Integer> row : result) {
            System.out.println(row);
        }
    }
}
