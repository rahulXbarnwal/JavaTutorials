package multithreading.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
locking me fairness hoti hai, order determine hoti hai ki kon se thread ko lock milega, kyuki multiple thread wants lock,
to sbse phle kisko milega fir kisko milega, to wo order jo hai usko fairness kehte

jo pehle aaya hai usko pehle lock milega

Fair Lock: Jo pehle aya, usko lock milega (FIFO)
Unfair Lock: Jo fast hai wo ghus jata hai, chahe baad me aaya ho

let's say 20 threads hai and unme se ek to lock mil hi nhi rha hai baaki sb race krrhe hai, (starvation)
this doesn't happen in fairness, mauka sbko milega, order to FIFO rhega hi but mauka sbko milega

Disadvantages of synchronization:
- synchronized me fairness ki guarantee nhi hai
- indefinitely blocking hoti hai
- interruptibility bhi nhi hai
- synchronized ko pta hi nhi hai kon sa read / write hai to wo to poora block krke rkhega
 */

public class FairnessLockExample {
//    private  final Lock unfairLock = new ReentrantLock();
    private final Lock lock = new ReentrantLock(true);

    public void accessResource() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock");
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " released the lock");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        FairnessLockExample example = new FairnessLockExample();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                example.accessResource();
            }
        };

        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");
        Thread thread3 = new Thread(task, "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
