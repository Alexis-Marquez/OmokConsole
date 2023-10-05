public class Game {
    public static void main(String[] args) {
        Board board = new Board(15);
        Player player1 = new HumanPlayer('1', board);
        Player player2 = new CpuPlayer('2', board);

        board.initialize();
    }
    public static void drawMenu(){

    }
}
