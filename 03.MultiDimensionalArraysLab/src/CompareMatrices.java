import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] rowsCols = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int row = rowsCols[0];
        int cols = rowsCols[1];

        int [][] Matrix1 = new int[row][cols];

        for (int i = 0; i < row; i++) {
            int[] matrixRow = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < cols; j++) {
                Matrix1 [i][j] = matrixRow[j];
            }
        }

        int[] rowsCols2 = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row2 = rowsCols2[0];
        int cols2 = rowsCols2[1];

        int [][] Matrix2 = new int[row2][cols2];

        for (int i = 0; i < row2; i++) {
            int[] matrixRow = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < cols2; j++) {
                Matrix2 [i][j] = matrixRow[j];
            }
        }

        if (row != row2 || cols != cols2) {
            System.out.println("not equal");
            return;
        }

        boolean notEqual = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                if (Matrix1[i][j] != Matrix2[i][j]) {
                    notEqual = true;
                    System.out.println("not equal");
                    return;
                }
            }
        }

        System.out.println("equal");
    }
}
