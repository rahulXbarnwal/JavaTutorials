package oops2;

// properties and behavior both will get inherited on extending

// When a class extends another class, it inherits all non-private fields and methods of the parent class, but constructors and private members are not inherited.
// Static methods are not truly inherited, they are hidden.
public class Car extends Vehicle {

    String color;

    void start() {
        System.out.println(this); // oops2.Car@5b2133b1
        System.out.println(this.model + " Car is starting");
    }

    Car () {
        super(4);
        System.out.println("Car is being created");
    }

    public static void main(String[] args) {

        Car obj = new Car();
        obj.wheelsCount = 4;
        obj.model = "I10";
        obj.color = "Red";
        obj.start();
    }
}

// every class in java extends Object Class
// when in multiple inheritance lets say A <-- B <-- C
// if C.start(), then it will check it in C first, if not present then B else A
// multilevel is possible, multiple inheritance is not

