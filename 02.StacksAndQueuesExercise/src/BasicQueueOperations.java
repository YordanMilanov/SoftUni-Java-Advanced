import java.util.*;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> Numbers = new ArrayDeque<>();

        int[] Data = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] inputNumbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int N = Data[0];
        int S = Data[1];
        int X = Data[2];

        for (int i = 0; i < N; i++) {
            Numbers.offer(inputNumbers[i]);
        }

        for (int i = 0; i < S; i++) {
            Numbers.poll();
        }

        if (Numbers.contains(X)) {
            System.out.println("true");
        } else {
            if (Numbers.size() > 0) {
            System.out.println(Collections.min(Numbers));
            } else {
                System.out.println(0);
            }
        }
    }
}
