package LLD.synchronization_with_semaphores.ZeroEvenOdd;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/*
 * You have an object printNumber. printNumber.accept(x) can be called with an integer parameter that prints it to the console.

You are given an instance of the class ZeroEvenOdd that has three functions: zero, even, and odd. The same instance of ZeroEvenOdd will be passed to three different threads:

Thread A: calls zero() that should only output 0's.
Thread B: calls even() that should only output even numbers.
Thread C: calls odd() that should only output odd numbers.
Modify the given class to output the series "010203040506..." where the length of the series must be 2n.

Implement the ZeroEvenOdd class:

ZeroEvenOdd(int n) Initializes the object with the number n that represents the numbers that should be printed.
void zero(printNumber) Calls printNumber to output one zero.
void even(printNumber) Calls printNumber to output one even number.
void odd(printNumber) Calls printNumber to output one odd number.
Example 1:
Input: n = 2
Output: "0102"
Explanation: There are three threads being fired asynchronously.
One of them calls zero(), the other calls even(), and the last one calls odd().
"0102" is the correct output.
Example 2:
Input: n = 5
Output: "0102030405"
Constraints:
1 <= n <= 1000
 */
class ZeroEvenOdd {
    private int n;
    private Semaphore zeroSemaphore;
    private Semaphore oddSemaphore;
    private Semaphore evenSemaphore;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.zeroSemaphore = new Semaphore(1);  // Start with zero
        this.oddSemaphore = new Semaphore(0);   // Odd waits
        this.evenSemaphore = new Semaphore(0);  // Even waits
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroSemaphore.acquire();
            printNumber.accept(0); // Print 0
            if (i % 2 == 1) {
                oddSemaphore.release();  // Allow odd
            } else {
                evenSemaphore.release(); // Allow even
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSemaphore.acquire();
            printNumber.accept(i); // Print odd number
            zeroSemaphore.release(); // Allow next 0
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSemaphore.acquire();
            printNumber.accept(i); // Print even number
            zeroSemaphore.release(); // Allow next 0
        }
    }
}

