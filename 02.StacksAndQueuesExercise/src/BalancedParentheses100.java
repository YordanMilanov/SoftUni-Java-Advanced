import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> openBracketsStack = new ArrayDeque<>();
        boolean areBalanced = false;
        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);

            if (currentBracket == '[' || currentBracket == '{' || currentBracket == '(') {
                openBracketsStack.push(currentBracket);
            } else if (currentBracket == ']' || currentBracket == '}' || currentBracket == ')') {

                if (openBracketsStack.isEmpty()) {
                    areBalanced = false;
                    break;
                }
                char lastOpen = openBracketsStack.pop();

                if (currentBracket == '}' && lastOpen == '{') {
                    areBalanced = true;
                } else if (currentBracket == ']' && lastOpen == '[') {
                    areBalanced = true;
                } else if (currentBracket == ')' && lastOpen == '(') {
                    areBalanced = true;
                } else {
                    areBalanced = false;
                    break;
                }
            }
        }

        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
