package multithreading;

/*
1. CPU -> Brain of the computer.
   Responsible for executing instructions from programs.
   Performs basic arithmetic, logic, control, and I/O operations specified by instructions.

2. Core -> An individual processing unit within a CPU.
   Modern CPUs can have multiple cores, allowing them to perform multiple tasks simultaneously.

3. A quad-core processor has four cores, allowing it to perform 4 tasks simultaneously.
   Example: One core may handle a web browser, another music player, another a download manager,
   and another a background system update.

4. Program -> A set of instructions written in a programming language that tells the computer
   how to perform a specific task.
   Example: MS Word is a program used to create and edit documents.

5. Process -> An instance of a program that is being executed.
   When a program runs, the OS creates a process to manage its execution.
   Example: When we open MS Word, it becomes a process in the OS.

6. Thread -> The smallest unit of execution within a process.
   A process can have multiple threads which share the same resources but run independently.
   Example: A browser like Chrome uses multiple threads for different tabs.

7. Multitasking -> Allows an OS to run multiple processes simultaneously.
   - In single-core CPUs, this is achieved using time-sharing.
   - In multi-core CPUs, true parallel execution happens.
   - The OS scheduler manages and balances tasks for efficient performance.
   Example: Browsing the internet while listening to music and downloading a file.

8. Multitasking utilizes the CPU and its cores efficiently.
   The OS can assign different tasks to different cores, which is more efficient
   than executing everything on a single core.

9. Multithreading -> Ability to execute multiple threads within a single process concurrently.
   Example: A browser uses multiple threads for rendering pages, running JavaScript,
   and handling user input.

10. Multithreading improves multitasking by dividing tasks into smaller threads.
    These threads can execute simultaneously, improving CPU utilization.

11. In a single-core system:
    - Threads and processes are managed using time slicing and context switching
      to simulate parallel execution.

    In a multi-core system:
    - Threads and processes can run truly in parallel on different cores.
    - The OS scheduler distributes tasks efficiently across cores.

12. Time Slicing
    - Definition: Time Slicing divides CPU time into small intervals called time slices or quanta.
    - Function: The OS Scheduler allocates these time slices to different processes and threads, ensuring each gets a fair share of CPU time.
    - Purpose: This prevents any single process or thread from monopolizing CPU, improving responsiveness & enabling concurrent execution.

13. Context Switching
    - Definition: Process of saving the state of a currently running process/thread and loading the state of next one to be executed.
    - Function: When a process/thread's time slice expires, OS scheduler performs a context switch to move the CPU's focus to another process/thread.
    - Purpose: Allows multiple processes/threads to share CPU, giving appearance of simultaneous execution on single-core CPU or improving parallelism on multi-core CPUs.

14. Multitasking can be achieved through multithreading where each task is divided into threads that are managed concurrently.
    While multitasking typically refers to thr running of multiple apps, multithreading is more granular dealing with multiple threads within the same app/process

15. Multitasking operates at the level of processes, which are the OS's primary units of execution.
    Multithreading operates at the level of threads, which are smaller units within a process.

16. Multitasking involves managing resources b/w completely separate programs, which may have independent memory spaces and system resources.
    Multithreading involves managing resources within a single program, where threads share the same memory & resources

17. Multitasking allows us to run multiple applications simultaneously, improving productivity & system utilization.
    Multithreading allows a single app to perform multiple tasks at same time, improving app performance & responsiveness.
*/

/*
1. In Java, Multithreading is the concurrent execution of two/more threads to maximize the utilization of CPU.
   Java's multithreading capabilities are part of the java.lang package, making it easy to implement concurrent execution.

2. In a single-core env, Java's Multithreading is managed by JVM & OS, which switch b/w threads to give illusion of concurrency.
   The threads share the single core, and time-slicing is used to manage thread execution

3. In a multi-core env, Java's multithreading can take full advantage of the available cores.
   The JVM can distribute threads across multiple cores, allowing true parallel execution of threads

4. A thread is a lightweight process, the smallest unit of processing.
   Java supports multithreading through its
   - java.lang.Thread class
   - java.lang.Runnable interface

5. When a Java program starts, one thread begins running immediately, which is called main thread.
   This thread is responsible for executing the main method of a program.

6. To create a new thread in Java, you can either
   - extend the Thread class
              OR
   - implement the Runnable interface
 */

/*
1. By extending the Thread class:
    - A new class World is created that extends Thread
    - The run method is overridden to define the code that constitutes the new thread.
    - start method is called to initiate the new thread

2. By implementing Runnable Interface
    - A new class World2 is created that implements Runnable
    - The run method is overridden to define the code that constitutes the new thread.
    - A Thread object is created by passing an instance of World2
    - start method is called on the Thread object to initiate the new thread.

In both cases, the run method contains the code that will be executed in the new thread
 */


public class LearnMultithreading {
    public static void main(String[] args) {

//        World world = new World();
//        world.start();

        World2 world2 = new World2();
        Thread t1 = new Thread(world2);
        t1.start();

        for(; ;) {
            System.out.println("Hello");
        }
    }
}
