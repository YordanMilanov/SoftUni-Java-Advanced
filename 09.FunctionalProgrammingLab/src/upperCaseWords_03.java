import java.util.Arrays;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class upperCaseWords_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // here we create a predicate to check if the word starts with capital letter
        Predicate<String> upperCasePredicate = word -> Character.isUpperCase(word.charAt(0));
        // here we create a consumer which task is to print the words in the list
        Consumer<String> printer = word -> System.out.println(word);

        List<String> uppercaseWords = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(upperCasePredicate)
                .collect(Collectors.toList());

        System.out.println(uppercaseWords.size());
        uppercaseWords.forEach(printer);
    }
}
