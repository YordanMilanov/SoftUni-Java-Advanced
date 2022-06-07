import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] children = scanner.nextLine().split(" ");
        int numberOfTurns = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> ChildrenQueue = new ArrayDeque<>();

        for (int i = 0; i < children.length; i++) {
            ChildrenQueue.offer(children[i]);
        }

        while (ChildrenQueue.size() != 1) {
            for (int i = 1; i < numberOfTurns; i++) {
                String currentChild = ChildrenQueue.poll();
                ChildrenQueue.offer(currentChild);
            }
            String childToRemove = ChildrenQueue.poll();
            System.out.println("Removed " + childToRemove);
        }

        String lastChild = ChildrenQueue.peek();
        System.out.println("Last is " + lastChild);
    }
}
