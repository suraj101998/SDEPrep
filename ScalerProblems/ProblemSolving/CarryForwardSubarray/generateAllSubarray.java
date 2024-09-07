package ScalerProblems.ProblemSolving.CarryForwardSubarray;
// Problem Description
// You are given an array A of N integers.
// Return a 2D array consisting of all the subarrays of the array

import java.util.ArrayList;

// Note : The order of the subarrays in the resulting 2D array does not matter.


// Problem Constraints
// 1 <= N <= 100
// 1 <= A[i] <= 105


// Input Format
// First argument A is an array of integers.


// Output Format
// Return a 2D array of integers in any order.


// Example Input
// Input 1:
// A = [1, 2, 3]
// Input 2:
// A = [5, 2, 1, 4]


// Example Output
// Output 1:
// [[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]
// Output 2:
// [[1 ], [1 4 ], [2 ], [2 1 ], [2 1 4 ], [4 ], [5 ], [5 2 ], [5 2 1 ], [5 2 1 4 ] ]


// Example Explanation
// For Input 1:
// All the subarrays of the array are returned. There are a total of 6 subarrays.
// For Input 2:
// All the subarrays of the array are returned. There are a total of 10 subarrays.

public class generateAllSubarray {
        public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A) {
        int N=A.size();
        ArrayList<ArrayList<Integer>> twoDimList = new ArrayList<>();
        // ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=i;j<N;j++){
                ArrayList<Integer> list =PrintSubArray(A,i,j);
                twoDimList.add(list);
            }
        }
        return twoDimList;
 
    }
    public static ArrayList<Integer> PrintSubArray(ArrayList<Integer> arr,int si,int ei){
      ArrayList<Integer> oneDimList = new ArrayList<>();
      ArrayList<ArrayList<Integer>> twoDimList = new ArrayList<>();
        for (int k=si;k<=ei;k++){
                oneDimList.add(arr.get(k));
        }
        return oneDimList;
    }
}
