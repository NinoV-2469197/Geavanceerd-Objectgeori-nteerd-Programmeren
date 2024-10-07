package mastermind;
//@author Nino Verstraeten - Groep 8

import java.util.Arrays;
import java.util.List;

public class Board {
    private final int boardColumnCount;
    private final int boardRowCount;
    private final char[][] board;

    public Board(int boardColumnCount, int boardRowCount) {
        this.boardColumnCount = boardColumnCount;
        this.boardRowCount = boardRowCount;
        this.board = new char[boardColumnCount][boardRowCount];
        initBoard();
    }
    private void initBoard() {
        for (int i = 0; i < boardColumnCount; i++) {
            for (int j = 0; j < boardRowCount; j++) {
                board[i][j] = '-';
            }
        }
    }
    public void printBoard() {
        for (int i = 0; i < boardRowCount; i++) {
            for (int j = 0; j < boardColumnCount; j++) {
                System.out.print("[");
                System.out.print(board[i][j]);
                System.out.print("]");
            }
            System.out.println();
        }
    }
    public void updateBoard(int row, UserGuess guess) {
        for (int i = 0; i < boardColumnCount; i++) {
            board[row][i] = guess.getPegs().get(i).getColor();
        }
    }

    public void suggestFeedback(UserGuess guess, SecretCode secretCode) {
        int correctPositions = checkCorrectPositions(guess, secretCode);

        guess.getFeedback().setCorrectPositions(correctPositions);

    }

    public int checkCorrectPositions(UserGuess guess, SecretCode secretCode) {
        int correctPegs = 0;
        for (int i = 0; i < boardColumnCount; i++) {
            if (guess.getPegs().get(i).getColor() == secretCode.getSecretCode().get(i).getColor()) {
                correctPegs++;
            }
        }
        return correctPegs;
    }

    public boolean checkBoardIfHasWon(SecretCode secretCode) {
        List<Peg> secretCodePegs = secretCode.getSecretCode();

        for (int i = 0; i < boardRowCount; i++) {
           if(Arrays.toString(this.board[i]).equals(secretCodePegs.toString())){
              return true;
           }
        }
        return false;
    }
    public int getBoardColumnCount() {
        return boardColumnCount;
    }

    public int getBoardRowCount() {
        return boardRowCount;
    }
}
