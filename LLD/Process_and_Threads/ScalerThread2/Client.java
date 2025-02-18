package ScalerThread2;

import java.util.Scanner; 
public class Client {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        scanner.close();
        Adder adderTask = new Adder(num1, num2);
        ScalerThread thread = new ScalerThread(adderTask);
        thread.start();
        thread.join();
    }
}
