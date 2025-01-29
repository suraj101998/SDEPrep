package DSA.Advanced.BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class longestIncreasingSubsequence {
    public static int findIncreasingSubsequence(int[] arr){
        List<Integer> result = new ArrayList<>();
        for(int num : arr){
            int position = Collections.binarySearch(result, num);
            if(position< 0){
                position = -(position+1);
            }
            if(position<result.size()){
                result.set(position, num);
            }
            else{
                result.add(num);
            }
        }
        return result.size();
    }
    public static void main(String[] args){
        int[] A = {1,3,45,2,20};
        int result = findIncreasingSubsequence(A);
        System.out.println("ans: "+result);
    }
}
