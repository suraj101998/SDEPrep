package ScalerProblems.DSA.Recursion;
// Problem Description
// Implement pow(A, B) % C.
// In other words, given A, B and C, Find (AB % C).
// Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.


// Problem Constraints
// -109 <= A <= 109
// 0 <= B <= 109
// 1 <= C <= 109


// Input Format
// Given three integers A, B, C.


// Output Format
// Return an integer.


// Example Input
// Input 1:
// A = 2
// B = 3
// C = 3
// Input 2:
// A = 3
// B = 3
// C = 1


// Example Output
// Output 1:
// 2
// Output 2:
// 0


// Example Explanation
// Explanation 1:
// 23 % 3 = 8 % 3 = 2
// Explanation 2:
// 33 % 1 = 27 % 1 = 0

public class powerFunction {
    public int pow(int A, int B, int C) {
        // Special case: 0^0 should return 0 when C = 1
        if (A == 0 && B == 0 && C == 1) {
            return 0;
        }
        // Handle negative A by converting it to a positive equivalent within the modulo space
        if (A < 0) {
            A = (A % C + C) % C;
        }
        
        // Recursive method to calculate (A^B) % C
        return modExp(A, B, C);
    }

    private int modExp(int A, int B, int C) {
        if (B == 0) {
            return 1; // Base case: A^0 = 1
        }

        long half = modExp(A, B / 2, C); // Recursively calculate (A^(B/2)) % C
        half = (half * half) % C; // Square the result

        // If B is odd, multiply by A
        if (B % 2 != 0) {
            half = (half * A) % C;
        }

        return (int) half; // Convert the result back to an integer
    }
}
