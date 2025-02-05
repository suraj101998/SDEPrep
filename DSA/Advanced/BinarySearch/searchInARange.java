package DSA.Advanced.BinarySearch;
/*
Problem Description
Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.
Return an array of size 2, such that 
          First element = Left most index of B in A
          Second element = Right most index of B in A.
If B is not found in A, return [-1, -1].
Note : Your algorithm's runtime complexity must be in the order of O(log n).

Problem Constraints
1 <= N <= 106
1 <= A[i], B <= 109

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the left most and right most index (0-based) of B in A as a 2-element array. If B is not found in A, return [-1, -1].

Example Input
Input 1:
 A = [5, 7, 7, 8, 8, 10]
 B = 8
Input 2:
 A = [5, 17, 100, 111]
 B = 3

Example Output
Output 1:
 [3, 4]
Output 2:
 [-1, -1]

Example Explanation
Explanation 1:
 The first occurrence of 8 in A is at index 3.
 The last occurrence of 8 in A is at index 4.
 ans = [3, 4]
Explanation 2:
 There is no occurrence of 3 in the array.
*/

import java.util.Arrays;

/*
 * Approach:
1. Initialize Result Array:
    Create an array ans of size 2 to store the first and last occurrences of the target B.
2. Find First Occurrence:
    Use a binary search approach:
    Start with pointers l = 0 and r = N-1.
    If the middle element A[mid] == B, record the index and move r = mid - 1 to search for earlier occurrences.
    If A[mid] < B, move l = mid + 1.
    If A[mid] > B, move r = mid - 1.
3. Find Last Occurrence:
    Use a binary search approach similar to the first occurrence:
    If the middle element A[mid] == B, record the index and move l = mid + 1 to search for later occurrences.
    If A[mid] < B, move l = mid + 1.
    If A[mid] > B, move r = mid - 1.
4. Return Result: Store the results from both searches into ans and return it.

TC= O(logN)
SC= O(1)
 */
public class searchInARange {
    public static int[] searchRange(final int[] A, int B) {
        int[] ans = new int[2];
        ans[0] = firstOccurance(A, B);
        ans[1] = lastOccurance(A, B);
        return ans;
    }
    private static int firstOccurance(int[] A, int B){
        int N = A.length;
        int l =0, r = N-1;
        int firstIndex = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(A[mid]==B){
                firstIndex = mid;
                r=mid-1;
            }
            else if(A[mid]<B){
                l = mid +1;
            }
            else{
                r =mid-1;
            }
        }
        return firstIndex;
    }
    private static int lastOccurance(int[] A, int B){
        int N = A.length;
        int l =0, r = N-1;
        int lastIndex = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(A[mid]==B){
                lastIndex = mid;
                l= mid+1;
            }
            else if(A[mid]<B){
                l = mid +1;
            }
            else{
                r =mid-1;
            }
        }
        return lastIndex;
    }
    public static void main(String[] args){
        int[] A = {5, 7, 7, 8, 8, 10};
        int B = 8;
        int[] result= searchRange(A, B);
        System.out.println("ans: "+Arrays.toString(result)); 
    }
}
