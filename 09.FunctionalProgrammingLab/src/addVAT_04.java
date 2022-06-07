import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class addVAT_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Double> prices = Arrays
                .stream(scanner.nextLine().split(", "))
                .map(e -> Double.parseDouble(e))
                .map(e -> e * 1.2)
                .collect(Collectors.toList());

        prices.forEach(e -> System.out.printf("%.2f%n", e));

    }
}
