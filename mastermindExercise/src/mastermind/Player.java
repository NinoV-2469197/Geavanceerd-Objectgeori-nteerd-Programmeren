package mastermind;
//@author Nino Verstraeten - Groep 8

import java.util.ArrayList;

public class Player {
    private final ArrayList<UserGuess> guesses = new ArrayList<>();

    public Player() {

    }

    public UserGuess makeGuess(String guessString) {
        ArrayList<Peg> pegs = new ArrayList<>();
        for (int i = 0; i < guessString.length(); i++) {
            pegs.add(new Peg(guessString.charAt(i), i));
        }
        UserGuess guess = new UserGuess(pegs);
        guesses.add(guess);
        return guess;
    }

    public ArrayList<UserGuess> getGuesses() {
        return guesses;
    }

    public void showCompletedTurns() {
        System.out.println("Turns completed by player " + guesses.toString());
    }
}
