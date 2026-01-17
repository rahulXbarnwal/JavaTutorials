package pets;

import animals.Animal;

public class Dog extends Animal {

    public Dog() {
        // If you do not explicitly write super() or this() inside a subclass constructor,
        // Java automatically inserts super().
        super(); // ✅ protected constructor accessible via inheritance
        System.out.println("Dog constructor");
    }

    public void test() {

        // ✅ protected method via inheritance
        eat();
        this.eat();

        // ❌ NOT allowed: protected constructor via object creation
        // Animal a1 = new Animal();

        // ❌ NOT allowed: protected method via superclass reference
        // Animal a2 = this;
        // a2.eat();

        // ✅ allowed: access via subclass reference
        Dog d = this;
        d.eat();
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.test();

//        Output:
//        Animal constructor
//        Dog constructor
//        Animal is eating
//        Animal is eating
//        Animal is eating

//        *V.IMP* -> In a different package, protected members are accessible only through inheritance,
//        not through a superclass reference or object creation.

//        1. Java does NOT match constructors by parameter count automatically
//        Having a 1-param constructor in subclass does NOT mean Java will call the 1-param constructor in superclass.

//        2. Constructor chaining must be explicit when parameters exist
//        3. super(param) must be the first statement

//        TLDR: If a superclass has only parameterized constructors, the subclass must explicitly call super(arguments);
//        otherwise, compilation fails.

//        If the superclass has a no-argument constructor, Java automatically inserts super()
//        even if the subclass constructor has parameters.

//        A constructor may contain EXACTLY ONE constructor call (this() OR super()),
//        and it must be the FIRST line.
    }
}
