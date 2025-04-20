package CodingInterview;
/*
 * Given a range find the symmetric numbers count in between them
 * A number is called symmetric if:
It has an even number of digits.
The sum of the first half digits equals the sum of the second half digits.
Example:
1230 → first half: 1 + 2 = 3, second half: 3 + 0 = 3 → symmetric
1111 → 1 + 1 = 2, 1 + 1 = 2 → symmetric
1234 → 1 + 2 = 3, 3 + 4 = 7 → not symmetric
 * 
 */
public class Symmetric {
    public static void main(String[] args) {
        int low = 1000;
        int high = 9999;
        System.out.println("Count: " + countSymmetricIntegers(low, high));
        System.out.println("Count: " + countSymmetricNumbers(low, high));
    }

    public static int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            String str = Integer.toString(i);
            int len = str.length();

            if (len % 2 != 0) continue; // skip odd digit numbers

            int half = len / 2;
            int sumLeft = 0, sumRight = 0;

            for (int j = 0; j < half; j++) {
                sumLeft += str.charAt(j) - '0';
                sumRight += str.charAt(j + half) - '0';
            }

            if (sumLeft == sumRight) {
                count++;
            }
        }
        return count;
    }


    // Function to count symmetric (palindromic) numbers in a given range
    public static int countSymmetricNumbers(int start, int end) {
        int count = 0;
        
        // Iterate through the range [start, end]
        for (int num = start; num <= end; num++) {
            if (isSymmetric(num)) {
                count++;
            }
        }
        
        return count;
    }

    // Function to check if a number is symmetric (palindromic)
    public static boolean isSymmetric(int num) {
        int originalNum = num;
        int reversedNum = 0;

        // Reverse the number
        while (num > 0) {
            int digit = num % 10;
            reversedNum = reversedNum * 10 + digit;
            num /= 10;
        }

        // Check if original number equals the reversed number
        return originalNum == reversedNum;
    }
}
