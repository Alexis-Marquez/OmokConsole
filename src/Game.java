public class Game {
    public static void main(String[] args) {
        System.out.println();
        MenuUi menu = new MenuUi();
        menu.drawMenu();
        Board board = new Board(menu.getBoardSize());
        System.out.println(menu.getBoardSize());
        board.initialize();
        menu.setBoard(board);
        menu.draw();
        int numberPlayers = menu.getNumberOfPlayers();
        Player player1;
        Player player2;

        if(numberPlayers==1){
            player1 = new HumanPlayer('1');
            player2 = new CpuPlayer('2', board);
        }
        else {
            player1 = new HumanPlayer('1');
            player2 = new HumanPlayer('2');
        }
        int counter = 0;
        while(counter<=board.getBOARD_SIZE()*board.getBOARD_SIZE()) {
            play(player1, board, menu);
            counter++;
            if(board.isWin()){
                System.out.println("Player 1 has won!");
                break;
            }
            if(counter>=board.getBOARD_SIZE()*board.getBOARD_SIZE()){
                System.out.println("Tied game");
                break;
            }
            menu.draw();
            play(player2, board, menu);
            counter++;
            if(board.isWin()){
                System.out.println("Player 2 has won!");
                break;
            }
            if(counter>=board.getBOARD_SIZE()*board.getBOARD_SIZE()){
                System.out.println("Tied game");
                break;
            }
            menu.draw();
        }

    }
    public static void play(Player player, Board board, MenuUi menu){
        if(player.pickPlace()){
            return;
        }
            int[] play = menu.getInputCoordinate();
            int x = play[0];
            int y = play[1];
            System.out.println(x+", "+y);
            if(!board.placeStone(x,y, player.symbol)){
                System.out.println("Try again");
                play(player, board, menu);
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
