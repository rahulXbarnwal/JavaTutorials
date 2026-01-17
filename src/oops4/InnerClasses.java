package oops4;

public class InnerClasses {

    public static void main(String[] args) {
        // Member Inner Class
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.show();

        // Static Nested Class
        Outer1.Inner obj = new Outer1.Inner();
        obj.show();

        // Local Inner Class
        Outer2 outer2 = new Outer2();
        outer2.display();
    }
}

// Member Inner Class
// 1. Has access to all members of outer class (even private)
// 2. Cannot have static members (except constants), since inner class depends on instance and static belongs to class level
// 3. Needs an outer class object

class Outer {
    int x = 10;

    class Inner {

        void show() {
            System.out.println(x);
        }
    }
}


// Static Nested Class
// a static class inside another class

class Outer1 {
    static int x = 10;

    static class Inner {
        void show() {
            System.out.println(x);
        }
    }
}

//🔑 Key differences vs Inner Class
// Feature	                        Inner Class	                Static Nested Class
// Needs outer object	                ✅ Yes	                    ❌ No
// Access non-static members	        ✅ Yes	                    ❌ No
// Access static members	            ✅ Yes	                    ✅ Yes
// Can have static members	            ❌ No	                    ✅ Yes
// Memory efficient	                    ❌ Less	                    ✅ More


// Local Inner Class - A class declared inside a method
// scope is limited to the method
// can't be public, private, protected or static
// can access effectively final local variables

class Outer2 {
    void display() {
        int x = 19;
        // x = 20; // not effectively final

        class LocalInner {
            void show() {
                System.out.println("Hello");

                // can access only effectively final local variables
                System.out.println(x);
            }
        }

        LocalInner obj = new LocalInner();
        obj.show();
    }
}
