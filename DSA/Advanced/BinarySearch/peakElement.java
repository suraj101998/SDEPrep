package DSA.Advanced.BinarySearch;
/*Problem Description
Given an array of integers A, find and return the peak element in it.
An array element is considered a peak if it is not smaller than its neighbors. 
For corner elements, we need to consider only one neighbor.

NOTE:
It is guaranteed that the array contains only a single peak element.
Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 109

Input Format
The only argument given is the integer array A.

Output Format
Return the peak element.

Example Input
Input 1:
A = [1, 2, 3, 4, 5]
Input 2:
A = [5, 17, 100, 11]

Example Output
Output 1: 5
Output 2: 100

Example Explanation
Explanation 1: 5 is the peak.
Explanation 2: 100 is the peak.
*/

/*
 * Approach:
1. Base Cases:
    If the array has only one element, return that element.
    If the first element is greater than or equal to the second, return the first element (peak in strictly decreasing array).
    If the last element is greater than or equal to the second last, return the last element (peak in strictly increasing array).
2. Binary Search:
    Apply binary search in the range [1, N-2] (ignoring already checked boundaries).
    At each mid-point:
    If A[mid] is greater than or equal to its neighbors (A[mid-1] and A[mid+1]), return A[mid] (peak found).
    If A[mid] < A[mid+1], move to the right subarray (l = mid + 1).
    Otherwise, move to the left subarray (r = mid - 1).
3. Return Value: If no peak is found during the search, return -1.

TC = O(logN)
SC = O(1)
*/
public class peakElement {
    public static int solve(int[] A) {
        int N = A.length;
        if(N==1){
            return A[0];
        }
        //strictly decreasing array
        else if(A[0]>=A[1]){
            return A[0];
        }
        //strictly increasing array
        else if(A[N-1]>=A[N-2]){
            return A[N-1];
        }
        // increasing+decreasing array
        int l=1, r=N-2;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(A[mid] >= A[mid-1] && A[mid] >= A[mid+1]){
                return A[mid];
            }
            else if(A[mid]<A[mid+1]){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] A = {1,2,3,1};
        int result = solve(A);
        System.out.println("ans: "+result);
    }
}
