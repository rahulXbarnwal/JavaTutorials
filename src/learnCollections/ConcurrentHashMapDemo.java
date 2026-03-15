package learnCollections;

import java.util.concurrent.ConcurrentHashMap;

/*
                    ConcurrentHashMap
                           |
   ---------------------------------------------------------
   |        |        |        |        |        |        |
 Segment0 Segment1 Segment2 Segment3 Segment4 Segment5 Segment6
   |        |        |        |        |        |        |
 HashMap  HashMap  HashMap  HashMap  HashMap  HashMap  HashMap


- 16 segments by default
- Does not guarantee any ordering of keys

CASE 1: Two threads writing to different segments

            KeyA.hash → Segment3
            KeyB.hash → Segment10

            Thread A → put(KeyA)
            Thread B → put(KeyB)

            KeyA → Segment3
            KeyB → Segment10


            Thread A
              |
              v
            Segment3 (LOCK)
              |
              v
            HashMap


            Thread B
              |
              v
            Segment10 (LOCK)
              |
              v
            HashMap

            Segment3 lock ≠ Segment10 lock

            Thread A and Thread B run simultaneously


CASE 2: Two threads writing to the same segment

            KeyA.hash → Segment3
            KeyB.hash → Segment3

            Thread A → put(KeyA)
            Thread B → put(KeyB)

            KeyA → Segment3
            KeyB → Segment3

            Thread A
              |
              v
            Segment3 (LOCK ACQUIRED)
              |
              v
            HashMap

            Thread B
              |
              v
            Segment3 (WAITING FOR LOCK)

            Thread B must wait until Thread A releases lock
 */


            
/*
        Map                         | Thread-safe | Sorted
        --------------------------------------------------
        HashMap                     | No          | No
        ConcurrentHashMap           | Yes         | No
        TreeMap                     | No          | Yes
        ConcurrentSkipListMap       | Yes         | Yes
*/

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        // Java 7 --> segment based locking --> 16 segments --> smaller hashmaps
        // Only the segment being written to or read from is locked
        // read: do not require locking unless there is a write operation happening on the same segment
        // write: lock

        // Java 8 --> no segmentation
        //        --> Compare-And-Swap approach --> no locking except resizing or collision
        // Thread A last saw --> x = 42
        // Thread A work --> x to 50
        // if x is still 42, then change it to 50, else don't change and retry
    }
}
