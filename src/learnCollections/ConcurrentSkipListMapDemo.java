package learnCollections;

import java.util.concurrent.ConcurrentSkipListMap;

/*
ConcurrentSkipListMap:
- stores key in sorted order
- thread safe / synchronized

SkipList:
- probabilistic data structure that allows for efficient search, insertion, and deletion operations
- it's similar to a sorted linked list but with multiple layers that "skip" over elements to provide faster access to elements
*/

public class ConcurrentSkipListMapDemo {
    public static void main(String[] args) {
        ConcurrentSkipListMap<String, Integer> map = new ConcurrentSkipListMap<>();
    }
}
