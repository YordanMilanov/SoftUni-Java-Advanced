import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class comparatorSort_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Comparator<Integer> comparator = ((first, second) -> {
            // even odd
            if (first % 2 == 0 && second % 2 != 0) {
                return -1;
            }
            // odd even
            else if (first % 2 != 0 && second % 2 == 0) {
                return 1;
            } else {
                return first.compareTo(second);
            }
        });

        numbers.stream().sorted(comparator).forEach(number -> System.out.print(number + " "));
    }
}
