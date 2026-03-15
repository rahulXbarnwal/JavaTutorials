package learnCollections;

import java.util.SortedMap;
import java.util.TreeMap;

/*
SortedMap is an Interface that extends Map and guarantees that the entries are sorted based on the keys, either in their natural ordering or by a specified Comparator.

HashMap uses an array of buckets with linked lists / trees, while TreeMap is implemented as a self-balancing Red-Black Tree without any bucket array
 */

public class SortedMapDemo {
    public static void main(String[] args) {
        // Key (Integer) implements Comparable, so it will be sorted in natural order (numerical)
        // else we can pass custom comparator to the TreeMap constructor
        SortedMap<Integer, String> map = new TreeMap<>();
        map.put(91, "Vivek");
        map.put(99, "Shubham");
        map.put(78, "Mohit");
        map.put(77, "Vipul");
        // map.put(null, "Rahul"); // null keys are not allowed in TreeMap, it will throw NullPointerException

        System.out.println(map); // {77=Vipul, 78=Mohit, 91=Vivek, 99=Shubham}

        System.out.println(map.firstKey());    // 77
        System.out.println(map.lastKey());     // 99
        System.out.println(map.headMap(91));   // {77=Vipul, 78=Mohit} -> exclude 91
        System.out.println(map.tailMap(91));   // {91=Vivek, 99=Shubham} -> include 91


        // For keys in descending order
        SortedMap<Integer, String> map1 = new TreeMap<>((a, b) -> b - a);
    }
}
