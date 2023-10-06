public class HumanPlayer extends Player{
        public HumanPlayer(){
            this.symbol = '1';
        }
        public HumanPlayer(char symbol){
            this.symbol=symbol;
        }
    public boolean pickPlace() {
        return false;
    }
}
