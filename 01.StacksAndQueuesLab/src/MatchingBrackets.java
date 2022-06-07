import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> BracketsStack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                BracketsStack.push(i);
            } else if (input.charAt(i) == ')') {
                int endIndex = i + 1;
                int startIndex = BracketsStack.pop();
                String content = input.substring(startIndex, endIndex);
                System.out.println(content);
            }
        }
    }
}
