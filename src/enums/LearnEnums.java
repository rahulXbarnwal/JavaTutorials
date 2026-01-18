package enums;

public class LearnEnums {
    public static void main(String[] args) {
        System.out.println(Day.TUESDAY); // TUESDAY
        System.out.println(Day.MONDAY);

        Day monday = Day.MONDAY;
        int ordinal = monday.ordinal();
        System.out.println(ordinal); // 1
        System.out.println(monday.name()); // MONDAY
    }
}
