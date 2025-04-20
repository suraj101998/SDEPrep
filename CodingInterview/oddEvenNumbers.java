package CodingInterview;

import java.util.ArrayList;
import java.util.List;

public class oddEvenNumbers {
    public static List<Integer> getOddNumbers(int[] arr) {
        List<Integer> oddList = new ArrayList<>();
        for (int num : arr) {
            if (num % 2 != 0) {
                oddList.add(num);
            }
        }
        return oddList;
    }

    public static List<Integer> getEvenNumbers(int[] arr) {
        List<Integer> evenList = new ArrayList<>();
        for (int num : arr) {
            if (num % 2 == 0) {
                evenList.add(num);
            }
        }
        return evenList;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> oddNumbers = getOddNumbers(arr);
        List<Integer> evenNumbers = getEvenNumbers(arr);

        System.out.println("Odd Numbers Array: " + oddNumbers);
        System.out.println("Even Numbers Array: " + evenNumbers);
    }
}
