public class Game {
    public static void main(String[] args) {
        System.out.println();
        MenuUi menu = new MenuUi();
        menu.drawMenu();
        Board board = new Board(menu.getBoardSize());
        Player player1 = new HumanPlayer('1', board);
        Player player2 = new CpuPlayer('2', board);
        board.initialize();
        menu.setBoard(board);
        menu.draw();
        while(!board.win){

        }
    }

}

//  TODO:
// Files:
// * 1. MenuUi:
// *    -Multiplayer menu
//      -Play Menu (player selects spot)
//      -Quit option
//      -Player selects symbol
//   2. CpuPlayer:
//      -Smart strategy
//      *
