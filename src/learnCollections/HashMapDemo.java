package learnCollections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
- Unordered: Doesn't mantain any order of its elements.
- Allows null Keys and Values: Can have one null key and multiple null values.
- Not Synchronized: Not thread-safe, requires external synchronization if used in multi-threaded context.
- Performance: Offers constant-time performance O(1) for basic operations like get and put, assuming the hash function disperses elements properly.
 */


/*
Basic Components of HashMap:

1. Key: The identifier used to retrieve the value
2. Value: The data associated with the key
3. Bucket: A place where key-value pairs are stored. Think of buckets as cells in a list (array)
4. Hash Function: Converts a key into an index (bucket location) for storage

A hash function is an algo that takes an input (or "key") and returns a fixed-size string of bytes, typically a numerical value.
The output is known as a hash code, hash value, or simply hash. 
The primary purpose of a hash function is to map data of arbitrary size to data of fixed size.

- Deterministic: Same i/p will always produce the same o/p
- Fixed o/p size: Regardless of i/p size, hash code has a consistent size (e.g., 32 or 64 bits)
- Efficient Computation: Hash function should compute the hash quickly
*/


/*
How Data is Stored in HashMap:

1. Hashing the Key:
    - First the key is passed through a hash function to generate a unique hash code (integer).
    - This hash code helps determine where the key-value pair will be stored in the array (called a "bucket array").

2. Calculating the Index:
    - The hash code is then used to calculate an index in the array (bucket location) using
        int index = hashCode % arraySize
    - The index decides which bucket will hold this key-value pair.

    For example, if the hash code is 12345 and the array size is 16, the index would be:
        index = 12345 % 16 = 9

3. Storing in the Bucket:
    - The key-value pair is stored in the bucket at the calculated index. Each bucket can hold multiple key-value pairs (this is called a collision handling mechanism)
 */


/*
How HashMap Retrieves Data:

When we call get(key), the HashMap follows these steps:

1. Hashing the Key: 
    - Similar to insertion, the key is hashed using the same hash function to calculate its hash code

2. Finding the Index: 
    - The hash code is used to find the index in the bucket array where the key-value pair is stored

3. Searching in the Bucket:
    - Once the correct bucket is found, it checks for the key in that bucket. If it finds the key, it returns the associated value
 */


/*
+-----+-----+-----+-----+-----+
|  0  |  1  |  2  |  3  |  4  |
+-----+-----+-----+-----+-----+
                    |
                    v
               +-----------+
               | (k1, v1)  |
               +-----------+
                    |
                    v
               +-----------+
               | (k2, v2)  |
               +-----------+
                    |
                    v
                  null


class Node<K, V> {
    final int hash;   // hash code of the key
    final K key;      // the key itself
    V value;          // the value associated with the key
    Node<K, V> next;  // pointer to the next node in case of a collision (linked list)
}


This searching in linked list is O(n) time complexity in worst case (when all keys hash to the same bucket). 
To mitigate this, Java 8 introduced a Balanced BST (Red-Black Tree - Self balancing BST) -> O(log n).
TREEIFY_THRESHOLD = 8 (when a bucket has more than 8 entries, it converts the linked list to a tree for better performance)
 */


/*
HashMap Resizing (Rehashing):

- HashMap has an internal array size, which by default is 16.
  When the no. of elements (key-value pairs) exceeds a certain threshold (load factor, default is 0.75), the HashMap automatically resizes the array to hold more data. This process is called rehashing.

- The default size of the array is 16, so when more than 12 elements (16 * 0.75) are inserted, the HashMap will resize.

During Rehashing:
- The array size is doubled.
  1. All existing entries are rehashed (i.e. their positions are recalculated) and placed into the new array
  2. This ensures the HashMap continues to perform efficiently even as more data is added
 */

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>(17, 0.5f); // initial capacity = 17, load factor = 0.5
        map.put(3, "Prateek");
        map.put(1, "Rahul");
        map.put(2, "Mayank");
        System.out.println(map); // {1=Rahul, 2=Mayank, 3=Prateek}

        String student = map.get(3);
        System.out.println(student); // Prateek

        String s = map.get(69);
        System.out.println(s); // null

        System.out.println(map.containsKey(2));
        System.out.println(map.containsValue("Rahul"));

        // Set<Integer> keys = map.keySet();
        for (int i : map.keySet()) {
            System.out.println(map.get(i));
        }


        Set<Map.Entry<Integer, String>> entries = map.entrySet();

        for (Map.Entry<Integer, String> entry: entries) {
            // System.out.println(entry.getKey() + ": " + entry.getValue());
            entry.setValue(entry.getValue().toUpperCase());
        }
        
        System.out.println(map); // {1=RAHUL, 2=MAYANK, 3=PRATEEK}


        boolean res = map.remove(3, "Ravi"); // won't remove because value doesn't match
        System.out.println("REMOVED ? " + res); // REMOVED ? false

        res = map.remove(3, "PRATEEK"); // will remove because value matches
        System.out.println("REMOVED ? " + res); // REMOVED ? true

        System.out.println(map); // {1=RAHUL, 2=MAYANK}
    }
}
