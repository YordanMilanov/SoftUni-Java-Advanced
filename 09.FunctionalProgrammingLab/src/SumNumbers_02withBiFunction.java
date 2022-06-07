import java.util.Scanner;
import java.util.function.BiFunction;

public class SumNumbers_02withBiFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split(", ");

        System.out.println("Count = " + input.length);

        int sum = 0;
        BiFunction<Integer, String, Integer> parseAndSum = (x, y) -> x + Integer.parseInt(y);

        for (int i = 0; i < input.length; i++) {
            sum = parseAndSum.apply(sum, input[i]);
        }

        System.out.println("Sum = " + sum);
    }
}
