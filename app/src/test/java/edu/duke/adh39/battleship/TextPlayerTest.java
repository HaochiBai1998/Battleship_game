package edu.duke.adh39.battleship;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextPlayerTest {
    private TextPlayer createTextPlayer(String name,int w, int h, String inputData, ByteArrayOutputStream bytes) {
        BufferedReader input = new BufferedReader(new StringReader(inputData));
        PrintStream output = new PrintStream(bytes, true);
        Board<Character> board = new BattleShipBoard<Character>(w, h);
        V1ShipFactory shipFactory = new V1ShipFactory();
        BoardTextView view=new BoardTextView(board);
        return new TextPlayer(name, board, input, output, shipFactory,view);
    }
    @Test
    public void test_read_placement() throws IOException {

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        TextPlayer player = createTextPlayer("A",10, 20, "B2V\nC8H\na4v\n",bytes);
        String prompt = "Please enter a location for a ship:";
        Placement[] expected = new Placement[3];
        expected[0] = new Placement(new Coordinate(1, 2), 'V');
        expected[1] = new Placement(new Coordinate(2, 8), 'H');
        expected[2] = new Placement(new Coordinate(0, 4), 'V');


        for (int i = 0; i < expected.length; i++) {
            Placement p = player.readPlacement(prompt);
            assertEquals(p, expected[i]); //did we get the right Placement back
            //assertEquals(prompt+"\n", bytes.toString()); //should have printed prompt and newline
            bytes.reset(); //clear out bytes for next time around
        }
    }
    String makeHeader(int width) {
        StringBuilder ans = new StringBuilder("  "); // README shows two spaces at
        String sep=""; //start with nothing to separate, then switch to | to separate
        for (int i = 0; i < width; i++) {
            ans.append(sep);
            ans.append(i);
            sep = "|";
        }
        ans.append("\n");
        return ans.toString();
    }
//    @Test
//    public void test_do_one_placement() throws IOException {
//        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//        TextPlayer player = createTextPlayer("A",3, 5, "\nA0V\n",bytes);
//        String prompt = "Please enter a location for a ship:";
//        player.doOnePlacement();
//        assertEquals(bytes.toString(), "Player A where do you want to place a Destroyer?\n" +
//                makeHeader(3)+
//                "A d| |  A\nB d| |  B\nC d| |  C\nD  | |  D\nE  | |  E\n"
//                +makeHeader(3)+"\n"); //did we get the right Placement back
//        bytes.reset(); //clear out bytes for next time around
//    }
}
