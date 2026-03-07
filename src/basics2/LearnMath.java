package basics2;

public class LearnMath {
    public static void main(String[] args) {
        System.out.println(getRandom(10, 20));
    }

    public static int getRandom(int l, int r) {
        return l + (int)(Math.random() * (r - l + 1));
    }
}

// Math.random() ->  0.0 ≤ value < 1.0
