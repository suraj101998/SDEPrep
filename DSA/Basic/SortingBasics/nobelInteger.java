package DSA.Basic.SortingBasics;
// Problem Description
// Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.

import java.util.ArrayList;
import java.util.Collections;

// Problem Constraints
// 1 <= |A| <= 2*105
// -108 <= A[i] <= 108


// Input Format
// First and only argument is an integer array A.



// Output Format
// Return 1 if any such integer p is present else, return -1.



// Example Input
// Input 1:

//  A = [3, 2, 1, 3]
// Input 2:

//  A = [1, 1, 3, 3]


// Example Output
// Output 1:

//  1
// Output 2:

//  -1


// Example Explanation
// Explanation 1:

//  For integer 2, there are 2 greater elements in the array..
// Explanation 2:

//  There exist no integer satisfying the required conditions.

public class nobelInteger {
        public int solve(ArrayList<Integer> A) {
        // Sort the array in ascending order
        Collections.sort(A); //1,2,3,3
        int N = A.size();  //4
        for (int i = 0; i < N; i++) {
            if (A.get(i) == N - 1 - i) {
// i = 0, A.get(0) = 1, 4 - 0 - 1 = 3, 1 == 3 is false.
//i =1, A.get(1) =2, 4-1-1 =2 , 2=2 is true.
                    //A.get(i)==1 forwarded

                if (i == N - 1 || A.get(i) != A.get(i + 1)) {
                    // since 2 A.get(i) not equals 3 A.get(i+1) or i is equals 3 index
                    // we don't want to count max value at position N-1, next element should not= ith element
                    return 1;
                }
            }
        }        
        return -1;
    }
}
