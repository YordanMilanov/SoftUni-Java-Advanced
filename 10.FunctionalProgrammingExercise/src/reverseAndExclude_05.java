import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class reverseAndExclude_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // take the input numbers
        List<Integer> numbers = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        // take the dividing number
        int n = Integer.parseInt(scanner.nextLine());

        // reverse the list
        Collections.reverse(numbers);

        // create a predicate to check if the current number in the list is dividable by the n number
        Predicate<Integer> checkDivision = number -> number % n == 0;

        // remove the current number if the predicate checkDivision is true
        numbers.removeIf(checkDivision);

        // print the list
        numbers.forEach(e -> System.out.print(e + " "));
    }
}
