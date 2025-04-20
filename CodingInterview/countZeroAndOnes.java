package CodingInterview;
public class countZeroAndOnes{
    public static int[] countZeroAndOne(int[] arr){
        int countOfZero = 0;
        for(int num: arr){
                if(num == 0){
                    countOfZero++;
                }
        }
        int index = 0;
        while(countOfZero-- > 0){
            arr[index++] = 0;
        }
        while(index < arr.length){
            arr[index++] = 1;
        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr = {1,0,1,0,1};
        int[] result = countZeroAndOne(arr);
        for(int num : result){
            System.out.println(num+" ");
        }
    }
}