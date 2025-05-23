package DSA.Advanced.ArraysOneDimensional;
/*
 * Problem Description
Imagine a histogram where the bars' heights are given by the array A. Each bar is of uniform width, which is 1 unit. When it rains, water will accumulate in the valleys between the bars.
Your task is to calculate the total amount of water that can be trapped in these valleys.

Example:
The Array A = [5, 4, 1, 4, 3, 2, 7] is visualized as below. The total amount of rain water trapped in A is 11.

Problem Constraints
1 <= |A| <= 105
0 <= A[i] <= 105

Input Format
First and only argument is the Integer Array, A.

Output Format
Return an Integer, denoting the total amount of water that can be trapped in these valleys

Example Input
Input 1:
 A = [0, 1, 0, 2]
Input 2:
A = [1, 2]

Example Output
Output 1:
1
Output 2:
0

Example Explanation
Explanation 1:
1 unit is trapped on top of the 3rd element.

Explanation 2:
No water is trapped.
 */

public class rainWaterTrapped {
    public static int trap(final int[] A) {
        int N = A.length;
        if(N<3){
            return 0;
        }
        int[] lmax = new int[N];
        int[] rmax = new int[N];
        lmax[0]=A[0];
        for(int i=1; i<N; i++){
            lmax[i]= Math.max(lmax[i-1], A[i]);
        }
        rmax[N-1] = A[N-1];
        for(int i=N-2; i>=0; i--){
            rmax[i] = Math.max(rmax[i+1], A[i]);
        }
        int ans = 0;
        for (int i=0; i<N; i++){
            ans += Math.min(lmax[i], rmax[i]) - A[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A= {0, 1, 0, 2};
        int result = trap(A);
        System.out.println("ans: "+result);
      }
}
