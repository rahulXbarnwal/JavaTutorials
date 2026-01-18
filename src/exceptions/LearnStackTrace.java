package exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Student {
    int id;

    void setId (int id) {
        this.id = id;
    }
}

public class LearnStackTrace {
    public static void main(String[] args) throws IOException {
        try {
            level1();
        } catch (Exception o) {
//            StackTraceElement stackTrace[] = o.getStackTrace();
//            for(StackTraceElement st: stackTrace) {
//                System.out.println(st);
//            }

            o.printStackTrace();
        }

        // null-pointer exception
        // unchecked exception -> these exceptions are not checked at compile time
        Student a = null;
        a.setId(123);


        method2();
        System.out.println("Hello");
    }

    public static void method2() throws FileNotFoundException {
        method1();
    }

    public static void method1() throws FileNotFoundException {
        // checked exception -> checked at compile time
        // either handle this using try catch
        // or make it's caller responsible, write "throws Exception" in method in which its present
        // FileReader fileReader = new FileReader("a.txt");

        try {
            FileReader fileReader = new FileReader("a.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw new FileNotFoundException("oops!");
        }
    }

    // not needed to do that throws etc. here since its unchecked exception
    public static void someMethod() {
        throw new ArithmeticException();
    }

    public static void level3() {
        int[] array = new int[5];
        array[5] = 10;
    }

    public static void level2() {
        level3();
    }

    public static void level1() {
        level2();
    }

    public static int divide (int a, int b) {
        try {
            return a/b;
        } catch (Exception e) {
            return -1;
        }
        finally {
            // this will execute, no matter try or catch which is executing
            // we can print even when return statements are there in try/catch
            System.out.println("Bye");
        }
//        System.out.println("Bye");
    }
}
