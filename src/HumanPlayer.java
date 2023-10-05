public class HumanPlayer extends Player{
        char symbol;
        private Board board;
        public HumanPlayer(){
            this.symbol = '1';
        }
        public HumanPlayer(char symbol, Board board){
            this.symbol=symbol;
            this.board=board;
        }
    public boolean pickPlace() {
        return false;
    }
}
