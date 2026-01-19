package multithreading;

public class ThreadClassMethods extends Thread{

    // naming of thread
//    public ThreadClassMethods(String name) {
//        super(name);
//    }

    @Override
    public void run() {
        /* setPriority()
        for(int i = 0; i < 5; i++) {
            String a = "";
            for(int j = 0; j < 10000; j++) {
                a += "a";
            }
            System.out.println(Thread.currentThread().getName() + " - Priority: " + Thread.currentThread().getPriority() + " - count: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        */


        /* interrupt()
        try {
            Thread.sleep(1000);
            System.out.println("Thread is running...");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e);
        }
         */


        /* yield()
        for(int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running");
            Thread.yield();
        }
         */


        while(true) {
            System.out.println("Hello World!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /* setPriority()
        ThreadClassMethods l = new ThreadClassMethods("Low Priority Thread");
        ThreadClassMethods m = new ThreadClassMethods("Medium Priority Thread");
        ThreadClassMethods h = new ThreadClassMethods("High Priority Thread");

        l.setPriority(Thread.MIN_PRIORITY);
        m.setPriority(Thread.NORM_PRIORITY);
        h.setPriority(Thread.MAX_PRIORITY);

        // 1. start() -> when it's called, JVM will execute run method
        l.start();
        m.start();
        h.start();
        */



        /* interrupt()
        ThreadClassMethods t1 = new ThreadClassMethods();
        t1.start();
        t1.interrupt(); // Thread interrupted: java.lang.InterruptedException: sleep interrupted

         */



        /* yield()
        ThreadClassMethods t1 = new ThreadClassMethods();
        ThreadClassMethods t2 = new ThreadClassMethods();

        t1.start();
        t2.start();
         */



        ThreadClassMethods myThread = new ThreadClassMethods();
        myThread.setDaemon(true);
        ThreadClassMethods t1 = new ThreadClassMethods();
        t1.start(); // now JVM will wait for t1, since that's user thread
        myThread.start();
        System.out.println("Main done");

        // main thread's work is completed, but JVM is waiting for the myThread to get completed
        // hence by setting that thread as daemon, now that is background threa, JVM will not wait for that and will exit
    }
}

// start, run, sleep, join, setPriority, interrupt, yield, setDaemon

/*
setPriority -> not strict, will just give hint to JVM and OS Scheduler
interrupt -> if the thread is waiting/ sleeping, interrupt it
yield -> A hint to the scheduler that the current thread is willing to yield its current use of a processor.
         The scheduler is free to ignore this hint.

USER THREADS -> which are actually doing work
DAEMON THREADS -> which runs in background, like Garbage collector
                  JVM will not wait for these threads
*/