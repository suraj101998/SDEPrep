package DSA.Basic.Prefix_Sum;
// Problem Description
// Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.

import java.util.ArrayList;
import java.util.Arrays;

// Problem Constraints
// 1 <= N <= 105
// -105 <= A[i] <= 105
// Sum of all elements of A <= 109


// Input Format
// First argument contains an array A of integers of size N


// Output Format
// Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.



// Example Input
// Input 1:
// A = [2, 1, 6, 4]
// Input 2:

// A = [1, 1, 1]


// Example Output
// Output 1:
// 1
// Output 2:

// 3


// Example Explanation
// Explanation 1:
// Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1]. 
// Therefore, the required output is 1. 
// Explanation 2:

// Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
// Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
// Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
// Therefore, the required output is 3.

public class specialIndex {
     public int solve(ArrayList<Integer> A) {
         int N=A.size();
        ArrayList<Integer> pfEven = new ArrayList<>(Arrays.asList(new Integer[N]));
        ArrayList<Integer> pfOdd = new ArrayList<>(Arrays.asList(new Integer[N]));
    
        // Initialize the first elements
        pfEven.set(0, A.get(0));
        pfOdd.set(0, 0);
        for (int i=1;i<N;i++){
            if (i%2==0){
                pfEven.set(i,pfEven.get(i-1)+A.get(i));
                pfOdd.set(i,pfOdd.get(i-1));
            }
            else{
                pfEven.set(i,pfEven.get(i-1));
                pfOdd.set(i,pfOdd.get(i-1)+A.get(i));
            }
        }
 
        int count=0;
        if(pfOdd.get(N-1)-pfOdd.get(0)==pfEven.get(N-1)-pfEven.get(0)){
            count++;
        }
        for(int i=1;i<N;i++){
            int se = pfEven.get(i-1)+ pfOdd.get(N-1)-pfOdd.get(i);
            int so=pfOdd.get(i-1)+pfEven.get(N-1)-pfEven.get(i);
            if (se==so){
                count++;
            }
        }
        return count;
    }
}
