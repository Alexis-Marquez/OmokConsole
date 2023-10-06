import java.util.Scanner;
public class MenuUi {
    protected Board board;
    private int boardSize;
    private int numberOfPlayers;
    public MenuUi() {

    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public int getBoardSize(){
        return boardSize;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void drawMenu(){
        System.out.println("*************************");
        System.out.println("*********Omok Game*******");
        System.out.println("*************************");
        System.out.println("Please enter one of the following options: ");
        System.out.println("1. Single player game");
        System.out.println("2. Multiplayer game");
        this.drawOptions(this.getInput());
    }
    public int getInput(){
        Scanner input = new Scanner(System.in);
        int opt;
        do {
            opt = input.nextInt();
            if(opt==1||opt==2){
                return opt;
            }
            System.out.println("Please enter a valid option");
            drawMenu();
        }while(1==1);
    }
    public void drawOptions(int input){


        /*public void drawOptions(int input) {
        Scanner in = new Scanner(System.in);
        boolean valid = false;
        if (input == 1) {
            this.numberOfPlayers = 1;
        } else if (input == 2) {
            this.numberOfPlayers = 2;
        }
        else {
            System.out.println("Invalid option. Please choose 1 or 2.");
            drawMenu();
            return;
        }

        System.out.println("Enter board size between 1 and 40: ");
        int opt = in.nextInt();
        while (!valid) {
            if (opt > 0 && opt < 40) {
                this.boardSize = opt;
                valid = true;
            } else {
                opt = in.nextInt();
                System.out.println("Enter board size between 1 and 40: ");
            }
        }


        * */
        Scanner in = new Scanner(System.in);
        boolean valid = false;
        if(input==1){
            this.numberOfPlayers = 1;
            System.out.println("Enter board size between 1 and 40: ");
            int opt = in.nextInt();
            while(!valid) {
                if (opt > 0 && opt < 40) {
                    this.boardSize = opt;
                    valid = true;
                }
                else {
                    opt = in.nextInt();
                    System.out.println("Enter board size between 1 and 40: ");
                }
            }
        }
        if(input==2){
            this.numberOfPlayers = 1;
            System.out.println("Enter board size between 1 and 40: ");
            int opt = in.nextInt();
            while(!valid) {
                if (opt > 0 && opt < 40) {
                    this.boardSize = opt;
                    valid = true;
                }
                else {
                    opt = in.nextInt();
                    System.out.println("Enter board size between 1 and 40: ");
                }
            }
        }
    }
    public void draw(){
        char[][] board = this.board.getBoard();
        int BOARD_SIZE = this.board.getBOARD_SIZE();
        int i = 0;
        for (char[] col:board) {
            for (char row : col) {
                System.out.print("|"+ row+"| ");
            }
            System.out.println(i++);
        }
        for (int j = 0; j < BOARD_SIZE; j++) {
            System.out.print("|"+j+"| ");
        }
        System.out.println();
    }

    // new :)
    // what do you call a fish wearing a bowtie? ... sofishticated ;3
    public void playGame() {
        board.initialize();
        int currentPlayer = 1;

        while (!board.isWin()) {
            draw();
            System.out.println("it's player " + currentPlayer + "'s turn.");
            System.out.print("Enter X coordinate please (0-" + (board.getBOARD_SIZE() - 1) + "): ");
            int x = getInputCoordinate();
            System.out.print("Enter Y coordinate please (0-" + (board.getBOARD_SIZE() - 1) + "): ");
            int y = getInputCoordinate();
            if (board.placeStone(x, y, currentPlayer)) {
                if (currentPlayer == 1) {
                    currentPlayer = 2;
                } else {
                    currentPlayer = 1;
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        draw();
        System.out.println("Player " + currentPlayer + " wins!");
    }

    private int selectSymbol(int playerNumber) {
        Scanner input = new Scanner(System.in);
        int symbol;
        System.out.println("Player " + playerNumber + ", choose your symbol (1 or 2): ");
        while (true) {
            symbol = input.nextInt();
            if (symbol == 1 || symbol == 2) {
                return symbol;
            }
            else{
                System.out.println("Invalid choice. Please select 1 or 2.");
            }
        }
    }



    private int getInputCoordinate() {
        Scanner input = new Scanner(System.in);
        int coordinate;
        do {
            System.out.print("Please enter a coordinate (0-" + (board.getBOARD_SIZE() - 1) + ") or -1 to exit. ");
            coordinate = input.nextInt();

            if (coordinate == -1) {
                System.exit(0);
            }

            if (coordinate >= 0 && coordinate < board.getBOARD_SIZE()) {
                return coordinate;
            } else {
                System.out.println("Please enter a valid coordinate.");
            }
        } while (true);
    }

}






