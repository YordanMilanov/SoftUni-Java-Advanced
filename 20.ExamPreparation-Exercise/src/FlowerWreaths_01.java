import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

// 100/100
public class FlowerWreaths_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
                ArrayDeque<Integer> roseStack = Arrays.stream(scanner.nextLine().split(", "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toCollection(ArrayDeque::new));

                ArrayDeque<Integer> lillyQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(lillyQueue::push);

        int wreathCount = 0;
        int flowersStore = 0;

        while(!roseStack.isEmpty() && !lillyQueue.isEmpty()) {
            int roses = roseStack.peek();
            int lillie = lillyQueue.peek();
           int sum = roses + lillie;
           while (sum > 15) {
               lillie -= 2;
               sum = roses + lillie;
           }
           if (sum == 15) {
               wreathCount++;
           } else {
               flowersStore += sum;
           }
            roseStack.pop();
            lillyQueue.poll();
        }

        wreathCount += flowersStore / 15;

        if (wreathCount >= 5) {
            System.out.println("You made it, you are going to the competition with " + wreathCount + " wreaths!");
        } else {
            System.out.println("You didn't make it, you need " + (5 - wreathCount) + " wreaths more!");
        }
    }
}
