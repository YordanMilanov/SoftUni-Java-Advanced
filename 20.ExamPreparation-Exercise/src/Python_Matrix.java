import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Python_Matrix {

    public static int x = -1;
    public static int y = -1;
    public static int totalFood = 0;
    public static int foodEaten = 0;
    public static int moves = 0;
    public static boolean reachedEnemy = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");

        char[][] matrix = new char[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            List<Character> characterList = Arrays.stream(scanner.nextLine().split(" "))
                    .map(e -> e.charAt(0))
                    .collect(Collectors.toList());
            for (int col = 0; col < characterList.size(); col++) {
                char currentChar = characterList.get(col);
                if (currentChar == 's') {
                    x = row;
                    y = col;
                } else if (currentChar == 'f') {
                    totalFood++;
                }
                matrix[row][col] = currentChar;
            }
        }


        for (int i = 0; i < commands.length; i++) {

            switch (commands[i]) {
                case "up":
                    snakeMove(matrix, -1, 0);
                    break;
                case "down":
                    snakeMove(matrix, 1, 0);
                    break;
                case "right":
                    snakeMove(matrix, 0, 1);
                    break;
                case "left":
                    snakeMove(matrix, 0, -1);
                    break;
            }


            if (matrix[x][y] == 'f') {
                matrix[x][y] = '*';
                foodEaten++;
                if (foodEaten == totalFood) {
                    int snakeLength = foodEaten + 1;
                    System.out.printf("You win! Final python length is %d", snakeLength);
                    return;
                }
            }

            if (reachedEnemy) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
            if (totalFood == foodEaten) {
                int snakeLength = foodEaten + 1;
                System.out.printf("You win! Final python length is %d", snakeLength);
                return;
            }

            if (moves == commands.length) {
                int foodLeft = totalFood - foodEaten;
                System.out.printf("You lose! There is still %d food to be eaten.", foodLeft);
            }
        }
    }




    private static void snakeMove(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = x + rowMutator;
        int nextCol = y + colMutator;

        if (nextRow >= matrix.length) {
            nextRow = 0;
        } else if (nextRow < 0) {
            nextRow = matrix.length - 1;
        }

        if (nextCol >= matrix.length) {
            nextCol = 0;
        } else if (nextCol < 0) {
            nextCol = matrix.length - 1;
        }


        if (matrix[nextRow][nextCol] == 'f') {
            foodEaten++;
            matrix[nextRow][nextCol] = '*';
        }
        if (matrix[nextRow][nextCol] == 'e') {
            reachedEnemy = true;
            return;
        }

        matrix[nextRow][nextCol] = 's';
        matrix[x][y] = '*';
        x = nextRow;
        y = nextCol;
        moves++;
    }
}
