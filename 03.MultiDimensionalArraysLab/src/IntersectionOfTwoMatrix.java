import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char [][] matrix1 = new char[rows][cols];
        char [][] matrix2 = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            String [] buffer = scanner.nextLine().split(" ");
            for (int j = 0; j < buffer.length; j++) {
                matrix1[i][j] = buffer[j].charAt(0);
            }
        }

        for (int i = 0; i < rows; i++) {
            String [] buffer = scanner.nextLine().split(" ");
            for (int j = 0; j < buffer.length; j++) {
                matrix2[i][j] = buffer[j].charAt(0);
            }
        }

        char [][] matrixResult = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix1[i][j] == matrix2[i][j]) {
                    matrixResult[i][j] = matrix1[i][j];
                } else {
                    matrixResult[i][j] = '*';
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrixResult[i][j] + " ");
            }
            System.out.println();
        }
    }
}
