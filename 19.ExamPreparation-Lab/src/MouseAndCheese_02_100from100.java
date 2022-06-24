import java.util.Scanner;

public class MouseAndCheese_02_100from100 {
    //this parameters are private static and out of the main because if we declare it here as static variables
    // we can use them in the other methods(moveMouse method) we can modify and use them without declaring them
    //MOUSE COORDINATES
    private static int row = 0;
    private static int col = 0;
    private static int eatenCheese = 0;
    private static boolean mouseIsInField = true;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[size][size];

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            field[i] = line.toCharArray();

            //mouse location we find it while we read the matrix
            if (line.contains("M")) {
                row = i;
                col = line.indexOf("M");
            }

        }

        String command = scanner.nextLine();

        while(!command.equals("end")) {

            if(command.equals("up")) {
                moveMouse(field, -1, 0);
            } else if (command.equals("down")) {
                moveMouse(field,  1,0);
            } else if (command.equals("left")) {
                moveMouse(field, 0,  -1);
            } else if (command.equals("right")) {
                moveMouse(field, 0, 1);

            }

            if(!mouseIsInField) {
                break;
            }

            command = scanner.nextLine();
        }

        if(!mouseIsInField) {
            System.out.println("Where is the mouse?");
        }

        if(eatenCheese >= 5) {
            System.out.println("Great job, the mouse is fed " + eatenCheese + " cheeses!");
        } else {
            System.out.println("The mouse couldn't eat the cheeses, she needed " + (5 - eatenCheese) + " cheeses more.");
        }
        printTheMatrix(field);
    }

    private static void moveMouse(char[][] field, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;

        boolean isBonusHit = false;

        if(!isInBounds(field, nextRow, nextCol)) {
            field[row][col] = '-';
            mouseIsInField = false;
            return;
        }

        if (field[nextRow][nextCol] == 'c') {
            eatenCheese++;
        } else if (field[nextRow][nextCol] == 'B') {
            isBonusHit = true;
        }

        field[row][col] = '-';
        field[nextRow][nextCol] = 'M';
        row = nextRow;
        col = nextCol;

        if (isBonusHit) {
            moveMouse(field, rowMutator, colMutator);
        }
    }

    private static boolean isInBounds(char[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
    }


    private static void printTheMatrix(char[][] field) {

        for (char[] chars : field) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
