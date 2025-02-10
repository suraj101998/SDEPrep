package DSA.Advanced.countAndMergeSort;
/*Problem Description
Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).

Problem Constraints
1 <= length of the array <= 105
1 <= A[i] <= 109

Input Format
The only argument given is the integer array A.

Output Format
Return the number of inversions of A modulo (109 + 7).

Example Input
Input 1:
A = [1, 3, 2]

Input 2:
A = [3, 4, 1, 2]

Example Output
Output 1:
1

Output 2:
4

Example Explanation
Explanation 1:
The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]

Explanation 2:
The pair (0, 2) is an inversion as 0 < 2 and A[0] > A[2]
The pair (0, 3) is an inversion as 0 < 3 and A[0] > A[3]
The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
The pair (1, 3) is an inversion as 1 < 3 and A[1] > A[3]
*/

public class inversionCount {
    private static final int MOD = 1000000007;
    public static int solve(int[] A) {
        return mergeSort(A, 0, A.length - 1);
    }

    private static int mergeSort(int[] A, int lo, int hi) {
        if (lo>=hi){
            return 0;
        }
            int mid = lo + (hi - lo) / 2;
            int f1= mergeSort(A, lo, mid);
            int f2= mergeSort(A, mid + 1, hi);
            int f3= merge2SortedSubArrays(A, lo, mid, hi);
            return (f1+f2+f3)% MOD;
    }

    private static int merge2SortedSubArrays(int[] A, int lo, int mid, int hi) {
        int[] temp = new int[hi - lo + 1];
        int i = lo, j = mid + 1, k = 0;
        int inversions = 0;

        while (i <= mid && j <= hi) {
            if (A[i] <= A[j]) {
                temp[k++] = A[i++];
            } else {
                temp[k++] = A[j++];
                inversions = (inversions + (mid - i + 1)) % MOD;
            }
        }
        while (i <= mid) {
            temp[k++] = A[i++];
        }
        while (j <= hi) {
            temp[k++] = A[j++];
        }
        System.arraycopy(temp, 0, A, lo, temp.length);
        return inversions;
    }
    public static void main(String[] args){
        int[] A = {3, 4, 1, 2};
        int result = solve(A);
        System.out.println("ans: "+result);
    }
}
