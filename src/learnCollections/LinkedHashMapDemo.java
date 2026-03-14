package learnCollections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        // uses double linked list to maintain insertion order
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(11, 0.8f, true); // initial capacity = 11, load factor = 0.8, access order = true (maintains access order instead of insertion order, by default it's false)
        linkedHashMap.put("Orange", 10);
        linkedHashMap.put("Apple", 20);
        linkedHashMap.put("Guava", 30);

        linkedHashMap.get("Apple");

        for (Map.Entry<String, Integer> entry: linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        /*
        Orange: 10
        Guava: 30
        Apple: 20
         */


        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("Shubham", 90);
        hashMap.put("Bob", 80);
        hashMap.put("Akshit", 78);

        Integer res = hashMap.getOrDefault("Rahul", 0);
        hashMap.putIfAbsent("Shubham", 92); // won't update because key already exists
        System.out.println(hashMap);
    }
}
