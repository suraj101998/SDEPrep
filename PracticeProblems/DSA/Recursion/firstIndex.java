package PracticeProblems.DSA.Recursion;
// Problem Description
// You are given an array A of size N. Write a recursive function that returns the first index at which an integer B is found in the array.

// NOTE: If B is not found anywhere in the array then return -1.


// Problem Constraints
// 1 <= N <= 100
// -1000 <= A[i] <= 1000
// -1000 <= B <= 1000


// Input Format
// The function contains two arguments.
// The first argument is the array A.
// The second argument is the element B that is to be searched.


// Output Format
// Return the Index of B from the list in integer format if B is present in the array, else return -1.


// Example Input
// Input 1 :
// A = [-3, 5, 6, 2]  
// B = 6
// Input 2 :
// A = [0, 1, 0, 2]  
// B = 3


// Example Output
// Ouput 1 :
// 2
// Ouput 2 :
// -1


// Example Explanation
// For Input 1 :
// At index 0 we have -3
// At index 1 we have 5
// At index 2 we have 6 which is equal to B
// For Input 2 :
// The element B = 3 is nowhere to be found in the array so we print -1

public class firstIndex {
    public int FirstIndex(int[] A, int B) {
        // Start the recursion from the first index (0)
        return findFirstIndex(A, B, 0);
    }

    private int findFirstIndex(int[] A, int B, int index) {
        // Base case: If index reaches the length of the array, return -1 (not found)
        if (index == A.length) {
            return -1;
        }

        // If the element at the current index is equal to B, return the current index
        if (A[index] == B) {
            return index;
        }

        // Otherwise, recursively search in the rest of the array
        return findFirstIndex(A, B, index + 1);
    }
}
