package mastermind;
//@author Nino Verstraeten - Groep 8

import java.util.ArrayList;

public class Main {
      // Initialize game elements
    public static void main(String[] args) {
        // Create players
        Player player1 = new Player();
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        // Create board
        Board board = new Board(3,3);
        // Create Game
        Game game = new Game(players, board);
        game.startGame();

    }
}
