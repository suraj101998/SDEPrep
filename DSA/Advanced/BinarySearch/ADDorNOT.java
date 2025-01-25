package DSA.Advanced.BinarySearch;

/*
In a single operation, any one element of the array can be increased by 1. 
You are allowed to do at most B such operations.
Find the number with the maximum number of occurrences and return an array C of size 2, 
where C[0] is the number of occurrences, and C[1] is the number with maximum occurrence.
If there are several such numbers, your task is to find the minimum one.

Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109
0 <= B <= 109

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return an array C of size 2, 
where C[0] is number of occurence and C[1] is the number with maximum occurence.

Example Input
Input 1:
 A = [3, 1, 2, 2, 1]
 B = 3

Input 2:
 A = [5, 5, 5]
 B = 3

Example Output
Output 1:
 [4, 2]

Output 2:
 [3, 5]

Example Explanation
Explanation 1:
 Apply operations on A[2] and A[4]
 A = [3, 2, 2, 2, 2]
 Maximum occurence =  4
 Minimum value of element with maximum occurence = 2

Explanation 2:
 A = [5, 5, 5]
 Maximum occurence =  3
 Minimum value of element with maximum occurence = 5
*/

/*
 * Approach:
1. Sort the array A in ascending order to group similar elements together.
2. Initialize two pointers: start at the beginning of the array and end to iterate through the array.
3. Use a variable sum to track the total cost of making all elements in the current subarray
 equal to A[end].
        For each element A[end], compute the cost of making all elements from start to end equal to A[end].
        Add the cost difference ((A[end] - A[end - 1]) * (end - start)) to sum.
4. If sum exceeds B, increment the start pointer and subtract the corresponding cost from 
sum to shrink the window.
5. Track the maximum occurrences (maxOccurrences) of an element within the allowed cost B:
        If the current window size (end - start + 1) is greater than maxOccurrences, 
        update maxOccurrences and set element = A[end].
        If the window size is equal to maxOccurrences, update element to the smaller of the current element
        and A[end].
6. Return an array with the maximum occurrences and the smallest element achieving that.

TC = O(NlogN)
Sorting the array takes O(N log N).
The sliding window loop runs in O(N).
Total time complexity: O(N log N).

SC = O(1)
 */

import java.util.Arrays;
public class ADDorNOT {
    public static int[] solve(int[] A, int B) {
            Arrays.sort(A);
            int n = A.length;
            int maxOccurrences = 1;
            int element = A[0];
            int start = 0;
            long sum = 0;
            for (int end = 0; end < n; end++) {
                if (end > 0) {
                    sum += (long)(A[end] - A[end - 1]) * (end - start);
                }
                while (sum > B) {
                    sum -= (A[end] - A[start]);
                    start++;
                }
                int currentOccurrences = end - start + 1;
                if (currentOccurrences > maxOccurrences) {
                    maxOccurrences = currentOccurrences;
                    element = A[end];
                } else if (currentOccurrences == maxOccurrences) {
                    element = Math.min(element, A[end]);
                }
            }
            return new int[]{maxOccurrences, element};
    }
    public static void main(String[] args){
            int[] A= {3, 1, 2, 2, 1};
            int B = 3;
            int result[] = solve(A,B);
        System.out.println("ans: "+Arrays.toString(result));
    }
}
