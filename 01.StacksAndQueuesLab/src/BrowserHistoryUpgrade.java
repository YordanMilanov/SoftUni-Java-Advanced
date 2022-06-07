import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        String currentURL = "";
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (browserHistory.size() > 1) {
                    forwardHistory.push(browserHistory.pop());
                    currentURL = browserHistory.peek();
                    System.out.println(currentURL);
                } else {
                    System.out.println("no previous URLs");
                }

                if (input.equals("forward")) {
                    if (forwardHistory.size() > 1) {
                        System.out.println(forwardHistory.poll());
                    } else {
                        System.out.println("no next URLs");
                    }
                }
            } else if (input.equals("forward")) {
                if (!forwardHistory.isEmpty()) {
                    browserHistory.push(forwardHistory.peek());
                    System.out.println(forwardHistory.poll());
                } else {
                    System.out.println("no next URLs");
                }
            } else {
                browserHistory.push(input);
                currentURL = browserHistory.peek();
                System.out.println(currentURL);
                forwardHistory.clear();
            }

            input = scanner.nextLine();
        }
    }
}
