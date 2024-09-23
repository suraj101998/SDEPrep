package ScalerProblems.DSA.BinarySearch;

/*
Any positive integer is magical if divisible by either B or C.
Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
Note: Ensure to prevent integer overflow while calculating.

Problem Constraints
1 <= A <= 109
2 <= B, C <= 40000

Input Format
The first argument given is an integer A.
The second argument given is an integer B.
The third argument given is an integer C.

Output Format
Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

Example Input
Input 1:
 A = 1
 B = 2
 C = 3
Input 2:
 A = 4
 B = 2
 C = 3

Example Output
Output 1:
 2
Output 2:
 6

Example Explanation
Explanation 1:
 1st magical number is 2.
Explanation 2:
 First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
*/

public class AthMagicalNumber {
    private static final int MOD = 1000000007;
    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Helper function to calculate the least common multiple
    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public int solve(int A, int B, int C) {
        long low = 1;
        long high = (long) A * Math.min(B, C);  // Upper bound for the binary search
        long lcmBC = lcm(B, C);
        
        // Binary search to find the Ath magical number
        while (low < high) {
            long mid = (low + high) / 2;
            long count = (mid / B) + (mid / C) - (mid / lcmBC);
            
            if (count < A) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return (int) (low % MOD);
    }
}
