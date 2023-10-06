import java.util.Random;

public class CpuPlayer extends Player{
        private Board board;
        public CpuPlayer(){
            this.symbol = '1';
        }
        public CpuPlayer(char symbol, Board board){
            this.symbol=symbol;
            this.board=board;
        }
    @Override
    public boolean pickPlace() {
        Random rand = new Random();
        int upperbound = board.getBOARD_SIZE();
        int randX = rand.nextInt(upperbound);
        int randY = rand.nextInt(upperbound);
        System.out.println(randY+", "+randX);
        if(board.placeStone(randX, randY, this.symbol)){
            return true;
        }
        else{
            this.pickPlace();
        }
        return false;
    }
}
