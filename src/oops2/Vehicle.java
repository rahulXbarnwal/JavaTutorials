package oops2;

public class Vehicle {

    int wheelsCount;
    String model;

    void start() {
        System.out.println("Vehicle is starting");
    }

    Vehicle() {
        System.out.println("Creating a vehicle instance");
    }

    Vehicle(int wheelsCount) {
        this.wheelsCount = wheelsCount;
        System.out.println("Creating vehicle with wheels");
    }

//    a constructor can't have a return type
//    if you add a return type, java treats it as normal method, not a constructor
//    void Vehicle() {
//        System.out.println("bye");
//    }

//    valid constructor
//    Vehicle() {
//        System.out.println("This is constructor");
//    }


//    constructors can have access modifier -> public, protected, default, private

//    public constructor -> object can be created from anywhere
//    public Vehicle() {}

//    default (package-private) -> object can be created only within same package
//    Vehicle() {}

//    protected constructor
//    ✔ Same package
//    ✔ Subclasses in other packages
//    ❌ Other classes
//    protected Vehicle() {}

//    private constructor
//    ❌ Cannot create object using new from outside
//    Used for: Singleton pattern, Utility classes, Factory methods
//    private Vehicle() {}

//    Constructor can't be final, static or abstract
//    why not final -> cannot override (constructors are not inherited)
//    why not static -> constructor belongs to object not a class
//    why not abstract -> constructor must have a body
}
