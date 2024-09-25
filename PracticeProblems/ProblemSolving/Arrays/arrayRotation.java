/*
Problem Description
Given an integer array A of size N and an integer B, you have to return the same array after rotating it B times towards the right.
Problem Constraints
1 <= N <= 105
1 <= A[i] <=109
1 <= B <= 109

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the array A after rotating it B times to the right

Example Input
Input 1:
A = [1, 2, 3, 4]
B = 2
Input 2:
A = [2, 5, 6]
B = 1

Example Output
Output 1:
[3, 4, 1, 2]
Output 2:
[6, 2, 5]

Example Explanation
Explanation 1:
Rotate towards the right 2 times - [1, 2, 3, 4] => [4, 1, 2, 3] => [3, 4, 1, 2]
Explanation 2:
Rotate towards the right 1 time - [2, 5, 6] => [6, 2, 5]
 */
package PracticeProblems.ProblemSolving.Arrays;
import java.util.ArrayList;

/*Approach:
1. Compute rotations as B % N to get the effective number of rotations.
2. If rotations is 0, return A (no rotation needed).
3. Initialize a new ArrayList rotated to store the rotated elements.
4. Add elements from index N - rotations to N - 1 of A to rotated. Add elements from index 0 to N - rotations - 1 of A to rotated.
5. Copy elements from rotated back to A. return the modified A.
 */
public class arrayRotation {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        int rotations = B % N; // Effective number of rotations
        if (rotations == 0) {
            return A; // No rotation needed
        }
        // Create a new array to store rotated elements
        ArrayList<Integer> rotated = new ArrayList<>();  
        // Add elements from index N-rotations to N-1
        for (int i = N - rotations; i < N; i++) {
            rotated.add(A.get(i));
        }
        // Add elements from index 0 to N-rotations-1
        for (int i = 0; i < N - rotations; i++) {
            rotated.add(A.get(i));
        }
        // Copy rotated elements back to array A
        for (int i = 0; i < N; i++) {
            A.set(i, rotated.get(i));
        }
        return A;
    }
}
