public abstract class Player {
    char symbol;
    private Board board;
    public Player(){
        this.symbol = '1';
    }
    public abstract boolean pickPlace();
}