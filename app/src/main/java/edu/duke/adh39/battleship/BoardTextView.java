
package edu.duke.adh39.battleship;

/**
 * This class handles textual display of
 * a Board (i.e., converting it to a string to show
 * to the user).
 * It supports two ways to display the Board:
 * one for the player's own board, and one for the 
 * enemy's board.
 */
public class BoardTextView {
    /**
     * The Board to display
     */
    private final Board<Character> toDisplay;
    /**
     * Constructs a BoardView, given the board it will display.
     * @param toDisplay is the Board to display
     */
    public BoardTextView(Board<Character> toDisplay) {
        this.toDisplay = toDisplay;
        if (toDisplay.getWidth() > 10 || toDisplay.getHeight() > 26) {
            throw new IllegalArgumentException(
                    "Board must be no larger than 10x26, but is " + toDisplay.getWidth() + "x" + toDisplay.getHeight());
        }
    }
    /**
     * displayBoard information and append to a string
     * @return a String to print
     */
    public String displayMyOwnBoard() {
        StringBuilder ans=new StringBuilder();
        ans.append(makeHeader());
        int width=this.toDisplay.getWidth();
        int height=this.toDisplay.getHeight();
        for(int i=0;i<height;++i){
            ans.append((char)('A'+i)+" ");
            String sep="";
            for(int j=0;j<width;++j) {
                ans.append(sep);
                Character c=toDisplay.whatIsAt(new Coordinate(i,j));
                ans.append(c==null?' ':c);
                sep = "|";
            }
            ans.append(" "+(char)('A'+i));
            ans.append("\n");
        }
        ans.append(makeHeader());
        return ans.toString();
    }

    String makeHeader() {
        StringBuilder ans = new StringBuilder("  "); // README shows two spaces at
        String sep=""; //start with nothing to separate, then switch to | to separate
        for (int i = 0; i < toDisplay.getWidth(); i++) {
            ans.append(sep);
            ans.append(i);
            sep = "|";
        }
        ans.append("\n");
        return ans.toString();
    }
}