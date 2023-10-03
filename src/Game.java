public class Game {
    public static void main(String[] args) {
        Board board = new Board(8);
        Player player1 = new Player('1');
        Player player2 = new Player('2');
        board.initialize();
            board.draw();
    }
    public static void drawMenu(){

    }
}
