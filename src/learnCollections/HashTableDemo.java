package learnCollections;

import java.util.Hashtable;

public class HashTableDemo {
    public static void main(String[] args) {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        // Hashtable is synchronized
        // no null key or value
        // Legacy class, replaced by ConcurrentHashMap
        // slower than HashMap
        // only linked list in case of collision, no tree structure like in HashMap
        // all methods are synchronized
        hashtable.put(1, "One");
        hashtable.put(2, "Two");
        hashtable.put(3, "Three");

        System.out.println(hashtable);
        System.out.println(hashtable.get(2)); // Two
        System.out.println(hashtable.containsKey(3)); // true
        hashtable.remove(1);
        System.out.println(hashtable); // {2=Two, 3=Three}

        // hashtable.put(null, "value"); // throws NullPointerException
        // hashtable.put(4, null); // throws NullPointerException



        // HashMap<Integer, String> map = new HashMap<>();
        Hashtable<Integer, String> map = new Hashtable<>();

        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 1000; i++) {
                map.put(i, "Thread 1");
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 1000; i < 2000; i++) {
                map.put(i, "Thread 2");
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final size: " + map.size()); // Final size: 2000, no data corruption due to synchronization
    }
}
