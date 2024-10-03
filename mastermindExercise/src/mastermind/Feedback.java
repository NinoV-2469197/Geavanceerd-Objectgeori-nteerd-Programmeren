package mastermind;
//@author Nino Verstraeten - Groep 8

public class Feedback {
    private int correctPositions;

    public Feedback() {
        this.correctPositions = 0;
    }

    public int getCorrectPositions() {
        return correctPositions;
    }

    public void setCorrectPositions(int correctPositions) {
        this.correctPositions = correctPositions;
    }

    @Override
    public String toString() {

        return "You have placed " + correctPositions  + " peg" + (correctPositions == 1 ? "" : "s") + " in the correct position";
    }
}
