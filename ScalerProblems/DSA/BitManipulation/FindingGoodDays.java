package ScalerProblems.DSA.BitManipulation;
// Problem Description
// Alex has a cat named Boomer. He decides to put his cat to the test for eternity.

// He starts on day 1 with one stash of food unit, every next day, the stash doubles.

// If Boomer is well behaved during a particular day, only then she receives food worth equal to the stash produced on that day.

// Boomer receives a net worth of A units of food. What is the number of days she received the stash?



// Problem Constraints
// 1 <= A <= 231-1



// Input Format
// First and only argument is an integer A.



// Output Format
// Return an integer denoting the number of days Boomer was well behaved.



// Example Input
// Input 1:

// A = 5
// Input 2:

// A = 8


// Example Output
// Output 1:

//  2
// Output 2:

//  1


// Example Explanation
// Explanation 1:

//  To eat a total of 5 units of food, Boomer behaved normally on Day 1 and on the Day 3.
// Explanation 2:

//  To eat a total of 8 units of food, Boomer behaved normally only on day 4.

/*Approach:
 * consider each day as bits of A
        if A=5, 101  --> which means 1st and third day ---> total 2days Boomer received food
        if A=8, 1000 --> which means 4th day  --> total 1day
        Solution: count no of set bits in given number
 */
public class FindingGoodDays {
    public int solve(int A) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((A & (1<<i)) != 0) {
                count++;
            }
        }
        return count;
    }
    
}
