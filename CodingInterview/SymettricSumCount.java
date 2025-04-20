package CodingInterview;
/*NTT Data
given a range. find the symettric numbers in that range.
*/
public class SymettricSumCount{
    public static void main(String[] args){
        int start = 1200;
        int end =1230;
        int result = symmetric(start, end);
        System.out.println("ans: "+result);
    }

    public static int symmetric(int start, int end){
        int count = 0;
        for(int i=start; i<=end; i++){
            String str = Integer.toString(i);
            int len = str.length();
            if(len % 2 != 0) continue;
            int half = len/2;
                int leftSum = 0, rightSum = 0;
                for(int j =0; j<half; j++){
                    leftSum += str.charAt(j)- '0';
                    rightSum += str.charAt(j+half) - '0';
                }
                if(leftSum == rightSum){
                    count++;
                }
        }
        return count;
    }
}