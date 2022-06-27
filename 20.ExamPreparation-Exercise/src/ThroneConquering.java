import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ThroneConquering {

    public static int x = -1;
    public static int y = -1;
    public static int energy = 0;
    public static boolean saved = false;
    public static boolean gotKilled = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int e = Integer.parseInt(scanner.nextLine());
        energy = e;
        int matrixSize = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][];

        for (int row = 0; row < matrixSize; row++) {
            List<Character> characterList = Arrays.stream(scanner.nextLine().split(" "))
                    .map(s -> s.charAt(0))
                    .collect(Collectors.toList());
            for (int col = 0; col < characterList.size(); col++) {
                char currentChar = characterList.get(col);
                matrix[row][col] = currentChar;
            }
        }

        String[] command = scanner.nextLine().split(" ");
        String moveCommand = command[0];
        int enemySpawnX = Integer.parseInt(command[1]);
        int enemySpawnY = Integer.parseInt(command[2]);

        while (energy > 0) {
            switch (moveCommand) {
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


            if (matrix[x][y] == 'S') {
                matrix[x][y] = '-';
                foodEaten++;
                if (foodEaten == totalFood) {
                    int snakeLength = foodEaten + 1;
                    System.out.printf("You win! Final python length is %d", snakeLength);
                    return;
                }
            }


        }
    }


    private static void snakeMove(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = x + rowMutator;
        int nextCol = y + colMutator;

        if (nextRow >= matrix.length || nextRow < 0 || nextCol >= matrix.length || nextCol < 0) {
            energy--;
            nextRow = x;
            nextCol = y;
        }


        if (matrix[nextRow][nextCol] == 'S') {
            energy -= 2;
            if (energy <= 0) {
                gotKilled = true;
                matrix[nextRow][nextCol] = 'X';
                return;
            }
            matrix[nextRow][nextCol] = '-';
        }
        if (matrix[nextRow][nextCol] == 'H') {
            saved = true;
            return;
        }


        matrix[nextRow][nextCol] = 'P';
        matrix[x][y] = '-';
        x = nextRow;
        y = nextCol;
    }
}