package mastermind;
//@author Nino Verstraeten - Groep 8

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private GameState state;
    private final ArrayList<Player> players;
    private final Board board;
    private final SecretCode secretCode;

    public Game(ArrayList<Player> players, Board board) {
        this.players = players;
        this.board = board;
        char[] colors = {'r', 'g', 'b'};
        this.secretCode = new SecretCode(board.getBoardColumnCount(), colors);
        this.state = GameState.PLAYING;
    }

    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Secret code: " + secretCode.getSecretCode());
        System.out.println("You can choose from the following colors: " + Arrays.toString(secretCode.getColorChoices()));
        int guessCount = 0;
        // Prompt the user for input
        while (state == GameState.PLAYING && guessCount < board.getBoardRowCount()) {
            for (Player player : players) {
                board.printBoard();
                System.out.print("Enter your guess: ");
                String guessInput = scanner.nextLine();
                UserGuess guess = player.makeGuess(guessInput);
                board.updateBoard(board.getBoardRowCount() - guessCount - 1 , guess);
                guessCount++;
                if(board.checkBoardIfHasWon(secretCode)) {
                    state = GameState.WON;
                    System.out.println("You won!");
                    break;
                } else {
                    System.out.println("You have " + (board.getBoardRowCount() - guessCount) + " guesses left.");
                    board.suggestFeedback(guess, secretCode);
                    System.out.println(guess.getFeedback());
                }
            }
        }
        if(state == GameState.PLAYING){
            state = GameState.LOST;
            System.out.println("You lost!");
        }
        scanner.close();
    }
}
