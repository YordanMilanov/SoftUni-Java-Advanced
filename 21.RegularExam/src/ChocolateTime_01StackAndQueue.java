import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
 // 100/100 - Excellent
public class ChocolateTime_01StackAndQueue  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // read the input
        ArrayDeque<Double> MilkQuantityStack = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Double> CacaoQuantityQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(CacaoQuantityQueue::push);

        int chocolateCounter = 0;
        int milkChocolateCounter = 0;
        int darkChocolateCounter = 0;
        int bakingChocolateCounter = 0;

        while (!MilkQuantityStack.isEmpty() && !CacaoQuantityQueue.isEmpty()) {
            double milkValue = MilkQuantityStack.peek();
            double cacaoPowderValue = CacaoQuantityQueue.peek();
            double sumOfMilkAndCacao = milkValue + cacaoPowderValue;
            double chocolatePercentage = (cacaoPowderValue / sumOfMilkAndCacao) * 100;
            DecimalFormat df = new DecimalFormat("###.");
            chocolatePercentage = Double.parseDouble(df.format(chocolatePercentage));


            //if we cook the chocolate
            if (chocolatePercentage == 30) {

                chocolateCounter++;
                milkChocolateCounter++;

                MilkQuantityStack.pop();
                CacaoQuantityQueue.poll();

            } else if (chocolatePercentage == 50) {

                chocolateCounter++;
                darkChocolateCounter++;

                MilkQuantityStack.pop();
                CacaoQuantityQueue.poll();

            } else if (chocolatePercentage == 100) {

                bakingChocolateCounter++;
                chocolateCounter++;

                MilkQuantityStack.pop();
                CacaoQuantityQueue.poll();

                //if we don't cook the chocolate
            } else {
                CacaoQuantityQueue.poll();
                MilkQuantityStack.poll();
                milkValue += 10;
                MilkQuantityStack.offer(milkValue);

            }
        }

        //create a map to sort them alphabetically
        TreeMap<String, Integer> cookedChocolates = new TreeMap();
        if (milkChocolateCounter > 0) {
            cookedChocolates.put("Milk Chocolate", milkChocolateCounter);
        }
        if (darkChocolateCounter > 0) {
            cookedChocolates.put("Dark Chocolate", darkChocolateCounter);
        }
        if (bakingChocolateCounter > 0) {
            cookedChocolates.put("Baking Chocolate", bakingChocolateCounter);
        }

        //task is completed print
        if (milkChocolateCounter > 0 && darkChocolateCounter > 0 && bakingChocolateCounter > 0) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
            //task is not completed print
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        //print each cooked chocolate
        for (Map.Entry<String, Integer> entry : cookedChocolates.entrySet()) {
            String chocolate = entry.getKey();
            int count = entry.getValue();
            System.out.println("# " + chocolate + " --> " + count);
        }
    }
}
