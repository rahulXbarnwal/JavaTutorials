package learnCollections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    public static void main(String[] args) {
        /*
            INSERTION METHODS

            addFirst(E e) - adds element at the front of the deque, throws exception if deque is full
            offerFirst(E e) - adds element at the front of the deque, returns false if deque is full
            addLast(E e) - adds element at the end of the deque, throws exception if deque is full
            offerLast(E e) - adds element at the end of the deque, returns false if deque is full
         */

        /*
            REMOVAL METHODS

            removeFirst() - removes and returns the first element of the deque, throws exception if deque is empty
            pollFirst() - removes and returns the first element of the deque, returns null if deque is empty
            removeLast() - removes and returns the last element of the deque, throws exception if deque is empty
            pollLast() - removes and returns the last element of the deque, returns null if deque is empty
         */

        /*
            EXAMINATION METHODS

            getFirst() - retrieves, but does not remove, the first element of the deque, throws exception if deque is empty
            peekFirst() - retrieves, but does not remove, the first element of the deque, returns null if deque is empty
            getLast() - retrieves, but does not remove, the last element of the deque, throws exception if deque is empty
            peekLast() - retrieves, but does not remove, the last element of the deque, returns null if deque is empty
         */

        /*
            STACK METHODS (Deque can be used as a stack)

            push(E e) - Adds an element at the front (equivalent to addFirst(E e)). Throws exception if deque is full
            pop() - Removes and returns the first element (equivalent to removeFirst()), throws exception if deque is empty
         */


        Deque<Integer> deque1 = new ArrayDeque<>(); // faster iteration, low memory, no null allowed
        // circular array, head and tail pointers
        // no need to shift elements, just shift head and tail pointers
        deque1.addFirst(10);
        deque1.addLast(20);
        deque1.offerFirst(5);
        deque1.offerLast(25);
        System.out.println(deque1); // [5, 10, 20, 25]

        System.out.println("First element: " + deque1.getFirst()); // 5
        System.out.println("Last element: " + deque1.getLast()); // 25
        deque1.removeFirst(); // removes 5
        deque1.pollLast(); // removes 25
        // Current Deque: [10, 20]

        for(int num: deque1) {
            System.out.println(num); // 10, 20
        }

        Deque<Integer> deque2 = new LinkedList<>(); // insertion, deletion somewhere in middle is faster, allows null elements
    }
}
