public class Board{
    private int BOARD_SIZE;
    private char[][] board;
    boolean win = false;
    public Board(int boardSize) {
        BOARD_SIZE = boardSize;
    }
    public void initialize(){
        board = new char[BOARD_SIZE][BOARD_SIZE];
        for (int col = 0; col<BOARD_SIZE;col++) {
            for (int row = 0; row<BOARD_SIZE;row++) {
                board[col][row] = '0';
            }
        }
        this.draw();
    }
    public void draw(){
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
        return searchHorizontal(x,y,player)||searchVertical(x,y,player)||searchDiagonalOne(x,y,player)||searchDiagonalTwo(x,y,player);
    }
    private boolean searchHorizontal(int x, int y, Player player){
        int l, r, count;
        l = y-1;
        r = y+1;
        count = 1;
        while(count<5){
            if(l>=0&&board[x][l]==player.symbol){
                count++;
                l--;
            }
            else if(r< board.length&&board[x][r]==player.symbol){
                count++;
                r++;
            }
            else{
                return false;
            }
        }
        return true;
    }
    private boolean searchVertical(int x, int y, Player player){
        int l, r, count;
        l = x-1;
        r = x+1;
        count = 1;
        while(count<5){
            if(l>=0&&board[l][y]==player.symbol){
                count++;
                l--;
            }
            else if(r< board.length&&board[r][y]==player.symbol){
                count++;
                r++;
            }
            else{
                return false;
            }
        }
        return true;
    }
    private boolean searchDiagonalOne(int x, int y, Player player){
        int l, r, count, u, d;
        l = x-1;
        r = x+1;
        u = y-1;
        d = y+1;
        count = 1;
        while(count<5){
            if(l>=0&&u>=0&&board[l][u]==player.symbol){
                count++;
                l--;
                u--;
            }
            else if(r< board.length&&d<= board.length&&board[r][d]==player.symbol){
                count++;
                r++;
                d++;
            }
            else{
                return false;
            }
        }
        return true;
    }
    private boolean searchDiagonalTwo(int x, int y, Player player){
        int l, r, count, u, d;
        l = x-1;
        r = x+1;
        u = y-1;
        d = y+1;
        count = 1;
        while(count<5){
            if(l>=0&&d< board.length&&board[l][d]==player.symbol){
                count++;
                l--;
                d++;
            }
            else if(r< board.length&&u>=0&&board[r][u]==player.symbol){
                count++;
                r++;
                u--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}