package DSA.Advanced.ArraysOneDimensional;
/*
 * Problem Description
You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN. In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR. By flipping, we mean changing character 0 to 1 and vice-versa.
Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.
If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.
NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.

Problem Constraints
1 <= size of string <= 100000

Input Format
First and only argument is a string A.

Output Format
Return an array of integers denoting the answer.

Example Input
Input 1:
A = "010"

Input 2:
A = "111"

Example Output
Output 1:
[1, 1]

Output 2:
[]


Example Explanation
Explanation 1:
A = "010"
Pair of [L, R] | Final string
_______________|_____________
[1 1]          | "110"
[1 2]          | "100"
[1 3]          | "101"
[2 2]          | "000"
[2 3]          | "001"
We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].

Explanation 2:
No operation can give us more than three 1s in final string. So, we return empty array [].
 */

import java.util.Arrays;

public class Flip {
    public static int[] flip(String A) {
        int n = A.length();
        int maxDiff = 0;
        int currentDiff = 0;
        int startIndex = 0;
        int endIndex = -1;
        int tempStartIndex = 0;
        for (int i = 0; i < n; i++) {
            // If the character is '0', we consider it as +1 to maximize 1s
            int value;
            if (A.charAt(i) == '0') {
                value = 1;
            } else {
                // If the character is '1', we consider it as -1 since flipping it would reduce the number of 1s
                value = -1;
            }
            currentDiff += value;
            if (currentDiff > maxDiff) {
                maxDiff = currentDiff;
                startIndex = tempStartIndex;
                endIndex = i;
            }
            if (currentDiff < 0) {
                currentDiff = 0;
                tempStartIndex = i + 1;
            }
        }
        // If no valid flip is found, return an empty array
        if (endIndex == -1) {
            return new int[]{};
        }
        return new int[]{startIndex + 1, endIndex + 1};
    }
    public static void main(String[] args){
        String A = "010";
        int[] result = flip(A);
        System.out.println("ans: "+Arrays.toString(result));
    }
}
