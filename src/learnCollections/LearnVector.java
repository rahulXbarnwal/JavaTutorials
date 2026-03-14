package learnCollections;

import java.util.LinkedList;
import java.util.Vector;

/*
Synchronized: Vector is synchronized, which means that it is thread-safe.

However, due to its synchronization overhead, it's generally recommended to use other modern alternatives like ArrayList in single-threaded scenarions.
Despite this, Vector is still useful in certain situations, particularly in multi-threaded environments where thread safety is a concern.

Constructors of Vector:
1. Vector(): Creates a vector with an initial capacity of 10 and a capacity increment of 0. This means that when the vector needs to grow, it will double its capacity.
2. Vector(int initialCapacity): Creates an empty vector with the specified initial capacity.
3. Vector(int initialCapacity, int capacityIncrement): Creates a vector with an initial capacity and capacity increment (how much the vector should grow when its capacity is exceeded).
4. Vector(Collection<? extends E> c): Creates a vector containing the elements of the specified collection.
 */

public class LearnVector {
    public static void main(String[] args) {
        Vector <Integer> vector = new Vector<>(5, 3); // initial capacity = 5, capacity increment = 3
        
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        Vector<Integer> vector1 = new Vector<>(linkedList);
        System.out.println(vector1); // [1, 2, 3]

        linkedList.clear();
        System.out.println(linkedList); // []

        vector1.clear();
        System.out.println(vector1); // []
    }
}
