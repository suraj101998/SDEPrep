package DSA.Advanced.DyanmicProgramming;

import java.util.Arrays;

public class longestIncreasingSubsequence {
    public static int longestSubstring(int[] A){
        int n = A.length;
        if(n==0){
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(A[i]>A[j] && dp[i]>dp[j]){
                    dp[i] = dp[j]+1;
                }
            }
        }
        int maxSubsequence = 1;
        for(int num: dp){
            maxSubsequence = Math.max(maxSubsequence, num);
        }
        return maxSubsequence;
    }

    public static void main(String[] args){
        int[] A= {1,3,45,2,20};
        int result = longestSubstring(A);
        System.out.println("ans: "+result);
    }
}
