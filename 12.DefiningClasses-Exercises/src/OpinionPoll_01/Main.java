package OpinionPoll_01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> peopleList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String [] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            Person person = new Person(name, age);
            if (age > 30) {
               peopleList.add(person);
            }
        }
        peopleList.sort(Comparator.comparing(person -> person.getName()));
        peopleList.forEach(p -> System.out.printf("%s - %d%n",p.getName(), p.getAge()));
    }
}
