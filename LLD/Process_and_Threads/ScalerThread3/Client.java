package ScalerThread3;

import java.util.Scanner;
public class Client {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        Thread[] threads = new Thread[n];

        for (int i = 1; i <= n; i++) {
            threads[i - 1] = new TableCreator(i);
            threads[i - 1].start();
        }

        // Ensuring all threads complete execution
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
