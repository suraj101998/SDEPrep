package DSA.SAT;

import java.util.HashSet;

public class removeDuplicatesFromArray {
    static int removeDuplicates(int[] arr){
        // int i =0;
        // for(int j=1; j<arr.length; j++){
        //     if (arr[i] != arr[j]){
        //         i++;
        //         arr[i]=arr[j];
        //     }
        // }
        // return i+1;
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i =0; i<n; i++){
            set.add(arr[i]);
        }
        int index = 0;
        for (int value : set) {
            arr[index++] = value;
        }
        return set.size();
    }
    public static void main(String[] args){
        int arr[] = {1,1,2,2,2,3,3};
        int k = removeDuplicates(arr);
        for(int i=0; i<k; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
