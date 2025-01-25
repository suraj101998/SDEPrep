package DSA.Advanced.ArraysOneDimensional;

public class largestElementinArray {
  public static void main(String[] args) {
    int[] A = {1,2,5,4,3};
    int result = largestElemet(A);
    System.out.println("ans: "+result);
  }
  public static int largestElemet(int[] A){
    int max = A[0];
    for(int i=1; i<A.length; i++){
      max = Math.max(max, A[i]);
    }
    return max;
  }
}
