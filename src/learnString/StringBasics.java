package learnString;

public class StringBasics {
    public static void main(String[] args) {
        String name = "Rahul";
        String sameName = "Rahul";
        String newName = new String("Rahul");

        System.out.println(name);
        System.out.println(newName);

        if(name == sameName) {
            System.out.println("Both are same");
        }

        if(name == newName) {
            System.out.println("Both are same");
        } else {
            System.out.println("Both are not same");
        }

        // while using ==, it's not the object values which gets checked,
        // it's references which gets checked

        // in primitive data types, == checks the values even if the values are getting stored separately
        // in non-primitive, == checks if references are pointing to same address or not

        // so the question is how do we check values
        // .equals() function
        // .equalsIgnoreCase() -> ignores the case of the string and then compare

        if(name.equals(newName)) {
            System.out.println("name and newName have same values");
        }
    }
}
