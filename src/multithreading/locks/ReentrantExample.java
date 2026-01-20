package multithreading.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    private final Lock lock = new ReentrantLock();

    public void outerMethod() {

        // 1. lock acquired by main thread
//        lock.lock(); // t1 ne lock le liya and innerMethod me ghus gya, and t2 wait krrha indefinitely for t1 to get finished, esko bolte hai BLOCKED/WAITING state, agar aap .lock() use krrhe to us waiting thread t2 ko interrupt nhi kr paynge
        try {
            lock.lockInterruptibly(); // lekin agar aapko usko interrupt krna hai, to lock ko interruptible hona bhi to chahie, to interruptexception throw hoga, to esko try/catch me krna pdega
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            // 2.
            System.out.println("Outer method");
            innerMethod();
        } finally {
            lock.unlock();
        }
    }

    public void innerMethod() {
        /*
        3. jo lock phle se lock kr-rkha hai hmne usko fir se mai lock krne ka try krrha hu
        mai apna hi wait krrha hu - deadlock

        But since the lock is Reentrant
        yani same thread holds it, to fir se whi thread acquire kr lega lock


        Jb hm Reentrant lock use krte hai to ek count maintain hota hai, ki lock kitni baar acquire kiya gya hai
        each lock call must be paired with an unlock call
        lock tb release hoga jb hr ek lock match ho jayega uske unlock se
         */

        lock.lock();
        try {
            System.out.println("Inner method");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantExample example = new ReentrantExample();
        example.outerMethod();
    }
}
