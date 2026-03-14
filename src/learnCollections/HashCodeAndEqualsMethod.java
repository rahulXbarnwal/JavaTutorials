package learnCollections;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeAndEqualsMethod {
    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();
        Person p1 = new Person("Alice", 1);
        Person p2 = new Person("Bob", 2);
        Person p3 = new Person("Alice", 1); // same content as p1 but different object -> diff memory -> diff hashcode
        
        map.put(p1, "Engineer"); // hashcode1 --> index1
        map.put(p2, "Designer"); // hashcode2 --> index2
        map.put(p3, "Manager");  // hashcode3 --> index3

        System.out.println("HashMap Size: " + map.size()); // 3 because p1 and p3 are different objects (different hashcodes) even though they have same content
        System.out.println("Value for p1: " + map.get(p1)); // Engineer
        System.out.println("Value for p3: " + map.get(p3)); // Manager

        // After overriding equals() and hashCode() in Person class, p1 and p3 are considered equal (same content) and will have same hashcode, so p3 will replace p1's value in the map
        // HashMap Size: 2
        // Value for p1: Manager
        // Value for p3: Manager


        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Shubham", 90); // hashcode1 --> index1
        map1.put("Neha", 92);    // hashcode2 --> index2
        map1.put("Shubham", 99); // hashcode1 --> index1 --> equals() --> replace
    }
}

class Person {
    String name;
    int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return id == person.getId() && Objects.equals(name, person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name;
    }
}
