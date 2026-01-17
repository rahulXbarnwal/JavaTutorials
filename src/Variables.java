public class Variables {
    public static void main(String[] args) {

        boolean isPassed = true;
        long count = 12;
        int countInt = (int)count;

        byte marks = 13;
        short studentsCount = 1235;

        float pi = 3.14f;

        double secondPi = 3.143213241123; // will print all precision

        float x = 3.143213241123f; // will print till 7 decimal points

        System.out.println(pi);
        System.out.println(secondPi);
        System.out.println(x);

        char myLetter = 'a';
        System.out.println(myLetter);

        int age = 128;
        byte newAge = (byte)age; // explicit typecasting, lossy conversion

        System.out.println(newAge); // -128 -> rotation
    }
}
