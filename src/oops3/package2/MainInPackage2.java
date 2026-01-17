package oops3.package2;

import oops3.learnPackage.Teacher;

public class MainInPackage2 extends Teacher {

    public static void main(String[] args) {
        Teacher obj = new Teacher();
//        obj.id = 123; // not accessible since its private
        obj.teachingClass = 4;
//        obj.degree = "PHD"; // can't use outside package, since its default

        MainInPackage2 mainInPackage2 = new MainInPackage2();
        mainInPackage2.studentsCount = 100;
        // accessible, since it's accessing the protected field via inheritance, even if it's in diff package

    }
}
