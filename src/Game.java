public class Game {
    public static void main(String[] args) {
        Board board = new Board(8);
        Player player1 = new HumanPlayer('/', board);
        Player player2 = new CpuPlayer('*', board);
        board.initialize();
        for (int i = 0; i < 40; i++) {
            player2.pickPlace();
            System.out.println(i);
            if(board.win){
                System.out.println("Congrats!");
                break;
            }
        }
        System.out.println();
        board.draw();

    }
    public static void drawMenu(){

    }
}
