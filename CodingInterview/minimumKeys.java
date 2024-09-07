package CodingInterview;
/*
ITC INFOTECH
 You are playing a game with N levels. To complete each level i, you need a certain number of keys, represented by A[i]. After completing level i, you receive some additional keys, represented by B[i]. You start with zero keys.

Your task is to determine the minimum number of keys you need to start with in order to complete all N levels.

Input:
The first line contains an integer N (1 ≤ N ≤ 1000) — the number of levels.
The next N lines each contain two integers A[i] and B[i] (1 ≤ A[i], B[i] ≤ 1000) — the number of keys required to complete level i and the number of keys obtained after completing level i, respectively.
Output:
Print a single integer — the minimum number of keys required at the start to complete all levels.
Example:
Input:
2
1 2
3 4

Output:
2

Explanation:
For the first level, you need 1 key and will receive 2 keys after completing it. Starting with 2 keys allows you to complete the first level, leaving you with 3 keys.
For the second level, you need 3 keys and will receive 4 keys after completing it. Since you have 3 keys, you can complete the level.
The minimum number of keys required to start is 2.

 */

import java.util.*;
public class minimumKeys {
    public static int minKeys(int N, int[] A, int[] B) {
        // This is the default output. You can change it.
        int result = -404;

        // Write your logic here:
        int requiredKeys = 0;
        int currentKeys = 0;

        for (int i = 0; i < N; i++) {
            // If current keys are less than keys needed for level i
            if (currentKeys < A[i]) {
                // Calculate the additional keys required
                requiredKeys += (A[i] - currentKeys);
                currentKeys = A[i];  // Update current keys to the needed amount
            }
            // Use the keys for the current level
            currentKeys -= A[i];
            // Add the keys obtained from the current level
            currentKeys += B[i];
        }

        result = requiredKeys;

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
        }

        int result = minKeys(N, A, B);
        System.out.println(result);
    } 
}
