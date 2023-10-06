import java.util.Scanner;
public class MenuUi {
    protected Board board;
    private int boardSize;
    private int numberOfPlayers;

    private int [] coord = new int[2];

    public MenuUi() {

    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void drawMenu() {
        System.out.println("*************************");
        System.out.println("*********Omok Game*******");
        System.out.println("*************************");
        System.out.println("Please enter one of the following options: ");
        System.out.println("1. Single player game");
        System.out.println("2. Multiplayer game");
        this.newGameMenu(this.getInput());
    }

    public int getInput() {
        Scanner input = new Scanner(System.in);
        int opt;
        do {
            opt = input.nextInt();
            if (opt == 1 || opt == 2) {
                return opt;
            }
            System.out.println("Please enter a valid option");
            drawMenu();
        } while (1 == 1);
    }

    public void newGameMenu(int input) {
        Scanner in = new Scanner(System.in);
        boolean valid = false;
        if (input == 1) {
            this.numberOfPlayers = 1;
        } else if (input == 2) {
            this.numberOfPlayers = 2;
        } else {
            System.out.println("Invalid option. Please choose 1 or 2.");
        }
        System.out.println("Enter board size between 1 and 40: ");
        int size = in.nextInt();
        valid = false;
        while (!valid) {
            if (size > 0 && size < 40) {
                setBoardSize(size);
                valid = true;
            } else {
                size = in.nextInt();
                System.out.println("Enter board size between 1 and 40: ");
            }
        }
    }

    public void draw() {
        char[][] board = this.board.getBoard();
        int BOARD_SIZE = this.board.getBOARD_SIZE();
        int i = 0;
        for (char[] col : board) {
            for (char row : col) {
                System.out.print("|" + row + "| ");
            }
            System.out.println(i++);
        }
        for (int j = 0; j < BOARD_SIZE; j++) {
            System.out.print("|" + j + "| ");
        }
        System.out.println();
    }
    public int[] getInputCoordinate() {
        Scanner input = new Scanner(System.in);
        int x, y;
        boolean validX = false;
        boolean validY = false;
        do {
            System.out.print("Please enter an x coordinate (0-" + (board.getBOARD_SIZE() - 1) + ") or -1 to exit. ");
            x = input.nextInt();
            if (x == -1) {
                System.exit(0);
            }
            if (x >= 0 && x < board.getBOARD_SIZE()) {
                coord[0]=x;
                validX=true;
            } else {
                System.out.println("Please enter a valid coordinate.");
            }
            System.out.print("Please enter a y coordinate (0-" + (board.getBOARD_SIZE() - 1) + ") or -1 to exit. ");
            y = input.nextInt();
            if (y == -1) {
                System.exit(0);
            }
            if (y >= 0 && y < board.getBOARD_SIZE()) {
                coord[1]=y;
                validY=true;
            } else {
                System.out.println("Please enter a valid coordinate.");
            }
        } while (!validX||!validY);
        return coord;
    }
}



