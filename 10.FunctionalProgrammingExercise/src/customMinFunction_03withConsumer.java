import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class customMinFunction_03withConsumer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> Numbers = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        Consumer <List<Integer>> printMin = list -> System.out.println(Collections.min(list));
        printMin.accept(Numbers);
    }
}
