import java.util.*;
import java.util.stream.Collectors;
// Score: 100/100
public class Cooking_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. read the input and collect it
        ArrayDeque<Integer> liquids = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        for (String s : scanner.nextLine().split(" ")) {
            Integer integer = Integer.parseInt(s);
            ingredients.push(integer);
        }

        int breadCount = 0;
        int cakeCount = 0;
        int pastryCount = 0;
        int fruitPieCount = 0;

        //2. implement the code
        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int sum = liquids.peek() + ingredients.peek();
            boolean cookedSomething = false;

            switch (sum) {
                case 25: //bread
                    breadCount++;
                    liquids.poll();
                    ingredients.pop();
                    cookedSomething = true;
                    break;
                case 50: //cake
                    cakeCount++;
                    liquids.poll();
                    ingredients.pop();
                    cookedSomething = true;
                    break;
                case 75: //pastry
                    pastryCount++;
                    liquids.poll();
                    ingredients.pop();
                    cookedSomething = true;
                    break;
                case 100: //pie
                    fruitPieCount++;
                    liquids.poll();
                    ingredients.pop();
                    cookedSomething = true;
                    break;

            }
            if (!cookedSomething) {
                liquids.poll();
                int localIngredient = ingredients.pop();
                ingredients.push(localIngredient + 3);
            }
        }

        if (breadCount > 0 && cakeCount > 0 && pastryCount > 0 && fruitPieCount > 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
            List<String> LiquidsAsString = liquids.stream().map(String::valueOf).collect(Collectors.toList());
        if (LiquidsAsString.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            String listToPrint = String.join(", ",LiquidsAsString);
            System.out.println("Liquids left: " + listToPrint);
        }

            List<String> ingredientsAsString = ingredients.stream().map(String::valueOf).collect(Collectors.toList());
        if (ingredientsAsString.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            String listToPrint = String.join(", ", ingredientsAsString);
            System.out.println("Ingredients left: " + listToPrint);
        }

        System.out.println("Bread: " + breadCount);
        System.out.println("Cake: " + cakeCount);
        System.out.println("Fruit Pie: " + fruitPieCount);
        System.out.println("Pastry: " + pastryCount);
    }
}

