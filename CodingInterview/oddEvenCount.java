package CodingInterview;

public class oddEvenCount {
    public static int[] countOddEven(int[] arr) {
        int oddCount = 0;
        int evenCount = 0;

        for (int num : arr) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        return new int[]{oddCount, evenCount}; // Index 0 -> odd count, Index 1 -> even count
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        int[] result = countOddEven(arr);
        System.out.println("Odd Count: " + result[0]);
        System.out.println("Even Count: " + result[1]);
    }
}
