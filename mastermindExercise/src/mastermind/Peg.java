package mastermind;
//@author Nino Verstraeten - Groep 8

public class Peg {
    private final char color;
    private int index;

    public Peg(char color, int index) {
        this.color = color;
        this.index = index;

    }
    public char getColor() {
        return color;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return Character.toString(color);
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Peg other) {
            return this.color == other.color;
        }
        return false;
    }
}
