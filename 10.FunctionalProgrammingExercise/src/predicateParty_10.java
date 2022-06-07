import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class predicateParty_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String command = scanner.nextLine();

        BiPredicate<String, String> startWith = ((name, start) -> {
            if (name.substring(0, start.length() - 1).equals(start)) {
                return true;
            } else {
                return false;
            }
        });

        BiPredicate<String, String> endWith = ((name, end) -> {
            if (name.substring(name.length() - end.length() - 1, name.length() - 1).equals(end)) {
                return true;
            } else {
                return false;
            }
        });

        BiPredicate<String, Integer> lengthCompare = ((name, length) -> {
            if (name.length() == length) {
                return true;
            } else {
                return false;
            }
        });

        Predicate<String> ifDouble = dataInput -> dataInput.equals("Double");
        Predicate<String> ifRemove = dataInput -> dataInput.equals("Remove");

        Predicate<String> ifStart = dataInput -> dataInput.equals("StartsWith");
        Predicate<String> ifEnd = dataInput -> dataInput.equals("EndsWith");
        Predicate<String> ifLength = dataInput -> dataInput.equals("Length");


        while (!command.equals("Party!")) {

            String[] data = command.split(" ");
            String addRemove = data[0];
            String startsEnds = data[1];
            String toCompare = data[2];

            if (ifDouble.test(addRemove)) {
                if (ifStart.test(startsEnds)) {
                    for (int i = 0; i <= names.size() - 1; i++) {
                        String currentNameToTest = names.get(i).substring(0, toCompare.length());
                        if (currentNameToTest.equals(toCompare)) {
                            names.add(i + 1, names.get(i));
                            i++;
                        }
                    }
                } else if (ifEnd.test(startsEnds)) {
                    for (int i = 0; i <= names.size() - 1; i++) {
                        String currentNameToTest = names.get(i).substring(names.get(i).length() - toCompare.length(), names.get(i).length());
                        if (currentNameToTest.length() < toCompare.length()) {
                            continue;
                        }
                        if (currentNameToTest.equals(toCompare)) {
                            names.add(i + 1, names.get(i));
                            i++;
                        }
                    }
                } else if (ifLength.test(startsEnds)) {
                    for (int i = 0; i <= names.size() - 1; i++) {
                        int nameLength = Integer.parseInt(toCompare);
                        if (names.get(i).length() == nameLength) {
                            names.add(i + 1, names.get(i));
                            i++;
                        }
                    }
                }
            } else if (ifRemove.test(addRemove)) {
                if (ifStart.test(startsEnds)) {
                    for (int i = 0; i <= names.size() - 1; i++) {
                        String currentNameToTest = names.get(i).substring(0, toCompare.length());
                        if (currentNameToTest.equals(toCompare)) {
                            names.remove(i);
                            i--;
                        }
                    }
                } else if (ifEnd.test(startsEnds)) {
                    for (int i = 0; i <= names.size() - 1; i++) {
                        String currentNameToTest = names.get(i).substring(names.get(i).length() - toCompare.length(), names.get(i).length());
                        if (currentNameToTest.length() < toCompare.length()) {
                            continue;
                        }
                        if (currentNameToTest.equals(toCompare)) {
                            names.remove(i);
                            i--;
                        }
                    }
                } else if (ifLength.test(startsEnds)) {
                    for (int i = 0; i <= names.size() - 1; i++) {
                        int nameLength = Integer.parseInt(toCompare);
                        if (names.get(i).length() == nameLength) {
                            names.remove(i);
                            i--;
                        }
                    }
                }
            }


            command = scanner.nextLine();
        }
        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(names);
            StringBuilder namesToEdit = new StringBuilder();

            for (int i = 0; i < names.size(); i++) {
                namesToEdit.append(names.get(i) + ", ");
            }
            String NamesToPrint = namesToEdit.substring(0, namesToEdit.lastIndexOf(","));
            System.out.println(NamesToPrint + " are going to the party!");
        }
    }
}
