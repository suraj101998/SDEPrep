package DSA.Advanced.Hashing;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * Problem Description
Misha likes finding all Subarrays of an Array. Now she gives you an array A of N elements and told you to find the number of subarrays of A, that have unique elements.
Since the number of subarrays could be large, return value % 109 +7.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 106


Input Format
The only argument given is an Array A, having N integers.

Output Format
Return the number of subarrays of A, that have unique elements.


Example Input
Input 1:
 A = [1, 1, 3]

Input 2:
 A = [2, 1, 2]

Example Output
Output 1:
 4

Output 1:
 5

Example Explanation
Explanation 1:
 Subarrays of A that have unique elements only:
 [1], [1], [1, 3], [3]

Explanation 2:
 Subarrays of A that have unique elements only:
 [2], [1], [2, 1], [1, 2], [2]
 */
public class countSubarrays {
    public static int solve(int[] A) {
        int n =A.length;
        long count = 0;
        int l=0;
        HashSet<Integer> set = new HashSet<>();
        for(int r=0; r<n; r++){
          while (set.contains(A[r])){
            set.remove(A[r]);
            l++;
          }
          set.add(A[r]);
          count += (r-l+1);
        }
        return (int) (count % (1_000_000_007));
    }
    public static void main(String[] args) {
        int[] A= {1, 1, 3};
        int result = solve(A);
        System.out.println("ans: "+result);
    }
}
