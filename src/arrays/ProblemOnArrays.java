package arrays;

public class ProblemOnArrays {
    public static void main(String[] args) {

        int numbers[] = {23, 12, 6, 7, 15, 3, 2, 56};

        int min = Integer.MAX_VALUE;

        for(int num: numbers) {
            if(num < min) min = num;
        }

        System.out.println(min);
    }
}
