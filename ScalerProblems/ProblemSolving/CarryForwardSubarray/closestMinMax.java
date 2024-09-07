package ScalerProblems.ProblemSolving.CarryForwardSubarray;
// Problem Description
// Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array

import java.util.ArrayList;

// and at least one occurrence of the minimum value of the array.



// Problem Constraints
// 1 <= |A| <= 2000



// Input Format
// First and only argument is vector A



// Output Format
// Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array



// Example Input
// Input 1:

// A = [1, 3, 2]
// Input 2:

// A = [2, 6, 1, 6, 9]


// Example Output
// Output 1:

//  2
// Output 2:

//  3


// Example Explanation
// Explanation 1:

//  Take the 1st and 2nd elements as they are the minimum and maximum elements respectievly.
// Explanation 2:

//  Take the last 3 elements of the array.

public class closestMinMax {
        public int solve(ArrayList<Integer> A) {
        int N=A.size();
        int max=A.get(0);
        int min=A.get(0);
       if (A.size() == 1){ //[1]
            return 1;
         }
        for(int i=1;i<N;i++){
            max=Max(max,A.get(i));
            min=Min(min,A.get(i));
        }
         int ans=N;
        int minIdx=-1;//my index starts from 0. so min can be at 0 index
        int maxIdx=-1;//same for max
        for(int i=0;i<N;i++){// [2,6,1,6,9]
            if(min==max){
                ans=1;
            }
            if(A.get(i)==min){
                minIdx=i;
                if(maxIdx !=-1){
                   ans=Min(ans,minIdx-maxIdx+1);  //if we found min at current index and maxindex is not -1 means
                    // alredy max index is peresent before the min index so formula is minIdx-maxIdx ans we need to calculate
                    //size means we have to find size(or range from a to b)means we need to incluede a and b(i.e [a,b]=b-a+1)
       
                }
 
            }else if(A.get(i)==max){
                maxIdx=i; //maxindex=1
                 if(minIdx !=-1){
                    ans=Min(ans,maxIdx-minIdx+1);
                 }
            }
        }
        return ans;
 
    }
     public static int Min(int a,int b){
        if (a<b){
            return a;
        }
            return b;
    }
    public static int Max(int a,int b){
        if (a>b){
            return a;
        }
            return b;
    }
}
