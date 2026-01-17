package learnString;

import java.util.Scanner;

public class LearnString {
    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Enter your first name: ");
//        String firstName = sc.nextLine(); // will consider whole line
//
//        System.out.println("Enter your last name: ");
//        String lastName = sc.next(); // will take only the first word before space
//
//        System.out.println("Your full name is " + firstName + " " + lastName);
//        System.out.println(lastName);

//        int age = 123;
//        String stringAge = String.valueOf(age); // to convert int, float etc. to string
//        System.out.println(age + 2); // 125
//        System.out.println(stringAge + 2); // 1232


//        String sentence = "I love java, java is good";
//        String newSentence = sentence.replace("java", "cpp");
//
//        System.out.println(sentence); // I love java, java is good
//        System.out.println(newSentence); // I love cpp, cpp is good


        String sentence = "I love Java, Java is a good language";

//        String substring = sentence.substring(2);
//        System.out.println(substring); // from index 2 to last
//
//        String substring2 = sentence.substring(2, 8); // [2, 8)
//        System.out.println(substring2);

//        String words[] = sentence.split(" ");
//        for(String word: words) {
//            System.out.println(word);
//        }

//        String color = "Brown is my fav color!";
//        char letters[] = color.toCharArray();
//
//        for(char letter: letters) {
//            System.out.println(letter);
//        }


        String animal = "   ";

        if(animal.isEmpty()) {
            System.out.println("Empty");
        } else if (animal.isBlank()) {
            System.out.println("Blank");
        }

    }
}
