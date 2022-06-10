package GenericCountMethodDouble_06;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<Double> box = new Box();

        for (int i = 0; i < n; i++) {
            double number = Double.parseDouble(scanner.nextLine());
            box.add(number);
        }

        double element = Double.parseDouble(scanner.nextLine()); //this is the element from which we will check the bigger values in box

        System.out.println(box.countGreaterThan(element));
    }
}