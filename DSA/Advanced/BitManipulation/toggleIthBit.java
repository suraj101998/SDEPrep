package DSA.Advanced.BitManipulation;
/*Problem Description
You are given two integers A and B.
If B-th bit in A is set, make it unset
If B-th bit in A is unset, make it set
Return the updated A value

Problem Constraints
1 <= A <= 109
0 <= B <= 30

Input Format
First argument A is an integer.
Second argument B is an integer.

Output Format
Return an integer.

Example Input
Input 1:
A = 4
B = 1

Input 2:
A = 5
B = 2

Example Output
Output 1:
6

Output 2:
1

Example Explanation
For Input 1:
Given N = 4 which is 100 in binary. The 1-st bit is unset
so we make it set

For Input 2: 
Given N = 5 which is 101 in binary. The 2-nd bit is set
so we make it unset
*/

public class toggleIthBit {
    public static int solve(int A, int B) {
        A=(A^(1<<B)); //actually we want to toggle the Bth index so use XOR
        return A;
    }
    public static void main(String[] args){
        int A = 4;
        int B = 1;
        int result = solve(A, B);
        System.out.println("ans: "+result);
    }
}
