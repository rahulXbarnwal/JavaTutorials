package multithreading;

/*
The lifecycle of a thread in Java consists of several state, which a thread can move through during its execution

- New:              Created but not started
- Runnable:         After the start method is called, the thread becomes runnable.
                    It's ready to run & is waiting for CPU time.
- Running:          When it's executing.
- Blocked/Waiting:  When it's waiting for a resource or for another thread to perform an action.
- Terminated:       When it has finished executing.
 */

public class ThreadLifeCycle {
    public static void main(String[] args) {

        World t1 = new World(); // NEW
        t1.start(); // RUNNABLE
        System.out.println();
    }
}
