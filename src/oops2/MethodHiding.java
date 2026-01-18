package oops2;

// static variables and methods get inherited,
// but they do not behave like normal overridden methods

// static variables is accessible in child

class Parent {
    static int x = 20;

    static void staticMethod() {
        System.out.println("Parent static");
    }

    void instanceMethod() {
        System.out.println("Parent instance");
    }
}

// static methods are accessible in child
class Child extends Parent {

}

// static methods can't be overridden
// since overriding is run time polymorphism
// static methods belongs to class , not object
// static binding happens at compile time
class Child2 extends Parent {
    static void staticMethod() {
        System.out.println("Child2 static");
    }

    @Override
    void instanceMethod() {
        System.out.println("Child2 instance");
    }
}

public class MethodHiding {
    public static void main(String[] args) {
        System.out.println(Child.x); // 20
        Child.staticMethod(); // Parent static

        Parent p = new Child2();
        p.staticMethod(); // Parent static
        p.instanceMethod(); // Child2 instance

        // because static methods are resolved using ref type, not object type
        // Ref type = parent
        // so Parent.show()
        // this is method hiding
    }
}
