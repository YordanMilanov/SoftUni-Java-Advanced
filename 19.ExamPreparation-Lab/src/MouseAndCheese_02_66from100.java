import java.util.Scanner;
import java.util.regex.Pattern;

public class MouseAndCheese_02_66from100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //read the field
        int size = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[size][];

        for (int i = 0; i < size; i++) {
            field[i] = scanner.nextLine().toCharArray();

        }

        //find mouse start location
        //mouse coordinates
        int x = -1;
        int y = -1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field[i][j] == 'M') {
                    x = i;
                    y = j;
                    break;
                }
                ;
            }
        }


        int eatenCheese = 0;
        boolean outOfBound = false;
        // commands
        String command = scanner.nextLine();

        while (!command.equals("end") && outOfBound == false) {
            if (command.equals("up")) {
                if (x <= 0) {
                    outOfBound = true;
                    field[x][y] = '-';
                    break;
                }
                char nextPosition = field[x - 1][y];
                if (nextPosition == 'c') {
                    eatenCheese++;
                    field[x - 1][y] = 'M';
                    field[x][y] = '-';
                    x--;
                } else if (nextPosition == 'B') {
                    field[x - 1][y] = 'M';
                    field[x][y] = '-';
                    x--;
                    if (x <= 0) {
                        field[x][y] = '-';
                        outOfBound = true;
                        break;
                    }
                    continue;
                } else if (nextPosition == '-') {
                    field[x - 1][y] = 'M';
                    field[x][y] = '-';
                    x--;
                }
            } else if (command.equals("down")) {
                if (x >= size) {
                    outOfBound = true;
                    field[x][y] = '-';
                    break;
                }
                char nextPosition = field[x + 1][y];
                if (nextPosition == 'c') {
                    eatenCheese++;
                    field[x + 1][y] = 'M';
                    field[x][y] = '-';
                    x++;
                } else if (nextPosition == 'B') {
                    field[x + 1][y] = 'M';
                    field[x][y] = '-';
                    x++;
                    if (x >= size) {
                        field[x][y] = '-';
                        outOfBound = true;
                        break;
                    }
                    continue;
                } else if (nextPosition == '-') {
                    field[x + 1][y] = 'M';
                    field[x][y] = '-';
                    x++;
                }
            } else if (command.equals("left")) {
                if (y <= 0) {
                    outOfBound = true;
                    field[x][y] = '-';
                    break;
                }
                char nextPosition = field[x][y - 1];
                if (nextPosition == 'c') {
                    eatenCheese++;
                    field[x][y - 1] = 'M';
                    field[x][y] = '-';
                    y--;
                } else if (nextPosition == 'B') {
                    field[x][y - 1] = 'M';
                    field[x][y] = '-';
                    y--;
                    if (y <= 0) {
                        field[x][y] = '-';
                        outOfBound = true;
                        break;
                    }
                    continue;
                } else if (nextPosition == '-') {
                    field[x][y - 1] = 'M';
                    field[x][y] = '-';
                    y--;
                }

            } else if (command.equals("right")) {
                if (y >= size) {
                    outOfBound = true;
                    field[x][y] = '-';
                    break;
                }
                char nextPosition = field[x][y + 1];
                if (nextPosition == 'c') {
                    eatenCheese++;
                    field[x][y + 1] = 'M';
                    field[x][y] = '-';
                    y++;
                } else if (nextPosition == 'B') {
                    field[x][y + 1] = 'M';
                    field[x][y] = '-';
                    y++;
                    if (y >= size - 1) {
                        field[x][y] = '-';
                        outOfBound = true;
                        break;
                    }
                    continue;
                } else if (nextPosition == '-') {
                    field[x][y + 1] = 'M';
                    field[x][y] = '-';
                    y++;
                }

            }
            command = scanner.nextLine();
        }

        //print the sentences
        if (outOfBound) {
            System.out.println("Where is the mouse?");
        }
        if(eatenCheese >= 5) {
            System.out.println("Great job, the mouse is fed " + eatenCheese + " cheeses.");
        } else {
            System.out.println("The mouse couldn't eat the cheeses, she needed " + (5 - eatenCheese) + " cheeses more.");
        }

        //print the matrix
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }

    }
}
