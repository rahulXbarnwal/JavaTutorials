package learnCollections;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/*
                 Queue (Interface)

                      FIFO
               (First In First Out)

        +----------------------------------+
        |           Queue Ops              |
        |                                  |
        |  enqueue                         |
        |  dequeue                         |
        |  peek                            |
        +----------------------------------+

                ↓ Equivalent Methods

        enqueue  →  add() / offer()
        dequeue  →  remove() / poll()
        peek     →  element() / peek()


        +----------------------------------+
        |        Queue Implementations     |
        |                                  |
        |  LinkedList                      |
        |  PriorityQueue                   |
        +----------------------------------+

*/

public class QueueDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1); // enqueue
        list.addLast(2); // enqueue
        list.addLast(3); // enqueue
        System.out.println(list);

        Integer i = list.removeFirst(); // dequeue
        System.out.println(list); // [2, 3]
        list.getFirst(); // peek


        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue); // [1, 2, 3]

        Integer j = queue.remove(); // dequeue
        System.out.println(queue); // [2, 3]
        queue.peek(); // peek


        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        System.out.println(q.size()); 

        System.out.println(q.remove()); // throws exception if queue is empty
        System.out.println(q.poll()); // returns null if queue is empty

        // System.out.println(q.element()); // throws exception if queue is empty
        System.out.println(q.peek()); // returns null if queue is empty


        Queue <Integer> queue2 = new ArrayBlockingQueue<>(2); // capacity of 2
        System.out.println(queue2.add(1)); // true
        System.out.println(queue2.offer(2)); // true

        System.out.println(queue2.add(3)); // throws IllegalStateException: Queue full
        System.out.println(queue2.offer(3)); // returns false if queue is full
    }
}
