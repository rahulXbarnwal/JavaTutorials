package learnCollections;

import java.lang.ref.WeakReference;

public class GarbageCollection {
    public static void main(String[] args) {
        Phone phone = new Phone("Apple", "16 pro max"); // strong reference to the phone object, until we set phone to null, the phone object will not be eligible for garbage collection
        System.out.println(phone);

        phone = null;
        System.out.println(phone); // null
        // JVM will automatically call garbage collector to free up memory occupied by the phone object, but we can't predict when it will happen


        WeakReference<Phone> phoneWeakReference = new WeakReference<>(new Phone("Samsung", "S23 Ultra"));
        System.out.println(phoneWeakReference.get()); // Phone{brand='Samsung', model='S23 Ultra'}
        System.gc(); // request JVM to run garbage collector, but it's not guaranteed that it will run immediately

        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            
        }

        System.out.println(phoneWeakReference.get()); // null
    }
}

class Phone {
    String brand;
    String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
