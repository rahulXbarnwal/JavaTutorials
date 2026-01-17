package oops4;

public class LearnInterfaces {

    public static void main(String[] args) {
        Monkey monkey = new Monkey();
        monkey.eats();
        monkey.drinks();

//        Animal.LEGS = 5; // can't do, since its final

        System.out.println(Animal.LEGS);
    }
}

interface Pet {

    void sings();
    void drinks();
}

interface Animal {

    // can define only those fields inside interface which are public, static and final

//    public static final int LEGS=4;
    int LEGS=4;

    // Modifier 'abstract' is redundant for interface methods
    // since methods are by default abstract for interfaces

    // public is also redundant since it has to be accessible inside the inheriting class
    // so keep it default
//    public abstract void eats();

    void eats();
    void drinks();

    // default implementation -> can be overridden
    default void walk() {
        System.out.println("Animal is walking");
    }
}

// a class can implement 2 interfaces even if they have same methods
// because implementing class will have to provide the implementation of that function
// so it will not create a deadlock like which interface's function to call

// but this is not possible when extending 2 classes, i.e. multiple inheritance is not possible

class Monkey implements Animal, Pet {


    @Override
    public void eats() {
        System.out.println("Monkey is eating");
    }

    @Override
    public void sings() {
        System.out.println("Monkey is singing");
    }

    public void drinks() {
        System.out.println("Monkey is drinking");
    }
}