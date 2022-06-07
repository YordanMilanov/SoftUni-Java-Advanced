import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] rowsCols = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(rowsCols[0]);
        int cols = Integer.parseInt(rowsCols[1]);

        int [][] matrix = new int[rows][cols];

        //collecting the input arrays to the matrix
        for (int i = 0; i < rows; i++) {
            int[] matrixRow = Arrays
                            .stream(scanner.nextLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
            for (int j = 0; j < cols; j++) {
            matrix [i][j] = matrixRow[j];
            }
        }

        int target = Integer.parseInt(scanner.nextLine());

        //creating a boolean in case that there is not a target number in the matrix so we can print not found
        boolean notFound = true;

        //checking and printing for the given searched number
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == target) {
                    System.out.println(i + " " + j);
                    notFound = false;
                }
            }
        }
        if (notFound) {
            System.out.println("not found");
        }
    }
}
