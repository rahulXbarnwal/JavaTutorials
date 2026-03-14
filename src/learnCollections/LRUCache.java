package learnCollections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int capacity;

    LRUCache (int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    // invoke when put or putAll is called
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> studentMap = new LRUCache<>(3);
        studentMap.put("Bob", 99);
        studentMap.put("Alice", 89);
        studentMap.put("Ram", 91);
        studentMap.get("Bob");
        studentMap.put("Rahul", 89);

        System.out.println(studentMap); // {Ram=91, Bob=99, Rahul=89}
    }
}
