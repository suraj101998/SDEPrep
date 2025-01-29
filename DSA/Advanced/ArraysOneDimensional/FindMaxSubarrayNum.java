package DSA.Advanced.ArraysOneDimensional;
/*
 * Given an array={5,3,8,2,7,9} and an window size k =3.
 * slide the window and find the max element in each subaaray.
 * Store the result in the ans[] array.
 * Input: 5 3 8 2 7 9 , k =3
 * Output: 8 8 8 9
 */

class FindMaxSubarrayNum {
    public static int[] findMax(int[] arr, int k){
      int N = arr.length;
      int[] ans = new int[N-k+1];
      int maxIndex = 0;
  
      //create the first window
      for(int i=0; i<k; i++){
        if(arr[i] > arr[maxIndex]){
          maxIndex= i;
        }
      }
      ans[0] = arr[maxIndex];
  
      //slide the window over the array
      for (int i =k; i<N; i++){
        if(arr[i] > arr[maxIndex]){
          maxIndex= i;
        }
        if (maxIndex <= i-k){
          maxIndex = i-k+1;
          for(int j =maxIndex; j<=i; j++){
            if(arr[i]>arr[maxIndex]){
              maxIndex=i;
            }
          }
        }
        ans[i-k+1] = arr[maxIndex];
      }
      return ans;
    }
    public static void main(String[] args) {
        int[] arr = {5,3,8,2,7,9};
        int k =3;
        int[] result = findMax(arr, k);
        for(int i=0; i<result.length; i++){
          int num = result[i];
          System.out.print(num+" ");
        }
    }
  }