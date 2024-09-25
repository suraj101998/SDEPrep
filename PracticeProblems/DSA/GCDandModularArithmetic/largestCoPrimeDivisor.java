package PracticeProblems.DSA.GCDandModularArithmetic;
// Problem Description

// You are given two positive numbers A and B . You need to find the maximum valued integer X such that:

// X divides A i.e. A % X = 0
// X and B are co-prime i.e. gcd(X, B) = 1


// Problem Constraints

// 1 <= A, B <= 109



// Input Format

// First argument is an integer A.
// Second argument is an integer B.



// Output Format

// Return an integer maximum value of X as descibed above.



// Example Input

// Input 1:

//  A = 30
//  B = 12
// Input 2:

//  A = 5
//  B = 10


// Example Output

// Output 1:

//  5
// Output 2:

//  1


// Example Explanation

// Explanation 1:

//  All divisors of A are (1, 2, 3, 5, 6, 10, 15, 30). 
//  The maximum value is 5 such that A%5 == 0 and gcd(5,12) = 1
// Explanation 2:

//  1 is the only value such that A%5 == 0 and gcd(1,10) = 1

public class largestCoPrimeDivisor {
        // Function to compute the greatest common divisor
        public static int gcd(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
    
        // Function to compute the maximum divisor of A which is co-prime with B
        public int cpFact(int A, int B) {
            int maxDivisor = 1; // Initialize max divisor as 1
            
            // Check divisors up to square root of A
            for (int i = 1; i * i <= A; i++) {
                if (A % i == 0) {
                    // i is a divisor of A
                    if (gcd(i, B) == 1) {
                        maxDivisor = Math.max(maxDivisor, i);
                    }
                    // A / i is also a divisor of A
                    if (i != A / i && gcd(A / i, B) == 1) {
                        maxDivisor = Math.max(maxDivisor, A / i);
                    }
                }
            }
            
            return maxDivisor;
        }
}
