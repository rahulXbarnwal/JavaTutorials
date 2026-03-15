package learnCollections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = Collections.unmodifiableMap(map1); // creates an immutable view of the original map
        System.out.println(map2);
        map2.put("C", 3); // throws UnsupportedOperationException

        // returns an unmodifiable map containing 2 mappings - since Java 9
        // limited to 10 (k, v) pairs
        Map<String, Integer> map3 = Map.of("Shubham", 98, "Vivek", 89);
        map3.put("Rahul", 88); // throws UnsupportedOperationException

        // if want > 10 (k, v) pairs, we can use Map.ofEntries() method, also unmodifiable
        Map<String, Integer> map4 = Map.ofEntries(
                Map.entry("Shubham", 98),
                Map.entry("Vivek", 89)
        );
    }
}
