import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithStacks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> reversedNumbers = new ArrayDeque<>();

        int[] Numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int number : Numbers) {
            reversedNumbers.push(number);
        }

        int stackSize = reversedNumbers.size();
        for (int i = 0; i < stackSize; i++) {
            System.out.print(reversedNumbers.pop() + " ");
        }
    }
}

