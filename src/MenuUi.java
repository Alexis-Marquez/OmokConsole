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
}
