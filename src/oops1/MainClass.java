package oops1;

// only one class with the name of the file, will be public, rest will be non-public
// code execution will only start from main method of public class

public class MainClass {
    public static void main(String[] args) {

        Dog d1 = new Dog();
        d1.name = "Tommy";
        d1.bark();
        d1.walk();

        Dog d2 = new Dog();
        d2.name = "Leo";
        d2.walk();
    }
}

class Dog {
    String name;
    int age;
    String color;

    void walk () {
        System.out.println(name + " is walking");
    }

    void bark() {
        System.out.println(name + " is barking");
    }
}
