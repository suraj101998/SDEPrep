package DSA.Advanced.countAndMergeSort;
// Problem Description
// Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.

// Note: A linear time complexity is expected and you should avoid use of any library function.


// Problem Constraints
// -2×109 <= A[i], B[i] <= 2×109
// 1 <= |A|, |B| <= 5×104


// Input Format
// First Argument is a 1-D array representing  A.
// Second Argument is also a 1-D array representing B.


// Output Format
// Return a 1-D vector which you got after merging A and B.


// Example Input
// Input 1:

// A = [4, 7, 9]
// B = [2, 11, 19]
// Input 2:

// A = [1]
// B = [2]


// Example Output
// Output 1:

// [2, 4, 7, 9, 11, 19]
// Output 2:

// [1, 2]


// Example Explanation
// Explanation 1:

// Merging A and B produces the output as described above.
// Explanation 2:

//  Merging A and B produces the output as described above.

public class mergeTwoSortedArray {
    public int[] solve(final int[] A, final int[] B) {
        int N = A.length;
        int M= B.length;
        int ans[] =new int[N+M];
        int i =0, j=0, k=0;
        while(i<N && j<M){
            if(A[i]<=B[j]){
                ans[k] = A[i];
                i++;
            }
            else{
                ans[k]= B[j];
                j++;
            }
            k++;
        }
        while(i<N){
            ans[k] = A[i];
            i++;
            k++;
        }
        while(j<M){
            ans[k] = B[j];
            j++;
            k++;
        }
        return ans;
    }
}
