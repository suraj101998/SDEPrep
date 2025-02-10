package DSA.Advanced.GCDandModularArithmetic;
/*Problem Description
Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
Since the answer may be large, return the answer modulo (109 + 7).
Note: Ensure to handle integer overflow when performing the calculations.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 106

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).

Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
 B = 2

Input 2:
 A = [5, 17, 100, 11]
 B = 28

Example Output
Output 1:
 4

Output 2:
 1

Example Explanation
Explanation 1:
 All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5). 
 So total 4 pairs.
Explanation 2:
 There is only one pair which is divisible by 28 is (17, 11)
*/
public class pairSumDivisibleByM {
    public static int solve(int[] A, int B) {
        long mod = 1000000007;
        int[] freq = new int[B]; // Frequency array to store remainders
        // Fill the frequency array
        for (int i = 0; i < A.length; i++) {
            freq[A[i] % B]++;
        }   
        long ans = 0;
        // Handle the pairs where both numbers have remainder 0
        ans += (freq[0] * (freq[0] - 1L)) / 2;
        ans %= mod;
        // Handle the pairs where both numbers have remainder B/2 if B is even
        if (B % 2 == 0) {
            ans += (freq[B / 2] * (freq[B / 2] - 1L)) / 2;
            ans %= mod;
        }
        // Handle the rest of the pairs
        int l = 1, r = B - 1;
        while (l < r) {
            ans += (freq[l] * (long)freq[r]) % mod;
            ans %= mod;
            l++;
            r--;
        }
        return (int) ans;
    }
    public static void main(String[] args){
        int[] A = {1, 2, 3, 4, 5};
        int B =2;
        int result = solve(A, B);
        System.out.println("ans: "+result);
    }
}
