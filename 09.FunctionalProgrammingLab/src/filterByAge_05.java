import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class filterByAge_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> user = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String [] data = scanner.nextLine().split(", ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            user.put(name, age);
        }

        String comparison = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String printType = scanner.nextLine();

        BiPredicate<Integer, Integer> filterPredicate; // create an empty predicate

        if (comparison.equals("younger")) {
            filterPredicate = (personAge, age) -> personAge <= age;
        } else {
            filterPredicate = (personAge, age) -> personAge >= age;
        }

        Consumer<Map.Entry<String, Integer>> printConsumer;

        if (printType.equals("age")) {
            printConsumer = person -> System.out.println(person.getValue());
        } else if (printType.equals("name")) {
            printConsumer = person -> System.out.println(person.getKey());
        } else {
            printConsumer = person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
        }

        user.entrySet()
                .stream()
                // the filter uses predicate not BiPredicate that is why we apply for every user the BiPredicate.test function that we created above
                .filter(person -> filterPredicate.test(person.getValue(), ageLimit))
                .forEach(printConsumer);

    }
}
