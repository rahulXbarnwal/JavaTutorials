package learnCollections;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

/*
Set is a collection that can't contain duplicate elements.
Faster operations
Map -> HashMap, LinkediHashMap, TreeMap, EnumMap
Set -> HashSet, LinkedHashSet, TreeSet, EnumSet
 */

public class SetOverview {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(12);
        set.add(1);
        set.add(1);
        set.add(67);
        System.out.println(set); // [1, 67, 12] - no duplicates, order is not guaranteed


        // if wanna maintain insertion order, use LinkedHashSet
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(12);
        linkedHashSet.add(1);
        linkedHashSet.add(1);
        linkedHashSet.add(67);
        System.out.println(linkedHashSet); // [12, 1, 67] - no duplicates, maintains insertion order


        // if wanna maintain natural order, use TreeSet
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(12);
        treeSet.add(1);
        treeSet.add(1);
        treeSet.add(67);
        System.out.println(treeSet); // [1, 12, 67] - no duplicates, maintains natural order


        NavigableSet<Integer> navigableSet = new TreeSet<>();
        navigableSet.add(12);
        navigableSet.add(1);
        navigableSet.add(1);
        navigableSet.add(67);
        System.out.println(navigableSet.contains(67)); // true
        System.out.println(navigableSet.higher(1)); // returns the least element strictly > than the given element, or null if there is no such element. Output: 12
        System.out.println(navigableSet.lower(12)); // returns the greatest element strictly < than the given element, or null if there is no such element. Output: 1
        System.out.println(navigableSet.ceiling(1)); // returns the least element >= than the given element, or null if there is no such element. Output: 1
        System.out.println(navigableSet.floor(12)); // returns the greatest element <= than the given element, or null if there is no such element. Output: 12
        navigableSet.clear(); // removes all elements from the set


        // for thread safety
        Set<Integer> integers = Collections.synchronizedSet(set); // not recommended for concurrent access, better to use ConcurrentSkipListSet
        Set<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();

        // unmodifiable set
        Set<Integer> unmodifiableSet = Set.of(1, 2, 3, 4); // > 10 entries allowed unlike Map.of()
        Collections.unmodifiableSet(treeSet); // creates an unmodifiable view of the original set
    }
}
