package ScalerProblems.DSA.BinarySearch;

// Problem Description
// Given an array of integers A, find and return the peak element in it.
// An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.

// NOTE:

// It is guaranteed that the array contains only a single peak element.
// Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.


// Problem Constraints
// 1 <= |A| <= 100000

// 1 <= A[i] <= 109



// Input Format
// The only argument given is the integer array A.



// Output Format
// Return the peak element.



// Example Input
// Input 1:

// A = [1, 2, 3, 4, 5]
// Input 2:

// A = [5, 17, 100, 11]


// Example Output
// Output 1:

//  5
// Output 2:

//  100


// Example Explanation
// Explanation 1:

//  5 is the peak.
// Explanation 2:

//  100 is the peak.

public class peakElement {
    public int solve(int[] A) {
        int N = A.length;
        if(N==1){
            return A[0];
        }
        else if(A[0]>=A[1]){
            return A[0];
        }
        else if(A[N-1]>=A[N-2]){
            return A[N-1];
        }
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
}
