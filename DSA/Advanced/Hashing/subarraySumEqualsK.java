package DSA.Advanced.Hashing;
import java.util.HashMap;
/*
 * Problem Description
Given an array of integers A and an integer B.
Find the total number of subarrays having sum equals to B.

Problem Constraints
 1 <= length of the array <= 50000
-1000 <= A[i] <= 1000

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the total number of subarrays having sum equals to B.

Example Input
Input 1:
A = [1, 0, 1]
B = 1

Input 2:
A = [0, 0, 0]
B = 0

Example Output
Output 1:
4
Output 2:
6

Example Explanation
Explanation 1:
[1], [1, 0], [0, 1] and [1] are four subarrays having sum 1.

Explanation 2:
All the possible subarrays having sum 0.
 */

public class subarraySumEqualsK {
     public static int solve(int[] A, int B) {
        int N=A.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int tempSum = 0;
        for(int i=0; i<N; i++){
            tempSum += A[i];
            if (tempSum == B) {
                ans++;
            }
            if (map.containsKey(tempSum - B)) {
                ans += map.get(tempSum - B);
            }
            map.put(tempSum, map.getOrDefault(tempSum, 0)+1);
        }
/*            if (!map.containsKey(tempSum)) {
                map.put(tempSum, 1);
            } else {
                int ov = map.get(tempSum);
                map.put(tempSum, ov + 1);
            }
        }
*/
        return ans;
    }
    public static void main(String[] args) {
        int[] A= {1, 0, 1};
        int B= 1;
        int result = solve(A,B);
        System.out.println("ans: "+result);
    }
}
