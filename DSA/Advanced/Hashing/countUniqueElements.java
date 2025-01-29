package DSA.Advanced.Hashing;
import java.util.HashMap;
/*
 * Problem Description
You are given an array A of N integers. Return the count of elements with frequncy 1 in the given array.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109


Input Format
First argument A is an array of integers.

Output Format
Return an integer.

Example Input
Input 1:
A = [3, 4, 3, 6, 6]

Input 2:
A = [3, 3, 3, 9, 0, 1, 0]


Example Output
Output 1:
1

Output 2:
2


Example Explanation
Explanation 1:
Only the element 4 has a frequency 1.
Explanation 2:
The elements 9 and 1 has a frequncy 1.
 */

public class countUniqueElements {
    public static int solve(int[] A) {
        int N= A.length;
        int count =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<N; i++){
            if(!map.containsKey(A[i])){
                map.put(A[i],1);
            }
            else{
                int ov = map.get(A[i]);
                map.put(A[i], ov+1);
            }
        }
        for(int i=0; i<N; i++){
            if(map.get(A[i])==1){
                count ++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] A= {3, 3, 4, 6, 6};
        int result = solve(A);
        System.out.println("ans: "+result);
    }
}
