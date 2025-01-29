package CodingInterview;
/*
 * Equal
 * generate and display the Fibonacci series where first digit is sum of its last 3 digit.
 * input: 10
 * output: 0 1 2 3 6 11 20 37 68 125
 */
public class fibonacciWith3digitSum {
    public static void main(String[] args) {
        int n = 10; // Number of terms in the Fibonacci series

        System.out.println("Fibonacci series up to " + n + " terms:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    // Recursive method to calculate the nth Fibonacci number
    public static int fibonacci(int n) {
        if (n <= 2) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2) + fibonacci(n-3);
    }
}

