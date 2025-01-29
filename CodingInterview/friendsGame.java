package CodingInterview;
/*
ITC INFOTECH
 Question:
You are given N friends, each with a certain amount of energy. The energy of the i-th friend is represented by A[i]. To win a game, a friend must have more energy than the friends with the minimum energy level. Your task is to determine how many friends can win the game.

Input:
The first line contains an integer N (1 ≤ N ≤ 1000) — the number of friends.
The second line contains N integers A[i] (1 ≤ A[i] ≤ 1000) — the energy levels of the friends.
Output:
Print a single integer — the number of friends that can win the game.
Example:
Input:
6
5 2 2 3 6 6
Output:
4
Explanation:
The minimum energy level is 2.
There are 2 friends with the minimum energy level.
Therefore, 6 - 2 = 4 friends can win the game.
 */
import java.util.Scanner;
public class friendsGame {
    public static int gameWinners(int N, int[] A) {
        // This is the default output. You can change it.
        int result = -404;
        int minEnergy = A[0];

        // Write your logic here:
        for (int i = 1; i < N; i++) {
            if (A[i] < minEnergy) {
                minEnergy = A[i];  // Correctly update minEnergy
            }
        }

        int minCount = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == minEnergy) {
                minCount++;
            }
        }

        result = N - minCount;
        return result;  // Ensure to return the result
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int result = gameWinners(N, A);
        System.out.println(result);
    } 
}
