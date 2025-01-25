package DSA.Advanced.BinarySearch;

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


/*
 * Approach:
1. Define GCD and LCM:
    Use the Euclidean algorithm to compute GCD, then calculate LCM as (B×C)/GCD(B,C).
2. Binary Search Setup:
    Initialize low to 1 and high to 𝐴×min(𝐵,𝐶), the upper bound for the Ath magical number.
    Precompute the LCM of B and C as lcmBC.
3. Binary Search:
    In each iteration, calculate mid as the middle value of the current range.
    Count the total magical numbers less than or equal to mid.
    If count is less than A, update low to mid + 1. Otherwise, set high to mid.
4.Return Result:
    When the search ends, low contains the Ath magical number.

TC = 𝑂(log(𝐴×min(𝐵,𝐶))+log(min(𝐵,𝐶)))
SC = 𝑂(1)

 */
public class AthMagicalNumber {
    private static final int MOD = 1000000007;
    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Helper function to calculate the least common multiple
    private static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static int solve(int A, int B, int C) {
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
    
    public static void main(String[] args){
        int A= 1;
        int B = 2;
        int C= 3;
        int result = solve(A,B,C);
        System.out.println("magical number: "+result);
    }
}
