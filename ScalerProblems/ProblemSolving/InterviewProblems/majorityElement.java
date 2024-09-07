package ScalerProblems.ProblemSolving.InterviewProblems;
// Problem Description
// Given an array of size N, find the majority element. The majority element is the element that appears more than floor(n/2) times.
// You may assume that the array is non-empty and the majority element always exists in the array.

import java.util.List;

// Problem Constraints
// 1 <= N <= 5*105
// 1 <= num[i] <= 109


// Input Format
// Only argument is an integer array.


// Output Format
// Return an integer.


// Example Input
// Input 1:
// [2, 1, 2]
// Input 2:
// [1, 1, 1]


// Example Output
// Input 1:
// 2
// Input 2:
// 1


// Example Explanation
// For Input 1:
// 2 occurs 2 times which is greater than 3/2.
// For Input 2:
//  1 is the only element in the array, so it is majority
public class majorityElement {
        public int majorityElement(final List<Integer> A) {
        int majority= A.get(0), frequency =1;
        for(int i=1; i<A.size(); i++){
            if(frequency==0){
                majority= A.get(i);
                frequency=1;
            }
            else if(A.get(i)==majority){
                frequency++;
            }
            else{
                frequency--;
            }
        }
        // Verify if the candidate is actually the majority element
        int count = 0;
        for (int num : A) {
            if (num == majority) {
                count++;
            }
        }
        if (count > A.size() / 2) {
            return majority;
        } else {
            return -1; // This should not happen as per problem constraints (assuming a majority element always exists)
        }
    }
}
