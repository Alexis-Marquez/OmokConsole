public class Board{
    int BOARD_SIZE = 16;
    int[][] board;
    public Board(int boardSize) {
        BOARD_SIZE = boardSize;
    }
    public void initialize(){
        board = new int[BOARD_SIZE][BOARD_SIZE];
        int i = 0;
        for (int[] col:board) {
            for (int row : col) {
                row = 0;
                System.out.print("|"+ row+"| ");
            }
            System.out.println(++i);
        }
        for (int j = 1; j <= BOARD_SIZE; j++) {
            System.out.print("|"+j+"| ");
        }
    }
}