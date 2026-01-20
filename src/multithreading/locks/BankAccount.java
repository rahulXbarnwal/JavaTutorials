package multithreading.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
ReentrantLock is a class which implements Lock interface

tryLock(): Acquires the lock only if it's free at time of invocation.
           Acquires the lock if it's available and returns immediately with the value true.
           If the lock is not available then this method will return immediately with the value false.

lock(): same as synchronized, will wait for the lock to be available


If an InterruptedException or a ThreadDeath error is not handled properly, the information that the thread was interrupted will be lost.
Handling this exception means either to re-throw it or manually re-interrupt the current thread by calling Thread.interrupt().
Simply logging the exception is not sufficient and counts as ignoring it.
B/w the moment the exception is caught and handled, is the right time to perform cleanup operations on the method's state, if needed.

What is the potential impact?
- Failing to interrupt the thread (or to re-throw) risks delaying the thread shutdown and losing the information that the thread was interrupted
  probably without finishing its task.
 */

public class BankAccount {
    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    /*
    jab hmne esko synchronized kr diya to agar t1 access krrha to t2 access nhi kr payega
    chahe hm kitna bhi sleep krwa rhe ho
    jb tk t1 esko poora khtm nhi kr lega including this sleep, tab tk t2 nhi aayega
     */
//    public synchronized void withdraw(int amount) {

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        /*
        if(balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {

            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " insufficient balance");
        }
         */

        try {
            // Acquires the lock if it's free within the given waiting time & the current thread hasn't been interrupted
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if(balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
                        Thread.sleep(3000); // Simulate time taken to process the withdrawal
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " couldn't acquire the lock, will try again later");
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        if(Thread.currentThread().isInterrupted()) {
            System.out.println("");
        }
    }
}
