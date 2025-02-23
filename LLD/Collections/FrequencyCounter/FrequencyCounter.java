package LLD.Collections.FrequencyCounter;

/*
 * Frequency Count
Problem Statement
You are given an array of integers, and you need to count the frequency of each integer present in the array using a Map and return the map as the answer.

Use Map<Integer,Integer> to solve the question.
The keys of the map are the elements of the array.
The values of the map are the frequencies of those elements.
Instructions
Implement the countFrequencies method inside the FrequencyCounter class.
You don't need to print anything, just implement the function and return the map that stores the elements and their frequencies.
The order of the keys inside the map does not matter.
 */
import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter {
    public static Map<Integer, Integer> countFrequencies(int[] nums) {
        Map<Integer,Integer> hashMap = new HashMap<>();
        for(int num: nums){
            hashMap.put(num, hashMap.getOrDefault(num, 0)+1);
        }

        return hashMap;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,1,2,3,4,5,1};
        Map<Integer,Integer> ans = countFrequencies(nums);

        System.out.println(ans);

    }
}