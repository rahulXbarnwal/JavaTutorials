package learnCollections;

import java.util.NavigableMap;
import java.util.TreeMap;

/*
            +----------------------+
            |      SortedMap       |
            |     (interface)      |
            +----------------------+
                      ^
                      |
                      | extends
                      |
            +----------------------+
            |    NavigableMap      |
            |     (interface)      |
            +----------------------+
                      ^
                      |
                      | implements
                      |
            +----------------------+
            |       TreeMap        |
            |        (class)       |
            +----------------------+

*/

public class NavigableMapDemo {
    public static void main(String[] args) {
        NavigableMap<Integer, String> navigableMap = new TreeMap<>();
        navigableMap.put(1, "One");
        navigableMap.put(5, "Five");
        navigableMap.put(3, "Three");

        System.out.println(navigableMap); // {1=One, 3=Three, 5=Five}

        System.out.println(navigableMap.lowerKey(4)); // returns the greatest key strictly < given key or null if there is no such key
        System.out.println(navigableMap.ceilingKey(4)); // returns the least key >= given key or null if there is no such key
        System.out.println(navigableMap.higherEntry(1)); // returns the least entry > given key or null if there is no such key
        System.out.println(navigableMap.floorEntry(2)); // returns the greatest entry <= given key or null if there is no such key
        System.out.println(navigableMap.descendingMap()); // returns a reverse order view of the mappings contained in this map
    }
}
