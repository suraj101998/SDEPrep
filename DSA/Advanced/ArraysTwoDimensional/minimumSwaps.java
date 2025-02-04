package DSA.Advanced.ArraysTwoDimensional;
/*Problem Description
Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.
Note: It is possible to swap any two elements, not necessarily consecutive.

Problem Constraints
1 <= length of the array <= 100000
-109 <= A[i], B <= 109

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the minimum number of swaps.

Example Input
Input 1:
 A = [1, 12, 10, 3, 14, 10, 5]
 B = 8

Input 2:
 A = [5, 17, 100, 11]
 B = 20

Example Output
Output 1:
 2

Output 2:
 1

Example Explanation
Explanation 1:
 A = [1, 12, 10, 3, 14, 10, 5]
 After swapping  12 and 3, A => [1, 3, 10, 12, 14, 10, 5].
 After swapping  the first occurence of 10 and 5, A => [1, 3, 5, 12, 14, 10, 10].
 Now, all elements less than or equal to 8 are together.

Explanation 2:
 A = [5, 17, 100, 11]
 After swapping 100 and 11, A => [5, 17, 11, 100].
 Now, all elements less than or equal to 20 are together.
*/

public class minimumSwaps {
    public static int solve(int[] A, int B) {
        int n = A.length;
        // Count the elements less than or equal to B
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] <= B) {
                k++;
            }
        }
        // If no such elements, no swaps
        if (k == 0) {
            return 0;
        }
        // Find the number of unwanted elements in the first window of size k
        int unwanted = 0;
        for (int i = 0; i < k; i++) {
            if (A[i] > B) {
                unwanted++;
            }
        }
        //Use sliding window to find the minimum number of swaps
        int minSwaps = unwanted;
        for (int i = k; i < n; i++) {
            if (A[i] > B) {
                unwanted++;
            }
            // Exiting the old element from the window
            if (A[i - k] > B) {
                unwanted--;
            }
            minSwaps = Math.min(minSwaps, unwanted);
        }
        return minSwaps;
    }
    public static void main(String[] args){
        int[] A = {1, 12, 10, 3, 14, 10, 5};
        int B = 8;
        int result = solve(A, B);
        System.out.println("ans: "+result);
    }
}
