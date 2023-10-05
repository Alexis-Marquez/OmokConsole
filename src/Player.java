public abstract class Player {
    char symbol;
    private Board board;
    public Player(){
        this.symbol = '1';
    }
    public Player(char symbol, Board board){
        this.symbol=symbol;
        this.board=board;
    }
    public abstract boolean pickPlace();
}