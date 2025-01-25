package DSA.Basic.InterviewProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * You are given an array/list ARR consisting of N integers. 
 * Your task is to find all the distinct triplets present in the array which adds up to a given number K.
An array is said to have a triplet {ARR[i], ARR[j], ARR[k]} with sum = 'K' 
if there exists three indices i, j and k such that i!=j, j!=k and i!=j and ARR[i] + ARR[j] + ARR[k] = 'K'.
Note:
1. You can return the list of values in any order. 
For example, if a valid triplet is {1, 2, -3}, then {2, -3, 1}, {-3, 2, 1} etc is also valid triplet. 
Also, the ordering of different triplets can be random i.e if there are more than one valid triplets, 
you can return them in any order.
2. The elements in the array need not be distinct.
3. If no such triplet is present in the array, then return an empty list, 
and the output printed for such a test case will be "-1".
 */
public class tripletsWithGivenSum {
    public static List<List<Integer>> findTriplets(int[] arr, int target){
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0; i< arr.length - 2; i++){
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }
            int l = i+1;
            int r = arr.length-1;
            while (l<r) {
                int sum = arr[i]+arr[l]+arr[r];
                if(sum==target){
                    triplets.add(Arrays.asList(arr[i], arr[l],arr[r]));
                    while(l<r && arr[l]==arr[l+1]){
                        l++;
                    }
                    while(l<r && arr[r]==arr[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                }
                else if(sum<target){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args){
        int arr[] = {1,2,3,4,5};
        int k = 12;
        List<List<Integer>> result =  findTriplets(arr, k);
        if(result.isEmpty()){
            System.out.println("-1");
        }
        else{
            for(List<Integer> num: result){
                System.out.println(num);
            }
        }
    }
}
