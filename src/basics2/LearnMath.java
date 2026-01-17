package basics2;

public class LearnMath {
    public static void main(String[] args) {
        System.out.println(getRandom(10, 20));
    }

    public static int getRandom(int a, int b) {
        return (int) (Math.random() * (b - a + 1) + a);
    }
}
