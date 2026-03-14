package learnCollections;

import java.util.Arrays;
import java.util.LinkedList;

/*
The LinkedList class in Java is a part of the Java Collections Framework and implements the List interface. 
Unlike an ArrayList, which is backed by a dynamic array, a LinkedList is implemented as a doubly linked list.
This provides different performance characteristics compared to an ArrayList, especially when it comes to adding and removing elements.

A LinkedList is a linear DS where each element is a separate object, called a node. Each node contains two parts:
1. Data: The actual data stored in the node.
2. Pointers: Two pointers, one pointing to the next node (next) and another pointing to the previous node (prev) in the list.

LinkedList has different performance characteristics compared to an ArrayList:
- Insertion and Deletion: LinkedList is better for frequent insertions and deletions in the middle of the list because it does not require shifting elements like an ArrayList.
- Random Access: LinkedList has slower random access (get(int index)) compared to an ArrayList because it has to traverse the list from the beginning or end to reach the desired index.
- Memory Overhead: LinkedList uses more memory than an ArrayList because each node in a LinkedList requires extra memory to store references to the next and previous nodes.
 */

class Node {
    public int value;
    public Node next;
}

public class LearnLinkedList {
    public static void main(String[] args) {
        /*
        Node node1 = new Node();
        Node node2 = new Node();
        node1.value = 1;
        node2.value = 2;
        node1.next = node2;
        node2.next = null;
        */

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.get(2); // O(n)
        linkedList.addLast(4); // O(1)
        linkedList.addFirst(0); // O(1)

        linkedList.getFirst(); // O(1)
        linkedList.getLast(); // O(1)

        System.out.println(linkedList);
        linkedList.removeIf(x -> x % 2 == 0);
        System.out.println(linkedList);

        LinkedList<String> animals = new LinkedList<>(Arrays.asList("Cat", "Dog", "Elephant"));
        LinkedList<String> animalsToRemove = new LinkedList<>(Arrays.asList("Dog", "Lion"));
        animals.removeAll(animalsToRemove);
        System.out.println(animals); // [Cat, Elephant]
    }
}
