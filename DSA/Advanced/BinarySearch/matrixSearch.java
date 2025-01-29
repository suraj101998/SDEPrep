package DSA.Advanced.BinarySearch;

/*
This matrix A has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.
NOTE: Rows are numbered from top to bottom, and columns are from left to right.

Problem Constraints
1 <= N, M <= 1000
1 <= A[i][j], B <= 106

Input Format
The first argument given is the integer matrix A.
The second argument given is the integer B.

Output Format
Return 1 if B is present in A else, return 0.

Example Input
Input 1:
A = [ 
      [1,   3,  5,  7]
      [10, 11, 16, 20]
      [23, 30, 34, 50]  
    ]
B = 3
Input 2:
A = [   
      [5, 17, 100, 111]
      [119, 120, 127, 131]    
    ]
B = 3

Example Output
Output 1:
1
Output 2:
0

Example Explanation
Explanation 1:
 3 is present in the matrix at A[0][1] position so return 1.
Explanation 2:
 3 is not present in the matrix so return 0.
*/


/*
 * Approach:
1. Treat the matrix as a 1D array of size N * M.
2. Use two pointers, l and r, to perform binary search over this virtual 1D array.
3. Compute the middle index mid, then map it to the 2D indices using:
        row = mid / M
        col = mid % M.
4. Compare the element at A[row][col] with B:
        If equal, return 1.
        If A[row][col] < B, update l = mid + 1.
        Otherwise, update r = mid - 1.
5. If the loop ends without finding the element, return 0.


TC = O(log(N * M))
SC = O(1)
 */
public class matrixSearch {
    public static int searchMatrix(int[][] A, int B) {
        int N = A.length;
        int M = A[0].length;
        int l = 0;
        int r = N * M - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int row = mid / M;
            int col = mid % M;
            if (A[row][col] == B) {
                return 1;
            } else if (A[row][col] < B) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return 0;
    }
    public static void main(String[] args){
        int[][] A = {
            {1,   3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        int B= 3;
        int result = searchMatrix(A,B);
        System.out.println("Seach result: "+result);
    }
}
