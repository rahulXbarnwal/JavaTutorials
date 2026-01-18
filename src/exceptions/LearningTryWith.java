package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// BufferedReader is using system resources which needs to be closed
// to make sure its closed, we can use finally block

public class LearningTryWith {
    public static void main(String[] args) {
//        BufferedReader reader = null;
//        try {
//            reader = new BufferedReader(new FileReader("example.txt"));

        // object which will be created inside the parenthesis, will get auto closed
        // - only the objects of class which is implementing AutoClosable interface
        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
//        finally {
//            try {
//                if (reader != null) {
//                    reader.close();
//                }
//            } catch (IOException e) {
//                System.out.println("Error closing reader: " + e.getMessage());
//            }
//        }
    }
}
