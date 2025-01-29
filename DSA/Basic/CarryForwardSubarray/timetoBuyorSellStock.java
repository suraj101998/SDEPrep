package DSA.Basic.CarryForwardSubarray;
// Problem Description
// Say you have an array, A, for which the ith element is the price of a given stock on day i.
// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

import java.util.List;

// Return the maximum possible profit.



// Problem Constraints
// 0 <= A.size() <= 700000
// 1 <= A[i] <= 107



// Input Format
// The first and the only argument is an array of integers, A.


// Output Format
// Return an integer, representing the maximum possible profit.


// Example Input
// Input 1:
// A = [1, 2]
// Input 2:

// A = [1, 4, 5, 2, 4]


// Example Output
// Output 1:
// 1
// Output 2:

// 4


// Example Explanation
// Explanation 1:
// Buy the stock on day 0, and sell it on day 1.
// Explanation 2:

// Buy the stock on day 0, and sell it on day 2.
public class timetoBuyorSellStock {
    //     // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) { //list is final so cant change the exististing array
        //A=[1 2] expected =1 2-1 =1  but it is returning 0.
        int N=A.size();
         if (A == null || A.size() < 2) {
            return 0;
        }
        int max=0;// 1
        int min=Integer.MAX_VALUE;// 1
        for(int i=0;i<N;i++){
        //    max=Math.max(max,A.get(i)); // 2
           min = Math.min(min, A.get(i));   //1
//             // Calculate the potential profit if selling at the current price
            int currentProfit = A.get(i) - min; // day 3 something at 105 rs. that is 5 rs. bcz 105-100
//             // Update the gain found
             max = Math.max(max, currentProfit);
        }
        return max; //2-1
    }
}
