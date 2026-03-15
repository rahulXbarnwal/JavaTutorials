package learnCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
Comparator is used when you have to do custom sorting
Comparable is used to define natural ordering of objects
 */

public class ComparableDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Charlie", 3.5));
        list.add(new Student("Bob", 3.7));
        list.add(new Student("Alice", 3.5));
        list.add(new Student("Akshit", 3.9));
        list.sort(null);
        System.out.println(list);
    }
}

class Student implements Comparable<Student> {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Student other = (Student) obj;
        return Double.compare(gpa, other.getGpa()) == 0 && Objects.equals(name, other.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gpa);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', gpa=" + gpa + "}";
    }

    @Override
    public int compareTo(Student other) {
        if(getGpa() == other.getGpa()) {
            return name.compareTo(other.getName());
        }
        return Double.compare(other.getGpa(), gpa);
    }
}
