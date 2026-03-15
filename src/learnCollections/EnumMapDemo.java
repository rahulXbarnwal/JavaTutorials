package learnCollections;

import java.util.EnumMap;
import java.util.Map;

/*
- if all the keys in Map are values of a single enum, it's recommended to use EnumMap. It has advantage of knowing all possible keys in advance 
- it is more efficient compared to other implementations, as it internally uses a simple array
 */

public class EnumMapDemo {
    public static void main(String[] args) {
        // array of size same as enum
        // [_, "Gym", _, _, _, _, _]
        // no hashing
        // ordinal / index is used
        // faster than HashMap
        // memory efficient
        // ordered by enum declaration order
        Map<Day, String> map = new EnumMap<>(Day.class);
        map.put(Day.TUESDAY, "Gym");
        map.put(Day.MONDAY, "Walk");
        System.out.println(map); // {MONDAY=Walk, TUESDAY=Gym}

        System.out.println(Day.TUESDAY.ordinal()); // 1 --> index
    }
}

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
