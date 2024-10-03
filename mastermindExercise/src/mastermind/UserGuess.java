package mastermind;
//@author Nino Verstraeten - Groep 8

import java.util.ArrayList;

public class UserGuess {
    private ArrayList<Peg> pegs;
    private Feedback feedback;

    public UserGuess(ArrayList<Peg> pegs) {
        this.pegs = pegs;
        this.feedback = new Feedback();
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public ArrayList<Peg> getPegs() {
        return pegs;
    }

    public void setPegs(ArrayList<Peg> pegs) {
        this.pegs = pegs;
    }
}
