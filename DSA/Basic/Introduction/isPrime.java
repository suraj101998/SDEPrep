/*
 Problem Description
Given a number A. Return 1 if A is prime and return 0 if not. 
Note : 
The value of A can cross the range of Integer.

Problem Constraints
1 <= A <= 109

Input Format
The first argument is a single integer A.

Output Format
Return 1 if A is prime else return 0.

Example Input
Input 1:
A = 5
Input 2:
A = 10

Example Output
Output 1:
1
Output 2:
0

Example Explanation
Explanation 1:
5 is a prime number.
Explanation 2:
10 is not a prime number.
 */

package DSA.Basic.Introduction;

/*Approach:
1. Check if A is less than or equal to 1. If true, return 0 (not prime).
2. iterate from 2 to A-1.
3. if A % i == 0 for each i.
4. If the condition is true, return 0 (not prime).
5. After the loop completes, return 1 (prime).
*/

public class isPrime {
    public int solve(int A) {
        if (A<=1){
            return 0;
        }
        for(int i=2; i<A; i++){
            if(A%i==0){
                return 0;
            }
        }
        return 1;
    }
}
