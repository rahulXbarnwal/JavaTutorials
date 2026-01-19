package multithreading;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("RUNNING");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        System.out.println(t1.getState()); // NEW
        t1.start();
        System.out.println(t1.getState()); // RUNNABLE
//        System.out.println(Thread.currentThread().getState()); // RUNNABLE

        Thread.sleep(100);
        System.out.println(t1.getState()); // TIMED_WAITING

        // caller method (main) will wait for t1 to get finished
        t1.join();
        System.out.println(t1.getState()); // TERMINATED
    }
}
