import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split(" ");
        int numberOfTurns = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> ChildrenQueue = new ArrayDeque<>();

        for (int i = 0; i < children.length; i++) {
            ChildrenQueue.offer(children[i]);
        }

        int cycles = 1;
        while (ChildrenQueue.size() > 1) {
            for (int i = 1; i < numberOfTurns; i++) {
                String currentChild = ChildrenQueue.poll();
                ChildrenQueue.offer(currentChild);
            }
            String name = ChildrenQueue.peek();
            if (isPrime(cycles) == false) {
                System.out.println("Removed " + name);
                ChildrenQueue.remove();
            } else {
                System.out.println("Prime " + name);
            }

            cycles++;
        }

        System.out.println("Last is " + ChildrenQueue.peek());
    }

    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}


