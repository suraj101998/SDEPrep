package LLD;

/*implement a mutex lock using semaphores
 * A mutex lock can be implemented using semaphores by ensuring that a single thread can acquire the lock at a time. 
 * A semaphore with an initial value of 1 is used for this purpose.

Here's how it works:

Lock acquisition (acquire operation): A thread attempts to decrement the semaphore. 
If the semaphore value becomes 0, it means the lock is held, 
and other threads are blocked until it is released.

Lock release (release operation): The thread increments the semaphore, 
allowing other threads to acquire the lock.
 */

 import java.util.concurrent.Semaphore;

 class MutexLock {
     private final Semaphore semaphore;
 
     // Constructor to initialize the semaphore with 1 permit
     public MutexLock() {
         this.semaphore = new Semaphore(1); // Binary semaphore (mutex)
     }
 
     // Acquire the lock
     public void lock() {
         try {
             semaphore.acquire(); // Decrement semaphore (wait if already 0)
         } catch (InterruptedException e) {
             Thread.currentThread().interrupt();
             System.out.println("Thread interrupted while acquiring lock");
         }
     }
 
     // Release the lock
     public void unlock() {
         semaphore.release(); // Increment semaphore (signal)
     }
 }
 
 // Example usage
 public class mutexLockUsingSemphores {
     public static void main(String[] args) {
         MutexLock mutex = new MutexLock();
 
         // Create multiple threads to test the mutex
         Runnable criticalSection = () -> {
             System.out.println(Thread.currentThread().getName() + " is waiting for the lock...");
             mutex.lock();
             try {
                 System.out.println(Thread.currentThread().getName() + " acquired the lock.");
                 // Simulate critical section
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 Thread.currentThread().interrupt();
             } finally {
                 System.out.println(Thread.currentThread().getName() + " is releasing the lock.");
                 mutex.unlock();
             }
         };
 
         Thread t1 = new Thread(criticalSection, "Thread-1");
         Thread t2 = new Thread(criticalSection, "Thread-2");
 
         t1.start();
         t2.start();
     }
 }
 