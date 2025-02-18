package LLD.synchronization_with_semaphores.printFooBarAlternately;

import java.util.concurrent.Semaphore;

/*
 * Suppose you are given the following code:

class FooBar {
  public void foo() {
    for (int i = 0; i < n; i++) {
      print("foo");
    }
  }

  public void bar() {
    for (int i = 0; i < n; i++) {
      print("bar");
    }
  }
}
The same instance of FooBar will be passed to two different threads:

thread A will call foo(), while
thread B will call bar().
Modify the given program to output "foobar" n times.

Example 1:
Input: n = 1
Output: "foobar"
Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar().
"foobar" is being output 1 time.
Example 2:
Input: n = 2
Output: "foobarfoobar"
Explanation: "foobar" is being output 2 times.
Constraints:
1 <= n <= 1000
 */
class FooBar {
    private int n;
    private final Semaphore fooSemaphore;
    private final Semaphore barSemaphore;

    public FooBar(int n) {
        this.n = n;
        this.fooSemaphore = new Semaphore(1); // Start with foo allowed
        this.barSemaphore = new Semaphore(0); // bar should wait
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSemaphore.acquire(); // Ensure foo runs first
            printFoo.run(); // Print "foo"
            barSemaphore.release(); // Allow bar to run
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSemaphore.acquire(); // Wait for foo to complete
            printBar.run(); // Print "bar"
            fooSemaphore.release(); // Allow foo to run again
        }
    }
}
