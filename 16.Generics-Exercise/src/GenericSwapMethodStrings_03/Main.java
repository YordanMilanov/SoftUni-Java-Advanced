package GenericSwapMethodStrings_03;

import java.util.Scanner;

//problem explanation
//Create a generic method that receives a list containing
//any type of data and swaps the elements at two given indexes.
//As in the previous problems(GenericBox_01 and GenericBoxOfInteger_02), read n number of boxes of type String and add them to the list.
// On the next line, however, you will receive a swap command consisting of two indexes.
// Use the method you've created to swap the elements that correspond to the given
// indexes and print each element in the list.
//*This problem is expansion to the first it needs the other part to work properly (genericBox_01).

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<String> box = new Box<>();

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            box.add(text);
        }

        int firstIndex = scanner.nextInt();
        int secondIndex = scanner.nextInt();

        box.swap(firstIndex, secondIndex);
         System.out.println(box);
    }
}
