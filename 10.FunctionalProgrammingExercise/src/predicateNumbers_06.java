import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class predicateNumbers_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //read the target length of the name
        int n = Integer.parseInt(scanner.nextLine());
        // read all the names
        List<String> names = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        //creating a predicate to check if the name is longer than the target length
        Predicate<String> checkLength = name -> name.length() > n;
        //remove if the name is longer than the target by using predicate
        names.removeIf(checkLength);
        //print each name on new line
        names.forEach(System.out::println);
    }
}
