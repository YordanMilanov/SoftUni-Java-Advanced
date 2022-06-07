import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibunacciNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()) + 2;
        List<BigDecimal> numbers = new ArrayList<>();
        ArrayDeque<BigDecimal> Stack = new ArrayDeque<>();

        if (n == 2) {
            System.out.println(0);
            return;
        } else if (n == 3) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (numbers.size() > 1) {
                BigDecimal lastNumber = numbers.get(i - 1);
                BigDecimal secondLastNumber = numbers.get(i - 2);
                BigDecimal sum = lastNumber.add(secondLastNumber);
                Stack.push(sum);
                numbers.add(sum);
            } else {
                numbers.add(BigDecimal.valueOf(i));
                Stack.push(BigDecimal.valueOf(i));
            }
        }

        System.out.println(Stack.peek());
    }
}
