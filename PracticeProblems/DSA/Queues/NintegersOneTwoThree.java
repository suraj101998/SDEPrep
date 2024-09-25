package PracticeProblems.DSA.Queues;
/*
 * Problem Description
Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.

NOTE: All the A integers will fit in 32-bit integers.



Problem Constraints
1 <= A <= 29500



Input Format
The only argument given is integer A.



Output Format
Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.



Example Input
Input 1:

 A = 3
Input 2:

 A = 7


Example Output
Output 1:

 [1, 2, 3]
Output 2:

 [1, 2, 3, 11, 12, 13, 21]


Example Explanation
Explanation 1:

 Output denotes the first 3 integers that contains only digits 1, 2 and 3.
Explanation 2:

 Output denotes the first 7 integers that contains only digits 1, 2 and 3.
 */
import java.util.Queue;
import java.util.LinkedList;
public class NintegersOneTwoThree {
    public int[] solve(int A) {
        // Result array to store the first A integers
        int[] result = new int[A];
        
        // Queue for BFS approach
        Queue<String> queue = new LinkedList<>();
        
        // Enqueue the starting digits '1', '2', and '3'
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        
        int index = 0;
        
        // Generate the first A numbers
        while (index < A) {
            // Dequeue the front of the queue
            String current = queue.poll();
            
            // Convert to an integer and store in the result array
            result[index] = Integer.parseInt(current);
            index++;
            
            // Add the next possible numbers to the queue by appending 1, 2, and 3
            queue.offer(current + "1");
            queue.offer(current + "2");
            queue.offer(current + "3");
        }
        
        return result;
    }
}
