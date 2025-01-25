package DSA.Advanced.BinarySearch;
/*
 * Problem Description
Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the maximum value of K (sub array length).

Example Input
Input 1:
A = [1, 2, 3, 4, 5]
B = 10
Input 2:
A = [5, 17, 100, 11]
B = 130

Example Output
Output 1:
 2
Output 2:
 3

Example Explanation
Explanation 1:
For K = 5, There are subarrays [1, 2, 3, 4, 5] which has a sum > B
For K = 4, There are subarrays [1, 2, 3, 4], [2, 3, 4, 5] which has a sum > B
For K = 3, There is a subarray [3, 4, 5] which has a sum > B
For K = 2, There were no subarray which has a sum > B.
Constraints are satisfied for maximal value of 2.

Explanation 2:
For K = 4, There are subarrays [5, 17, 100, 11] which has a sum > B
For K = 3, There were no subarray which has a sum > B.
Constraints are satisfied for maximal value of 3.
 */

public class specialInteger {
       //Binary search
       public int solve(int[] A, int B) {
        int n = A.length;
        int l =1, r=n, ans=0;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(isValidK(A,B,mid)){
                ans = mid;
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return ans;
    }
    //sliding window
    private boolean isValidK(int[] A, int B, int K){
        int n = A.length;
        long currentSum = 0;
        for(int i=0; i<K; i++){
            currentSum += A[i];
        }
        if (currentSum > B){
            return false;
        }
        for(int i=K; i<n; i++){
            currentSum += A[i]-A[i-K];
            if (currentSum > B){
                return false;
            }
        }
        return true;
    } 
}
