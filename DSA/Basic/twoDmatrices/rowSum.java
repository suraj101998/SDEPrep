package DSA.Basic.twoDmatrices;
// Problem Constraints
// 1 <= A.size() <= 103

import java.util.ArrayList;

// 1 <= A[i].size() <= 103

// 1 <= A[i][j] <= 103



// Input Format
// First argument A is a 2D array of integers.(2D matrix).



// Output Format
// Return an array containing row-wise sums of original matrix.



// Example Input
// Input 1:

// [1,2,3,4]
// [5,6,7,8]
// [9,2,3,4]


// Example Output
// Output 1:

// [10,26,18]


// Example Explanation
// Explanation 1

// Row 1 = 1+2+3+4 = 10
// Row 2 = 5+6+7+8 = 26
// Row 3 = 9+2+3+4 = 18

public class rowSum {
        public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        int numRows = A.size();
        int numCols = A.get(0).size();

        ArrayList<Integer> rowSums= new ArrayList<>(numRows);
        for(int i=0; i< numRows; i++){
            rowSums.add(0);
        }

        for (int i = 0; i<numRows; i++){
            int sum = 0;
            for (int j=0; j<numCols; j++){
                sum += A.get(i).get(j);
            }
            rowSums.set(i,sum);
        }
        return rowSums;
    }
}
