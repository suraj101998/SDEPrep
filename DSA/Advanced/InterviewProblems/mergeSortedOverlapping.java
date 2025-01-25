package DSA.Advanced.InterviewProblems;
// Problem Description
// You are given a collection of intervals A in a 2-D array format, where each interval is represented by a pair of integers `[start, end]`. The intervals are sorted based on their start values.

import java.util.ArrayList;
import java.util.List;

// Your task is to merge all overlapping intervals and return the resulting set of non-overlapping intervals.


// Problem Constraints
// 1 <= len(A) <= 100000.
// 1 <= A[i][0] <= A[i][1] <= 100000

// A is sorted based on the start value (A[i][0])



// Input Format
// First argument is a list of intervals in 2-Dimentional Array.



// Output Format
// Return the sorted list of intervals after merging all the overlapping intervals.



// Example Input
// Input 1:

// [ [1, 3], [2, 6], [8, 10], [15, 18] ]
// Input 2:

// [ [2, 10], [4, 9], [6, 7] ]


// Example Output
// Output 1:

// [ [1, 6], [8, 10], [15, 18] ]
// Output 2:

// [ [2, 10] ]


// Example Explanation
// Explanation 1:

// Merge intervals [1,3] and [2,6] -> [1,6].
// so, the required answer after merging is [1,6],[8,10],[15,18].
// No more overlapping intervals present.
// Explanation 2:

// Merge intervals [2, 10], [4, 9], [6, 7] as [2,10].
// Since [4, 9] and [6, 7] is overlapping inside the interval [2, 10].

// so, the required answer after merging is [2, 10].

public class mergeSortedOverlapping {
        public int[][] solve(int[][] A) {
        int N= A.length;
        List<int[]> ans = new ArrayList<>();
        int l = A[0][0];
        int r = A[0][1];
        for(int i=1; i<N; i++){
            if(A[i][0] >r){
                 // No overlap, add the previous interval to the result
                ans.add(new int[]{l,r});
                // Start a new interval
                l = A[i][0];
                r = A[i][1];
            }else{
                // Overlapping intervals, update the end
                r = Math.max(r, A[i][1]);
            }
        }
        // Add the last interval
        ans.add(new int[]{l, r});
        // Convert list to array
        return ans.toArray(new int[ans.size()][]);
    }
}
