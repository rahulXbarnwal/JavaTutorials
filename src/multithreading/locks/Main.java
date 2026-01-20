package multithreading.locks;

/*
1. Intrinsic: These are built into every object in Java. You don't see them, but they're there.
              When you use a synchronized keyword, you're using these automatic locks.

2. Explicit: These are more advanced locks you can control yourself using the Lock class from java.util.concurrent.locks.
             You explicitly say when to lock & unlock, giving you more control over how & when people can write in the notebook.
 */

public class Main {
    public static void main(String[] args) {
        BankAccount sbi = new BankAccount();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                sbi.withdraw(50);
            }
        };
        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        t1.start();
        t2.start();
    }
}
