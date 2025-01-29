package DSA.Advanced.Recursion;
// Problem Description
// You are given an integer A, print A to 1 using using recursion.

// Note :- After printing all the numbers from A to 1, print a new line.



// Problem Constraints
// 1 <= A <= 104



// Input Format
// First argument A is an integer.



// Output Format
// Print A space-separated integers A to 1.
// Note: There should be exactly one space after each integer. Print a new line after printing the A integers



// Example Input
// Input 1:

// 10
// Input 2:

// 5


// Example Output
// Output 1:

// 10 9 8 7 6 5 4 3 2 1 
// Output 2:

// 5 4 3 2 1 


// Example Explanation
// Explanation 1:

// Print 10 to 1 space separated integers.
// Explanation 2:

// Print 5 to 1 space separated integers.

public class printAToOne {
    public void solve(int A) {
        // Create a StringBuilder to hold the output
        StringBuilder result = new StringBuilder();
        
        // Helper function to accumulate the result
        accumulateNumbers(A, result);
        
        // Print the accumulated result
        System.out.println(result.toString());
    }
    
    private void accumulateNumbers(int A, StringBuilder result) {
        if (A == 0) {
            return;
        }
        // Accumulate the current number and a space
        result.append(A).append(" ");
        
        // Recursive call to process the next number
        accumulateNumbers(A - 1, result);
    }
}
