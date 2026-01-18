package exceptions;

// Types of errors
// - Syntax error, Logical error, Runtime error

// Program will crash during run time errors
// so we will handle those exceptions

// Exception handling is a way to handle the runtime errors so that
// normal flow of application can be maintained

// Exception is an event that disrupts the normal flow of program,
// It is an object which is thrown at runtime

public class LearnExceptions {
    public static void main(String[] args) {
        int numerators[] = {10, 200, 30, 40};
        int denominators[] = {1, 2, 0, 4};
        for(int i = 0; i < 10; i++) {
            try {
                System.out.println(divide(numerators[i], denominators[i]));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("Good job :)");
    }

    public static int divide(int a, int b) {
        try {
            return a/b;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic exception :(");
            return -1;
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }
}
