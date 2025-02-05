package DSA.Advanced.BinarySearch;
/*
Problem Description
Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.
Elements which are appearing twice are adjacent to each other.
NOTE: Users are expected to solve this in O(log(N)) time.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9

Input Format
The only argument given is the integer array A.

Output Format
Return the single element that appears only once.

Example Input
Input 1:
A = [1, 1, 7]
Input 2:
A = [2, 3, 3]

Example Output
Output 1: 7
Output 2: 2

Example Explanation
Explanation 1: 7 appears once
Explanation 2: 2 appears once
*/

/*
 * Approach:
1. Edge Cases:
    If the array contains only one element, return that element.
    If the first element is unique (not equal to the second), return the first element.
    If the last element is unique (not equal to the second-last), return the last element.
2. Binary Search for Unique Element:
    Use binary search to find the single element in the middle of the array.
    For each mid index:
    If A[mid] is not equal to A[mid - 1] and A[mid + 1], return A[mid] as the unique element.
    Otherwise, determine which half of the array to search based on index parity:
    If A[mid] == A[mid - 1], check the index mid - 1 (to ensure you are on the start of the pair).
    If the starting index of the pair (fo) is even, search the right half (l = mid + 1).
    If odd, search the left half (r = mid - 1).
3. Return Result: Return the unique element when found, or return -1 if no single element exists.

TC = O(logN)
SC = O(1)
 */
public class singleElementInSortedArray {
    public static int solve(int[] A) {
        int N = A.length;
        //only single element is present in the array
        if(N==1){
            return A[0];
        }
        //single element is present in the first index
        else if(A[0]!=A[1]){
            return A[0];
        }
        //single element is present in the last index
        else if(A[N-1] != A[N-2]){
            return A[N-1];
        }
        //single element is present in betwwn the array
        int l=0, r=N-2;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(A[mid] != A[mid-1] && A[mid] != A[mid+1]){
                return A[mid];
            }
            int fo = mid;
            if(A[mid] == A[mid-1]){
                fo= mid-1;
            }
            if(fo % 2==0){
                l= mid+1;
            }
            else{
                r= mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] A = {1, 1, 7};
        int result = solve(A);
        System.out.println("ans: "+result);
    }
}
