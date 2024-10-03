package mastermind;
//@author Nino Verstraeten - Groep 8

import java.util.*;

public class SecretCode {
   private final int codeLength;
   private final char[] colorChoices;
   private final ArrayList<Peg> secretCode = new ArrayList<Peg>();

    public SecretCode(int codeLength, char[] colorChoices) {
        this.codeLength = codeLength;
        this.colorChoices = colorChoices;
        generateSecretCode();
    }

    private void generateSecretCode(){
        List<Character> colorList = new ArrayList<>();
        for (char c : colorChoices){
            colorList.add(c);
        }
        Collections.shuffle(colorList);

        for (int i = 0; i < codeLength; i++){
            secretCode.add(i, new Peg(colorList.get(i), i));
        }
    }
    public ArrayList<Peg> getSecretCode() {
        return secretCode;
    }
    public char[] getColorChoices() {
        return colorChoices;
    }
}
