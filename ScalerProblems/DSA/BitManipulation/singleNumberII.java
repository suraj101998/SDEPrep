package ScalerProblems.DSA.BitManipulation;
// Problem Description
// Given an array of integers, every element appears thrice except for one, which occurs once.

// Find that element that does not appear thrice.

// NOTE: Your algorithm should have a linear runtime complexity.

// Could you implement it without using extra memory?




// Problem Constraints
// 2 <= A <= 5*106

// 0 <= A <= INTMAX



// Input Format
// First and only argument of input contains an integer array A.



// Output Format
// Return a single integer.



// Example Input
// Input 1:

//  A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
// Input 2:

//  A = [0, 0, 0, 1]


// Example Output
// Output 1:

//  4
// Output 2:

//  1


// Example Explanation
// Explanation 1:

//  4 occurs exactly once in Input 1.
//  1 occurs exactly once in Input 2.

public class singleNumberII {
    public int singleNumber(final int[] A) {
        int uniqueNumber = 0;
        
        // There are 32 bits in an integer
        for (int i = 0; i < 32; i++) {
            int bitSum = 0;
            int mask = 1 << i; // mask to check i-th bit
            
            // Count the number of integers with the i-th bit set
            for (int j = 0; j < A.length; j++) {
                int num = A[j];
                if ((num & mask) != 0) {
                    bitSum++;
                }
            }

            // If bitSum is not divisible by 3, it means the unique number has this bit set
            if (bitSum % 3 != 0) {
               uniqueNumber = uniqueNumber | mask; // set the i-th bit in the unique number
            }
        }
        
        return uniqueNumber;
    }
}
