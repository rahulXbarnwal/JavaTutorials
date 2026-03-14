package learnCollections;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {
    public static void main(String[] args) {
        String key1 = new String("key");
        String key2 = new String("key");

        Map<String, Integer> map = new HashMap<>();
        // hashcode and equals
        map.put(key1, 1); // hashcode1 --> index1
        map.put(key2, 2); // hashcode1 --> index1 --> equals() --> replace value of key with 2
        System.out.println(key1.equals(key2));
        System.out.println(map);


        // whether the class has overridden equals() and hashCode() or not, in IdentityHashMap, object class hashcode will be used which is based on memory address
        // hence object hashcode will be considered for key1 and key2, which will be different
        Map<String, Integer> identityMap = new IdentityHashMap<>();
        System.out.println(System.identityHashCode(key1)); // 292938459
        System.out.println(System.identityHashCode(key2)); // 917142466

        System.out.println(key1.hashCode()); // 106079
        System.out.println(key2.hashCode()); // 106079

        // IdentityHashcode and ==
        identityMap.put(key1, 1); // key1 --> index1
        identityMap.put(key2, 2); // key2 --> index2 (different from key1)
        System.out.println(identityMap); // {key=2, key=1}
    }
}
