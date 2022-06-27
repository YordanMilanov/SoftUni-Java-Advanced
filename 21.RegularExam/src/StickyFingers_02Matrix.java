import java.util.Scanner;

public class StickyFingers_02Matrix {
    public static int housesCount = 0;
    public static int x = -1;
    public static int y = -1;
    public static int thefts = 0;
    public static boolean reachedPolice = false;
    public static int moves = 0;
    public static int totalStolen = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        String[] command = scanner.nextLine().split(",");
        String[][] city = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                city[i][j] = line[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String localChar = city[i][j];
                if (localChar.equals("D")) {
                    x = i;
                    y = j;
                } else if (localChar.equals("$")) {
                    housesCount++;
                }
            }
        }


        for (int i = 0; i < command.length; i++) {

            switch (command[i]) {
                case "up":
                    DillionMove(city, -1, 0);
                    break;
                case "down":
                    DillionMove(city, 1, 0);
                    break;
                case "right":
                    DillionMove(city, 0, 1);
                    break;
                case "left":
                    DillionMove(city, 0, -1);
                    break;
            }


            if (reachedPolice) {
                System.out.printf("You got caught with %d$, and you are going to jail.\n", totalStolen);
                //replace the P/D with #
                printTheCity(city);
                return;
            }
         //   if (housesCount == thefts) {
         //       System.out.printf("Your last theft has finished successfully with %d$ in your pocket.\n", totalStolen);
         //       printTheCity(city);
         //       return;
         //   }

            if (moves == command.length) {
                System.out.printf("Your last theft has finished successfully with %d$ in your pocket.\n", totalStolen);
                printTheCity(city);
            }
        }
    }

    private static void printTheCity(String[][] city) {
        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < city.length; j++) {
                System.out.print(city[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void DillionMove(String[][] field, int rowMutator, int colMutator) {
        int nextRow = x + rowMutator;
        int nextCol = y + colMutator;
        if (nextRow >= field.length || nextRow < 0 || nextCol >= field.length || nextCol < 0) {
            System.out.println("You cannot leave the town, there is police outside!");
            moves++;
            return;
        }

        if (field[nextRow][nextCol].equals("$")) {
            thefts++;
            int money = nextRow * nextCol;
            totalStolen += money;
            System.out.printf("You successfully stole %d$.\n", money);
        }
        if (field[nextRow][nextCol].equals("P")) {
            reachedPolice = true;
            field[nextRow][nextCol] = "#";
            field[x][y] = "+";
            x = nextRow;
            y = nextCol;
            return;
        }

        field[nextRow][nextCol] = "D";
        field[x][y] = "+";
        x = nextRow;
        y = nextCol;
        moves++;
    }
}