package oops4;


// No constructor
// No name
// Used for short implementations
// Replaced mostly by Lambda expressions

public class LearnAnonymousClasses {

    // this obj is of the anonymous subclass
    OuterClass obj = new OuterClass() {
        void sing() {

        }

        public void outerMethod() {

        }
    };

    // object of anonymous class implementing SuperInterface
    SuperInterface obj2 = new SuperInterface() {
        @Override
        public void interfaceMethod() {

        }
    };

    // creation of object of anonymous class implementing functional interface
    // using lambda functions / expressions
    SuperInterface obj3 = () -> {

    };

}


class OuterClass {

    public void outerMethod() {

    }
}

@FunctionalInterface
interface SuperInterface {

    void interfaceMethod();
}