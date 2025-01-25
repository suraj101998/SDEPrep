package DSA.Advanced.BinarySearch;
/*
 *Given a sorted array of integers A of size N and an integer B, 
where array A is rotated at some pivot unknown beforehand.
For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
Your task is to search for the target value B in the array. 
If found, return its index; otherwise, return -1.
You can assume that no duplicates exist in the array.
NOTE: You are expected to solve this problem with a time complexity of O(log(N)).

Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 109
All elements in A are Distinct.

Input Format
The First argument given is the integer array A.
The Second argument given is the integer B.

Output Format
Return index of B in array A, otherwise return -1

Example Input
Input 1:
A = [4, 5, 6, 7, 0, 1, 2, 3]
B = 4 

Input 2:
A : [ 9, 10, 3, 5, 6, 8 ]
B : 5

Example Output
Output 1:
 0 

Output 2:
 3

Example Explanation
Explanation 1:
Target 4 is found at index 0 in A. 

Explanation 2:
Target 5 is found at index 3 in A.
 */


/*
 * 
Approach:
1. Binary Search:
    Initialize pointers l (start of the array) and r (end of the array).
    Iterate while l <= r:
        Calculate mid = (l + r) / 2.
        If A[mid] == B, return mid (target found).
2. Check Left or Right Subarray:
    If the left half (A[l] to A[mid]) is sorted:
    If the target B lies within this range (B >= A[l] and B < A[mid]), move to the left half (r = mid - 1).
    Otherwise, move to the right half (l = mid + 1).
    If the right half (A[mid] to A[r]) is sorted:
    If the target B lies within this range (B > A[mid] and B <= A[r]), move to the right half (l = mid + 1).
    Otherwise, move to the left half (r = mid - 1).
3. Return -1:
    If the loop ends without finding the target, return -1.

TC= O(logN)
SC= O(1)
 */
public class rotatedSortedArray {
    public int search(final int[] A, int B) {
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] == B) {
                return mid;
            }
            if (A[l] <= A[mid]) {
                if (B >= A[l] && B < A[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (B > A[mid] && B <= A[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
