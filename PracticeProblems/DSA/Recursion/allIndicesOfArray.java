package PracticeProblems.DSA.Recursion;
// Problem Description
// Given an array of integers A with N elements and a target integer B, the task is to find all the indices at which B occurs in the array.

import java.util.ArrayList;
import java.util.List;

// Note: The problem encourages recursive logic for learning purposes. Although the online judge doesn't enforce recursion, it's recommended to use recursive solutions to align with the question's spirit.


// Problem Constraints
// 1 <= N <= 103
// 1 <= A[i] <= 103
// 1 <= B <= 103
// It is guaranteed that the target B, exist atleast once in the Array A.


// Input Format
// First Argument in an Array of Integers, A.
// Second Argument is the Target, B.


// Output Format
// Return the sorted array of indices.


// Example Input
// Input 1:
// A = [1, 2, 3, 4, 5]
// B = 1
// Input 2:
// A = [8, 9, 5, 6, 5, 5]
// B = 5


// Example Output
// Output 1:
// [0]
// Output 2:
// [2, 4, 5]


// Example Explanation
// Explanation 1:
// The Target, 1 occurs on Index = 0.  So returning [0]
// Explanation 2:
// Here, the target 5 occurs at indexes [2, 4, 5].

public class allIndicesOfArray {
        public int[] allIndices(int[] A, int B) {
        List<Integer> result = new ArrayList<>();
        findAllIndices(A, B, 0, result);

        // Convert the List to an array manually
        int[] indicesArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            indicesArray[i] = result.get(i);
        }

        return indicesArray;
    }

    private void findAllIndices(int[] A, int B, int currentIndex, List<Integer> result) {
        // Base case: If the current index is equal to the length of the array, stop recursion
        if (currentIndex == A.length) {
            return;
        }

        // If the current element matches the target, add its index to the result list
        if (A[currentIndex] == B) {
            result.add(currentIndex);
        }

        // Recursively check the next index
        findAllIndices(A, B, currentIndex + 1, result);
    }
}
