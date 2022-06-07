import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> PrinterQueue = new ArrayDeque<>();
        while(!input.equals("print")) {

            if (input.equals("cancel")) {
                if (PrinterQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + PrinterQueue.poll());
                }
            } else {
                PrinterQueue.offer(input);
            }
            input = scanner.nextLine();
        }
        for (String s : PrinterQueue) {
            System.out.println(s);
        }
    }
}
