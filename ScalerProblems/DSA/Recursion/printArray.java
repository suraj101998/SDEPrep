package ScalerProblems.DSA.Recursion;
// Problem Description
// You are given an array A. Print the elements of the array using recursion.

// NOTE :
// You are required to not use any loops, You can create new functions.
// Don't change the signature of the function PrintArray.
// Print a new empty line after printing the output.


// Problem Constraints
// 1 <= | A | <= 100
// -1000 <= A[i] <= 1000


// Input Format
// One line containing the array A


// Output Format
// Print the elements of the array in the sequential order.


// Example Input
// Input 1 :
// A = [6, -2, 5, 3]
// Input 2 :
// A = [1]


// Example Output
// Output 1 :
// 6 -2 5 3 
// Output 2 :
// 1 


// Example Explanation
// Print the elements in their order.

public class printArray {
    public void PrintArray(int[] A) {
        PrintArrayHelper(A,0);
        System.out.println();
    }
    private void PrintArrayHelper(int[] A, int indx){
        if (indx== A.length){
            return;
        }
        System.out.print(A[indx] + " ");
        PrintArrayHelper(A,indx+1);
    }
}
