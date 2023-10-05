public class Board{
    private int BOARD_SIZE;
    private char[][] board;
    boolean win = false;

    public int getBOARD_SIZE(){
        return BOARD_SIZE;
    }
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
    public boolean placeStone(int y, int x, char symbol){
        if(board[y][x]=='0') {
            board[y][x] = symbol;
            win = checkWin(y,x, symbol);
            return true;
        }
        else{
            return false;
        }
    }
    private boolean checkWin(int y, int x, char symbol){
        return searchHorizontal(y,x,symbol)||searchVertical(y,x,symbol)||searchDiagonalOne(y,x,symbol)||searchDiagonalTwo(y,x,symbol);
    }
    private boolean searchHorizontal(int y, int x, char symbol){
        int l, r, count;
        l = x-1;
        r = x+1;
        count = 1;
        while(count<5){
            if(l>=0&&board[y][l]==symbol){
                count++;
                l--;
            }
            else if(r< board.length&&board[y][r]==symbol){
                count++;
                r++;
            }
            else{
                return false;
            }
        }
        System.out.println("Search horizontal");
        return true;
    }
    private boolean searchVertical(int y, int x, char symbol){
        int u, d, count;
        u = y-1;
        d = y+1;
        count = 1;
        while(count<5){
            if(u>=0&&board[u][x]==symbol){
                count++;
                u--;
            }
            else if(d< board.length&&board[d][x]==symbol){
                count++;
                d++;
            }
            else{
                return false;
            }
        }
        System.out.println("Search vertical");
        return true;
    }
    private boolean searchDiagonalOne(int y, int x, char symbol){
        int l, r, count, u, d;
        l = x-1;
        r = x+1;
        u = y-1;
        d = y+1;
        count = 1;
        while(count<5){
            if(l>=0&&u>=0 && board[u][l]==symbol){
                count++;
                l--;
                u--;
            }
            else if(r< board.length && d< board.length&&board[d][r]==symbol){
                count++;
                r++;
                d++;
            }
            else{
                return false;
            }
        }
        System.out.println("diagonal one");
        return true;
    }
    private boolean searchDiagonalTwo(int y, int x, char symbol){
        int l, r, count, u, d;
        l = x-1;
        r = x+1;
        u = y-1;
        d = y+1;
        count = 1;
        while(count<5){
            if(l>=0&&d< board.length&&board[d][l]==symbol){
                count++;
                l--;
                d++;
            }
            else if(r< board.length&&u>=0&&board[u][r]==symbol){
                count++;
                r++;
                u--;
            }
            else{
                return false;
            }
        }
        System.out.println("diagonal two");
        return true;
    }
}