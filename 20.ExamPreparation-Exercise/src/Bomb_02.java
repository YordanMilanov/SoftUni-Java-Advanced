import java.util.Arrays;
import java.util.Scanner;

public class Bomb_02 {

    public static int bombCount = 0;
    public static int x = -1;
    public static int y = -1;
    public static int bombsFound = 0;
    public static boolean reachedEnd = false;
    public static int moves = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        String [] command = scanner.nextLine().split(",");
        String[][] field = new String[n][n];
        for (int i = 0; i < n; i++) {
            String [] line = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                field[i][j] = line[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String localChar = field[i][j];
                if (localChar.equals("s")) {
                    x = i;
                    y = j;
                } else if (localChar.equals("B")) {
                    bombCount++;
                }
            }
        }


        for (int i = 0; i < command.length; i++) {

            switch (command[i]) {
                case "up":
                    sapperMove(field, -1, 0);
                    break;
                case "down":
                    sapperMove(field, 1, 0);
                    break;
                case "right":
                    sapperMove(field, 0, 1);
                    break;
                case "left":
                    sapperMove(field, 0, -1);
                    break;
            }


            if (reachedEnd) {
                System.out.println("END! " + (bombCount - bombsFound) + " bombs left on the field");
                return;
            }
            if (bombCount == bombsFound) {
                System.out.println("Congratulations! You found all bombs!");
                return;
            }

            if( moves == command.length) {
                int bombsLeft = bombCount - bombsFound;
                System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombsLeft, x, y);
            }
        }

    }

    private static void sapperMove(String[][] field, int rowMutator, int colMutator) {
        int nextRow = x + rowMutator;
        int nextCol = y + colMutator;
        if (nextRow >= field.length || nextRow < 0 || nextCol >= field.length || nextCol < 0) {
            moves++;
            return;
        }

        if (field[nextRow][nextCol].equals("B")) {
            bombsFound++;
            System.out.println("You found a bomb!");
            field[nextRow][nextCol] = "+";
        }
        if (field[nextRow][nextCol].equals("e")) {
            reachedEnd = true;
            return;
        }

        field[nextRow][nextCol] = "s";
        field[x][y] = "+";
        x = nextRow;
        y = nextCol;
        moves++;
    }
}
