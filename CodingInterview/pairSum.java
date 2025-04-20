package CodingInterview;

import java.util.HashMap;
import java.util.HashSet;

public class pairSum {
    //Brute Force
    public static void findPairsBruteForce(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("(" + arr[i] + ", " + arr[j] + ")");
                }
            }
        }
    }
    //Using HashSet
    public static void findPairsHashSet(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;

            if (set.contains(complement)) {
                System.out.println("(" + num + ", " + complement + ")");
            }
            set.add(num);
        }
    }
    //using HashMap
    public static void findPairsHashMap(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            int complement = target - num;

            if (map.containsKey(complement)) {
                System.out.println("(" + num + ", " + complement + ")");
            }
            map.put(num, 1); // store in map
        }
    }
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 7, 8, 3, 9};
        int targetSum = 12;

        System.out.println("Pairs with sum " + targetSum + ":");
        findPairsBruteForce(arr, targetSum);
        System.out.println("Pairs with sum HashSet " + targetSum + ":");
        findPairsHashSet(arr, targetSum);
        System.out.println("Pairs with sum HashSet " + targetSum + ":");
        findPairsHashMap(arr, targetSum);
    }
}
