public class Board{
    private int BOARD_SIZE;
    private char[][] board;
    boolean win = false;
    public Board(int boardSize) {
        BOARD_SIZE = boardSize;
    }
    public void initialize(){
        board = new char[BOARD_SIZE][BOARD_SIZE];
        int i = 0;
        for (int col = 0; col<BOARD_SIZE;col++) {
            for (int row = 0; row<BOARD_SIZE;row++) {
                board[col][row] = '0';
                System.out.print("|"+ row+"| ");
            }
            System.out.println(++i);
        }
        for (int j = 1; j <= BOARD_SIZE; j++) {
            System.out.print("|"+j+"| ");
        }
        System.out.println();
    }
    public void draw(){
        int i = 0;
        for (char[] col:board) {
            for (char row : col) {
                System.out.print("|"+ row+"| ");
            }
            System.out.println(++i);
        }
        for (int j = 1; j <= BOARD_SIZE; j++) {
            System.out.print("|"+j+"| ");
        }
        System.out.println();
    }
    public boolean placeStone(int x, int y, Player player){
        if(board[y][x]=='0') {
            board[y][x] = player.symbol;
            win = checkWin(x,y,player);
            return true;
        }
        else{
            return false;
        }
    }
    private boolean checkWin(int x, int y, Player player){
        return search(-1,1,x, y, player)|| //search lower-left diagonal
        search(1,1,x, y, player)||  //search lower-right diagonal
        search(1,-1,x, y, player)|| //search upper-right diagonal
        search(-1,-1,x, y, player)||//search upper-left diagonal
        search(0,1,x,y,player)||    //search up
        search(0,-1,x,y,player)||   //search down
        search(1,0,x,y,player)||    //search right
        search(-1,0,x,y,player);    //search left
    }
    private boolean search(int h, int v, int x, int y, Player player){
        for (int i = x; i < x+5; i+=h) {
            for (int j = y; j < y+5; j+=v) {
                if(x>=BOARD_SIZE||y>=BOARD_SIZE||x<0||y<0){
                    return false;
                }
                    if(board[i][j]!=player.symbol){
                        return false;
                    }
            }
        }
        return true;
    }
}