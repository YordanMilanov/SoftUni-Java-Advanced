import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\s+");
        // we read the input

        ArrayDeque<String> tokens = new ArrayDeque<>();
        //create an empty stack

        Collections.addAll(tokens, input);
        //add all data from the input array to the stack using the collections.addAll

        while (tokens.size() > 1) {
            //creating a while cycle
            int firstNumber = Integer.parseInt(tokens.pop());
            //taking first number
            String sign = tokens.pop();
            //taking sign
            int secondNumber = Integer.parseInt(tokens.pop());
            //taking second number
            int result = 0;
            //creating a buffer result int

            if (sign.equals("+")) {
                //check if the sign is + and add it
                result = firstNumber + secondNumber;
            } else {
                //if it is not + then it is - and we remove
                result = firstNumber - secondNumber;
            }

            tokens.push(String.valueOf(result));
            //now we return the only thing (the result) which is left in the stack
            // we use the String.valueOf() method which converts int to string we can also do result+ "" because
            // string + int = string
        }
        System.out.println(tokens.peek());
        //print
    }
}
