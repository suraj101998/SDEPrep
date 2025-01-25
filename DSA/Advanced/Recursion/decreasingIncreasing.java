package DSA.Advanced.Recursion;
// Problem Description
// Print N numbers in Decreasing Order and then in Increasing Order.

// You are given a positive number N.
// You are required to print the numbers from N to 1.
// You are required to not use any loops. Don't change the signature of the function DecThenInc function.
// Note : Please print an new line after printing the output.


// Problem Constraints
// 1 <= N <= 100


// Input Format
// The first line contains a single integer N.


// Output Format
// A single line having number printed from N to 1 and then from 1 to N.


// Example Input
// Input 2:
// 1
// Input 1:
// 4


// Example Output
// Output 1:
// 1 1
// Output 2:
// 4 3 2 1 1 2 3 4


// Example Explanation
// Elements are First printer from N down to 1 and then 1 upto N.

public class decreasingIncreasing {
    public void DecThenInc(int A) {
        // First print the numbers in decreasing order
        printDecreasing(A);
        
        // Then print the numbers in increasing order
        printIncreasing(1, A);
        
        // Print a new line at the end as required
        System.out.println();
    }
    
    // Function to print numbers from A down to 1
    private void printDecreasing(int A) {
        if (A < 1) {
            return;
        }
        System.out.print(A + " ");  // Print the current number
        printDecreasing(A - 1);     // Recursive call to print the next number
    }
    
    // Function to print numbers from 1 up to A
    private void printIncreasing(int current, int A) {
        if (current > A) {
            return;
        }
        System.out.print(current + " ");  // Print the current number
        printIncreasing(current + 1, A);  // Recursive call to print the next number
    }
}
