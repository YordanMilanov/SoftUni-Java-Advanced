import java.util.*;
import java.util.stream.Collectors;

public class SortEvenNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringNumbers = scanner.nextLine().split(", ");

        //we start the stream
        List<Integer> evenNumbers = Arrays.stream(stringNumbers)
                // parse to int
                .map(Integer::parseInt)
                //filter the odd leave only the even
                .filter(e -> e % 2 == 0)
                //in the end we always collect the data with .collect(collectors.tolist());
                .collect(Collectors.toList());


        List<String> evenNumbersString = evenNumbers
                // we star the stream
                .stream()
                //transform them into string because we need to print them without the last comma
                // and this can be achieved using string.join
                .map(e -> e.toString())
                //collect them into new list evenNumbersString
                .collect(Collectors.toList());
        //print them using string.join
        System.out.print(String.join(", ", evenNumbersString));
        //we print new separating line
        System.out.println();

        Collections.sort(evenNumbers, Integer::compareTo);

        //now we give the string list the new sorted even numbers
        evenNumbersString = evenNumbers
                // we star the stream
                .stream()
                //map the evenNumbers Integers to string
                .map(e -> e.toString())
                //collect them
                .collect(Collectors.toList());


        // print using .join
        System.out.print(String.join(", ", evenNumbersString));

    }
}
