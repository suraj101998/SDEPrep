/*
 * Big Factorial (Assignment)
Problem Statement
Implement a thread that computes factorials of a large number. Since the result can be significantly large, you should use the BigInteger class to store the result and perform the computation.

Instructions
Implement the BigFactorial Class: Design this class to utilize multi-threading for computing the factorial of large numbers, specifically by extending the Thread class. Incorporate the BigInteger class for handling large results. Detailed requirements for the class include:
An int field to hold the number for factorial computation.
A BigInteger field to store the computed factorial.
A constructor to initialize the class with the target number.
Essential methods to perform the computation in a separate thread and retrieve the result.
The class should override the run() method of the Thread class to perform the factorial computation within a separate thread.
The class should efficiently calculate the factorial of any number provided, ensuring thread-safe execution and resource management, by extending the Thread class and overriding the run() method.
 */

 import java.math.BigInteger;

public class BigFactorial extends Thread {
    private final int number;
    private volatile BigInteger factorial; // Ensures visibility across threads

    public BigFactorial(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        factorial = computeFactorial(number);
    }

    private BigInteger computeFactorial(int num) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public BigInteger getFactorial() {
        return factorial;
    }

    public static void main(String[] args) throws InterruptedException {
        BigFactorial calculator = new BigFactorial(100);
        calculator.start();
        calculator.join(); // Wait for the thread to finish

        System.out.println("Factorial of 100: " + calculator.getFactorial());
    }
}
