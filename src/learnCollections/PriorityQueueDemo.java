package learnCollections;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        // Part of the Queue interface
        // order elements based on their natural ordering (for primitives lowest first)
        // custom comparator for customized ordering
        // does not allow null elements

        // min-heap by default
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(15);
        pq.add(10);
        pq.add(30);
        pq.add(5);

        while(!pq.isEmpty()) {
            System.out.println(pq.poll()); // 5, 10, 15, 30
        }

        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder()); // max-heap

        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> a - b); // min-heap using lambda expression
        PriorityQueue<Integer> pq3 = new PriorityQueue<>((a, b) -> b - a); // max-heap using lambda expression
    }
}
