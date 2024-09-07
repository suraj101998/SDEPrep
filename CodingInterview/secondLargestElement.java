package CodingInterview;
// Infosys: Given an array Find the Second largest Element. [1 2 3 4 5] ans = 4.
public class secondLargestElement {
    public static int[] solve(int[] A) {
        int max=-1;
        int secondMax=-1;
       for(int i=0;i<A.length;i++){
           if(max<A[i]){
               secondMax=max;
               max=A[i];
           }
           else if (A[i] > secondMax && A[i] < max) {
                secondMax = A[i];
            }
       }
       return new int[] { secondMax };
    }
    public static void main(String[] args){
        int[] A = {5,8,9,6,4,3};
        int[] result = solve(A);
        for(int i=0; i<result.length; i++){
            int num = result[i];
            System.out.print(num + " ");
        }
    }
}
