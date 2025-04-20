package CodingInterview;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class longestSequence {
    public static void main(String[] args){
        List<Integer> nums = Arrays.asList(6, 100,4,200,1,3,2,5);
        int result = longestConsecutiveSubsequence(nums);
        System.out.println("ans: "+result);
    }

    public static int longestConsecutiveSubsequence(List<Integer> nums){
        Set<Integer> set = new HashSet<>(nums);
        int maxLength = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int currentNum = num; ///setting the strting point
                int count =1;
                while(set.contains(currentNum+1)){
                    currentNum++;
                    count++;
                }
                maxLength = Math.max(maxLength, count);
            }
        }
        return maxLength;
    }
}
