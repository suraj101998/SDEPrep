package CodingInterview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*Given two arrays print only the not common elements  */
public class uniqueElements {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5, 6, 7, 8};
        findUniqueHashSet(arr1, arr2);
        findUniqueArray(arr1, arr2);
        int[] result = getNotCommonElements(arr1, arr2);
        System.out.println("\nans: "+Arrays.toString(result));
    }

    public static void findUniqueHashSet(int[] arr1, int[] arr2){
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int num : arr1)
            set1.add(num);
        for(int num : arr2)
            set2.add(num);

        // Find common elements
        Set<Integer> common = new HashSet<>(set1);
        common.retainAll(set2); // keeps only common elements

        // Print non-common elements from both arrays
        System.out.println("Non-common elements in SET format:");
        for(int num : arr1) {
            if(!common.contains(num))
                System.out.print(num + " ");
        }
        for(int num : arr2) {
            if(!common.contains(num))
                System.out.print(num + " ");
        }
    }

    public static void findUniqueArray(int[] arr1, int[] arr2){
        System.out.println("\nNot common elements in array format:");

        // Check elements of arr1 not in arr2
        for (int i = 0; i < arr1.length; i++) {
            boolean found = false;
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.print(arr1[i] + " ");
            }
        }

        // Check elements of arr2 not in arr1
        for (int i = 0; i < arr2.length; i++) {
            boolean found = false;
            for (int j = 0; j < arr1.length; j++) {
                if (arr2[i] == arr1[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.print(arr2[i] + " ");
            }
        }
    }

    public static int[] getNotCommonElements(int[] arr1, int[] arr2) {
        int[] temp = new int[arr1.length + arr2.length];
        int index = 0;

        // Check arr1 elements not in arr2
        for (int i = 0; i < arr1.length; i++) {
            boolean found = false;
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                temp[index++] = arr1[i];
            }
        }

        // Check arr2 elements not in arr1
        for (int i = 0; i < arr2.length; i++) {
            boolean found = false;
            for (int j = 0; j < arr1.length; j++) {
                if (arr2[i] == arr1[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                temp[index++] = arr2[i];
            }
        }

        // Copy only filled elements to result array
        int[] result = new int[index];
        for (int i = 0; i < index; i++) {
            result[i] = temp[i];
        }

        return result;
    }
}
