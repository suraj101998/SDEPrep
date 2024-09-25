package PracticeProblems.DSA.InterviewProblems;
// Problem Description
// Scaler Academy, a leading ed-tech platform known for its comprehensive learning programs, is planning to conduct maintenance on its website to enhance user experience and introduce new features.To ensure the maintenance work does not disrupt the scheduled meets of various batches, Scaler Academy aims to schedule this maintenance during the period of no user activity.
// Given sorted intervals A on the active hours of multiple learners on the platform and the scheduled meeting by [start, end], where time is denoted by numbers.
// Your task is to analyze this data and identify the longest continuous period when no meetings are scheduled before the end time B.
// This identified time slot is crucial as it represents the best opportunity to perform website maintenance with the least disruption to the scheduled meets of various batches.
// Refer the Example Explanation for better understanding!

// Problem Constraints
// 1 <= A.length <= 105
// A[i].length == 2
// 0 <= A[i][0] < A[i][1] <= 105
// A is sorted in non-decreasing order

// Input Format
// First Argument is a 2-D Integer Array A, of size Nx2.
// Second Argument is an Integer B.

// Output Format
// Return an Integer, denoting the longest continuous period.

// Example Input
// Input 1:
// A = [ [1, 3], [5, 8], [6, 7], [7, 9] ]
// B = 12
// Input 2:
// A = [ [0, 5], [2, 7] ]
// B = 7

// Example Output
// Output 1:
// 3
// Output 2:
// 0

// Example Explanation
// Explanation 1:
// Explanation
// The longest continuous period when no meetings are scheduled is [9, 12].
// Thus the answer is 3.
// Explanation 2:
// Explanation
// There is No free hours.  Thus the answer is 0.

public class websiteMaintainance {
    public int findLongestTime(int[][] A, int B) {
        if (A.length == 0) {
            return B;
        }
        int max_gap = 0;
        int last_end_time = 0;
        for (int i = 0; i < A.length; i++) {
            int start = A[i][0];
            int end = A[i][1];
            if (start > last_end_time) {
                max_gap = Math.max(max_gap, start - last_end_time);
            }
            last_end_time = Math.max(last_end_time, end);
        }
        if (last_end_time < B) {
            max_gap = Math.max(max_gap, B - last_end_time);
        }
        return max_gap;
    }
}
