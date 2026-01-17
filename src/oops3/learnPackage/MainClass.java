package oops3.learnPackage;

public class MainClass {
    public static void main(String[] args) {

        Teacher obj = new Teacher();
        obj.teachingClass = 12;
        // obj.id = 123; not accessible even in same package, since its private
        obj.degree = "PHD"; // accessible in same package since its default
    }
}
