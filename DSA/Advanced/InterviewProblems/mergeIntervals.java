package DSA.Advanced.InterviewProblems;
// Problem Description
// You have a set of non-overlapping intervals. You are given a new interval [start, end], insert this new interval into the set of intervals (merge if necessary).

import java.util.ArrayList;
import java.util.List;

// You may assume that the intervals were initially sorted according to their start times.



// Problem Constraints
// 0 <= |intervals| <= 105



// Input Format
// First argument is the vector of intervals

// second argument is the new interval to be merged



// Output Format
// Return the vector of intervals after merging



// Example Input
// Input 1:

// Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
// Input 2:

// Given intervals [1, 3], [6, 9] insert and merge [2, 6] .


// Example Output
// Output 1:

//  [ [1, 5], [6, 9] ]
// Output 2:

//  [ [1, 9] ]


// Example Explanation
// Explanation 1:

// (2,5) does not completely merge the given intervals
// Explanation 2:

// (2,6) completely merges the given intervals

public class mergeIntervals {
        public int[][] insert(int[][] A, int[] B) {
        int N= A.length;
        List<int[]> ans = new ArrayList<>();
        int i =0;
        while(i<N && A[i][1]<B[0]){
            ans.add(A[i]);
            i++;
        }
        while(i<N && A[i][0]<=B[1]){
            B[0]= Math.min(B[0], A[i][0]);
            B[1]= Math.max(B[1], A[i][1]);
            i++;
        }
        ans.add(B);
        while(i<N){
            ans.add(A[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
