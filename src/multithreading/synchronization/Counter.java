package multithreading.synchronization;

public class Counter {
    private int count = 0;

//    public synchronized void increment() {
    public void increment() {

        // this ka matlab hai ki yha ek instance ki baat krrhe hai
        // ek instance jispe increment method call ho rha hai
        // agar usko multiple threads access krrhe hai to ek baar me ek hi thread access kr payega
        synchronized (this) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
