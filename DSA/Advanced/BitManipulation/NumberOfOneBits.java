package DSA.Advanced.BitManipulation;
/*Problem Description
Write a function that takes an integer and returns the number of 1 bits present in its binary representation.

Problem Constraints
1 <= A <= 109

Input Format
First and only argument contains integer A

Output Format
Return an integer

Example Input
Input 1:
11

Input 2:
6

Example Output
Output 1:
3

Output 2:
2

Example Explanation
Explaination 1:
11 is represented as 1011 in binary.

Explaination 2:
6 is represented as 110 in binary.
*/
public class NumberOfOneBits {
    public static int numSetBits(int A) {
        int count=0;
        for(int i=0;i<32;i++){
            if((A&(1<<i))!=0){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        int A = 11;
        int result = numSetBits(A);
        System.out.println("ans: "+result);
    }
}
