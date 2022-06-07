import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class evenOrOdd_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] bounds = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int bottom = bounds[0];
        int top = bounds[1];
        String type = scanner.nextLine();

        Predicate<Integer> isEven = number -> number % 2 == 0;

        if (type.equals("even")) {
            printEven(bottom, top, isEven);
        } else {
            printOdd(bottom, top, isEven);
        }
    }

    private static void printEven(int bottom, int top, Predicate<Integer> isEven) {
        for (int i = bottom; i <= top; i++) {

            if (isEven.test(i)) {
                System.out.print(i + " ");
            } else {
                continue;
            }
        }
    }

    private static void printOdd(int bottom, int top, Predicate<Integer> isEven) {
        for (int i = bottom; i <= top; i++) {

            if (!isEven.test(i)) {
                System.out.print(i + " ");
            } else {
                continue;
            }
        }
    }

}
