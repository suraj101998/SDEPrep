package DSA.Advanced.InterviewProblems;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem Description
Given an integer A, you have to find the Ath Perfect Number.
A Perfect Number has the following properties:

It comprises only 1 and 2.
The number of digits in a Perfect number is even.
It is a palindrome number.
For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.


Problem Constraints
1 <= A <= 100000

Input Format
The only argument given is an integer A.

Output Format
Return a string that denotes the Ath Perfect Number.

Example Input
Input 1:
 A = 2

Input 2:
 A = 3

Example Output
Output 1:
 22

Output 2:
 1111

Example Explanation
Explanation 1:
First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
Return the 2nd Perfect number.

Explanation 2:
First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
Return the 3rd Perfect number.
 */

public class perfectNumber {
    public static String solve(int A) {
        // Queue to generate half numbers
        Queue<String> queue = new LinkedList<>();
        
        // Add initial half numbers
        queue.add("1");
        queue.add("2");
        
        // Generate perfect numbers
        int count = 0;
        while (!queue.isEmpty()) {
            // Pop the front element
            String half = queue.poll();
            
            // Increment the count
            count++;
            
            // If count matches A, return the perfect number
            if (count == A) {
                // Form the full palindrome
                String fullPerfectNumber = half + new StringBuilder(half).reverse().toString();
                return fullPerfectNumber;
            }
            
            // Add new numbers to the queue
            queue.add(half + "1");
            queue.add(half + "2");
        }
        
        // Should never reach here as A is within valid constraints
        return "";
    }
    public static void main(String[] args){
        int A = 2;
        String result= solve(A);
        System.out.println("ans: "+result);
    }    
}
