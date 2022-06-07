import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses87 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("");
        ArrayDeque<Character> openBracketsStack = new ArrayDeque<>();
        ArrayDeque<Character> closedBracketsQueue = new ArrayDeque<>();
        boolean areBalanced = false;

        for (int i = 0; i < data.length; i++) {
            char currentBracket = data[i].charAt(0);
            if (currentBracket == '[' || currentBracket == '{' || currentBracket == '(') {
                openBracketsStack.push(currentBracket);
            } else if (currentBracket == ']' || currentBracket == '}' || currentBracket == ')') {
                closedBracketsQueue.offer(currentBracket);
            }
        }

        if (openBracketsStack.size() != closedBracketsQueue.size()) {
            System.out.println("NO");
        } else {
            while (!closedBracketsQueue.isEmpty() && !openBracketsStack.isEmpty()) {
                char lastOpen = openBracketsStack.pop();
                char firstClosed = closedBracketsQueue.poll();
                if (firstClosed == '}' && lastOpen == '{') {
                    areBalanced = true;
                } else if (firstClosed == ']' && lastOpen == '[') {
                    areBalanced = true;
                } else if (firstClosed == ')' && lastOpen == '(') {
                    areBalanced = true;
                } else {
                    areBalanced = false;
                    break;
                }
            }
            if (areBalanced) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
