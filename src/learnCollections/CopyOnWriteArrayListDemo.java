package learnCollections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        // "Copy on Write" means that whenever a write operation
        // like adding or removing an element
        // instead of directly modifying the existing list
        // a new copy of the list is created, and the modification applied to that new copy.
        // This ensures that other threads reading the list while it's being modified are unaffected.

        // Read Operations: Fast and direct, since they happen on a stable list without interference from modifications.
        // Write Operations: A new copy of the list is created for every modification.
        //                   The reference to the list is updated to point to the new copy so that subsequent read operations use this new list.

        // read intensive scenarios


        // List<String> shoppingList = new ArrayList<>();
        List<String> shoppingList = new CopyOnWriteArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Eggs");
        shoppingList.add("Bread");
        System.out.println("Initial shopping list: " + shoppingList);
        
        for(String item : shoppingList) {
            System.out.println(item);
            // Try to modify the list while reading
            if(item.equals("Eggs")) {
                shoppingList.add("Butter"); // This will cause ConcurrentModificationException
                System.out.println("Added Butter while reading");
            }
        }
        // purani = new
        System.out.println("Updated shopping list: " + shoppingList); // [Milk, Eggs, Bread, Butter]



        List<String> sharedList = new CopyOnWriteArrayList<>();
        sharedList.add("Item 1");
        sharedList.add("Item 2");
        sharedList.add("Item 3");

        Thread readerThread = new Thread(() -> {
            try {
                while(true) {
                    // Iterate through the list
                    for (String item: sharedList) {
                        System.out.println("Reading item: " + item);
                        Thread.sleep(100); // Small delay to simulate work
                    }
                }
            } catch (Exception e) {
                System.out.println("Exception in reader thread: " + e);
            }
        });

        Thread writerThread = new Thread(() -> {
            try {
                while(true) {
                    Thread.sleep(500); // Delay to allow reading to start first
                    sharedList.add("Item 4");
                    System.out.println("Added Item 4 to the list");

                    Thread.sleep(500);
                    sharedList.remove("Item 1");
                    System.out.println("Removed Item 1 from the list");
                }
            } catch (Exception e) {
                System.out.println("Exception in writer thread: " + e);
            }
        });

        readerThread.start();
        writerThread.start();
    }
}
