import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());


        Function<List<Integer>, List<Integer>> add = list -> list.stream().map(number -> number += 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtract = list -> list.stream().map(number -> number -= 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiply = list -> list.stream().map(number -> number *= 2).collect(Collectors.toList());
        Consumer<List<Integer>> print = list -> list.forEach(number -> System.out.print(number + " "));

        String command = scanner.nextLine();

        while(!command.equals("end")) {
            if (command.equals("add")) {
               numbers = add.apply(numbers);
            } else if (command.equals("subtract")) {
               numbers = subtract.apply(numbers);
            } else if (command.equals("multiply")) {
               numbers = multiply.apply(numbers);
            } else if (command.equals("print")) {
                print.accept(numbers);
                System.out.println();
            }
            command = scanner.nextLine();
        }
    }
}
